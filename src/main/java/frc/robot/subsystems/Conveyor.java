package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.RobotMap.*;

public class Conveyor extends SubsystemBase{
    private WPI_VictorSPX _motor;
    private final double EAT_POWER = 0.5, UNEAT_POWER = -0.5;
    public Conveyor() {
        _motor = new WPI_VictorSPX(kConveyor);
    }

    public void eat() {
        _motor.set(EAT_POWER);
    }

    public void uneat() {
        _motor.set(UNEAT_POWER);
    }
}