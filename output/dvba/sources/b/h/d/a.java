package b.h.d;

import b.f.h;
import b.i.l.c;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c<ArrayList<T>> f692a = new c<>(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<T, ArrayList<T>> f693b = new h<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f694c = new ArrayList<>();
    public final HashSet<T> d = new HashSet<>();

    public void a(T t) {
        if (this.f693b.e(t) >= 0) {
            return;
        }
        this.f693b.put(t, null);
    }

    public final void b(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> orDefault = this.f693b.getOrDefault(t, null);
        if (orDefault != null) {
            int size = orDefault.size();
            for (int i = 0; i < size; i++) {
                b(orDefault.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }
}
