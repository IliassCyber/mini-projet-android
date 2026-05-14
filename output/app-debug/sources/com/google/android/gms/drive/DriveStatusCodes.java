package com.google.android.gms.drive;

import com.google.android.gms.common.api.CommonStatusCodes;

/* JADX INFO: loaded from: classes.dex */
public final class DriveStatusCodes extends CommonStatusCodes {
    public static final int DRIVE_CONTENTS_TOO_LARGE = 1508;

    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int DRIVE_RATE_LIMIT_EXCEEDED = 1507;
    public static final int DRIVE_RESOURCE_NOT_AVAILABLE = 1502;

    private DriveStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        return i != 1500 ? i != 1502 ? i != 1507 ? CommonStatusCodes.getStatusCodeString(i) : "DRIVE_RATE_LIMIT_EXCEEDED" : "DRIVE_RESOURCE_NOT_AVAILABLE" : "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    }
}
