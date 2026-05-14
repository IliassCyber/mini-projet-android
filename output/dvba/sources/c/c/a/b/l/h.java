package c.c.a.b.l;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f1642c;
    public int d;
    public int e;

    public h(long j, long j2) {
        this.f1640a = 0L;
        this.f1641b = 300L;
        this.f1642c = null;
        this.d = 0;
        this.e = 1;
        this.f1640a = j;
        this.f1641b = j2;
    }

    public h(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f1640a = 0L;
        this.f1641b = 300L;
        this.f1642c = null;
        this.d = 0;
        this.e = 1;
        this.f1640a = j;
        this.f1641b = j2;
        this.f1642c = timeInterpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(this.f1640a);
        animator.setDuration(this.f1641b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.d);
            valueAnimator.setRepeatMode(this.e);
        }
    }

    public TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f1642c;
        return timeInterpolator != null ? timeInterpolator : a.f1628b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f1640a == hVar.f1640a && this.f1641b == hVar.f1641b && this.d == hVar.d && this.e == hVar.e) {
            return b().getClass().equals(hVar.b().getClass());
        }
        return false;
    }

    public int hashCode() {
        long j = this.f1640a;
        long j2 = this.f1641b;
        return ((((b().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.f1640a + " duration: " + this.f1641b + " interpolator: " + b().getClass() + " repeatCount: " + this.d + " repeatMode: " + this.e + "}\n";
    }
}
