package b.l.a;

import androidx.fragment.app.Fragment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class p extends b.n.p {
    public static final b.n.q h = new a();
    public final boolean e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<Fragment> f938b = new HashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, p> f939c = new HashMap<>();
    public final HashMap<String, b.n.s> d = new HashMap<>();
    public boolean f = false;
    public boolean g = false;

    public static class a implements b.n.q {
        public <T extends b.n.p> T a(Class<T> cls) {
            return new p(true);
        }
    }

    public p(boolean z) {
        this.e = z;
    }

    @Override // b.n.p
    public void a() {
        boolean z = k.H;
        this.f = true;
    }

    public boolean b(Fragment fragment) {
        if (this.f938b.contains(fragment)) {
            return this.e ? this.f : !this.g;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.f938b.equals(pVar.f938b) && this.f939c.equals(pVar.f939c) && this.d.equals(pVar.d);
    }

    public int hashCode() {
        return this.d.hashCode() + ((this.f939c.hashCode() + (this.f938b.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f938b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f939c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
