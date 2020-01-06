/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Winch extends SubsystemBase {
  private WPI_VictorSPX winchMotor;
  /**
   * Creates a new Winch.
   */
  public Winch() {
    winchMotor = new WPI_VictorSPX(7);
  }

  public void runWinch(XboxController controller) {
    winchMotor.set(controller.getY(GenericHID.Hand.kRight));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
