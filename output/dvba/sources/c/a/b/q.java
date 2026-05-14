package c.a.b;

import c.a.b.b;

/* JADX INFO: loaded from: classes.dex */
public class q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f1218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.a f1219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f1220c;
    public boolean d;

    public interface a {
        void a(u uVar);
    }

    public interface b<T> {
        void a(T t);
    }

    public q(u uVar) {
        this.d = false;
        this.f1218a = null;
        this.f1219b = null;
        this.f1220c = uVar;
    }

    public q(T t, b.a aVar) {
        this.d = false;
        this.f1218a = t;
        this.f1219b = aVar;
        this.f1220c = null;
    }
}
