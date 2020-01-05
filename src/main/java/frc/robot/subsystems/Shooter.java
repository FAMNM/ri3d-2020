package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase{
    private WPI_VictorSPX _motor;
    private Encoder _encoder;

    private PIDController _pid;

    private double kP = 0.01, kI = 0, kD = 0;

    public Shooter() {
        _motor = new WPI_VictorSPX(kFlyWheel);
        _encoder = new Encoder(kFlyWheelEncoderA, kFlyWheelEncoderB);
        _pid = new PIDController(kP, kI, kD);
    }

    public void activate(double speed) {

        _pid.setSetpoint(speed);

        _motor.set(ControlMode.Velocity, speed);

        double realVelocity = _encoder.getRate();

        double pidOut = _pid.calculate(realVelocity);

        _motor.set(pidOut);

    }

    public void stop() {
        _motor.set(ControlMode.Velocity, 0);
    }

    public void setPidConstants(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }
}