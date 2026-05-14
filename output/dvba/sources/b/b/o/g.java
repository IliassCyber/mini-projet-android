package b.b.o;

import android.view.View;
import android.view.animation.Interpolator;
import b.i.m.q;
import b.i.m.r;
import b.i.m.s;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f338c;
    public r d;
    public boolean e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f337b = -1;
    public final s f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<q> f336a = new ArrayList<>();

    public class a extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f339a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f340b = 0;

        public a() {
        }

        @Override // b.i.m.r
        public void a(View view) {
            int i = this.f340b + 1;
            this.f340b = i;
            if (i == g.this.f336a.size()) {
                r rVar = g.this.d;
                if (rVar != null) {
                    rVar.a(null);
                }
                this.f340b = 0;
                this.f339a = false;
                g.this.e = false;
            }
        }

        @Override // b.i.m.s, b.i.m.r
        public void b(View view) {
            if (this.f339a) {
                return;
            }
            this.f339a = true;
            r rVar = g.this.d;
            if (rVar != null) {
                rVar.b(null);
            }
        }
    }

    public void a() {
        if (this.e) {
            Iterator<q> it = this.f336a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    public void b() {
        View view;
        if (this.e) {
            return;
        }
        for (q qVar : this.f336a) {
            long j = this.f337b;
            if (j >= 0) {
                qVar.c(j);
            }
            Interpolator interpolator = this.f338c;
            if (interpolator != null && (view = qVar.f846a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.d != null) {
                qVar.d(this.f);
            }
            View view2 = qVar.f846a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
