package frc.robot.subsystems.Motors;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Velocity;
import edu.wpi.first.units.Voltage;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class MotorIOTalonSRX implements MotorIO {
    private TalonSRX motor;
    
    public MotorIOTalonSRX(int id){
        motor = new TalonSRX(id);
        motor.configFactoryDefault();
        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); //only one perevery two motors so hsould all this be done on left and right motor groups and iff so would it need seperate pid for each

        motor.config_kP(0, 1, 0);
		motor.config_kI(0, 0, 0);
		motor.config_kD(0, 0, 0);
        motor.config_kF(0, 0, 0);

        motor.setInverted(false); // make sure red -> red and black -> black
        motor.setSensorPhase(true); // if this need to be switched you will know run robot look at advantage scope
        motor.setSelectedSensorPosition(motor.getSensorCollection().getPulseWidthPosition(), 0, 0);
    }


    @Override
    public void setVoltage(Measure<Voltage> volts) {
        motor.set(TalonSRXControlMode.PercentOutput, volts.in(Volts) / 12);
    }

    // @Override
    // public void setPosition(Measure<Angle> degress){
    //     motor.set(TalonSRXControlMode.Position, degress.in(Rotations));
    // }

    @Override
    public void setVelocity(Measure<Velocity<Distance>> speed){ 
        motor.set(TalonSRXControlMode.Velocity, speed.in(MetersPerSecond));
        
    }
    @Override
    public Measure<Angle> getSensorPosition(){
        return Rotations.of(motor.getSelectedSensorPosition() / 4096);
    }

     @Override
    public Measure<Velocity<Angle>> getSensorVelocity(){
        return RotationsPerSecond.of((motor.getSelectedSensorVelocity() / 4096) * 10);
    }

    @Override
    public void updateInputs(MotorIOInputs inputs) {
        inputs.motorCurrent = motor.getStatorCurrent();
        inputs.motorVoltage = motor.getBusVoltage();
        inputs.motorPosition = motor.getSelectedSensorPosition();
        inputs.motorVelocity = motor.getSelectedSensorVelocity();
        inputs.motorTemperature = motor.getTemperature();
    }
}