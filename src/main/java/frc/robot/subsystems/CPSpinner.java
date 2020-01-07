/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CPSpinner extends SubsystemBase {
  private final Relay m_spinner = new Relay(Constants.kSpinner, Relay.Direction.kForward);

  /**
   * Spins the CP Spinner
   */
  public void spinCP() {
    m_spinner.set(Relay.Value.kOn);
  }

  /**
   * Stops the CP Spinner
   */
  public void stopCP() {
    m_spinner.set(Relay.Value.kOff);
  }
}
