package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootCommand extends CommandBase {
    private Shooter shooter;

    /**
     * Creates a new instance of this ShootCommand
     * @param shooter the Shooter subsystem used by this command
     */
    public ShootCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    /**
     * Runs repeatedly while this command is active
     */
    @Override
    public void execute() {
        shooter.shoot();
    }

    /**
     * Runs when this command ends or is interrupted
     */
    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}