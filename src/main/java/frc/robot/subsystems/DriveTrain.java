/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import static frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {
  WPI_VictorSPX flMotor;
  WPI_VictorSPX frMotor;
  WPI_VictorSPX rlMotor;
  WPI_VictorSPX rrMotor;
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  DifferentialDrive dt;
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    flMotor = new WPI_VictorSPX(FRONT_LEFT_MOTOR);
    frMotor = new WPI_VictorSPX(FRONT_RIGHT_MOTOR);
    rlMotor = new WPI_VictorSPX(REAR_LEFT_MOTOR);
    rrMotor = new WPI_VictorSPX(REAR_RIGHT_MOTOR);
    leftMotors = new SpeedControllerGroup(flMotor, rlMotor);
    rightMotors = new SpeedControllerGroup(frMotor, rrMotor);
    dt = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void tankDrive(XboxController driver) {
    double move = driver.getRawAxis(0);
    double turn = driver.getRawAxis(1);
    dt.arcadeDrive(move, turn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
