package androidx.activity;

import b.a.b;
import b.l.a.k;
import b.n.d;
import b.n.e;
import b.n.g;
import b.n.h;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f36a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f37b = new ArrayDeque<>();

    public class LifecycleOnBackPressedCancellable implements e, b.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f38a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f39b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b.a.a f40c;

        public LifecycleOnBackPressedCancellable(d dVar, b bVar) {
            this.f38a = dVar;
            this.f39b = bVar;
            dVar.a(this);
        }

        @Override // b.a.a
        public void cancel() {
            ((h) this.f38a).f986a.d(this);
            this.f39b.f240b.remove(this);
            b.a.a aVar = this.f40c;
            if (aVar != null) {
                aVar.cancel();
                this.f40c = null;
            }
        }

        @Override // b.n.e
        public void g(g gVar, d.a aVar) {
            if (aVar == d.a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                b bVar = this.f39b;
                onBackPressedDispatcher.f37b.add(bVar);
                a aVar2 = onBackPressedDispatcher.new a(bVar);
                bVar.f240b.add(aVar2);
                this.f40c = aVar2;
                return;
            }
            if (aVar != d.a.ON_STOP) {
                if (aVar == d.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                b.a.a aVar3 = this.f40c;
                if (aVar3 != null) {
                    aVar3.cancel();
                }
            }
        }
    }

    public class a implements b.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f41a;

        public a(b bVar) {
            this.f41a = bVar;
        }

        @Override // b.a.a
        public void cancel() {
            OnBackPressedDispatcher.this.f37b.remove(this.f41a);
            this.f41a.f240b.remove(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f36a = runnable;
    }

    public void a() {
        Iterator<b> itDescendingIterator = this.f37b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            b next = itDescendingIterator.next();
            if (next.f239a) {
                k kVar = k.this;
                kVar.P();
                if (kVar.l.f239a) {
                    kVar.d();
                    return;
                } else {
                    kVar.k.a();
                    return;
                }
            }
        }
        Runnable runnable = this.f36a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
