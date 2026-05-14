package b.b.k;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class t {
    public static t d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationManager f287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f288c = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f290b;
    }

    public t(Context context, LocationManager locationManager) {
        this.f286a = context;
        this.f287b = locationManager;
    }

    public final Location a(String str) {
        try {
            if (this.f287b.isProviderEnabled(str)) {
                return this.f287b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }
}
