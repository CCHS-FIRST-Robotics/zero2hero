package frc.robot.subsystems.Motors;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Velocity;
import edu.wpi.first.units.Voltage;

public class Motor {
    private MotorIO io;
    private MotorIOInputsAutoLogged inputs = new MotorIOInputsAutoLogged();
    String name;

    public Motor(MotorIO io, String name) {
        this.io = io;
        this.name = name;
    }

    public void setVoltage(Measure<Voltage> volts){
        io.setVoltage(volts);
    }

    // public void setPosition(Measure<Angle> radians){
    //     io.setPosition(radians);
    // }

    public void setVelocity(Measure<Velocity<Distance>> velocity){
        io.setVelocity(velocity);
    }


    public Measure<Angle> getSensorPosition(){
        return io.getSensorPosition();
    }

    public Measure<Velocity<Angle>> getSensorVelocity(){
        return io.getSensorVelocity();
    }

    public void updateInputs(){
        io.updateInputs(inputs);
        Logger.processInputs(name, inputs);
    }
}