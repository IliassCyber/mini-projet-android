package b.l.a;

import androidx.fragment.app.Fragment;
import b.n.d;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f944c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public ArrayList<Runnable> q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<a> f942a = new ArrayList<>();
    public boolean p = false;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f947c;
        public int d;
        public int e;
        public int f;
        public d.b g;
        public d.b h;

        public a() {
        }

        public a(int i, Fragment fragment) {
            this.f945a = i;
            this.f946b = fragment;
            d.b bVar = d.b.RESUMED;
            this.g = bVar;
            this.h = bVar;
        }
    }

    public r b(Fragment fragment, String str) {
        g(0, fragment, str, 1);
        return this;
    }

    public void c(a aVar) {
        this.f942a.add(aVar);
        aVar.f947c = this.f943b;
        aVar.d = this.f944c;
        aVar.e = this.d;
        aVar.f = this.e;
    }

    public r d(Fragment fragment) {
        c(new a(7, fragment));
        return this;
    }

    public abstract int e();

    public abstract r f(Fragment fragment);

    public void g(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder sbE = c.a.a.a.a.e("Fragment ");
            sbE.append(cls.getCanonicalName());
            sbE.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(sbE.toString());
        }
        if (str != null) {
            String str2 = fragment.y;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.y + " now " + str);
            }
            fragment.y = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.w;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.w + " now " + i);
            }
            fragment.w = i;
            fragment.x = i;
        }
        c(new a(i2, fragment));
    }
}
