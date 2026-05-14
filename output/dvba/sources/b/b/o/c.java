package b.b.o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import b.b.i;

/* JADX INFO: loaded from: classes.dex */
public class c extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f321c;
    public Configuration d;
    public Resources e;

    public c() {
        super(null);
    }

    public c(Context context, int i) {
        super(context);
        this.f319a = i;
    }

    public void a(Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f320b == null) {
            this.f320b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f320b.setTo(theme);
            }
        }
        this.f320b.applyStyle(this.f319a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.e == null) {
            Configuration configuration = this.d;
            this.e = configuration == null ? super.getResources() : createConfigurationContext(configuration).getResources();
        }
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f321c == null) {
            this.f321c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f321c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f320b;
        if (theme != null) {
            return theme;
        }
        if (this.f319a == 0) {
            this.f319a = i.Theme_AppCompat_Light;
        }
        b();
        return this.f320b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f319a != i) {
            this.f319a = i;
            b();
        }
    }
}
