package c.a.b;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f1207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<h> f1208c;
    public final boolean d;

    public l(int i, byte[] bArr, Map<String, String> map, List<h> list, boolean z, long j) {
        this.f1206a = bArr;
        this.f1207b = map;
        this.f1208c = list == null ? null : Collections.unmodifiableList(list);
        this.d = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Map] */
    public l(int i, byte[] bArr, boolean z, long j, List<h> list) {
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (h hVar : list) {
                treeMap.put(hVar.f1202a, hVar.f1203b);
            }
        }
        this(i, bArr, treeMap, list, z, j);
    }
}
