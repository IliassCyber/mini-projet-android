package b.c.a.a;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f525c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f527b;

    public a() {
        b bVar = new b();
        this.f527b = bVar;
        this.f526a = bVar;
    }

    public static a b() {
        if (f525c != null) {
            return f525c;
        }
        synchronized (a.class) {
            if (f525c == null) {
                f525c = new a();
            }
        }
        return f525c;
    }

    @Override // b.c.a.a.c
    public boolean a() {
        return this.f526a.a();
    }
}
