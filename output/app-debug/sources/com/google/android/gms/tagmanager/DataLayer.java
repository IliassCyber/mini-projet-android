package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] zzaLf = "gtm.lifetime".toString().split("\\.");
    private static final Pattern zzaLg = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<zzb, Integer> zzaLh;
    private final Map<String, Object> zzaLi;
    private final ReentrantLock zzaLj;
    private final LinkedList<Map<String, Object>> zzaLk;
    private final zzc zzaLl;
    private final CountDownLatch zzaLm;

    static final class zza {
        public final Object zzGK;
        public final String zztw;

        zza(String str, Object obj) {
            this.zztw = str;
            this.zzGK = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zztw.equals(zzaVar.zztw) && this.zzGK.equals(zzaVar.zzGK);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zztw.hashCode()), Integer.valueOf(this.zzGK.hashCode())});
        }

        public String toString() {
            return "Key: " + this.zztw + " value: " + this.zzGK.toString();
        }
    }

    interface zzb {
        void zzF(Map<String, Object> map);
    }

    interface zzc {

        public interface zza {
            void zzo(List<zza> list);
        }

        void zza(zza zzaVar);

        void zza(List<zza> list, long j);

        void zzep(String str);
    }

    DataLayer() {
        this(new zzc() { // from class: com.google.android.gms.tagmanager.DataLayer.1
            @Override // com.google.android.gms.tagmanager.DataLayer.zzc
            public void zza(zzc.zza zzaVar) {
                zzaVar.zzo(new ArrayList());
            }

            @Override // com.google.android.gms.tagmanager.DataLayer.zzc
            public void zza(List<zza> list, long j) {
            }

            @Override // com.google.android.gms.tagmanager.DataLayer.zzc
            public void zzep(String str) {
            }
        });
    }

    DataLayer(zzc zzcVar) {
        this.zzaLl = zzcVar;
        this.zzaLh = new ConcurrentHashMap<>();
        this.zzaLi = new HashMap();
        this.zzaLj = new ReentrantLock();
        this.zzaLk = new LinkedList<>();
        this.zzaLm = new CountDownLatch(1);
        zzyy();
    }

    public static List<Object> listOf(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Map<String, Object> mapOf(Object... objArr) {
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap map = new HashMap();
        for (int i = 0; i < objArr.length; i += 2) {
            if (!(objArr[i] instanceof String)) {
                throw new IllegalArgumentException("key is not a string: " + objArr[i]);
            }
            map.put((String) objArr[i], objArr[i + 1]);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzH(Map<String, Object> map) {
        this.zzaLj.lock();
        try {
            this.zzaLk.offer(map);
            if (this.zzaLj.getHoldCount() == 1) {
                zzyz();
            }
            zzI(map);
        } finally {
            this.zzaLj.unlock();
        }
    }

    private void zzI(Map<String, Object> map) {
        Long lZzJ = zzJ(map);
        if (lZzJ == null) {
            return;
        }
        List<zza> listZzL = zzL(map);
        listZzL.remove("gtm.lifetime");
        this.zzaLl.zza(listZzL, lZzJ.longValue());
    }

    private Long zzJ(Map<String, Object> map) {
        Object objZzK = zzK(map);
        if (objZzK == null) {
            return null;
        }
        return zzeo(objZzK.toString());
    }

    private Object zzK(Map<String, Object> map) {
        String[] strArr = zzaLf;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            String str = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(str);
        }
        return obj;
    }

    private List<zza> zzL(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        zza(map, "", arrayList);
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void zzM(Map<String, Object> map) {
        synchronized (this.zzaLi) {
            for (String str : map.keySet()) {
                zzc(zzj(str, map.get(str)), this.zzaLi);
            }
        }
        zzN(map);
    }

    private void zzN(Map<String, Object> map) {
        Iterator<zzb> it = this.zzaLh.keySet().iterator();
        while (it.hasNext()) {
            it.next().zzF(map);
        }
    }

    private void zza(Map<String, Object> map, String str, Collection<zza> collection) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str.length() == 0 ? "" : ".");
            sb.append(entry.getKey());
            String string = sb.toString();
            if (entry.getValue() instanceof Map) {
                zza((Map) entry.getValue(), string, collection);
            } else if (!string.equals("gtm.lifetime")) {
                collection.add(new zza(string, entry.getValue()));
            }
        }
    }

    static Long zzeo(String str) {
        long j;
        long j2;
        long j3;
        Matcher matcher = zzaLg.matcher(str);
        if (!matcher.matches()) {
            zzbg.zzaA("unknown _lifetime: " + str);
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException e) {
            zzbg.zzaC("illegal number in _lifetime value: " + str);
            j = 0L;
        }
        if (j <= 0) {
            zzbg.zzaA("non-positive _lifetime: " + str);
            return null;
        }
        String strGroup = matcher.group(2);
        if (strGroup.length() == 0) {
            return Long.valueOf(j);
        }
        char cCharAt = strGroup.charAt(0);
        if (cCharAt != 'd') {
            if (cCharAt == 'h') {
                j3 = j * 1000 * 60;
            } else if (cCharAt == 'm') {
                j3 = j * 1000;
            } else {
                if (cCharAt != 's') {
                    zzbg.zzaC("unknown units in _lifetime: " + str);
                    return null;
                }
                j2 = j * 1000;
            }
            j2 = j3 * 60;
        } else {
            j2 = j * 1000 * 60 * 60 * 24;
        }
        return Long.valueOf(j2);
    }

    private void zzyy() {
        this.zzaLl.zza(new zzc.zza() { // from class: com.google.android.gms.tagmanager.DataLayer.2
            @Override // com.google.android.gms.tagmanager.DataLayer.zzc.zza
            public void zzo(List<zza> list) {
                for (zza zzaVar : list) {
                    DataLayer dataLayer = DataLayer.this;
                    dataLayer.zzH(dataLayer.zzj(zzaVar.zztw, zzaVar.zzGK));
                }
                DataLayer.this.zzaLm.countDown();
            }
        });
    }

    private void zzyz() {
        int i = 0;
        do {
            Map<String, Object> mapPoll = this.zzaLk.poll();
            if (mapPoll == null) {
                return;
            }
            zzM(mapPoll);
            i++;
        } while (i <= 500);
        this.zzaLk.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object get(String str) {
        synchronized (this.zzaLi) {
            Object obj = this.zzaLi;
            for (String str2 : str.split("\\.")) {
                if (!(obj instanceof Map)) {
                    return null;
                }
                obj = ((Map) obj).get(str2);
                if (obj == null) {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String str, Object obj) {
        push(zzj(str, obj));
    }

    public void push(Map<String, Object> map) {
        try {
            this.zzaLm.await();
        } catch (InterruptedException e) {
            zzbg.zzaC("DataLayer.push: unexpected InterruptedException");
        }
        zzH(map);
    }

    public void pushEvent(String str, Map<String, Object> map) {
        HashMap map2 = new HashMap(map);
        map2.put("event", str);
        push(map2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        String string;
        synchronized (this.zzaLi) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : this.zzaLi.entrySet()) {
                sb.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", entry.getKey(), entry.getValue()));
            }
            string = sb.toString();
        }
        return string;
    }

    void zza(zzb zzbVar) {
        this.zzaLh.put(zzbVar, 0);
    }

    void zzb(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                zzb((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                zzc((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    void zzc(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                zzb((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                zzc((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void zzen(String str) {
        push(str, null);
        this.zzaLl.zzep(str);
    }

    Map<String, Object> zzj(String str, Object obj) {
        HashMap map = new HashMap();
        String[] strArrSplit = str.toString().split("\\.");
        int i = 0;
        HashMap map2 = map;
        while (i < strArrSplit.length - 1) {
            HashMap map3 = new HashMap();
            map2.put(strArrSplit[i], map3);
            i++;
            map2 = map3;
        }
        map2.put(strArrSplit[strArrSplit.length - 1], obj);
        return map;
    }
}
