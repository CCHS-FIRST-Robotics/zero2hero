package frc.robot.subsystems.Drive;

import edu.wpi.first.math.geometry.Rotation2d;
import com.kauailabs.navx.frc.AHRS;
import static edu.wpi.first.units.Units.*;

public class Gyro implements GyroIO {
    private final AHRS NavX;
    private final GyroIOInputs inputs = new GyroIOInputs();

    public Gyro() {
        NavX = new AHRS();
    }

    @Override
    public void updateInputs(GyroIOInputs inputs) {
        inputs.imu_Connected = NavX.isConnected();
        inputs.gyroYawDeg = NavX.getYaw();
        inputs.gyroPitchDeg = NavX.getPitch();
        inputs.gyroRollDeg = NavX.getRoll();
        inputs.gyroYawRad = Radians.of(NavX.getYaw());
        inputs.gyroPitchRad = Radians.of(NavX.getPitch());
        inputs.gyroRollRad = Radians.of(NavX.getRoll());
        inputs.turn_times = NavX.getAngle() / 360.0;
        inputs.xAccelMps = NavX.getWorldLinearAccelX() * 9.81;
        inputs.yAccelMps = NavX.getWorldLinearAccelY() * 9.81;
        inputs.xVelocityMps += inputs.xAccelMps * 0.02;
        inputs.yVelocityMps += inputs.yAccelMps * 0.02;
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
    public Rotation2d getGyroRoll() {
        return Rotation2d.fromDegrees(inputs.gyroRollDeg);
    }
    /**
     * Resets the IMU to its initial state.
     */
    public void resetImu() {
        NavX.reset();
    }

   
}
