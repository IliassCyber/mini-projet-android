package c.c.a.a.f.c;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX WARN: Incorrect class signature: super class is equals to this class */
/* JADX INFO: loaded from: classes.dex */
public abstract class k implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NullableDecl
    public T f1456c;
    public final CharSequence d;
    public final e e;
    public int h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1455b = 2;
    public int g = 0;
    public final boolean f = false;

    public k(i iVar, CharSequence charSequence) {
        this.e = iVar.f1450a;
        this.h = iVar.f1452c;
        this.d = charSequence;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        if (r0 >= r3) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        if (r9.e.b(r9.d.charAt(r0)) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        if (r3 <= r0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        r8 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        if (r9.e.b(r9.d.charAt(r8)) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        if (r9.f == false) goto L53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean hasNext() {
        /*
            r9 = this;
            int r0 = r9.f1455b
            r1 = 0
            r2 = 1
            r3 = 4
            if (r0 == r3) goto L9
            r0 = 1
            goto La
        L9:
            r0 = 0
        La:
            if (r0 == 0) goto Lba
            int[] r0 = c.c.a.a.f.c.b.f1432a
            int r4 = r9.f1455b
            int r4 = r4 - r2
            r0 = r0[r4]
            if (r0 == r2) goto Lb9
            r4 = 2
            if (r0 == r4) goto Lb8
            r9.f1455b = r3
        L1a:
            int r0 = r9.g
        L1c:
            int r3 = r9.g
            r4 = 3
            r5 = -1
            if (r3 == r5) goto Lad
            r6 = r9
            c.c.a.a.f.c.j r6 = (c.c.a.a.f.c.j) r6
            c.c.a.a.f.c.h r7 = r6.i
            c.c.a.a.f.c.e r7 = r7.f1447a
            java.lang.CharSequence r6 = r6.d
            int r3 = r7.a(r6, r3)
            if (r3 != r5) goto L3a
            java.lang.CharSequence r3 = r9.d
            int r3 = r3.length()
            r9.g = r5
            goto L3e
        L3a:
            int r6 = r3 + 1
            r9.g = r6
        L3e:
            int r6 = r9.g
            if (r6 != r0) goto L51
            int r6 = r6 + 1
            r9.g = r6
            java.lang.CharSequence r3 = r9.d
            int r3 = r3.length()
            if (r6 <= r3) goto L1c
            r9.g = r5
            goto L1c
        L51:
            if (r0 >= r3) goto L64
            c.c.a.a.f.c.e r6 = r9.e
            java.lang.CharSequence r7 = r9.d
            char r7 = r7.charAt(r0)
            boolean r6 = r6.b(r7)
            if (r6 == 0) goto L64
            int r0 = r0 + 1
            goto L51
        L64:
            if (r3 <= r0) goto L78
            c.c.a.a.f.c.e r6 = r9.e
            java.lang.CharSequence r7 = r9.d
            int r8 = r3 + (-1)
            char r7 = r7.charAt(r8)
            boolean r6 = r6.b(r7)
            if (r6 == 0) goto L78
            r3 = r8
            goto L64
        L78:
            boolean r6 = r9.f
            if (r6 == 0) goto L7f
            if (r0 != r3) goto L7f
            goto L1a
        L7f:
            int r6 = r9.h
            if (r6 != r2) goto L9f
            java.lang.CharSequence r3 = r9.d
            int r3 = r3.length()
            r9.g = r5
        L8b:
            if (r3 <= r0) goto La2
            c.c.a.a.f.c.e r5 = r9.e
            java.lang.CharSequence r6 = r9.d
            int r7 = r3 + (-1)
            char r6 = r6.charAt(r7)
            boolean r5 = r5.b(r6)
            if (r5 == 0) goto La2
            r3 = r7
            goto L8b
        L9f:
            int r6 = r6 - r2
            r9.h = r6
        La2:
            java.lang.CharSequence r5 = r9.d
            java.lang.CharSequence r0 = r5.subSequence(r0, r3)
            java.lang.String r0 = r0.toString()
            goto Lb0
        Lad:
            r9.f1455b = r4
            r0 = 0
        Lb0:
            r9.f1456c = r0
            int r0 = r9.f1455b
            if (r0 == r4) goto Lb9
            r9.f1455b = r2
        Lb8:
            r1 = 1
        Lb9:
            return r1
        Lba:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.f.c.k.hasNext():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        if (r0 >= r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r11.e.b(r11.d.charAt(r0)) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        if (r3 <= r0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
    
        r10 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
    
        if (r11.e.b(r11.d.charAt(r10)) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
    
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
    
        if (r11.f == false) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object next() {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.f.c.k.next():java.lang.Object");
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
