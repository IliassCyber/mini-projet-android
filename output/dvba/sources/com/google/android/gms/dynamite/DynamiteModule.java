package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import c.c.a.a.e.c;
import c.c.a.a.e.d;
import c.c.a.a.e.e;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class DynamiteModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    public static Boolean f1957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    public static c f1958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    public static String f1959c;
    public static final ThreadLocal<b> d = new ThreadLocal<>();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    public static class a extends Exception {
        public a(String str, c.c.a.a.e.a aVar) {
            super(str);
        }

        public a(String str, Throwable th, c.c.a.a.e.a aVar) {
            super(str, th);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cursor f1960a;
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(str.length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(sb.toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String strValueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 51 + str.length());
            sb2.append("Module descriptor id '");
            sb2.append(strValueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(str.length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", strValueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(strValueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @GuardedBy("DynamiteModule.class")
    public static void b(ClassLoader classLoader) throws a {
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                return;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
            if (iInterfaceQueryLocalInterface instanceof e) {
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new a("Failed to instantiate dynamite loader", e, null);
        }
    }

    public static int c(Context context, String str, boolean z) {
        c dVar;
        synchronized (DynamiteModule.class) {
            if (f1958b != null) {
                dVar = f1958b;
            } else {
                if (c.c.a.a.c.e.f1288b.b(context) == 0) {
                    try {
                        IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                        if (iBinder == null) {
                            dVar = null;
                        } else {
                            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                            dVar = iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new d(iBinder);
                        }
                        if (dVar != null) {
                            f1958b = dVar;
                        }
                    } catch (Exception e) {
                        String strValueOf = String.valueOf(e.getMessage());
                        Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(strValueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                    }
                }
                dVar = null;
            }
        }
        if (dVar == null) {
            return 0;
        }
        try {
            if (dVar.g() >= 2) {
                return dVar.d(new c.c.a.a.d.b(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return dVar.f(new c.c.a.a.d.b(context), str, z);
        } catch (RemoteException e2) {
            String strValueOf2 = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", strValueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf2) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r7, java.lang.String r8, boolean r9) throws java.lang.Throwable {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            if (r9 == 0) goto La
            java.lang.String r7 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r7 = "api"
        Lc:
            int r9 = r7.length()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            int r9 = r9 + 42
            java.lang.String r2 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            int r9 = r9 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            java.lang.String r9 = "content://com.google.android.gms.chimera/"
            r2.append(r9)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            r2.append(r7)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            java.lang.String r7 = "/"
            r2.append(r7)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            r2.append(r8)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            android.net.Uri r2 = android.net.Uri.parse(r7)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L94
            if (r7 == 0) goto L80
            boolean r8 = r7.moveToFirst()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            if (r8 == 0) goto L80
            r8 = 0
            int r8 = r7.getInt(r8)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            if (r8 <= 0) goto L79
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r9 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r9)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            r1 = 2
            java.lang.String r1 = r7.getString(r1)     // Catch: java.lang.Throwable -> L76
            com.google.android.gms.dynamite.DynamiteModule.f1959c = r1     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "loaderVersion"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L76
            if (r1 < 0) goto L64
            r7.getInt(r1)     // Catch: java.lang.Throwable -> L76
        L64:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L76
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$b> r9 = com.google.android.gms.dynamite.DynamiteModule.d     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            java.lang.Object r9 = r9.get()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            com.google.android.gms.dynamite.DynamiteModule$b r9 = (com.google.android.gms.dynamite.DynamiteModule.b) r9     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            if (r9 == 0) goto L79
            android.database.Cursor r1 = r9.f1960a     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            if (r1 != 0) goto L79
            r9.f1960a = r7     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            goto L7a
        L76:
            r8 = move-exception
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L76
            throw r8     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
        L79:
            r0 = r7
        L7a:
            if (r0 == 0) goto L7f
            r0.close()
        L7f:
            return r8
        L80:
            java.lang.String r8 = "DynamiteModule"
            java.lang.String r9 = "Failed to retrieve remote module version."
            android.util.Log.w(r8, r9)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            com.google.android.gms.dynamite.DynamiteModule$a r8 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            java.lang.String r9 = "Failed to connect to dynamite module ContentResolver."
            r8.<init>(r9, r0)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
            throw r8     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La4
        L8f:
            r8 = move-exception
            goto L97
        L91:
            r7 = move-exception
            r8 = r7
            goto La6
        L94:
            r7 = move-exception
            r8 = r7
            r7 = r0
        L97:
            boolean r9 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.a     // Catch: java.lang.Throwable -> La4
            if (r9 == 0) goto L9c
            throw r8     // Catch: java.lang.Throwable -> La4
        L9c:
            com.google.android.gms.dynamite.DynamiteModule$a r9 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = "V2 version check failed"
            r9.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> La4
            throw r9     // Catch: java.lang.Throwable -> La4
        La4:
            r8 = move-exception
            r0 = r7
        La6:
            if (r0 == 0) goto Lab
            r0.close()
        Lab:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.d(android.content.Context, java.lang.String, boolean):int");
    }
}
