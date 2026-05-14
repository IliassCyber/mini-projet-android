package c.c.a.a.c;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class j extends b.l.a.c {
    public Dialog h0 = null;
    public DialogInterface.OnCancelListener i0 = null;

    @Override // b.l.a.c
    public Dialog a0(Bundle bundle) {
        if (this.h0 == null) {
            this.b0 = false;
        }
        return this.h0;
    }

    @Override // b.l.a.c
    public void b0(b.l.a.j jVar, String str) {
        super.b0(jVar, str);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.i0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
