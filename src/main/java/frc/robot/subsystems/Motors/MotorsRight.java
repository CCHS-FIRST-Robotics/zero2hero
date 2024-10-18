package frc.robot.subsystems.Motors;

import static edu.wpi.first.units.Units.*;



import edu.wpi.first.units.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class MotorsRight extends SubsystemBase{

    private final MotorIOTalonSRX motor1IO = new MotorIOTalonSRX(Constants.RIGHT_ID_1);
    private final MotorIOTalonSRX motor2IO = new MotorIOTalonSRX(Constants.RIGHT_ID_2);
    private final Motor Cim1 = new Motor(motor1IO, "RightMotor1");
    private final Motor Cim2 = new Motor(motor2IO, "RightMotor2");

    

    public MotorsRight(){
        
        };



    @Override
    public void periodic() {
        Cim1.updateInputs();
        Cim2.updateInputs();
        }

    public void setVoltage(Measure<Voltage> volts){
        Cim1.setVoltage(volts);
        Cim2.setVoltage(volts);

    }

    public void setVelocity(Measure<Velocity<Distance>> velocity){
        Cim1.setVelocity(velocity);
        Cim2.setVelocity(velocity);
    }
    


    


    public Measure<Distance> distanceTraveled(){
        Measure<Angle> Rotations = Cim1.getSensorPosition();
        Measure<Distance> whellciqumference = Constants.Wheel_Diameter.times(Math.PI);
        Measure <Distance> metersTraveled = Meters.of(Rotations.in(Rotation) * whellciqumference.in(Meters));
        return metersTraveled;

    }


}




    
    


