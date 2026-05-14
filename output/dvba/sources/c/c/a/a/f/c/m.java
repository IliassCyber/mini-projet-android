package c.c.a.a.f.c;

import java.util.NoSuchElementException;

/* JADX WARN: Incorrect class signature: super class is equals to this class */
/* JADX INFO: loaded from: classes.dex */
public final class m<E> extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1462c;
    public final n<E> d;

    public m(n<E> nVar, int i) {
        int size = nVar.size();
        c.c.a.a.c.l.q.A0(i, size);
        this.f1461b = size;
        this.f1462c = i;
        this.d = nVar;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f1462c < this.f1461b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f1462c > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!(this.f1462c < this.f1461b)) {
            throw new NoSuchElementException();
        }
        int i = this.f1462c;
        this.f1462c = i + 1;
        return this.d.get(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f1462c;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!(this.f1462c > 0)) {
            throw new NoSuchElementException();
        }
        int i = this.f1462c - 1;
        this.f1462c = i;
        return this.d.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f1462c - 1;
    }
}
