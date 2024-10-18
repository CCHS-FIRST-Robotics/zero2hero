package frc.robot.subsystems.Motors;

import static edu.wpi.first.units.Units.Degrees;

import org.littletonrobotics.junction.AutoLog;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Measure;

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
    public default Measure<Angle> getSensorPosition(){
        return Degrees.of(0);
    



}
}