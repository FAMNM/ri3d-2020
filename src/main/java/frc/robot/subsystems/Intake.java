package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.RobotMap.*;

public class Intake extends SubsystemBase
{
    private WPI_VictorSPX _intakeMotor;
    private SpeedControllerGroup intake;
    private double eatPower = 0.5, uneatPower = -0.5;

    public Intake() {
        _intakeMotor = new WPI_VictorSPX(kIntake);
        intake = new SpeedControllerGroup(_intakeMotor);
    }

    public void eat() {
        intake.set(eatPower);
    }

    public void uneat() {
        intake.set(uneatPower);
    }

    @Override
    public void periodic() {
        
    }
}