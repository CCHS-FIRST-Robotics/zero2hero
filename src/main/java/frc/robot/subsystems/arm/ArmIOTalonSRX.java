package frc.robot.subsystems.arm;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class ArmIOTalonSRX implements ArmIO {
    private TalonSRX motor;
    
    public ArmIOTalonSRX(int id){
        motor = new TalonSRX(id);
    }

    

    @Override
    public void setPosition(double radians){
        double revolutions = radians / (2 * Math.PI); // Convert radians to revolutions
        double targetPosition = motor.getSelectedSensorPosition() + (revolutions * Constants.ticksPerRevolution);
        motor.set(TalonSRXControlMode.Position, targetPosition); // ! not in radians
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