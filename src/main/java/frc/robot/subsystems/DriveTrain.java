/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;

public class DriveTrain extends SubsystemBase {
  private WPI_VictorSPX flMotor;
  private WPI_VictorSPX frMotor;
  private WPI_VictorSPX rlMotor;
  private WPI_VictorSPX rrMotor;
  private SpeedControllerGroup leftMotors;
  private SpeedControllerGroup rightMotors;
  private DifferentialDrive driveTrain;
  private int direction;
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    flMotor = new WPI_VictorSPX(3);
    frMotor = new WPI_VictorSPX(1);
    rlMotor = new WPI_VictorSPX(4);
    rrMotor = new WPI_VictorSPX(2);
    leftMotors = new SpeedControllerGroup(flMotor, rlMotor);
    rightMotors = new SpeedControllerGroup(frMotor, rrMotor);
    driveTrain = new DifferentialDrive(leftMotors, rightMotors);
    direction = 1;
  }

  public void arcadeDrive(XboxController controller) {
    double move = controller.getY(GenericHID.Hand.kLeft) * direction;
    double turn = controller.getX(GenericHID.Hand.kLeft);
    driveTrain.arcadeDrive(move, turn);
  }

  public void changeDirection() {
    direction *= -1;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
