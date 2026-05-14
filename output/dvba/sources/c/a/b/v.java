package c.a.b;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1221a = Log.isLoggable("Volley", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1222b = v.class.getName();

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final boolean f1223c = v.f1221a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C0050a> f1224a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1225b = false;

        /* JADX INFO: renamed from: c.a.b.v$a$a, reason: collision with other inner class name */
        public static class C0050a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f1226a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f1227b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f1228c;

            public C0050a(String str, long j, long j2) {
                this.f1226a = str;
                this.f1227b = j;
                this.f1228c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (this.f1225b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f1224a.add(new C0050a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            long j;
            this.f1225b = true;
            if (this.f1224a.size() == 0) {
                j = 0;
            } else {
                j = this.f1224a.get(r1.size() - 1).f1228c - this.f1224a.get(0).f1228c;
            }
            if (j <= 0) {
                return;
            }
            long j2 = this.f1224a.get(0).f1228c;
            v.b("(%-4d ms) %s", Long.valueOf(j), str);
            for (C0050a c0050a : this.f1224a) {
                long j3 = c0050a.f1228c;
                v.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c0050a.f1227b), c0050a.f1226a);
                j2 = j3;
            }
        }

        public void finalize() {
            if (this.f1225b) {
                return;
            }
            b("Request on the loose");
            v.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClassName().equals(f1222b)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        Log.d("Volley", a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e("Volley", a(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        if (f1221a) {
            Log.v("Volley", a(str, objArr));
        }
    }
}
