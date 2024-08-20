package frc.robot.subsystems.Motors;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import frc.robot.Constants;


import com.revrobotics.CANSparkLowLevel.MotorType;

public class MotorsRight implements MotorIO{
    CANSparkMax Cim1, Cim2;
    RelativeEncoder encoder;
    private final MotorIOInputs inputs = new MotorIOInputs();
    

    public MotorsRight(int cim_1_id, int cim_2_id){
        Cim1 = new CANSparkMax(cim_1_id, MotorType.kBrushed);
        Cim2 = new CANSparkMax(cim_2_id, MotorType.kBrushed);
        encoder = Cim1.getEncoder();

        };






    

    public void setVoltage(double volts){
        Cim1.setVoltage(volts);
        Cim2.setVoltage(volts);
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





}


    
    


