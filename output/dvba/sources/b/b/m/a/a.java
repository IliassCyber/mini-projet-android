package b.b.m.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import b.b.m.a.b;
import b.b.m.a.d;
import b.f.i;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class a extends b.b.m.a.d implements b.i.f.k.a {
    public c p;
    public g q;
    public int r;
    public int s;
    public boolean t;

    public static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animatable f302a;

        public b(Animatable animatable) {
            super(null);
            this.f302a = animatable;
        }

        @Override // b.b.m.a.a.g
        public void c() {
            this.f302a.start();
        }

        @Override // b.b.m.a.a.g
        public void d() {
            this.f302a.stop();
        }
    }

    public static class c extends d.a {
        public b.f.e<Long> K;
        public i<Integer> L;

        public c(c cVar, a aVar, Resources resources) {
            i<Integer> iVar;
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                iVar = cVar.L;
            } else {
                this.K = new b.f.e<>();
                iVar = new i<>(10);
            }
            this.L = iVar;
        }

        public static long i(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        @Override // b.b.m.a.d.a, b.b.m.a.b.c
        public void e() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public int h(int i, int i2, Drawable drawable, boolean z) {
            int iA = super.a(drawable);
            long jI = i(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = iA;
            this.K.a(jI, Long.valueOf(j2 | j));
            if (z) {
                this.K.a(i(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return iA;
        }

        public int j(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.e(i, 0).intValue();
        }

        public int k(int[] iArr) {
            int iG = super.g(iArr);
            return iG >= 0 ? iG : super.g(StateSet.WILD_CARD);
        }

        @Override // b.b.m.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // b.b.m.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    public static class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.u.a.a.b f303a;

        public d(b.u.a.a.b bVar) {
            super(null);
            this.f303a = bVar;
        }

        @Override // b.b.m.a.a.g
        public void c() {
            this.f303a.start();
        }

        @Override // b.b.m.a.a.g
        public void d() {
            this.f303a.stop();
        }
    }

    public static class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObjectAnimator f304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f305b;

        public e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            objectAnimatorOfInt.setAutoCancel(true);
            objectAnimatorOfInt.setDuration(fVar.f308c);
            objectAnimatorOfInt.setInterpolator(fVar);
            this.f305b = z2;
            this.f304a = objectAnimatorOfInt;
        }

        @Override // b.b.m.a.a.g
        public boolean a() {
            return this.f305b;
        }

        @Override // b.b.m.a.a.g
        public void b() {
            this.f304a.reverse();
        }

        @Override // b.b.m.a.a.g
        public void c() {
            this.f304a.start();
        }

        @Override // b.b.m.a.a.g
        public void d() {
            this.f304a.cancel();
        }
    }

    public static class f implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f308c;

        public f(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f307b = numberOfFrames;
            int[] iArr = this.f306a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f306a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f306a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f308c = i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.f308c) + 0.5f);
            int i2 = this.f307b;
            int[] iArr = this.f306a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.f308c : 0.0f);
        }
    }

    public static abstract class g {
        public g(C0009a c0009a) {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public a(c cVar, Resources resources) {
        super(null);
        this.r = -1;
        this.s = -1;
        c cVar2 = new c(cVar, this, resources);
        super.f(cVar2);
        this.p = cVar2;
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e7, code lost:
    
        r5.onStateChange(r5.getState());
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ee, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.b.m.a.a h(android.content.Context r17, android.content.res.Resources r18, org.xmlpull.v1.XmlPullParser r19, android.util.AttributeSet r20, android.content.res.Resources.Theme r21) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.m.a.a.h(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):b.b.m.a.a");
    }

    @Override // b.b.m.a.d, b.b.m.a.b
    public b.c b() {
        return new c(this.p, this, null);
    }

    @Override // b.b.m.a.d, b.b.m.a.b
    public void f(b.c cVar) {
        super.f(cVar);
        if (cVar instanceof c) {
            this.p = (c) cVar;
        }
    }

    @Override // b.b.m.a.d
    /* JADX INFO: renamed from: g */
    public d.a b() {
        return new c(this.p, this, null);
    }

    @Override // b.b.m.a.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // b.b.m.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.q;
        if (gVar != null) {
            gVar.d();
            this.q = null;
            e(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    @Override // b.b.m.a.d, b.b.m.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.p.e();
                this.t = true;
            }
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e8  */
    @Override // b.b.m.a.d, b.b.m.a.b, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onStateChange(int[] r19) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.m.a.a.onStateChange(int[]):boolean");
    }

    @Override // b.b.m.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.q != null && (visible || z2)) {
            if (z) {
                this.q.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }
}
