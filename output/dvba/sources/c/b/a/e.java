package c.b.a;

import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1256a = "amazing".length();

    public static String a(String str) {
        return c(new String(Base64.decode(str, 0)));
    }

    public static String b(String str) {
        return Base64.encodeToString(c(str).getBytes(), 0);
    }

    public static String c(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            str2 = str2 + ((char) (str.charAt(i) ^ "amazing".charAt(i % f1256a)));
        }
        return str2;
    }
}
