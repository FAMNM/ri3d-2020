/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrain extends SubsystemBase {
  // Motor Controllers:
  private WPI_VictorSPX m_LFDrive = new WPI_VictorSPX(Constants.kLFDrive);
  private WPI_VictorSPX m_RFDrive = new WPI_VictorSPX(Constants.kRFDrive);
  private WPI_VictorSPX m_LBDrive = new WPI_VictorSPX(Constants.kLBDrive);
  private WPI_VictorSPX m_RBDrive = new WPI_VictorSPX(Constants.kRBDrive);

  // SpeedControllerGroups:
  private SpeedControllerGroup m_left = new SpeedControllerGroup(m_LFDrive, m_LBDrive);
  private SpeedControllerGroup m_right = new SpeedControllerGroup(m_RFDrive, m_RBDrive);

  // DifferentialDrive:
  private DifferentialDrive m_driveTrain = new DifferentialDrive(m_left, m_right);

  //Local variables:
  private boolean fullSpeed = false;

  /**
   * Runs arcade drive on this drivetrain
   * @param move The speed to move forward
   * @param turn The speed to turn the robot
   */
  public void arcadeDrive(double move, double turn) {
    m_driveTrain.arcadeDrive(
      fullSpeed ? move : move * Constants.kLeftDriveScaling,
      fullSpeed ? turn : turn * Constants.kRightDriveScaling,
      true
    );
  }

  /**
   * Runs the robot using set values
   * @param move The speed at which to drive
   * @param turn The speed at which to turn
   */
  public void autoDrive(double move, double turn) {
    m_driveTrain.arcadeDrive(-move, turn, true);
  }

  /**
   * Stops the motors of the drive train
   */
  public void stopMotors() {
    m_driveTrain.stopMotor();
  }

  /**
   * Toggle full robot speed
   */
  public void toggleSpeed() {
    fullSpeed = !fullSpeed;
  }
}
