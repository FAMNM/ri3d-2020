package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.Map;

public class Shooter extends SubsystemBase{ 
    private WPI_VictorSPX m_flywheel = new WPI_VictorSPX(Constants.kFlyWheel);

    private ShuffleboardTab flywheelSpeedTab;
    private NetworkTableEntry flywheelSpeedEntry;

    public double kFlywheelSpeed = 0.5;

    public Shooter() {
        flywheelSpeedTab = Shuffleboard.getTab("Shooter");
        flywheelSpeedEntry = flywheelSpeedTab.add("Speed", 0).withWidget(BuiltInWidgets.kNumberSlider)
                .withProperties(Map.of("min", -1, "max", 1)).getEntry();
    }

    public void shoot() {
        m_flywheel.set(kFlywheelSpeed);
    }

    public void setflywheelSpeed(double flywheelSpeed) {
        this.kFlywheelSpeed = flywheelSpeed;
    }

    public void stop() {
        m_flywheel.set(0);
    }

    @Override
    public void periodic() {
        kFlywheelSpeed = flywheelSpeedEntry.getDouble(0.5);
    }
}