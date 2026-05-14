package b.i.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import b.i.m.a;
import b.i.m.v.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakHashMap<View, q> f835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f837c;
    public static ThreadLocal<Rect> d;

    public class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f838a;

        public a(j jVar) {
            this.f838a = jVar;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            if (windowInsets == null) {
                throw null;
            }
            return this.f838a.a(view, new u(windowInsets)).g();
        }
    }

    public static abstract class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<T> f840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f841c;

        public b(int i, Class<T> cls, int i2) {
            this.f839a = i;
            this.f840b = cls;
            this.f841c = i2;
        }

        public b(int i, Class<T> cls, int i2, int i3) {
            this.f839a = i;
            this.f840b = cls;
            this.f841c = i3;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        public abstract T b(View view);

        public abstract void c(View view, T t);

        public T d(View view) {
            if (Build.VERSION.SDK_INT >= this.f841c) {
                return b(view);
            }
            T t = (T) view.getTag(this.f839a);
            if (this.f840b.isInstance(t)) {
                return t;
            }
            return null;
        }

        public abstract boolean e(T t, T t2);
    }

    public interface c {
        boolean a(View view, KeyEvent keyEvent);
    }

    public static class d {
        public static final ArrayList<WeakReference<View>> d = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f842a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray<WeakReference<View>> f843b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<KeyEvent> f844c = null;

        public static d a(View view) {
            d dVar = (d) view.getTag(b.i.b.tag_unhandled_key_event_manager);
            if (dVar != null) {
                return dVar;
            }
            d dVar2 = new d();
            view.setTag(b.i.b.tag_unhandled_key_event_manager, dVar2);
            return dVar2;
        }

        public final View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f842a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewB = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewB != null) {
                            return viewB;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(b.i.b.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((c) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        new AtomicInteger(1);
        f835a = null;
        f837c = false;
        new WeakHashMap();
    }

    public static boolean A(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean B(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean C(View view) {
        return view.hasTransientState();
    }

    public static boolean D(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean E(View view) {
        return view.isLaidOut();
    }

    public static boolean F(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static boolean G(View view) {
        return view.isPaddingRelative();
    }

    public static boolean H(View view) {
        Boolean boolD = new m(b.i.b.tag_screen_reader_focusable, Boolean.class, 28).d(view);
        if (boolD == null) {
            return false;
        }
        return boolD.booleanValue();
    }

    public static void I(View view, int i) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = new n(b.i.b.tag_accessibility_pane_title, CharSequence.class, 8, 28).d(view) != null;
            if (view.getAccessibilityLiveRegion() != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    public static void J(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        Rect rectN = n();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectN.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectN.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        b(view, i);
        if (z && rectN.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectN);
        }
    }

    public static void K(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        Rect rectN = n();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectN.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectN.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        c(view, i);
        if (z && rectN.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectN);
        }
    }

    public static u L(View view, u uVar) {
        WindowInsets windowInsetsG = uVar.g();
        if (windowInsetsG == null) {
            return uVar;
        }
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsG);
        return !windowInsetsOnApplyWindowInsets.equals(windowInsetsG) ? new u(windowInsetsOnApplyWindowInsets) : uVar;
    }

    public static void M(View view, b.i.m.v.b bVar) {
        view.onInitializeAccessibilityNodeInfo(bVar.f864a);
    }

    public static boolean N(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static void O(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void P(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void Q(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void R(View view, int i) {
        S(i, view);
        I(view, 0);
    }

    public static void S(int i, View view) {
        ArrayList arrayList = (ArrayList) view.getTag(b.i.b.tag_accessibility_actions);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(b.i.b.tag_accessibility_actions, arrayList);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((b.a) arrayList.get(i2)).a() == i) {
                arrayList.remove(i2);
                return;
            }
        }
    }

    public static void T(View view, b.a aVar, CharSequence charSequence, b.i.m.v.d dVar) {
        b.a aVar2 = new b.a(null, aVar.f868b, null, dVar, aVar.f869c);
        b.i.m.a aVarG = g(view);
        if (aVarG == null) {
            aVarG = new b.i.m.a();
        }
        W(view, aVarG);
        S(aVar2.a(), view);
        ArrayList arrayList = (ArrayList) view.getTag(b.i.b.tag_accessibility_actions);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(b.i.b.tag_accessibility_actions, arrayList);
        }
        arrayList.add(aVar2);
        I(view, 0);
    }

    public static void U(View view) {
        view.requestApplyInsets();
    }

    public static void V(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void W(View view, b.i.m.a aVar) {
        if (aVar == null && (h(view) instanceof a.C0033a)) {
            aVar = new b.i.m.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.f821b);
    }

    public static void X(View view, boolean z) {
        o oVar = new o(b.i.b.tag_accessibility_heading, Boolean.class, 28);
        Boolean boolValueOf = Boolean.valueOf(z);
        if (Build.VERSION.SDK_INT >= oVar.f841c) {
            oVar.c(view, boolValueOf);
            return;
        }
        if (oVar.e(oVar.d(view), boolValueOf)) {
            b.i.m.a aVarG = g(view);
            if (aVarG == null) {
                aVarG = new b.i.m.a();
            }
            W(view, aVarG);
            view.setTag(oVar.f839a, boolValueOf);
            I(view, 0);
        }
    }

    public static void Y(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    public static void Z(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static q a(View view) {
        if (f835a == null) {
            f835a = new WeakHashMap<>();
        }
        q qVar = f835a.get(view);
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(view);
        f835a.put(view, qVar2);
        return qVar2;
    }

    public static void a0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void b(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            Object parent = view.getParent();
            if (parent instanceof View) {
                j0((View) parent);
            }
        }
    }

    public static void b0(View view, float f) {
        view.setElevation(f);
    }

    public static void c(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            Object parent = view.getParent();
            if (parent instanceof View) {
                j0((View) parent);
            }
        }
    }

    public static void c0(View view, boolean z) {
        view.setHasTransientState(z);
    }

    public static u d(View view, u uVar, Rect rect) {
        WindowInsets windowInsetsG = uVar.g();
        if (windowInsetsG != null) {
            return u.h(view.computeSystemWindowInsets(windowInsetsG, rect));
        }
        rect.setEmpty();
        return uVar;
    }

    public static void d0(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static boolean e(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        d dVarA = d.a(view);
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = dVarA.f842a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (!d.d.isEmpty()) {
                synchronized (d.d) {
                    if (dVarA.f842a == null) {
                        dVarA.f842a = new WeakHashMap<>();
                    }
                    int size = d.d.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        View view2 = d.d.get(size).get();
                        if (view2 == null) {
                            d.d.remove(size);
                        } else {
                            dVarA.f842a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                dVarA.f842a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View viewB = dVarA.b(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewB != null && !KeyEvent.isModifierKey(keyCode)) {
                if (dVarA.f843b == null) {
                    dVarA.f843b = new SparseArray<>();
                }
                dVarA.f843b.put(keyCode, new WeakReference<>(viewB));
            }
        }
        return viewB != null;
    }

    public static void e0(View view, j jVar) {
        if (jVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new a(jVar));
        }
    }

    public static boolean f(View view, KeyEvent keyEvent) {
        int iIndexOfKey;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        d dVarA = d.a(view);
        WeakReference<KeyEvent> weakReference = dVarA.f844c;
        if (weakReference != null && weakReference.get() == keyEvent) {
            return false;
        }
        dVarA.f844c = new WeakReference<>(keyEvent);
        WeakReference<View> weakReferenceValueAt = null;
        if (dVarA.f843b == null) {
            dVarA.f843b = new SparseArray<>();
        }
        SparseArray<WeakReference<View>> sparseArray = dVarA.f843b;
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReferenceValueAt = sparseArray.valueAt(iIndexOfKey);
            sparseArray.removeAt(iIndexOfKey);
        }
        if (weakReferenceValueAt == null) {
            weakReferenceValueAt = sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReferenceValueAt == null) {
            return false;
        }
        View view2 = weakReferenceValueAt.get();
        if (view2 != null && view2.isAttachedToWindow()) {
            dVarA.c(view2, keyEvent);
        }
        return true;
    }

    public static void f0(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static b.i.m.a g(View view) {
        View.AccessibilityDelegate accessibilityDelegateH = h(view);
        if (accessibilityDelegateH == null) {
            return null;
        }
        return accessibilityDelegateH instanceof a.C0033a ? ((a.C0033a) accessibilityDelegateH).f822a : new b.i.m.a(accessibilityDelegateH);
    }

    public static void g0(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    public static View.AccessibilityDelegate h(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (f837c) {
            return null;
        }
        if (f836b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f836b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f837c = true;
                return null;
            }
        }
        Object obj = f836b.get(view);
        if (obj instanceof View.AccessibilityDelegate) {
            return (View.AccessibilityDelegate) obj;
        }
        return null;
    }

    public static void h0(View view, String str) {
        view.setTransitionName(str);
    }

    public static int i(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static void i0(View view) {
        view.stopNestedScroll();
    }

    public static ColorStateList j(View view) {
        return view.getBackgroundTintList();
    }

    public static void j0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static Rect k(View view) {
        return view.getClipBounds();
    }

    public static Display l(View view) {
        return view.getDisplay();
    }

    public static float m(View view) {
        return view.getElevation();
    }

    public static Rect n() {
        if (d == null) {
            d = new ThreadLocal<>();
        }
        Rect rect = d.get();
        if (rect == null) {
            rect = new Rect();
            d.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static boolean o(View view) {
        return view.getFitsSystemWindows();
    }

    public static int p(View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int q(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int r(View view) {
        return view.getLayoutDirection();
    }

    public static int s(View view) {
        return view.getMinimumHeight();
    }

    public static int t(View view) {
        return view.getMinimumWidth();
    }

    public static int u(View view) {
        return view.getPaddingEnd();
    }

    public static int v(View view) {
        return view.getPaddingStart();
    }

    public static u w(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return u.h(view.getRootWindowInsets());
        }
        return null;
    }

    public static String x(View view) {
        return view.getTransitionName();
    }

    public static int y(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float z(View view) {
        return view.getZ();
    }
}
