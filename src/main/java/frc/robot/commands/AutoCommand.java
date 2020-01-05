package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class AutoCommand extends SequentialCommandGroup {

    public AutoCommand(Drivetrain drivetrain, Shooter shooter) {
        addCommands(
            new MoveInchesCommand(drivetrain, 10, 0.5)
        );
    }
}