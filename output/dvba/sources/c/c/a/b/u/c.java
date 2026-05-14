package c.c.a.b.u;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f1689c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;
    public final Paint h;

    public c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(c.c.a.a.c.l.q.W(context, c.c.a.b.b.materialCalendarStyle, f.class.getCanonicalName()), c.c.a.b.k.MaterialCalendar);
        this.f1687a = b.a(context, typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialCalendar_dayStyle, 0));
        this.g = b.a(context, typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialCalendar_dayInvalidStyle, 0));
        this.f1688b = b.a(context, typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialCalendar_daySelectedStyle, 0));
        this.f1689c = b.a(context, typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListZ = c.c.a.a.c.l.q.z(context, typedArrayObtainStyledAttributes, c.c.a.b.k.MaterialCalendar_rangeFillColor);
        this.d = b.a(context, typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialCalendar_yearStyle, 0));
        this.e = b.a(context, typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialCalendar_yearSelectedStyle, 0));
        this.f = b.a(context, typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(colorStateListZ.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
