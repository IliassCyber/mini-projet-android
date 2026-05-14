package b.d;

import b.d.e;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CharSequence f563c;
    public final /* synthetic */ e.a d;

    public f(e.a aVar, int i, CharSequence charSequence) {
        this.d = aVar;
        this.f562b = i;
        this.f563c = charSequence;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.a(this.f562b, this.f563c);
        e.this.a0();
    }
}
