package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class MoveTimeCommand extends CommandBase {
    private Drivetrain drivetrain;
    private double lPower, rPower;
    private double lTime, rTime;
    private Timer timer;

    public MoveTimeCommand(Drivetrain drivetrain, double lTime, double rTime, double lPower, double rPower) {
        this.drivetrain = drivetrain;
        this.lTime = lTime;
        this.rTime = rTime;

        this.lPower = lPower;
        this.rPower = rPower;

        timer = new Timer();

        addRequirements(drivetrain);
    }

    public MoveTimeCommand(Drivetrain drivetrain, double time, double power) {
        this(drivetrain, time, time, power, power);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        drivetrain.tankDrive(
            timer.get() < lTime ? lPower : 0,
            timer.get() < rTime ? rPower : 0);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
        timer.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= lTime && timer.get() >= rTime;
    }
}