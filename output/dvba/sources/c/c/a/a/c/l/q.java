package c.c.a.a.c.l;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewParent;
import b.b.p.x0;
import c.c.a.a.f.c.b1;
import c.c.a.a.f.c.n1;
import c.c.a.b.d0.g;
import c.c.a.b.t.c;
import c.c.b.i.d;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.KotlinVersion;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f1399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f1400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f1401c;

    public static ColorStateList A(Context context, x0 x0Var, int i) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!x0Var.f507b.hasValue(i) || (resourceId = x0Var.f507b.getResourceId(i, 0)) == 0 || (colorStateListA = b.b.l.a.a.a(context, resourceId)) == null) ? x0Var.c(i) : colorStateListA;
    }

    public static int A0(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(B0(i, i2, "index"));
        }
        return i;
    }

    public static Calendar B(Calendar calendar) {
        Calendar calendarG = G(calendar);
        Calendar calendarF = F();
        calendarF.set(calendarG.get(1), calendarG.get(2), calendarG.get(5));
        return calendarF;
    }

    public static String B0(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return s0("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return s0("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static Drawable C(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableB = b.b.l.a.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableB;
    }

    public static void C0(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static TimeZone D() {
        return TimeZone.getTimeZone("UTC");
    }

    public static void D0(Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt(i | (i2 << 16));
        } else {
            parcel.writeInt(i | (-65536));
            parcel.writeInt(i2);
        }
    }

    public static Calendar E() {
        return B(Calendar.getInstance());
    }

    public static Calendar F() {
        return G(null);
    }

    public static Calendar G(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(D());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    public static boolean H() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @TargetApi(20)
    public static boolean I(Context context) {
        if (f1399a == null) {
            f1399a = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f1399a.booleanValue();
    }

    @TargetApi(26)
    public static boolean J(Context context) {
        if (I(context)) {
            if (Build.VERSION.SDK_INT >= 24) {
                if (f1400b == null) {
                    f1400b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
                }
                if (!f1400b.booleanValue() || H()) {
                }
            }
            return true;
        }
        return false;
    }

    public static int K(int i, int i2, float f) {
        return b.i.f.a.a(b.i.f.a.c(i2, Math.round(Color.alpha(i2) * f)), i);
    }

    public static float L(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }

    public static PorterDuff.Mode M(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void N(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        list.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(list);
    }

    public static boolean O(Parcel parcel, int i) {
        v0(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static IBinder P(Parcel parcel, int i) {
        int iT = T(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iT);
        return strongBinder;
    }

    public static int Q(Parcel parcel, int i) {
        v0(parcel, i, 4);
        return parcel.readInt();
    }

    public static long R(Parcel parcel, int i) {
        v0(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long S(Parcel parcel, int i) {
        int iT = T(parcel, i);
        if (iT == 0) {
            return null;
        }
        z0(parcel, iT, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int T(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static TypedValue U(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean V(Context context, int i, boolean z) {
        TypedValue typedValueU = U(context, i);
        return (typedValueU == null || typedValueU.type != 18) ? z : typedValueU.data != 0;
    }

    public static int W(Context context, int i, String str) {
        TypedValue typedValueU = U(context, i);
        if (typedValueU != null) {
            return typedValueU.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static void X(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof c.c.a.b.d0.g) {
            c.c.a.b.d0.g gVar = (c.c.a.b.d0.g) background;
            g.b bVar = gVar.f1555b;
            if (bVar.o != f) {
                bVar.o = f;
                gVar.x();
            }
        }
    }

    public static void Y(View view, c.c.a.b.d0.g gVar) {
        c.c.a.b.v.a aVar = gVar.f1555b.f1559b;
        if (aVar != null && aVar.f1718a) {
            float fM = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                fM += b.i.m.l.m((View) parent);
            }
            g.b bVar = gVar.f1555b;
            if (bVar.n != fM) {
                bVar.n = fM;
                gVar.x();
            }
        }
    }

    public static void Z(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + T(parcel, i));
    }

    public static int a(Parcel parcel) {
        return n0(parcel, 20293);
    }

    public static PorterDuffColorFilter a0(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static int b0(Parcel parcel) {
        int i = parcel.readInt();
        int iT = T(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if ((65535 & i) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw new c.c.a.a.c.l.u.b(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = iT + iDataPosition;
        if (i2 >= iDataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(iDataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new c.c.a.a.c.l.u.b(sb.toString(), parcel);
    }

    public static void c(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    public static void c0(Parcel parcel, int i, boolean z) {
        D0(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    public static void d0(Parcel parcel, int i, int i2) {
        D0(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static String e(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void e0(Parcel parcel, int i, long j) {
        D0(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static <T> T f(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    public static void f0(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            D0(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            D0(parcel, i, 0);
        }
    }

    public static <T> T g(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void g0(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                D0(parcel, i, 0);
            }
        } else {
            int iN0 = n0(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C0(parcel, iN0);
        }
    }

    public static <T> T h(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void h0(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                D0(parcel, i, 0);
            }
        } else {
            int iN0 = n0(parcel, i);
            parcel.writeString(str);
            C0(parcel, iN0);
        }
    }

    public static void i(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void i0(Parcel parcel, int i, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                D0(parcel, i, 0);
            }
        } else {
            int iN0 = n0(parcel, i);
            parcel.writeStringList(list);
            C0(parcel, iN0);
        }
    }

    public static c.c.b.i.d<?> j(String str, String str2) {
        final c.c.b.n.a aVar = new c.c.b.n.a(str, str2);
        d.b bVarA = c.c.b.i.d.a(c.c.b.n.e.class);
        bVarA.d = 1;
        bVarA.c(new c.c.b.i.g(aVar) { // from class: c.c.b.i.c

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f1885a;

            {
                this.f1885a = aVar;
            }

            @Override // c.c.b.i.g
            public Object a(a aVar2) {
                return this.f1885a;
            }
        });
        return bVarA.b();
    }

    public static <T extends Parcelable> void j0(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                D0(parcel, i, 0);
                return;
            }
            return;
        }
        int iN0 = n0(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                w0(parcel, t, i2);
            }
        }
        C0(parcel, iN0);
    }

    public static Bundle k(Parcel parcel, int i) {
        int iT = T(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iT);
        return bundle;
    }

    public static <T extends Parcelable> void k0(Parcel parcel, int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                D0(parcel, i, 0);
                return;
            }
            return;
        }
        int iN0 = n0(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                w0(parcel, t, 0);
            }
        }
        C0(parcel, iN0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Animator l(c.c.a.b.t.c cVar, float f, float f2, float f3) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(cVar, (Property<c.c.a.b.t.c, V>) c.C0063c.f1677a, (TypeEvaluator) c.b.f1675b, (Object[]) new c.e[]{new c.e(f, f2, f3)});
        c.e revealInfo = cVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f, (int) f2, revealInfo.f1681c, f3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    public static int l0(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    public static c.c.a.b.d0.d m(int i) {
        return i != 0 ? i != 1 ? new c.c.a.b.d0.i() : new c.c.a.b.d0.e() : new c.c.a.b.d0.i();
    }

    public static int m0(int i, int i2) {
        String strS0;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strS0 = s0("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(26);
                sb.append("negative size: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
            strS0 = s0("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strS0);
    }

    public static <T extends Parcelable> T n(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iT = T(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iT);
        return tCreateFromParcel;
    }

    public static int n0(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static String o(Parcel parcel, int i) {
        int iT = T(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iT);
        return string;
    }

    public static int o0(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static ArrayList<String> p(Parcel parcel, int i) {
        int iT = T(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iT);
        return arrayListCreateStringArrayList;
    }

    public static Status p0(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Status(17499, null);
        }
        String[] strArrSplit = str.split(":", 2);
        strArrSplit[0] = strArrSplit[0].trim();
        if (strArrSplit.length > 1 && strArrSplit[1] != null) {
            strArrSplit[1] = strArrSplit[1].trim();
        }
        List listAsList = Arrays.asList(strArrSplit);
        return listAsList.size() > 1 ? q0((String) listAsList.get(0), (String) listAsList.get(1)) : q0((String) listAsList.get(0), null);
    }

    public static <T> T[] q(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iT = T(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iT);
        return tArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0329  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.common.api.Status q0(java.lang.String r4, java.lang.String r5) {
        /*
            Method dump skipped, instruction units count: 1506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.c.l.q.q0(java.lang.String, java.lang.String):com.google.android.gms.common.api.Status");
    }

    public static <T> ArrayList<T> r(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iT = T(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iT);
        return arrayListCreateTypedArrayList;
    }

    public static n1 r0(c.c.b.h.b bVar, String str) {
        f(bVar);
        if (c.c.b.h.r.class.isAssignableFrom(bVar.getClass())) {
            c.c.b.h.r rVar = (c.c.b.h.r) bVar;
            f(rVar);
            return new n1(rVar.f1876b, rVar.f1877c, "google.com", null, null, str, null, null);
        }
        if (c.c.b.h.d.class.isAssignableFrom(bVar.getClass())) {
            c.c.b.h.d dVar = (c.c.b.h.d) bVar;
            f(dVar);
            return new n1(null, dVar.f1827b, "facebook.com", null, null, str, null, null);
        }
        if (c.c.b.h.a0.class.isAssignableFrom(bVar.getClass())) {
            c.c.b.h.a0 a0Var = (c.c.b.h.a0) bVar;
            f(a0Var);
            return new n1(null, a0Var.f1775b, "twitter.com", a0Var.f1776c, null, str, null, null);
        }
        if (c.c.b.h.q.class.isAssignableFrom(bVar.getClass())) {
            c.c.b.h.q qVar = (c.c.b.h.q) bVar;
            f(qVar);
            return new n1(null, qVar.f1875b, "github.com", null, null, str, null, null);
        }
        if (c.c.b.h.z.class.isAssignableFrom(bVar.getClass())) {
            c.c.b.h.z zVar = (c.c.b.h.z) bVar;
            f(zVar);
            return new n1(null, null, "playgames.google.com", null, zVar.f1883b, str, null, null);
        }
        if (!c.c.b.h.g0.class.isAssignableFrom(bVar.getClass())) {
            throw new IllegalArgumentException("Unsupported credential type.");
        }
        c.c.b.h.g0 g0Var = (c.c.b.h.g0) bVar;
        f(g0Var);
        n1 n1Var = g0Var.e;
        return n1Var != null ? n1Var : new n1(g0Var.f1868c, g0Var.d, g0Var.f1867b, g0Var.g, null, str, g0Var.f, g0Var.h);
    }

    public static <T extends c.c.a.a.c.l.u.c> T s(byte[] bArr, Parcelable.Creator<T> creator) {
        f(creator);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }

    public static String s0(@NullableDecl String str, @NullableDecl Object... objArr) {
        int iIndexOf;
        String string;
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String string2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String strValueOf = String.valueOf(string2);
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", strValueOf.length() != 0 ? "Exception during lenientFormat for ".concat(strValueOf) : new String("Exception during lenientFormat for "), (Throwable) e);
                    String name2 = e.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(name2.length() + String.valueOf(string2).length() + 9);
                    sb2.append("<");
                    sb2.append(string2);
                    sb2.append(" threw ");
                    sb2.append(name2);
                    sb2.append(">");
                    string = sb2.toString();
                }
            }
            objArr[i2] = string;
        }
        StringBuilder sb3 = new StringBuilder((objArr.length * 16) + str.length());
        int i3 = 0;
        while (i < objArr.length && (iIndexOf = str.indexOf("%s", i3)) != -1) {
            sb3.append((CharSequence) str, i3, iIndexOf);
            sb3.append(objArr[i]);
            i3 = iIndexOf + 2;
            i++;
        }
        sb3.append((CharSequence) str, i3, str.length());
        if (i < objArr.length) {
            sb3.append(" [");
            sb3.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb3.append(", ");
                sb3.append(objArr[i4]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }

    public static String t() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public static List<c.c.b.h.s> t0(List<b1> list) {
        if (list == null || list.isEmpty()) {
            return c.c.a.a.f.c.n.h();
        }
        ArrayList arrayList = new ArrayList();
        for (b1 b1Var : list) {
            c.c.b.h.y yVar = null;
            if (b1Var != null && !TextUtils.isEmpty(b1Var.f1434b)) {
                yVar = new c.c.b.h.y(b1Var.f1435c, b1Var.d, b1Var.e, b1Var.f1434b);
            }
            if (yVar != null) {
                arrayList.add(yVar);
            }
        }
        return arrayList;
    }

    public static float u(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f3 - f, f4 - f2);
    }

    public static void u0(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? B0(i, i3, "start index") : (i2 < 0 || i2 > i3) ? B0(i2, i3, "end index") : s0("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static void v(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new c.c.a.a.c.l.u.b(sb.toString(), parcel);
    }

    public static void v0(Parcel parcel, int i, int i2) {
        int iT = T(parcel, i);
        if (iT == i2) {
            return;
        }
        String hexString = Integer.toHexString(iT);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(iT);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new c.c.a.a.c.l.u.b(sb.toString(), parcel);
    }

    public static <TResult> c.c.a.a.h.d<TResult> w(Exception exc) {
        c.c.a.a.h.t tVar = new c.c.a.a.h.t();
        tVar.c(exc);
        return tVar;
    }

    public static <T extends Parcelable> void w0(Parcel parcel, T t, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static int x(Context context, int i, int i2) {
        TypedValue typedValueU = U(context, i);
        return typedValueU != null ? typedValueU.data : i2;
    }

    public static void x0(Object obj, Object obj2) {
        if (obj == null) {
            String strValueOf = String.valueOf(obj2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("null key in entry: null=");
            sb.append(strValueOf);
            throw new NullPointerException(sb.toString());
        }
        if (obj2 != null) {
            return;
        }
        String strValueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 26);
        sb2.append("null value in entry: ");
        sb2.append(strValueOf2);
        sb2.append("=null");
        throw new NullPointerException(sb2.toString());
    }

    public static int y(View view, int i) {
        return W(view.getContext(), i, view.getClass().getCanonicalName());
    }

    public static boolean y0(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static ColorStateList z(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListA = b.b.l.a.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListA;
    }

    public static void z0(Parcel parcel, int i, int i2) {
        if (i == i2) {
            return;
        }
        String hexString = Integer.toHexString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(i);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new c.c.a.a.c.l.u.b(sb.toString(), parcel);
    }
}
