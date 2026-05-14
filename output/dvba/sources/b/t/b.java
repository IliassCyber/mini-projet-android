package b.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends b.t.i {
    public static final String[] M = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> N = new C0045b(PointF.class, "boundsOrigin");
    public static final Property<k, PointF> O = new c(PointF.class, "topLeft");
    public static final Property<k, PointF> P = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> Q = new e(PointF.class, "bottomRight");
    public static final Property<View, PointF> R = new f(PointF.class, "topLeft");
    public static final Property<View, PointF> S = new g(PointF.class, "position");
    public static b.t.g T = new b.t.g();
    public int[] J = new int[2];
    public boolean K = false;
    public boolean L = false;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f1096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1097c;
        public final /* synthetic */ float d;

        public a(b bVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.f1095a = viewGroup;
            this.f1096b = bitmapDrawable;
            this.f1097c = view;
            this.d = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u uVarA = v.a(this.f1095a);
            ((t) uVarA).f1154a.remove(this.f1096b);
            v.f1155a.e(this.f1097c, this.d);
        }
    }

    /* JADX INFO: renamed from: b.t.b$b, reason: collision with other inner class name */
    public static class C0045b extends Property<Drawable, PointF> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f1098a;

        public C0045b(Class cls, String str) {
            super(cls, str);
            this.f1098a = new Rect();
        }

        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f1098a);
            Rect rect = this.f1098a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.f1098a);
            this.f1098a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.f1098a);
        }
    }

    public static class c extends Property<k, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        public void set(k kVar, PointF pointF) {
            k kVar2 = kVar;
            PointF pointF2 = pointF;
            if (kVar2 == null) {
                throw null;
            }
            kVar2.f1105a = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            kVar2.f1106b = iRound;
            int i = kVar2.f + 1;
            kVar2.f = i;
            if (i == kVar2.g) {
                v.d(kVar2.e, kVar2.f1105a, iRound, kVar2.f1107c, kVar2.d);
                kVar2.f = 0;
                kVar2.g = 0;
            }
        }
    }

    public static class d extends Property<k, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        public void set(k kVar, PointF pointF) {
            k kVar2 = kVar;
            PointF pointF2 = pointF;
            if (kVar2 == null) {
                throw null;
            }
            kVar2.f1107c = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            kVar2.d = iRound;
            int i = kVar2.g + 1;
            kVar2.g = i;
            if (kVar2.f == i) {
                v.d(kVar2.e, kVar2.f1105a, kVar2.f1106b, kVar2.f1107c, iRound);
                kVar2.f = 0;
                kVar2.g = 0;
            }
        }
    }

    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            v.d(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            v.d(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    public static class g extends Property<View, PointF> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int iRound = Math.round(pointF2.x);
            int iRound2 = Math.round(pointF2.y);
            v.d(view2, iRound, iRound2, view2.getWidth() + iRound, view2.getHeight() + iRound2);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f1099a;
        public k mViewBounds;

        public h(b bVar, k kVar) {
            this.f1099a = kVar;
            this.mViewBounds = this.f1099a;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f1102c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public i(b bVar, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f1101b = view;
            this.f1102c = rect;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1100a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1100a) {
                return;
            }
            b.i.m.l.a0(this.f1101b, this.f1102c);
            v.d(this.f1101b, this.d, this.e, this.f, this.g);
        }
    }

    public class j extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1103a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1104b;

        public j(b bVar, ViewGroup viewGroup) {
            this.f1104b = viewGroup;
        }

        @Override // b.t.l, b.t.i.d
        public void b(b.t.i iVar) {
            s.a(this.f1104b, false);
            this.f1103a = true;
        }

        @Override // b.t.i.d
        public void c(b.t.i iVar) {
            if (!this.f1103a) {
                s.a(this.f1104b, false);
            }
            iVar.w(this);
        }

        @Override // b.t.l, b.t.i.d
        public void d(b.t.i iVar) {
            s.a(this.f1104b, false);
        }

        @Override // b.t.l, b.t.i.d
        public void e(b.t.i iVar) {
            s.a(this.f1104b, true);
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1107c;
        public int d;
        public View e;
        public int f;
        public int g;

        public k(View view) {
            this.e = view;
        }
    }

    public final void I(q qVar) {
        View view = qVar.f1148b;
        if (!b.i.m.l.E(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        qVar.f1147a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        qVar.f1147a.put("android:changeBounds:parent", qVar.f1148b.getParent());
        if (this.L) {
            qVar.f1148b.getLocationInWindow(this.J);
            qVar.f1147a.put("android:changeBounds:windowX", Integer.valueOf(this.J[0]));
            qVar.f1147a.put("android:changeBounds:windowY", Integer.valueOf(this.J[1]));
        }
        if (this.K) {
            qVar.f1147a.put("android:changeBounds:clip", view.getClipBounds());
        }
    }

    @Override // b.t.i
    public void e(q qVar) {
        I(qVar);
    }

    @Override // b.t.i
    public void h(q qVar) {
        I(qVar);
    }

    @Override // b.t.i
    public Animator l(ViewGroup viewGroup, q qVar, q qVar2) {
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator animatorB;
        Path pathA;
        Property<View, PointF> property;
        q qVarO;
        if (qVar == null || qVar2 == null) {
            return null;
        }
        Map<String, Object> map = qVar.f1147a;
        Map<String, Object> map2 = qVar2.f1147a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = qVar2.f1148b;
        if (!(!this.L || ((qVarO = o(viewGroup2, true)) != null ? viewGroup3 == qVarO.f1148b : viewGroup2 == viewGroup3))) {
            int iIntValue = ((Integer) qVar.f1147a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) qVar.f1147a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) qVar2.f1147a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) qVar2.f1147a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.J);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fB = v.b(view2);
            v.f1155a.e(view2, 0.0f);
            viewGroup.getOverlay().add(bitmapDrawable);
            b.t.e eVar = this.F;
            int[] iArr = this.J;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolder.ofObject(N, (TypeConverter) null, eVar.a(iIntValue - iArr[0], iIntValue2 - iArr[1], iIntValue3 - iArr[0], iIntValue4 - iArr[1])));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, fB));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect2 = (Rect) qVar.f1147a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) qVar2.f1147a.get("android:changeBounds:bounds");
        int i4 = rect2.left;
        int i5 = rect3.left;
        int i6 = rect2.top;
        int i7 = rect3.top;
        int i8 = rect2.right;
        int i9 = rect3.right;
        int i10 = rect2.bottom;
        int i11 = rect3.bottom;
        int i12 = i8 - i4;
        int i13 = i10 - i6;
        int i14 = i9 - i5;
        int i15 = i11 - i7;
        Rect rect4 = (Rect) qVar.f1147a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) qVar2.f1147a.get("android:changeBounds:clip");
        if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
            i2 = 0;
        } else {
            i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
            if (i8 != i9 || i10 != i11) {
                i2++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        if (this.K) {
            view = view2;
            v.d(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
            ObjectAnimator objectAnimatorB0 = (i4 == i5 && i6 == i7) ? null : a.a.a.a.a.b0(view, S, this.F.a(i4, i6, i5, i7));
            if (rect4 == null) {
                i3 = 0;
                rect = new Rect(0, 0, i12, i13);
            } else {
                i3 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                b.i.m.l.a0(view, rect);
                b.t.g gVar = T;
                Object[] objArr = new Object[2];
                objArr[i3] = rect;
                objArr[1] = rect6;
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", gVar, objArr);
                objectAnimatorOfObject.addListener(new i(this, view, rect5, i5, i7, i9, i11));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorB = p.b(objectAnimatorB0, objectAnimator);
        } else {
            view = view2;
            v.d(view, i4, i6, i8, i10);
            if (i2 == 2) {
                if (i12 == i14 && i13 == i15) {
                    pathA = this.F.a(i4, i6, i5, i7);
                    property = S;
                } else {
                    k kVar = new k(view);
                    ObjectAnimator objectAnimatorB02 = a.a.a.a.a.b0(kVar, O, this.F.a(i4, i6, i5, i7));
                    ObjectAnimator objectAnimatorB03 = a.a.a.a.a.b0(kVar, P, this.F.a(i8, i10, i9, i11));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(objectAnimatorB02, objectAnimatorB03);
                    animatorSet.addListener(new h(this, kVar));
                    animatorB = animatorSet;
                }
            } else if (i4 == i5 && i6 == i7) {
                pathA = this.F.a(i8, i10, i9, i11);
                property = Q;
            } else {
                pathA = this.F.a(i4, i6, i5, i7);
                property = R;
            }
            animatorB = a.a.a.a.a.b0(view, property, pathA);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            s.a(viewGroup4, true);
            a(new j(this, viewGroup4));
        }
        return animatorB;
    }

    @Override // b.t.i
    public String[] q() {
        return M;
    }
}
