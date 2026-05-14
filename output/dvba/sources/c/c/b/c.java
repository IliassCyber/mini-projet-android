package c.c.b;

import c.c.a.a.c.l.q;

/* JADX INFO: loaded from: classes.dex */
public class c extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(str);
        q.e(str, "Detail message must not be empty");
    }
}
