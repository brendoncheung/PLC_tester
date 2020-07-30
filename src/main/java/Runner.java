import components.CB20.CB20;
import components.CB20.CB20Keys;
import components.MS.MS;
import components.MS.MSKeys;
import components.testBox.TestBox;
import components.testBox.TestBoxKeys;
import triggers.Release.Release;
import triggers.Restraint.Restraint;
import triggers.Restraint.RestraintKey;
import triggers.Time.Time;
import triggers.Time.TimeKeys;
import triggers.limitswitch.LimitSwitch;
import triggers.limitswitch.LimitSwitchKeys;
import interfaces.State;
import interfaces.Trigger;

public class Runner {

    // initialize triggers
    private final Trigger LS1 = new LimitSwitch(LimitSwitchKeys.LS1);
    private final Trigger LS2 = new LimitSwitch(LimitSwitchKeys.LS2);
    private final Trigger release = new Release();
    private final Trigger restraint = new Restraint();
    private final Trigger time = new Time();

    // initialize systems under test
    private final State mTestBox = new TestBox();
    private final State ms = new MS();
    private final State cb20 = new CB20();

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.runTest();
    }

    public void runTest() {

        // powering the test box on
        mTestBox.setInitialState();
        ms.setInitialState();
        cb20.setInitialState();

        // Trigger: toggle LS1 to HIGH
        log("***LS1 ON***", false);
        log("***LS2 ON***", false);
        LS1.getTriggers().put(LimitSwitchKeys.TOGGLE_ON, true);
        cb20.changeState(LS1);
        mTestBox.changeState(LS1);

        // Check condition
        log("CB20: Red light should be flashing", cb20.getStates().get(TestBoxKeys.RED_LIGHT_FLASH)); // true
        log("CB20: Alarm beeps", cb20.getStates().get(CB20Keys.ALARM_BEEP)); // true
        log("Testbox: Red light should be flashing", mTestBox.getStates().get(TestBoxKeys.RED_LIGHT_FLASH)); // true

        // Trigger: LS1 is HIGH, press "RESTRAIN" button
        log("***LS1 HIGH, RESTRAIN PRESSED***", true);
        restraint.getTriggers().put(RestraintKey.RESTRAINT_PRESSED, true);
        cb20.changeState(restraint);
        ms.changeState(restraint);

        // check condition
        log("CB20: Alarm solid", cb20.getStates().get(CB20Keys.ALARM_SOLID)); // true
        log("M1/S1: Light solid", ms.getStates().get(MSKeys.M1_S1_LIGHT_ON)); // true

        // Trigger: 1.5 seconds lapsed
        log("***1.5 second lapsed***", true);
        time.getTriggers().put(TimeKeys.TIME_1_5_LAPSED, true);
        ms.changeState(time);

        // check condition
        log("M1/S1: Light solid", ms.getStates().get(MSKeys.M1_S1_LIGHT_ON));














    }

    private void log(String s, Object obj) {
        System.out.print(s + ": ");
        System.out.println(obj);
    }
}















