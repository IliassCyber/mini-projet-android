package c.c.a.a.c.p;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f1419b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f1420a = null;

    public static a a(Context context) {
        a aVar;
        b bVar = f1419b;
        synchronized (bVar) {
            if (bVar.f1420a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                bVar.f1420a = new a(context);
            }
            aVar = bVar.f1420a;
        }
        return aVar;
    }
}
