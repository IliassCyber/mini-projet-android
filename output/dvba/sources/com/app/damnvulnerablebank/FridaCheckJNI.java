package com.app.damnvulnerablebank;

/* JADX INFO: loaded from: classes.dex */
public class FridaCheckJNI {
    static {
        System.loadLibrary("frida-check");
    }

    public native int fridaCheck();
}
