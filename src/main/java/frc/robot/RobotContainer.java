// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.commands.*;
import frc.robot.subsystems.Drive.Drive;
import frc.robot.subsystems.arm.Arm;
import frc.robot.subsystems.arm.ArmIOTalonSRX;


public class RobotContainer {
    CommandXboxController controller = new CommandXboxController(Constants.CONTROLLER_PORT);
    ArmIOTalonSRX io = new ArmIOTalonSRX(Constants.ARM_ID);
    Arm Arm = new Arm(io);
    Drive drive = new Drive();

    public RobotContainer() {
      configureBindings();
    }

    private void configureBindings() {
        // joystick controls
        drive.setDefaultCommand(
            new DriveWithJoysticks(
                drive,
                () -> controller.getLeftY(),
                () -> controller.getRightX()
            )
        );

        controller.x().onTrue(new InstantCommand(() -> Arm.setPosition(Units.degreesToRadians(10))));
        
    }
}












