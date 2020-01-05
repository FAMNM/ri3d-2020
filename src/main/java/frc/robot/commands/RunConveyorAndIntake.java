/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Conveyor;

public class RunConveyorAndIntake extends CommandBase {
  Conveyor conveyor;
  Intake intake;
  double powerConveyor;
  double powerIntake;
  double time;
  /**
   * Creates a new RunConveyorAndIntake.
   */
  public RunConveyorAndIntake(Conveyor c, Intake i, double pc, double pi, double t) {
    conveyor = c;
    intake = i;
    powerConveyor = pc;
    powerIntake = pi;
    time = t;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(conveyor);
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (time != - 1) {
      withTimeout(time);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    conveyor.conveyorMove(powerConveyor);
    intake.grabPowerCells(powerIntake);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    conveyor.conveyorMove(0);
    intake.grabPowerCells(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
