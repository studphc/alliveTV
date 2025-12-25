package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: f */
    public static Configuration f784f;

    /* renamed from: a */
    public int f785a;

    /* renamed from: b */
    public Resources.Theme f786b;

    /* renamed from: c */
    public LayoutInflater f787c;

    /* renamed from: d */
    public Configuration f788d;

    /* renamed from: e */
    public Resources f789e;

    public ContextThemeWrapper() {
        super(null);
    }

    /* renamed from: a */
    public final void m205a() {
        boolean z;
        if (this.f786b == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f786b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f786b.setTo(theme);
            }
        }
        onApplyThemeResource(this.f786b, this.f785a, z);
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.f789e == null) {
            if (this.f788d == null) {
                this.f788d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r0.equals(androidx.appcompat.view.ContextThemeWrapper.f784f) != false) goto L15;
     */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Resources getResources() {
        if (this.f789e == null) {
            Configuration configuration = this.f788d;
            if (configuration != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    if (f784f == null) {
                        Configuration configuration2 = new Configuration();
                        configuration2.fontScale = RecyclerView.f7068F0;
                        f784f = configuration2;
                    }
                }
                this.f789e = createConfigurationContext(this.f788d).getResources();
            }
            this.f789e = super.getResources();
        }
        return this.f789e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f787c == null) {
                this.f787c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f787c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f786b;
        if (theme != null) {
            return theme;
        }
        if (this.f785a == 0) {
            this.f785a = R.style.Theme_AppCompat_Light;
        }
        m205a();
        return this.f786b;
    }

    public int getThemeResId() {
        return this.f785a;
    }

    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f785a != i) {
            this.f785a = i;
            m205a();
        }
    }

    public ContextThemeWrapper(Context context, @StyleRes int i) {
        super(context);
        this.f785a = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f786b = theme;
    }
}
