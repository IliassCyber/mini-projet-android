package c.c.a.b.d0;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1551a;

    public a(float f) {
        this.f1551a = f;
    }

    @Override // c.c.a.b.d0.c
    public float a(RectF rectF) {
        return this.f1551a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f1551a == ((a) obj).f1551a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f1551a)});
    }
}
