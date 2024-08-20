package frc.robot.subsystems.Drive;

import org.littletonrobotics.junction.AutoLog;
import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Measure;
import static edu.wpi.first.units.Units.*;

public interface GyroIO {

    @AutoLog
    public static class GyroIOInputs {
        public boolean imu_Connected = false;
        public Measure<Angle> gyroYawRad = Radians.of(0.0);
        public Measure<Angle> gyroPitchRad = Radians.of(0.0);
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

    void updateInputs(GyroIOInputs inputs);
}
