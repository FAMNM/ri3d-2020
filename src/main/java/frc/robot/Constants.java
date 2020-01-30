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
    // Hardware Ports:
    // -- Drivetrain:
    public static final int kLFDrive = 9;
    public static final int kRFDrive = 7;
    public static final int kLBDrive = 8;
    public static final int kRBDrive = 6;

    // -- Intake:
    public static final int kIntake = 5;
    
    // -- Shooter:
    public static final int kFlyWheel = 2;

    // -- Climbing Arm:
    public static final int kArm = 3;

    // -- Winch:
    public static final int kWinch = 4;

    // -- Conveyor:
    public static final int kConveyor = 1;

    // -- CPSpinner:
    public static final int kSpinner = 0;

    // Constant Variables:
    public static final double kConveyorSpeed = 0.5;
    public static final double kFlywheelSpeed = 0.45;
    public static final double kWinchSpeed = 0.65;
    public static final double kArmSpeed = 0.7;
    public static final double kIntakeSpeed = 1.0;
    public static final double kLeftDriveScaling = 1.0 / 1.3;
    public static final double kRightDriveScaling = 1.0 / 1.4;

    //Autonomous:
    public final class Autonomous {
        public static final double kStartDelay = 0.0;
        public static final double kForwardTime = 3; //1 sec is about 3.5 ft (min 3 sec)
        public static final double kAutoSpeed = 0.6;
    }
}
