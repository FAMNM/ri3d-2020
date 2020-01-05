/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private final WPI_VictorSPX m_leftFront = new WPI_VictorSPX(Constants.kLeftFrontVictor);
  private final WPI_VictorSPX m_leftBack = new WPI_VictorSPX(Constants.kLeftBackVictor);
  private final SpeedControllerGroup m_left = new SpeedControllerGroup(m_leftFront, m_leftBack);

  private final WPI_VictorSPX m_rightFront = new WPI_VictorSPX(Constants.kRightFrontVictor);
  private final WPI_VictorSPX m_rightBack = new WPI_VictorSPX(Constants.kRightBackVictor);
  private final SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightFront, m_rightBack);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

  //Reverses forward direction of robot when true
  private boolean kReverse = false;

  /**
   * Runs tank drive
   * @param left Value of the left stick y axis
   * @param right Value of the right stick y axis
   */
  public void tankDrive(double left, double right) {
    int dir = kReverse ? 1 : -1;
    m_drive.tankDrive(dir * left, dir * right);
  }

  /**
   * Swaps the forward direction
   */
  public void reverseDirection() {
    kReverse = !kReverse;
  }
}
