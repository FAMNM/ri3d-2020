/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ClimbingArm extends SubsystemBase {
  // Motor Controllers:
  private WPI_VictorSPX m_armMotor = new WPI_VictorSPX(Constants.kArm);

  /**
   * Controls the climbing arm
   * @param speed The speed at which to move the arm
   */
  public void climb(double speed) {
    m_armMotor.set(speed);
  }
}
