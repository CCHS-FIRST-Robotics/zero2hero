package frc.robot.subsystems.drive.Motors;

import org.littletonrobotics.junction.AutoLog;

public interface MotorIO {
    @AutoLog
    public static class MotorIOInputs {
        public double Cim1Current;
        public double Cim1Voltage;
        public double Cim1Position;
        public double Cim1Velocity;
        public double Cim1Temperature;

        public double Cim2Current;
        public double Cim2Voltage;
        public double Cim2Position;
        public double Cim2Velocity;
        public double Cim2Temperature;
    }

    public default void setVoltage(double volts) {
    }

    public default void updateInputs(MotorIOInputs inputs) {
    }
}
