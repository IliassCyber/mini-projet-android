package c.c.a.a.c.l;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("sCache")
    public static final b.f.h<String, String> f1371a = new b.f.h<>();

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            c.c.a.a.c.p.a aVarA = c.c.a.a.c.p.b.a(context);
            return aVarA.f1418a.getPackageManager().getApplicationLabel(aVarA.f1418a.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(c.c.a.a.b.b.common_google_play_services_notification_channel_name);
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i == 1) {
            return resources.getString(c.c.a.a.b.b.common_google_play_services_install_text, strA);
        }
        if (i == 2) {
            return q.J(context) ? resources.getString(c.c.a.a.b.b.common_google_play_services_wear_update_text) : resources.getString(c.c.a.a.b.b.common_google_play_services_update_text, strA);
        }
        if (i == 3) {
            return resources.getString(c.c.a.a.b.b.common_google_play_services_enable_text, strA);
        }
        if (i == 5) {
            return f(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i == 7) {
            return f(context, "common_google_play_services_network_error_text", strA);
        }
        if (i == 9) {
            return resources.getString(c.c.a.a.b.b.common_google_play_services_unsupported_text, strA);
        }
        if (i == 20) {
            return f(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i) {
            case 16:
                return f(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return f(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(c.c.a.a.b.b.common_google_play_services_updating_text, strA);
            default:
                return resources.getString(c.c.a.a.c.i.common_google_play_services_unknown_issue, strA);
        }
    }

    public static String d(Context context, int i) {
        String string;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(c.c.a.a.b.b.common_google_play_services_install_title);
            case 2:
                return resources.getString(c.c.a.a.b.b.common_google_play_services_update_title);
            case 3:
                return resources.getString(c.c.a.a.b.b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return e(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return e(context, "common_google_play_services_network_error_title");
            case 8:
                string = "Internal error occurred. Please see logs for detailed information";
                break;
            case 9:
                string = "Google Play services is invalid. Cannot recover.";
                break;
            case 10:
                string = "Developer error occurred. Please see logs for detailed information";
                break;
            case 11:
                string = "The application is not licensed to the user.";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i);
                string = sb.toString();
                break;
            case 16:
                string = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return e(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return e(context, "common_google_play_services_restricted_profile_title");
        }
        Log.e("GoogleApiAvailability", string);
        return null;
    }

    public static String e(Context context, String str) {
        synchronized (f1371a) {
            String orDefault = f1371a.getOrDefault(str, null);
            if (orDefault != null) {
                return orDefault;
            }
            Resources resourcesD = c.c.a.a.c.f.d(context);
            if (resourcesD == null) {
                return null;
            }
            int identifier = resourcesD.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String strValueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", strValueOf.length() != 0 ? "Missing resource: ".concat(strValueOf) : new String("Missing resource: "));
                return null;
            }
            String string = resourcesD.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                f1371a.put(str, string);
                return string;
            }
            String strValueOf2 = String.valueOf(str);
            Log.w("GoogleApiAvailability", strValueOf2.length() != 0 ? "Got empty resource: ".concat(strValueOf2) : new String("Got empty resource: "));
            return null;
        }
    }

    public static String f(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strE = e(context, str);
        if (strE == null) {
            strE = resources.getString(c.c.a.a.c.i.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strE, str2);
    }
}
