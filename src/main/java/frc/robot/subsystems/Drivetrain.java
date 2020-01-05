/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.VictorSP;
import java.util.function.DoubleSupplier;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private final WPI_VictorSPX m_left = new WPI_VictorSPX(Constants.kLeftVictor);
  private final WPI_VictorSPX m_right = new WPI_VictorSPX(Constants.kRightVictor);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

  private boolean kReverse = false;

  /**
   * Runs tank drive
   */
  public void tankDrive(double left, double right) {
    int dir = kReverse ? -1 : 1;
    m_drive.tankDrive(dir * left, dir * right);
  }

  /**
   * Swaps the forward direction
   */
  public void reverseDirection() {
    kReverse = !kReverse;
  }
}
