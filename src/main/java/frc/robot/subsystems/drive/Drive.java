package frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.*;
import frc.robot.Constants;
import frc.robot.subsystems.Motors.*;
import com.kauailabs.navx.frc.AHRS;
import static edu.wpi.first.units.Units.*;

public class Drive extends SubsystemBase implements DriveIO {
    private final DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.TRACK_WIDTH);
    private final MotorsLeft leftMotors;
    private final MotorsRight rightMotors;
    private final AHRS imu;
    private final DifferentialDriveOdometry odometry;
    private final DriveIOInputs inputs = new DriveIOInputs(); // Store inputs here
    private Pose2d currentPose = new Pose2d(0, 0, new Rotation2d());

    public Drive() {
        leftMotors = new MotorsLeft(Constants.LEFT_ID_1, Constants.LEFT_ID_2);
        rightMotors = new MotorsRight(Constants.RIGHT_ID_1, Constants.RIGHT_ID_2);
        imu = new AHRS();
        odometry = new DifferentialDriveOdometry(imu.getRotation2d(), leftMotors.distanceTraveled(), rightMotors.distanceTraveled(), currentPose);
    }

    @Override
    public void updateInputs(DriveIOInputs inputs) {
        inputs.gyroYawDeg = imu.getYaw();
        inputs.gyroPitchDeg = imu.getPitch();
        inputs.gyroRollDeg = imu.getRoll();
        inputs.gyroYawRad = Radians.of(imu.getYaw());
        inputs.gyroPitchwRad = Radians.of(imu.getPitch());
        inputs.gyroRollRad = Radians.of(imu.getRoll());
        inputs.turn_times = imu.getAngle() / 360.0;
        inputs.xAccelMps = imu.getWorldLinearAccelX() * 9.81;
        inputs.yAccelMps = imu.getWorldLinearAccelY() * 9.81;
        inputs.xVelocityMps += inputs.xAccelMps * 0.02;
        inputs.yVelocityMps += inputs.yAccelMps * 0.02;
    }

   
    public void setVelocity(ChassisSpeeds speeds) {
        DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(speeds);
        leftMotors.setVoltage(wheelSpeeds.leftMetersPerSecond);
        rightMotors.setVoltage(wheelSpeeds.rightMetersPerSecond);
    }

    /**
     * Returns the current gyro yaw as a Rotation2d on the Z rotation.
     * @return The current yaw of the gyro.
     */
    public Rotation2d getGyroYaw() {
        return Rotation2d.fromDegrees(inputs.gyroYawDeg);
    }

    /**
     * Returns the current gyro pitch as a Rotation2d on a Y rotation.
     * @return The current pitch of the gyro.
     */
    public Rotation2d getGyroPitch() {
        return Rotation2d.fromDegrees(inputs.gyroPitchDeg);
    }

    /**
     * Returns the current gyro roll as a Rotation2d on the X rotation.
     * @return The current roll of the gyro.
     */
    public Rotation2d getGyroroll() {
        return Rotation2d.fromDegrees(inputs.gyroRollDeg);
    }

    /**
     * Returns the current pose of the robot as a Pose2d.
     * @return The current pose of the robot.
     */
    public Pose2d getPose2d() {
        return currentPose;
    }

    @Override
    public void periodic() {
        currentPose = odometry.update(imu.getRotation2d(), leftMotors.distanceTraveled(), rightMotors.distanceTraveled());
        updateInputs(inputs); 
    }
}
