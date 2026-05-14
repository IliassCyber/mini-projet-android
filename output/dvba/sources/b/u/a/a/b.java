package b.u.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class b extends e implements Animatable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0048b f1160c;
    public Context d;
    public ArgbEvaluator e;
    public final Drawable.Callback f;

    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            b.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: renamed from: b.u.a.a.b$b, reason: collision with other inner class name */
    public static class C0048b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f1163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AnimatorSet f1164c;
        public ArrayList<Animator> d;
        public b.f.a<Animator, String> e;

        public C0048b(C0048b c0048b, Drawable.Callback callback, Resources resources) {
            if (c0048b != null) {
                this.f1162a = c0048b.f1162a;
                f fVar = c0048b.f1163b;
                if (fVar != null) {
                    Drawable.ConstantState constantState = fVar.getConstantState();
                    f fVar2 = (f) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    this.f1163b = fVar2;
                    fVar2.mutate();
                    this.f1163b = fVar2;
                    fVar2.setCallback(callback);
                    this.f1163b.setBounds(c0048b.f1163b.getBounds());
                    this.f1163b.g = false;
                }
                ArrayList<Animator> arrayList = c0048b.d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.d = new ArrayList<>(size);
                    this.e = new b.f.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = c0048b.d.get(i);
                        Animator animatorClone = animator.clone();
                        String orDefault = c0048b.e.getOrDefault(animator, null);
                        animatorClone.setTarget(this.f1163b.f1169c.f1180b.p.getOrDefault(orDefault, null));
                        this.d.add(animatorClone);
                        this.e.put(animatorClone, orDefault);
                    }
                    if (this.f1164c == null) {
                        this.f1164c = new AnimatorSet();
                    }
                    this.f1164c.playTogether(this.d);
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1162a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public b() {
        this(null, null, null);
    }

    public b(Context context, C0048b c0048b, Resources resources) {
        this.e = null;
        this.f = new a();
        this.d = context;
        this.f1160c = new C0048b(null, this.f, null);
    }

    @Override // b.u.a.a.e, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f1160c.f1163b.draw(canvas);
        if (this.f1160c.f1164c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getAlpha() : this.f1160c.f1163b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f1160c.f1162a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getColorFilter() : this.f1160c.f1163b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f1168b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f1168b.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f1160c.f1163b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f1160c.f1163b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getOpacity() : this.f1160c.f1163b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArrayObtainAttributes;
        String str;
        XmlResourceParser animation;
        Animator animatorR;
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        for (int i = 1; eventType != i && (xmlPullParser.getDepth() >= depth || eventType != 3); i = 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    typedArrayObtainAttributes = a.a.a.a.a.a0(resources, theme, attributeSet, b.u.a.a.a.e);
                    int resourceId = typedArrayObtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f fVarB = f.b(resources, resourceId, theme);
                        fVarB.g = false;
                        fVarB.setCallback(this.f);
                        f fVar = this.f1160c.f1163b;
                        if (fVar != null) {
                            fVar.setCallback(null);
                        }
                        this.f1160c.f1163b = fVarB;
                    }
                } else if ("target".equals(name)) {
                    typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, b.u.a.a.a.f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(i, 0);
                    if (resourceId2 != 0) {
                        Context context = this.d;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        if (Build.VERSION.SDK_INT >= 24) {
                            animatorR = AnimatorInflater.loadAnimator(context, resourceId2);
                        } else {
                            Resources resources2 = context.getResources();
                            Resources.Theme theme2 = context.getTheme();
                            try {
                                try {
                                    animation = resources2.getAnimation(resourceId2);
                                    try {
                                        try {
                                            str = "Can't load animation resource ID #0x";
                                            try {
                                                animatorR = a.a.a.a.a.r(context, resources2, theme2, animation, Xml.asAttributeSet(animation), null, 0, 1.0f);
                                                animation.close();
                                            } catch (IOException e) {
                                                e = e;
                                                Resources.NotFoundException notFoundException = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                                notFoundException.initCause(e);
                                                throw notFoundException;
                                            } catch (XmlPullParserException e2) {
                                                e = e2;
                                                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                                notFoundException2.initCause(e);
                                                throw notFoundException2;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            if (animation != null) {
                                                animation.close();
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e3) {
                                        e = e3;
                                        str = "Can't load animation resource ID #0x";
                                    } catch (XmlPullParserException e4) {
                                        e = e4;
                                        str = "Can't load animation resource ID #0x";
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    animation = null;
                                }
                            } catch (IOException e5) {
                                e = e5;
                                str = "Can't load animation resource ID #0x";
                            } catch (XmlPullParserException e6) {
                                e = e6;
                                str = "Can't load animation resource ID #0x";
                            }
                        }
                        animatorR.setTarget(this.f1160c.f1163b.f1169c.f1180b.p.getOrDefault(string, null));
                        C0048b c0048b = this.f1160c;
                        if (c0048b.d == null) {
                            c0048b.d = new ArrayList<>();
                            this.f1160c.e = new b.f.a<>();
                        }
                        this.f1160c.d.add(animatorR);
                        this.f1160c.e.put(animatorR, string);
                    }
                } else {
                    continue;
                }
                typedArrayObtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        C0048b c0048b2 = this.f1160c;
        if (c0048b2.f1164c == null) {
            c0048b2.f1164c = new AnimatorSet();
        }
        c0048b2.f1164c.playTogether(c0048b2.d);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.isAutoMirrored() : this.f1160c.f1163b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f1168b;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f1160c.f1164c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.isStateful() : this.f1160c.f1163b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f1160c.f1163b.setBounds(rect);
        }
    }

    @Override // b.u.a.a.e, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.setLevel(i) : this.f1160c.f1163b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.setState(iArr) : this.f1160c.f1163b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f1160c.f1163b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            return;
        }
        f fVar = this.f1160c.f1163b;
        Drawable drawable2 = fVar.f1168b;
        if (drawable2 != null) {
            drawable2.setAutoMirrored(z);
        } else {
            fVar.f1169c.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        f fVar = this.f1160c.f1163b;
        Drawable drawable2 = fVar.f1168b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        } else {
            fVar.e = colorFilter;
            fVar.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            a.a.a.a.a.t0(drawable, i);
        } else {
            this.f1160c.f1163b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            a.a.a.a.a.u0(drawable, colorStateList);
        } else {
            this.f1160c.f1163b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            a.a.a.a.a.v0(drawable, mode);
        } else {
            this.f1160c.f1163b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f1160c.f1163b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f1160c.f1164c.isStarted()) {
                return;
            }
            this.f1160c.f1164c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f1160c.f1164c.end();
        }
    }

    public static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f1165a;

        public c(Drawable.ConstantState constantState) {
            this.f1165a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1165a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1165a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b(null, null, null);
            Drawable drawableNewDrawable = this.f1165a.newDrawable();
            bVar.f1168b = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b(null, null, null);
            Drawable drawableNewDrawable = this.f1165a.newDrawable(resources);
            bVar.f1168b = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b(null, null, null);
            Drawable drawableNewDrawable = this.f1165a.newDrawable(resources, theme);
            bVar.f1168b = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f);
            return bVar;
        }
    }
}
