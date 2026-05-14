package c.c.b.h;

import android.net.Uri;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1774c;
    public final String d;

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b7, code lost:
    
        r3[r8] = (byte) r5;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f5, code lost:
    
        r3[r8] = (short) r5;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012a, code lost:
    
        r3[r9] = r6;
        r2 = r2 + 1;
     */
    static {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.b.h.a.<clinit>():void");
    }

    public a(String str) {
        this.f1772a = b(str, "apiKey");
        this.f1773b = b(str, "oobCode");
        String strB = b(str, "mode");
        this.f1774c = strB;
        if (this.f1772a == null || this.f1773b == null || strB == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        b(str, "continueUrl");
        b(str, "languageCode");
        this.d = b(str, "tenantId");
    }

    public static a a(String str) {
        c.c.a.a.c.l.q.d(str);
        try {
            return new a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String b(String str, String str2) {
        Uri uri = Uri.parse(str);
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return uri.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(uri.getQueryParameter("link")).getQueryParameter(str2);
            }
            return null;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
