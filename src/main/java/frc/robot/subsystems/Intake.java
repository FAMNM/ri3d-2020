/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private static WPI_VictorSPX m_intake = new WPI_VictorSPX(Constants.kIntake);

  /**
   * Drives the intake motor forward or backward with triggers
   * @param left Value of the left trigger
   * @param right Value of the right trigger
   */
  public void runIntake(double left, double right) {
    m_intake.set(right - left);
  }
}
