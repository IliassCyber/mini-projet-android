package b.u.a.a;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
public class c implements TypeEvaluator<b.i.f.c[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.i.f.c[] f1166a;

    @Override // android.animation.TypeEvaluator
    public b.i.f.c[] evaluate(float f, b.i.f.c[] cVarArr, b.i.f.c[] cVarArr2) {
        b.i.f.c[] cVarArr3 = cVarArr;
        b.i.f.c[] cVarArr4 = cVarArr2;
        if (!a.a.a.a.a.e(cVarArr3, cVarArr4)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
        if (!a.a.a.a.a.e(this.f1166a, cVarArr3)) {
            this.f1166a = a.a.a.a.a.x(cVarArr3);
        }
        for (int i = 0; i < cVarArr3.length; i++) {
            b.i.f.c cVar = this.f1166a[i];
            b.i.f.c cVar2 = cVarArr3[i];
            b.i.f.c cVar3 = cVarArr4[i];
            if (cVar == null) {
                throw null;
            }
            cVar.f746a = cVar2.f746a;
            int i2 = 0;
            while (true) {
                float[] fArr = cVar2.f747b;
                if (i2 < fArr.length) {
                    cVar.f747b[i2] = (cVar3.f747b[i2] * f) + ((1.0f - f) * fArr[i2]);
                    i2++;
                }
            }
        }
        return this.f1166a;
    }
}
