package frc.robot;

//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
//import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ControlWJoysticks;
import frc.robot.subsystems.driveTrain;

public class RobotContainer {

  private final CommandXboxController controller = new CommandXboxController(0);
  driveTrain DRIVETRAIN = new driveTrain();
  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    DRIVETRAIN.setDefaultCommand(
      new ControlWJoysticks(
          DRIVETRAIN,
          () -> controller.getLeftX(),
          () -> controller.getLeftY(),
          () -> controller.getRightX(),
          () -> controller.getRightY()
      )
  );
  }
}
