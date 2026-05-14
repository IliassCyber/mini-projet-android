package c.c.a.a.c.k.k;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<BasePendingResult<?>, Boolean> f1334a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<c.c.a.a.h.e<?>, Boolean> f1335b = Collections.synchronizedMap(new WeakHashMap());

    public final void a(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f1334a) {
            map = new HashMap(this.f1334a);
        }
        synchronized (this.f1335b) {
            map2 = new HashMap(this.f1335b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).f(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((c.c.a.a.h.e) entry2.getKey()).a(new c.c.a.a.c.k.b(status));
            }
        }
    }
}
