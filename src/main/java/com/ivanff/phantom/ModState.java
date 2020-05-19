package com.ivanff.phantom;

public class ModState {
    private static boolean modEnabled = true;

    public static boolean getEnabled() {
        return modEnabled;
    }

    public static void setEnabled(boolean enabled) {
        modEnabled = enabled;
    }
}