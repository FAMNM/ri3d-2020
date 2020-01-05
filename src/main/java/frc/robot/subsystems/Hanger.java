package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Hanger extends SubsystemBase
{
    private WPI_VictorSPX _armMotor;
    private WPI_VictorSPX _winchMotor;
    public Hanger() {
        _armMotor = new WPI_VictorSPX(kArm);
        _winchMotor = new WPI_VictorSPX(kWinch);
    }

    public void setArmPower(double power) {
        _armMotor.set(power);
    }

    public void setWinchPower(double power) {
        _winchMotor.set(power);
    }
}