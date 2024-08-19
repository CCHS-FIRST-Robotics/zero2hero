package frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.*;
import frc.robot.Constants;
import frc.robot.subsystems.Motors.*;
import com.kauailabs.navx.frc.AHRS;

public class Drive extends SubsystemBase implements DriveIO {
    DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.TRACK_WIDTH);
    private final MotorsLeft leftMotors;
    private final MotorsRight rightMotors;
    private final AHRS imu;
    private DifferentialDriveOdometry odometry; 
    private Pose2d currentPose = new Pose2d(0, 0, new Rotation2d()); 

    public Drive() {
        leftMotors = new MotorsLeft(Constants.LEFT_ID_1, Constants.LEFT_ID_2);
        rightMotors = new MotorsRight(Constants.RIGHT_ID_1, Constants.RIGHT_ID_2);
        imu = new AHRS();
        odometry = new DifferentialDriveOdometry(imu.getRotation2d(), leftMotors.distanceTravled(), rightMotors.distanceTravled(), currentPose);
    }

    public void updateInputs(DriveIOInputs inputs) {
        inputs.gyroYawDeg = imu.getYaw();
        inputs.gyroPitchDeg = imu.getPitch();
        inputs.gyrorollDeg = imu.getRoll();
        inputs.turn_times = (imu.getAngle() / 360);
        inputs.xAccelMps = imu.getWorldLinearAccelX() * 9.81;
        inputs.yAccelMps = imu.getWorldLinearAccelY() * 9.81;
        inputs.xVelocityMps += inputs.xAccelMps * 0.02;
        inputs.yVelocityMps += inputs.yAccelMps * 0.02;
        inputs.currentPose = currentPose; // meters,meters,degree
    }

    public void setVelocity(ChassisSpeeds speeds) {
        DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(speeds);

        double lVelocity = wheelSpeeds.leftMetersPerSecond;
        double rVelocity = wheelSpeeds.rightMetersPerSecond;

        leftMotors.setVoltage(lVelocity);
        rightMotors.setVoltage(rVelocity);
    }

    @Override
    public void periodic() {
        currentPose = odometry.update(imu.getRotation2d(), leftMotors.distanceTravled(), rightMotors.distanceTravled());
    }
}
