package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.Logger;

public class Arm {
    private ArmIO io;
    private ArmIOInputsAutoLogged inputs = new ArmIOInputsAutoLogged();


public Arm(ArmIO io){
    this.io = io;

}
public void setPosition(double radians){
    io.setPosition(radians);
}

 public void setVelocity(double velocity){
    io.setVelocity(velocity);
 }


 public void updateInputs(){
    io.updateInputs(inputs);
    Logger.processInputs("Arm", inputs);
}
    











}