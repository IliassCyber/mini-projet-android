package b.l.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.l.a.k.i;
import b.l.a.r;

/* JADX INFO: loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler W;
    public Runnable X = new a();
    public int Y = 0;
    public int Z = 0;
    public boolean a0 = true;
    public boolean b0 = true;
    public int c0 = -1;
    public Dialog d0;
    public boolean e0;
    public boolean f0;
    public boolean g0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            Dialog dialog = cVar.d0;
            if (dialog != null) {
                cVar.onDismiss(dialog);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void A(Bundle bundle) {
        super.A(bundle);
        this.W = new Handler();
        this.b0 = this.x == 0;
        if (bundle != null) {
            this.Y = bundle.getInt("android:style", 0);
            this.Z = bundle.getInt("android:theme", 0);
            this.a0 = bundle.getBoolean("android:cancelable", true);
            this.b0 = bundle.getBoolean("android:showsDialog", this.b0);
            this.c0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void C() {
        this.E = true;
        Dialog dialog = this.d0;
        if (dialog != null) {
            this.e0 = true;
            dialog.setOnDismissListener(null);
            this.d0.dismiss();
            if (!this.f0) {
                onDismiss(this.d0);
            }
            this.d0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void D() {
        this.E = true;
        if (this.g0 || this.f0) {
            return;
        }
        this.f0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater E(Bundle bundle) {
        Context context;
        if (!this.b0) {
            return super.E(bundle);
        }
        Dialog dialogA0 = a0(bundle);
        this.d0 = dialogA0;
        if (dialogA0 != null) {
            int i = this.Y;
            if (i == 1 || i == 2) {
                dialogA0.requestWindowFeature(1);
                context = this.d0.getContext();
            } else {
                if (i == 3) {
                    dialogA0.getWindow().addFlags(24);
                    dialogA0.requestWindowFeature(1);
                }
                context = this.d0.getContext();
            }
        } else {
            context = this.t.f908c;
        }
        return (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.fragment.app.Fragment
    public void I(Bundle bundle) {
        Bundle bundleOnSaveInstanceState;
        Dialog dialog = this.d0;
        if (dialog != null && (bundleOnSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.Y;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.Z;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.a0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.b0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.c0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void J() {
        this.E = true;
        Dialog dialog = this.d0;
        if (dialog != null) {
            this.e0 = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void K() {
        this.E = true;
        Dialog dialog = this.d0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void Z(boolean z, boolean z2) {
        if (this.f0) {
            return;
        }
        this.f0 = true;
        this.g0 = false;
        Dialog dialog = this.d0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.d0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.W.getLooper()) {
                    onDismiss(this.d0);
                } else {
                    this.W.post(this.X);
                }
            }
        }
        this.e0 = true;
        if (this.c0 >= 0) {
            j jVarP = P();
            int i = this.c0;
            k kVar = (k) jVarP;
            if (i >= 0) {
                kVar.N(kVar.new i(null, i, 1), false);
                this.c0 = -1;
                return;
            } else {
                throw new IllegalArgumentException("Bad id: " + i);
            }
        }
        b.l.a.a aVar = new b.l.a.a((k) P());
        k kVar2 = this.s;
        if (kVar2 != null && kVar2 != aVar.r) {
            StringBuilder sbE = c.a.a.a.a.e("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
            sbE.append(toString());
            sbE.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(sbE.toString());
        }
        aVar.c(new r.a(3, this));
        if (z) {
            aVar.e();
        } else {
            aVar.i(false);
        }
    }

    public abstract Dialog a0(Bundle bundle);

    public void b0(j jVar, String str) {
        this.f0 = false;
        this.g0 = true;
        k kVar = (k) jVar;
        if (kVar == null) {
            throw null;
        }
        b.l.a.a aVar = new b.l.a.a(kVar);
        aVar.g(0, this, str, 1);
        aVar.i(false);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.e0) {
            return;
        }
        Z(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void y(Bundle bundle) {
        Bundle bundle2;
        this.E = true;
        if (this.b0) {
            View view = this.G;
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.d0.setContentView(view);
            }
            e eVarG = g();
            if (eVarG != null) {
                this.d0.setOwnerActivity(eVarG);
            }
            this.d0.setCancelable(this.a0);
            this.d0.setOnCancelListener(this);
            this.d0.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.d0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void z(Context context) {
        super.z(context);
        if (this.g0) {
            return;
        }
        this.f0 = false;
    }
}
