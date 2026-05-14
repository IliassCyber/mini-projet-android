package b.b.o.i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.f.h<b.i.h.a.b, MenuItem> f349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b.f.h<b.i.h.a.c, SubMenu> f350c;

    public c(Context context) {
        this.f348a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b.i.h.a.b)) {
            return menuItem;
        }
        b.i.h.a.b bVar = (b.i.h.a.b) menuItem;
        if (this.f349b == null) {
            this.f349b = new b.f.h<>();
        }
        MenuItem orDefault = this.f349b.getOrDefault(menuItem, null);
        if (orDefault != null) {
            return orDefault;
        }
        j jVar = new j(this.f348a, bVar);
        this.f349b.put(bVar, jVar);
        return jVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof b.i.h.a.c)) {
            return subMenu;
        }
        b.i.h.a.c cVar = (b.i.h.a.c) subMenu;
        if (this.f350c == null) {
            this.f350c = new b.f.h<>();
        }
        SubMenu subMenu2 = this.f350c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f348a, cVar);
        this.f350c.put(cVar, sVar);
        return sVar;
    }
}
