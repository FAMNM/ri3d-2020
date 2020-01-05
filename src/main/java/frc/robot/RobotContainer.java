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
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Auton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

import static frc.robot.Constants.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain = new DriveTrain();
  private final Hanger hanger = new Hanger();
  private final Intake intake = new Intake();
  private final Rotator rotator = new Rotator();
  private final Shooter shooter = new Shooter();

  private final ArcadeDrive arcadeDrive = new ArcadeDrive(driveTrain);
  private final GrabBarHang grabBarHang = new GrabBarHang(hanger);
  private final GrabPowerCell grabPowerCell = new GrabPowerCell(intake);
  private final RotateWheel rotateWheel = new RotateWheel(rotator);
  private final Shoot shoot = new Shoot(shooter, -1);
  private final Winch winch = new Winch(hanger);

  public static XboxController driverController = new XboxController(DRIVER_CONTROLLER);
  public static XboxController operatorController = new XboxController(OPERATOR_CONTROLLER);



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton grabBarButton = new JoystickButton(driverController, 0);
    grabBarButton.whileHeld(grabBarHang);

    JoystickButton winchButton = new JoystickButton(operatorController, 1);
    winchButton.whileHeld(winch);

    JoystickButton shootButton = new JoystickButton(operatorController, 2);
    shootButton.whileHeld(shoot);

    JoystickButton rotateButton = new JoystickButton(operatorController, 3);
    rotateButton.whileHeld(rotateWheel);

    JoystickButton intakeButton = new JoystickButton(operatorController, 4);
    intakeButton.whileHeld(grabPowerCell);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new Auton(driveTrain, shooter);
  }
}
