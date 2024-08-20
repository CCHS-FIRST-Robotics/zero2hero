package frc.robot.subsystems.Drive;

import org.littletonrobotics.junction.AutoLog;


import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Measure;


import static edu.wpi.first.units.Units.*;


public interface DriveIO {
  @AutoLog
  public static class DriveIOInputs {
    public Measure<Angle> gyroYawRad = Radians.of(0.0);
    public Measure<Angle> gyroPitchwRad = Radians.of(0.0);
    public Measure<Angle> gyroRollRad = Radians.of(0.0);
    public double gyroYawDeg = 0.0;
    public double gyroPitchDeg = 0.0;
    public double gyroRollDeg = 0.0;
    public double turn_times = 0.0;
    public double xAccelMps = 0.0;
    public double yAccelMps = 0.0;
    public double xVelocityMps = 0.0;
    public double yVelocityMps = 0.0;
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(DriveIOInputs inputs) {
  }

  /** Run open loop at the specified voltage. */
  public default void setVelocity(ChassisSpeeds speeds) {
  }
}