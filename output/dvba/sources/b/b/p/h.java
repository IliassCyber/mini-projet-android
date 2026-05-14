package b.b.p;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes.dex */
public class h extends CheckedTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f427c = {R.attr.checkMark};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f428b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        u0.a(context);
        s0.a(this, getContext());
        y yVar = new y(this);
        this.f428b = yVar;
        yVar.e(attributeSet, R.attr.checkedTextViewStyle);
        this.f428b.b();
        x0 x0VarQ = x0.q(getContext(), attributeSet, f427c, R.attr.checkedTextViewStyle, 0);
        setCheckMarkDrawable(x0VarQ.g(0));
        x0VarQ.f507b.recycle();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        y yVar = this.f428b;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a.a.a.a.a.c0(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(b.b.l.a.a.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(a.a.a.a.a.D0(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.f428b;
        if (yVar != null) {
            yVar.f(context, i);
        }
    }
}
