package b.b.k;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import b.b.p.b0;
import b.b.p.u0;
import b.b.p.w;
import b.b.p.z;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class r {
    public static final String LOG_TAG = "AppCompatViewInflater";
    public final Object[] mConstructorArgs = new Object[2];
    public static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    public static final int[] sOnClickAttrs = {R.attr.onClick};
    public static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    public static final b.f.h<String, Constructor<? extends View>> sConstructorMap = new b.f.h<>();

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f282c;
        public Method d;
        public Context e;

        public a(View view, String str) {
            this.f281b = view;
            this.f282c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string;
            Method method;
            if (this.d == null) {
                Context context = this.f281b.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.f282c, View.class)) != null) {
                            this.d = method;
                            this.e = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                int id = this.f281b.getId();
                if (id == -1) {
                    string = "";
                } else {
                    StringBuilder sbE = c.a.a.a.a.e(" with id '");
                    sbE.append(this.f281b.getContext().getResources().getResourceEntryName(id));
                    sbE.append("'");
                    string = sbE.toString();
                }
                StringBuilder sbE2 = c.a.a.a.a.e("Could not find method ");
                sbE2.append(this.f282c);
                sbE2.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                sbE2.append(this.f281b.getClass());
                sbE2.append(string);
                throw new IllegalStateException(sbE2.toString());
            }
            try {
                this.d.invoke(this.e, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && b.i.m.l.A(view)) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private View createViewByPrefix(Context context, String str, String str2) {
        String str3;
        Constructor<? extends View> orDefault = sConstructorMap.getOrDefault(str, null);
        if (orDefault == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            orDefault = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);
            sConstructorMap.put(str, orDefault);
        }
        orDefault.setAccessible(true);
        return orDefault.newInstance(this.mConstructorArgs);
    }

    private View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return createViewByPrefix(context, str, null);
            }
            for (int i = 0; i < sClassPrefixList.length; i++) {
                View viewCreateViewByPrefix = createViewByPrefix(context, str, sClassPrefixList[i]);
                if (viewCreateViewByPrefix != null) {
                    return viewCreateViewByPrefix;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr = this.mConstructorArgs;
            objArr[0] = null;
            objArr[1] = null;
        }
    }

    public static Context themifyContext(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.j.View, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(b.b.j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(b.b.j.View_theme, 0)) != 0) {
            Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof b.b.o.c) && ((b.b.o.c) context).f319a == resourceId) ? context : new b.b.o.c(context, resourceId) : context;
    }

    private void verifyNotNull(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    public b.b.p.d createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new b.b.p.d(context, attributeSet);
    }

    public b.b.p.f createButton(Context context, AttributeSet attributeSet) {
        return new b.b.p.f(context, attributeSet);
    }

    public b.b.p.g createCheckBox(Context context, AttributeSet attributeSet) {
        return new b.b.p.g(context, attributeSet);
    }

    public b.b.p.h createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new b.b.p.h(context, attributeSet);
    }

    public b.b.p.k createEditText(Context context, AttributeSet attributeSet) {
        return new b.b.p.k(context, attributeSet);
    }

    public b.b.p.l createImageButton(Context context, AttributeSet attributeSet) {
        return new b.b.p.l(context, attributeSet);
    }

    public b.b.p.n createImageView(Context context, AttributeSet attributeSet) {
        return new b.b.p.n(context, attributeSet, 0);
    }

    public b.b.p.o createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new b.b.p.o(context, attributeSet);
    }

    public b.b.p.r createRadioButton(Context context, AttributeSet attributeSet) {
        return new b.b.p.r(context, attributeSet, b.b.a.radioButtonStyle);
    }

    public b.b.p.s createRatingBar(Context context, AttributeSet attributeSet) {
        return new b.b.p.s(context, attributeSet);
    }

    public b.b.p.t createSeekBar(Context context, AttributeSet attributeSet) {
        return new b.b.p.t(context, attributeSet);
    }

    public w createSpinner(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet, b.b.a.spinnerStyle);
    }

    public z createTextView(Context context, AttributeSet attributeSet) {
        return new z(context, attributeSet);
    }

    public b0 createToggleButton(Context context, AttributeSet attributeSet) {
        return new b0(context, attributeSet);
    }

    public View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View viewCreateTextView;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        if (z4) {
            u0.a(context2);
        }
        switch (str) {
            case "TextView":
                viewCreateTextView = createTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "ImageView":
                viewCreateTextView = createImageView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "Button":
                viewCreateTextView = createButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "EditText":
                viewCreateTextView = createEditText(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "Spinner":
                viewCreateTextView = createSpinner(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "ImageButton":
                viewCreateTextView = createImageButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "CheckBox":
                viewCreateTextView = createCheckBox(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "RadioButton":
                viewCreateTextView = createRadioButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "CheckedTextView":
                viewCreateTextView = createCheckedTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "AutoCompleteTextView":
                viewCreateTextView = createAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "MultiAutoCompleteTextView":
                viewCreateTextView = createMultiAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "RatingBar":
                viewCreateTextView = createRatingBar(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "SeekBar":
                viewCreateTextView = createSeekBar(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "ToggleButton":
                viewCreateTextView = createToggleButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            default:
                viewCreateTextView = createView(context2, str, attributeSet);
                break;
        }
        if (viewCreateTextView == null && context != context2) {
            viewCreateTextView = createViewFromTag(context2, str, attributeSet);
        }
        if (viewCreateTextView != null) {
            checkOnClickListener(viewCreateTextView, attributeSet);
        }
        return viewCreateTextView;
    }
}
