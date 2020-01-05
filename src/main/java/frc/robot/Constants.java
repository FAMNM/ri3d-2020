/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Drivetrain:
    public static final int kLeftFrontVictor = 1;
    public static final int kLeftBackVictor = 2;
    public static final int kRightFrontVictor = 3;
    public static final int kRightBackVictor = 4;

    //Shooter:
    public static final class Shooter {
        //Hardware Ports:
        public static final int kFlywheel = 5;
        public static final int kEncPinA = 8;
        public static final int kEncPinB = 9;

        //Hardware settings:
        public static final double kRPSTolerance = 0.25;
        public static final double kEncoderDPP = 0.001;
        public static final double kTargetRPS = 3;

        //PID Values:
        //TODO - Tune these values
        public static final double kP = 2;
        public static final double kI = 0.1;
        public static final double kD = 0.01;

        //Voltage constants:
        //TODO - DETERMINE PROPER VALUES BEFORE RUNNING
        public static final double kSVolts = 6;
        public static final double kVVoltSRP = 3;
    }

    //Intake:
    public static final int kIntake = 6;
}
