package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.AbstractPendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzo;

/* JADX INFO: loaded from: classes.dex */
public class zzp extends AbstractPendingResult<ContainerHolder> {
    private final Context mContext;
    private final Looper zzWt;
    private long zzaKD;
    private final TagManager zzaKK;
    private final zzd zzaKN;
    private final zzcd zzaKO;
    private final int zzaKP;
    private zzf zzaKQ;
    private zzqa zzaKR;
    private volatile zzo zzaKS;
    private volatile boolean zzaKT;
    private zzaf.zzj zzaKU;
    private String zzaKV;
    private zze zzaKW;
    private zza zzaKX;
    private final String zzaKy;
    private final zzlb zzpw;

    interface zza {
        boolean zzb(Container container);
    }

    private class zzb implements zzbf<zzpx.zza> {
        private zzb() {
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzz(zzpx.zza zzaVar) {
            zzaf.zzj zzjVar;
            if (zzaVar.zzaPa != null) {
                zzjVar = zzaVar.zzaPa;
            } else {
                zzaf.zzf zzfVar = zzaVar.zziO;
                zzaf.zzj zzjVar2 = new zzaf.zzj();
                zzjVar2.zziO = zzfVar;
                zzjVar2.zziN = null;
                zzjVar2.zziP = zzfVar.version;
                zzjVar = zzjVar2;
            }
            zzp.this.zza(zzjVar, zzaVar.zzaOZ, true);
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zza(zzbf.zza zzaVar) {
            if (zzp.this.zzaKT) {
                return;
            }
            zzp.this.zzR(0L);
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zzyv() {
        }
    }

    private class zzc implements zzbf<zzaf.zzj> {
        private zzc() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.tagmanager.zzbf
        public void zza(zzbf.zza zzaVar) {
            zzp zzpVar;
            ContainerHolder containerHolderCreateFailedResult;
            synchronized (zzp.this) {
                if (!zzp.this.isReady()) {
                    if (zzp.this.zzaKS != null) {
                        zzpVar = zzp.this;
                        containerHolderCreateFailedResult = zzp.this.zzaKS;
                    } else {
                        zzpVar = zzp.this;
                        containerHolderCreateFailedResult = zzp.this.createFailedResult(Status.zzXS);
                    }
                    zzpVar.setResult(containerHolderCreateFailedResult);
                }
            }
            zzp.this.zzR(3600000L);
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public void zzz(zzaf.zzj zzjVar) {
            synchronized (zzp.this) {
                if (zzjVar.zziO == null) {
                    if (zzp.this.zzaKU.zziO == null) {
                        zzbg.zzaz("Current resource is null; network resource is also null");
                        zzp.this.zzR(3600000L);
                        return;
                    }
                    zzjVar.zziO = zzp.this.zzaKU.zziO;
                }
                zzp.this.zza(zzjVar, zzp.this.zzpw.currentTimeMillis(), false);
                zzbg.zzaB("setting refresh time to current time: " + zzp.this.zzaKD);
                if (!zzp.this.zzyu()) {
                    zzp.this.zza(zzjVar);
                }
            }
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zzyv() {
        }
    }

    private class zzd implements zzo.zza {
        private zzd() {
        }

        @Override // com.google.android.gms.tagmanager.zzo.zza
        public void zzej(String str) {
            zzp.this.zzej(str);
        }

        @Override // com.google.android.gms.tagmanager.zzo.zza
        public String zzyo() {
            return zzp.this.zzyo();
        }

        @Override // com.google.android.gms.tagmanager.zzo.zza
        public void zzyq() {
            if (zzp.this.zzaKO.zzkb()) {
                zzp.this.zzR(0L);
            }
        }
    }

    interface zze extends Releasable {
        void zza(zzbf<zzaf.zzj> zzbfVar);

        void zzem(String str);

        void zzf(long j, String str);
    }

    interface zzf extends Releasable {
        void zza(zzbf<zzpx.zza> zzbfVar);

        void zzb(zzpx.zza zzaVar);

        zzqf.zzc zziR(int i);

        void zzyw();
    }

    zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzf zzfVar, zze zzeVar, zzqa zzqaVar, zzlb zzlbVar, zzcd zzcdVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.zzaKK = tagManager;
        this.zzWt = looper == null ? Looper.getMainLooper() : looper;
        this.zzaKy = str;
        this.zzaKP = i;
        this.zzaKQ = zzfVar;
        this.zzaKW = zzeVar;
        this.zzaKR = zzqaVar;
        this.zzaKN = new zzd();
        this.zzaKU = new zzaf.zzj();
        this.zzpw = zzlbVar;
        this.zzaKO = zzcdVar;
        if (zzyu()) {
            zzej(zzcb.zzzf().zzzh());
        }
    }

    public zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzs zzsVar) {
        this(context, tagManager, looper, str, i, new zzcn(context, str), new zzcm(context, str, zzsVar), new zzqa(context), zzld.zzoQ(), new zzbe(30, 900000L, 5000L, "refreshing", zzld.zzoQ()));
        this.zzaKR.zzeU(zzsVar.zzyx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zzR(long j) {
        if (this.zzaKW == null) {
            zzbg.zzaC("Refresh requested, but no network load scheduler.");
        } else {
            this.zzaKW.zzf(j, this.zzaKU.zziP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zza(zzaf.zzj zzjVar) {
        if (this.zzaKQ != null) {
            zzpx.zza zzaVar = new zzpx.zza();
            zzaVar.zzaOZ = this.zzaKD;
            zzaVar.zziO = new zzaf.zzf();
            zzaVar.zzaPa = zzjVar;
            this.zzaKQ.zzb(zzaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x000f A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x000f, B:11:0x0011, B:13:0x0045, B:15:0x0058, B:17:0x005e, B:19:0x0066, B:14:0x0053), top: B:25:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x000f, B:11:0x0011, B:13:0x0045, B:15:0x0058, B:17:0x005e, B:19:0x0066, B:14:0x0053), top: B:25:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x000f, B:11:0x0011, B:13:0x0045, B:15:0x0058, B:17:0x005e, B:19:0x0066, B:14:0x0053), top: B:25:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void zza(com.google.android.gms.internal.zzaf.zzj r10, long r11, boolean r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            if (r13 == 0) goto L9
            boolean r13 = r9.zzaKT     // Catch: java.lang.Throwable -> L6d
            if (r13 == 0) goto L9
            monitor-exit(r9)
            return
        L9:
            boolean r13 = r9.isReady()     // Catch: java.lang.Throwable -> L6d
            if (r13 == 0) goto L11
            com.google.android.gms.tagmanager.zzo r13 = r9.zzaKS     // Catch: java.lang.Throwable -> L6d
        L11:
            r9.zzaKU = r10     // Catch: java.lang.Throwable -> L6d
            r9.zzaKD = r11     // Catch: java.lang.Throwable -> L6d
            r0 = 0
            long r2 = r9.zzaKD     // Catch: java.lang.Throwable -> L6d
            r4 = 43200000(0x2932e00, double:2.1343636E-316)
            long r2 = r2 + r4
            com.google.android.gms.internal.zzlb r13 = r9.zzpw     // Catch: java.lang.Throwable -> L6d
            long r6 = r13.currentTimeMillis()     // Catch: java.lang.Throwable -> L6d
            long r2 = r2 - r6
            long r2 = java.lang.Math.min(r4, r2)     // Catch: java.lang.Throwable -> L6d
            long r0 = java.lang.Math.max(r0, r2)     // Catch: java.lang.Throwable -> L6d
            r9.zzR(r0)     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.tagmanager.Container r13 = new com.google.android.gms.tagmanager.Container     // Catch: java.lang.Throwable -> L6d
            android.content.Context r3 = r9.mContext     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.tagmanager.TagManager r0 = r9.zzaKK     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.tagmanager.DataLayer r4 = r0.getDataLayer()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r5 = r9.zzaKy     // Catch: java.lang.Throwable -> L6d
            r2 = r13
            r6 = r11
            r8 = r10
            r2.<init>(r3, r4, r5, r6, r8)     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.tagmanager.zzo r10 = r9.zzaKS     // Catch: java.lang.Throwable -> L6d
            if (r10 != 0) goto L53
            com.google.android.gms.tagmanager.zzo r10 = new com.google.android.gms.tagmanager.zzo     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.tagmanager.TagManager r11 = r9.zzaKK     // Catch: java.lang.Throwable -> L6d
            android.os.Looper r12 = r9.zzWt     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.tagmanager.zzp$zzd r0 = r9.zzaKN     // Catch: java.lang.Throwable -> L6d
            r10.<init>(r11, r12, r13, r0)     // Catch: java.lang.Throwable -> L6d
            r9.zzaKS = r10     // Catch: java.lang.Throwable -> L6d
            goto L58
        L53:
            com.google.android.gms.tagmanager.zzo r10 = r9.zzaKS     // Catch: java.lang.Throwable -> L6d
            r10.zza(r13)     // Catch: java.lang.Throwable -> L6d
        L58:
            boolean r10 = r9.isReady()     // Catch: java.lang.Throwable -> L6d
            if (r10 != 0) goto L6b
            com.google.android.gms.tagmanager.zzp$zza r10 = r9.zzaKX     // Catch: java.lang.Throwable -> L6d
            boolean r10 = r10.zzb(r13)     // Catch: java.lang.Throwable -> L6d
            if (r10 == 0) goto L6b
            com.google.android.gms.tagmanager.zzo r10 = r9.zzaKS     // Catch: java.lang.Throwable -> L6d
            r9.setResult(r10)     // Catch: java.lang.Throwable -> L6d
        L6b:
            monitor-exit(r9)
            return
        L6d:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzp.zza(com.google.android.gms.internal.zzaf$zzj, long, boolean):void");
    }

    private void zzam(final boolean z) {
        this.zzaKQ.zza(new zzb());
        this.zzaKW.zza(new zzc());
        zzqf.zzc zzcVarZziR = this.zzaKQ.zziR(this.zzaKP);
        if (zzcVarZziR != null) {
            TagManager tagManager = this.zzaKK;
            this.zzaKS = new zzo(tagManager, this.zzWt, new Container(this.mContext, tagManager.getDataLayer(), this.zzaKy, 0L, zzcVarZziR), this.zzaKN);
        }
        this.zzaKX = new zza() { // from class: com.google.android.gms.tagmanager.zzp.3
            @Override // com.google.android.gms.tagmanager.zzp.zza
            public boolean zzb(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= zzp.this.zzpw.currentTimeMillis() : !container.isDefault();
            }
        };
        if (zzyu()) {
            this.zzaKW.zzf(0L, "");
        } else {
            this.zzaKQ.zzyw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzyu() {
        zzcb zzcbVarZzzf = zzcb.zzzf();
        return (zzcbVarZzzf.zzzg() == zzcb.zza.CONTAINER || zzcbVarZzzf.zzzg() == zzcb.zza.CONTAINER_DEBUG) && this.zzaKy.equals(zzcbVarZzzf.getContainerId());
    }

    public void load(final String str) {
        int i = this.zzaKP;
        this.zzaKR.zza(this.zzaKy, i != -1 ? Integer.valueOf(i) : null, str, new zzqa.zza() { // from class: com.google.android.gms.tagmanager.zzp.1
            @Override // com.google.android.gms.internal.zzqa.zza
            public void zza(zzqe zzqeVar) {
                if (zzqeVar.getStatus() != Status.zzXP) {
                    zzbg.zzaz("Load request failed for the container " + zzp.this.zzaKy);
                    zzp zzpVar = zzp.this;
                    zzpVar.setResult(zzpVar.createFailedResult(Status.zzXR));
                    return;
                }
                zzqf.zzc zzcVarZzAk = zzqeVar.zzAg().zzAk();
                if (zzcVarZzAk == null) {
                    zzbg.zzaz("Response doesn't have the requested container");
                    zzp zzpVar2 = zzp.this;
                    zzpVar2.setResult(zzpVar2.createFailedResult(new Status(8, "Response doesn't have the requested container", null)));
                } else {
                    long jZzAl = zzqeVar.zzAg().zzAl();
                    zzp zzpVar3 = zzp.this;
                    zzpVar3.zzaKS = new zzo(zzpVar3.zzaKK, zzp.this.zzWt, new Container(zzp.this.mContext, zzp.this.zzaKK.getDataLayer(), zzp.this.zzaKy, jZzAl, zzcVarZzAk), new zzo.zza() { // from class: com.google.android.gms.tagmanager.zzp.1.1
                        @Override // com.google.android.gms.tagmanager.zzo.zza
                        public void zzej(String str2) {
                            zzp.this.zzej(str2);
                        }

                        @Override // com.google.android.gms.tagmanager.zzo.zza
                        public String zzyo() {
                            return zzp.this.zzyo();
                        }

                        @Override // com.google.android.gms.tagmanager.zzo.zza
                        public void zzyq() {
                            if (zzp.this.zzaKO.zzkb()) {
                                zzp.this.load(str);
                            }
                        }
                    });
                    zzp zzpVar4 = zzp.this;
                    zzpVar4.setResult(zzpVar4.zzaKS);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.AbstractPendingResult
    /* JADX INFO: renamed from: zzaU, reason: merged with bridge method [inline-methods] */
    public ContainerHolder createFailedResult(Status status) {
        if (this.zzaKS != null) {
            return this.zzaKS;
        }
        if (status == Status.zzXS) {
            zzbg.zzaz("timer expired: setting result to failure");
        }
        return new zzo(status);
    }

    synchronized void zzej(String str) {
        this.zzaKV = str;
        if (this.zzaKW != null) {
            this.zzaKW.zzem(str);
        }
    }

    synchronized String zzyo() {
        return this.zzaKV;
    }

    public void zzyr() {
        zzqf.zzc zzcVarZziR = this.zzaKQ.zziR(this.zzaKP);
        if (zzcVarZziR != null) {
            setResult(new zzo(this.zzaKK, this.zzWt, new Container(this.mContext, this.zzaKK.getDataLayer(), this.zzaKy, 0L, zzcVarZziR), new zzo.zza() { // from class: com.google.android.gms.tagmanager.zzp.2
                @Override // com.google.android.gms.tagmanager.zzo.zza
                public void zzej(String str) {
                    zzp.this.zzej(str);
                }

                @Override // com.google.android.gms.tagmanager.zzo.zza
                public String zzyo() {
                    return zzp.this.zzyo();
                }

                @Override // com.google.android.gms.tagmanager.zzo.zza
                public void zzyq() {
                    zzbg.zzaC("Refresh ignored: container loaded as default only.");
                }
            }));
        } else {
            zzbg.zzaz("Default was requested, but no default container was found");
            setResult(createFailedResult(new Status(10, "Default was requested, but no default container was found", null)));
        }
        this.zzaKW = null;
        this.zzaKQ = null;
    }

    public void zzys() {
        zzam(false);
    }

    public void zzyt() {
        zzam(true);
    }
}
