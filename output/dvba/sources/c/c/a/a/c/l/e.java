package c.c.a.a.c.l;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            v vVar = (v) this;
            Intent intent = vVar.f1406b;
            if (intent != null) {
                vVar.f1407c.startActivityForResult(intent, vVar.d);
            }
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
