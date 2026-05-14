package b.i.d;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f707c;

    public c(Object obj, Object obj2) {
        this.f706b = obj;
        this.f707c = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b.d != null) {
                b.d.invoke(this.f706b, this.f707c, Boolean.FALSE, "AppCompat recreation");
            } else {
                b.e.invoke(this.f706b, this.f707c, Boolean.FALSE);
            }
        } catch (RuntimeException e) {
            if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                throw e;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }
}
