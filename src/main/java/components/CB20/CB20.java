package components.CB20;

import components.testBox.TestBoxKeys;
import interfaces.State;
import interfaces.Trigger;
import triggers.Restraint.RestraintKey;
import triggers.limitswitch.LimitSwitchKeys;

import java.util.HashMap;

public class CB20 implements State {

    private final HashMap<String, Boolean> mStates;

    public CB20() {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(CB20Keys.RED_LIGHT_FLASH, false);
        map.put(CB20Keys.GREEN_LIGHT_FLASH, false);
        map.put(CB20Keys.ALARM_BEEP, false);
        map.put(CB20Keys.ALARM_SOLID, false);
        mStates = map;
    }

    @Override
    public void changeState(Trigger trigger) {

        switch (trigger.getName()) {
            case LimitSwitchKeys.LS1 :
                if(trigger.getTriggers().get(LimitSwitchKeys.TOGGLE_ON) &&
                        trigger.getName().equals(LimitSwitchKeys.LS1)) {
                    mStates.put(CB20Keys.RED_LIGHT_FLASH, true);
                    mStates.put(CB20Keys.ALARM_BEEP, true);
                    // need to remember LS1 is on
                    mStates.put(CB20Keys.LS1_HELD_HIGH, true);
                }
                break;

            case RestraintKey.NAME :
                if(trigger.getTriggers().get(RestraintKey.RESTRAINT_PRESSED) &&
                        mStates.get(CB20Keys.LS1_HELD_HIGH)) {
                    mStates.put(CB20Keys.ALARM_SOLID, true);
                }
                break;
        }

    }

    @Override
    public void setInitialState() {
        mStates.put(CB20Keys.ALARM_BEEP, true);
        mStates.put(CB20Keys.RED_LIGHT_FLASH, true);
    }

    @Override
    public HashMap<String, Boolean> getStates() {
        return mStates;
    }
}
