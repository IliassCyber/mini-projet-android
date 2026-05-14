package c.c.a.a.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public final class f extends g {
    public static Resources d(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
