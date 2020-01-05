package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase{
    private WPI_VictorSPX _flyWheelMotor;
    private SpeedControllerGroup flyWheel;

    public Shooter() {
        _flyWheelMotor = new WPI_VictorSPX(kFlyWheel);
        flyWheel = new SpeedControllerGroup(_flyWheelMotor);
    }

    public void activate() {
        flyWheel.set(1);
    }

    public void stop() {
        flyWheel.set(0);
    }
} 