package frc.robot.subsystems.Motors;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import frc.robot.Constants;

import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class MotorsRight implements MotorIO{
    CANSparkMax Cim1, Cim2;
    RelativeEncoder encoder;
    private final MotorIOInputs inputs = new MotorIOInputs();
    

    public MotorsRight(){
        Cim1 = new CANSparkMax(Constants.RIGHT_ID_1, MotorType.kBrushed);
        Cim2 = new CANSparkMax(Constants.RIGHT_ID_2, MotorType.kBrushed);
        encoder = Cim1.getEncoder();

        };






    

    
    public void setVelocity(double RPM){
        Cim1.getPIDController().setReference(RPM, ControlType.kVelocity);
        Cim2.getPIDController().setReference(RPM, ControlType.kVelocity);

       
    }


    public void updateInputs(){
        inputs.Cim1Current = Cim1.getOutputCurrent();
        inputs.Cim1Voltage = Cim1.getBusVoltage();
        inputs.Cim1Position = encoder.getPosition();
        inputs.Cim1Velocity = encoder.getVelocity();
        inputs.Cim1Temperature = Cim1.getMotorTemperature();



        inputs.Cim2Current = Cim2.getOutputCurrent();
        inputs.Cim2Voltage = Cim2.getBusVoltage();
        inputs.Cim2Position = encoder.getPosition();
        inputs.Cim2Velocity = encoder.getVelocity();
        inputs.Cim2Temperature = Cim2.getMotorTemperature();
    }


    public double distanceTraveled(){
        double counts = encoder.getPosition();
        double whellciqumference = Constants.Wheel_Diameter * Math.PI;
        double revolutions = counts * encoder.getCountsPerRevolution();
        return whellciqumference * revolutions;

    }



    
    public void resetDistanceTraveled(){
        encoder.setPosition(0);
    }



}


    
    


