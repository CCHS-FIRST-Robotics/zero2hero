public class Robot extends TimedRobot{
  
    final static int IDLE_COUNT = 3000 / Main.INTERVAL;
    final static int HOLD_COUNT = 1000 / Main.INTERVAL;
    final static int MAX_SPEED = 150;
    public static int RoboSpeed = 0;
    
    public enum State {IDLE, SPEEDUP, HOLD, SLOWDOWN};
    State m_state;
    int m_counter = 0;

    /** Called once at the beginning of the robot program. */
    public Robot() {
        m_state = State.IDLE;
        m_counter = IDLE_COUNT;
        System.out.println("m_counter"+ m_counter);
    }

    /*
    * The RobotPeriodic function is called every control packet no matter the
    * robot mode.
    */
    @Override
    public void robotPeriodic() {

        System.out.println("Robot executed at: " + System.currentTimeMillis());

        switch(m_state) {
            case IDLE: 
                System.out.println("SPEED: " + RoboSpeed + " IDLE");
                if (m_counter == 0)
                {
                    m_state = State.SPEEDUP;
                }
                else m_counter--;
                break;

            case SPEEDUP:
                System.out.println("SPEED: " + RoboSpeed + " SPEEDUP");
                if (RoboSpeed < MAX_SPEED)
                    RoboSpeed++;
                else
                {
                    m_state = State.HOLD;
                    m_counter = HOLD_COUNT;
                }

                break;

            case HOLD:
                System.out.println("SPEED: " + RoboSpeed + " HOLD");
                if (m_counter == 0)
                {
                    m_state = State.SLOWDOWN;
                }
                else m_counter--;
                break;

            case SLOWDOWN:
                System.out.println("SPEED: " + RoboSpeed + " SLOWDOWN");
                if (RoboSpeed > 0)
                    RoboSpeed--;
                else 
                {
                    m_state = State.IDLE;
                    m_counter = IDLE_COUNT;
                }
                break;
        }

    }

    /** The teleop periodic function is called every control packet in teleop. */
    @Override
    public void teleopPeriodic() {
        System.out.println("Teleop" + System.currentTimeMillis());

    }
}