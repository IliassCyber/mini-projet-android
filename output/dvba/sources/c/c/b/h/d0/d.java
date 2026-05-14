package c.c.b.h.d0;

/* JADX INFO: loaded from: classes.dex */
public final class d implements c.c.a.a.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1833a;

    public d(e eVar) {
        this.f1833a = eVar;
    }

    @Override // c.c.a.a.h.a
    public final void b(Exception exc) {
        if (exc instanceof c.c.b.e) {
            c.h.c("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            c cVar = this.f1833a.f1835c;
            int i = (int) cVar.f1830c;
            cVar.f1830c = (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) ? 2 * cVar.f1830c : i != 960 ? 30L : 960L;
            cVar.f1829b = (cVar.f1830c * 1000) + System.currentTimeMillis();
            c.c.a.a.c.m.a aVar = c.h;
            long j = cVar.f1829b;
            StringBuilder sb = new StringBuilder(43);
            sb.append("Scheduling refresh for ");
            sb.append(j);
            aVar.c(sb.toString(), new Object[0]);
            cVar.f.postDelayed(cVar.g, cVar.f1830c * 1000);
        }
    }
}
