package b.l.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class i<E> extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f908c;
    public final Handler d;
    public final int e;
    public final k f;

    public i(e eVar) {
        Handler handler = new Handler();
        this.f = new k();
        this.f907b = eVar;
        a.a.a.a.a.h(eVar, "context == null");
        this.f908c = eVar;
        a.a.a.a.a.h(handler, "handler == null");
        this.d = handler;
        this.e = 0;
    }
}
