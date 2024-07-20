package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.kinematics.*;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;

public class Drive extends SubsystemBase{
    DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.TRACK_WIDTH);
    TalonFX l1, l2, r1, r2;

    public Drive(int l1Id, int l2Id, int r1Id, int r2Id){
        l1 = new TalonFX(l1Id);
        l2 = new TalonFX(l2Id);
        r1 = new TalonFX(r1Id);
        r2 = new TalonFX(r2Id);
    }

    public void setVelocity(ChassisSpeeds speeds){
        DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(speeds);

        double lVelocity = wheelSpeeds.leftMetersPerSecond;
        double rVelocity = wheelSpeeds.rightMetersPerSecond;

        l1.set(lVelocity);
        l2.set(lVelocity);
        r1.set(rVelocity);
        r2.set(rVelocity);
    }
}