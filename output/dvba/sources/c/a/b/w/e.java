package c.a.b.w;

import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c.a.b.h> f1244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1245c;
    public final InputStream d;

    public e(int i, List<c.a.b.h> list) {
        this.f1243a = i;
        this.f1244b = list;
        this.f1245c = -1;
        this.d = null;
    }

    public e(int i, List<c.a.b.h> list, int i2, InputStream inputStream) {
        this.f1243a = i;
        this.f1244b = list;
        this.f1245c = i2;
        this.d = inputStream;
    }
}
