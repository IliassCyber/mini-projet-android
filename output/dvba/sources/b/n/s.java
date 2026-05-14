package b.n;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, p> f995a = new HashMap<>();

    public final void a() {
        for (p pVar : this.f995a.values()) {
            Map<String, Object> map = pVar.f994a;
            if (map != null) {
                synchronized (map) {
                    for (Object obj : pVar.f994a.values()) {
                        if (obj instanceof Closeable) {
                            try {
                                ((Closeable) obj).close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
            pVar.a();
        }
        this.f995a.clear();
    }
}
