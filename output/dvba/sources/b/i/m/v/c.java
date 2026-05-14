package b.i.m.v;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f872a;

    public static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f873a;

        public a(c cVar) {
            this.f873a = cVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            b.i.m.v.b bVarA = this.f873a.a(i);
            if (bVarA == null) {
                return null;
            }
            return bVarA.f864a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (this.f873a != null) {
                return null;
            }
            throw null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f873a.c(i, i2, bundle);
        }
    }

    public static class b extends a {
        public b(c cVar) {
            super(cVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            b.i.m.v.b bVarB = this.f873a.b(i);
            if (bVarB == null) {
                return null;
            }
            return bVarB.f864a;
        }
    }

    public c() {
        this.f872a = new b(this);
    }

    public c(Object obj) {
        this.f872a = obj;
    }

    public b.i.m.v.b a(int i) {
        return null;
    }

    public b.i.m.v.b b(int i) {
        return null;
    }

    public boolean c(int i, int i2, Bundle bundle) {
        return false;
    }
}
