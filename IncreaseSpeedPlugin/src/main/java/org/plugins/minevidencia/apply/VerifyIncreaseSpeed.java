package org.plugins.minevidencia.apply;

public class VerifyIncreaseSpeed {

    public VerifyIncreaseSpeed() {
    }

    public boolean isValidSpeedIncrease(int speedIncrease) {
        return speedIncrease <= 4 && speedIncrease >= 0;
    }
}
