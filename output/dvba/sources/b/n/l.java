package b.n;

import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: classes.dex */
public class l<T> extends LiveData<T> {
    public void g(T t) {
        LiveData.a("setValue");
        this.f++;
        this.d = t;
        c(null);
    }
}
