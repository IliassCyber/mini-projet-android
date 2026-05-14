package c.c.a.a.f.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException(c.c.a.a.c.l.q.B0(i, length, "index"));
        }
        while (i < length) {
            if (b(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean b(char c2);
}
