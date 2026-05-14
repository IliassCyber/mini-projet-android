package b.b.k;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes.dex */
public class g extends q implements DialogInterface {
    public final AlertController d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlertController.b f252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f253b;

        public a(Context context) {
            int iD = g.d(context, 0);
            this.f252a = new AlertController.b(new ContextThemeWrapper(context, g.d(context, iD)));
            this.f253b = iD;
        }

        public g a() {
            g gVar = new g(this.f252a.f49a, this.f253b);
            AlertController.b bVar = this.f252a;
            AlertController alertController = gVar.d;
            View view = bVar.g;
            if (view != null) {
                alertController.G = view;
            } else {
                CharSequence charSequence = bVar.f;
                if (charSequence != null) {
                    alertController.e = charSequence;
                    TextView textView = alertController.E;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = bVar.d;
                if (drawable != null) {
                    alertController.C = drawable;
                    alertController.B = 0;
                    ImageView imageView = alertController.D;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.D.setImageDrawable(drawable);
                    }
                }
                int i = bVar.f51c;
                if (i != 0) {
                    alertController.f(i);
                }
                int i2 = bVar.e;
                if (i2 != 0) {
                    if (alertController == null) {
                        throw null;
                    }
                    TypedValue typedValue = new TypedValue();
                    alertController.f43a.getTheme().resolveAttribute(i2, typedValue, true);
                    alertController.f(typedValue.resourceId);
                }
            }
            CharSequence charSequence2 = bVar.h;
            if (charSequence2 != null) {
                alertController.f = charSequence2;
                TextView textView2 = alertController.F;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = bVar.i;
            if (charSequence3 != null) {
                alertController.e(-1, charSequence3, bVar.j, null, null);
            }
            CharSequence charSequence4 = bVar.k;
            if (charSequence4 != null) {
                alertController.e(-2, charSequence4, bVar.l, null, null);
            }
            if (bVar.q != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) bVar.f50b.inflate(alertController.L, (ViewGroup) null);
                int i3 = bVar.v ? alertController.N : alertController.O;
                ListAdapter dVar = bVar.q;
                if (dVar == null) {
                    dVar = new AlertController.d(bVar.f49a, i3, R.id.text1, null);
                }
                alertController.H = dVar;
                alertController.I = bVar.w;
                if (bVar.r != null) {
                    recycleListView.setOnItemClickListener(new f(bVar, alertController));
                }
                if (bVar.v) {
                    recycleListView.setChoiceMode(1);
                }
                alertController.g = recycleListView;
            }
            View view2 = bVar.t;
            if (view2 == null) {
                int i4 = bVar.s;
                if (i4 != 0) {
                    alertController.h = null;
                    alertController.i = i4;
                    alertController.n = false;
                }
            } else if (bVar.u) {
                alertController.h = view2;
                alertController.i = 0;
                alertController.n = true;
                alertController.j = 0;
                alertController.k = 0;
                alertController.l = 0;
                alertController.m = 0;
            } else {
                alertController.h = view2;
                alertController.i = 0;
                alertController.n = false;
            }
            gVar.setCancelable(this.f252a.m);
            if (this.f252a.m) {
                gVar.setCanceledOnTouchOutside(true);
            }
            gVar.setOnCancelListener(this.f252a.n);
            gVar.setOnDismissListener(this.f252a.o);
            DialogInterface.OnKeyListener onKeyListener = this.f252a.p;
            if (onKeyListener != null) {
                gVar.setOnKeyListener(onKeyListener);
            }
            return gVar;
        }
    }

    public g(Context context, int i) {
        super(context, d(context, i));
        this.d = new AlertController(getContext(), this, getWindow());
    }

    public static int d(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.b.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x02ea A[PHI: r4
  0x02ea: PHI (r4v7 android.view.View) = (r4v6 android.view.View), (r4v18 android.view.View) binds: [B:134:0x02e8, B:131:0x02df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.b.k.q, android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r17) {
        /*
            Method dump skipped, instruction units count: 951
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.k.g.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.d.A;
        if (nestedScrollView != null && nestedScrollView.j(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.d.A;
        if (nestedScrollView != null && nestedScrollView.j(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // b.b.k.q, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.d;
        alertController.e = charSequence;
        TextView textView = alertController.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
