package interfaces;

import java.util.HashMap;

public interface State{
    void changeState(Trigger trigger);
    HashMap<String, Boolean> getStates();
    void setInitialState();
}
