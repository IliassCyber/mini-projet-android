package b.b.k;

import android.os.Build;
import android.view.View;
import b.i.m.u;

/* JADX INFO: loaded from: classes.dex */
public class l implements b.i.m.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f272a;

    public l(k kVar) {
        this.f272a = kVar;
    }

    @Override // b.i.m.j
    public b.i.m.u a(View view, b.i.m.u uVar) {
        int iD = uVar.d();
        int iN = this.f272a.N(uVar, null);
        if (iD != iN) {
            int iB = uVar.b();
            int iC = uVar.c();
            int iA = uVar.a();
            u.c bVar = Build.VERSION.SDK_INT >= 29 ? new u.b(uVar) : new u.a(uVar);
            bVar.c(b.i.f.b.a(iB, iN, iC, iA));
            uVar = bVar.a();
        }
        return b.i.m.l.L(view, uVar);
    }
}
