package b.r.d;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.f.h<RecyclerView.d0, a> f1085a = new b.f.h<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.e<RecyclerView.d0> f1086b = new b.f.e<>();

    public static class a {
        public static b.i.l.c<a> d = new b.i.l.c<>(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.l.c f1088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public RecyclerView.l.c f1089c;

        public static a a() {
            a aVarA = d.a();
            return aVarA == null ? new a() : aVarA;
        }

        public static void b(a aVar) {
            aVar.f1087a = 0;
            aVar.f1088b = null;
            aVar.f1089c = null;
            d.b(aVar);
        }
    }

    public interface b {
    }

    public void a(RecyclerView.d0 d0Var) {
        a orDefault = this.f1085a.getOrDefault(d0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f1085a.put(d0Var, orDefault);
        }
        orDefault.f1087a |= 1;
    }

    public void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a orDefault = this.f1085a.getOrDefault(d0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f1085a.put(d0Var, orDefault);
        }
        orDefault.f1089c = cVar;
        orDefault.f1087a |= 8;
    }

    public void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a orDefault = this.f1085a.getOrDefault(d0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f1085a.put(d0Var, orDefault);
        }
        orDefault.f1088b = cVar;
        orDefault.f1087a |= 4;
    }

    public boolean d(RecyclerView.d0 d0Var) {
        a orDefault = this.f1085a.getOrDefault(d0Var, null);
        return (orDefault == null || (orDefault.f1087a & 1) == 0) ? false : true;
    }

    public final RecyclerView.l.c e(RecyclerView.d0 d0Var, int i) {
        a aVarK;
        RecyclerView.l.c cVar;
        int iE = this.f1085a.e(d0Var);
        if (iE >= 0 && (aVarK = this.f1085a.k(iE)) != null) {
            int i2 = aVarK.f1087a;
            if ((i2 & i) != 0) {
                aVarK.f1087a = (~i) & i2;
                if (i == 4) {
                    cVar = aVarK.f1088b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVarK.f1089c;
                }
                if ((aVarK.f1087a & 12) == 0) {
                    this.f1085a.i(iE);
                    a.b(aVarK);
                }
                return cVar;
            }
        }
        return null;
    }

    public void f(RecyclerView.d0 d0Var) {
        a orDefault = this.f1085a.getOrDefault(d0Var, null);
        if (orDefault == null) {
            return;
        }
        orDefault.f1087a &= -2;
    }

    public void g(RecyclerView.d0 d0Var) {
        int iH = this.f1086b.h() - 1;
        while (true) {
            if (iH < 0) {
                break;
            }
            if (d0Var == this.f1086b.i(iH)) {
                b.f.e<RecyclerView.d0> eVar = this.f1086b;
                Object[] objArr = eVar.d;
                Object obj = objArr[iH];
                Object obj2 = b.f.e.f;
                if (obj != obj2) {
                    objArr[iH] = obj2;
                    eVar.f576b = true;
                }
            } else {
                iH--;
            }
        }
        a aVarRemove = this.f1085a.remove(d0Var);
        if (aVarRemove != null) {
            a.b(aVarRemove);
        }
    }
}
