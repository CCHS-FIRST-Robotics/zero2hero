package frc.robot.subsystems.Motors;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class MotorsLeft extends SubsystemBase{
    RelativeEncoder encoder;
    private final MotorIOTalonSRX motor1IO = new MotorIOTalonSRX(Constants.LEFT_ID_1);
    private final MotorIOTalonSRX motor2IO = new MotorIOTalonSRX(Constants.LEFT_ID_2);
    private final Motor Cim1 = new Motor(motor1IO);
    private final Motor Cim2 = new Motor(motor2IO);
    

    public MotorsLeft(){
       
        //encoder = Cim1.getEncoder();
        
        };



    @Override
    public void periodic() {
        Cim1.updateInputs();
        Cim2.updateInputs();
        }

    public void setVoltage(double volts){
        Cim1.setVoltage(volts);
        Cim2.setVoltage(volts);

    }

    public void setVelocity(double velocity){
        Cim1.setVelocity(velocity);
        Cim2.setVelocity(velocity);
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




    
    


