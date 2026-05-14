package b.l.a;

import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public class d extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f904a;

    public d(Fragment fragment) {
        this.f904a = fragment;
    }

    @Override // b.l.a.f
    public View b(int i) {
        View view = this.f904a.G;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + this + " does not have a view");
    }

    @Override // b.l.a.f
    public boolean c() {
        return this.f904a.G != null;
    }
}
