package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import b.n.d;
import b.n.e;
import b.n.g;
import b.n.h;
import b.s.a;
import b.s.c;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class Recreator implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f236a;

    public Recreator(c cVar) {
        this.f236a = cVar;
    }

    @Override // b.n.e
    public void g(g gVar, d.a aVar) {
        if (aVar != d.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        ((h) gVar.a()).f986a.d(this);
        a aVarE = this.f236a.e();
        if (!aVarE.f1092c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = aVarE.f1091b;
        Bundle bundle2 = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle("androidx.savedstate.Restarter");
            aVarE.f1091b.remove("androidx.savedstate.Restarter");
            if (aVarE.f1091b.isEmpty()) {
                aVarE.f1091b = null;
            }
            bundle2 = bundle3;
        }
        if (bundle2 == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundle2.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.InterfaceC0044a.class);
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    try {
                        ((a.InterfaceC0044a) declaredConstructor.newInstance(new Object[0])).a(this.f236a);
                    } catch (Exception e) {
                        throw new RuntimeException(c.a.a.a.a.c("Failed to instantiate ", str), e);
                    }
                } catch (NoSuchMethodException e2) {
                    StringBuilder sbE = c.a.a.a.a.e("Class");
                    sbE.append(clsAsSubclass.getSimpleName());
                    sbE.append(" must have default constructor in order to be automatically recreated");
                    throw new IllegalStateException(sbE.toString(), e2);
                }
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException("Class " + str + " wasn't found", e3);
            }
        }
    }
}
