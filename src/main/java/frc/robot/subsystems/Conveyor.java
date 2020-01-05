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

public class Conveyor extends SubsystemBase {
  WPI_VictorSPX conveyorMotor;
  /**
   * Creates a new Conveyor.
   */
  public Conveyor() {
    conveyorMotor = new WPI_VictorSPX(CONVEYOR_MOTOR);
  }

  public void conveyorMove(double p) {
    conveyorMotor.set(p);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
