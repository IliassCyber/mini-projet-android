package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import b.i.d.d;
import b.n.d;
import b.n.e;
import b.n.g;
import b.n.h;
import b.n.o;
import b.n.s;
import b.n.t;
import b.s.c;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends d implements g, t, c, b.a.c {
    public s e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f28c = new h(this);
    public final b.s.b d = new b.s.b(this);
    public final OnBackPressedDispatcher f = new OnBackPressedDispatcher(new a());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s f32a;
    }

    public ComponentActivity() {
        h hVar = this.f28c;
        if (hVar == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        hVar.a(new e() { // from class: androidx.activity.ComponentActivity.2
            @Override // b.n.e
            public void g(g gVar, d.a aVar) {
                if (aVar == d.a.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        this.f28c.a(new e() { // from class: androidx.activity.ComponentActivity.3
            @Override // b.n.e
            public void g(g gVar, d.a aVar) {
                if (aVar != d.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.f().a();
            }
        });
        if (Build.VERSION.SDK_INT <= 23) {
            this.f28c.a(new ImmLeaksCleaner(this));
        }
    }

    @Override // b.n.g
    public b.n.d a() {
        return this.f28c;
    }

    @Override // b.a.c
    public final OnBackPressedDispatcher d() {
        return this.f;
    }

    @Override // b.s.c
    public final b.s.a e() {
        return this.d.f1094b;
    }

    @Override // b.n.t
    public s f() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.e == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.e = bVar.f32a;
            }
            if (this.e == null) {
                this.e = new s();
            }
        }
        return this.e;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f.a();
    }

    @Override // b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d.a(bundle);
        o.b(this);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        s sVar = this.e;
        if (sVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            sVar = bVar.f32a;
        }
        if (sVar == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.f32a = sVar;
        return bVar2;
    }

    @Override // b.i.d.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        h hVar = this.f28c;
        if (hVar instanceof h) {
            hVar.f(d.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.d.b(bundle);
    }
}
