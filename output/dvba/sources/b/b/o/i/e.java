package b.b.o.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.view.menu.ExpandedMenuView;
import b.b.k.g;
import b.b.o.i.m;
import b.b.o.i.n;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f361c;
    public g d;
    public ExpandedMenuView e;
    public int f;
    public int g = 0;
    public int h;
    public m.a i;
    public a j;

    public class a extends BaseAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f362b = -1;

        public a() {
            a();
        }

        public void a() {
            g gVar = e.this.d;
            i iVar = gVar.w;
            if (iVar != null) {
                gVar.i();
                ArrayList<i> arrayList = gVar.j;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (arrayList.get(i) == iVar) {
                        this.f362b = i;
                        return;
                    }
                }
            }
            this.f362b = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i getItem(int i) {
            g gVar = e.this.d;
            gVar.i();
            ArrayList<i> arrayList = gVar.j;
            int i2 = i + e.this.f;
            int i3 = this.f362b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return arrayList.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            g gVar = e.this.d;
            gVar.i();
            int size = gVar.j.size() - e.this.f;
            return this.f362b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f361c.inflate(eVar.h, viewGroup, false);
            }
            ((n.a) view).e(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i) {
        this.h = i;
        this.f360b = context;
        this.f361c = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.j == null) {
            this.j = new a();
        }
        return this.j;
    }

    @Override // b.b.o.i.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.i;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // b.b.o.i.m
    public boolean c(g gVar, i iVar) {
        return false;
    }

    @Override // b.b.o.i.m
    public void d(m.a aVar) {
        this.i = aVar;
    }

    @Override // b.b.o.i.m
    public boolean f(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        h hVar = new h(rVar);
        g gVar = hVar.f369b;
        g.a aVar = new g.a(gVar.f366a);
        e eVar = new e(aVar.f252a.f49a, b.b.g.abc_list_menu_item_layout);
        hVar.d = eVar;
        eVar.i = hVar;
        g gVar2 = hVar.f369b;
        gVar2.b(eVar, gVar2.f366a);
        ListAdapter listAdapterA = hVar.d.a();
        AlertController.b bVar = aVar.f252a;
        bVar.q = listAdapterA;
        bVar.r = hVar;
        View view = gVar.o;
        if (view != null) {
            bVar.g = view;
        } else {
            bVar.d = gVar.n;
            bVar.f = gVar.m;
        }
        aVar.f252a.p = hVar;
        b.b.k.g gVarA = aVar.a();
        hVar.f370c = gVarA;
        gVarA.setOnDismissListener(hVar);
        WindowManager.LayoutParams attributes = hVar.f370c.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        hVar.f370c.show();
        m.a aVar2 = this.i;
        if (aVar2 == null) {
            return true;
        }
        aVar2.c(rVar);
        return true;
    }

    @Override // b.b.o.i.m
    public boolean g() {
        return false;
    }

    @Override // b.b.o.i.m
    public void h(boolean z) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // b.b.o.i.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(android.content.Context r3, b.b.o.i.g r4) {
        /*
            r2 = this;
            int r0 = r2.g
            if (r0 == 0) goto L12
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.g
            r0.<init>(r3, r1)
            r2.f360b = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
            goto L20
        L12:
            android.content.Context r0 = r2.f360b
            if (r0 == 0) goto L22
            r2.f360b = r3
            android.view.LayoutInflater r0 = r2.f361c
            if (r0 != 0) goto L22
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
        L20:
            r2.f361c = r3
        L22:
            r2.d = r4
            b.b.o.i.e$a r3 = r2.j
            if (r3 == 0) goto L2b
            r3.notifyDataSetChanged()
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.o.i.e.j(android.content.Context, b.b.o.i.g):void");
    }

    @Override // b.b.o.i.m
    public boolean k(g gVar, i iVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.d.s(this.j.getItem(i), this, 0);
    }
}
