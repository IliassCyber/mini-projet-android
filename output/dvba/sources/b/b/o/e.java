package b.b.o;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import b.b.o.a;
import b.b.o.i.j;
import b.b.o.i.o;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.b.o.a f323b;

    public static class a implements a.InterfaceC0011a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<e> f326c = new ArrayList<>();
        public final b.f.h<Menu, Menu> d = new b.f.h<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f325b = context;
            this.f324a = callback;
        }

        @Override // b.b.o.a.InterfaceC0011a
        public boolean a(b.b.o.a aVar, Menu menu) {
            return this.f324a.onPrepareActionMode(e(aVar), f(menu));
        }

        @Override // b.b.o.a.InterfaceC0011a
        public void b(b.b.o.a aVar) {
            this.f324a.onDestroyActionMode(e(aVar));
        }

        @Override // b.b.o.a.InterfaceC0011a
        public boolean c(b.b.o.a aVar, MenuItem menuItem) {
            return this.f324a.onActionItemClicked(e(aVar), new j(this.f325b, (b.i.h.a.b) menuItem));
        }

        @Override // b.b.o.a.InterfaceC0011a
        public boolean d(b.b.o.a aVar, Menu menu) {
            return this.f324a.onCreateActionMode(e(aVar), f(menu));
        }

        public ActionMode e(b.b.o.a aVar) {
            int size = this.f326c.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.f326c.get(i);
                if (eVar != null && eVar.f323b == aVar) {
                    return eVar;
                }
            }
            e eVar2 = new e(this.f325b, aVar);
            this.f326c.add(eVar2);
            return eVar2;
        }

        public final Menu f(Menu menu) {
            Menu orDefault = this.d.getOrDefault(menu, null);
            if (orDefault != null) {
                return orDefault;
            }
            o oVar = new o(this.f325b, (b.i.h.a.a) menu);
            this.d.put(menu, oVar);
            return oVar;
        }
    }

    public e(Context context, b.b.o.a aVar) {
        this.f322a = context;
        this.f323b = aVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f323b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f323b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.f322a, (b.i.h.a.a) this.f323b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f323b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f323b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f323b.f317b;
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f323b.h();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f323b.f318c;
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f323b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f323b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f323b.k(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f323b.l(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f323b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f323b.f317b = obj;
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f323b.n(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f323b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f323b.p(z);
    }
}
