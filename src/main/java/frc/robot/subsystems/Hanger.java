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

public class Hanger extends SubsystemBase {
  WPI_VictorSPX armMotor;
  WPI_VictorSPX winchMotor;
  /**
   * Creates a new Hanger.
   */
  public Hanger() {
    armMotor = new WPI_VictorSPX(ARM_MOTOR);
    winchMotor = new WPI_VictorSPX(WINCH_MOTOR);
  }

  public void grabBar() {
    armMotor.set(.5);
  }

  public void winch() {
    winchMotor.set(.5);
  }

  public void stopGrabbing() {
    armMotor.set(0);
  }

  public void stopWinch() {
    winchMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
