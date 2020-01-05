package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class MoveInchesCommand extends CommandBase {
    private Drivetrain drivetrain;
    private double lPower, rPower;
    private int lPulses, rPulses;

    public MoveInchesCommand(Drivetrain drivetrain, double lInches, double rInches, double lPower, double rPower) {
        this.drivetrain = drivetrain;
        this.lPulses = drivetrain.inchesToPulses(lInches);
        this.rPulses = drivetrain.inchesToPulses(rInches);

        this.lPower = Math.copySign(lPower, lPulses);
        this.rPower = Math.copySign(rPower, rPulses);

        addRequirements(drivetrain);
    }

    public MoveInchesCommand(Drivetrain drivetrain, double inches, double power) {
        this(drivetrain, inches, inches, power, power);
    }

    @Override
    public void initialize() {
        drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        drivetrain.tankDrive(lPower, rPower);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }

    @Override
    public boolean isFinished() {
        return drivetrain.getLEncoderValue() >= lPulses 
            || drivetrain.getREncoderValue() >= rPulses;
    }
}