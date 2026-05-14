package b.b.k;

import android.view.View;
import android.widget.AbsListView;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: classes.dex */
public class d implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f247b;

    public d(AlertController alertController, View view, View view2) {
        this.f246a = view;
        this.f247b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlertController.c(absListView, this.f246a, this.f247b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
