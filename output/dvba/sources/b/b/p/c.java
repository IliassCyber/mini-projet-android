package b.b.p;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import b.b.o.i.g;
import b.b.o.i.m;
import b.b.o.i.n;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c extends b.b.o.i.b {
    public d j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public final SparseBooleanArray t;
    public e u;
    public a v;
    public RunnableC0014c w;
    public b x;
    public final f y;
    public int z;

    public class a extends b.b.o.i.l {
        public a(Context context, b.b.o.i.r rVar, View view) {
            super(context, rVar, view, false, b.b.a.actionOverflowMenuStyle, 0);
            if (!rVar.B.g()) {
                View view2 = c.this.j;
                this.f = view2 == null ? (View) c.this.i : view2;
            }
            d(c.this.y);
        }

        @Override // b.b.o.i.l
        public void c() {
            c cVar = c.this;
            cVar.v = null;
            cVar.z = 0;
            super.c();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: b.b.p.c$c, reason: collision with other inner class name */
    public class RunnableC0014c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f408b;

        public RunnableC0014c(e eVar) {
            this.f408b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a aVar;
            b.b.o.i.g gVar = c.this.d;
            if (gVar != null && (aVar = gVar.e) != null) {
                aVar.a(gVar);
            }
            View view = (View) c.this.i;
            if (view != null && view.getWindowToken() != null && this.f408b.f()) {
                c.this.u = this.f408b;
            }
            c.this.w = null;
        }
    }

    public class d extends n implements ActionMenuView.a {

        public class a extends h0 {
            public a(View view, c cVar) {
                super(view);
            }

            @Override // b.b.p.h0
            public b.b.o.i.p b() {
                e eVar = c.this.u;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            @Override // b.b.p.h0
            public boolean c() {
                c.this.n();
                return true;
            }

            @Override // b.b.p.h0
            public boolean d() {
                c cVar = c.this;
                if (cVar.w != null) {
                    return false;
                }
                cVar.i();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, b.b.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            a.a.a.a.a.w0(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.n();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    public class e extends b.b.o.i.l {
        public e(Context context, b.b.o.i.g gVar, View view, boolean z) {
            super(context, gVar, view, z, b.b.a.actionOverflowMenuStyle, 0);
            this.g = 8388613;
            d(c.this.y);
        }

        @Override // b.b.o.i.l
        public void c() {
            b.b.o.i.g gVar = c.this.d;
            if (gVar != null) {
                gVar.c(true);
            }
            c.this.u = null;
            super.c();
        }
    }

    public class f implements m.a {
        public f() {
        }

        @Override // b.b.o.i.m.a
        public void b(b.b.o.i.g gVar, boolean z) {
            if (gVar instanceof b.b.o.i.r) {
                gVar.k().c(false);
            }
            m.a aVar = c.this.f;
            if (aVar != null) {
                aVar.b(gVar, z);
            }
        }

        @Override // b.b.o.i.m.a
        public boolean c(b.b.o.i.g gVar) {
            c cVar = c.this;
            if (gVar == cVar.d) {
                return false;
            }
            int i = ((b.b.o.i.r) gVar).B.f371a;
            m.a aVar = cVar.f;
            if (aVar != null) {
                return aVar.c(gVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, b.b.g.abc_action_menu_layout, b.b.g.abc_action_menu_item_layout);
        this.t = new SparseBooleanArray();
        this.y = new f();
    }

    @Override // b.b.o.i.b
    public View a(b.b.o.i.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.f()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.C ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // b.b.o.i.m
    public void b(b.b.o.i.g gVar, boolean z) {
        e();
        m.a aVar = this.f;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    public boolean e() {
        return i() | l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.b.o.i.b, b.b.o.i.m
    public boolean f(b.b.o.i.r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        b.b.o.i.r rVar2 = rVar;
        while (true) {
            b.b.o.i.g gVar = rVar2.A;
            if (gVar == this.d) {
                break;
            }
            rVar2 = (b.b.o.i.r) gVar;
        }
        b.b.o.i.i iVar = rVar2.B;
        ViewGroup viewGroup = (ViewGroup) this.i;
        View view = null;
        view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == iVar) {
                    view = childAt;
                    break;
                }
                i++;
            }
        }
        if (view == null) {
            return false;
        }
        int i2 = rVar.B.f371a;
        int size = rVar.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i3++;
        }
        a aVar = new a(this.f347c, rVar, view);
        this.v = aVar;
        aVar.h = z;
        b.b.o.i.k kVar = aVar.j;
        if (kVar != null) {
            kVar.p(z);
        }
        if (!this.v.f()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
        super.f(rVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.b.o.i.m
    public boolean g() {
        ArrayList<b.b.o.i.i> arrayListL;
        int size;
        int i;
        boolean z;
        b.b.o.i.g gVar = this.d;
        View view = null;
        if (gVar != null) {
            arrayListL = gVar.l();
            size = arrayListL.size();
        } else {
            arrayListL = null;
            size = 0;
        }
        int i2 = this.q;
        int i3 = this.p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.i;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 2;
            z = 1;
            if (i4 >= size) {
                break;
            }
            b.b.o.i.i iVar = arrayListL.get(i4);
            if ((iVar.y & 2) == 2) {
                i6++;
            } else if ((iVar.y & 1) == 1) {
                i5++;
            } else {
                z2 = true;
            }
            if (this.r && iVar.C) {
                i2 = 0;
            }
            i4++;
        }
        if (this.m && (z2 || i5 + i6 > i2)) {
            i2--;
        }
        int i7 = i2 - i6;
        SparseBooleanArray sparseBooleanArray = this.t;
        sparseBooleanArray.clear();
        int i8 = 0;
        int i9 = 0;
        while (i8 < size) {
            b.b.o.i.i iVar2 = arrayListL.get(i8);
            if ((iVar2.y & i) == i) {
                View viewA = a(iVar2, view, viewGroup);
                viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewA.getMeasuredWidth();
                i3 -= measuredWidth;
                if (i9 == 0) {
                    i9 = measuredWidth;
                }
                int i10 = iVar2.f372b;
                if (i10 != 0) {
                    sparseBooleanArray.put(i10, z);
                }
                iVar2.k(z);
            } else if ((iVar2.y & z) == z) {
                int i11 = iVar2.f372b;
                boolean z3 = sparseBooleanArray.get(i11);
                boolean z4 = (i7 > 0 || z3) && i3 > 0;
                if (z4) {
                    View viewA2 = a(iVar2, view, viewGroup);
                    viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i3 -= measuredWidth2;
                    if (i9 == 0) {
                        i9 = measuredWidth2;
                    }
                    z4 &= i3 + i9 > 0;
                }
                boolean z5 = z4;
                if (z5 && i11 != 0) {
                    sparseBooleanArray.put(i11, z);
                } else if (z3) {
                    sparseBooleanArray.put(i11, false);
                    for (int i12 = 0; i12 < i8; i12++) {
                        b.b.o.i.i iVar3 = arrayListL.get(i12);
                        if (iVar3.f372b == i11) {
                            if (iVar3.g()) {
                                i7++;
                            }
                            iVar3.k(false);
                        }
                    }
                }
                if (z5) {
                    i7--;
                }
                iVar2.k(z5);
            } else {
                iVar2.k(false);
                i8++;
                view = null;
                i = 2;
                z = 1;
            }
            i8++;
            view = null;
            i = 2;
            z = 1;
        }
        return true;
    }

    @Override // b.b.o.i.b, b.b.o.i.m
    public void h(boolean z) {
        ArrayList<b.b.o.i.i> arrayList;
        super.h(z);
        ((View) this.i).requestLayout();
        b.b.o.i.g gVar = this.d;
        boolean z2 = false;
        if (gVar != null) {
            gVar.i();
            ArrayList<b.b.o.i.i> arrayList2 = gVar.i;
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                b.i.m.b bVar = arrayList2.get(i).A;
            }
        }
        b.b.o.i.g gVar2 = this.d;
        if (gVar2 != null) {
            gVar2.i();
            arrayList = gVar2.j;
        } else {
            arrayList = null;
        }
        if (this.m && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z2 = !arrayList.get(0).C;
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        d dVar = this.j;
        if (z2) {
            if (dVar == null) {
                this.j = new d(this.f346b);
            }
            ViewGroup viewGroup = (ViewGroup) this.j.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                d dVar2 = this.j;
                ActionMenuView.c cVarGenerateDefaultLayoutParams = actionMenuView.generateDefaultLayoutParams();
                cVarGenerateDefaultLayoutParams.f65c = true;
                actionMenuView.addView(dVar2, cVarGenerateDefaultLayoutParams);
            }
        } else if (dVar != null) {
            Object parent = dVar.getParent();
            Object obj = this.i;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.j);
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.m);
    }

    public boolean i() {
        Object obj;
        RunnableC0014c runnableC0014c = this.w;
        if (runnableC0014c != null && (obj = this.i) != null) {
            ((View) obj).removeCallbacks(runnableC0014c);
            this.w = null;
            return true;
        }
        e eVar = this.u;
        if (eVar == null) {
            return false;
        }
        if (eVar.b()) {
            eVar.j.dismiss();
        }
        return true;
    }

    @Override // b.b.o.i.m
    public void j(Context context, b.b.o.i.g gVar) {
        this.f347c = context;
        LayoutInflater.from(context);
        this.d = gVar;
        Resources resources = context.getResources();
        if (!this.n) {
            this.m = true;
        }
        int i = 2;
        this.o = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.q = i;
        int measuredWidth = this.o;
        if (this.m) {
            if (this.j == null) {
                d dVar = new d(this.f346b);
                this.j = dVar;
                if (this.l) {
                    dVar.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.p = measuredWidth;
        this.s = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean l() {
        a aVar = this.v;
        if (aVar == null) {
            return false;
        }
        if (!aVar.b()) {
            return true;
        }
        aVar.j.dismiss();
        return true;
    }

    public boolean m() {
        e eVar = this.u;
        return eVar != null && eVar.b();
    }

    public boolean n() {
        b.b.o.i.g gVar;
        if (!this.m || m() || (gVar = this.d) == null || this.i == null || this.w != null) {
            return false;
        }
        gVar.i();
        if (gVar.j.isEmpty()) {
            return false;
        }
        RunnableC0014c runnableC0014c = new RunnableC0014c(new e(this.f347c, this.d, this.j, true));
        this.w = runnableC0014c;
        ((View) this.i).post(runnableC0014c);
        return true;
    }
}
