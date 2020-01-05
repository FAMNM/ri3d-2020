/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;

public class RunConveyorAndShooter extends CommandBase {
  Conveyor conveyor;
  Shooter shooter;
  double powerConveyor;
  double powerShooter;
  double time;
  /**
   * Creates a new RunConveyorAndShooter.
   */
  public RunConveyorAndShooter(Conveyor c, Shooter s, double pc, double ps, double t) {
    conveyor = c;
    shooter = s;
    powerConveyor = pc;
    powerShooter = ps;
    time = t;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(conveyor);
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (time != -1) {
      withTimeout(time);
    }
    shooter.shoot(.5);
    Timer.delay(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    conveyor.conveyorMove(.5);
    shooter.shoot(.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    conveyor.conveyorMove(0);
    shooter.shoot(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
