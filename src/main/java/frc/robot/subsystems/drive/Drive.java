package frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


import static edu.wpi.first.units.Units.*;


import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.*;
import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Velocity;
import edu.wpi.first.units.Voltage;
import frc.robot.Constants;

import frc.robot.subsystems.Motors.*;



public class Drive extends SubsystemBase {
    private final DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.TRACK_WIDTH);
    private final DifferentialDriveOdometry odometry;
    private Pose2d currentPose = new Pose2d(0, 0, new Rotation2d());
    private final MotorsLeft leftMotors = new MotorsLeft();
    private final MotorsRight rightMotors = new MotorsRight();
    private final Gyro NavX = new Gyro(); 


   

    public Drive() {
        odometry = new DifferentialDriveOdometry(NavX.getYaw(), leftMotors.distanceTraveled(), rightMotors.distanceTraveled(), currentPose);
    }




    public Pose2d getPose() {
        return currentPose;
    }

    public DifferentialDriveKinematics getKinematics(){
        return kinematics;
    }




 
    public Measure<Distance> leftDistanceTraveled(){
        return leftMotors.distanceTraveled();

}

    public void setVoltage(Measure<Voltage> volts){
        leftMotors.setVoltage(volts);
        rightMotors.setVoltage(volts);
    }


    public void setVelocity(ChassisSpeeds speeds){
        DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(speeds);

        Measure<Velocity<Distance>> lVelocity = MetersPerSecond.of(wheelSpeeds.leftMetersPerSecond);
        Measure<Velocity<Distance>> rVelocity = MetersPerSecond.of(wheelSpeeds.rightMetersPerSecond);

        leftMotors.setVelocity(lVelocity);
        rightMotors.setVelocity(rVelocity);
    }

    public Measure<Distance> rightDistanceTravled(){
        return rightMotors.distanceTraveled();

    }

    public void Stop(){
        leftMotors.setVoltage(Volts.of(0.0));
        rightMotors.setVoltage(Volts.of(0.0));
    }
        

    @Override
    public void periodic() {
        currentPose = odometry.update(NavX.getYaw(), leftMotors.distanceTraveled().in(Meters), rightMotors.distanceTraveled().in(Meters));
        NavX.updateInputs(); 
    }



}