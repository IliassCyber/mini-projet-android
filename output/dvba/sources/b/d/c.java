package b.d;

import android.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.g;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SyntheticAccessor"})
public class c extends b.l.a.c {
    public Bundle i0;
    public int j0;
    public int k0;
    public int l0;
    public ImageView m0;
    public TextView n0;
    public Context o0;
    public DialogInterface.OnClickListener q0;
    public HandlerC0020c h0 = new HandlerC0020c();
    public boolean p0 = true;
    public final DialogInterface.OnClickListener r0 = new a();

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: b.d.c$a$a, reason: collision with other inner class name */
        public class RunnableC0019a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DialogInterface f553b;

            public RunnableC0019a(DialogInterface dialogInterface) {
                this.f553b = dialogInterface;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.onCancel(this.f553b);
            }
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                a.a.a.a.a.T("FingerprintDialogFrag", c.this.g(), c.this.i0, new RunnableC0019a(dialogInterface));
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            DialogInterface.OnClickListener onClickListener;
            if (c.this.i0.getBoolean("allow_device_credential")) {
                onClickListener = c.this.r0;
            } else {
                onClickListener = c.this.q0;
                if (onClickListener == null) {
                    Log.w("FingerprintDialogFrag", "No suitable negative button listener.");
                    return;
                }
            }
            onClickListener.onClick(dialogInterface, i);
        }
    }

    /* JADX INFO: renamed from: b.d.c$c, reason: collision with other inner class name */
    public final class HandlerC0020c extends Handler {
        public HandlerC0020c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    c cVar = c.this;
                    CharSequence charSequence = (CharSequence) message.obj;
                    cVar.f0(2);
                    cVar.h0.removeMessages(4);
                    TextView textView = cVar.n0;
                    if (textView != null) {
                        textView.setTextColor(cVar.j0);
                        cVar.n0.setText(charSequence);
                    }
                    HandlerC0020c handlerC0020c = cVar.h0;
                    handlerC0020c.sendMessageDelayed(handlerC0020c.obtainMessage(4), 2000L);
                    break;
                case 2:
                    c cVar2 = c.this;
                    CharSequence charSequence2 = (CharSequence) message.obj;
                    cVar2.f0(2);
                    cVar2.h0.removeMessages(4);
                    TextView textView2 = cVar2.n0;
                    if (textView2 != null) {
                        textView2.setTextColor(cVar2.j0);
                        cVar2.n0.setText(charSequence2);
                    }
                    HandlerC0020c handlerC0020c2 = cVar2.h0;
                    handlerC0020c2.sendMessageDelayed(handlerC0020c2.obtainMessage(3), c.d0(cVar2.o0));
                    break;
                case 3:
                    c cVar3 = c.this;
                    CharSequence charSequence3 = (CharSequence) message.obj;
                    if (cVar3.p0) {
                        cVar3.c0();
                    } else {
                        TextView textView3 = cVar3.n0;
                        if (textView3 != null) {
                            textView3.setTextColor(cVar3.j0);
                            if (charSequence3 != null) {
                                cVar3.n0.setText(charSequence3);
                            } else {
                                cVar3.n0.setText(n.fingerprint_error_lockout);
                            }
                        }
                        cVar3.h0.postDelayed(new d(cVar3), c.d0(cVar3.o0));
                    }
                    cVar3.p0 = true;
                    break;
                case 4:
                    c cVar4 = c.this;
                    cVar4.f0(1);
                    TextView textView4 = cVar4.n0;
                    if (textView4 != null) {
                        textView4.setTextColor(cVar4.k0);
                        cVar4.n0.setText(cVar4.o0.getString(n.fingerprint_dialog_touch_sensor));
                    }
                    break;
                case 5:
                    c.this.c0();
                    break;
                case 6:
                    Context contextK = c.this.k();
                    c.this.p0 = contextK != null && a.a.a.a.a.y0(contextK, Build.MODEL);
                    break;
            }
        }
    }

    public static int d0(Context context) {
        if (context == null || !a.a.a.a.a.y0(context, Build.MODEL)) {
            return RecyclerView.MAX_SCROLL_DURATION;
        }
        return 0;
    }

    @Override // b.l.a.c, androidx.fragment.app.Fragment
    public void A(Bundle bundle) {
        super.A(bundle);
        Context contextK = k();
        this.o0 = contextK;
        this.j0 = Build.VERSION.SDK_INT >= 26 ? e0(R.attr.colorError) : b.i.e.a.a(contextK, j.biometric_error_color);
        this.k0 = e0(R.attr.textColorSecondary);
    }

    @Override // androidx.fragment.app.Fragment
    public void G() {
        this.E = true;
        this.h0.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void H() {
        this.E = true;
        this.l0 = 0;
        f0(1);
    }

    @Override // b.l.a.c, androidx.fragment.app.Fragment
    public void I(Bundle bundle) {
        super.I(bundle);
        bundle.putBundle("SavedBundle", this.i0);
    }

    @Override // b.l.a.c
    public Dialog a0(Bundle bundle) {
        if (bundle != null && this.i0 == null) {
            this.i0 = bundle.getBundle("SavedBundle");
        }
        g.a aVar = new g.a(k());
        CharSequence charSequence = this.i0.getCharSequence("title");
        AlertController.b bVar = aVar.f252a;
        bVar.f = charSequence;
        View viewInflate = LayoutInflater.from(bVar.f49a).inflate(m.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(l.fingerprint_subtitle);
        TextView textView2 = (TextView) viewInflate.findViewById(l.fingerprint_description);
        CharSequence charSequence2 = this.i0.getCharSequence("subtitle");
        if (TextUtils.isEmpty(charSequence2)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence2);
        }
        CharSequence charSequence3 = this.i0.getCharSequence("description");
        if (TextUtils.isEmpty(charSequence3)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(charSequence3);
        }
        this.m0 = (ImageView) viewInflate.findViewById(l.fingerprint_icon);
        this.n0 = (TextView) viewInflate.findViewById(l.fingerprint_error);
        CharSequence charSequenceT = this.i0.getBoolean("allow_device_credential") ? t(n.confirm_device_credential_password) : this.i0.getCharSequence("negative_text");
        b bVar2 = new b();
        AlertController.b bVar3 = aVar.f252a;
        bVar3.k = charSequenceT;
        bVar3.l = bVar2;
        bVar3.t = viewInflate;
        bVar3.s = 0;
        bVar3.u = false;
        b.b.k.g gVarA = aVar.a();
        gVarA.setCanceledOnTouchOutside(false);
        return gVarA;
    }

    public void c0() {
        if (this.s == null) {
            Log.e("FingerprintDialogFrag", "Failed to dismiss fingerprint dialog fragment. Fragment manager was null.");
        } else {
            Z(true, false);
        }
    }

    public final int e0(int i) {
        TypedValue typedValue = new TypedValue();
        this.o0.getTheme().resolveAttribute(i, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = g().obtainStyledAttributes(typedValue.data, new int[]{i});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f0(int r6) {
        /*
            r5 = this;
            android.widget.ImageView r0 = r5.m0
            if (r0 != 0) goto L5
            return
        L5:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L5a
            int r0 = r5.l0
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 != 0) goto L15
            if (r6 != r3) goto L15
            goto L19
        L15:
            if (r0 != r3) goto L1c
            if (r6 != r2) goto L1c
        L19:
            int r0 = b.d.k.fingerprint_dialog_fp_to_error
            goto L28
        L1c:
            if (r0 != r2) goto L21
            if (r6 != r3) goto L21
            goto L26
        L21:
            if (r0 != r3) goto L2f
            r0 = 3
            if (r6 != r0) goto L2f
        L26:
            int r0 = b.d.k.fingerprint_dialog_error_to_fp
        L28:
            android.content.Context r4 = r5.o0
            android.graphics.drawable.Drawable r0 = r4.getDrawable(r0)
            goto L30
        L2f:
            r0 = r1
        L30:
            if (r0 != 0) goto L33
            return
        L33:
            boolean r4 = r0 instanceof android.graphics.drawable.AnimatedVectorDrawable
            if (r4 == 0) goto L3a
            r1 = r0
            android.graphics.drawable.AnimatedVectorDrawable r1 = (android.graphics.drawable.AnimatedVectorDrawable) r1
        L3a:
            android.widget.ImageView r4 = r5.m0
            r4.setImageDrawable(r0)
            if (r1 == 0) goto L58
            int r0 = r5.l0
            r4 = 0
            if (r0 != 0) goto L4a
            if (r6 != r3) goto L4a
        L48:
            r3 = 0
            goto L53
        L4a:
            if (r0 != r3) goto L4f
            if (r6 != r2) goto L4f
            goto L53
        L4f:
            if (r0 != r2) goto L48
            if (r6 != r3) goto L48
        L53:
            if (r3 == 0) goto L58
            r1.start()
        L58:
            r5.l0 = r6
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.c.f0(int):void");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        e eVar = (e) this.s.b("FingerprintHelperFragment");
        if (eVar != null) {
            eVar.Z(1);
        }
    }
}
