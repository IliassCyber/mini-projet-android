package c.c.a.a.c;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class d extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f1284c = new Object();
    public static final d d = new d();

    @SuppressLint({"HandlerLeak"})
    public class a extends c.c.a.a.f.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1285a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f1285a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int iB = d.this.b(this.f1285a);
            if (d.this == null) {
                throw null;
            }
            if (g.c(iB)) {
                d dVar = d.this;
                Context context = this.f1285a;
                Intent intentA = dVar.a(context, iB, "n");
                dVar.e(context, iB, intentA != null ? PendingIntent.getActivity(context, 0, intentA, 134217728) : null);
            }
        }
    }

    @Override // c.c.a.a.c.e
    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    @Override // c.c.a.a.c.e
    public int b(Context context) {
        return c(context, e.f1287a);
    }

    @Override // c.c.a.a.c.e
    public int c(Context context, int i) {
        return super.c(context, i);
    }

    public boolean d(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogCreate;
        c.c.a.a.c.l.v vVar = new c.c.a.a.c.l.v(super.a(activity, i, "d"), activity, i2);
        if (i == 0) {
            alertDialogCreate = null;
        } else {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
            AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
            if (builder == null) {
                builder = new AlertDialog.Builder(activity);
            }
            builder.setMessage(c.c.a.a.c.l.d.c(activity, i));
            builder.setOnCancelListener(onCancelListener);
            String string = activity.getResources().getString(i != 1 ? i != 2 ? i != 3 ? R.string.ok : c.c.a.a.b.b.common_google_play_services_enable_button : c.c.a.a.b.b.common_google_play_services_update_button : c.c.a.a.b.b.common_google_play_services_install_button);
            if (string != null) {
                builder.setPositiveButton(string, vVar);
            }
            String strD = c.c.a.a.c.l.d.d(activity, i);
            if (strD != null) {
                builder.setTitle(strD);
            }
            alertDialogCreate = builder.create();
        }
        if (alertDialogCreate == null) {
            return false;
        }
        if (activity instanceof b.l.a.e) {
            b.l.a.j jVarM = ((b.l.a.e) activity).m();
            j jVar = new j();
            c.c.a.a.c.l.q.g(alertDialogCreate, "Cannot display null dialog");
            alertDialogCreate.setOnCancelListener(null);
            alertDialogCreate.setOnDismissListener(null);
            jVar.h0 = alertDialogCreate;
            jVar.i0 = onCancelListener;
            jVar.b0(jVarM, "GooglePlayServicesErrorDialog");
        } else {
            FragmentManager fragmentManager = activity.getFragmentManager();
            b bVar = new b();
            c.c.a.a.c.l.q.g(alertDialogCreate, "Cannot display null dialog");
            alertDialogCreate.setOnCancelListener(null);
            alertDialogCreate.setOnDismissListener(null);
            bVar.f1280b = alertDialogCreate;
            bVar.f1281c = onCancelListener;
            bVar.show(fragmentManager, "GooglePlayServicesErrorDialog");
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c8 A[PHI: r2
  0x01c8: PHI (r2v15 android.app.Notification) = (r2v14 android.app.Notification), (r2v17 android.app.Notification) binds: [B:103:0x01c6, B:78:0x017f] A[DONT_GENERATE, DONT_INLINE]] */
    @android.annotation.TargetApi(20)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.content.Context r9, int r10, android.app.PendingIntent r11) {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.c.d.e(android.content.Context, int, android.app.PendingIntent):void");
    }
}
