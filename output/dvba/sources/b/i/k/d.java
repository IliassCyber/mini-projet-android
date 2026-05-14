package b.i.k;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b.i.k.c f805a = new C0032d(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b.i.k.c f806b = new C0032d(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b.i.k.c f807c = new C0032d(a.f808a, false);
    public static final b.i.k.c d = new C0032d(a.f808a, true);

    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f808a = new a();

        @Override // b.i.k.d.b
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int iA = 2;
            while (i < i3 && iA == 2) {
                iA = d.a(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iA;
        }
    }

    public interface b {
        int a(CharSequence charSequence, int i, int i2);
    }

    public static abstract class c implements b.i.k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f809a;

        public c(b bVar) {
            this.f809a = bVar;
        }

        public abstract boolean a();

        public boolean b(CharSequence charSequence, int i, int i2) {
            if (i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            b bVar = this.f809a;
            if (bVar == null) {
                return a();
            }
            int iA = bVar.a(charSequence, i, i2);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return a();
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: b.i.k.d$d, reason: collision with other inner class name */
    public static class C0032d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f810b;

        public C0032d(b bVar, boolean z) {
            super(bVar);
            this.f810b = z;
        }

        @Override // b.i.k.d.c
        public boolean a() {
            return this.f810b;
        }
    }

    public static int a(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
