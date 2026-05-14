package c.c.a.a.c.m;

import android.util.Log;
import c.c.a.a.c.l.i;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1412c;

    public a(String str, String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append(']');
            sb.append(' ');
            string = sb.toString();
        }
        this.f1411b = string;
        this.f1410a = str;
        new i(str, null);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f1410a, i)) {
            i++;
        }
        this.f1412c = i;
    }

    public final String a(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f1411b.concat(str);
    }

    public void b(String str, Object... objArr) {
        Log.i(this.f1410a, a(str, objArr));
    }

    public void c(String str, Object... objArr) {
        if (this.f1412c <= 2) {
            Log.v(this.f1410a, a(str, objArr));
        }
    }
}
