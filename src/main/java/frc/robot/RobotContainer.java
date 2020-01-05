/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //Subsystems:
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Shooter m_shooter = new Shooter();
  private final Intake m_intake = new Intake();

  //Controllers:
  private final XboxController driverController = new XboxController(1);
  private final XboxController manipController = new XboxController(2);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //Drivetrain defaults to running tank drive with the two driver sticks
    m_drivetrain.setDefaultCommand(new RunCommand(() -> m_drivetrain.tankDrive(
      driverController.getY(GenericHID.Hand.kLeft),
      driverController.getY(GenericHID.Hand.kRight)),
      m_drivetrain
    ));

    //Intake defaults to running the intake with the two manip triggers
    m_intake.setDefaultCommand(new RunCommand(() -> m_intake.runIntake(
      manipController.getTriggerAxis(GenericHID.Hand.kLeft),
      manipController.getTriggerAxis(GenericHID.Hand.kRight)),
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
    //Driver Y button reverses forward direction of robot
    new JoystickButton(driverController, XboxController.Button.kY.value)
      .whenPressed(new InstantCommand(m_drivetrain::reverseDirection, m_drivetrain));
    //Manip A button activates shooter
    new JoystickButton(manipController, XboxController.Button.kA.value)
      .whileHeld(new InstantCommand(m_shooter::activateFlywheel, m_shooter))
      .whenReleased(new InstantCommand(m_shooter::stopFlywheel, m_shooter));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //Currently, there is no autonomous command
    return null;
  }
}
