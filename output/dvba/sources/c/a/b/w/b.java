package c.a.b.w;

import c.a.b.b;
import c.a.b.o;
import c.a.b.u;
import c.a.b.v;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class b implements c.a.b.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f1229c = v.f1221a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f1231b;

    public b(a aVar) {
        c cVar = new c(4096);
        this.f1230a = aVar;
        this.f1231b = cVar;
    }

    public static void a(String str, o<?> oVar, u uVar) throws u {
        c.a.b.f fVar = oVar.n;
        int i = fVar.f1195a;
        try {
            int i2 = fVar.f1196b + 1;
            fVar.f1196b = i2;
            fVar.f1195a = ((int) (i * fVar.d)) + i;
            if (!(i2 <= fVar.f1197c)) {
                throw uVar;
            }
            oVar.a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(i)));
        } catch (u e) {
            oVar.a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(i)));
            throw e;
        }
    }

    public static List<c.a.b.h> b(List<c.a.b.h> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<c.a.b.h> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().f1202a);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<c.a.b.h> list2 = aVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (c.a.b.h hVar : aVar.h) {
                    if (!treeSet.contains(hVar.f1202a)) {
                        arrayList.add(hVar);
                    }
                }
            }
        } else if (!aVar.g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new c.a.b.h(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public final Map<String, String> c(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        String str = aVar.f1187b;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j = aVar.d;
        if (j > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            map.put("If-Modified-Since", simpleDateFormat.format(new Date(j)));
        }
        return map;
    }

    public final byte[] d(InputStream inputStream, int i) throws IOException {
        i iVar = new i(this.f1231b, i);
        byte[] bArrA = null;
        try {
            bArrA = this.f1231b.a(1024);
            while (true) {
                int i2 = inputStream.read(bArrA);
                if (i2 == -1) {
                    break;
                }
                iVar.write(bArrA, 0, i2);
            }
            byte[] byteArray = iVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                v.d("Error occurred when closing InputStream", new Object[0]);
            }
            this.f1231b.b(bArrA);
            iVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                v.d("Error occurred when closing InputStream", new Object[0]);
            }
            this.f1231b.b(bArrA);
            iVar.close();
            throw th;
        }
    }

    public final void e(long j, o<?> oVar, byte[] bArr, int i) {
        if (f1229c || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = oVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(oVar.n.f1196b);
            v.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        throw new java.io.IOException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0117, code lost:
    
        throw new c.a.b.s(r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [c.a.b.w.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c.a.b.l f(c.a.b.o<?> r29) throws c.a.b.u {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.b.w.b.f(c.a.b.o):c.a.b.l");
    }
}
