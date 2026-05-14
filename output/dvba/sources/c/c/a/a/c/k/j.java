package c.c.a.a.c.k;

/* JADX INFO: loaded from: classes.dex */
public final class j extends UnsupportedOperationException {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.c.a.a.c.c f1300b;

    public j(c.c.a.a.c.c cVar) {
        this.f1300b = cVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String strValueOf = String.valueOf(this.f1300b);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
        sb.append("Missing ");
        sb.append(strValueOf);
        return sb.toString();
    }
}
