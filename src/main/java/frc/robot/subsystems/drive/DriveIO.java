package frc.robot.subsystems.Drive;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.kinematics.ChassisSpeeds;

public interface DriveIO {
  @AutoLog
  public static class DriveIOInputs {
    public double gyroYawDeg;
    public double gyroPitchDeg;
    public double gyrorollDeg;
    public double turn_times;
    public double xAccelMps;
    public double yAccelMps;
    public double xVelocityMps;
    public double yVelocityMps;



    


  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(DriveIOInputs inputs) {
  }

  /** Run open loop at the specified voltage. */
  public default void setVelocity(ChassisSpeeds speeds) {
  }
}