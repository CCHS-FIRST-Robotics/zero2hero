package frc.robot.subsystems.Motors;

import org.littletonrobotics.junction.AutoLog;

public interface MotorIO {
    @AutoLog
    public static class MotorIOInputs {
        public double Cim1Current = 0.0;
        public double Cim1Voltage = 0.0;
        public double Cim1Position = 0.0;
        public double Cim1Velocity = 0.0;
        public double Cim1Temperature = 0.0;

        public double Cim2Current = 0.0;
        public double Cim2Voltage = 0.0;
        public double Cim2Position = 0.0;
        public double Cim2Velocity = 0.0;
        public double Cim2Temperature = 0.0;
    }

    public default void setVoltage(double volts) {
    }

    public default void updateInputs(MotorIOInputs inputs) {
    }
}
