/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Conveyor extends SubsystemBase {
  // Motor Controllers:
  private final WPI_VictorSPX m_conveyor = new WPI_VictorSPX(Constants.kConveyor);

  /**
   * Runs conveyor up
   */
  public void raiseConveyor() {
    m_conveyor.set(Constants.kConveyorSpeed);
  }

  /**
   * Runs conveyor down
   */
  public void lowerConveyor() {
    m_conveyor.set(-Constants.kConveyorSpeed);
  }

  /**
   * Stops conveyor
   */
  public void stopConveyor() {
    m_conveyor.stopMotor();
  }
}
