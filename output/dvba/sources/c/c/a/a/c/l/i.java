package c.c.a.a.c.l;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1387b;

    public i(String str, String str2) {
        q.g(str, "log tag cannot be null");
        Object[] objArr = {str, 23};
        if (!(str.length() <= 23)) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
        this.f1386a = str;
        if (str2 == null || str2.length() <= 0) {
            this.f1387b = null;
        } else {
            this.f1387b = str2;
        }
    }

    public final boolean a(int i) {
        return Log.isLoggable(this.f1386a, i);
    }
}
