/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;

public class ClimbingArm extends SubsystemBase {
  private WPI_VictorSPX armMotor;
  /**
   * Creates a new Climber.
   */
  public ClimbingArm() {
    armMotor = new WPI_VictorSPX(6);
  }

  public void climb(XboxController controller) {
    armMotor.set(controller.getY(GenericHID.Hand.kLeft));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
