package triggers.Release;

import interfaces.Trigger;

import java.util.HashMap;

public class Release implements Trigger {

    private final HashMap<String, Boolean> mState;

    public Release() {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(ReleaseKey.RELEASE_PRESSED, false);
        mState = map;
    }

    @Override
    public HashMap<String, Boolean> getTriggers() {
        return mState;
    }

    @Override
    public String getName() {
        return ReleaseKey.NAME;
    }
}
