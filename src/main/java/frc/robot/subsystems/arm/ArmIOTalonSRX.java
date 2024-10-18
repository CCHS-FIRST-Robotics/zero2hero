package frc.robot.subsystems.arm;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Measure;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class ArmIOTalonSRX implements ArmIO {
    private TalonSRX motor;
    
    public ArmIOTalonSRX(int id){
        motor = new TalonSRX(id);
    }

    

    @Override
    public void setPosition(Measure<Angle> radians){
        
    }

    // public void setVelocity(double velocity){
    //     motor.set(TalonSRXControlMode.Velocity, velocity);
    // }

    @Override
    public void updateInputs(ArmIOInputs inputs) {
        inputs.motorCurrent = motor.getStatorCurrent();
        inputs.motorVoltage = motor.getBusVoltage();
        inputs.motorPosition = motor.getSelectedSensorPosition();
        inputs.motorVelocity = motor.getSelectedSensorVelocity();
        inputs.motorTemperature = motor.getTemperature();
    }
}