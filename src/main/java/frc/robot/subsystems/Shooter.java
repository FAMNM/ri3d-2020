package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.RobotMap.*;

public class Shooter extends SubsystemBase{ 
    private WPI_VictorSPX _motor;

    public Shooter() {
        _motor = new WPI_VictorSPX(kFlyWheel);
    }

    public void shoot(double speed) {

        _motor.set(speed);

    }

    public void stop() {
        _motor.set(0);
    }
}