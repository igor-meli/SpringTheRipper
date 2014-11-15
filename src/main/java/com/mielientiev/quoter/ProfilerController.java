package com.mielientiev.quoter;

public class ProfilerController implements ProfilerControllerMBean {

    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
