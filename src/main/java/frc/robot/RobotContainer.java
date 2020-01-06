/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private final Intake m_intake = new Intake();
  private final Conveyor m_conveyor = new Conveyor();
  private final Shooter m_shooter = new Shooter();
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final ClimbingArm m_climbArm = new ClimbingArm();
  private final Winch m_winch = new Winch();

  // Controllers
  private final XboxController m_driver = new XboxController(0);
  private final XboxController m_manip = new XboxController(1);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_intake.setDefaultCommand(new RunCommand(() -> m_intake.runIntake(
      m_manip.getTriggerAxis(GenericHID.Hand.kLeft),
      m_manip.getTriggerAxis(GenericHID.Hand.kRight)),
      m_intake
    ));
    m_driveTrain.setDefaultCommand(new RunCommand(() -> m_driveTrain.arcadeDrive(
      m_driver.getY(GenericHID.Hand.kLeft),
      m_driver.getX(GenericHID.Hand.kLeft)),
      m_driveTrain
    ));
    m_climbArm.setDefaultCommand(new RunCommand(() -> m_climbArm.climb(
      m_manip.getY(GenericHID.Hand.kLeft)),
      m_climbArm
    ));
    m_winch.setDefaultCommand(new RunCommand(() -> m_winch.runWinch(
      m_manip.getY(GenericHID.Hand.kRight)),
      m_winch
    ));
  }


  private void configureButtonBindings() {
    new JoystickButton(m_driver, XboxController.Button.kY.value)
      .whenPressed(new InstantCommand(m_driveTrain::changeDirection, m_driveTrain));
    new JoystickButton(m_manip, XboxController.Button.kA.value)
      .whenHeld(new ShootCommand(m_shooter));
    new DPadUp().whileActiveContinuous(new ConveyorUp(m_conveyor));
    new DPadDown().whileActiveContinuous(new ConveyorDown(m_conveyor));
  }

  public Command getAutonomousCommand() {
    return null;
  }

  private class DPadUp extends Trigger {
    @Override
    public boolean get() {
      int pov = m_manip.getPOV();
      return pov == 315 || pov <= 45;
    }
  }

  private class DPadDown extends Trigger {
    @Override
    public boolean get() {
      int pov = m_manip.getPOV();
      return pov >= 135 && pov <= 225;
    }
  }
}
