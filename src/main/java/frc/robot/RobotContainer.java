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
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.ButtonMap.*;

public class RobotContainer {
  private final Drivetrain drivetrain;
  private final Shooter shooter;
  private final Intake intake;
  private final Conveyor conveyor;
  private final XboxController driverController, manipController;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    drivetrain = new Drivetrain();
    shooter = new Shooter();
    intake = new Intake();
    conveyor = new Conveyor();
    driverController = new XboxController(1);
    manipController = new XboxController(2);
    // Configure the button bindings
    configureButtonBindings();

    drivetrain.setDefaultCommand(new ArcadeDriveCommand(drivetrain, driverController));
    shooter.setDefaultCommand(new ShootCommand(shooter, manipController));
    
  }

  private void configureButtonBindings(){
    mpbtn("intake_in").whileHeld(rc(intake::eat));
    mpbtn("intake_out").whileHeld(rc(intake::uneat));
    mpbtn("conveyor_in").whileHeld(rc(conveyor::eat));
    mpbtn("conveyor_out").whileHeld(rc(conveyor::uneat));

    mpbtn("intake_and_conveyor_in").whileHeld(
      new ParallelCommandGroup(
        rc(intake::eat), 
        rc(conveyor::eat)
      ));
    
    mpbtn("intake_and_conveyor_out").whileHeld(
      new ParallelCommandGroup(
        rc(intake::uneat),
        rc(conveyor::uneat)
      ));
    
    
  }

  private JoystickButton drbtn(String name) {
    return getButton(driverController, name);
  }

  private JoystickButton mpbtn(String name) {
    return getButton(manipController, name);
  }

  private RunCommand rc(Runnable command) {
    return new RunCommand(command);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new AutoCommand(drivetrain, shooter);
  }
}
