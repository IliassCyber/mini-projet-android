package c.c.b.h.c0.a;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Callable<c<t0>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0 f1800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1801b;

    public j0(t0 t0Var, Context context) {
        this.f1800a = t0Var;
        this.f1801b = context;
    }

    public final c.c.a.a.c.k.c<t0> a(boolean z, Context context) {
        t0 t0Var = (t0) this.f1800a.clone();
        t0Var.f1782b = z;
        return new d(context, s0.f1812c, t0Var, new c.c.b.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0104 A[Catch: all -> 0x0139, TRY_LEAVE, TryCatch #4 {all -> 0x0139, blocks: (B:16:0x0031, B:56:0x00d7, B:58:0x00dd, B:67:0x0104, B:61:0x00e3, B:63:0x00f5, B:65:0x00ff, B:64:0x00fa, B:81:0x0138, B:17:0x0032, B:19:0x0036, B:20:0x004e, B:54:0x00d4, B:39:0x00a0, B:47:0x00ac, B:55:0x00d6, B:53:0x00b2), top: B:93:0x0031, inners: #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c.c.b.h.c0.a.c<c.c.b.h.c0.a.t0> call() {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.b.h.c0.a.j0.call():java.lang.Object");
    }
}
