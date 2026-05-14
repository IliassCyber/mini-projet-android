package b.g.b.i.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.b.i.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b.g.b.i.d> f634a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f635b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b.g.b.i.e f636c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d.a f637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d.a f638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f639c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public boolean j;
    }

    /* JADX INFO: renamed from: b.g.b.i.l.b$b, reason: collision with other inner class name */
    public interface InterfaceC0023b {
    }

    public b(b.g.b.i.e eVar) {
        this.f636c = eVar;
    }

    public final boolean a(InterfaceC0023b interfaceC0023b, b.g.b.i.d dVar, boolean z) {
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.MATCH_CONSTRAINT;
        this.f635b.f637a = dVar.j();
        this.f635b.f638b = dVar.n();
        this.f635b.f639c = dVar.o();
        this.f635b.d = dVar.i();
        a aVar3 = this.f635b;
        aVar3.i = false;
        aVar3.j = z;
        boolean z2 = aVar3.f637a == aVar2;
        boolean z3 = this.f635b.f638b == aVar2;
        boolean z4 = z2 && dVar.N > 0.0f;
        boolean z5 = z3 && dVar.N > 0.0f;
        if (z4 && dVar.l[0] == 4) {
            this.f635b.f637a = aVar;
        }
        if (z5 && dVar.l[1] == 4) {
            this.f635b.f638b = aVar;
        }
        ((ConstraintLayout.b) interfaceC0023b).a(dVar, this.f635b);
        dVar.B(this.f635b.e);
        dVar.w(this.f635b.f);
        a aVar4 = this.f635b;
        dVar.w = aVar4.h;
        int i = aVar4.g;
        dVar.R = i;
        dVar.w = i > 0;
        a aVar5 = this.f635b;
        aVar5.j = false;
        return aVar5.i;
    }

    public final void b(b.g.b.i.e eVar, int i, int i2) {
        int i3 = eVar.S;
        int i4 = eVar.T;
        eVar.z(0);
        eVar.y(0);
        eVar.L = i;
        int i5 = eVar.S;
        if (i < i5) {
            eVar.L = i5;
        }
        eVar.M = i2;
        int i6 = eVar.T;
        if (i2 < i6) {
            eVar.M = i6;
        }
        eVar.z(i3);
        eVar.y(i4);
        this.f636c.E();
    }
}
