package c.c.a.a.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import javax.annotation.CheckReturnValue;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f1292a;

    public h(Context context) {
        context.getApplicationContext();
    }

    public static t a(PackageInfo packageInfo, t... tVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        u uVar = new u(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < tVarArr.length; i++) {
            if (tVarArr[i].equals(uVar)) {
                return tVarArr[i];
            }
        }
        return null;
    }

    public static boolean b(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? a(packageInfo, w.f1426a) : a(packageInfo, w.f1426a[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
