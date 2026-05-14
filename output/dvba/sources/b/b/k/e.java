package b.b.k;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f249c;
    public final /* synthetic */ AlertController d;

    public e(AlertController alertController, View view, View view2) {
        this.d = alertController;
        this.f248b = view;
        this.f249c = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.c(this.d.g, this.f248b, this.f249c);
    }
}
