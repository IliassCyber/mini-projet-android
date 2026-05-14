package c.c.a.b.d0;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f1552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1553b;

    public b(float f, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f1552a;
            f += ((b) cVar).f1553b;
        }
        this.f1552a = cVar;
        this.f1553b = f;
    }

    @Override // c.c.a.b.d0.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f1552a.a(rectF) + this.f1553b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1552a.equals(bVar.f1552a) && this.f1553b == bVar.f1553b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1552a, Float.valueOf(this.f1553b)});
    }
}
