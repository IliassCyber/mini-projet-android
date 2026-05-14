package b.i.m;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import b.b.o.i.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f823a;

    public interface a {
    }

    public b(Context context) {
    }

    public boolean a() {
        return true;
    }

    public View b(MenuItem menuItem) {
        return ((j.a) this).f375b.onCreateActionView();
    }

    public boolean c() {
        return false;
    }

    public void d(a aVar) {
        if (this.f823a != null) {
            StringBuilder sbE = c.a.a.a.a.e("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sbE.append(getClass().getSimpleName());
            sbE.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", sbE.toString());
        }
        this.f823a = aVar;
    }
}
