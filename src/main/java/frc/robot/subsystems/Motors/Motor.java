package frc.robot.subsystems.Motors;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Measure;

public class Motor {
    private MotorIO io;
    private MotorIOInputsAutoLogged inputs = new MotorIOInputsAutoLogged();

    public Motor(MotorIO io) {
        this.io = io;
    }

    public void setVoltage(double volts){
        io.setVoltage(volts);
    }

    public void setPosition(double radians){
        io.setPosition(radians);
    }

    public void setVelocity(double velocity){
        io.setVelocity(velocity);
    }


    public Measure<Angle> getSensorPosition(){
        return io.getSensorPosition();
    }

    public void updateInputs(){
        io.updateInputs(inputs);
        Logger.processInputs("motor", inputs);
    }
}