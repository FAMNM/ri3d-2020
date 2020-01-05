package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Rotator extends SubsystemBase{
    private WPI_VictorSPX _rotatorMotor;

    public Rotator() {
        _rotatorMotor = new WPI_VictorSPX(kRotator);
    }

    public void setPower (double power) {
        _rotatorMotor.set(power);
    }
}