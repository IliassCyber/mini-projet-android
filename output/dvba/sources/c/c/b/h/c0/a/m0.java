package c.c.b.h.c0.a;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<Pair<String, String>> f1804a;

    static {
        SparseArray<Pair<String, String>> sparseArray = new SparseArray<>();
        f1804a = sparseArray;
        c.a.a.a.a.g("ERROR_INVALID_CUSTOM_TOKEN", "The custom token format is incorrect. Please check the documentation.", sparseArray, 17000);
        c.a.a.a.a.g("ERROR_CUSTOM_TOKEN_MISMATCH", "The custom token corresponds to a different audience.", f1804a, 17002);
        c.a.a.a.a.g("ERROR_INVALID_CREDENTIAL", "The supplied auth credential is malformed or has expired.", f1804a, 17004);
        c.a.a.a.a.g("ERROR_INVALID_EMAIL", "The email address is badly formatted.", f1804a, 17008);
        c.a.a.a.a.g("ERROR_WRONG_PASSWORD", "The password is invalid or the user does not have a password.", f1804a, 17009);
        c.a.a.a.a.g("ERROR_USER_MISMATCH", "The supplied credentials do not correspond to the previously signed in user.", f1804a, 17024);
        c.a.a.a.a.g("ERROR_REQUIRES_RECENT_LOGIN", "This operation is sensitive and requires recent authentication. Log in again before retrying this request.", f1804a, 17014);
        c.a.a.a.a.g("ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL", "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address.", f1804a, 17012);
        c.a.a.a.a.g("ERROR_EMAIL_ALREADY_IN_USE", "The email address is already in use by another account.", f1804a, 17007);
        c.a.a.a.a.g("ERROR_CREDENTIAL_ALREADY_IN_USE", "This credential is already associated with a different user account.", f1804a, 17025);
        c.a.a.a.a.g("ERROR_USER_DISABLED", "The user account has been disabled by an administrator.", f1804a, 17005);
        c.a.a.a.a.g("ERROR_USER_TOKEN_EXPIRED", "The user's credential is no longer valid. The user must sign in again.", f1804a, 17021);
        c.a.a.a.a.g("ERROR_USER_NOT_FOUND", "There is no user record corresponding to this identifier. The user may have been deleted.", f1804a, 17011);
        c.a.a.a.a.g("ERROR_INVALID_USER_TOKEN", "This user's credential isn't valid for this project. This can happen if the user's token has been tampered with, or if the user isn't for the project associated with this API key.", f1804a, 17017);
        c.a.a.a.a.g("ERROR_OPERATION_NOT_ALLOWED", "The given sign-in provider is disabled for this Firebase project. Enable it in the Firebase console, under the sign-in method tab of the Auth section.", f1804a, 17006);
        c.a.a.a.a.g("ERROR_WEAK_PASSWORD", "The given password is invalid.", f1804a, 17026);
        c.a.a.a.a.g("ERROR_EXPIRED_ACTION_CODE", "The out of band code has expired.", f1804a, 17029);
        c.a.a.a.a.g("ERROR_INVALID_ACTION_CODE", "The out of band code is invalid. This can happen if the code is malformed, expired, or has already been used.", f1804a, 17030);
        c.a.a.a.a.g("ERROR_INVALID_MESSAGE_PAYLOAD", "The email template corresponding to this action contains invalid characters in its message. Please fix by going to the Auth email templates section in the Firebase Console.", f1804a, 17031);
        c.a.a.a.a.g("ERROR_INVALID_RECIPIENT_EMAIL", "The email corresponding to this action failed to send as the provided recipient email address is invalid.", f1804a, 17033);
        c.a.a.a.a.g("ERROR_INVALID_SENDER", "The email template corresponding to this action contains an invalid sender email or name. Please fix by going to the Auth email templates section in the Firebase Console.", f1804a, 17032);
        c.a.a.a.a.g("ERROR_MISSING_EMAIL", "An email address must be provided.", f1804a, 17034);
        c.a.a.a.a.g("ERROR_MISSING_PASSWORD", "A password must be provided.", f1804a, 17035);
        c.a.a.a.a.g("ERROR_MISSING_PHONE_NUMBER", "To send verification codes, provide a phone number for the recipient.", f1804a, 17041);
        c.a.a.a.a.g("ERROR_INVALID_PHONE_NUMBER", "The format of the phone number provided is incorrect. Please enter the phone number in a format that can be parsed into E.164 format. E.164 phone numbers are written in the format [+][country code][subscriber number including area code].", f1804a, 17042);
        c.a.a.a.a.g("ERROR_MISSING_VERIFICATION_CODE", "The Phone Auth Credential was created with an empty sms verification Code", f1804a, 17043);
        c.a.a.a.a.g("ERROR_INVALID_VERIFICATION_CODE", "The sms verification code used to create the phone auth credential is invalid. Please resend the verification code sms and be sure use the verification code provided by the user.", f1804a, 17044);
        c.a.a.a.a.g("ERROR_MISSING_VERIFICATION_ID", "The Phone Auth Credential was created with an empty verification ID", f1804a, 17045);
        c.a.a.a.a.g("ERROR_INVALID_VERIFICATION_ID", "The verification ID used to create the phone auth credential is invalid.", f1804a, 17046);
        c.a.a.a.a.g("ERROR_RETRY_PHONE_AUTH", "An error occurred during authentication using the PhoneAuthCredential. Please retry authentication.", f1804a, 17049);
        c.a.a.a.a.g("ERROR_SESSION_EXPIRED", "The sms code has expired. Please re-send the verification code to try again.", f1804a, 17051);
        c.a.a.a.a.g("ERROR_QUOTA_EXCEEDED", "The sms quota for this project has been exceeded.", f1804a, 17052);
        c.a.a.a.a.g("ERROR_APP_NOT_AUTHORIZED", "This app is not authorized to use Firebase Authentication. Please verify that the correct package name and SHA-1 are configured in the Firebase Console.", f1804a, 17028);
        c.a.a.a.a.g("ERROR_API_NOT_AVAILABLE_WITHOUT_GOOGLE_PLAY", "The API that you are calling is not available on devices without Google Play services.", f1804a, 17063);
        c.a.a.a.a.g("ERROR_WEB_INTERNAL_ERROR", "There was an internal error in the web widget.", f1804a, 17062);
        c.a.a.a.a.g("ERROR_INVALID_CERT_HASH", "There was an error while trying to get your package certificate hash.", f1804a, 17064);
        c.a.a.a.a.g("ERROR_WEB_STORAGE_UNSUPPORTED", "This browser is not supported or 3rd party cookies and data may be disabled.", f1804a, 17065);
        c.a.a.a.a.g("ERROR_MISSING_CONTINUE_URI", "A continue URL must be provided in the request.", f1804a, 17040);
        c.a.a.a.a.g("ERROR_DYNAMIC_LINK_NOT_ACTIVATED", "Please activate Dynamic Links in the Firebase Console and agree to the terms and conditions.", f1804a, 17068);
        c.a.a.a.a.g("ERROR_INVALID_PROVIDER_ID", "The provider ID provided for the attempted web operation is invalid.", f1804a, 17071);
        c.a.a.a.a.g("ERROR_WEB_CONTEXT_ALREADY_PRESENTED", "A headful operation is already in progress. Please wait for that to finish.", f1804a, 17057);
        c.a.a.a.a.g("ERROR_WEB_CONTEXT_CANCELED", "The web operation was canceled by the user.", f1804a, 17058);
        c.a.a.a.a.g("ERROR_TENANT_ID_MISMATCH", "The provided tenant ID does not match the Auth instance's tenant ID.", f1804a, 17072);
        c.a.a.a.a.g("ERROR_UNSUPPORTED_TENANT_OPERATION", "This operation is not supported in a multi-tenant context.", f1804a, 17073);
        c.a.a.a.a.g("ERROR_INVALID_DYNAMIC_LINK_DOMAIN", "The provided dynamic link domain is not configured or authorized for the current project.", f1804a, 17074);
        c.a.a.a.a.g("ERROR_REJECTED_CREDENTIAL", "The request contains malformed or mismatching credentials", f1804a, 17075);
        c.a.a.a.a.g("ERROR_PHONE_NUMBER_NOT_FOUND", "The provided phone number does not match any of the second factor phone numbers associated with this user.", f1804a, 17077);
        c.a.a.a.a.g("ERROR_INVALID_TENANT_ID", "The Auth instance's tenant ID is invalid.", f1804a, 17079);
        c.a.a.a.a.g("ERROR_SECOND_FACTOR_REQUIRED", "Please complete a second factor challenge to finish signing into this account.", f1804a, 17078);
        c.a.a.a.a.g("ERROR_API_NOT_AVAILABLE", "The API that you are calling is not available.", f1804a, 17080);
        c.a.a.a.a.g("ERROR_MISSING_MULTI_FACTOR_SESSION", "The request is missing proof of first factor successful sign-in.", f1804a, 17081);
        c.a.a.a.a.g("ERROR_MISSING_MULTI_FACTOR_INFO", "No second factor identifier is provided.", f1804a, 17082);
        c.a.a.a.a.g("ERROR_INVALID_MULTI_FACTOR_SESSION", "The request does not contain a valid proof of first factor successful sign-in.", f1804a, 17083);
        c.a.a.a.a.g("ERROR_MULTI_FACTOR_INFO_NOT_FOUND", "The user does not have a second factor matching the identifier provided.", f1804a, 17084);
        c.a.a.a.a.g("ERROR_ADMIN_RESTRICTED_OPERATION", "This operation is restricted to administrators only.", f1804a, 17085);
        c.a.a.a.a.g("ERROR_UNVERIFIED_EMAIL", "This operation requires a verified email.", f1804a, 17086);
        c.a.a.a.a.g("ERROR_SECOND_FACTOR_ALREADY_ENROLLED", "The second factor is already enrolled on this account.", f1804a, 17087);
        c.a.a.a.a.g("ERROR_MAXIMUM_SECOND_FACTOR_COUNT_EXCEEDED", "The maximum allowed number of second factors on a user has been exceeded.", f1804a, 17088);
        c.a.a.a.a.g("ERROR_UNSUPPORTED_FIRST_FACTOR", "Enrolling a second factor or signing in with a multi-factor account requires sign-in with a supported first factor.", f1804a, 17089);
        c.a.a.a.a.g("ERROR_EMAIL_CHANGE_NEEDS_VERIFICATION", "Multi-factor users must always have a verified email.", f1804a, 17090);
        c.a.a.a.a.g("ERROR_INTERNAL_SUCCESS_SIGN_OUT", "This is an internal error code indicating that the operation was successful but the user needs to be signed out.", f1804a, 17091);
        c.a.a.a.a.g("ERROR_MISSING_CLIENT_IDENTIFIER", "This request is missing a reCAPTCHA token.", f1804a, 17093);
        c.a.a.a.a.g("ERROR_MISSING_OR_INVALID_NONCE", "The request does not contain a valid nonce. This can occur if the SHA-256 hash of the provided raw nonce does not match the hashed nonce in the ID token payload.", f1804a, 17094);
        c.a.a.a.a.g("ERROR_USER_CANCELLED", "The user did not grant your application the permissions it requested.", f1804a, 18001);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static c.c.b.c a(com.google.android.gms.common.api.Status r4) {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.b.h.c0.a.m0.a(com.google.android.gms.common.api.Status):c.c.b.c");
    }

    public static c.c.b.c b(Status status, c.c.b.h.b bVar, String str, String str2) {
        int i = status.f1952c;
        if (!(i == 17012 || i == 17007 || i == 17025)) {
            return a(status);
        }
        Pair<String, String> pair = f1804a.get(i);
        return new c.c.b.h.l(d(i), e(pair != null ? (String) pair.second : "An internal error has occurred.", status));
    }

    public static c.c.b.h.j c(FirebaseAuth firebaseAuth, c.c.a.a.f.c.v0 v0Var, c.c.b.h.o oVar) {
        if (firebaseAuth == null || v0Var == null) {
            throw null;
        }
        Pair<String, String> pair = f1804a.get(17078);
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        List<c.c.b.h.s> listT0 = c.c.a.a.c.l.q.t0(v0Var.f1482c);
        ArrayList arrayList = new ArrayList();
        for (c.c.b.h.s sVar : listT0) {
            if (sVar instanceof c.c.b.h.y) {
                arrayList.add((c.c.b.h.y) sVar);
            }
        }
        List<c.c.b.h.s> listT02 = c.c.a.a.c.l.q.t0(v0Var.f1482c);
        String str3 = v0Var.f1481b;
        c.c.a.a.c.l.q.f(listT02);
        c.c.a.a.c.l.q.d(str3);
        c.c.b.h.d0.g0 g0Var = new c.c.b.h.d0.g0();
        g0Var.d = new ArrayList();
        for (c.c.b.h.s sVar2 : listT02) {
            if (sVar2 instanceof c.c.b.h.y) {
                g0Var.d.add((c.c.b.h.y) sVar2);
            }
        }
        g0Var.f1842c = str3;
        c.c.b.b bVar = firebaseAuth.f2025a;
        bVar.a();
        return new c.c.b.h.j(str, str2, new c.c.b.h.d0.f0(arrayList, g0Var, bVar.f1763b, v0Var.d, (c.c.b.h.d0.c0) oVar));
    }

    public static String d(int i) {
        Pair<String, String> pair = f1804a.get(i);
        return pair != null ? (String) pair.first : "INTERNAL_ERROR";
    }

    public static String e(String str, Status status) {
        return TextUtils.isEmpty(status.d) ? str : String.format(String.valueOf(str).concat(" [ %s ]"), status.d);
    }
}
