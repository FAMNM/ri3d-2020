package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootCommand extends CommandBase {
    private Shooter shooter;
    private XboxController controller;

    public ShootCommand(Shooter shooter, XboxController controller) {
        this.shooter = shooter;
        this.controller = controller;

        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.shoot(controller.getTriggerAxis(Hand.kRight));
    }
}