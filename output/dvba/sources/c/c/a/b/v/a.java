package c.c.a.b.v;

import android.content.Context;
import c.c.a.a.c.l.q;
import c.c.a.b.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1720c;
    public final float d;

    public a(Context context) {
        this.f1718a = q.V(context, b.elevationOverlayEnabled, false);
        this.f1719b = q.x(context, b.elevationOverlayColor, 0);
        this.f1720c = q.x(context, b.colorSurface, 0);
        this.d = context.getResources().getDisplayMetrics().density;
    }
}
