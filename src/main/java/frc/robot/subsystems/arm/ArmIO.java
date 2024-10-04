package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;


public interface ArmIO {
    

    @AutoLog
    public static class ArmIOInputs {
        public double motorCurrent;
        public double motorVoltage;
        public double motorPosition;
        public double motorVelocity;
        public double motorTemperature;
    }



    public default void setPosition(double radians){
       
    }

    public default void updateInputs(ArmIOInputs inputs) {
    }
    public default void setVelocity(double velocity) {
    }
}