package c.c.a.b.u;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;

/* JADX INFO: loaded from: classes.dex */
public final class n<S> extends b.l.a.c {
    public static boolean c0(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(c.c.a.a.c.l.q.W(context, c.c.a.b.b.materialCalendarStyle, f.class.getCanonicalName()), new int[]{R.attr.windowFullscreen});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }
}
