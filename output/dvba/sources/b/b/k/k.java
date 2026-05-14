package b.b.k;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import b.b.k.t;
import b.b.o.a;
import b.b.o.i.g;
import b.b.o.i.m;
import b.b.p.c0;
import b.b.p.c1;
import b.b.p.d1;
import b.b.p.x0;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends b.b.k.j implements g.a, LayoutInflater.Factory2 {
    public static final boolean b0 = false;
    public static boolean f0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public j[] G;
    public j H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public g R;
    public g S;
    public boolean T;
    public int U;
    public boolean W;
    public Rect X;
    public Rect Y;
    public r Z;
    public final Object d;
    public final Context e;
    public Window f;
    public e g;
    public final b.b.k.i h;
    public b.b.k.a i;
    public MenuInflater j;
    public CharSequence k;
    public c0 l;
    public c m;
    public C0007k n;
    public b.b.o.a o;
    public ActionBarContextView p;
    public PopupWindow q;
    public Runnable r;
    public boolean u;
    public ViewGroup v;
    public TextView w;
    public View x;
    public boolean y;
    public boolean z;
    public static final b.f.h<String, Integer> a0 = new b.f.h<>();
    public static final int[] c0 = {R.attr.windowBackground};
    public static final boolean d0 = !"robolectric".equals(Build.FINGERPRINT);
    public static final boolean e0 = true;
    public b.i.m.q s = null;
    public boolean t = true;
    public final Runnable V = new b();

    public class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f256a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f256a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            String message;
            boolean z = false;
            if ((th instanceof Resources.NotFoundException) && (message = th.getMessage()) != null && (message.contains("drawable") || message.contains("Drawable"))) {
                z = true;
            }
            if (!z) {
                this.f256a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f256a.uncaughtException(thread, notFoundException);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = k.this;
            if ((kVar.U & 1) != 0) {
                kVar.x(0);
            }
            k kVar2 = k.this;
            if ((kVar2.U & 4096) != 0) {
                kVar2.x(108);
            }
            k kVar3 = k.this;
            kVar3.T = false;
            kVar3.U = 0;
        }
    }

    public final class c implements m.a {
        public c() {
        }

        @Override // b.b.o.i.m.a
        public void b(b.b.o.i.g gVar, boolean z) {
            k.this.t(gVar);
        }

        @Override // b.b.o.i.m.a
        public boolean c(b.b.o.i.g gVar) {
            Window.Callback callbackE = k.this.E();
            if (callbackE == null) {
                return true;
            }
            callbackE.onMenuOpened(108, gVar);
            return true;
        }
    }

    public class d implements a.InterfaceC0011a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a.InterfaceC0011a f259a;

        public class a extends b.i.m.s {
            public a() {
            }

            @Override // b.i.m.r
            public void a(View view) {
                k.this.p.setVisibility(8);
                k kVar = k.this;
                PopupWindow popupWindow = kVar.q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (kVar.p.getParent() instanceof View) {
                    b.i.m.l.U((View) k.this.p.getParent());
                }
                k.this.p.removeAllViews();
                k.this.s.d(null);
                k kVar2 = k.this;
                kVar2.s = null;
                b.i.m.l.U(kVar2.v);
            }
        }

        public d(a.InterfaceC0011a interfaceC0011a) {
            this.f259a = interfaceC0011a;
        }

        @Override // b.b.o.a.InterfaceC0011a
        public boolean a(b.b.o.a aVar, Menu menu) {
            b.i.m.l.U(k.this.v);
            return this.f259a.a(aVar, menu);
        }

        @Override // b.b.o.a.InterfaceC0011a
        public void b(b.b.o.a aVar) {
            this.f259a.b(aVar);
            k kVar = k.this;
            if (kVar.q != null) {
                kVar.f.getDecorView().removeCallbacks(k.this.r);
            }
            k kVar2 = k.this;
            if (kVar2.p != null) {
                kVar2.y();
                k kVar3 = k.this;
                b.i.m.q qVarA = b.i.m.l.a(kVar3.p);
                qVarA.a(0.0f);
                kVar3.s = qVarA;
                b.i.m.q qVar = k.this.s;
                a aVar2 = new a();
                View view = qVar.f846a.get();
                if (view != null) {
                    qVar.e(view, aVar2);
                }
            }
            k kVar4 = k.this;
            b.b.k.i iVar = kVar4.h;
            if (iVar != null) {
                iVar.g(kVar4.o);
            }
            k kVar5 = k.this;
            kVar5.o = null;
            b.i.m.l.U(kVar5.v);
        }

        @Override // b.b.o.a.InterfaceC0011a
        public boolean c(b.b.o.a aVar, MenuItem menuItem) {
            return this.f259a.c(aVar, menuItem);
        }

        @Override // b.b.o.a.InterfaceC0011a
        public boolean d(b.b.o.a aVar, Menu menu) {
            return this.f259a.d(aVar, menu);
        }
    }

    public class f extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PowerManager f263c;

        public f(Context context) {
            super();
            this.f263c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // b.b.k.k.g
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // b.b.k.k.g
        public int c() {
            return this.f263c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // b.b.k.k.g
        public void d() {
            k.this.p();
        }
    }

    public abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f264a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                g.this.d();
            }
        }

        public g() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f264a;
            if (broadcastReceiver != null) {
                try {
                    k.this.e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f264a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f264a == null) {
                this.f264a = new a();
            }
            k.this.e.registerReceiver(this.f264a, intentFilterB);
        }
    }

    public class h extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final t f267c;

        public h(t tVar) {
            super();
            this.f267c = tVar;
        }

        @Override // b.b.k.k.g
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // b.b.k.k.g
        public int c() {
            boolean z;
            long j;
            t tVar = this.f267c;
            t.a aVar = tVar.f288c;
            if (aVar.f290b > System.currentTimeMillis()) {
                z = aVar.f289a;
            } else {
                Location locationA = a.a.a.a.a.i(tVar.f286a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? tVar.a("network") : null;
                Location locationA2 = a.a.a.a.a.i(tVar.f286a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? tVar.a("gps") : null;
                if (locationA2 == null || locationA == null ? locationA2 != null : locationA2.getTime() > locationA.getTime()) {
                    locationA = locationA2;
                }
                if (locationA != null) {
                    t.a aVar2 = tVar.f288c;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (s.d == null) {
                        s.d = new s();
                    }
                    s sVar = s.d;
                    sVar.a(jCurrentTimeMillis - 86400000, locationA.getLatitude(), locationA.getLongitude());
                    sVar.a(jCurrentTimeMillis, locationA.getLatitude(), locationA.getLongitude());
                    boolean z2 = sVar.f285c == 1;
                    long j2 = sVar.f284b;
                    long j3 = sVar.f283a;
                    sVar.a(jCurrentTimeMillis + 86400000, locationA.getLatitude(), locationA.getLongitude());
                    long j4 = sVar.f284b;
                    if (j2 == -1 || j3 == -1) {
                        j = 43200000 + jCurrentTimeMillis;
                    } else {
                        j = (jCurrentTimeMillis > j3 ? j4 + 0 : jCurrentTimeMillis > j2 ? j3 + 0 : j2 + 0) + 60000;
                    }
                    aVar2.f289a = z2;
                    aVar2.f290b = j;
                    z = aVar.f289a;
                } else {
                    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                    int i = Calendar.getInstance().get(11);
                    z = i < 6 || i >= 22;
                }
            }
            return z ? 2 : 1;
        }

        @Override // b.b.k.k.g
        public void d() {
            k.this.p();
        }
    }

    public class i extends ContentFrameLayout {
        public i(Context context) {
            super(context, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return k.this.w(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    k kVar = k.this;
                    kVar.u(kVar.D(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(b.b.l.a.a.b(getContext(), i));
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f270c;
        public int d;
        public ViewGroup e;
        public View f;
        public View g;
        public b.b.o.i.g h;
        public b.b.o.i.e i;
        public Context j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o = false;
        public boolean p;
        public Bundle q;

        public j(int i) {
            this.f268a = i;
        }

        public void a(b.b.o.i.g gVar) {
            b.b.o.i.e eVar;
            b.b.o.i.g gVar2 = this.h;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.u(this.i);
            }
            this.h = gVar;
            if (gVar == null || (eVar = this.i) == null) {
                return;
            }
            gVar.b(eVar, gVar.f366a);
        }
    }

    /* JADX INFO: renamed from: b.b.k.k$k, reason: collision with other inner class name */
    public final class C0007k implements m.a {
        public C0007k() {
        }

        @Override // b.b.o.i.m.a
        public void b(b.b.o.i.g gVar, boolean z) {
            b.b.o.i.g gVarK = gVar.k();
            boolean z2 = gVarK != gVar;
            k kVar = k.this;
            if (z2) {
                gVar = gVarK;
            }
            j jVarB = kVar.B(gVar);
            if (jVarB != null) {
                if (!z2) {
                    k.this.u(jVarB, z);
                } else {
                    k.this.s(jVarB.f268a, jVarB, gVarK);
                    k.this.u(jVarB, true);
                }
            }
        }

        @Override // b.b.o.i.m.a
        public boolean c(b.b.o.i.g gVar) {
            Window.Callback callbackE;
            if (gVar != gVar.k()) {
                return true;
            }
            k kVar = k.this;
            if (!kVar.A || (callbackE = kVar.E()) == null || k.this.M) {
                return true;
            }
            callbackE.onMenuOpened(108, gVar);
            return true;
        }
    }

    static {
        if (!b0 || f0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        f0 = true;
    }

    public k(Context context, Window window, b.b.k.i iVar, Object obj) {
        Integer orDefault;
        b.b.k.h hVar;
        this.N = -100;
        this.e = context;
        this.h = iVar;
        this.d = obj;
        if (this.N == -100 && (obj instanceof Dialog)) {
            while (context != null) {
                if (!(context instanceof b.b.k.h)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    hVar = (b.b.k.h) context;
                    break;
                }
            }
            hVar = null;
            if (hVar != null) {
                this.N = ((k) hVar.q()).N;
            }
        }
        if (this.N == -100 && (orDefault = a0.getOrDefault(this.d.getClass().getName(), null)) != null) {
            this.N = orDefault.intValue();
            a0.remove(this.d.getClass().getName());
        }
        if (window != null) {
            r(window);
        }
        b.b.p.j.e();
    }

    public final void A() {
        if (this.f == null) {
            Object obj = this.d;
            if (obj instanceof Activity) {
                r(((Activity) obj).getWindow());
            }
        }
        if (this.f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public j B(Menu menu) {
        j[] jVarArr = this.G;
        int length = jVarArr != null ? jVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            j jVar = jVarArr[i2];
            if (jVar != null && jVar.h == menu) {
                return jVar;
            }
        }
        return null;
    }

    public final g C(Context context) {
        if (this.R == null) {
            if (t.d == null) {
                Context applicationContext = context.getApplicationContext();
                t.d = new t(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.R = new h(t.d);
        }
        return this.R;
    }

    public j D(int i2) {
        j[] jVarArr = this.G;
        if (jVarArr == null || jVarArr.length <= i2) {
            j[] jVarArr2 = new j[i2 + 1];
            if (jVarArr != null) {
                System.arraycopy(jVarArr, 0, jVarArr2, 0, jVarArr.length);
            }
            this.G = jVarArr2;
            jVarArr = jVarArr2;
        }
        j jVar = jVarArr[i2];
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(i2);
        jVarArr[i2] = jVar2;
        return jVar2;
    }

    public final Window.Callback E() {
        return this.f.getCallback();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() {
        /*
            r3 = this;
            r3.z()
            boolean r0 = r3.A
            if (r0 == 0) goto L37
            b.b.k.a r0 = r3.i
            if (r0 == 0) goto Lc
            goto L37
        Lc:
            java.lang.Object r0 = r3.d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L20
            b.b.k.u r0 = new b.b.k.u
            java.lang.Object r1 = r3.d
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.B
            r0.<init>(r1, r2)
        L1d:
            r3.i = r0
            goto L2e
        L20:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L2e
            b.b.k.u r0 = new b.b.k.u
            java.lang.Object r1 = r3.d
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L2e:
            b.b.k.a r0 = r3.i
            if (r0 == 0) goto L37
            boolean r1 = r3.W
            r0.g(r1)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.k.k.F():void");
    }

    public final void G(int i2) {
        this.U = (1 << i2) | this.U;
        if (this.T) {
            return;
        }
        b.i.m.l.P(this.f.getDecorView(), this.V);
        this.T = true;
    }

    public int H(Context context, int i2) {
        g gVarC;
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    if (this.S == null) {
                        this.S = new f(context);
                    }
                    gVarC = this.S;
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() == 0) {
                    return -1;
                }
                gVarC = C(context);
            }
            return gVarC.c();
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(b.b.k.k.j r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.k.k.I(b.b.k.k$j, android.view.KeyEvent):void");
    }

    public final boolean J(j jVar, int i2, KeyEvent keyEvent, int i3) {
        b.b.o.i.g gVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((jVar.k || K(jVar, keyEvent)) && (gVar = jVar.h) != null) {
            zPerformShortcut = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.l == null) {
            u(jVar, true);
        }
        return zPerformShortcut;
    }

    public final boolean K(j jVar, KeyEvent keyEvent) {
        c0 c0Var;
        Resources.Theme themeNewTheme;
        c0 c0Var2;
        c0 c0Var3;
        if (this.M) {
            return false;
        }
        if (jVar.k) {
            return true;
        }
        j jVar2 = this.H;
        if (jVar2 != null && jVar2 != jVar) {
            u(jVar2, false);
        }
        Window.Callback callbackE = E();
        if (callbackE != null) {
            jVar.g = callbackE.onCreatePanelView(jVar.f268a);
        }
        int i2 = jVar.f268a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (c0Var3 = this.l) != null) {
            c0Var3.d();
        }
        if (jVar.g == null) {
            if (jVar.h == null || jVar.p) {
                if (jVar.h == null) {
                    Context context = this.e;
                    int i3 = jVar.f268a;
                    if ((i3 == 0 || i3 == 108) && this.l != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(b.b.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(b.b.a.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(b.b.a.actionBarWidgetTheme, typedValue, true);
                            themeNewTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (themeNewTheme == null) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                            }
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                        }
                        if (themeNewTheme != null) {
                            b.b.o.c cVar = new b.b.o.c(context, 0);
                            cVar.getTheme().setTo(themeNewTheme);
                            context = cVar;
                        }
                    }
                    b.b.o.i.g gVar = new b.b.o.i.g(context);
                    gVar.e = this;
                    jVar.a(gVar);
                    if (jVar.h == null) {
                        return false;
                    }
                }
                if (z && this.l != null) {
                    if (this.m == null) {
                        this.m = new c();
                    }
                    this.l.b(jVar.h, this.m);
                }
                jVar.h.z();
                if (!callbackE.onCreatePanelMenu(jVar.f268a, jVar.h)) {
                    jVar.a(null);
                    if (z && (c0Var = this.l) != null) {
                        c0Var.b(null, this.m);
                    }
                    return false;
                }
                jVar.p = false;
            }
            jVar.h.z();
            Bundle bundle = jVar.q;
            if (bundle != null) {
                jVar.h.v(bundle);
                jVar.q = null;
            }
            if (!callbackE.onPreparePanel(0, jVar.g, jVar.h)) {
                if (z && (c0Var2 = this.l) != null) {
                    c0Var2.b(null, this.m);
                }
                jVar.h.y();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            jVar.n = z2;
            jVar.h.setQwertyMode(z2);
            jVar.h.y();
        }
        jVar.k = true;
        jVar.l = false;
        this.H = jVar;
        return true;
    }

    public final boolean L() {
        ViewGroup viewGroup;
        return this.u && (viewGroup = this.v) != null && b.i.m.l.E(viewGroup);
    }

    public final void M() {
        if (this.u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int N(b.i.m.u uVar, Rect rect) {
        boolean z;
        boolean z2;
        Context context;
        int i2;
        int iD = uVar != null ? uVar.d() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.p;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            if (this.p.isShown()) {
                if (this.X == null) {
                    this.X = new Rect();
                    this.Y = new Rect();
                }
                Rect rect2 = this.X;
                Rect rect3 = this.Y;
                if (uVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(uVar.b(), uVar.d(), uVar.c(), uVar.a());
                }
                d1.a(this.v, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                b.i.m.u uVarW = b.i.m.l.w(this.v);
                int iB = uVarW == null ? 0 : uVarW.b();
                int iC = uVarW == null ? 0 : uVarW.c();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z2 = true;
                }
                if (i3 <= 0 || this.x != null) {
                    View view = this.x;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = iB;
                            marginLayoutParams2.rightMargin = iC;
                            this.x.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.e);
                    this.x = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iC;
                    this.v.addView(this.x, -1, layoutParams);
                }
                z = this.x != null;
                if (z && this.x.getVisibility() != 0) {
                    View view3 = this.x;
                    if ((b.i.m.l.y(view3) & 8192) != 0) {
                        context = this.e;
                        i2 = b.b.c.abc_decor_view_status_guard_light;
                    } else {
                        context = this.e;
                        i2 = b.b.c.abc_decor_view_status_guard;
                    }
                    view3.setBackgroundColor(b.i.e.a.a(context, i2));
                }
                if (!this.C && z) {
                    iD = 0;
                }
                z = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z = false;
            }
            if (z) {
                this.p.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.x;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return iD;
    }

    @Override // b.b.o.i.g.a
    public void a(b.b.o.i.g gVar) {
        c0 c0Var = this.l;
        if (c0Var == null || !c0Var.f() || (ViewConfiguration.get(this.e).hasPermanentMenuKey() && !this.l.c())) {
            j jVarD = D(0);
            jVarD.o = true;
            u(jVarD, false);
            I(jVarD, null);
            return;
        }
        Window.Callback callbackE = E();
        if (this.l.e()) {
            this.l.g();
            if (this.M) {
                return;
            }
            callbackE.onPanelClosed(108, D(0).h);
            return;
        }
        if (callbackE == null || this.M) {
            return;
        }
        if (this.T && (1 & this.U) != 0) {
            this.f.getDecorView().removeCallbacks(this.V);
            this.V.run();
        }
        j jVarD2 = D(0);
        b.b.o.i.g gVar2 = jVarD2.h;
        if (gVar2 == null || jVarD2.p || !callbackE.onPreparePanel(0, jVarD2.g, gVar2)) {
            return;
        }
        callbackE.onMenuOpened(108, jVarD2.h);
        this.l.a();
    }

    @Override // b.b.o.i.g.a
    public boolean b(b.b.o.i.g gVar, MenuItem menuItem) {
        j jVarB;
        Window.Callback callbackE = E();
        if (callbackE == null || this.M || (jVarB = B(gVar.k())) == null) {
            return false;
        }
        return callbackE.onMenuItemSelected(jVarB.f268a, menuItem);
    }

    @Override // b.b.k.j
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        z();
        ((ViewGroup) this.v.findViewById(R.id.content)).addView(view, layoutParams);
        this.g.f342b.onContentChanged();
    }

    @Override // b.b.k.j
    public void f() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.e);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof k) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // b.b.k.j
    public void g() {
        F();
        b.b.k.a aVar = this.i;
        G(0);
    }

    @Override // b.b.k.j
    public void h(Bundle bundle) {
        this.J = true;
        q(false);
        A();
        Object obj = this.d;
        if (obj instanceof Activity) {
            String strK = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    strK = a.a.a.a.a.K(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } catch (IllegalArgumentException unused) {
            }
            if (strK != null) {
                b.b.k.a aVar = this.i;
                if (aVar == null) {
                    this.W = true;
                } else {
                    aVar.g(true);
                }
            }
            synchronized (b.b.k.j.f255c) {
                b.b.k.j.j(this);
                b.b.k.j.f254b.add(new WeakReference<>(this));
            }
        }
        this.K = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    @Override // b.b.k.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.d
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = b.b.k.j.f255c
            monitor-enter(r0)
            b.b.k.j.j(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.T
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.V
            r0.removeCallbacks(r1)
        L20:
            r0 = 0
            r3.L = r0
            r0 = 1
            r3.M = r0
            int r0 = r3.N
            r1 = -100
            if (r0 == r1) goto L50
            java.lang.Object r0 = r3.d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L50
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L50
            b.f.h<java.lang.String, java.lang.Integer> r0 = b.b.k.k.a0
            java.lang.Object r1 = r3.d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.N
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5f
        L50:
            b.f.h<java.lang.String, java.lang.Integer> r0 = b.b.k.k.a0
            java.lang.Object r1 = r3.d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5f:
            b.b.k.a r0 = r3.i
            if (r0 == 0) goto L68
            if (r0 == 0) goto L66
            goto L68
        L66:
            r0 = 0
            throw r0
        L68:
            b.b.k.k$g r0 = r3.R
            if (r0 == 0) goto L6f
            r0.a()
        L6f:
            b.b.k.k$g r0 = r3.S
            if (r0 == 0) goto L76
            r0.a()
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.k.k.i():void");
    }

    @Override // b.b.k.j
    public boolean k(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i2 = 108;
        } else if (i2 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i2 = 109;
        }
        if (this.E && i2 == 108) {
            return false;
        }
        if (this.A && i2 == 1) {
            this.A = false;
        }
        if (i2 == 1) {
            M();
            this.E = true;
            return true;
        }
        if (i2 == 2) {
            M();
            this.y = true;
            return true;
        }
        if (i2 == 5) {
            M();
            this.z = true;
            return true;
        }
        if (i2 == 10) {
            M();
            this.C = true;
            return true;
        }
        if (i2 == 108) {
            M();
            this.A = true;
            return true;
        }
        if (i2 != 109) {
            return this.f.requestFeature(i2);
        }
        M();
        this.B = true;
        return true;
    }

    @Override // b.b.k.j
    public void l(int i2) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.e).inflate(i2, viewGroup);
        this.g.f342b.onContentChanged();
    }

    @Override // b.b.k.j
    public void m(View view) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.g.f342b.onContentChanged();
    }

    @Override // b.b.k.j
    public void n(View view, ViewGroup.LayoutParams layoutParams) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.g.f342b.onContentChanged();
    }

    @Override // b.b.k.j
    public final void o(CharSequence charSequence) {
        this.k = charSequence;
        c0 c0Var = this.l;
        if (c0Var != null) {
            c0Var.setWindowTitle(charSequence);
            return;
        }
        b.b.k.a aVar = this.i;
        if (aVar != null) {
            aVar.i(charSequence);
            return;
        }
        TextView textView = this.w;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        r rVar;
        if (this.Z == null) {
            String string = this.e.obtainStyledAttributes(b.b.j.AppCompatTheme).getString(b.b.j.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                rVar = new r();
            } else {
                try {
                    this.Z = (r) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    rVar = new r();
                    this.Z = rVar;
                }
            }
            this.Z = rVar;
        }
        r rVar2 = this.Z;
        c1.a();
        return rVar2.createView(view, str, context, attributeSet, false, false, true, false);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public boolean p() {
        return q(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(boolean r13) {
        /*
            Method dump skipped, instruction units count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.k.k.q(boolean):boolean");
    }

    public final void r(Window window) {
        if (this.f != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof e) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        e eVar = new e(callback);
        this.g = eVar;
        window.setCallback(eVar);
        x0 x0VarP = x0.p(this.e, null, c0);
        Drawable drawableH = x0VarP.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        x0VarP.f507b.recycle();
        this.f = window;
    }

    public void s(int i2, j jVar, Menu menu) {
        if (menu == null && jVar != null) {
            menu = jVar.h;
        }
        if ((jVar == null || jVar.m) && !this.M) {
            this.g.f342b.onPanelClosed(i2, menu);
        }
    }

    public void t(b.b.o.i.g gVar) {
        if (this.F) {
            return;
        }
        this.F = true;
        this.l.j();
        Window.Callback callbackE = E();
        if (callbackE != null && !this.M) {
            callbackE.onPanelClosed(108, gVar);
        }
        this.F = false;
    }

    public void u(j jVar, boolean z) {
        ViewGroup viewGroup;
        c0 c0Var;
        if (z && jVar.f268a == 0 && (c0Var = this.l) != null && c0Var.e()) {
            t(jVar.h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.e.getSystemService("window");
        if (windowManager != null && jVar.m && (viewGroup = jVar.e) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                s(jVar.f268a, jVar, null);
            }
        }
        jVar.k = false;
        jVar.l = false;
        jVar.m = false;
        jVar.f = null;
        jVar.o = true;
        if (this.H == jVar) {
            this.H = null;
        }
    }

    public final Configuration v(Context context, int i2, Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean w(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.k.k.w(android.view.KeyEvent):boolean");
    }

    public void x(int i2) {
        j jVarD = D(i2);
        if (jVarD.h != null) {
            Bundle bundle = new Bundle();
            jVarD.h.w(bundle);
            if (bundle.size() > 0) {
                jVarD.q = bundle;
            }
            jVarD.h.z();
            jVarD.h.clear();
        }
        jVarD.p = true;
        jVarD.o = true;
        if ((i2 == 108 || i2 == 0) && this.l != null) {
            j jVarD2 = D(0);
            jVarD2.k = false;
            K(jVarD2, null);
        }
    }

    public void y() {
        b.i.m.q qVar = this.s;
        if (qVar != null) {
            qVar.b();
        }
    }

    public final void z() {
        ViewGroup viewGroup;
        if (this.u) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = this.e.obtainStyledAttributes(b.b.j.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(b.b.j.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_windowNoTitle, false)) {
            k(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_windowActionBar, false)) {
            k(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_windowActionBarOverlay, false)) {
            k(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_windowActionModeOverlay, false)) {
            k(10);
        }
        this.D = typedArrayObtainStyledAttributes.getBoolean(b.b.j.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        A();
        this.f.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.e);
        if (this.E) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(this.C ? b.b.g.abc_screen_simple_overlay_action_mode : b.b.g.abc_screen_simple, (ViewGroup) null);
        } else if (this.D) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(b.b.g.abc_dialog_title_material, (ViewGroup) null);
            this.B = false;
            this.A = false;
        } else if (this.A) {
            TypedValue typedValue = new TypedValue();
            this.e.getTheme().resolveAttribute(b.b.a.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new b.b.o.c(this.e, typedValue.resourceId) : this.e).inflate(b.b.g.abc_screen_toolbar, (ViewGroup) null);
            c0 c0Var = (c0) viewGroup.findViewById(b.b.f.decor_content_parent);
            this.l = c0Var;
            c0Var.setWindowCallback(E());
            if (this.B) {
                this.l.h(109);
            }
            if (this.y) {
                this.l.h(2);
            }
            if (this.z) {
                this.l.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            StringBuilder sbE = c.a.a.a.a.e("AppCompat does not support the current theme features: { windowActionBar: ");
            sbE.append(this.A);
            sbE.append(", windowActionBarOverlay: ");
            sbE.append(this.B);
            sbE.append(", android:windowIsFloating: ");
            sbE.append(this.D);
            sbE.append(", windowActionModeOverlay: ");
            sbE.append(this.C);
            sbE.append(", windowNoTitle: ");
            sbE.append(this.E);
            sbE.append(" }");
            throw new IllegalArgumentException(sbE.toString());
        }
        b.i.m.l.e0(viewGroup, new l(this));
        if (this.l == null) {
            this.w = (TextView) viewGroup.findViewById(b.b.f.title);
        }
        d1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(b.b.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new n(this));
        this.v = viewGroup;
        Object obj = this.d;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.k;
        if (!TextUtils.isEmpty(title)) {
            c0 c0Var2 = this.l;
            if (c0Var2 != null) {
                c0Var2.setWindowTitle(title);
            } else {
                b.b.k.a aVar = this.i;
                if (aVar != null) {
                    aVar.i(title);
                } else {
                    TextView textView = this.w;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.v.findViewById(R.id.content);
        View decorView = this.f.getDecorView();
        contentFrameLayout2.h.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (b.i.m.l.E(contentFrameLayout2)) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = this.e.obtainStyledAttributes(b.b.j.AppCompatTheme);
        typedArrayObtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(b.b.j.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(b.b.j.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(b.b.j.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(b.b.j.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes2.getValue(b.b.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.u = true;
        j jVarD = D(0);
        if (this.M || jVarD.h != null) {
            return;
        }
        G(108);
    }

    public class e extends b.b.o.h {
        public e(Window.Callback callback) {
            super(callback);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0052  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.view.ActionMode a(android.view.ActionMode.Callback r10) {
            /*
                Method dump skipped, instruction units count: 441
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.b.k.k.e.a(android.view.ActionMode$Callback):android.view.ActionMode");
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return k.this.w(keyEvent) || this.f342b.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // android.view.Window.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) {
            /*
                r5 = this;
                android.view.Window$Callback r0 = r5.f342b
                boolean r0 = r0.dispatchKeyShortcutEvent(r6)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L4f
                b.b.k.k r0 = b.b.k.k.this
                int r3 = r6.getKeyCode()
                r0.F()
                b.b.k.a r4 = r0.i
                if (r4 == 0) goto L1f
                boolean r3 = r4.f(r3, r6)
                if (r3 == 0) goto L1f
            L1d:
                r6 = 1
                goto L4d
            L1f:
                b.b.k.k$j r3 = r0.H
                if (r3 == 0) goto L34
                int r4 = r6.getKeyCode()
                boolean r3 = r0.J(r3, r4, r6, r2)
                if (r3 == 0) goto L34
                b.b.k.k$j r6 = r0.H
                if (r6 == 0) goto L1d
                r6.l = r2
                goto L1d
            L34:
                b.b.k.k$j r3 = r0.H
                if (r3 != 0) goto L4c
                b.b.k.k$j r3 = r0.D(r1)
                r0.K(r3, r6)
                int r4 = r6.getKeyCode()
                boolean r6 = r0.J(r3, r4, r6, r2)
                r3.k = r1
                if (r6 == 0) goto L4c
                goto L1d
            L4c:
                r6 = 0
            L4d:
                if (r6 == 0) goto L50
            L4f:
                r1 = 1
            L50:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.b.k.k.e.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof b.b.o.i.g)) {
                return this.f342b.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            this.f342b.onMenuOpened(i, menu);
            k kVar = k.this;
            if (kVar == null) {
                throw null;
            }
            if (i == 108) {
                kVar.F();
                b.b.k.a aVar = kVar.i;
                if (aVar != null) {
                    aVar.b(true);
                }
            }
            return true;
        }

        @Override // android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            this.f342b.onPanelClosed(i, menu);
            k kVar = k.this;
            if (kVar == null) {
                throw null;
            }
            if (i == 108) {
                kVar.F();
                b.b.k.a aVar = kVar.i;
                if (aVar != null) {
                    aVar.b(false);
                    return;
                }
                return;
            }
            if (i == 0) {
                j jVarD = kVar.D(i);
                if (jVarD.m) {
                    kVar.u(jVarD, false);
                }
            }
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            b.b.o.i.g gVar = menu instanceof b.b.o.i.g ? (b.b.o.i.g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.y = true;
            }
            boolean zOnPreparePanel = this.f342b.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.y = false;
            }
            return zOnPreparePanel;
        }

        @Override // android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            b.b.o.i.g gVar = k.this.D(0).h;
            if (gVar != null) {
                this.f342b.onProvideKeyboardShortcuts(list, gVar, i);
            } else {
                this.f342b.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return k.this.t ? a(callback) : this.f342b.onWindowStartingActionMode(callback);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (k.this.t && i == 0) {
                return a(callback);
            }
            return this.f342b.onWindowStartingActionMode(callback, i);
        }
    }
}
