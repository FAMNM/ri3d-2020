/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
  private final DriveTrain driveTrain;
  private final Hanger hanger;
  private final Intake intake;
  private final Shooter shooter;
  private final Conveyor conveyor;

  private final ArcadeDrive arcadeDrive;

  public static XboxController driverJoystick;
  public static XboxController operatorJoystick;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driveTrain = new DriveTrain();
    hanger = new Hanger();
    intake = new Intake();
    shooter = new Shooter();
    conveyor = new Conveyor();

    arcadeDrive = new ArcadeDrive(driveTrain);
    arcadeDrive.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(arcadeDrive);

    driverJoystick = new XboxController(DRIVER_JOYSTICK);
    operatorJoystick = new XboxController(OPERATOR_JOYSTICK);
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
    JoystickButton grabBarButton = new JoystickButton(driverJoystick, 
    XboxController.Button.kA.value);
    grabBarButton.whileHeld(new GrabBarHang(hanger, .5));

    JoystickButton releaseBarButton = new JoystickButton(driverJoystick, 
    XboxController.Button.kB.value);
    releaseBarButton.whileHeld(new GrabBarHang(hanger, -.5));

    JoystickButton winchButton = new JoystickButton(driverJoystick, 
    XboxController.Button.kX.value);
    winchButton.whileHeld(new Winch(hanger, .5));

    JoystickButton sendWinchButton = new JoystickButton(driverJoystick, 
    XboxController.Button.kY.value);
    sendWinchButton.whileHeld(new Winch(hanger, -.5));

    JoystickButton shootButton = new JoystickButton(operatorJoystick, 
    XboxController.Button.kBumperRight.value);
    shootButton.whileHeld(new Shoot(shooter, .5, -1));

    JoystickButton sendBackButton = new JoystickButton(operatorJoystick, 
    XboxController.Button.kBumperLeft.value);
    sendBackButton.whileHeld(new Shoot(shooter, -.5, -1));

    JoystickButton conveyorButton = new JoystickButton(operatorJoystick, 
    XboxController.Button.kStickRight.value);
    conveyorButton.whileHeld(new ConveyorBelt(conveyor, .5, -1));

    JoystickButton conveyorDownButton = new JoystickButton(operatorJoystick, 
    XboxController.Button.kStickLeft.value);
    conveyorDownButton.whileHeld(new ConveyorBelt(conveyor, .5, -1));

    JoystickButton conveyorIntakeButton = new JoystickButton(operatorJoystick, 
    XboxController.Button.kStart.value);
    conveyorIntakeButton.whileHeld(new RunConveyorAndIntake(conveyor, intake, .5, .5, -1));

    JoystickButton conveyorShooterButton = new JoystickButton(operatorJoystick, 
    XboxController.Button.kBack.value);
    conveyorShooterButton.whileHeld(new RunConveyorAndShooter(conveyor, shooter, .5, .5, -1));

    JoystickButton intakeButton = new JoystickButton(operatorJoystick, 
    XboxController.Button.kA.value);
    intakeButton.whileHeld(new GrabPowerCell(intake, .5));

    JoystickButton throwOutButton = new JoystickButton(operatorJoystick, 
    XboxController.Button.kB.value);
    throwOutButton.whileHeld(new GrabPowerCell(intake, -.5));
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
