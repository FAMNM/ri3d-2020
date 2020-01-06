<<<<<<< HEAD
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

public class Intake extends SubsystemBase {
  private final WPI_VictorSPX m_intake = new WPI_VictorSPX(Constants.kIntake);

  /**
   * Runs the intake motor
   * @param left Value of left trigger
   * @param right Value of right trigger
   */
  public void runIntake(double left, double right) {
    m_intake.set(right - left);
  }
}
=======
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.RobotMap.*;

public class Intake extends SubsystemBase
{
    private WPI_VictorSPX _intakeMotor;
    private SpeedControllerGroup intake;
    private double eatPower = 0.5, uneatPower = -0.5;

    public Intake() {
        _intakeMotor = new WPI_VictorSPX(kIntake);
        intake = new SpeedControllerGroup(_intakeMotor);
    }

    public void eat() {
        intake.set(eatPower);
    }

    public void uneat() {
        intake.set(uneatPower);
    }

    @Override
    public void periodic() {
        
    }
}
>>>>>>> 2c8c190e4878e253a279aebed3f46cd812495230
