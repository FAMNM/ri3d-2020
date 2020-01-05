/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import frc.robot.Constants;

public class Shooter extends PIDSubsystem {
  private final SpeedController m_flywheel = new PWMVictorSPX(Constants.Shooter.kFlywheel);
  private final Encoder m_encoder = new Encoder(Constants.Shooter.kEncPinA, Constants.Shooter.kEncPinB);
  private final SimpleMotorFeedforward m_flywheelFeedforward = new SimpleMotorFeedforward(Constants.Shooter.kSVolts, Constants.Shooter.kVVoltSRP);

  public Shooter() {
    super(new PIDController(Constants.Shooter.kP, Constants.Shooter.kI, Constants.Shooter.kD));
    getController().setTolerance(Constants.Shooter.kRPSTolerance);
    m_encoder.setDistancePerPulse(Constants.Shooter.kEncoderDPP);
    setSetpoint(Constants.Shooter.kTargetRPS);
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    m_flywheel.setVoltage(output + m_flywheelFeedforward.calculate(setpoint));
  }

  @Override
  protected double getMeasurement() {
    return m_encoder.getRate();
  }

  public boolean atSetpoint() {
    return m_controller.atSetpoint();
  }
}
