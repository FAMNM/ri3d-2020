/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ConveyorDown;
import frc.robot.commands.ConveyorUp;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
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
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new DPadUp().whileActiveContinuous(new ConveyorUp(m_conveyor));
    new DPadDown().whileActiveContinuous(new ConveyorDown(m_conveyor));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
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
