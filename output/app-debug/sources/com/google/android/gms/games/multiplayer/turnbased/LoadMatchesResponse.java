package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class LoadMatchesResponse {
    private final InvitationBuffer zzauD;
    private final TurnBasedMatchBuffer zzauE;
    private final TurnBasedMatchBuffer zzauF;
    private final TurnBasedMatchBuffer zzauG;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder dataHolderZza = zza(bundle, 0);
        if (dataHolderZza != null) {
            this.zzauD = new InvitationBuffer(dataHolderZza);
        } else {
            this.zzauD = null;
        }
        DataHolder dataHolderZza2 = zza(bundle, 1);
        if (dataHolderZza2 != null) {
            this.zzauE = new TurnBasedMatchBuffer(dataHolderZza2);
        } else {
            this.zzauE = null;
        }
        DataHolder dataHolderZza3 = zza(bundle, 2);
        if (dataHolderZza3 != null) {
            this.zzauF = new TurnBasedMatchBuffer(dataHolderZza3);
        } else {
            this.zzauF = null;
        }
        DataHolder dataHolderZza4 = zza(bundle, 3);
        this.zzauG = dataHolderZza4 != null ? new TurnBasedMatchBuffer(dataHolderZza4) : null;
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String strZzfG = TurnBasedMatchTurnStatus.zzfG(i);
        if (bundle.containsKey(strZzfG)) {
            return (DataHolder) bundle.getParcelable(strZzfG);
        }
        return null;
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzauG;
    }

    public InvitationBuffer getInvitations() {
        return this.zzauD;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzauE;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzauF;
    }

    public boolean hasData() {
        InvitationBuffer invitationBuffer = this.zzauD;
        if (invitationBuffer != null && invitationBuffer.getCount() > 0) {
            return true;
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer = this.zzauE;
        if (turnBasedMatchBuffer != null && turnBasedMatchBuffer.getCount() > 0) {
            return true;
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.zzauF;
        if (turnBasedMatchBuffer2 != null && turnBasedMatchBuffer2.getCount() > 0) {
            return true;
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.zzauG;
        return turnBasedMatchBuffer3 != null && turnBasedMatchBuffer3.getCount() > 0;
    }

    public void release() {
        InvitationBuffer invitationBuffer = this.zzauD;
        if (invitationBuffer != null) {
            invitationBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer = this.zzauE;
        if (turnBasedMatchBuffer != null) {
            turnBasedMatchBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.zzauF;
        if (turnBasedMatchBuffer2 != null) {
            turnBasedMatchBuffer2.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.zzauG;
        if (turnBasedMatchBuffer3 != null) {
            turnBasedMatchBuffer3.release();
        }
    }
}
