package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static frc.robot.RobotMap.*;

public class Drivetrain extends SubsystemBase{
    private WPI_VictorSPX _lfDrive, _rfDrive, _lbDrive, _rbDrive;

    private SpeedControllerGroup lDrive, rDrive;

    private DifferentialDrive drive;

    
    public Drivetrain() {
        _lfDrive = new WPI_VictorSPX(kLFDrive);
        _rfDrive = new WPI_VictorSPX(kRFDrive);
        _lbDrive = new WPI_VictorSPX(kLBDrive);
        _rbDrive = new WPI_VictorSPX(kRBDrive);
        
        lDrive = new SpeedControllerGroup(_lfDrive, _lbDrive);
        rDrive = new SpeedControllerGroup(_rfDrive, _rbDrive);

        drive = new DifferentialDrive(lDrive, rDrive);
    }

    public void tankDrive(double l, double r) {
        drive.tankDrive(l, r);
    }

    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation, true);
    }


    public void stop() {
        drive.tankDrive(0, 0);
    }
}