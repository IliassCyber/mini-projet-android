package c.c.a.b.d0;

/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1554a = -1.0f;

    @Override // c.c.a.b.d0.d
    public void a(m mVar, float f, float f2, float f3) {
        mVar.e(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d = f3;
        double d2 = f2;
        mVar.d((float) (Math.sin(Math.toRadians(f)) * d * d2), (float) (Math.sin(Math.toRadians(90.0f - f)) * d * d2));
    }
}
