package b.b.k;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertController f250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AlertController.b f251c;

    public f(AlertController.b bVar, AlertController alertController) {
        this.f251c = bVar;
        this.f250b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f251c.r.onClick(this.f250b.f44b, i);
        if (this.f251c.v) {
            return;
        }
        this.f250b.f44b.dismiss();
    }
}
