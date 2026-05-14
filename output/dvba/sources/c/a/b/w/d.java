package c.a.b.w;

import android.os.SystemClock;
import c.a.b.b;
import c.a.b.v;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class d implements c.a.b.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f1237c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f1235a = new LinkedHashMap(16, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1236b = 0;
    public final int d = 5242880;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f1238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1240c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;
        public final List<c.a.b.h> h;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(String str, b.a aVar) {
            List list;
            String str2 = aVar.f1187b;
            long j = aVar.f1188c;
            long j2 = aVar.d;
            long j3 = aVar.e;
            long j4 = aVar.f;
            List<c.a.b.h> list2 = aVar.h;
            if (list2 != null) {
                list = list2;
            } else {
                Map<String, String> map = aVar.g;
                ArrayList arrayList = new ArrayList(map.size());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    arrayList.add(new c.a.b.h(entry.getKey(), entry.getValue()));
                }
                list = arrayList;
            }
            this(str, str2, j, j2, j3, j4, list);
            this.f1238a = aVar.f1186a.length;
        }

        public a(String str, String str2, long j, long j2, long j3, long j4, List<c.a.b.h> list) {
            this.f1239b = str;
            this.f1240c = "".equals(str2) ? null : str2;
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }

        public static a a(b bVar) throws IOException {
            if (d.h(bVar) != 538247942) {
                throw new IOException();
            }
            String strJ = d.j(bVar);
            String strJ2 = d.j(bVar);
            long jI = d.i(bVar);
            long jI2 = d.i(bVar);
            long jI3 = d.i(bVar);
            long jI4 = d.i(bVar);
            int iH = d.h(bVar);
            if (iH < 0) {
                throw new IOException("readHeaderList size=" + iH);
            }
            List listEmptyList = iH == 0 ? Collections.emptyList() : new ArrayList();
            for (int i = 0; i < iH; i++) {
                listEmptyList.add(new c.a.b.h(d.j(bVar).intern(), d.j(bVar).intern()));
            }
            return new a(strJ, strJ2, jI, jI2, jI3, jI4, listEmptyList);
        }

        public b.a b(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f1186a = bArr;
            aVar.f1187b = this.f1240c;
            aVar.f1188c = this.d;
            aVar.d = this.e;
            aVar.e = this.f;
            aVar.f = this.g;
            List<c.a.b.h> list = this.h;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (c.a.b.h hVar : list) {
                treeMap.put(hVar.f1202a, hVar.f1203b);
            }
            aVar.g = treeMap;
            aVar.h = Collections.unmodifiableList(this.h);
            return aVar;
        }

        public boolean c(OutputStream outputStream) {
            try {
                d.m(outputStream, 538247942);
                d.o(outputStream, this.f1239b);
                d.o(outputStream, this.f1240c == null ? "" : this.f1240c);
                d.n(outputStream, this.d);
                d.n(outputStream, this.e);
                d.n(outputStream, this.f);
                d.n(outputStream, this.g);
                List<c.a.b.h> list = this.h;
                if (list != null) {
                    d.m(outputStream, list.size());
                    for (c.a.b.h hVar : list) {
                        d.o(outputStream, hVar.f1202a);
                        d.o(outputStream, hVar.f1203b);
                    }
                } else {
                    d.m(outputStream, 0);
                }
                outputStream.flush();
                return true;
            } catch (IOException e) {
                v.b("%s", e.toString());
                return false;
            }
        }
    }

    public static class b extends FilterInputStream {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1242c;

        public b(InputStream inputStream, long j) {
            super(inputStream);
            this.f1241b = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.f1242c++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.f1242c += (long) i3;
            }
            return i3;
        }
    }

    public d(File file) {
        this.f1237c = file;
    }

    public static int g(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    public static int h(InputStream inputStream) {
        return (g(inputStream) << 24) | (g(inputStream) << 0) | 0 | (g(inputStream) << 8) | (g(inputStream) << 16);
    }

    public static long i(InputStream inputStream) {
        return ((((long) g(inputStream)) & 255) << 0) | 0 | ((((long) g(inputStream)) & 255) << 8) | ((((long) g(inputStream)) & 255) << 16) | ((((long) g(inputStream)) & 255) << 24) | ((((long) g(inputStream)) & 255) << 32) | ((((long) g(inputStream)) & 255) << 40) | ((((long) g(inputStream)) & 255) << 48) | ((255 & ((long) g(inputStream))) << 56);
    }

    public static String j(b bVar) {
        return new String(l(bVar, i(bVar)), "UTF-8");
    }

    public static byte[] l(b bVar, long j) throws IOException {
        long j2 = bVar.f1241b - bVar.f1242c;
        if (j >= 0 && j <= j2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + j2);
    }

    public static void m(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static void n(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void o(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        n(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public synchronized void a() {
        File[] fileArrListFiles = this.f1237c.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
        this.f1235a.clear();
        this.f1236b = 0L;
        v.b("Cache cleared.", new Object[0]);
    }

    public File b(String str) {
        return new File(this.f1237c, c(str));
    }

    public final String c(String str) {
        int length = str.length() / 2;
        StringBuilder sbE = c.a.a.a.a.e(String.valueOf(str.substring(0, length).hashCode()));
        sbE.append(String.valueOf(str.substring(length).hashCode()));
        return sbE.toString();
    }

    public final void d(int i) {
        long j;
        long j2 = i;
        if (this.f1236b + j2 < this.d) {
            return;
        }
        if (v.f1221a) {
            v.d("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f1236b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f1235a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (b(value.f1239b).delete()) {
                j = j2;
                this.f1236b -= value.f1238a;
            } else {
                j = j2;
                String str = value.f1239b;
                v.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
            }
            it.remove();
            i2++;
            if (this.f1236b + j < this.d * 0.9f) {
                break;
            } else {
                j2 = j;
            }
        }
        if (v.f1221a) {
            v.d("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f1236b - j3), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    public synchronized void e(String str, b.a aVar) {
        d(aVar.f1186a.length);
        File fileB = b(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileB));
            a aVar2 = new a(str, aVar);
            if (!aVar2.c(bufferedOutputStream)) {
                bufferedOutputStream.close();
                v.b("Failed to write header for %s", fileB.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(aVar.f1186a);
            bufferedOutputStream.close();
            f(str, aVar2);
        } catch (IOException unused) {
            if (fileB.delete()) {
                return;
            }
            v.b("Could not clean up file %s", fileB.getAbsolutePath());
        }
    }

    public final void f(String str, a aVar) {
        if (this.f1235a.containsKey(str)) {
            this.f1236b = (aVar.f1238a - this.f1235a.get(str).f1238a) + this.f1236b;
        } else {
            this.f1236b += aVar.f1238a;
        }
        this.f1235a.put(str, aVar);
    }

    public synchronized void k(String str) {
        boolean zDelete = b(str).delete();
        a aVarRemove = this.f1235a.remove(str);
        if (aVarRemove != null) {
            this.f1236b -= aVarRemove.f1238a;
        }
        if (!zDelete) {
            v.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }
}
