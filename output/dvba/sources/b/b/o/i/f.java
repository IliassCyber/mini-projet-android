package b.b.o.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import b.b.o.i.n;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f extends BaseAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f365c = -1;
    public boolean d;
    public final boolean e;
    public final LayoutInflater f;
    public final int g;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.e = z;
        this.f = layoutInflater;
        this.f364b = gVar;
        this.g = i;
        a();
    }

    public void a() {
        g gVar = this.f364b;
        i iVar = gVar.w;
        if (iVar != null) {
            gVar.i();
            ArrayList<i> arrayList = gVar.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i) == iVar) {
                    this.f365c = i;
                    return;
                }
            }
        }
        this.f365c = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i getItem(int i) {
        ArrayList<i> arrayListL;
        if (this.e) {
            g gVar = this.f364b;
            gVar.i();
            arrayListL = gVar.j;
        } else {
            arrayListL = this.f364b.l();
        }
        int i2 = this.f365c;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> arrayListL;
        if (this.e) {
            g gVar = this.f364b;
            gVar.i();
            arrayListL = gVar.j;
        } else {
            arrayListL = this.f364b.l();
        }
        int i = this.f365c;
        int size = arrayListL.size();
        return i < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f.inflate(this.g, viewGroup, false);
        }
        int i2 = getItem(i).f372b;
        int i3 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f364b.m() && i2 != (i3 >= 0 ? getItem(i3).f372b : i2));
        n.a aVar = (n.a) view;
        if (this.d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
