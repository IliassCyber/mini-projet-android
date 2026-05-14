package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private static final zza zzYE = new zza(new String[0], null) { // from class: com.google.android.gms.common.data.DataHolder.1
    };
    boolean mClosed;
    private final int zzCY;
    private final int zzTS;
    int[] zzYA;
    int zzYB;
    private Object zzYC;
    private boolean zzYD;
    private final String[] zzYw;
    Bundle zzYx;
    private final CursorWindow[] zzYy;
    private final Bundle zzYz;

    public static class zza {
        private final ArrayList<HashMap<String, Object>> zzYF;
        private final String zzYG;
        private final HashMap<Object, Integer> zzYH;
        private boolean zzYI;
        private String zzYJ;
        private final String[] zzYw;

        private zza(String[] strArr, String str) {
            this.zzYw = (String[]) zzu.zzu(strArr);
            this.zzYF = new ArrayList<>();
            this.zzYG = str;
            this.zzYH = new HashMap<>();
            this.zzYI = false;
            this.zzYJ = null;
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zzYD = true;
        this.zzCY = i;
        this.zzYw = strArr;
        this.zzYy = cursorWindowArr;
        this.zzTS = i2;
        this.zzYz = bundle;
    }

    private DataHolder(zza zzaVar, int i, Bundle bundle) {
        this(zzaVar.zzYw, zza(zzaVar, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzYD = true;
        this.zzCY = 1;
        this.zzYw = (String[]) zzu.zzu(strArr);
        this.zzYy = (CursorWindow[]) zzu.zzu(cursorWindowArr);
        this.zzTS = i;
        this.zzYz = bundle;
        zznf();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzYE, i, bundle);
    }

    private static CursorWindow[] zza(zza zzaVar, int i) {
        long jLongValue;
        if (zzaVar.zzYw.length == 0) {
            return new CursorWindow[0];
        }
        List listSubList = (i < 0 || i >= zzaVar.zzYF.size()) ? zzaVar.zzYF : zzaVar.zzYF.subList(0, i);
        int size = listSubList.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(zzaVar.zzYw.length);
        CursorWindow cursorWindow2 = cursorWindow;
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i2 + ")");
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(zzaVar.zzYw.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) listSubList.get(i2);
                boolean zPutDouble = true;
                for (int i3 = 0; i3 < zzaVar.zzYw.length && zPutDouble; i3++) {
                    String str = zzaVar.zzYw[i3];
                    Object obj = map.get(str);
                    if (obj == null) {
                        zPutDouble = cursorWindow2.putNull(i2, i3);
                    } else if (obj instanceof String) {
                        zPutDouble = cursorWindow2.putString((String) obj, i2, i3);
                    } else {
                        if (obj instanceof Long) {
                            jLongValue = ((Long) obj).longValue();
                        } else if (obj instanceof Integer) {
                            zPutDouble = cursorWindow2.putLong(((Integer) obj).intValue(), i2, i3);
                        } else if (obj instanceof Boolean) {
                            jLongValue = ((Boolean) obj).booleanValue() ? 1L : 0L;
                        } else if (obj instanceof byte[]) {
                            zPutDouble = cursorWindow2.putBlob((byte[]) obj, i2, i3);
                        } else if (obj instanceof Double) {
                            zPutDouble = cursorWindow2.putDouble(((Double) obj).doubleValue(), i2, i3);
                        } else {
                            if (!(obj instanceof Float)) {
                                throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                            }
                            zPutDouble = cursorWindow2.putDouble(((Float) obj).floatValue(), i2, i3);
                        }
                        zPutDouble = cursorWindow2.putLong(jLongValue, i2, i3);
                    }
                }
                if (zPutDouble) {
                    z = false;
                } else {
                    if (z) {
                        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                    Log.d("DataHolder", "Couldn't populate window data for row " + i2 + " - allocating new window.");
                    cursorWindow2.freeLastRow();
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(zzaVar.zzYw.length);
                    arrayList.add(cursorWindow2);
                    i2--;
                    z = true;
                }
                i2++;
            } catch (RuntimeException e) {
                int size2 = arrayList.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    ((CursorWindow) arrayList.get(i4)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder zzbi(int i) {
        return zza(i, (Bundle) null);
    }

    private void zzg(String str, int i) {
        Bundle bundle = this.zzYx;
        if (bundle == null || !bundle.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= this.zzYB) {
            throw new CursorIndexOutOfBoundsException(i, this.zzYB);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (int i = 0; i < this.zzYy.length; i++) {
                    this.zzYy[i].close();
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        String string;
        try {
            if (this.zzYD && this.zzYy.length > 0 && !isClosed()) {
                if (this.zzYC == null) {
                    string = "internal object: " + toString();
                } else {
                    string = this.zzYC.toString();
                }
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + string + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzYB;
    }

    public int getStatusCode() {
        return this.zzTS;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzg(str, i);
        this.zzYy[i2].copyStringToBuffer(i, this.zzYx.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzg(str, i);
        return this.zzYy[i2].getLong(i, this.zzYx.getInt(str));
    }

    public boolean zzbV(String str) {
        return this.zzYx.containsKey(str);
    }

    public int zzbh(int i) {
        int i2 = 0;
        zzu.zzU(i >= 0 && i < this.zzYB);
        while (true) {
            int[] iArr = this.zzYA;
            if (i2 >= iArr.length) {
                break;
            }
            if (i < iArr[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zzYA.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        zzg(str, i);
        return this.zzYy[i2].getInt(i, this.zzYx.getInt(str));
    }

    public String zzd(String str, int i, int i2) {
        zzg(str, i);
        return this.zzYy[i2].getString(i, this.zzYx.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzg(str, i);
        return Long.valueOf(this.zzYy[i2].getLong(i, this.zzYx.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzg(str, i);
        return this.zzYy[i2].getFloat(i, this.zzYx.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzg(str, i);
        return this.zzYy[i2].getBlob(i, this.zzYx.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String strZzd = zzd(str, i, i2);
        if (strZzd == null) {
            return null;
        }
        return Uri.parse(strZzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzg(str, i);
        return this.zzYy[i2].isNull(i, this.zzYx.getInt(str));
    }

    public Bundle zznb() {
        return this.zzYz;
    }

    public void zznf() {
        this.zzYx = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzYw;
            if (i2 >= strArr.length) {
                break;
            }
            this.zzYx.putInt(strArr[i2], i2);
            i2++;
        }
        this.zzYA = new int[this.zzYy.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zzYy;
            if (i >= cursorWindowArr.length) {
                this.zzYB = numRows;
                return;
            }
            this.zzYA[i] = numRows;
            numRows += this.zzYy[i].getNumRows() - (numRows - cursorWindowArr[i].getStartPosition());
            i++;
        }
    }

    String[] zzng() {
        return this.zzYw;
    }

    CursorWindow[] zznh() {
        return this.zzYy;
    }

    public void zzp(Object obj) {
        this.zzYC = obj;
    }
}
