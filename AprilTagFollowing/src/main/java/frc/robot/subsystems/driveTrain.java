package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTrain extends SubsystemBase{
    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;

    private DifferentialDrive driveTrain;

    public driveTrain() {
        leftMotor = new CANSparkMax(1, MotorType.kBrushless);
        rightMotor = new CANSparkMax(2, MotorType.kBrushless);

        leftMotor.setSmartCurrentLimit(20); //current to 20 amps max (idk if this is true  ppl say 80... thats a lot)
        rightMotor.setSmartCurrentLimit(20);

        driveTrain = new DifferentialDrive(leftMotor, rightMotor);
    }

    public void drive(double speed, double rotation) {
        driveTrain.arcadeDrive(speed, rotation);
    }
}
