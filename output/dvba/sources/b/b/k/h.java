package b.b.k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import b.b.o.a;
import b.b.p.c1;
import b.b.p.n0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class h extends b.l.a.e implements i, b.i.d.m {
    public j n;
    public Resources o;

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        q().c(view, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void attachBaseContext(android.content.Context r10) {
        /*
            Method dump skipped, instruction units count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.k.h.attachBaseContext(android.content.Context):void");
    }

    @Override // b.b.k.i
    public void b(b.b.o.a aVar) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        r();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // b.i.d.d, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        r();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        k kVar = (k) q();
        kVar.z();
        return (T) kVar.f.findViewById(i);
    }

    @Override // b.b.k.i
    public void g(b.b.o.a aVar) {
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        k kVar = (k) q();
        if (kVar.j == null) {
            kVar.F();
            a aVar = kVar.i;
            kVar.j = new b.b.o.f(aVar != null ? aVar.d() : kVar.e);
        }
        return kVar.j;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.o == null) {
            c1.a();
        }
        Resources resources = this.o;
        return resources == null ? super.getResources() : resources;
    }

    @Override // b.b.k.i
    public b.b.o.a h(a.InterfaceC0011a interfaceC0011a) {
        return null;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        q().g();
    }

    @Override // b.i.d.m
    public Intent j() {
        return a.a.a.a.a.I(this);
    }

    @Override // b.l.a.e, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.o != null) {
            this.o.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        k kVar = (k) q();
        if (kVar.A && kVar.u) {
            kVar.F();
            a aVar = kVar.i;
            if (aVar != null) {
                aVar.e(configuration);
            }
        }
        b.b.p.j jVarA = b.b.p.j.a();
        Context context = kVar.e;
        synchronized (jVarA) {
            n0 n0Var = jVarA.f442a;
            synchronized (n0Var) {
                b.f.e<WeakReference<Drawable.ConstantState>> eVar = n0Var.d.get(context);
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
        kVar.q(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        j jVarQ = q();
        jVarQ.f();
        jVarQ.h(bundle);
        super.onCreate(bundle);
    }

    @Override // b.l.a.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        q().i();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if ((Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // b.l.a.e, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent intentI;
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a aVarR = r();
        if (menuItem.getItemId() != 16908332 || aVarR == null || (aVarR.c() & 4) == 0 || (intentI = a.a.a.a.a.I(this)) == null) {
            return false;
        }
        if (!shouldUpRecreateTask(intentI)) {
            navigateUpTo(intentI);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        Intent intentJ = j();
        if (intentJ == null) {
            intentJ = a.a.a.a.a.I(this);
        }
        if (intentJ != null) {
            ComponentName component = intentJ.getComponent();
            if (component == null) {
                component = intentJ.resolveActivity(getPackageManager());
            }
            int size = arrayList.size();
            while (true) {
                try {
                    Intent intentJ2 = a.a.a.a.a.J(this, component);
                    if (intentJ2 == null) {
                        break;
                    }
                    arrayList.add(size, intentJ2);
                    component = intentJ2.getComponent();
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e);
                }
            }
            arrayList.add(intentJ);
        }
        t();
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        b.i.e.a.e(this, intentArr, null);
        try {
            b.i.d.a.f(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // b.l.a.e, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((k) q()).z();
    }

    @Override // b.l.a.e, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        k kVar = (k) q();
        kVar.F();
        a aVar = kVar.i;
        if (aVar != null) {
            aVar.h(true);
        }
    }

    @Override // b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (((k) q()) == null) {
            throw null;
        }
    }

    @Override // b.l.a.e, android.app.Activity
    public void onStart() {
        super.onStart();
        k kVar = (k) q();
        kVar.L = true;
        kVar.p();
    }

    @Override // b.l.a.e, android.app.Activity
    public void onStop() {
        super.onStop();
        k kVar = (k) q();
        kVar.L = false;
        kVar.F();
        a aVar = kVar.i;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        q().o(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        r();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    @Override // b.l.a.e
    public void p() {
        q().g();
    }

    public j q() {
        if (this.n == null) {
            this.n = j.d(this, this);
        }
        return this.n;
    }

    public a r() {
        k kVar = (k) q();
        kVar.F();
        return kVar.i;
    }

    public void s() {
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        q().l(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        q().m(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        q().n(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        ((k) q()).O = i;
    }

    public void t() {
    }
}
