package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Intake extends SubsystemBase
{
    private WPI_VictorSPX _intakeMotor;
    private SpeedControllerGroup intake;
    public Intake() {
        _intakeMotor = new WPI_VictorSPX(kIntake);
        intake = new SpeedControllerGroup(_intakeMotor);
    }

    public void setPower(double power) {
        intake.set(power);
    }
}