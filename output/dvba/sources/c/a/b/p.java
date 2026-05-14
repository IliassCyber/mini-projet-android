package c.a.b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f1215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<o<?>> f1216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityBlockingQueue<o<?>> f1217c;
    public final PriorityBlockingQueue<o<?>> d;
    public final b e;
    public final i f;
    public final r g;
    public final j[] h;
    public d i;
    public final List<a> j;

    public interface a<T> {
        void a(o<T> oVar);
    }

    public p(b bVar, i iVar) {
        g gVar = new g(new Handler(Looper.getMainLooper()));
        this.f1215a = new AtomicInteger();
        this.f1216b = new HashSet();
        this.f1217c = new PriorityBlockingQueue<>();
        this.d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.e = bVar;
        this.f = iVar;
        this.h = new j[4];
        this.g = gVar;
    }

    public <T> o<T> a(o<T> oVar) {
        oVar.i = this;
        synchronized (this.f1216b) {
            this.f1216b.add(oVar);
        }
        oVar.h = Integer.valueOf(this.f1215a.incrementAndGet());
        oVar.a("add-to-queue");
        (!oVar.j ? this.d : this.f1217c).add(oVar);
        return oVar;
    }
}
