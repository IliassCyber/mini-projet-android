package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.internal.zzgd;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzh {
    private static zzh zzAZ;
    private final zza zzAY;
    private static final String zzAX = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time");
    private static final Object zzqt = new Object();

    public class zza extends SQLiteOpenHelper {
        public zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(zzh.zzAX);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaA("Database updated from version " + i + " to version " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase);
        }
    }

    zzh(Context context) {
        this.zzAY = new zza(context, "google_inapp_purchase.db");
    }

    public static zzh zzy(Context context) {
        zzh zzhVar;
        synchronized (zzqt) {
            if (zzAZ == null) {
                zzAZ = new zzh(context);
            }
            zzhVar = zzAZ;
        }
        return zzhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getRecordCount() {
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            Cursor cursorRawQuery = null;
            try {
                try {
                    cursorRawQuery = writableDatabase.rawQuery("select count(*) from InAppPurchase", null);
                } catch (SQLiteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error getting record count" + e.getMessage());
                    if (cursorRawQuery != null) {
                    }
                }
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getInt(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return 0;
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzAY.getWritableDatabase();
        } catch (SQLiteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error opening writable conversion tracking database");
            return null;
        }
    }

    public zzf zza(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new zzf(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void zza(zzf zzfVar) {
        if (zzfVar == null) {
            return;
        }
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            writableDatabase.delete("InAppPurchase", String.format("%s = %d", "purchase_id", Long.valueOf(zzfVar.zzAR)), null);
        }
    }

    public void zzb(zzf zzfVar) {
        if (zzfVar == null) {
            return;
        }
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("product_id", zzfVar.zzAT);
            contentValues.put("developer_payload", zzfVar.zzAS);
            contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
            zzfVar.zzAR = writableDatabase.insert("InAppPurchase", null, contentValues);
            if (getRecordCount() > 20000) {
                zzfg();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<zzf> zzf(long j) {
        synchronized (zzqt) {
            LinkedList linkedList = new LinkedList();
            if (j <= 0) {
                return linkedList;
            }
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return linkedList;
            }
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", String.valueOf(j));
                    if (cursorQuery.moveToFirst()) {
                        do {
                            linkedList.add(zza(cursorQuery));
                        } while (cursorQuery.moveToNext());
                    }
                } catch (SQLiteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error extracing purchase info: " + e.getMessage());
                    if (cursorQuery != null) {
                    }
                }
                return linkedList;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void zzfg() {
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        zza(zza(cursorQuery));
                    }
                } catch (SQLiteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error remove oldest record" + e.getMessage());
                    if (cursorQuery != null) {
                    }
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }
}
