package b.b.k;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f245c;
    public final /* synthetic */ AlertController d;

    public c(AlertController alertController, View view, View view2) {
        this.d = alertController;
        this.f244b = view;
        this.f245c = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.c(this.d.A, this.f244b, this.f245c);
    }
}
