package frc.robot.subsystems.Motors;

import static edu.wpi.first.units.Units.*;


import org.littletonrobotics.junction.Logger;

import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Velocity;
import edu.wpi.first.units.Voltage;
import frc.robot.Constants;

public class MotorGroup {
    private MotorGroupIOSparkSRX io ;
    private MotorIOInputsAutoLogged inputs = new MotorIOInputsAutoLogged();
    String name;

    public MotorGroup(MotorGroupIOSparkSRX io, String name) {
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

    public Measure<Distance> distanceTraveled(){
        Measure<Angle> Rotations = io.getSensorPosition();
        Measure<Distance> whellciqumference = Constants.Wheel_Diameter.times(Math.PI);
        Measure <Distance> metersTraveled = Meters.of(Rotations.in(Rotation) * whellciqumference.in(Meters));
        return metersTraveled;

    }

    public void updateInputs(){
        io.updateInputs(inputs);
        Logger.processInputs(name, inputs);
    }
}

