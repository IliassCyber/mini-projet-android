package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzlc;

/* JADX INFO: loaded from: classes.dex */
public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
    private final int zzCY;
    private final int zzQT;
    private final String zzadI;
    private final Uri zzanf;
    private final Uri zzang;
    private final String zzanq;
    private final String zzanr;
    private final String zzaoO;
    private final PlayerEntity zzaog;
    private final String zzapO;
    private final boolean zzaul;
    private final ParticipantResult zzaum;
    private final int zzwS;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        @Override // com.google.android.gms.games.multiplayer.ParticipantEntityCreator, android.os.Parcelable.Creator
        /* JADX INFO: renamed from: zzdJ, reason: merged with bridge method [inline-methods] */
        public ParticipantEntity createFromParcel(Parcel parcel) {
            if (ParticipantEntity.zzd(ParticipantEntity.zznE()) || ParticipantEntity.zzca(ParticipantEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Uri uri = string3 == null ? null : Uri.parse(string3);
            String string4 = parcel.readString();
            return new ParticipantEntity(3, string, string2, uri, string4 == null ? null : Uri.parse(string4), parcel.readInt(), parcel.readString(), parcel.readInt() > 0, parcel.readInt() > 0 ? PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    ParticipantEntity(int i, String str, String str2, Uri uri, Uri uri2, int i2, String str3, boolean z, PlayerEntity playerEntity, int i3, ParticipantResult participantResult, String str4, String str5) {
        this.zzCY = i;
        this.zzapO = str;
        this.zzadI = str2;
        this.zzanf = uri;
        this.zzang = uri2;
        this.zzwS = i2;
        this.zzaoO = str3;
        this.zzaul = z;
        this.zzaog = playerEntity;
        this.zzQT = i3;
        this.zzaum = participantResult;
        this.zzanq = str4;
        this.zzanr = str5;
    }

    public ParticipantEntity(Participant participant) {
        this.zzCY = 3;
        this.zzapO = participant.getParticipantId();
        this.zzadI = participant.getDisplayName();
        this.zzanf = participant.getIconImageUri();
        this.zzang = participant.getHiResImageUri();
        this.zzwS = participant.getStatus();
        this.zzaoO = participant.zzsr();
        this.zzaul = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.zzaog = player == null ? null : new PlayerEntity(player);
        this.zzQT = participant.getCapabilities();
        this.zzaum = participant.getResult();
        this.zzanq = participant.getIconImageUrl();
        this.zzanr = participant.getHiResImageUrl();
    }

    static int zza(Participant participant) {
        return zzt.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzsr(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return zzt.equal(participant2.getPlayer(), participant.getPlayer()) && zzt.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && zzt.equal(participant2.zzsr(), participant.zzsr()) && zzt.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && zzt.equal(participant2.getDisplayName(), participant.getDisplayName()) && zzt.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && zzt.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && zzt.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && zzt.equal(participant2.getResult(), participant.getResult()) && zzt.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String zzb(Participant participant) {
        return zzt.zzt(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zzsr()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public Participant freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public int getCapabilities() {
        return this.zzQT;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String getDisplayName() {
        PlayerEntity playerEntity = this.zzaog;
        return playerEntity == null ? this.zzadI : playerEntity.getDisplayName();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.zzaog;
        if (playerEntity == null) {
            zzlc.zzb(this.zzadI, charArrayBuffer);
        } else {
            playerEntity.getDisplayName(charArrayBuffer);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri getHiResImageUri() {
        PlayerEntity playerEntity = this.zzaog;
        return playerEntity == null ? this.zzang : playerEntity.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String getHiResImageUrl() {
        PlayerEntity playerEntity = this.zzaog;
        return playerEntity == null ? this.zzanr : playerEntity.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri getIconImageUri() {
        PlayerEntity playerEntity = this.zzaog;
        return playerEntity == null ? this.zzanf : playerEntity.getIconImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String getIconImageUrl() {
        PlayerEntity playerEntity = this.zzaog;
        return playerEntity == null ? this.zzanq : playerEntity.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String getParticipantId() {
        return this.zzapO;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Player getPlayer() {
        return this.zzaog;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public ParticipantResult getResult() {
        return this.zzaum;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public int getStatus() {
        return this.zzwS;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public boolean isConnectedToRoom() {
        return this.zzaul;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (!zznF()) {
            ParticipantEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(this.zzapO);
        parcel.writeString(this.zzadI);
        Uri uri = this.zzanf;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzang;
        parcel.writeString(uri2 != null ? uri2.toString() : null);
        parcel.writeInt(this.zzwS);
        parcel.writeString(this.zzaoO);
        parcel.writeInt(this.zzaul ? 1 : 0);
        parcel.writeInt(this.zzaog == null ? 0 : 1);
        PlayerEntity playerEntity = this.zzaog;
        if (playerEntity != null) {
            playerEntity.writeToParcel(parcel, i);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String zzsr() {
        return this.zzaoO;
    }
}
