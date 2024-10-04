package frc.robot.subsystems.Drive;

import edu.wpi.first.math.geometry.Rotation2d;

import com.kauailabs.navx.frc.AHRS;
import static edu.wpi.first.units.Units.*;

public class NavxIO implements GyroIO {
    private final AHRS NavX;
    
    public NavxIO(){
        NavX = new AHRS();
        NavX.reset();

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
    @Override
    public Rotation2d getYaw() {
        return new Rotation2d(NavX.getYaw());
    }

    /**
     * Returns the current gyro pitch as a Rotation2d on a Y rotation.
     * @return The current pitch of the gyro.
     */
    @Override
    public Rotation2d getPitch() {
        return new Rotation2d(NavX.getPitch());
    }

    /**
     * Returns the current gyro roll as a Rotation2d on the X rotation.
     * @return The current roll of the gyro.
     */
    @Override
    public Rotation2d getRoll() {
        return new Rotation2d(NavX.getRoll());
    }
    /**
     * Resets the Yaw to 0.
     */
    @Override
    public void resetImu() {
        NavX.reset();
    }

   
}
