package frc.robot.subsystems.Drive;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;

public interface DriveIO {
  @AutoLog
  public static class DriveIOInputs {
    public double gyroYawDeg = 0.0;
    public double gyroPitchDeg = 0.0;
    public double gyrorollDeg = 0.0;
    public double turn_times = 0.0;
    public double xAccelMps = 0.0;
    public double yAccelMps = 0.0;
    public double xVelocityMps = 0.0;
    public double yVelocityMps = 0.0;
    public Pose2d currentPose = new Pose2d(0,0,new Rotation2d());

  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(DriveIOInputs inputs) {
  }

  /** Run open loop at the specified voltage. */
  public default void setVelocity(ChassisSpeeds speeds) {
  }
}