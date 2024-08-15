package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.kinematics.*;
import frc.robot.Constants;
import frc.robot.subsystems.drive.Motors.MotorsLeft;
import frc.robot.subsystems.drive.Motors.MotorsRight;

public class Drive extends SubsystemBase{
    DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.TRACK_WIDTH);
    private final MotorsLeft leftMotors;
    private final MotorsRight rightMotors;



    public Drive(){
        leftMotors = new MotorsLeft(Constants.LEFT_ID_1, Constants.LEFT_ID_2);
        rightMotors = new MotorsRight(Constants.RIGHT_ID_1, Constants.RIGHT_ID_2);
    }

    public void setVelocity(ChassisSpeeds speeds){
        DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(speeds);

        double lVelocity = wheelSpeeds.leftMetersPerSecond;
        double rVelocity = wheelSpeeds.rightMetersPerSecond;

       leftMotors.setVoltage(lVelocity);
       rightMotors.setVoltage(rVelocity);

    }
}