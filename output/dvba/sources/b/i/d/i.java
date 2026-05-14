package b.i.d;

import android.app.Notification;
import android.app.RemoteInput;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Notification.Builder f718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RemoteViews f720c;
    public RemoteViews d;
    public final List<Bundle> e = new ArrayList();
    public final Bundle f = new Bundle();
    public int g;
    public RemoteViews h;

    public i(g gVar) {
        this.f719b = gVar;
        Notification.Builder builder = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(gVar.f713a, gVar.o) : new Notification.Builder(gVar.f713a);
        this.f718a = builder;
        Notification notification = gVar.s;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(gVar.d).setContentText(gVar.e).setContentInfo(null).setContentIntent(gVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        this.f718a.setSubText(null).setUsesChronometer(false).setPriority(gVar.g);
        for (e eVar : gVar.f714b) {
            IconCompat iconCompatA = eVar.a();
            Notification.Action.Builder builder2 = Build.VERSION.SDK_INT >= 23 ? new Notification.Action.Builder(iconCompatA != null ? iconCompatA.f() : null, eVar.j, eVar.k) : new Notification.Action.Builder(iconCompatA != null ? iconCompatA.c() : 0, eVar.j, eVar.k);
            k[] kVarArr = eVar.f711c;
            if (kVarArr != null) {
                int length = kVarArr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                if (kVarArr.length > 0) {
                    k kVar = kVarArr[0];
                    throw null;
                }
                for (int i = 0; i < length; i++) {
                    builder2.addRemoteInput(remoteInputArr[i]);
                }
            }
            Bundle bundle = eVar.f709a != null ? new Bundle(eVar.f709a) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", eVar.e);
            if (Build.VERSION.SDK_INT >= 24) {
                builder2.setAllowGeneratedReplies(eVar.e);
            }
            bundle.putInt("android.support.action.semanticAction", eVar.g);
            if (Build.VERSION.SDK_INT >= 28) {
                builder2.setSemanticAction(eVar.g);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder2.setContextual(eVar.h);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", eVar.f);
            builder2.addExtras(bundle);
            this.f718a.addAction(builder2.build());
        }
        Bundle bundle2 = gVar.k;
        if (bundle2 != null) {
            this.f.putAll(bundle2);
        }
        this.f720c = null;
        this.d = null;
        this.f718a.setShowWhen(gVar.h);
        this.f718a.setLocalOnly(gVar.j).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.g = gVar.q;
        this.f718a.setCategory(null).setColor(gVar.l).setVisibility(gVar.m).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        Iterator<String> it = gVar.t.iterator();
        while (it.hasNext()) {
            this.f718a.addPerson(it.next());
        }
        this.h = null;
        if (gVar.f715c.size() > 0) {
            if (gVar.k == null) {
                gVar.k = new Bundle();
            }
            Bundle bundle3 = gVar.k.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle();
            for (int i2 = 0; i2 < gVar.f715c.size(); i2++) {
                bundle4.putBundle(Integer.toString(i2), j.a(gVar.f715c.get(i2)));
            }
            bundle3.putBundle("invisible_actions", bundle4);
            if (gVar.k == null) {
                gVar.k = new Bundle();
            }
            gVar.k.putBundle("android.car.EXTENSIONS", bundle3);
            this.f.putBundle("android.car.EXTENSIONS", bundle3);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f718a.setExtras(gVar.k).setRemoteInputHistory(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f718a.setBadgeIconType(gVar.p).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(gVar.q);
            if (!TextUtils.isEmpty(gVar.o)) {
                this.f718a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f718a.setAllowSystemGeneratedContextualActions(gVar.r);
            this.f718a.setBubbleMetadata(null);
        }
    }

    public final void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & (-2);
        notification.defaults = i;
        notification.defaults = i & (-3);
    }
}
