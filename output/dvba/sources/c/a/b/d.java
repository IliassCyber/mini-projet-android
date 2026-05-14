package c.a.b;

import android.os.Process;
import android.text.TextUtils;
import c.a.b.b;
import c.a.b.o;
import c.a.b.w.d;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class d extends Thread {
    public static final boolean h = v.f1221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue<o<?>> f1191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlockingQueue<o<?>> f1192c;
    public final b d;
    public final r e;
    public volatile boolean f = false;
    public final a g = new a(this);

    public static class a implements o.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<o<?>>> f1193a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f1194b;

        public a(d dVar) {
            this.f1194b = dVar;
        }

        public static boolean a(a aVar, o oVar) {
            synchronized (aVar) {
                String strF = oVar.f();
                if (!aVar.f1193a.containsKey(strF)) {
                    aVar.f1193a.put(strF, null);
                    synchronized (oVar.f) {
                        oVar.p = aVar;
                    }
                    if (v.f1221a) {
                        v.b("new request, sending to network %s", strF);
                    }
                    return false;
                }
                List<o<?>> arrayList = aVar.f1193a.get(strF);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                oVar.a("waiting-for-response");
                arrayList.add(oVar);
                aVar.f1193a.put(strF, arrayList);
                if (v.f1221a) {
                    v.b("Request for cacheKey=%s is in flight, putting on hold.", strF);
                }
                return true;
            }
        }

        public synchronized void b(o<?> oVar) {
            String strF = oVar.f();
            List<o<?>> listRemove = this.f1193a.remove(strF);
            if (listRemove != null && !listRemove.isEmpty()) {
                if (v.f1221a) {
                    v.d("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), strF);
                }
                o<?> oVarRemove = listRemove.remove(0);
                this.f1193a.put(strF, listRemove);
                synchronized (oVarRemove.f) {
                    oVarRemove.p = this;
                }
                try {
                    this.f1194b.f1192c.put(oVarRemove);
                } catch (InterruptedException e) {
                    v.c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    d dVar = this.f1194b;
                    dVar.f = true;
                    dVar.interrupt();
                }
            }
        }
    }

    public d(BlockingQueue<o<?>> blockingQueue, BlockingQueue<o<?>> blockingQueue2, b bVar, r rVar) {
        this.f1191b = blockingQueue;
        this.f1192c = blockingQueue2;
        this.d = bVar;
        this.e = rVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List] */
    public final void a() throws InterruptedException {
        b.a aVarB;
        ?? arrayList;
        ?? r11;
        o<?> oVarTake = this.f1191b.take();
        oVarTake.a("cache-queue-take");
        if (oVarTake.i()) {
            oVarTake.c("cache-discard-canceled");
            return;
        }
        b bVar = this.d;
        String strF = oVarTake.f();
        c.a.b.w.d dVar = (c.a.b.w.d) bVar;
        synchronized (dVar) {
            d.a aVar = dVar.f1235a.get(strF);
            if (aVar != null) {
                File fileB = dVar.b(strF);
                try {
                    d.b bVar2 = new d.b(new BufferedInputStream(new FileInputStream(fileB)), fileB.length());
                    try {
                        d.a aVarA = d.a.a(bVar2);
                        if (TextUtils.equals(strF, aVarA.f1239b)) {
                            aVarB = aVar.b(c.a.b.w.d.l(bVar2, bVar2.f1241b - bVar2.f1242c));
                        } else {
                            v.b("%s: key=%s, found=%s", fileB.getAbsolutePath(), strF, aVarA.f1239b);
                            d.a aVarRemove = dVar.f1235a.remove(strF);
                            if (aVarRemove != null) {
                                dVar.f1236b -= aVarRemove.f1238a;
                            }
                        }
                    } finally {
                        bVar2.close();
                    }
                } catch (IOException e) {
                    v.b("%s: %s", fileB.getAbsolutePath(), e.toString());
                    dVar.k(strF);
                }
            }
            aVarB = null;
        }
        if (aVarB == null) {
            oVarTake.a("cache-miss");
            if (a.a(this.g, oVarTake)) {
                return;
            }
        } else {
            if (!(aVarB.e < System.currentTimeMillis())) {
                oVarTake.a("cache-hit");
                byte[] bArr = aVarB.f1186a;
                Map<String, String> map = aVarB.g;
                if (map == null) {
                    r11 = 0;
                } else {
                    if (map.isEmpty()) {
                        arrayList = Collections.emptyList();
                    } else {
                        arrayList = new ArrayList(map.size());
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            arrayList.add(new h(entry.getKey(), entry.getValue()));
                        }
                    }
                    r11 = arrayList;
                }
                q<?> qVarL = oVarTake.l(new l(200, bArr, map, r11, false, 0L));
                oVarTake.a("cache-hit-parsed");
                if (aVarB.f < System.currentTimeMillis()) {
                    oVarTake.a("cache-hit-refresh-needed");
                    oVarTake.o = aVarB;
                    qVarL.d = true;
                    if (!a.a(this.g, oVarTake)) {
                        ((g) this.e).a(oVarTake, qVarL, new c(this, oVarTake));
                        return;
                    }
                }
                ((g) this.e).a(oVarTake, qVarL, null);
                return;
            }
            oVarTake.a("cache-hit-expired");
            oVarTake.o = aVarB;
            if (a.a(this.g, oVarTake)) {
                return;
            }
        }
        this.f1192c.put(oVarTake);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (h) {
            v.d("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        c.a.b.w.d dVar = (c.a.b.w.d) this.d;
        synchronized (dVar) {
            if (dVar.f1237c.exists()) {
                File[] fileArrListFiles = dVar.f1237c.listFiles();
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        try {
                            long length = file.length();
                            d.b bVar = new d.b(new BufferedInputStream(new FileInputStream(file)), length);
                            try {
                                d.a aVarA = d.a.a(bVar);
                                aVarA.f1238a = length;
                                dVar.f(aVarA.f1239b, aVarA);
                                bVar.close();
                            } catch (Throwable th) {
                                bVar.close();
                                throw th;
                            }
                        } catch (IOException unused) {
                            file.delete();
                        }
                    }
                }
            } else if (!dVar.f1237c.mkdirs()) {
                v.c("Unable to create cache dir %s", dVar.f1237c.getAbsolutePath());
            }
        }
        while (true) {
            try {
                a();
            } catch (InterruptedException unused2) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
