package b.i.k;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final c d = d.f807c;
    public static final String e = Character.toString(8206);
    public static final String f = Character.toString(8207);
    public static final a g = new a(false, 2, d);
    public static final a h = new a(true, 2, d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f798c;

    /* JADX INFO: renamed from: b.i.k.a$a, reason: collision with other inner class name */
    public static class C0031a {
        public static final byte[] f = new byte[1792];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f801c;
        public int d;
        public char e;

        static {
            for (int i = 0; i < 1792; i++) {
                f[i] = Character.getDirectionality(i);
            }
        }

        public C0031a(CharSequence charSequence, boolean z) {
            this.f799a = charSequence;
            this.f800b = z;
            this.f801c = charSequence.length();
        }

        public byte a() {
            char cCharAt;
            char cCharAt2;
            char cCharAt3 = this.f799a.charAt(this.d - 1);
            this.e = cCharAt3;
            if (Character.isLowSurrogate(cCharAt3)) {
                int iCodePointBefore = Character.codePointBefore(this.f799a, this.d);
                this.d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.d--;
            char c2 = this.e;
            byte directionality = c2 < 1792 ? f[c2] : Character.getDirectionality(c2);
            if (!this.f800b) {
                return directionality;
            }
            char c3 = this.e;
            if (c3 != '>') {
                if (c3 != ';') {
                    return directionality;
                }
                int i = this.d;
                do {
                    int i2 = this.d;
                    if (i2 <= 0) {
                        break;
                    }
                    CharSequence charSequence = this.f799a;
                    int i3 = i2 - 1;
                    this.d = i3;
                    cCharAt = charSequence.charAt(i3);
                    this.e = cCharAt;
                    if (cCharAt == '&') {
                        return (byte) 12;
                    }
                } while (cCharAt != ';');
                this.d = i;
                this.e = ';';
                return (byte) 13;
            }
            int i4 = this.d;
            while (true) {
                int i5 = this.d;
                if (i5 <= 0) {
                    break;
                }
                CharSequence charSequence2 = this.f799a;
                int i6 = i5 - 1;
                this.d = i6;
                char cCharAt4 = charSequence2.charAt(i6);
                this.e = cCharAt4;
                if (cCharAt4 == '<') {
                    break;
                }
                if (cCharAt4 == '>') {
                    break;
                }
                if (cCharAt4 == '\"' || cCharAt4 == '\'') {
                    char c4 = this.e;
                    do {
                        int i7 = this.d;
                        if (i7 > 0) {
                            CharSequence charSequence3 = this.f799a;
                            int i8 = i7 - 1;
                            this.d = i8;
                            cCharAt2 = charSequence3.charAt(i8);
                            this.e = cCharAt2;
                        }
                    } while (cCharAt2 != c4);
                }
            }
            this.d = i4;
            this.e = '>';
            return (byte) 13;
        }
    }

    public a(boolean z, int i, c cVar) {
        this.f796a = z;
        this.f797b = i;
        this.f798c = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00db, code lost:
    
        if (r3 != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00de, code lost:
    
        if (r4 == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e4, code lost:
    
        if (r0.d <= 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ea, code lost:
    
        switch(r0.a()) {
            case 14: goto L106;
            case 15: goto L106;
            case 16: goto L105;
            case 17: goto L105;
            case 18: goto L104;
            default: goto L111;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ee, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f1, code lost:
    
        if (r3 != r5) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f3, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f5, code lost:
    
        if (r3 != r5) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f9, code lost:
    
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fc, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.CharSequence r12) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.k.a.a(java.lang.CharSequence):int");
    }

    public static int b(CharSequence charSequence) {
        C0031a c0031a = new C0031a(charSequence, false);
        c0031a.d = c0031a.f801c;
        int i = 0;
        int i2 = 0;
        while (c0031a.d > 0) {
            byte bA = c0031a.a();
            if (bA == 0) {
                if (i == 0) {
                    return -1;
                }
                if (i2 == 0) {
                    i2 = i;
                }
            } else if (bA == 1 || bA == 2) {
                if (i == 0) {
                    return 1;
                }
                if (i2 == 0) {
                    i2 = i;
                }
            } else if (bA != 9) {
                switch (bA) {
                    case 14:
                    case 15:
                        if (i2 == i) {
                            return -1;
                        }
                        i--;
                        break;
                    case 16:
                    case 17:
                        if (i2 == i) {
                            return 1;
                        }
                        i--;
                        break;
                    case 18:
                        i++;
                        break;
                    default:
                        if (i2 == 0) {
                            i2 = i;
                        }
                        break;
                }
            } else {
                continue;
            }
        }
        return 0;
    }

    public static a c() {
        boolean z = e.a(Locale.getDefault()) == 1;
        c cVar = d;
        return cVar == d ? z ? h : g : new a(z, 2, cVar);
    }
}
