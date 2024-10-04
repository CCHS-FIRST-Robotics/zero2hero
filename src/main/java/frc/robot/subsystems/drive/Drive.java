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
    private final DifferentialDriveOdometry odometry;
    private Pose2d currentPose = new Pose2d(0, 0, new Rotation2d());
    private final MotorsLeft leftMotors = new MotorsLeft();
    private final MotorsRight rightMotors = new MotorsRight();
    GyroIOInputs inputs = new GyroIOInputs();
    private final Gyro NavX = new Gyro(); 

   
    public Drive() {
       
        odometry = new DifferentialDriveOdometry(NavX.getYaw(), leftMotors.distanceTraveled(), rightMotors.distanceTraveled(), currentPose);
    }



    public Pose2d getPose(){
        return currentPose;
    }

    public void resetPose(){
        leftMotors.resetDistanceTraveled();
        rightMotors.resetDistanceTraveled();
        NavX.resetImu();
    }




 public DifferentialDriveKinematics getKinematics(){
    return kinematics;
 }




 
    public double leftDistanceTravled(){
        return leftMotors.distanceTraveled();

}

    public void setVoltage(double volts){
        leftMotors.setVoltage(volts);
        rightMotors.setVoltage(volts);
    }


    public void setVelocity(ChassisSpeeds speeds){
        DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(speeds);

        double lVelocity = wheelSpeeds.leftMetersPerSecond;
        double rVelocity = wheelSpeeds.rightMetersPerSecond;

        leftMotors.setVelocity(lVelocity);
        rightMotors.setVelocity(rVelocity);
    }


        





    public double rightDistanceTravled(){
        return rightMotors.distanceTraveled();

}

    public void Stop(){
        leftMotors.setVoltage(0.0);
        rightMotors.setVoltage(0.0);
    }
        

    @Override
    public void periodic() {
        currentPose = odometry.update(NavX.getYaw(), leftMotors.distanceTraveled(), rightMotors.distanceTraveled());
        NavX.updateInputs(); 
    }



}