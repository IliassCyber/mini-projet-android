package b.r.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import b.i.m.v.b;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class u extends b.i.m.a {
    public final RecyclerView d;
    public final a e;

    public static class a extends b.i.m.a {
        public final u d;
        public Map<View, b.i.m.a> e = new WeakHashMap();

        public a(u uVar) {
            this.d = uVar;
        }

        @Override // b.i.m.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            b.i.m.a aVar = this.e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : this.f820a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // b.i.m.a
        public b.i.m.v.c b(View view) {
            b.i.m.a aVar = this.e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // b.i.m.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            b.i.m.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                this.f820a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b.i.m.a
        public void d(View view, b.i.m.v.b bVar) {
            if (!this.d.j() && this.d.d.getLayoutManager() != null) {
                this.d.d.getLayoutManager().j0(view, bVar);
                b.i.m.a aVar = this.e.get(view);
                if (aVar != null) {
                    aVar.d(view, bVar);
                    return;
                }
            }
            this.f820a.onInitializeAccessibilityNodeInfo(view, bVar.f864a);
        }

        @Override // b.i.m.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            b.i.m.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.e(view, accessibilityEvent);
            } else {
                this.f820a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b.i.m.a
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            b.i.m.a aVar = this.e.get(viewGroup);
            return aVar != null ? aVar.f(viewGroup, view, accessibilityEvent) : this.f820a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // b.i.m.a
        public boolean g(View view, int i, Bundle bundle) {
            if (this.d.j() || this.d.d.getLayoutManager() == null) {
                return super.g(view, i, bundle);
            }
            b.i.m.a aVar = this.e.get(view);
            if (aVar != null) {
                if (aVar.g(view, i, bundle)) {
                    return true;
                }
            } else if (super.g(view, i, bundle)) {
                return true;
            }
            RecyclerView.o layoutManager = this.d.d.getLayoutManager();
            RecyclerView.v vVar = layoutManager.f198b.mRecycler;
            return layoutManager.B0();
        }

        @Override // b.i.m.a
        public void h(View view, int i) {
            b.i.m.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.h(view, i);
            } else {
                this.f820a.sendAccessibilityEvent(view, i);
            }
        }

        @Override // b.i.m.a
        public void i(View view, AccessibilityEvent accessibilityEvent) {
            b.i.m.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.i(view, accessibilityEvent);
            } else {
                this.f820a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public u(RecyclerView recyclerView) {
        this.d = recyclerView;
        a aVar = this.e;
        this.e = aVar == null ? new a(this) : aVar;
    }

    @Override // b.i.m.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f820a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || j()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().h0(accessibilityEvent);
        }
    }

    @Override // b.i.m.a
    public void d(View view, b.i.m.v.b bVar) {
        this.f820a.onInitializeAccessibilityNodeInfo(view, bVar.f864a);
        if (j() || this.d.getLayoutManager() == null) {
            return;
        }
        RecyclerView.o layoutManager = this.d.getLayoutManager();
        RecyclerView recyclerView = layoutManager.f198b;
        RecyclerView.v vVar = recyclerView.mRecycler;
        RecyclerView.a0 a0Var = recyclerView.mState;
        if (recyclerView.canScrollVertically(-1) || layoutManager.f198b.canScrollHorizontally(-1)) {
            bVar.f864a.addAction(8192);
            bVar.f864a.setScrollable(true);
        }
        if (layoutManager.f198b.canScrollVertically(1) || layoutManager.f198b.canScrollHorizontally(1)) {
            bVar.f864a.addAction(4096);
            bVar.f864a.setScrollable(true);
        }
        bVar.i(new b.C0034b(AccessibilityNodeInfo.CollectionInfo.obtain(layoutManager.R(vVar, a0Var), layoutManager.A(vVar, a0Var), layoutManager.V(), layoutManager.S())));
    }

    @Override // b.i.m.a
    public boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        if (j() || this.d.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.o layoutManager = this.d.getLayoutManager();
        RecyclerView.v vVar = layoutManager.f198b.mRecycler;
        return layoutManager.A0(i);
    }

    public boolean j() {
        return this.d.hasPendingAdapterUpdates();
    }
}
