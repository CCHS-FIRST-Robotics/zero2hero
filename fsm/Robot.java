public class Robot extends TimedRobot{
  
    final static int SPEEDUP_COUNT = 3000 / Main.INTERVAL;
    final static int HOLD_COUNT = 1000 / Main.INTERVAL;
    final static int SLOWDOWN_COUNT = 2000 / Main.INTERVAL;
    
    public enum State {IDLE, SPEEDUP, HOLD, SLOWDOWN};
    State m_state;
    int m_counter = 0;

    /** Called once at the beginning of the robot program. */
    public Robot() {
        m_state = State.SPEEDUP;
        m_counter = SPEEDUP_COUNT;
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
                System.out.println("IDLE");
                break;

            case SPEEDUP:
                System.out.println("SPEEDUP");

                if (m_counter == 0)
                {
                    m_state = State.HOLD;
                    m_counter = HOLD_COUNT;
                }
                else m_counter--;
                break;

            case HOLD:
                System.out.println("HOLD");
                if (m_counter == 0)
                {
                    m_state = State.SLOWDOWN;
                    m_counter = SLOWDOWN_COUNT;
                }
                else m_counter--; 
                break;

            case SLOWDOWN:
                System.out.println("SLOWDOWN");
                if (m_counter == 0)
                {
                    m_state = State.IDLE;
                }
                else m_counter--; 
                break;
        }

    }

    /** The teleop periodic function is called every control packet in teleop. */
    @Override
    public void teleopPeriodic() {
        System.out.println("Teleop" + System.currentTimeMillis());

    }
}