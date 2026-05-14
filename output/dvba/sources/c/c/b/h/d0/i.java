package c.c.b.h.d0;

import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c.c.a.a.c.m.a f1844a = new c.c.a.a.c.m.a("GetTokenResultFactory", new String[0]);

    public static c.c.b.h.p a(String str) {
        Map mapB;
        try {
            mapB = k.b(str);
        } catch (c.c.b.h.c0.b e) {
            c.c.a.a.c.m.a aVar = f1844a;
            Log.e(aVar.f1410a, aVar.a("Error parsing token claims", new Object[0]), e);
            mapB = c.c.a.a.f.c.s.h;
        }
        return new c.c.b.h.p(str, mapB);
    }
}
