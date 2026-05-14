package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbl {
    private static MessageDigest zzrK = null;
    protected Object zzqt = new Object();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected MessageDigest zzcu() {
        synchronized (this.zzqt) {
            if (zzrK != null) {
                return zzrK;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzrK = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                }
            }
            return zzrK;
        }
    }

    abstract byte[] zzy(String str);
}
