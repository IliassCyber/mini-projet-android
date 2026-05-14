package b.i.j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import b.f.h;
import b.i.j.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b.f.f<String, Typeface> f770a = new b.f.f<>(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b.i.j.c f771b = new b.i.j.c("fonts", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f772c = new Object();
    public static final h<String, ArrayList<c.InterfaceC0030c<g>>> d = new h<>();
    public static final Comparator<byte[]> e = new d();

    public class a implements Callable<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b.i.j.a f774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f775c;
        public final /* synthetic */ String d;

        public a(Context context, b.i.j.a aVar, int i, String str) {
            this.f773a = context;
            this.f774b = aVar;
            this.f775c = i;
            this.d = str;
        }

        @Override // java.util.concurrent.Callable
        public g call() {
            g gVarB = b.b(this.f773a, this.f774b, this.f775c);
            Typeface typeface = gVarB.f784a;
            if (typeface != null) {
                b.f770a.b(this.d, typeface);
            }
            return gVarB;
        }
    }

    /* JADX INFO: renamed from: b.i.j.b$b, reason: collision with other inner class name */
    public class C0029b implements c.InterfaceC0030c<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b.i.e.b.g f776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f777b;

        public C0029b(b.i.e.b.g gVar, Handler handler) {
            this.f776a = gVar;
            this.f777b = handler;
        }

        @Override // b.i.j.c.InterfaceC0030c
        public void a(g gVar) {
            int i;
            b.i.e.b.g gVar2;
            g gVar3 = gVar;
            if (gVar3 == null) {
                gVar2 = this.f776a;
                i = 1;
            } else {
                i = gVar3.f785b;
                if (i == 0) {
                    this.f776a.b(gVar3.f784a, this.f777b);
                    return;
                }
                gVar2 = this.f776a;
            }
            gVar2.a(i, this.f777b);
        }
    }

    public class c implements c.InterfaceC0030c<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f778a;

        public c(String str) {
            this.f778a = str;
        }

        @Override // b.i.j.c.InterfaceC0030c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar) {
            synchronized (b.f772c) {
                ArrayList<c.InterfaceC0030c<g>> arrayList = b.d.get(this.f778a);
                if (arrayList == null) {
                    return;
                }
                b.d.remove(this.f778a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).a(gVar);
                }
            }
        }
    }

    public class d implements Comparator<byte[]> {
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length == bArr4.length) {
                for (int i = 0; i < bArr3.length; i++) {
                    if (bArr3[i] != bArr4[i]) {
                        length = bArr3[i];
                        length2 = bArr4[i];
                    }
                }
                return 0;
            }
            length = bArr3.length;
            length2 = bArr4.length;
            return length - length2;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f[] f780b;

        public e(int i, f[] fVarArr) {
            this.f779a = i;
            this.f780b = fVarArr;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f783c;
        public final boolean d;
        public final int e;

        public f(Uri uri, int i, int i2, boolean z, int i3) {
            if (uri == null) {
                throw null;
            }
            this.f781a = uri;
            this.f782b = i;
            this.f783c = i2;
            this.d = z;
            this.e = i3;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f785b;

        public g(Typeface typeface, int i) {
            this.f784a = typeface;
            this.f785b = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0092 A[LOOP:1: B:15:0x004d->B:30:0x0092, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0096 A[EDGE_INSN: B:80:0x0096->B:32:0x0096 BREAK  A[LOOP:1: B:15:0x004d->B:30:0x0092], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.i.j.b.e a(android.content.Context r20, android.os.CancellationSignal r21, b.i.j.a r22) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.j.b.a(android.content.Context, android.os.CancellationSignal, b.i.j.a):b.i.j.b$e");
    }

    public static g b(Context context, b.i.j.a aVar, int i) {
        try {
            e eVarA = a(context, null, aVar);
            int i2 = eVarA.f779a;
            if (i2 != 0) {
                return new g(null, i2 == 1 ? -2 : -3);
            }
            Typeface typefaceB = b.i.f.d.f748a.b(context, null, eVarA.f780b, i);
            return new g(typefaceB, typefaceB != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static Typeface c(Context context, b.i.j.a aVar, b.i.e.b.g gVar, Handler handler, boolean z, int i, int i2) {
        String str = aVar.f + "-" + i2;
        Typeface typefaceA = f770a.a(str);
        if (typefaceA != null) {
            if (gVar != null) {
                gVar.d(typefaceA);
            }
            return typefaceA;
        }
        if (z && i == -1) {
            g gVarB = b(context, aVar, i2);
            if (gVar != null) {
                int i3 = gVarB.f785b;
                if (i3 == 0) {
                    gVar.b(gVarB.f784a, handler);
                } else {
                    gVar.a(i3, handler);
                }
            }
            return gVarB.f784a;
        }
        a aVar2 = new a(context, aVar, i2, str);
        if (z) {
            try {
                return ((g) f771b.b(aVar2, i)).f784a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        C0029b c0029b = gVar == null ? null : new C0029b(gVar, handler);
        synchronized (f772c) {
            ArrayList<c.InterfaceC0030c<g>> orDefault = d.getOrDefault(str, null);
            if (orDefault != null) {
                if (c0029b != null) {
                    orDefault.add(c0029b);
                }
                return null;
            }
            if (c0029b != null) {
                ArrayList<c.InterfaceC0030c<g>> arrayList = new ArrayList<>();
                arrayList.add(c0029b);
                d.put(str, arrayList);
            }
            b.i.j.c cVar = f771b;
            c cVar2 = new c(str);
            if (cVar == null) {
                throw null;
            }
            cVar.a(new b.i.j.d(cVar, aVar2, new Handler(), cVar2));
            return null;
        }
    }

    public static Map<Uri, ByteBuffer> d(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.e == 0) {
                Uri uri = fVar.f781a;
                if (!map.containsKey(uri)) {
                    map.put(uri, a.a.a.a.a.Y(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }
}
