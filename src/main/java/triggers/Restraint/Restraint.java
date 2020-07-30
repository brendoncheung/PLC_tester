package triggers.Restraint;

import interfaces.Trigger;

import java.util.HashMap;

public class Restraint implements Trigger {

    private final HashMap<String, Boolean> mState;

    public Restraint() {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(RestraintKey.RESTRAINT_PRESSED, false);
        mState = map;
    }

    @Override
    public HashMap<String, Boolean> getTriggers() {
        return mState;
    }

    @Override
    public String getName() {
        return RestraintKey.NAME;
    }
}
