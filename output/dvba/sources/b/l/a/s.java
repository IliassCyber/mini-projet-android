package b.l.a;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f948b;

    public s(ArrayList arrayList) {
        this.f948b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.o(this.f948b, 4);
    }
}
