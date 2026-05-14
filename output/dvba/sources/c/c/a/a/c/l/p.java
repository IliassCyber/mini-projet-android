package c.c.a.a.c.l;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f1397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1398b;

    public p(Object obj, j0 j0Var) {
        q.f(obj);
        this.f1398b = obj;
        this.f1397a = new ArrayList();
    }

    public final p a(String str, Object obj) {
        List<String> list = this.f1397a;
        q.f(str);
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(strValueOf.length() + str.length() + 1);
        sb.append(str);
        sb.append("=");
        sb.append(strValueOf);
        list.add(sb.toString());
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.f1398b.getClass().getSimpleName());
        sb.append('{');
        int size = this.f1397a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.f1397a.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
