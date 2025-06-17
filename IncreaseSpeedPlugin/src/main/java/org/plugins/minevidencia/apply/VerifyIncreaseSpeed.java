package org.plugins.minevidencia.apply;

public class VerifyIncreaseSpeed {

    public VerifyIncreaseSpeed() {}

    public boolean isValidSpeedIncrease(int speedIncrease){
        return speedIncrease <= 0 || speedIncrease > 3;
    }
}
