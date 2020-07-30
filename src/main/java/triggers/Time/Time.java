package triggers.Time;

import interfaces.Trigger;

import java.util.HashMap;

public class Time implements Trigger {

    private final HashMap<String, Boolean> mState;

    public Time() {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(TimeKeys.TIME_1_5_LAPSED, false);
        mState = map;
    }

    @Override
    public HashMap<String, Boolean> getTriggers() {
        return mState;
    }

    @Override
    public String getName() {
        return TimeKeys.TIME_1_5_LAPSED;
    }
}
