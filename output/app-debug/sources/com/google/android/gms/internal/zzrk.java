package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class zzrk implements Cloneable {
    private zzri<?, ?> zzaWb;
    private Object zzaWc;
    private List<zzrp> zzaWd = new ArrayList();

    zzrk() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzB()];
        zza(zzrg.zzA(bArr));
        return bArr;
    }

    public boolean equals(Object obj) {
        List<zzrp> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrk)) {
            return false;
        }
        zzrk zzrkVar = (zzrk) obj;
        if (this.zzaWc == null || zzrkVar.zzaWc == null) {
            List<zzrp> list2 = this.zzaWd;
            if (list2 != null && (list = zzrkVar.zzaWd) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), zzrkVar.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        zzri<?, ?> zzriVar = this.zzaWb;
        if (zzriVar != zzrkVar.zzaWb) {
            return false;
        }
        if (!zzriVar.zzaVV.isArray()) {
            return this.zzaWc.equals(zzrkVar.zzaWc);
        }
        Object obj2 = this.zzaWc;
        return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzrkVar.zzaWc) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzrkVar.zzaWc) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzrkVar.zzaWc) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzrkVar.zzaWc) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzrkVar.zzaWc) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzrkVar.zzaWc) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzrkVar.zzaWc);
    }

    public int hashCode() {
        try {
            return 527 + Arrays.hashCode(toByteArray());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    int zzB() {
        Object obj = this.zzaWc;
        if (obj != null) {
            return this.zzaWb.zzQ(obj);
        }
        Iterator<zzrp> it = this.zzaWd.iterator();
        int iZzB = 0;
        while (it.hasNext()) {
            iZzB += it.next().zzB();
        }
        return iZzB;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX INFO: renamed from: zzBM, reason: merged with bridge method [inline-methods] */
    public final zzrk clone() {
        Object objClone;
        zzrk zzrkVar = new zzrk();
        try {
            zzrkVar.zzaWb = this.zzaWb;
            if (this.zzaWd == null) {
                zzrkVar.zzaWd = null;
            } else {
                zzrkVar.zzaWd.addAll(this.zzaWd);
            }
            if (this.zzaWc != null) {
                if (this.zzaWc instanceof zzrn) {
                    objClone = ((zzrn) this.zzaWc).clone();
                } else if (this.zzaWc instanceof byte[]) {
                    objClone = ((byte[]) this.zzaWc).clone();
                } else {
                    int i = 0;
                    if (this.zzaWc instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.zzaWc;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzrkVar.zzaWc = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.zzaWc instanceof boolean[]) {
                        objClone = ((boolean[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof int[]) {
                        objClone = ((int[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof long[]) {
                        objClone = ((long[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof float[]) {
                        objClone = ((float[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof double[]) {
                        objClone = ((double[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof zzrn[]) {
                        zzrn[] zzrnVarArr = (zzrn[]) this.zzaWc;
                        zzrn[] zzrnVarArr2 = new zzrn[zzrnVarArr.length];
                        zzrkVar.zzaWc = zzrnVarArr2;
                        while (i < zzrnVarArr.length) {
                            zzrnVarArr2[i] = zzrnVarArr[i].clone();
                            i++;
                        }
                    }
                }
                zzrkVar.zzaWc = objClone;
            }
            return zzrkVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    void zza(zzrg zzrgVar) throws IOException {
        Object obj = this.zzaWc;
        if (obj != null) {
            this.zzaWb.zza(obj, zzrgVar);
            return;
        }
        Iterator<zzrp> it = this.zzaWd.iterator();
        while (it.hasNext()) {
            it.next().zza(zzrgVar);
        }
    }

    void zza(zzrp zzrpVar) {
        this.zzaWd.add(zzrpVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T zzb(zzri<?, T> zzriVar) {
        if (this.zzaWc == null) {
            this.zzaWb = zzriVar;
            this.zzaWc = zzriVar.zzx(this.zzaWd);
            this.zzaWd = null;
        } else if (this.zzaWb != zzriVar) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return (T) this.zzaWc;
    }
}
