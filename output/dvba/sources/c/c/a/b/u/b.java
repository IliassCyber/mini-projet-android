package c.c.a.b.u;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f1684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f1685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f1686c;
    public final ColorStateList d;
    public final int e;
    public final c.c.a.b.d0.j f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, c.c.a.b.d0.j jVar, Rect rect) {
        a.a.a.a.a.f(rect.left);
        a.a.a.a.a.f(rect.top);
        a.a.a.a.a.f(rect.right);
        a.a.a.a.a.f(rect.bottom);
        this.f1684a = rect;
        this.f1685b = colorStateList2;
        this.f1686c = colorStateList;
        this.d = colorStateList3;
        this.e = i;
        this.f = jVar;
    }

    public static b a(Context context, int i) {
        if (!(i != 0)) {
            throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, c.c.a.b.k.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(c.c.a.b.k.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(c.c.a.b.k.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(c.c.a.b.k.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(c.c.a.b.k.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListZ = c.c.a.a.c.l.q.z(context, typedArrayObtainStyledAttributes, c.c.a.b.k.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListZ2 = c.c.a.a.c.l.q.z(context, typedArrayObtainStyledAttributes, c.c.a.b.k.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListZ3 = c.c.a.a.c.l.q.z(context, typedArrayObtainStyledAttributes, c.c.a.b.k.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.c.a.b.k.MaterialCalendarItem_itemStrokeWidth, 0);
        c.c.a.b.d0.j jVarA = c.c.a.b.d0.j.a(context, typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), new c.c.a.b.d0.a(0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new b(colorStateListZ, colorStateListZ2, colorStateListZ3, dimensionPixelSize, jVarA, rect);
    }

    public void b(TextView textView) {
        c.c.a.b.d0.g gVar = new c.c.a.b.d0.g();
        c.c.a.b.d0.g gVar2 = new c.c.a.b.d0.g();
        gVar.setShapeAppearanceModel(this.f);
        gVar2.setShapeAppearanceModel(this.f);
        gVar.q(this.f1686c);
        gVar.t(this.e, this.d);
        textView.setTextColor(this.f1685b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f1685b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f1684a;
        b.i.m.l.Z(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
