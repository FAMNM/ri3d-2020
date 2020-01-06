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

public class Conveyor extends SubsystemBase {
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
=======
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.RobotMap.*;

public class Conveyor extends SubsystemBase{
    private WPI_VictorSPX _motor;
    private final double EAT_POWER = 0.5, UNEAT_POWER = -0.5;
    public Conveyor() {
        _motor = new WPI_VictorSPX(kConveyor);
    }

    public void eat() {
        _motor.set(EAT_POWER);
    }

    public void uneat() {
        _motor.set(UNEAT_POWER);
    }
}
>>>>>>> 2c8c190e4878e253a279aebed3f46cd812495230
