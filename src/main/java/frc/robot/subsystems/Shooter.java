package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.RobotMap.*;

import java.util.Map;

public class Shooter extends SubsystemBase{ 
    private WPI_VictorSPX _motor;
    private double shootPower = 0.5;

    private ShuffleboardTab shootPowerTab;
    private NetworkTableEntry shootPowerEntry;

    public Shooter() {
        _motor = new WPI_VictorSPX(kFlyWheel);

        shootPowerTab = Shuffleboard.getTab("Shooter");
        shootPowerEntry = shootPowerTab
                         .add("Speed", 0)
                         .withWidget(BuiltInWidgets.kNumberSlider)
                         .withProperties(Map.of("min", -1, "max", 1))
                         .getEntry();
    }

    public void shoot() {

        _motor.set(shootPower);

    }

    public void setShootPower(double shootPower) {
        this.shootPower = shootPower;
    }

    public void stop() {
        _motor.set(0);
    }

    @Override
    public void periodic() {
        shootPower = shootPowerEntry.getDouble(0.5);
    }
}