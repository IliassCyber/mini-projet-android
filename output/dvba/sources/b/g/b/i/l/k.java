package b.g.b.i.l;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f648c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<m> f650b = new ArrayList<>();

    public k(m mVar, int i) {
        this.f649a = null;
        f648c++;
        this.f649a = mVar;
    }

    public final long a(f fVar, long j) {
        m mVar = fVar.d;
        if (mVar instanceof i) {
            return j;
        }
        int size = fVar.k.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            d dVar = fVar.k.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.d != mVar) {
                    jMin = Math.min(jMin, a(fVar2, ((long) fVar2.f) + j));
                }
            }
        }
        if (fVar != mVar.i) {
            return jMin;
        }
        long j2 = j - mVar.j();
        return Math.min(Math.min(jMin, a(mVar.h, j2)), j2 - ((long) mVar.h.f));
    }

    public final long b(f fVar, long j) {
        m mVar = fVar.d;
        if (mVar instanceof i) {
            return j;
        }
        int size = fVar.k.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            d dVar = fVar.k.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.d != mVar) {
                    jMax = Math.max(jMax, b(fVar2, ((long) fVar2.f) + j));
                }
            }
        }
        if (fVar != mVar.h) {
            return jMax;
        }
        long j2 = j + mVar.j();
        return Math.max(Math.max(jMax, b(mVar.i, j2)), j2 - ((long) mVar.i.f));
    }
}
