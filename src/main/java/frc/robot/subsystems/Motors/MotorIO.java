package frc.robot.subsystems.Motors;

import org.littletonrobotics.junction.AutoLog;

public interface MotorIO {
    @AutoLog
    public static class MotorIOInputs {
        public double motorCurrent;
        public double motorVoltage;
        public double motorPosition;
        public double motorVelocity;
        public double motorTemperature;
    }

    public default void setVoltage(double volts) {
    }

    public default void setPosition(double radians){
    }

    public default void updateInputs(MotorIOInputs inputs) {
    }
    public default void setVelocity(double velocity) {
    }
}
