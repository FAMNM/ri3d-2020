package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Rotator extends SubsystemBase{
    private WPI_VictorSPX _rotatorMotor;
    private Encoder _rotatorEncoder;

    // TODO: Determine the real value.
    private final double ticksPerRotation = 1.0;

    public Rotator() {
        _rotatorMotor = new WPI_VictorSPX(kRotator);
        _rotatorEncoder = new Encoder(kRotatorEncoderA, kRotatorEncoderB);
        _rotatorEncoder.reset();
    }

    private double rotationsToTicks(double rotation) {
        return rotation * ticksPerRotation;
    }

    public void rotateNCycles(double n) {
        int currentEncoderValue = _rotatorEncoder.get();
        int newEncoderValue = currentEncoderValue + (int)rotationsToTicks(n);
        _rotatorMotor.set(ControlMode.Position, newEncoderValue);
    }
}