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

public class Rotator extends SubsystemBase {
  WPI_VictorSPX rotatorMotor;
  /**
   * Creates a new Rotator.
   */
  public Rotator() {
    rotatorMotor = new WPI_VictorSPX(ROTATOR_MOTOR);
  }

  public void rotate() {
    rotatorMotor.set(.5);
  }

  public void stopRotating() {
    rotatorMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
