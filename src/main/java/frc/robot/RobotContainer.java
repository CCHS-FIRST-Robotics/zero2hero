// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.commands.*;
import frc.robot.subsystems.drive.*;

public class RobotContainer {
    CommandXboxController controller = new CommandXboxController(Constants.CONTROLLER_PORT);

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
    }
}