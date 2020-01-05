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

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private final VictorSP m_left = new VictorSP(Constants.kLeftVictor);
  private final VictorSP m_right = new VictorSP(Constants.kRightVictor);

  private boolean kReverse = false;

  /**
   * Runs tank drive
   */
  public void tankDrive(double left, double right) {
    int dir = kReverse ? -1 : 1;
    m_left.setSpeed(-dir * left);
    m_right.setSpeed(dir * right);
  }

  /**
   * Swaps the forward direction
   */
  public void reverseDirection() {
    kReverse = !kReverse;
  }
}
