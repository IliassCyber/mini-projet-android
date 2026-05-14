package b.b.p;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextClassifier f505b;

    public x(TextView textView) {
        this.f504a = textView;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f505b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f504a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }
}
