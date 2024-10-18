package frc.robot.subsystems.Motors;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.units.Angle;
import edu.wpi.first.units.Measure;

import static edu.wpi.first.units.Units.Rotation;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class MotorIOTalonSRX implements MotorIO {
    private TalonSRX motor;
    
    public MotorIOTalonSRX(int id){
        motor = new TalonSRX(id);
    }

    @Override
    public void setVoltage(double volts) {
        motor.set(TalonSRXControlMode.PercentOutput, volts / 12);
    }

    @Override
    public void setPosition(double radians){
        motor.set(TalonSRXControlMode.Position, motor.getSelectedSensorPosition() + radians); // ! not in radians
    }

    public void setVelocity(double velocity){
        motor.set(TalonSRXControlMode.Velocity, velocity);
    }
    @Override
    public Measure<Angle> getSensorPosition(){
        return Rotations.of(motor.getSelectedSensorPosition() / 4096);
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