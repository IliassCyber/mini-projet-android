package c.c.a.b.g0;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public class a extends n {
    public final TextWatcher d;
    public final TextInputLayout.f e;
    public AnimatorSet f;
    public ValueAnimator g;

    /* JADX INFO: renamed from: c.c.a.b.g0.a$a, reason: collision with other inner class name */
    public class C0060a implements TextWatcher {
        public C0060a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!(editable.length() > 0)) {
                a.this.f.cancel();
                a.this.g.start();
            } else {
                if (a.this.f1611a.j()) {
                    return;
                }
                a.this.g.cancel();
                a.this.f.start();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements TextInputLayout.f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.getText().length() > 0);
            textInputLayout.setEndIconCheckable(false);
            editText.removeTextChangedListener(a.this.d);
            editText.addTextChangedListener(a.this.d);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f1611a.getEditText().setText((CharSequence) null);
        }
    }

    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new C0060a();
        this.e = new b();
    }

    @Override // c.c.a.b.g0.n
    public void a() {
        this.f1611a.setEndIconDrawable(b.b.l.a.a.b(this.f1612b, c.c.a.b.e.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f1611a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(c.c.a.b.i.clear_text_end_icon_content_description));
        this.f1611a.setEndIconOnClickListener(new c());
        this.f1611a.a(this.e);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(c.c.a.b.l.a.d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new e(this));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(c.c.a.b.l.a.f1627a);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f.addListener(new c.c.a.b.g0.b(this));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(c.c.a.b.l.a.f1627a);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new d(this));
        this.g = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new c.c.a.b.g0.c(this));
    }
}
