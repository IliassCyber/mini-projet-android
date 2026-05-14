package c.c.a.a.f.c;

/* JADX INFO: loaded from: classes.dex */
public final class f extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f1442b = new f();

    public f() {
        super("CharMatcher.none()");
    }

    @Override // c.c.a.a.f.c.e
    public final int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException(c.c.a.a.c.l.q.B0(i, length, "index"));
        }
        return -1;
    }

    @Override // c.c.a.a.f.c.e
    public final boolean b(char c2) {
        return false;
    }
}
