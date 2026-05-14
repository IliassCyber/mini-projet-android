package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.tagmanager.zzcx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

/* JADX INFO: loaded from: classes.dex */
class zzby implements zzau {
    private static final String zzKg = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final Context mContext;
    private final zzb zzaMs;
    private volatile zzac zzaMt;
    private final zzav zzaMu;
    private final String zzaMv;
    private long zzaMw;
    private final int zzaMx;
    private zzlb zzpw;

    class zza implements zzcx.zza {
        zza() {
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zza(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzyO());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzb(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzyO());
            zzbg.zzaB("Permanent failure dispatching hitId: " + zzaqVar.zzyO());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzc(zzaq zzaqVar) {
            long jZzyP = zzaqVar.zzyP();
            if (jZzyP == 0) {
                zzby.this.zzd(zzaqVar.zzyO(), zzby.this.zzpw.currentTimeMillis());
                return;
            }
            if (jZzyP + 14400000 < zzby.this.zzpw.currentTimeMillis()) {
                zzby.this.zzq(zzaqVar.zzyO());
                zzbg.zzaB("Giving up on failed hitId: " + zzaqVar.zzyO());
            }
        }
    }

    class zzb extends SQLiteOpenHelper {
        private long zzaMA;
        private boolean zzaMz;

        zzb(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
            this.zzaMA = 0L;
        }

        private boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return zMoveToFirst;
                } catch (SQLiteException e) {
                    zzbg.zzaC("Error querying for table " + str);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : cursorRawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                cursorRawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th) {
                cursorRawQuery.close();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (this.zzaMz && this.zzaMA + 3600000 > zzby.this.zzpw.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            }
            SQLiteDatabase writableDatabase = null;
            this.zzaMz = true;
            this.zzaMA = zzby.this.zzpw.currentTimeMillis();
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzby.this.mContext.getDatabasePath(zzby.this.zzaMv).delete();
            }
            if (writableDatabase == null) {
                writableDatabase = super.getWritableDatabase();
            }
            this.zzaMz = false;
            return writableDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzal.zzbe(sQLiteDatabase.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    cursorRawQuery.moveToFirst();
                } finally {
                    cursorRawQuery.close();
                }
            }
            if (zza("gtm_hits", sQLiteDatabase)) {
                zzc(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzby.zzKg);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    zzby(zzav zzavVar, Context context) {
        this(zzavVar, context, "gtm_urls.db", 2000);
    }

    zzby(zzav zzavVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.zzaMv = str;
        this.zzaMu = zzavVar;
        this.zzpw = zzld.zzoQ();
        this.zzaMs = new zzb(this.mContext, this.zzaMv);
        this.zzaMt = new zzcx(new DefaultHttpClient(), this.mContext, new zza());
        this.zzaMw = 0L;
        this.zzaMx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzd(long j, long j2) {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzer == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j2));
        try {
            sQLiteDatabaseZzer.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
        } catch (SQLiteException e) {
            zzbg.zzaC("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
            zzq(j);
        }
    }

    private SQLiteDatabase zzer(String str) {
        try {
            return this.zzaMs.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaC(str);
            return null;
        }
    }

    private void zzh(long j, String str) {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for putHit");
        if (sQLiteDatabaseZzer == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_time", Long.valueOf(j));
        contentValues.put("hit_url", str);
        contentValues.put("hit_first_send_time", (Integer) 0);
        try {
            sQLiteDatabaseZzer.insert("gtm_hits", null, contentValues);
            this.zzaMu.zzan(false);
        } catch (SQLiteException e) {
            zzbg.zzaC("Error storing hit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzq(long j) {
        zzf(new String[]{String.valueOf(j)});
    }

    private void zzzb() {
        int iZzzc = (zzzc() - this.zzaMx) + 1;
        if (iZzzc > 0) {
            List<String> listZziY = zziY(iZzzc);
            zzbg.zzaB("Store full, deleting " + listZziY.size() + " hits to make room.");
            zzf((String[]) listZziY.toArray(new String[0]));
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void dispatch() {
        zzbg.zzaB("GTM Dispatch running...");
        if (this.zzaMt.zzyH()) {
            List<zzaq> listZziZ = zziZ(40);
            if (listZziZ.isEmpty()) {
                zzbg.zzaB("...nothing to dispatch");
                this.zzaMu.zzan(true);
            } else {
                this.zzaMt.zzr(listZziZ);
                if (zzzd() > 0) {
                    zzcu.zzzz().dispatch();
                }
            }
        }
    }

    void zzf(String[] strArr) {
        SQLiteDatabase sQLiteDatabaseZzer;
        if (strArr == null || strArr.length == 0 || (sQLiteDatabaseZzer = zzer("Error opening database for deleteHits.")) == null) {
            return;
        }
        boolean z = true;
        try {
            sQLiteDatabaseZzer.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
            zzav zzavVar = this.zzaMu;
            if (zzzc() != 0) {
                z = false;
            }
            zzavVar.zzan(z);
        } catch (SQLiteException e) {
            zzbg.zzaC("Error deleting hits");
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void zzg(long j, String str) {
        zzis();
        zzzb();
        zzh(j, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0077 A[PHI: r1
  0x0077: PHI (r1v4 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v5 android.database.Cursor) binds: [B:20:0x0075, B:14:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.List<java.lang.String> zziY(int r14) {
        /*
            r13 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r14 > 0) goto Ld
            java.lang.String r14 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.tagmanager.zzbg.zzaC(r14)
            return r0
        Ld:
            java.lang.String r1 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r2 = r13.zzer(r1)
            if (r2 != 0) goto L16
            return r0
        L16:
            r1 = 0
            java.lang.String r3 = "gtm_hits"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            java.lang.String r6 = "hit_id"
            r11 = 0
            r5[r11] = r6     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "%s ASC"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            java.lang.String r12 = "hit_id"
            r4[r11] = r12     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            java.lang.String r10 = java.lang.String.format(r10, r4)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            java.lang.String r14 = java.lang.Integer.toString(r14)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r14
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            boolean r14 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            if (r14 == 0) goto L57
        L46:
            long r2 = r1.getLong(r11)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            java.lang.String r14 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            r0.add(r14)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            boolean r14 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5c
            if (r14 != 0) goto L46
        L57:
            if (r1 == 0) goto L7a
            goto L77
        L5a:
            r14 = move-exception
            goto L7b
        L5c:
            r14 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r2.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = "Error in peekHits fetching hitIds: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r14 = r14.getMessage()     // Catch: java.lang.Throwable -> L5a
            r2.append(r14)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r14 = r2.toString()     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.tagmanager.zzbg.zzaC(r14)     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto L7a
        L77:
            r1.close()
        L7a:
            return r0
        L7b:
            if (r1 == 0) goto L80
            r1.close()
        L80:
            throw r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zziY(int):java.util.List");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<zzaq> zziZ(int i) {
        ArrayList<zzaq> arrayList;
        ArrayList arrayList2 = new ArrayList();
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for peekHits");
        if (sQLiteDatabaseZzer == null) {
            return arrayList2;
        }
        Cursor cursorQuery = null;
        try {
            try {
                boolean z = false;
                cursorQuery = sQLiteDatabaseZzer.query("gtm_hits", new String[]{"hit_id", "hit_time", "hit_first_send_time"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
                ArrayList arrayList3 = new ArrayList();
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            try {
                                arrayList3.add(new zzaq(cursorQuery.getLong(0), cursorQuery.getLong(1), cursorQuery.getLong(2)));
                            } catch (SQLiteException e) {
                                e = e;
                                arrayList2 = arrayList3;
                                zzbg.zzaC("Error in peekHits fetching hitIds: " + e.getMessage());
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return arrayList2;
                            }
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    try {
                        try {
                            arrayList = arrayList3;
                        } finally {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        arrayList = arrayList3;
                    }
                    try {
                        cursorQuery = sQLiteDatabaseZzer.query("gtm_hits", new String[]{"hit_id", "hit_url"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
                        if (cursorQuery.moveToFirst()) {
                            int i2 = 0;
                            do {
                                if (((SQLiteCursor) cursorQuery).getWindow().getNumRows() > 0) {
                                    ((zzaq) arrayList.get(i2)).zzev(cursorQuery.getString(1));
                                } else {
                                    zzbg.zzaC(String.format("HitString for hitId %d too large.  Hit will be deleted.", Long.valueOf(((zzaq) arrayList.get(i2)).zzyO())));
                                }
                                i2++;
                            } while (cursorQuery.moveToNext());
                        }
                        return arrayList;
                    } catch (SQLiteException e3) {
                        e = e3;
                        zzbg.zzaC("Error in peekHits fetching hit url: " + e.getMessage());
                        ArrayList arrayList4 = new ArrayList();
                        for (zzaq zzaqVar : arrayList) {
                            if (TextUtils.isEmpty(zzaqVar.zzyQ())) {
                                if (z) {
                                    break;
                                }
                                z = true;
                            }
                            arrayList4.add(zzaqVar);
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return arrayList4;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    arrayList2 = arrayList3;
                }
            } catch (SQLiteException e5) {
                e = e5;
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    int zzis() {
        long jCurrentTimeMillis = this.zzpw.currentTimeMillis();
        if (jCurrentTimeMillis <= this.zzaMw + 86400000) {
            return 0;
        }
        this.zzaMw = jCurrentTimeMillis;
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for deleteStaleHits.");
        if (sQLiteDatabaseZzer == null) {
            return 0;
        }
        int iDelete = sQLiteDatabaseZzer.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzpw.currentTimeMillis() - 2592000000L)});
        this.zzaMu.zzan(zzzc() == 0);
        return iDelete;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int zzzc() {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzer == null) {
            return 0;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseZzer.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                i = cursorRawQuery.moveToFirst() ? (int) cursorRawQuery.getLong(0) : 0;
            } catch (SQLiteException e) {
                zzbg.zzaC("Error getting numStoredHits");
                if (cursorRawQuery != null) {
                }
            }
            return i;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int zzzd() {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for getNumStoredHits.");
        int count = 0;
        if (sQLiteDatabaseZzer == null) {
            return 0;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabaseZzer.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
                count = cursorQuery.getCount();
            } catch (SQLiteException e) {
                zzbg.zzaC("Error getting num untried hits");
                if (cursorQuery != null) {
                }
            }
            return count;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}
