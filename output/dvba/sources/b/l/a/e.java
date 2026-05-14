package b.l.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import b.n.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends ComponentActivity {
    public final g g;
    public final b.n.h h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public b.f.i<String> m;

    public class a extends i<e> implements b.n.t, b.a.c {
        public a() {
            super(e.this);
        }

        @Override // b.n.g
        public b.n.d a() {
            return e.this.h;
        }

        @Override // b.l.a.f
        public View b(int i) {
            return e.this.findViewById(i);
        }

        @Override // b.l.a.f
        public boolean c() {
            Window window = e.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // b.a.c
        public OnBackPressedDispatcher d() {
            return e.this.f;
        }

        @Override // b.n.t
        public b.n.s f() {
            return e.this.f();
        }
    }

    public e() {
        a aVar = new a();
        a.a.a.a.a.h(aVar, "callbacks == null");
        this.g = new g(aVar);
        this.h = new b.n.h(this);
        this.k = true;
    }

    public static void l(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public static boolean n(j jVar, d.b bVar) {
        List<Fragment> listEmptyList;
        k kVar = (k) jVar;
        if (kVar.g.isEmpty()) {
            listEmptyList = Collections.emptyList();
        } else {
            synchronized (kVar.g) {
                listEmptyList = (List) kVar.g.clone();
            }
        }
        boolean zN = false;
        for (Fragment fragment : listEmptyList) {
            if (fragment != null) {
                if (fragment.R.f987b.compareTo(d.b.STARTED) >= 0) {
                    fragment.R.f(bVar);
                    zN = true;
                }
                i iVar = fragment.t;
                if ((iVar == null ? null : e.this) != null) {
                    zN |= n(fragment.j(), bVar);
                }
            }
        }
        return zN;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.i);
        printWriter.print(" mResumed=");
        printWriter.print(this.j);
        printWriter.print(" mStopped=");
        printWriter.print(this.k);
        if (getApplication() != null) {
            b.o.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.g.f905a.f.a(str, fileDescriptor, printWriter, strArr);
    }

    public j m() {
        return this.g.f905a.f;
    }

    public void o() {
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.g.a();
        int i3 = i >> 16;
        if (i3 == 0) {
            b.i.d.a.g();
            super.onActivityResult(i, i2, intent);
            return;
        }
        int i4 = i3 - 1;
        String strD = this.m.d(i4);
        this.m.h(i4);
        if (strD == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        } else if (this.g.f905a.f.T(strD) == null) {
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strD);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.g.a();
        this.g.f905a.f.m(configuration);
    }

    @Override // androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        i<?> iVar = this.g.f905a;
        iVar.f.g(iVar, iVar, null);
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            i<?> iVar2 = this.g.f905a;
            if (!(iVar2 instanceof b.n.t)) {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
            iVar2.f.j0(parcelable);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.l = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.m = new b.f.i<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.m.g(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.m == null) {
            this.m = new b.f.i<>(10);
            this.l = 0;
        }
        super.onCreate(bundle);
        this.h.d(d.a.ON_CREATE);
        this.g.f905a.f.o();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean zOnCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        g gVar = this.g;
        return zOnCreatePanelMenu | gVar.f905a.f.p(menu, getMenuInflater());
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = this.g.f905a.f.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.g.f905a.f.q();
        this.h.d(d.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.g.f905a.f.r();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.g.f905a.f.H(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.g.f905a.f.n(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.g.f905a.f.s(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.g.a();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.g.f905a.f.I(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.j = false;
        this.g.f905a.f.M(3);
        this.h.d(d.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.g.f905a.f.K(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.h.d(d.a.ON_RESUME);
        k kVar = this.g.f905a.f;
        kVar.v = false;
        kVar.w = false;
        kVar.M(4);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return i == 0 ? super.onPreparePanel(0, view, menu) | this.g.f905a.f.L(menu) : super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.g.a();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String strD = this.m.d(i3);
            this.m.h(i3);
            if (strD == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            } else if (this.g.f905a.f.T(strD) == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strD);
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.j = true;
        this.g.a();
        this.g.f905a.f.P();
    }

    @Override // androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        while (n(m(), d.b.CREATED)) {
        }
        this.h.d(d.a.ON_STOP);
        Parcelable parcelableL0 = this.g.f905a.f.l0();
        if (parcelableL0 != null) {
            bundle.putParcelable("android:support:fragments", parcelableL0);
        }
        if (this.m.i() > 0) {
            bundle.putInt("android:support:next_request_index", this.l);
            int[] iArr = new int[this.m.i()];
            String[] strArr = new String[this.m.i()];
            for (int i = 0; i < this.m.i(); i++) {
                iArr[i] = this.m.f(i);
                strArr[i] = this.m.j(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.k = false;
        if (!this.i) {
            this.i = true;
            k kVar = this.g.f905a.f;
            kVar.v = false;
            kVar.w = false;
            kVar.M(2);
        }
        this.g.a();
        this.g.f905a.f.P();
        this.h.d(d.a.ON_START);
        k kVar2 = this.g.f905a.f;
        kVar2.v = false;
        kVar2.w = false;
        kVar2.M(3);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.g.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.k = true;
        while (n(m(), d.b.CREATED)) {
        }
        k kVar = this.g.f905a.f;
        kVar.w = true;
        kVar.M(2);
        this.h.d(d.a.ON_STOP);
    }

    @Deprecated
    public void p() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (i != -1) {
            l(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            l(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (i != -1) {
            l(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i != -1) {
            l(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = this.g.f905a.f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }
}
