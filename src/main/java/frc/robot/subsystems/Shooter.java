/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase {
  WPI_VictorSPX shooterMotor;
  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    shooterMotor = new WPI_VictorSPX(SHOOTER_MOTOR);
  }

  public void shoot() {
    shooterMotor.set(.5);
  }

  public void stopShooting() {
    shooterMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
