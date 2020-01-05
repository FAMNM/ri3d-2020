package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase{
    private WPI_VictorSPX _lfDrive, _rfDrive, _lbDrive, _rbDrive;

    private SpeedControllerGroup lDrive, rDrive;

    
    public Drivetrain() {
        _lfDrive = new WPI_VictorSPX(kLFDrive);
        _lfDrive.setInverted(true);
        _rfDrive = new WPI_VictorSPX(kRFDrive);
        _lbDrive = new WPI_VictorSPX(kLBDrive);
        _lbDrive.setInverted(true);
        _rbDrive = new WPI_VictorSPX(kRBDrive);
        
        lDrive = new SpeedControllerGroup(_lfDrive, _lbDrive);
        rDrive = new SpeedControllerGroup(_rfDrive, _rbDrive);
    }

    public void tankDrive(double l, double r) {
        lDrive.set(l);
        rDrive.set(r);
    }
}