package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.driveTrain;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class followAprilTag extends Command {
    private final driveTrain m_driveTrain;
    private final NetworkTable networkTable;
    private final double driveSpeed = 0.6;
    private final double turnSpeed = 0.3;

    public followAprilTag(driveTrain DRIVETRAIN) {
        m_driveTrain = DRIVETRAIN;
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        networkTable = inst.getTable("SmartDashboard");
        addRequirements(DRIVETRAIN);
    }

    @Override
    public void execute() {
        double tagID = networkTable.getEntry("tagID").getDouble(0);
        double[] tagPose = networkTable.getEntry("tagPose").getDoubleArray(new double[3]);

        if (tagPose.length >= 3) {
            double x = tagPose[0];
            double y = tagPose[1];
            double z = tagPose[2];

            System.out.println("tagID: " + (int)tagID);
            System.out.println("tag pose: x=" + x + ", y=" + y + ", z=" + z);

            //control logic only using pose of x val
            if (x < 0) {
                m_driveTrain.drive(driveSpeed, turnSpeed);
            } else if (x > 0) {
                m_driveTrain.drive(driveSpeed, -turnSpeed);
            } else {
                m_driveTrain.drive(0, 0);
            }
        }
    }

}
