package b.s;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import b.n.d;
import b.n.e;
import b.n.g;
import b.n.h;
import b.s.a;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f1093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f1094b = new a();

    public b(c cVar) {
        this.f1093a = cVar;
    }

    public void a(Bundle bundle) {
        d dVarA = this.f1093a.a();
        if (((h) dVarA).f987b != d.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        dVarA.a(new Recreator(this.f1093a));
        final a aVar = this.f1094b;
        if (aVar.f1092c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            aVar.f1091b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        dVarA.a(new e() { // from class: androidx.savedstate.SavedStateRegistry$1
            @Override // b.n.e
            public void g(g gVar, d.a aVar2) {
                a aVar3;
                boolean z;
                if (aVar2 == d.a.ON_START) {
                    aVar3 = aVar;
                    z = true;
                } else {
                    if (aVar2 != d.a.ON_STOP) {
                        return;
                    }
                    aVar3 = aVar;
                    z = false;
                }
                aVar3.d = z;
            }
        });
        aVar.f1092c = true;
    }

    public void b(Bundle bundle) {
        a aVar = this.f1094b;
        if (aVar == null) {
            throw null;
        }
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = aVar.f1091b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b.c.a.b.b<String, a.b>.d dVarB = aVar.f1090a.b();
        while (dVarB.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarB.next();
            bundle2.putBundle((String) entry.getKey(), ((a.b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
