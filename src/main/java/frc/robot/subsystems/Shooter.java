package frc.robot.subsystems;

// import java.util.Map;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    // Motor Controllers: 
    private WPI_VictorSPX m_flywheel = new WPI_VictorSPX(Constants.kFlyWheel);

    /**
     * Spins the flywheel
     */
    public void shoot() {
        m_flywheel.set(Constants.kFlywheelSpeed);
    }

    /**
     * Spins the flywheel in reverse (for unlodging cells)
     */
    public void reverse() {
        m_flywheel.set(-0.1);
    }

    /**
     * Stops the flywheel
     */
    public void stop() {
        m_flywheel.set(0);
    }
}