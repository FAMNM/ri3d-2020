/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private final WPI_VictorSPX m_flywheel = new WPI_VictorSPX(Constants.kFlywheel);

  /**
   * Activates the flywheel
   */
  public void activateFlywheel() {
    m_flywheel.set(ControlMode.Velocity, Constants.kTargetFlywheelRPS);
  }

  /**
   * Stops the flywheel
   */
  public void stopFlywheel() {
    m_flywheel.stopMotor();
  }
}
