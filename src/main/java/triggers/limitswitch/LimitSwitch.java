package triggers.limitswitch;


import interfaces.Trigger;

import java.util.HashMap;

public class LimitSwitch implements Trigger {

    private final HashMap<String, Boolean> mTriggers;
    private final String mName;

    public LimitSwitch(String name) {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(LimitSwitchKeys.TOGGLE_ON, false);
        map.put(LimitSwitchKeys.TOGGLE_OFF, false);
        mName = name;
        mTriggers = map;
    }

    @Override
    public HashMap<String, Boolean> getTriggers() {
        return mTriggers;
    }

    @Override
    public String getName() {
        return mName;
    }
}
