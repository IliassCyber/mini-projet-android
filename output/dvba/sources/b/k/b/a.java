package b.k.b;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import b.f.i;
import b.i.m.l;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends b.i.m.a {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);
    public static final b.k.b.b<b.i.m.v.b> o = new C0038a();
    public static final b.k.b.c<i<b.i.m.v.b>, b.i.m.v.b> p = new b();
    public final AccessibilityManager h;
    public final View i;
    public c j;
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public int k = RecyclerView.UNDEFINED_DURATION;
    public int l = RecyclerView.UNDEFINED_DURATION;
    public int m = RecyclerView.UNDEFINED_DURATION;

    /* JADX INFO: renamed from: b.k.b.a$a, reason: collision with other inner class name */
    public static class C0038a implements b.k.b.b<b.i.m.v.b> {
        public void a(Object obj, Rect rect) {
            ((b.i.m.v.b) obj).f864a.getBoundsInParent(rect);
        }
    }

    public static class b implements b.k.b.c<i<b.i.m.v.b>, b.i.m.v.b> {
    }

    public class c extends b.i.m.v.c {
        public c() {
        }

        @Override // b.i.m.v.c
        public b.i.m.v.b a(int i) {
            return new b.i.m.v.b(AccessibilityNodeInfo.obtain(a.this.o(i).f864a));
        }

        @Override // b.i.m.v.c
        public b.i.m.v.b b(int i) {
            int i2 = i == 2 ? a.this.k : a.this.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return new b.i.m.v.b(AccessibilityNodeInfo.obtain(a.this.o(i2).f864a));
        }

        @Override // b.i.m.v.c
        public boolean c(int i, int i2, Bundle bundle) {
            int i3;
            a aVar = a.this;
            if (i == -1) {
                return l.N(aVar.i, i2, bundle);
            }
            boolean z = true;
            if (i2 == 1) {
                return aVar.r(i);
            }
            if (i2 == 2) {
                return aVar.k(i);
            }
            if (i2 != 64) {
                return i2 != 128 ? aVar.p(i, i2, bundle) : aVar.j(i);
            }
            if (aVar.h.isEnabled() && aVar.h.isTouchExplorationEnabled() && (i3 = aVar.k) != i) {
                if (i3 != Integer.MIN_VALUE) {
                    aVar.j(i3);
                }
                aVar.k = i;
                aVar.i.invalidate();
                aVar.s(i, 32768);
            } else {
                z = false;
            }
            return z;
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (l.p(view) == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    @Override // b.i.m.a
    public b.i.m.v.c b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override // b.i.m.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f820a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // b.i.m.a
    public void d(View view, b.i.m.v.b bVar) {
        this.f820a.onInitializeAccessibilityNodeInfo(view, bVar.f864a);
        Chip.b bVar2 = (Chip.b) this;
        bVar.f864a.setCheckable(Chip.this.g());
        bVar.f864a.setClickable(Chip.this.isClickable());
        if (Chip.this.g() || Chip.this.isClickable()) {
            bVar.f864a.setClassName(Chip.this.g() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            bVar.f864a.setClassName("android.view.View");
        }
        CharSequence text = Chip.this.getText();
        if (Build.VERSION.SDK_INT >= 23) {
            bVar.f864a.setText(text);
        } else {
            bVar.f864a.setContentDescription(text);
        }
    }

    public final boolean j(int i) {
        if (this.k != i) {
            return false;
        }
        this.k = RecyclerView.UNDEFINED_DURATION;
        this.i.invalidate();
        s(i, 65536);
        return true;
    }

    public final boolean k(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = RecyclerView.UNDEFINED_DURATION;
        Chip.b bVar = (Chip.b) this;
        if (i == 1) {
            Chip chip = Chip.this;
            chip.m = false;
            chip.refreshDrawableState();
        }
        s(i, 8);
        return true;
    }

    public final b.i.m.v.b l(int i) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        b.i.m.v.b bVar = new b.i.m.v.b(AccessibilityNodeInfo.obtain());
        bVar.f864a.setEnabled(true);
        bVar.f864a.setFocusable(true);
        bVar.f864a.setClassName("android.view.View");
        bVar.f864a.setBoundsInParent(n);
        bVar.f864a.setBoundsInScreen(n);
        View view = this.i;
        bVar.f865b = -1;
        bVar.f864a.setParent(view);
        q(i, bVar);
        if (bVar.g() == null && bVar.e() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        bVar.f864a.getBoundsInParent(this.e);
        if (this.e.equals(n)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = bVar.f864a.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        int i2 = 128;
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        bVar.f864a.setPackageName(this.i.getContext().getPackageName());
        View view2 = this.i;
        bVar.f866c = i;
        bVar.f864a.setSource(view2, i);
        boolean z = false;
        if (this.k == i) {
            bVar.f864a.setAccessibilityFocused(true);
            accessibilityNodeInfo = bVar.f864a;
        } else {
            bVar.f864a.setAccessibilityFocused(false);
            accessibilityNodeInfo = bVar.f864a;
            i2 = 64;
        }
        accessibilityNodeInfo.addAction(i2);
        boolean z2 = this.l == i;
        if (z2) {
            bVar.f864a.addAction(2);
        } else if (bVar.f864a.isFocusable()) {
            bVar.f864a.addAction(1);
        }
        bVar.f864a.setFocused(z2);
        this.i.getLocationOnScreen(this.g);
        bVar.f864a.getBoundsInScreen(this.d);
        if (this.d.equals(n)) {
            bVar.f864a.getBoundsInParent(this.d);
            if (bVar.f865b != -1) {
                b.i.m.v.b bVar2 = new b.i.m.v.b(AccessibilityNodeInfo.obtain());
                for (int i3 = bVar.f865b; i3 != -1; i3 = bVar2.f865b) {
                    View view3 = this.i;
                    bVar2.f865b = -1;
                    bVar2.f864a.setParent(view3, -1);
                    bVar2.f864a.setBoundsInParent(n);
                    q(i3, bVar2);
                    bVar2.f864a.getBoundsInParent(this.e);
                    Rect rect = this.d;
                    Rect rect2 = this.e;
                    rect.offset(rect2.left, rect2.top);
                }
                bVar2.f864a.recycle();
            }
            this.d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
        }
        if (this.i.getLocalVisibleRect(this.f)) {
            this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
            if (this.d.intersect(this.f)) {
                bVar.f864a.setBoundsInScreen(this.d);
                Rect rect3 = this.d;
                if (rect3 != null && !rect3.isEmpty() && this.i.getWindowVisibility() == 0) {
                    View view4 = this.i;
                    while (true) {
                        Object parent = view4.getParent();
                        if (parent instanceof View) {
                            view4 = (View) parent;
                            if (view4.getAlpha() <= 0.0f || view4.getVisibility() != 0) {
                                break;
                            }
                        } else if (parent != null) {
                            z = true;
                        }
                    }
                }
                if (z) {
                    bVar.f864a.setVisibleToUser(true);
                }
            }
        }
        return bVar;
    }

    public abstract void m(List<Integer> list);

    /* JADX WARN: Removed duplicated region for block: B:103:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x013d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(int r20, android.graphics.Rect r21) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.b.a.n(int, android.graphics.Rect):boolean");
    }

    public b.i.m.v.b o(int i) {
        if (i != -1) {
            return l(i);
        }
        b.i.m.v.b bVar = new b.i.m.v.b(AccessibilityNodeInfo.obtain(this.i));
        l.M(this.i, bVar);
        ArrayList arrayList = new ArrayList();
        m(arrayList);
        if (bVar.f864a.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            bVar.f864a.addChild(this.i, ((Integer) arrayList.get(i2)).intValue());
        }
        return bVar;
    }

    public abstract boolean p(int i, int i2, Bundle bundle);

    public abstract void q(int i, b.i.m.v.b bVar);

    public final boolean r(int i) {
        int i2;
        if ((!this.i.isFocused() && !this.i.requestFocus()) || (i2 = this.l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            k(i2);
        }
        this.l = i;
        Chip.b bVar = (Chip.b) this;
        if (i == 1) {
            Chip chip = Chip.this;
            chip.m = true;
            chip.refreshDrawableState();
        }
        s(i, 8);
        return true;
    }

    public final boolean s(int i, int i2) {
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        if (i != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            b.i.m.v.b bVarO = o(i);
            accessibilityEventObtain.getText().add(bVarO.g());
            accessibilityEventObtain.setContentDescription(bVarO.e());
            accessibilityEventObtain.setScrollable(bVarO.f864a.isScrollable());
            accessibilityEventObtain.setPassword(bVarO.f864a.isPassword());
            accessibilityEventObtain.setEnabled(bVarO.f864a.isEnabled());
            accessibilityEventObtain.setChecked(bVarO.f864a.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(bVarO.f864a.getClassName());
            accessibilityEventObtain.setSource(this.i, i);
            accessibilityEventObtain.setPackageName(this.i.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            this.i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        return parent.requestSendAccessibilityEvent(this.i, accessibilityEventObtain);
    }

    public final void t(int i) {
        int i2 = this.m;
        if (i2 == i) {
            return;
        }
        this.m = i;
        s(i, 128);
        s(i2, 256);
    }
}
