package components.MS;

import interfaces.State;
import interfaces.Trigger;
import triggers.Restraint.RestraintKey;
import triggers.Release.ReleaseKey;
import triggers.Time.TimeKeys;

import java.util.HashMap;

public class MS implements State {

    private HashMap<String, Boolean> mStates;

    public MS() {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(MSKeys.M1_S1_LIGHT_ON, false);
        map.put(MSKeys.M2_S2_LIGHT_ON,false);
        mStates = map;
    }

    @Override
    public void changeState(Trigger trigger) {

        switch (trigger.getName()) {

            case RestraintKey.NAME:
                mStates.put(MSKeys.M2_S2_LIGHT_ON, false);
                mStates.put(MSKeys.M1_S1_LIGHT_ON, true);
                break;

            case ReleaseKey.NAME:
                mStates.put(MSKeys.M2_S2_LIGHT_ON, true);
                mStates.put(MSKeys.M1_S1_LIGHT_ON, false);
                break;

            case TimeKeys.TIME_NAME:
                if(mStates.get(MSKeys.M1_S1_LIGHT_ON)) {
                    mStates.put(MSKeys.M1_S1_LIGHT_ON, false);
                }
                if(mStates.get(MSKeys.M2_S2_LIGHT_ON)) {
                    mStates.put(MSKeys.M2_S2_LIGHT_ON, false);
                }
                break;
        }
    }

    @Override
    public HashMap<String, Boolean> getStates() {
        return mStates;
    }

    @Override
    public void setInitialState() {
        // no default initial state
    }
}
