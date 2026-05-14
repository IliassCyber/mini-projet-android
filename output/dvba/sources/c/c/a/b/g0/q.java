package c.c.a.b.g0;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public class q extends n {
    public final TextWatcher d;
    public final TextInputLayout.f e;
    public final TextInputLayout.g f;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            q.this.f1613c.setChecked(!q.d(r1));
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
            textInputLayout.setEndIconVisible(true);
            q.this.f1613c.setChecked(!q.d(r4));
            editText.removeTextChangedListener(q.this.d);
            editText.addTextChangedListener(q.this.d);
        }
    }

    public class c implements TextInputLayout.g {
        public c(q qVar) {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = q.this.f1611a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            editText.setTransformationMethod(q.d(q.this) ? null : PasswordTransformationMethod.getInstance());
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
        }
    }

    public q(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new a();
        this.e = new b();
        this.f = new c(this);
    }

    public static boolean d(q qVar) {
        EditText editText = qVar.f1611a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // c.c.a.b.g0.n
    public void a() {
        this.f1611a.setEndIconDrawable(b.b.l.a.a.b(this.f1612b, c.c.a.b.e.design_password_eye));
        TextInputLayout textInputLayout = this.f1611a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(c.c.a.b.i.password_toggle_content_description));
        this.f1611a.setEndIconOnClickListener(new d());
        this.f1611a.a(this.e);
        TextInputLayout textInputLayout2 = this.f1611a;
        textInputLayout2.R.add(this.f);
    }
}
