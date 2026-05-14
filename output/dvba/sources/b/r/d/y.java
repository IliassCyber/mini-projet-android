package b.r.d;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f1081b = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1082a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1084c;
        public int d;
        public int e;

        public boolean a() {
            int i = this.f1082a;
            if ((i & 7) != 0 && (i & (b(this.d, this.f1083b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f1082a;
            if ((i2 & 112) != 0 && (i2 & (b(this.d, this.f1084c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f1082a;
            if ((i3 & 1792) != 0 && (i3 & (b(this.e, this.f1083b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f1082a;
            return (i4 & 28672) == 0 || (i4 & (b(this.e, this.f1084c) << 12)) != 0;
        }

        public int b(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }
    }

    public interface b {
        int a();

        int b();

        int c(View view);

        int d(View view);

        View e(int i);
    }

    public y(b bVar) {
        this.f1080a = bVar;
    }

    public View a(int i, int i2, int i3, int i4) {
        int iB = this.f1080a.b();
        int iA = this.f1080a.a();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewE = this.f1080a.e(i);
            int iD = this.f1080a.d(viewE);
            int iC = this.f1080a.c(viewE);
            a aVar = this.f1081b;
            aVar.f1083b = iB;
            aVar.f1084c = iA;
            aVar.d = iD;
            aVar.e = iC;
            if (i3 != 0) {
                aVar.f1082a = 0;
                aVar.f1082a = i3 | 0;
                if (aVar.a()) {
                    return viewE;
                }
            }
            if (i4 != 0) {
                a aVar2 = this.f1081b;
                aVar2.f1082a = 0;
                aVar2.f1082a = i4 | 0;
                if (aVar2.a()) {
                    view = viewE;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean b(View view, int i) {
        a aVar = this.f1081b;
        int iB = this.f1080a.b();
        int iA = this.f1080a.a();
        int iD = this.f1080a.d(view);
        int iC = this.f1080a.c(view);
        aVar.f1083b = iB;
        aVar.f1084c = iA;
        aVar.d = iD;
        aVar.e = iC;
        if (i == 0) {
            return false;
        }
        a aVar2 = this.f1081b;
        aVar2.f1082a = 0;
        aVar2.f1082a = 0 | i;
        return aVar2.a();
    }
}
