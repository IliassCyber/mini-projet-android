package c.c.a.b.d0;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1561a;

    public h(float f) {
        this.f1561a = f;
    }

    @Override // c.c.a.b.d0.c
    public float a(RectF rectF) {
        return rectF.height() * this.f1561a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f1561a == ((h) obj).f1561a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f1561a)});
    }
}
