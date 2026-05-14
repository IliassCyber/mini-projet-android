package b.b.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class m0 extends k0 implements l0 {
    public static Method H;
    public l0 G;

    public static class a extends f0 {
        public final int p;
        public final int q;
        public l0 r;
        public MenuItem s;

        public a(Context context, boolean z) {
            super(context, z);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.p = 21;
                this.q = 22;
            } else {
                this.p = 22;
                this.q = 21;
            }
        }

        @Override // b.b.p.f0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            int iPointToPosition;
            int i;
            if (this.r != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                }
                b.b.o.i.f fVar = (b.b.o.i.f) adapter;
                b.b.o.i.i item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < fVar.getCount()) {
                    item = fVar.getItem(i);
                }
                MenuItem menuItem = this.s;
                if (menuItem != item) {
                    b.b.o.i.g gVar = fVar.f364b;
                    if (menuItem != null) {
                        this.r.k(gVar, menuItem);
                    }
                    this.s = item;
                    if (item != null) {
                        this.r.g(gVar, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.p) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i != this.q) {
                return super.onKeyDown(i, keyEvent);
            }
            setSelection(-1);
            ((b.b.o.i.f) getAdapter()).f364b.c(false);
            return true;
        }

        public void setHoverListener(l0 l0Var) {
            this.r = l0Var;
        }

        @Override // b.b.p.f0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                H = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public m0(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, null, i, i2);
    }

    @Override // b.b.p.l0
    public void g(b.b.o.i.g gVar, MenuItem menuItem) {
        l0 l0Var = this.G;
        if (l0Var != null) {
            l0Var.g(gVar, menuItem);
        }
    }

    @Override // b.b.p.l0
    public void k(b.b.o.i.g gVar, MenuItem menuItem) {
        l0 l0Var = this.G;
        if (l0Var != null) {
            l0Var.k(gVar, menuItem);
        }
    }

    @Override // b.b.p.k0
    public f0 q(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }
}
