package a.a.a.a;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Property;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.InflateException;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.biometric.DeviceCredentialHandlerActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.b.p.a1;
import b.b.p.e1;
import b.d.b;
import b.d.i;
import b.i.f.c;
import b.i.f.k.d;
import b.i.k.b;
import b.i.m.g;
import b.i.m.h;
import b.l.a.e;
import b.r.d.t;
import c.a.b.b;
import c.a.b.j;
import c.a.b.l;
import c.a.b.v;
import c.a.b.w.f;
import c.c.a.a.c.l.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f0a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f2c;
    public static boolean d;
    public static Field e;
    public static boolean f;
    public static Field g;
    public static boolean h;
    public static Method i;
    public static boolean j;
    public static Method k;
    public static boolean l;
    public static Field m;
    public static boolean n;
    public static Method o;
    public static boolean p;
    public static Field q;
    public static boolean r;

    public static Drawable A(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!n) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                m = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e2);
            }
            n = true;
        }
        Field field = m;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e3) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e3);
                m = null;
            }
        }
        return null;
    }

    public static List<byte[]> A0(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    public static int B(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (!l) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                k = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e2);
            }
            l = true;
        }
        Method method = k;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e3) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e3);
                k = null;
            }
        }
        return 0;
    }

    public static p B0(Object obj) {
        return new p(obj, null);
    }

    public static int C(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !N(xmlPullParser, str) ? i3 : typedArray.getColor(i2, i3);
    }

    public static Drawable C0(Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof b.i.f.k.a)) ? new d(drawable) : drawable;
    }

    public static b.i.e.b.a D(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2, int i3) {
        b.i.e.b.a aVarA;
        if (N(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i4 = typedValue.type;
            if (i4 >= 28 && i4 <= 31) {
                return new b.i.e.b.a(null, null, typedValue.data);
            }
            try {
                aVarA = b.i.e.b.a.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            } catch (Exception e2) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
                aVarA = null;
            }
            if (aVarA != null) {
                return aVarA;
            }
        }
        return new b.i.e.b.a(null, null, i3);
    }

    public static ActionMode.Callback D0(TextView textView, ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof b.i.n.d)) ? callback : new b.i.n.d(callback, textView);
    }

    public static float E(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, float f2) {
        return !N(xmlPullParser, str) ? f2 : typedArray.getFloat(i2, f2);
    }

    public static int F(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !N(xmlPullParser, str) ? i3 : typedArray.getInt(i2, i3);
    }

    public static String G(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (N(xmlPullParser, str)) {
            return typedArray.getString(i2);
        }
        return null;
    }

    public static PropertyValuesHolder H(TypedArray typedArray, int i2, int i3, int i4, String str) {
        PropertyValuesHolder propertyValuesHolderOfInt;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i3);
        boolean z = typedValuePeekValue != null;
        int i5 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i4);
        boolean z2 = typedValuePeekValue2 != null;
        int i6 = z2 ? typedValuePeekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((z && P(i5)) || (z2 && P(i6))) ? 3 : 0;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i2 != 2) {
            b.u.a.a.d dVar = i2 == 3 ? b.u.a.a.d.f1167a : null;
            if (z3) {
                if (z) {
                    float dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                    if (z2) {
                        propertyValuesHolderOfInt = PropertyValuesHolder.ofFloat(str, dimension, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                    } else {
                        propertyValuesHolderOfInt = PropertyValuesHolder.ofFloat(str, dimension);
                    }
                } else {
                    propertyValuesHolderOfInt = PropertyValuesHolder.ofFloat(str, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                }
            } else {
                if (!z) {
                    if (z2) {
                        propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : P(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
                    }
                    if (propertyValuesHolder == null && dVar != null) {
                        propertyValuesHolder.setEvaluator(dVar);
                        return propertyValuesHolder;
                    }
                }
                int dimension2 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : P(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                if (z2) {
                    propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : P(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
                } else {
                    propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2);
                }
            }
            propertyValuesHolder = propertyValuesHolderOfInt;
            return propertyValuesHolder == null ? propertyValuesHolder : propertyValuesHolder;
        }
        String string = typedArray.getString(i3);
        String string2 = typedArray.getString(i4);
        c[] cVarArrV = v(string);
        c[] cVarArrV2 = v(string2);
        if (cVarArrV == null && cVarArrV2 == null) {
            return null;
        }
        if (cVarArrV == null) {
            if (cVarArrV2 != null) {
                return PropertyValuesHolder.ofObject(str, new b.u.a.a.c(), cVarArrV2);
            }
            return null;
        }
        b.u.a.a.c cVar = new b.u.a.a.c();
        if (cVarArrV2 == null) {
            propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, cVar, cVarArrV);
        } else {
            if (!e(cVarArrV, cVarArrV2)) {
                throw new InflateException(" Can't morph from " + string + " to " + string2);
            }
            propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, cVar, cVarArrV, cVarArrV2);
        }
        return propertyValuesHolderOfObject;
    }

    public static Intent I(Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String strK = K(activity, activity.getComponentName());
            if (strK == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, strK);
            try {
                return K(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strK + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Intent J(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strK = K(context, componentName);
        if (strK == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strK);
        return K(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String K(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i2 = Build.VERSION.SDK_INT;
        int i3 = 640;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            i3 = 269222528;
        } else if (i4 >= 24) {
            i3 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i3);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static File L(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        StringBuilder sbE = c.a.a.a.a.e(".font");
        sbE.append(Process.myPid());
        sbE.append("-");
        sbE.append(Process.myTid());
        sbE.append("-");
        String string = sbE.toString();
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(cacheDir, string + i2);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.i.k.b.a M(android.widget.TextView r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L10
            b.i.k.b$a r0 = new b.i.k.b$a
            android.text.PrecomputedText$Params r8 = r8.getTextMetricsParams()
            r0.<init>(r8)
            return r0
        L10:
            android.text.TextPaint r0 = new android.text.TextPaint
            android.text.TextPaint r2 = r8.getPaint()
            r0.<init>(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 0
            r4 = 23
            r5 = 1
            if (r2 < r4) goto L24
            r2 = 1
            r6 = 1
            goto L26
        L24:
            r2 = 0
            r6 = 0
        L26:
            android.text.TextDirectionHeuristic r7 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r4) goto L34
            int r2 = r8.getBreakStrategy()
            int r6 = r8.getHyphenationFrequency()
        L34:
            android.text.method.TransformationMethod r4 = r8.getTransformationMethod()
            boolean r4 = r4 instanceof android.text.method.PasswordTransformationMethod
            if (r4 == 0) goto L3f
        L3c:
            android.text.TextDirectionHeuristic r8 = android.text.TextDirectionHeuristics.LTR
            goto L86
        L3f:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r1) goto L68
            int r1 = r8.getInputType()
            r1 = r1 & 15
            r4 = 3
            if (r1 != r4) goto L68
            java.util.Locale r8 = r8.getTextLocale()
            android.icu.text.DecimalFormatSymbols r8 = android.icu.text.DecimalFormatSymbols.getInstance(r8)
            java.lang.String[] r8 = r8.getDigitStrings()
            r8 = r8[r3]
            int r8 = r8.codePointAt(r3)
            byte r8 = java.lang.Character.getDirectionality(r8)
            if (r8 == r5) goto L7e
            r1 = 2
            if (r8 != r1) goto L3c
            goto L7e
        L68:
            int r1 = r8.getLayoutDirection()
            if (r1 != r5) goto L6f
            r3 = 1
        L6f:
            int r8 = r8.getTextDirection()
            switch(r8) {
                case 2: goto L81;
                case 3: goto L3c;
                case 4: goto L7e;
                case 5: goto L7b;
                case 6: goto L84;
                case 7: goto L78;
                default: goto L76;
            }
        L76:
            if (r3 == 0) goto L84
        L78:
            android.text.TextDirectionHeuristic r8 = android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL
            goto L86
        L7b:
            android.text.TextDirectionHeuristic r8 = android.text.TextDirectionHeuristics.LOCALE
            goto L86
        L7e:
            android.text.TextDirectionHeuristic r8 = android.text.TextDirectionHeuristics.RTL
            goto L86
        L81:
            android.text.TextDirectionHeuristic r8 = android.text.TextDirectionHeuristics.ANYRTL_LTR
            goto L86
        L84:
            android.text.TextDirectionHeuristic r8 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
        L86:
            b.i.k.b$a r1 = new b.i.k.b$a
            r1.<init>(r0, r8, r2, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.M(android.widget.TextView):b.i.k.b$a");
    }

    public static boolean N(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static boolean O(Rect rect, Rect rect2, int i2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            return (i3 > i4 || rect.left >= i4) && rect.left > rect2.left;
        }
        if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            return (i5 > i6 || rect.top >= i6) && rect.top > rect2.top;
        }
        if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            return (i7 < i8 || rect.right <= i8) && rect.right < rect2.right;
        }
        if (i2 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
    }

    public static boolean P(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static boolean Q() {
        b bVar = b.j;
        return bVar != null && bVar.g;
    }

    public static boolean R() {
        boolean z;
        String line;
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return true;
        }
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        int i2 = 0;
        while (true) {
            if (i2 >= 10) {
                z = false;
                break;
            }
            if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return true;
        }
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
            processExec.destroy();
        } catch (Throwable unused) {
            if (processExec != null) {
                processExec.destroy();
            }
        }
        boolean z2 = line != null;
        return z2;
    }

    public static boolean S(Context context, String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i2)) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void T(String str, e eVar, Bundle bundle, Runnable runnable) {
        Object systemService;
        CharSequence charSequence;
        if (!(eVar instanceof DeviceCredentialHandlerActivity)) {
            Log.e(str, "Failed to check device credential. Parent handler not found.");
            return;
        }
        DeviceCredentialHandlerActivity deviceCredentialHandlerActivity = (DeviceCredentialHandlerActivity) eVar;
        if (Build.VERSION.SDK_INT >= 23) {
            systemService = deviceCredentialHandlerActivity.getSystemService(KeyguardManager.class);
        } else {
            systemService = deviceCredentialHandlerActivity.getSystemService("keyguard");
            if (!(systemService instanceof KeyguardManager)) {
                Log.e(str, "Failed to check device credential. KeyguardManager not found.");
                deviceCredentialHandlerActivity.u(0);
                return;
            }
        }
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        if (keyguardManager == null) {
            Log.e(str, "Failed to check device credential. KeyguardManager was null.");
            deviceCredentialHandlerActivity.u(0);
            return;
        }
        CharSequence charSequence2 = null;
        if (bundle != null) {
            charSequence2 = bundle.getCharSequence("title");
            charSequence = bundle.getCharSequence("subtitle");
        } else {
            charSequence = null;
        }
        Intent intentCreateConfirmDeviceCredentialIntent = keyguardManager.createConfirmDeviceCredentialIntent(charSequence2, charSequence);
        if (intentCreateConfirmDeviceCredentialIntent == null) {
            Log.e(str, "Failed to check device credential. Got null intent from Keyguard.");
            deviceCredentialHandlerActivity.u(0);
            return;
        }
        b bVarA = b.a();
        bVarA.g = true;
        bVarA.i = 2;
        if (runnable != null) {
            runnable.run();
        }
        intentCreateConfirmDeviceCredentialIntent.setFlags(134742016);
        deviceCredentialHandlerActivity.startActivityForResult(intentCreateConfirmDeviceCredentialIntent, 0);
    }

    public static ValueAnimator U(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
        ValueAnimator valueAnimator2;
        TypedArray typedArray;
        TypedArray typedArray2;
        ValueAnimator valueAnimator3;
        TypedArray typedArrayA0 = a0(resources, theme, attributeSet, b.u.a.a.a.g);
        TypedArray typedArrayA02 = a0(resources, theme, attributeSet, b.u.a.a.a.k);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        long jF = F(typedArrayA0, xmlPullParser, "duration", 1, 300);
        int resourceId = 0;
        long jF2 = F(typedArrayA0, xmlPullParser, "startOffset", 2, 0);
        int iF = F(typedArrayA0, xmlPullParser, "valueType", 7, 4);
        if (N(xmlPullParser, "valueFrom") && N(xmlPullParser, "valueTo")) {
            if (iF == 4) {
                TypedValue typedValuePeekValue = typedArrayA0.peekValue(5);
                boolean z = typedValuePeekValue != null;
                int i2 = z ? typedValuePeekValue.type : 0;
                TypedValue typedValuePeekValue2 = typedArrayA0.peekValue(6);
                boolean z2 = typedValuePeekValue2 != null;
                iF = ((z && P(i2)) || (z2 && P(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder propertyValuesHolderH = H(typedArrayA0, iF, 5, 6, "");
            if (propertyValuesHolderH != null) {
                valueAnimator4.setValues(propertyValuesHolderH);
            }
        }
        valueAnimator4.setDuration(jF);
        valueAnimator4.setStartDelay(jF2);
        valueAnimator4.setRepeatCount(F(typedArrayA0, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator4.setRepeatMode(F(typedArrayA0, xmlPullParser, "repeatMode", 4, 1));
        if (typedArrayA02 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String strG = G(typedArrayA02, xmlPullParser, "pathData", 1);
            if (strG != null) {
                String strG2 = G(typedArrayA02, xmlPullParser, "propertyXName", 2);
                String strG3 = G(typedArrayA02, xmlPullParser, "propertyYName", 3);
                if (strG2 == null && strG3 == null) {
                    throw new InflateException(typedArrayA02.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path pathW = w(strG);
                float f3 = 0.5f * f2;
                PathMeasure pathMeasure = new PathMeasure(pathW, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float length = 0.0f;
                do {
                    length += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(length));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(pathW, false);
                int iMin = Math.min(100, ((int) (length / f3)) + 1);
                float[] fArr = new float[iMin];
                float[] fArr2 = new float[iMin];
                float[] fArr3 = new float[2];
                float f4 = length / (iMin - 1);
                valueAnimator2 = valueAnimator4;
                typedArray = typedArrayA0;
                int i3 = 0;
                float f5 = 0.0f;
                while (true) {
                    if (resourceId >= iMin) {
                        break;
                    }
                    int i4 = iMin;
                    pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
                    fArr[resourceId] = fArr3[0];
                    fArr2[resourceId] = fArr3[1];
                    f5 += f4;
                    int i5 = i3 + 1;
                    if (i5 < arrayList.size() && f5 > ((Float) arrayList.get(i5)).floatValue()) {
                        pathMeasure2.nextContour();
                        i3 = i5;
                    }
                    resourceId++;
                    iMin = i4;
                }
                PropertyValuesHolder propertyValuesHolderOfFloat = strG2 != null ? PropertyValuesHolder.ofFloat(strG2, fArr) : null;
                PropertyValuesHolder propertyValuesHolderOfFloat2 = strG3 != null ? PropertyValuesHolder.ofFloat(strG3, fArr2) : null;
                if (propertyValuesHolderOfFloat == null) {
                    resourceId = 0;
                    objectAnimator.setValues(propertyValuesHolderOfFloat2);
                } else {
                    resourceId = 0;
                    if (propertyValuesHolderOfFloat2 == null) {
                        objectAnimator.setValues(propertyValuesHolderOfFloat);
                    } else {
                        objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                    }
                }
            } else {
                valueAnimator2 = valueAnimator4;
                typedArray = typedArrayA0;
                objectAnimator.setPropertyName(G(typedArrayA02, xmlPullParser, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = typedArrayA0;
        }
        if (N(xmlPullParser, "interpolator")) {
            typedArray2 = typedArray;
            resourceId = typedArray2.getResourceId(resourceId, resourceId);
        } else {
            typedArray2 = typedArray;
        }
        if (resourceId > 0) {
            valueAnimator3 = valueAnimator2;
            valueAnimator3.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        } else {
            valueAnimator3 = valueAnimator2;
        }
        typedArray2.recycle();
        if (typedArrayA02 != null) {
            typedArrayA02.recycle();
        }
        return valueAnimator3;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface V(android.content.Context r16, int r17, android.util.TypedValue r18, int r19, b.i.e.b.g r20, android.os.Handler r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.V(android.content.Context, int, android.util.TypedValue, int, b.i.e.b.g, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static int W(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else {
            if (i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i3 = rect2.top;
            i4 = rect.bottom;
        }
        return Math.max(0, i3 - i4);
    }

    public static int X(int i2, Rect rect, Rect rect2) {
        int iHeight;
        int i3;
        int iHeight2;
        if (i2 == 17) {
            iHeight = (rect.height() / 2) + rect.top;
            i3 = rect2.top;
            iHeight2 = rect2.height();
        } else {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
                iHeight = (rect.height() / 2) + rect.top;
                i3 = rect2.top;
                iHeight2 = rect2.height();
            }
            iHeight = (rect.width() / 2) + rect.left;
            i3 = rect2.left;
            iHeight2 = rect2.width();
        }
        return Math.abs(iHeight - ((iHeight2 / 2) + i3));
    }

    public static ByteBuffer Y(Context context, CancellationSignal cancellationSignal, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return map;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static c.a.b.p Z(Context context) {
        c.a.b.p pVar = new c.a.b.p(new c.a.b.w.d(new File(context.getCacheDir(), "volley")), new c.a.b.w.b(new f()));
        c.a.b.d dVar = pVar.i;
        if (dVar != null) {
            dVar.f = true;
            dVar.interrupt();
        }
        for (j jVar : pVar.h) {
            if (jVar != null) {
                jVar.f = true;
                jVar.interrupt();
            }
        }
        c.a.b.d dVar2 = new c.a.b.d(pVar.f1217c, pVar.d, pVar.e, pVar.g);
        pVar.i = dVar2;
        dVar2.start();
        for (int i2 = 0; i2 < pVar.h.length; i2++) {
            j jVar2 = new j(pVar.d, pVar.f, pVar.e, pVar.g);
            pVar.h[i2] = jVar2;
            jVar2.start();
        }
        return pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x070f  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0712  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x071b  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x072e  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x073e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0758 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(b.g.b.i.e r37, b.g.b.d r38, int r39) {
        /*
            Method dump skipped, instruction units count: 1894
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a(b.g.b.i.e, b.g.b.d, int):void");
    }

    public static TypedArray a0(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = c(r9, r10, r11)
            boolean r1 = c(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L7d
            if (r0 != 0) goto Lf
            goto L7d
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3d
            if (r9 == r3) goto L36
            if (r9 == r4) goto L2f
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L45
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L45
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L45
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L45
        L43:
            r7 = 1
            goto L46
        L45:
            r7 = 0
        L46:
            if (r7 != 0) goto L49
            return r6
        L49:
            if (r9 == r5) goto L7c
            if (r9 != r4) goto L4e
            goto L7c
        L4e:
            int r11 = W(r9, r10, r11)
            if (r9 == r5) goto L6f
            if (r9 == r3) goto L6a
            if (r9 == r4) goto L65
            if (r9 != r1) goto L5f
            int r9 = r12.bottom
            int r10 = r10.bottom
            goto L73
        L5f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L65:
            int r9 = r12.right
            int r10 = r10.right
            goto L73
        L6a:
            int r9 = r10.top
            int r10 = r12.top
            goto L73
        L6f:
            int r9 = r10.left
            int r10 = r12.left
        L73:
            int r9 = r9 - r10
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L7b
            r2 = 1
        L7b:
            return r2
        L7c:
            return r6
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.b(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static <T> ObjectAnimator b0(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
    }

    public static boolean c(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static InputConnection c0(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof e1) {
                    editorInfo.hintText = ((e1) parent).a();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }

    public static void d(Object obj, StringBuilder sb) {
        String hexString;
        int iLastIndexOf;
        if (obj == null) {
            hexString = "null";
        } else {
            String simpleName = obj.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(iLastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            hexString = Integer.toHexString(System.identityHashCode(obj));
        }
        sb.append(hexString);
    }

    public static boolean d0(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        try {
            return viewParent.onNestedFling(view, f2, f3, z);
        } catch (AbstractMethodError e2) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e2);
            return false;
        }
    }

    public static boolean e(c[] cVarArr, c[] cVarArr2) {
        if (cVarArr == null || cVarArr2 == null || cVarArr.length != cVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < cVarArr.length; i2++) {
            if (cVarArr[i2].f746a != cVarArr2[i2].f746a || cVarArr[i2].f747b.length != cVarArr2[i2].f747b.length) {
                return false;
            }
        }
        return true;
    }

    public static boolean e0(ViewParent viewParent, View view, float f2, float f3) {
        try {
            return viewParent.onNestedPreFling(view, f2, f3);
        } catch (AbstractMethodError e2) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e2);
            return false;
        }
    }

    public static int f(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static void f0(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof g) {
            ((g) viewParent).n(view, i2, i3, iArr, i4);
            return;
        }
        if (i4 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i2, i3, iArr);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e2);
            }
        }
    }

    public static <T> T g(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static void g0(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (viewParent instanceof h) {
            ((h) viewParent).k(view, i2, i3, i4, i5, i6, iArr);
            return;
        }
        iArr[0] = iArr[0] + i4;
        iArr[1] = iArr[1] + i5;
        if (viewParent instanceof g) {
            ((g) viewParent).l(view, i2, i3, i4, i5, i6);
            return;
        }
        if (i6 == 0) {
            try {
                viewParent.onNestedScroll(view, i2, i3, i4, i5);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e2);
            }
        }
    }

    public static <T> T h(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static b.i.e.b.b h0(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlPullParser.require(2, null, "font-family");
        if (!xmlPullParser.getName().equals("font-family")) {
            z0(xmlPullParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.i.c.FontFamily);
        String string = typedArrayObtainAttributes.getString(b.i.c.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(b.i.c.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(b.i.c.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(b.i.c.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(b.i.c.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(b.i.c.FontFamily_fontProviderFetchTimeout, 500);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                z0(xmlPullParser);
            }
            return new b.i.e.b.e(new b.i.j.a(string, string2, string3, l0(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.i.c.FontFamilyFont);
                    int i2 = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(b.i.c.FontFamilyFont_fontWeight) ? b.i.c.FontFamilyFont_fontWeight : b.i.c.FontFamilyFont_android_fontWeight, 400);
                    boolean z = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(b.i.c.FontFamilyFont_fontStyle) ? b.i.c.FontFamilyFont_fontStyle : b.i.c.FontFamilyFont_android_fontStyle, 0);
                    int i3 = typedArrayObtainAttributes2.hasValue(b.i.c.FontFamilyFont_ttcIndex) ? b.i.c.FontFamilyFont_ttcIndex : b.i.c.FontFamilyFont_android_ttcIndex;
                    String string4 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(b.i.c.FontFamilyFont_fontVariationSettings) ? b.i.c.FontFamilyFont_fontVariationSettings : b.i.c.FontFamilyFont_android_fontVariationSettings);
                    int i4 = typedArrayObtainAttributes2.getInt(i3, 0);
                    int i5 = typedArrayObtainAttributes2.hasValue(b.i.c.FontFamilyFont_font) ? b.i.c.FontFamilyFont_font : b.i.c.FontFamilyFont_android_font;
                    int resourceId2 = typedArrayObtainAttributes2.getResourceId(i5, 0);
                    String string5 = typedArrayObtainAttributes2.getString(i5);
                    typedArrayObtainAttributes2.recycle();
                    while (xmlPullParser.next() != 3) {
                        z0(xmlPullParser);
                    }
                    arrayList.add(new b.i.e.b.d(string5, i2, z, string4, i4, resourceId2));
                } else {
                    z0(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b.i.e.b.c((b.i.e.b.d[]) arrayList.toArray(new b.i.e.b.d[arrayList.size()]));
    }

    public static int i(Context context, String str) {
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) != -1) {
            String strPermissionToOp = Build.VERSION.SDK_INT >= 23 ? AppOpsManager.permissionToOp(str) : null;
            if (strPermissionToOp == null) {
                return 0;
            }
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                if (packagesForUid != null && packagesForUid.length > 0) {
                    packageName = packagesForUid[0];
                }
            }
            return (Build.VERSION.SDK_INT >= 23 ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, packageName) : 1) != 0 ? -2 : 0;
        }
        return -1;
    }

    public static b.a i0(l lVar) {
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = lVar.f1207b;
        String str = map.get("Date");
        long jK0 = str != null ? k0(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i2 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            int i3 = 0;
            j2 = 0;
            j3 = 0;
            while (i2 < strArrSplit.length) {
                String strTrim = strArrSplit[i2].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    i3 = 1;
                }
                i2++;
            }
            i2 = i3;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j3 = 0;
        }
        String str3 = map.get("Expires");
        long jK02 = str3 != null ? k0(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long jK03 = str4 != null ? k0(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j5 = jCurrentTimeMillis + (j2 * 1000);
            if (i2 != 0) {
                j6 = j5;
            } else {
                Long.signum(j3);
                j6 = (j3 * 1000) + j5;
            }
            j4 = j6;
        } else {
            j4 = 0;
            if (jK0 <= 0 || jK02 < jK0) {
                j5 = 0;
            } else {
                j5 = jCurrentTimeMillis + (jK02 - jK0);
                j4 = j5;
            }
        }
        b.a aVar = new b.a();
        aVar.f1186a = lVar.f1206a;
        aVar.f1187b = str5;
        aVar.f = j5;
        aVar.e = j4;
        aVar.f1188c = jK0;
        aVar.d = jK03;
        aVar.g = map;
        aVar.h = lVar.f1208c;
        return aVar;
    }

    public static int j(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static String j0(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] strArrSplit = str2.split(";", 0);
            for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                String[] strArrSplit2 = strArrSplit[i2].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        Drawable drawableA;
        int i2 = Build.VERSION.SDK_INT;
        drawable.clearColorFilter();
        if (i2 >= 23) {
            return;
        }
        if (drawable instanceof InsetDrawable) {
            drawableA = ((InsetDrawable) drawable).getDrawable();
        } else {
            if (!(drawable instanceof b.i.f.k.b)) {
                if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
                    return;
                }
                int childCount = drawableContainerState.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    Drawable child = drawableContainerState.getChild(i3);
                    if (child != null) {
                        k(child);
                    }
                }
                return;
            }
            drawableA = ((b.i.f.k.b) drawable).a();
        }
        k(drawableA);
    }

    public static long k0(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            Log.e("Volley", v.a("Unable to parse dateStr: %s, falling back to 0", str), e2);
            return 0L;
        }
    }

    public static int l(RecyclerView.a0 a0Var, t tVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.y() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.P(view) - oVar.P(view2)) + 1;
        }
        return Math.min(tVar.l(), tVar.b(view2) - tVar.e(view));
    }

    public static List<List<byte[]>> l0(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(A0(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(A0(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static int m(RecyclerView.a0 a0Var, t tVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.y() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (a0Var.b() - Math.max(oVar.P(view), oVar.P(view2))) - 1) : Math.max(0, Math.min(oVar.P(view), oVar.P(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(tVar.b(view2) - tVar.e(view)) / (Math.abs(oVar.P(view) - oVar.P(view2)) + 1))) + (tVar.k() - tVar.e(view)));
        }
        return iMax;
    }

    public static void m0(TextView textView, int i2) {
        f(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static int n(RecyclerView.a0 a0Var, t tVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.y() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a0Var.b();
        }
        return (int) (((tVar.b(view2) - tVar.e(view)) / (Math.abs(oVar.P(view) - oVar.P(view2)) + 1)) * a0Var.b());
    }

    public static void n0(TextView textView, int i2) {
        f(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static float[] o(float[] fArr, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i2 < 0 || i2 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = i3 - i2;
        int iMin = Math.min(i4, length - i2);
        float[] fArr2 = new float[i4];
        System.arraycopy(fArr, i2, fArr2, 0, iMin);
        return fArr2;
    }

    public static boolean o0(Drawable drawable, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i2);
        }
        if (!j) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                i = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e2);
            }
            j = true;
        }
        Method method = i;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i2));
                return true;
            } catch (Exception e3) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e3);
                i = null;
            }
        }
        return false;
    }

    public static boolean p(File file, Resources resources, int i2) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i2);
        } catch (Throwable th) {
            th = th;
            inputStreamOpenRawResource = null;
        }
        try {
            boolean zQ = q(file, inputStreamOpenRawResource);
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException unused) {
                }
            }
            return zQ;
        } catch (Throwable th2) {
            th = th2;
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static void p0(TextView textView, int i2) {
        f(i2);
        if (i2 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i2 - r0, 1.0f);
        }
    }

    public static boolean q(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return true;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static void q0(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
            return;
        }
        if (!r) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                q = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
            }
            r = true;
        }
        Field field = q;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e3) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x032a, code lost:
    
        if (r27 == null) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x032c, code lost:
    
        if (r13 == null) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x032e, code lost:
    
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x033d, code lost:
    
        if (r2.hasNext() == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x033f, code lost:
    
        r1[r3] = (android.animation.Animator) r2.next();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x034b, code lost:
    
        if (r28 != 0) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x034d, code lost:
    
        r27.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0351, code lost:
    
        r27.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0354, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x023f A[PHI: r14
  0x023f: PHI (r14v6 float) = (r14v5 float), (r14v7 float) binds: [B:115:0x0236, B:118:0x023d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0303  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator r(android.content.Context r22, android.content.res.Resources r23, android.content.res.Resources.Theme r24, org.xmlpull.v1.XmlPullParser r25, android.util.AttributeSet r26, android.animation.AnimatorSet r27, int r28, float r29) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.r(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static void r0(TextView textView, b.i.k.b bVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (bVar == null) {
                throw null;
            }
            textView.setText((CharSequence) null);
        } else {
            b.a aVarM = M(textView);
            if (bVar == null) {
                throw null;
            }
            if (!aVarM.a(null)) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(bVar);
        }
    }

    public static ColorStateList s(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return t(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static void s0(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList t(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.t(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static void t0(Drawable drawable, int i2) {
        drawable.setTint(i2);
    }

    public static Keyframe u(Keyframe keyframe, float f2) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f2) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f2) : Keyframe.ofObject(f2);
    }

    public static void u0(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
    
        if (r16 == false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0091 A[PHI: r14
  0x0091: PHI (r14v3 boolean) = (r14v1 boolean), (r14v1 boolean), (r14v6 boolean) binds: [B:32:0x007a, B:35:0x0080, B:41:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097 A[Catch: NumberFormatException -> 0x00b8, LOOP:3: B:29:0x006e->B:47:0x0097, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00b8, blocks: (B:26:0x005a, B:29:0x006e, B:31:0x0074, B:35:0x0080, B:47:0x0097, B:49:0x009d, B:52:0x00ad, B:54:0x00b2), top: B:69:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d A[Catch: NumberFormatException -> 0x00b8, TryCatch #0 {NumberFormatException -> 0x00b8, blocks: (B:26:0x005a, B:29:0x006e, B:31:0x0074, B:35:0x0080, B:47:0x0097, B:49:0x009d, B:52:0x00ad, B:54:0x00b2), top: B:69:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ad A[Catch: NumberFormatException -> 0x00b8, TryCatch #0 {NumberFormatException -> 0x00b8, blocks: (B:26:0x005a, B:29:0x006e, B:31:0x0074, B:35:0x0080, B:47:0x0097, B:49:0x009d, B:52:0x00ad, B:54:0x00b2), top: B:69:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0096 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.i.f.c[] v(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.v(java.lang.String):b.i.f.c[]");
    }

    public static void v0(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Path w(String str) {
        Path path = new Path();
        c[] cVarArrV = v(str);
        if (cVarArrV == null) {
            return null;
        }
        try {
            c.b(cVarArrV, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException(c.a.a.a.a.c("Error in parsing ", str), e2);
        }
    }

    public static void w0(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
            return;
        }
        a1 a1Var = a1.k;
        if (a1Var != null && a1Var.f398b == view) {
            a1.c(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new a1(view, charSequence);
            return;
        }
        a1 a1Var2 = a1.l;
        if (a1Var2 != null && a1Var2.f398b == view) {
            a1Var2.b();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static c[] x(c[] cVarArr) {
        if (cVarArr == null) {
            return null;
        }
        c[] cVarArr2 = new c[cVarArr.length];
        for (int i2 = 0; i2 < cVarArr.length; i2++) {
            cVarArr2[i2] = new c(cVarArr[i2]);
        }
        return cVarArr2;
    }

    public static void x0(PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i2);
            return;
        }
        if (!p) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                o = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            p = true;
        }
        Method method = o;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception unused2) {
            }
        }
    }

    public static boolean y(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean y0(Context context, String str) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return S(context, str, i.hide_fingerprint_instantly_prefixes);
    }

    public static void z(Object obj) {
        if (!d) {
            try {
                f2c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            d = true;
        }
        Class<?> cls = f2c;
        if (cls == null) {
            return;
        }
        if (!f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f = true;
        }
        Field field = e;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static void z0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }
}
