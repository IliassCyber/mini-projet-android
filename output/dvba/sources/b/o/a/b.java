package b.o.a;

import b.f.i;
import b.n.g;
import b.n.l;
import b.n.m;
import b.n.p;
import b.n.q;
import b.n.r;
import b.n.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class b extends b.o.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f997b;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<D>] */
    public static class a<D> extends l<D> {
        public g j;
        public C0040b<D> k;

        @Override // androidx.lifecycle.LiveData
        public void d() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void e() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void f(m<? super D> mVar) {
            super.f(mVar);
            this.j = null;
            this.k = null;
        }

        @Override // b.n.l
        public void g(D d) {
            super.g(d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            a.a.a.a.a.d(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: b.o.a.b$b, reason: collision with other inner class name */
    public static class C0040b<D> implements m<D> {
    }

    public static class c extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final q f998c = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i<a> f999b = new i<>(10);

        public static class a implements q {
            public <T extends p> T a(Class<T> cls) {
                return new c();
            }
        }

        @Override // b.n.p
        public void a() {
            if (this.f999b.i() > 0) {
                this.f999b.j(0);
                throw null;
            }
            i<a> iVar = this.f999b;
            int i = iVar.e;
            Object[] objArr = iVar.d;
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = null;
            }
            iVar.e = 0;
            iVar.f593b = false;
        }
    }

    public b(g gVar, s sVar) {
        this.f996a = gVar;
        q qVar = c.f998c;
        String canonicalName = c.class.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        String strC = c.a.a.a.a.c("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
        p pVarA = sVar.f995a.get(strC);
        if (!c.class.isInstance(pVarA)) {
            pVarA = qVar instanceof r ? ((r) qVar).a(strC, c.class) : ((c.a) qVar).a(c.class);
            p pVarPut = sVar.f995a.put(strC, pVarA);
            if (pVarPut != null) {
                pVarPut.a();
            }
        }
        this.f997b = (c) pVarA;
    }

    @Override // b.o.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        c cVar = this.f997b;
        if (cVar.f999b.i() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (cVar.f999b.i() <= 0) {
                return;
            }
            a aVarJ = cVar.f999b.j(0);
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(cVar.f999b.f(0));
            printWriter.print(": ");
            printWriter.println(aVarJ.toString());
            printWriter.print(str2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str2);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            throw null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        a.a.a.a.a.d(this.f996a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
