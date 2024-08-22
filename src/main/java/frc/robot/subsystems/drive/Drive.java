package frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.*;
import frc.robot.Constants;
import frc.robot.subsystems.Drive.GyroIO.GyroIOInputs;
import frc.robot.subsystems.Motors.*;



public class Drive extends SubsystemBase {
    private final DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.TRACK_WIDTH);
    private final MotorsLeft leftMotors;
    private final MotorsRight rightMotors;
    private final DifferentialDriveOdometry odometry;
    private Pose2d currentPose = new Pose2d(0, 0, new Rotation2d());
    private final Gyro NavX;
    private final GyroIOInputs gyroInputs; 

    public Drive() {
        leftMotors = new MotorsLeft(Constants.LEFT_ID_1, Constants.LEFT_ID_2);
        rightMotors = new MotorsRight(Constants.RIGHT_ID_1, Constants.RIGHT_ID_2);
        NavX = new Gyro(); 
        gyroInputs = new GyroIOInputs(); 
        odometry = new DifferentialDriveOdometry(NavX.getGyroYaw(), leftMotors.distanceTraveled(), rightMotors.distanceTraveled(), currentPose);
    }




   
    public void setVelocity(ChassisSpeeds speeds) {
        DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(speeds);
        leftMotors.setVoltage(wheelSpeeds.leftMetersPerSecond);
        rightMotors.setVoltage(wheelSpeeds.rightMetersPerSecond);
    }

    public Pose2d getPose(){
        return currentPose;
    }

    

   public double leftDistanceTravled(){
    return leftMotors.distanceTraveled();

}



    public double rightDistanceTravled(){
        return rightMotors.distanceTraveled();

    }
        

    @Override
    public void periodic() {
        currentPose = odometry.update(NavX.getGyroYaw(), leftMotors.distanceTraveled(), rightMotors.distanceTraveled());
        NavX.updateInputs(gyroInputs); 
    }
    }