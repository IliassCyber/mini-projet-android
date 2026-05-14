package b.b.o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import b.b.o.a;
import b.b.o.i.g;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class d extends a implements g.a {
    public Context d;
    public ActionBarContextView e;
    public a.InterfaceC0011a f;
    public WeakReference<View> g;
    public boolean h;
    public b.b.o.i.g i;

    public d(Context context, ActionBarContextView actionBarContextView, a.InterfaceC0011a interfaceC0011a, boolean z) {
        this.d = context;
        this.e = actionBarContextView;
        this.f = interfaceC0011a;
        b.b.o.i.g gVar = new b.b.o.i.g(actionBarContextView.getContext());
        gVar.l = 1;
        this.i = gVar;
        gVar.e = this;
    }

    @Override // b.b.o.i.g.a
    public void a(b.b.o.i.g gVar) {
        i();
        b.b.p.c cVar = this.e.e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // b.b.o.i.g.a
    public boolean b(b.b.o.i.g gVar, MenuItem menuItem) {
        return this.f.c(this, menuItem);
    }

    @Override // b.b.o.a
    public void c() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.e.sendAccessibilityEvent(32);
        this.f.b(this);
    }

    @Override // b.b.o.a
    public View d() {
        WeakReference<View> weakReference = this.g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // b.b.o.a
    public Menu e() {
        return this.i;
    }

    @Override // b.b.o.a
    public MenuInflater f() {
        return new f(this.e.getContext());
    }

    @Override // b.b.o.a
    public CharSequence g() {
        return this.e.getSubtitle();
    }

    @Override // b.b.o.a
    public CharSequence h() {
        return this.e.getTitle();
    }

    @Override // b.b.o.a
    public void i() {
        this.f.a(this, this.i);
    }

    @Override // b.b.o.a
    public boolean j() {
        return this.e.s;
    }

    @Override // b.b.o.a
    public void k(View view) {
        this.e.setCustomView(view);
        this.g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // b.b.o.a
    public void l(int i) {
        this.e.setSubtitle(this.d.getString(i));
    }

    @Override // b.b.o.a
    public void m(CharSequence charSequence) {
        this.e.setSubtitle(charSequence);
    }

    @Override // b.b.o.a
    public void n(int i) {
        this.e.setTitle(this.d.getString(i));
    }

    @Override // b.b.o.a
    public void o(CharSequence charSequence) {
        this.e.setTitle(charSequence);
    }

    @Override // b.b.o.a
    public void p(boolean z) {
        this.f318c = z;
        this.e.setTitleOptional(z);
    }
}
