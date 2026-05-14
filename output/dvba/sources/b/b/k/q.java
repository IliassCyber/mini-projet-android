package b.b.k;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import b.b.o.a;
import b.i.m.d;

/* JADX INFO: loaded from: classes.dex */
public class q extends Dialog implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.a f279c;

    public class a implements d.a {
        public a() {
        }

        @Override // b.i.m.d.a
        public boolean i(KeyEvent keyEvent) {
            return q.this.c(keyEvent);
        }
    }

    public q(Context context, int i) {
        int i2;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(b.b.a.dialogTheme, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = i;
        }
        super(context, i2);
        this.f279c = new a();
        j jVarA = a();
        if (i == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(b.b.a.dialogTheme, typedValue2, true);
            i = typedValue2.resourceId;
        }
        ((k) jVarA).O = i;
        jVarA.h(null);
    }

    public j a() {
        if (this.f278b == null) {
            this.f278b = j.e(this, this);
        }
        return this.f278b;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().c(view, layoutParams);
    }

    @Override // b.b.k.i
    public void b(b.b.o.a aVar) {
    }

    public boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().i();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b.i.m.d.a(this.f279c, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        k kVar = (k) a();
        kVar.z();
        return (T) kVar.f.findViewById(i);
    }

    @Override // b.b.k.i
    public void g(b.b.o.a aVar) {
    }

    @Override // b.b.k.i
    public b.b.o.a h(a.InterfaceC0011a interfaceC0011a) {
        return null;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().g();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().f();
        super.onCreate(bundle);
        a().h(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        k kVar = (k) a();
        kVar.L = false;
        kVar.F();
        b.b.k.a aVar = kVar.i;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().l(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().m(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().n(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().o(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().o(charSequence);
    }
}
