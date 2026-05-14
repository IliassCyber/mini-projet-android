package c.c.a.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import c.c.a.a.c.l.f0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f1288b;

    static {
        int i = g.f1289a;
        f1287a = 12451000;
        f1288b = new e();
    }

    public Intent a(Context context, int i, String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            return f0.b("com.google.android.gms");
        }
        if (context != null && c.c.a.a.c.l.q.J(context)) {
            return f0.c();
        }
        StringBuilder sbE = c.a.a.a.a.e("gcore_");
        sbE.append(f1287a);
        sbE.append("-");
        if (!TextUtils.isEmpty(str)) {
            sbE.append(str);
        }
        sbE.append("-");
        if (context != null) {
            sbE.append(context.getPackageName());
        }
        sbE.append("-");
        if (context != null) {
            try {
                c.c.a.a.c.p.a aVarA = c.c.a.a.c.p.b.a(context);
                sbE.append(aVarA.f1418a.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return f0.a("com.google.android.gms", sbE.toString());
    }

    public int b(Context context) {
        return c(context, f1287a);
    }

    public int c(Context context, int i) {
        int iB = g.b(context, i);
        boolean z = true;
        if (iB != 18) {
            if (iB == 1) {
                try {
                    Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
                            break;
                        }
                        if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                            break;
                        }
                    }
                } catch (PackageManager.NameNotFoundException | Exception unused) {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        if (z) {
            return 18;
        }
        return iB;
    }
}
