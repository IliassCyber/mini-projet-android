package c.c.a.a.c.o;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f1417b;

    @Nullable
    public static String a() throws Throwable {
        BufferedReader bufferedReaderB;
        if (f1416a == null) {
            if (f1417b == 0) {
                f1417b = Process.myPid();
            }
            int i = f1417b;
            String strTrim = null;
            strTrim = null;
            strTrim = null;
            BufferedReader bufferedReader = null;
            strTrim = null;
            if (i > 0) {
                try {
                    try {
                        StringBuilder sb = new StringBuilder(25);
                        sb.append("/proc/");
                        sb.append(i);
                        sb.append("/cmdline");
                        bufferedReaderB = b(sb.toString());
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    bufferedReaderB = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    strTrim = bufferedReaderB.readLine().trim();
                    bufferedReaderB.close();
                } catch (IOException unused3) {
                    if (bufferedReaderB != null) {
                        bufferedReaderB.close();
                    }
                    f1416a = strTrim;
                    return f1416a;
                } catch (Throwable th2) {
                    bufferedReader = bufferedReaderB;
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            f1416a = strTrim;
        }
        return f1416a;
    }

    public static BufferedReader b(String str) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
