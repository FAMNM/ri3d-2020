package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterTestCommand extends CommandBase {
    private Shooter shooter;
    private ShuffleboardTab flyWheelTab;
    private NetworkTableEntry flyWheelSpeed, p, i, d;

    public ShooterTestCommand(Shooter shooter) {
        this.shooter = shooter;

        this.flyWheelTab = Shuffleboard.getTab("Flywheel");

        this.flyWheelSpeed = this.flyWheelTab
                                 .add("Speed", 0)
                                 .withWidget(BuiltInWidgets.kNumberSlider)
                                 .getEntry();
        
        this.p = this.flyWheelTab
                     .add("p", 0.01)
                     .withWidget(BuiltInWidgets.kNumberSlider)
                     .getEntry();
        
        this.i = this.flyWheelTab
                     .add("i", 0)
                     .withWidget(BuiltInWidgets.kNumberSlider)
                     .getEntry();

        this.d = this.flyWheelTab
                     .add("d", 0)
                     .withWidget(BuiltInWidgets.kNumberSlider)
                     .getEntry();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        shooter.setPidConstants(p.getDouble(0), i.getDouble(0), d.getDouble(0));
        shooter.shoot(flyWheelSpeed.getDouble(0));
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}