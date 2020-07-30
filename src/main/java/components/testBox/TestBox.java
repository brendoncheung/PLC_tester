package components.testBox;

import triggers.limitswitch.LimitSwitchKeys;
import interfaces.State;
import interfaces.Trigger;
import java.util.HashMap;

public class TestBox implements State {

    private final HashMap<String, Boolean> mStates;

    public TestBox () {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(TestBoxKeys.RED_LIGHT_FLASH, false);
        map.put(TestBoxKeys.GREEN_LIGHT_FLASH, false);
        mStates = map;
    }

    @Override
    public void changeState(Trigger trigger) {
        switch(trigger.getName()) {

            case LimitSwitchKeys.LS1 :
                if(trigger.getTriggers().get(LimitSwitchKeys.TOGGLE_ON)) {
                    mStates.put(TestBoxKeys.RED_LIGHT_FLASH, true);
                    mStates.put(TestBoxKeys.GREEN_LIGHT_FLASH, false);
                }
                break;

            case LimitSwitchKeys.LS2 :
                if(trigger.getTriggers().get(LimitSwitchKeys.TOGGLE_ON)) {
                    mStates.put(TestBoxKeys.RED_LIGHT_FLASH, false);
                    mStates.put(TestBoxKeys.GREEN_LIGHT_FLASH, true);
                }
                break;

        }
    }

    @Override
    public void setInitialState() {
    }

    @Override
    public HashMap<String, Boolean> getStates() {
        return mStates;
    }

}
