/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private final SpeedController m_flywheel = new PWMVictorSPX(Constants.kFlywheel);

  /**
   * Spins the flywheel forward
   */
  public void spinFlywheel() {
    m_flywheel.set(1);
  }

  /**
   * Stops the flywheel
   */
  public void stopFlywheel() {
    m_flywheel.stopMotor();
  }
}
