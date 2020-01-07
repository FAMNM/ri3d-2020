/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
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
  // Subsystems:
  private final Intake m_intake = new Intake();
  private final Conveyor m_conveyor = new Conveyor();
  private final Shooter m_shooter = new Shooter();
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final ClimbingArm m_climbArm = new ClimbingArm();
  private final Winch m_winch = new Winch();

  // Controllers:
  private final XboxController m_driver = new XboxController(0);
  private final XboxController m_manip = new XboxController(1);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings:
    configureButtonBindings();

    // Intake default command (Run intake):
    m_intake.setDefaultCommand(new RunCommand(() -> m_intake.intakeStop(), m_intake));

    // Drivetrain default command (Arcade drive):
    m_driveTrain.setDefaultCommand(new RunCommand(() -> m_driveTrain.arcadeDrive(
      m_driver.getY(GenericHID.Hand.kLeft) / 1.3,
      m_driver.getX(GenericHID.Hand.kRight) / 1.4),
      m_driveTrain
    ));

    // Climbing arm default command (Run arm):
    m_climbArm.setDefaultCommand(new RunCommand(() -> m_climbArm.climb(
      -m_manip.getY(GenericHID.Hand.kLeft) * Constants.kArmSpeed),
      m_climbArm
    ));

    // Winch default command (Run winch):
    m_winch.setDefaultCommand(new RunCommand(() -> m_winch.runWinch(
      -m_manip.getY(GenericHID.Hand.kRight) * Constants.kWinchSpeed),
      m_winch
    ));

    // Conveyor default command (Stop conveyor):
    m_conveyor.setDefaultCommand(new RunCommand(() -> m_conveyor.stopConveyor(), m_conveyor));

    // Shooter default command (Stop shooter):
    m_shooter.setDefaultCommand(new RunCommand(() -> m_shooter.stop(), m_shooter));
  }

  /**
   * Configures the bindings for the controller buttons
   */
  private void configureButtonBindings() {
    // Change forward direction (Drive Y):
    new JoystickButton(m_driver, XboxController.Button.kY.value)
      .whenPressed(new InstantCommand(m_driveTrain::changeDirection, m_driveTrain));
    // Activate shooter (Manip A):
    new JoystickButton(m_manip, XboxController.Button.kA.value)
      .whileHeld(new RunCommand(() -> m_shooter.shoot(), m_shooter));
    // Move conveyor up (Manip RB):
    new JoystickButton(m_manip, XboxController.Button.kBumperRight.value)
      .whileActiveContinuous(new RunCommand(() -> m_conveyor.raiseConveyor(), m_conveyor));
    // Move conveyor down (Manip RT):
    new ManipRightTrigger()
      .whileActiveContinuous(new RunCommand(() -> m_conveyor.lowerConveyor(), m_conveyor));
    // Run intake inward (Manip LB):
    new JoystickButton(m_manip, XboxController.Button.kBumperLeft.value)
      .whileHeld(new RunCommand(() -> m_intake.intakeIn(), m_intake));
    // Run intake outward (Manip LT):
    new ManipLeftTrigger()
      .whileActiveContinuous(new RunCommand(() -> m_intake.intakeOut(), m_intake));
    }

  /**
   * Sets the command to run during autonomous
   * @return The autonomous command
   */
  public Command getAutonomousCommand() {
    return null;
  }

  /**
   * Trigger to return true when up is pressed on manip dpad
   */
  // private class ManipDPadUp extends Trigger {
  //   @Override
  //   public boolean get() {
  //     int pov = m_manip.getPOV();
  //     return pov == 315 || (pov <= 45 && pov >= 0);
  //   }
  // }

  // /**
  //  * Trigger to return true when down is pressed on manip dpad
  //  */
  // private class ManipDPadDown extends Trigger {
  //   @Override
  //   public boolean get() {
  //     int pov = m_manip.getPOV();
  //     return pov >= 135 && pov <= 225;
  //   }
  // }

  /**
   * Trigger to return true when the right trigger of the manip controller
   * is pressed in 3/4 of the way or more 
   */
  private class ManipRightTrigger extends Trigger {
    @Override
    public boolean get() {
      return m_manip.getTriggerAxis(GenericHID.Hand.kRight) >= 0.75;
    }
  }

  /**
   * Trigger to return true when the left trigger of the manip controller
   * is pressed in 3/4 of the way or more 
   */
  private class ManipLeftTrigger extends Trigger {
    @Override
    public boolean get() {
      return m_manip.getTriggerAxis(GenericHID.Hand.kLeft) >= 0.75;
    }
  }
}
