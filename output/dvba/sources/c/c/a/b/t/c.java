package c.c.a.b.t;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import c.c.a.a.c.l.q;

/* JADX INFO: loaded from: classes.dex */
public interface c {

    public static class b implements TypeEvaluator<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f1675b = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f1676a = new e(null);

        @Override // android.animation.TypeEvaluator
        public e evaluate(float f, e eVar, e eVar2) {
            e eVar3 = eVar;
            e eVar4 = eVar2;
            e eVar5 = this.f1676a;
            float fL = q.L(eVar3.f1679a, eVar4.f1679a, f);
            float fL2 = q.L(eVar3.f1680b, eVar4.f1680b, f);
            float fL3 = q.L(eVar3.f1681c, eVar4.f1681c, f);
            eVar5.f1679a = fL;
            eVar5.f1680b = fL2;
            eVar5.f1681c = fL3;
            return this.f1676a;
        }
    }

    /* JADX INFO: renamed from: c.c.a.b.t.c$c, reason: collision with other inner class name */
    public static class C0063c extends Property<c, e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, e> f1677a = new C0063c("circularReveal");

        public C0063c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        public e get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        public void set(c cVar, e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    public static class d extends Property<c, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, Integer> f1678a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f1679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1681c;

        public e() {
        }

        public e(float f, float f2, float f3) {
            this.f1679a = f;
            this.f1680b = f2;
            this.f1681c = f3;
        }

        public e(a aVar) {
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);
}
