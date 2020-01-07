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
  // Motor Controllers:
  private final WPI_VictorSPX m_intake = new WPI_VictorSPX(Constants.kIntake);

  /**
   * Runs the intake motor inward
   */
  public void intakeIn() {
    m_intake.set(-Constants.kIntakeSpeed);
  }

  /**
   * Runs the intake motor outward
   */
  public void intakeOut() {
    m_intake.set(Constants.kIntakeSpeed);
  }

  /**
   * Stops the intake motor
   */
  public void intakeStop() {
    m_intake.stopMotor();
  }
}
