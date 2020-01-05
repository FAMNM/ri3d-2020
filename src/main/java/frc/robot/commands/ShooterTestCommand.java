package frc.robot.commands;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterTestCommand extends CommandBase {
    private Shooter shooter;

    private ShuffleboardTab flyWheelTab;
    private NetworkTableEntry flyWheelSpeed;

    public ShooterTestCommand(Shooter shooter) {
        this.shooter = shooter;

        this.flyWheelTab = Shuffleboard.getTab("Flywheel");

        this.flyWheelSpeed = this.flyWheelTab
                                 .add("Speed", 0)
                                 .withWidget(BuiltInWidgets.kNumberSlider)
                                 .withProperties(Map.of("min", -1, "max", 1))
                                 .getEntry();
    }

    @Override
    public void execute() {
        shooter.shoot(flyWheelSpeed.getDouble(0));
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}