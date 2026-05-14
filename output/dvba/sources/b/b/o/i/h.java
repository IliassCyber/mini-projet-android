package b.b.o.i;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import b.b.o.i.e;
import b.b.o.i.m;

/* JADX INFO: loaded from: classes.dex */
public class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b.b.k.g f370c;
    public e d;

    public h(g gVar) {
        this.f369b = gVar;
    }

    @Override // b.b.o.i.m.a
    public void b(g gVar, boolean z) {
        b.b.k.g gVar2;
        if ((z || gVar == this.f369b) && (gVar2 = this.f370c) != null) {
            gVar2.dismiss();
        }
    }

    @Override // b.b.o.i.m.a
    public boolean c(g gVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f369b.r(((e.a) this.d.a()).getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        e eVar = this.d;
        g gVar = this.f369b;
        m.a aVar = eVar.i;
        if (aVar != null) {
            aVar.b(gVar, true);
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f370c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f370c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f369b.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f369b.performShortcut(i, keyEvent, 0);
    }
}
