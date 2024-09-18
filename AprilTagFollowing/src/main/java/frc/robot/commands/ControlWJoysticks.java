package frc.robot.commands;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.driveTrain;

public class ControlWJoysticks extends Command{
    Supplier<Double> leftXSupplier;
    Supplier<Double> leftYSupplier;
    Supplier<Double> rightXSupplier;
    Supplier<Double> rightYSupplier;
    private final driveTrain m_driveTrain;

    public ControlWJoysticks (driveTrain DRIVETRAIN, Supplier<Double> leftXSupplier, Supplier<Double> leftYSupplier, Supplier<Double> rightXSupplier, Supplier<Double> rightYSupplier) {
           m_driveTrain = DRIVETRAIN;
           this.leftXSupplier = leftXSupplier;
           this.leftYSupplier = leftYSupplier;
           this.rightXSupplier = rightXSupplier;
           this.rightYSupplier = rightYSupplier;
           addRequirements(DRIVETRAIN);
    }

    @Override
    public void execute() {
        double leftX = leftXSupplier.get();
        double leftY = leftYSupplier.get();
        double rightX = rightXSupplier.get();
        double rightY = rightYSupplier.get();

        m_driveTrain.drive(leftY, leftX);
    }
    
}