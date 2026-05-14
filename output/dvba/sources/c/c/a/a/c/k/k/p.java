package c.c.a.a.c.k.k;

import android.os.Handler;
import c.c.a.a.c.k.k.b;

/* JADX INFO: loaded from: classes.dex */
public final class p implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1336a;

    public p(d dVar) {
        this.f1336a = dVar;
    }

    @Override // c.c.a.a.c.k.k.b.a
    public final void a(boolean z) {
        Handler handler = this.f1336a.m;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
