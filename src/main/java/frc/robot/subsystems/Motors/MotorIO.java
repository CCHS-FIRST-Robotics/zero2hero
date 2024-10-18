package frc.robot.subsystems.Motors;

import static edu.wpi.first.units.Units.*;

import org.littletonrobotics.junction.AutoLog;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Velocity;
import edu.wpi.first.units.Voltage;

public interface MotorIO {
    @AutoLog
    public static class MotorIOInputs {
        public double motorCurrent;
        public double motorVoltage;
        public double motorPosition;
        public double motorVelocity;
        public double motorTemperature;
    }

    public default void setVoltage(Measure<Voltage> volts) {
    }

    // public default void setPosition(Measure<Angle> degress){
    // }

    public default void updateInputs(MotorIOInputs inputs) {
    }
    public default void setVelocity(Measure<Velocity<Distance>> speed){ //Meters per second
    }
    public default Measure<Angle> getSensorPosition(){
        return Degrees.of(0);
    }
    public default Measure<Velocity<Angle>> getSensorVelocity(){
        return RotationsPerSecond.of(0.0);
    }
    




}