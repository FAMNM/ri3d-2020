package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class ArcadeDriveCommand extends CommandBase {
    private final Drivetrain drivetrain;
    private final XboxController controller;

    public ArcadeDriveCommand(Drivetrain drivetrain, XboxController controller){
        this.drivetrain = drivetrain;
        this.controller = controller;

        addRequirements(this.drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(
            -controller.getY(GenericHID.Hand.kLeft), 
            controller.getX(GenericHID.Hand.kLeft)
        );
    }

}