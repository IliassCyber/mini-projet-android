package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class zzg {
    public static boolean zza(int i, DriveId driveId) {
        if (i == 1) {
            return driveId != null;
        }
        switch (i) {
            case 4:
                if (driveId == null) {
                }
                break;
            case 5:
            case 6:
                if (driveId != null) {
                }
                break;
        }
        return false;
    }
}
