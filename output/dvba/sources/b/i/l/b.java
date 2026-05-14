package b.i.l;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class b<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f815b;

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(bVar.f814a, null) && Objects.equals(bVar.f815b, null);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "Pair{null null}";
    }
}
