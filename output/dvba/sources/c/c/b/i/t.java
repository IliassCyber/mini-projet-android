package c.c.b.i;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class t implements c.c.b.j.d, c.c.b.j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, ConcurrentHashMap<c.c.b.j.b<Object>, Executor>> f1910a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue<c.c.b.j.a<?>> f1911b = new ArrayDeque();

    public t(Executor executor) {
    }
}
