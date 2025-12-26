package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Locale;
import p000.AbstractC0549b9;
import p000.AbstractC1187f9;
import p000.AbstractC2011y8;
import p000.AbstractC2048z8;
import p000.C0585c9;
import p000.C1114d9;
import p000.C1224g9;
import p000.C1261h9;
import p000.C1789s8;
import p000.C1900v8;
import p000.C1937w8;
import p000.C1974x8;
import p000.RunnableC1104d;
import p000.RunnableC1613o8;
import p000.RunnableC1863u8;
import p000.b01;
import p000.jz2;
import p000.o63;

/* renamed from: androidx.appcompat.app.e */
/* loaded from: classes.dex */
public final class LayoutInflaterFactory2C0084e extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* renamed from: i0 */
    public static final SimpleArrayMap f683i0 = new SimpleArrayMap();

    /* renamed from: j0 */
    public static final int[] f684j0 = {R.attr.windowBackground};

    /* renamed from: k0 */
    public static final boolean f685k0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: A */
    public boolean f686A;

    /* renamed from: B */
    public ViewGroup f687B;

    /* renamed from: C */
    public TextView f688C;

    /* renamed from: D */
    public View f689D;

    /* renamed from: E */
    public boolean f690E;

    /* renamed from: F */
    public boolean f691F;

    /* renamed from: G */
    public boolean f692G;

    /* renamed from: H */
    public boolean f693H;

    /* renamed from: I */
    public boolean f694I;

    /* renamed from: J */
    public boolean f695J;

    /* renamed from: K */
    public boolean f696K;

    /* renamed from: L */
    public boolean f697L;

    /* renamed from: M */
    public AppCompatDelegateImpl$PanelFeatureState[] f698M;

    /* renamed from: N */
    public AppCompatDelegateImpl$PanelFeatureState f699N;

    /* renamed from: O */
    public boolean f700O;

    /* renamed from: P */
    public boolean f701P;

    /* renamed from: Q */
    public boolean f702Q;

    /* renamed from: R */
    public boolean f703R;

    /* renamed from: S */
    public Configuration f704S;

    /* renamed from: T */
    public int f705T;

    /* renamed from: U */
    public int f706U;

    /* renamed from: V */
    public int f707V;

    /* renamed from: W */
    public boolean f708W;

    /* renamed from: X */
    public C1114d9 f709X;

    /* renamed from: Y */
    public C1114d9 f710Y;

    /* renamed from: Z */
    public boolean f711Z;

    /* renamed from: a0 */
    public int f712a0;

    /* renamed from: c0 */
    public boolean f714c0;

    /* renamed from: d0 */
    public Rect f715d0;

    /* renamed from: e0 */
    public Rect f716e0;

    /* renamed from: f0 */
    public AppCompatViewInflater f717f0;

    /* renamed from: g0 */
    public OnBackInvokedDispatcher f718g0;

    /* renamed from: h0 */
    public OnBackInvokedCallback f719h0;

    /* renamed from: j */
    public final Object f720j;

    /* renamed from: k */
    public final Context f721k;

    /* renamed from: l */
    public Window f722l;

    /* renamed from: m */
    public C0585c9 f723m;

    /* renamed from: n */
    public final AppCompatCallback f724n;

    /* renamed from: o */
    public ActionBar f725o;

    /* renamed from: p */
    public SupportMenuInflater f726p;

    /* renamed from: q */
    public CharSequence f727q;

    /* renamed from: r */
    public DecorContentParent f728r;

    /* renamed from: s */
    public C1937w8 f729s;

    /* renamed from: t */
    public C1261h9 f730t;

    /* renamed from: u */
    public ActionMode f731u;

    /* renamed from: v */
    public ActionBarContextView f732v;

    /* renamed from: w */
    public PopupWindow f733w;

    /* renamed from: x */
    public RunnableC1863u8 f734x;

    /* renamed from: y */
    public ViewPropertyAnimatorCompat f735y = null;

    /* renamed from: z */
    public boolean f736z = true;

    /* renamed from: b0 */
    public final RunnableC1104d f713b0 = new RunnableC1104d(4, this);

    public LayoutInflaterFactory2C0084e(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity appCompatActivity = null;
        this.f705T = -100;
        this.f721k = context;
        this.f724n = appCompatCallback;
        this.f720j = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (context instanceof AppCompatActivity) {
                        appCompatActivity = (AppCompatActivity) context;
                        break;
                    } else if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.f705T = appCompatActivity.getDelegate().getLocalNightMode();
            }
        }
        if (this.f705T == -100) {
            SimpleArrayMap simpleArrayMap = f683i0;
            Integer num = (Integer) simpleArrayMap.get(this.f720j.getClass().getName());
            if (num != null) {
                this.f705T = num.intValue();
                simpleArrayMap.remove(this.f720j.getClass().getName());
            }
        }
        if (window != null) {
            m180g(window);
        }
        AppCompatDrawableManager.preload();
    }

    /* renamed from: h */
    public static LocaleListCompat m174h(Context context) {
        LocaleListCompat localeListCompat;
        LocaleListCompat forLanguageTags;
        Locale locale;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || (localeListCompat = AppCompatDelegate.f596c) == null) {
            return null;
        }
        LocaleListCompat m176s = m176s(context.getApplicationContext().getResources().getConfiguration());
        if (i >= 24) {
            if (localeListCompat.isEmpty()) {
                forLanguageTags = LocaleListCompat.getEmptyLocaleList();
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (int i2 = 0; i2 < m176s.size() + localeListCompat.size(); i2++) {
                    if (i2 < localeListCompat.size()) {
                        locale = localeListCompat.get(i2);
                    } else {
                        locale = m176s.get(i2 - localeListCompat.size());
                    }
                    if (locale != null) {
                        linkedHashSet.add(locale);
                    }
                }
                forLanguageTags = LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
            }
        } else if (localeListCompat.isEmpty()) {
            forLanguageTags = LocaleListCompat.getEmptyLocaleList();
        } else {
            forLanguageTags = LocaleListCompat.forLanguageTags(AbstractC2011y8.m8256b(localeListCompat.get(0)));
        }
        if (!forLanguageTags.isEmpty()) {
            return forLanguageTags;
        }
        return m176s;
    }

    /* renamed from: l */
    public static Configuration m175l(Context context, int i, LocaleListCompat localeListCompat, Configuration configuration, boolean z) {
        int i2;
        if (i != 1) {
            if (i != 2) {
                if (z) {
                    i2 = 0;
                } else {
                    i2 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                }
            } else {
                i2 = 32;
            }
        } else {
            i2 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = RecyclerView.f7068F0;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (localeListCompat != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                AbstractC2048z8.m8402d(configuration2, localeListCompat);
            } else {
                configuration2.setLocale(localeListCompat.get(0));
                configuration2.setLayoutDirection(localeListCompat.get(0));
            }
        }
        return configuration2;
    }

    /* renamed from: s */
    public static LocaleListCompat m176s(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AbstractC2048z8.m8400b(configuration);
        }
        return LocaleListCompat.forLanguageTags(AbstractC2011y8.m8256b(configuration.locale));
    }

    /* renamed from: A */
    public final void m177A() {
        if (!this.f686A) {
        } else {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: B */
    public final void m178B() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.f718g0 != null && (m190t(0).f615m || this.f731u != null)) {
                z = true;
            }
            if (z && this.f719h0 == null) {
                this.f719h0 = AbstractC0549b9.m2065b(this.f718g0, this);
            } else if (!z && (onBackInvokedCallback = this.f719h0) != null) {
                AbstractC0549b9.m2066c(this.f718g0, onBackInvokedCallback);
                this.f719h0 = null;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: a */
    public final void mo163a() {
        LocaleListCompat localeListCompat;
        Context context = this.f721k;
        if (AppCompatDelegate.m160c(context) && (localeListCompat = AppCompatDelegate.f596c) != null && !localeListCompat.equals(AppCompatDelegate.f597d)) {
            AppCompatDelegate.f594a.execute(new RunnableC1613o8(context, 1));
        }
        m179f(true, true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m186o();
        ((ViewGroup) this.f687B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f723m.m2209a(this.f722l.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean applyDayNight() {
        return m179f(true, true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final Context attachBaseContext2(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        this.f701P = true;
        int i9 = this.f705T;
        if (i9 == -100) {
            i9 = AppCompatDelegate.getDefaultNightMode();
        }
        int m192v = m192v(i9, context);
        if (AppCompatDelegate.m160c(context)) {
            AppCompatDelegate.m162e(context);
        }
        LocaleListCompat m174h = m174h(context);
        Configuration configuration = null;
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(m175l(context, m192v, m174h, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).applyOverrideConfiguration(m175l(context, m192v, m174h, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f685k0) {
            return super.attachBaseContext2(context);
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = RecyclerView.f7068F0;
        Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = new Configuration();
            configuration.fontScale = RecyclerView.f7068F0;
            if (configuration3.diff(configuration4) != 0) {
                float f = configuration3.fontScale;
                float f2 = configuration4.fontScale;
                if (f != f2) {
                    configuration.fontScale = f2;
                }
                int i10 = configuration3.mcc;
                int i11 = configuration4.mcc;
                if (i10 != i11) {
                    configuration.mcc = i11;
                }
                int i12 = configuration3.mnc;
                int i13 = configuration4.mnc;
                if (i12 != i13) {
                    configuration.mnc = i13;
                }
                int i14 = Build.VERSION.SDK_INT;
                if (i14 >= 24) {
                    AbstractC2048z8.m8399a(configuration3, configuration4, configuration);
                } else if (!ObjectsCompat.equals(configuration3.locale, configuration4.locale)) {
                    configuration.locale = configuration4.locale;
                }
                int i15 = configuration3.touchscreen;
                int i16 = configuration4.touchscreen;
                if (i15 != i16) {
                    configuration.touchscreen = i16;
                }
                int i17 = configuration3.keyboard;
                int i18 = configuration4.keyboard;
                if (i17 != i18) {
                    configuration.keyboard = i18;
                }
                int i19 = configuration3.keyboardHidden;
                int i20 = configuration4.keyboardHidden;
                if (i19 != i20) {
                    configuration.keyboardHidden = i20;
                }
                int i21 = configuration3.navigation;
                int i22 = configuration4.navigation;
                if (i21 != i22) {
                    configuration.navigation = i22;
                }
                int i23 = configuration3.navigationHidden;
                int i24 = configuration4.navigationHidden;
                if (i23 != i24) {
                    configuration.navigationHidden = i24;
                }
                int i25 = configuration3.orientation;
                int i26 = configuration4.orientation;
                if (i25 != i26) {
                    configuration.orientation = i26;
                }
                int i27 = configuration3.screenLayout & 15;
                int i28 = configuration4.screenLayout & 15;
                if (i27 != i28) {
                    configuration.screenLayout |= i28;
                }
                int i29 = configuration3.screenLayout & PsExtractor.AUDIO_STREAM;
                int i30 = configuration4.screenLayout & PsExtractor.AUDIO_STREAM;
                if (i29 != i30) {
                    configuration.screenLayout |= i30;
                }
                int i31 = configuration3.screenLayout & 48;
                int i32 = configuration4.screenLayout & 48;
                if (i31 != i32) {
                    configuration.screenLayout |= i32;
                }
                int i33 = configuration3.screenLayout & 768;
                int i34 = configuration4.screenLayout & 768;
                if (i33 != i34) {
                    configuration.screenLayout |= i34;
                }
                if (i14 >= 26) {
                    i = configuration3.colorMode;
                    int i35 = i & 3;
                    i2 = configuration4.colorMode;
                    if (i35 != (i2 & 3)) {
                        i7 = configuration.colorMode;
                        i8 = configuration4.colorMode;
                        configuration.colorMode = i7 | (i8 & 3);
                    }
                    i3 = configuration3.colorMode;
                    int i36 = i3 & 12;
                    i4 = configuration4.colorMode;
                    if (i36 != (i4 & 12)) {
                        i5 = configuration.colorMode;
                        i6 = configuration4.colorMode;
                        configuration.colorMode = i5 | (i6 & 12);
                    }
                }
                int i37 = configuration3.uiMode & 15;
                int i38 = configuration4.uiMode & 15;
                if (i37 != i38) {
                    configuration.uiMode |= i38;
                }
                int i39 = configuration3.uiMode & 48;
                int i40 = configuration4.uiMode & 48;
                if (i39 != i40) {
                    configuration.uiMode |= i40;
                }
                int i41 = configuration3.screenWidthDp;
                int i42 = configuration4.screenWidthDp;
                if (i41 != i42) {
                    configuration.screenWidthDp = i42;
                }
                int i43 = configuration3.screenHeightDp;
                int i44 = configuration4.screenHeightDp;
                if (i43 != i44) {
                    configuration.screenHeightDp = i44;
                }
                int i45 = configuration3.smallestScreenWidthDp;
                int i46 = configuration4.smallestScreenWidthDp;
                if (i45 != i46) {
                    configuration.smallestScreenWidthDp = i46;
                }
                int i47 = configuration3.densityDpi;
                int i48 = configuration4.densityDpi;
                if (i47 != i48) {
                    configuration.densityDpi = i48;
                }
            }
        }
        Configuration m175l = m175l(context, m192v, m174h, configuration, true);
        androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, androidx.appcompat.R.style.Theme_AppCompat_Empty);
        contextThemeWrapper.applyOverrideConfiguration(m175l);
        try {
            if (context.getTheme() != null) {
                ResourcesCompat.ThemeCompat.rebase(contextThemeWrapper.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.attachBaseContext2(contextThemeWrapper);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final View createView(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.f717f0 == null) {
            int[] iArr = androidx.appcompat.R.styleable.AppCompatTheme;
            Context context2 = this.f721k;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            String string = obtainStyledAttributes.getString(androidx.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            obtainStyledAttributes.recycle();
            if (string == null) {
                this.f717f0 = new AppCompatViewInflater();
            } else {
                try {
                    this.f717f0 = (AppCompatViewInflater) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f717f0 = new AppCompatViewInflater();
                }
            }
        }
        return this.f717f0.createView(view, str, context, attributeSet, false, false, true, VectorEnabledTintResources.shouldBeUsed());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a3  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m179f(boolean z, boolean z2) {
        LocaleListCompat localeListCompat;
        int i;
        Configuration configuration;
        int i2;
        int i3;
        LocaleListCompat m176s;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Object obj;
        Object obj2;
        Object obj3;
        Activity activity;
        int i5;
        if (this.f703R) {
            return false;
        }
        int i6 = this.f705T;
        if (i6 == -100) {
            i6 = AppCompatDelegate.getDefaultNightMode();
        }
        int i7 = i6;
        Context context = this.f721k;
        int m192v = m192v(i7, context);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 33) {
            localeListCompat = m174h(context);
        } else {
            localeListCompat = null;
        }
        if (!z2 && localeListCompat != null) {
            localeListCompat = m176s(context.getResources().getConfiguration());
        }
        Configuration m175l = m175l(context, m192v, localeListCompat, null, false);
        boolean z7 = this.f708W;
        Object obj4 = this.f720j;
        if (!z7 && (obj4 instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i = 0;
                configuration = this.f704S;
                if (configuration == null) {
                    configuration = context.getResources().getConfiguration();
                }
                i2 = configuration.uiMode & 48;
                i3 = m175l.uiMode & 48;
                LocaleListCompat m176s2 = m176s(configuration);
                if (localeListCompat != null) {
                    m176s = null;
                } else {
                    m176s = m176s(m175l);
                }
                if (i2 == i3) {
                    i4 = 512;
                } else {
                    i4 = 0;
                }
                if (m176s != null && !m176s2.equals(m176s)) {
                    i4 |= 8196;
                }
                if (((~i) & i4) != 0 && z && this.f701P && ((f685k0 || this.f702Q) && (obj4 instanceof Activity))) {
                    activity = (Activity) obj4;
                    if (!activity.isChild()) {
                        if (Build.VERSION.SDK_INT >= 31 && (i4 & 8192) != 0) {
                            activity.getWindow().getDecorView().setLayoutDirection(m175l.getLayoutDirection());
                        }
                        ActivityCompat.recreate(activity);
                        z3 = true;
                        if (z3 && i4 != 0) {
                            if ((i & i4) == i4) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            Resources resources = context.getResources();
                            Configuration configuration2 = new Configuration(resources.getConfiguration());
                            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i3;
                            if (m176s != null) {
                                if (Build.VERSION.SDK_INT >= 24) {
                                    AbstractC2048z8.m8402d(configuration2, m176s);
                                } else {
                                    configuration2.setLocale(m176s.get(0));
                                    configuration2.setLayoutDirection(m176s.get(0));
                                }
                            }
                            resources.updateConfiguration(configuration2, null);
                            int i9 = Build.VERSION.SDK_INT;
                            if (i9 < 26 && i9 < 28) {
                                if (i9 >= 24) {
                                    if (!o63.f23638t) {
                                        try {
                                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                                            o63.f23637s = declaredField;
                                            declaredField.setAccessible(true);
                                        } catch (NoSuchFieldException e) {
                                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
                                        }
                                        o63.f23638t = true;
                                    }
                                    Field field = o63.f23637s;
                                    if (field != null) {
                                        try {
                                            obj2 = field.get(resources);
                                        } catch (IllegalAccessException e2) {
                                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
                                            obj2 = null;
                                        }
                                        if (obj2 != null) {
                                            if (!o63.f23632n) {
                                                try {
                                                    Field declaredField2 = obj2.getClass().getDeclaredField("mDrawableCache");
                                                    o63.f23631m = declaredField2;
                                                    declaredField2.setAccessible(true);
                                                } catch (NoSuchFieldException e3) {
                                                    Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
                                                }
                                                o63.f23632n = true;
                                            }
                                            Field field2 = o63.f23631m;
                                            if (field2 != null) {
                                                try {
                                                    obj3 = field2.get(obj2);
                                                } catch (IllegalAccessException e4) {
                                                    Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                                                }
                                                if (obj3 != null) {
                                                    o63.m6470m(obj3);
                                                }
                                            }
                                            obj3 = null;
                                            if (obj3 != null) {
                                            }
                                        }
                                    }
                                } else {
                                    if (!o63.f23632n) {
                                        try {
                                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                                            o63.f23631m = declaredField3;
                                            declaredField3.setAccessible(true);
                                        } catch (NoSuchFieldException e5) {
                                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e5);
                                        }
                                        o63.f23632n = true;
                                    }
                                    Field field3 = o63.f23631m;
                                    if (field3 != null) {
                                        try {
                                            obj = field3.get(resources);
                                        } catch (IllegalAccessException e6) {
                                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e6);
                                        }
                                        if (obj != null) {
                                            o63.m6470m(obj);
                                        }
                                    }
                                    obj = null;
                                    if (obj != null) {
                                    }
                                }
                            }
                            int i10 = this.f706U;
                            if (i10 != 0) {
                                context.setTheme(i10);
                                z6 = true;
                                context.getTheme().applyStyle(this.f706U, true);
                            } else {
                                z6 = true;
                            }
                            if (z5 && (obj4 instanceof Activity)) {
                                Activity activity2 = (Activity) obj4;
                                if (activity2 instanceof LifecycleOwner) {
                                    if (((LifecycleOwner) activity2).getLifecycle().getF6494d().isAtLeast(Lifecycle.State.CREATED)) {
                                        activity2.onConfigurationChanged(configuration2);
                                    }
                                } else if (this.f702Q && !this.f703R) {
                                    activity2.onConfigurationChanged(configuration2);
                                }
                            }
                            z4 = z6;
                        } else {
                            z4 = z3;
                        }
                        if (z4 && (obj4 instanceof AppCompatActivity)) {
                            if ((i4 & 512) != 0) {
                                ((AppCompatActivity) obj4).onNightModeChanged(m192v);
                            }
                            if ((i4 & 4) != 0) {
                                ((AppCompatActivity) obj4).onLocalesChanged(localeListCompat);
                            }
                        }
                        if (m176s != null) {
                            LocaleListCompat m176s3 = m176s(context.getResources().getConfiguration());
                            if (Build.VERSION.SDK_INT >= 24) {
                                AbstractC2048z8.m8401c(m176s3);
                            } else {
                                Locale.setDefault(m176s3.get(0));
                            }
                        }
                        if (i7 == 0) {
                            m189r(context).m4780e();
                        } else {
                            C1114d9 c1114d9 = this.f709X;
                            if (c1114d9 != null) {
                                c1114d9.m4779a();
                            }
                        }
                        if (i7 == 3) {
                            if (this.f710Y == null) {
                                this.f710Y = new C1114d9(this, context);
                            }
                            this.f710Y.m4780e();
                        } else {
                            C1114d9 c1114d92 = this.f710Y;
                            if (c1114d92 != null) {
                                c1114d92.m4779a();
                            }
                        }
                        return z4;
                    }
                }
                z3 = false;
                if (z3) {
                }
                z4 = z3;
                if (z4) {
                    if ((i4 & 512) != 0) {
                    }
                    if ((i4 & 4) != 0) {
                    }
                }
                if (m176s != null) {
                }
                if (i7 == 0) {
                }
                if (i7 == 3) {
                }
                return z4;
            }
            if (i8 >= 29) {
                i5 = 269221888;
            } else if (i8 >= 24) {
                i5 = 786432;
            } else {
                i5 = 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj4.getClass()), i5);
                if (activityInfo != null) {
                    this.f707V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e7) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e7);
                this.f707V = 0;
            }
        }
        this.f708W = true;
        i = this.f707V;
        configuration = this.f704S;
        if (configuration == null) {
        }
        i2 = configuration.uiMode & 48;
        i3 = m175l.uiMode & 48;
        LocaleListCompat m176s22 = m176s(configuration);
        if (localeListCompat != null) {
        }
        if (i2 == i3) {
        }
        if (m176s != null) {
            i4 |= 8196;
        }
        if (((~i) & i4) != 0) {
            activity = (Activity) obj4;
            if (!activity.isChild()) {
            }
        }
        z3 = false;
        if (z3) {
        }
        z4 = z3;
        if (z4) {
        }
        if (m176s != null) {
        }
        if (i7 == 0) {
        }
        if (i7 == 3) {
        }
        return z4;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final View findViewById(int i) {
        m186o();
        return this.f722l.findViewById(i);
    }

    /* renamed from: g */
    public final void m180g(Window window) {
        if (this.f722l == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof C0585c9)) {
                C0585c9 c0585c9 = new C0585c9(this, callback);
                this.f723m = c0585c9;
                window.setCallback(c0585c9);
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f721k, (AttributeSet) null, f684j0);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    window.setBackgroundDrawable(drawableIfKnown);
                }
                obtainStyledAttributes.recycle();
                this.f722l = window;
                if (Build.VERSION.SDK_INT >= 33 && this.f718g0 == null) {
                    setOnBackInvokedDispatcher(null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final Context getContextForDelegate() {
        return this.f721k;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new C0082c(this);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final int getLocalNightMode() {
        return this.f705T;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final MenuInflater getMenuInflater() {
        Context context;
        if (this.f726p == null) {
            m191u();
            ActionBar actionBar = this.f725o;
            if (actionBar != null) {
                context = actionBar.getThemedContext();
            } else {
                context = this.f721k;
            }
            this.f726p = new SupportMenuInflater(context);
        }
        return this.f726p;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBar getSupportActionBar() {
        m191u();
        return this.f725o;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean hasWindowFeature(int i) {
        int i2;
        boolean z;
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i2 = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i2 = 109;
        } else {
            i2 = i;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 5) {
                    if (i2 != 10) {
                        if (i2 != 108) {
                            if (i2 != 109) {
                                z = false;
                            } else {
                                z = this.f693H;
                            }
                        } else {
                            z = this.f692G;
                        }
                    } else {
                        z = this.f694I;
                    }
                } else {
                    z = this.f691F;
                }
            } else {
                z = this.f690E;
            }
        } else {
            z = this.f696K;
        }
        if (z || this.f722l.hasFeature(i)) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public final void m181i(int i, AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            if (appCompatDelegateImpl$PanelFeatureState == null && i >= 0) {
                AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArr = this.f698M;
                if (i < appCompatDelegateImpl$PanelFeatureStateArr.length) {
                    appCompatDelegateImpl$PanelFeatureState = appCompatDelegateImpl$PanelFeatureStateArr[i];
                }
            }
            if (appCompatDelegateImpl$PanelFeatureState != null) {
                menuBuilder = appCompatDelegateImpl$PanelFeatureState.f610h;
            }
        }
        if ((appCompatDelegateImpl$PanelFeatureState == null || appCompatDelegateImpl$PanelFeatureState.f615m) && !this.f703R) {
            C0585c9 c0585c9 = this.f723m;
            Window.Callback callback = this.f722l.getCallback();
            c0585c9.getClass();
            try {
                c0585c9.f8291e = true;
                callback.onPanelClosed(i, menuBuilder);
            } finally {
                c0585c9.f8291e = false;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.f721k);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else if (!(from.getFactory2() instanceof LayoutInflaterFactory2C0084e)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void invalidateOptionsMenu() {
        if (this.f725o != null) {
            m191u();
            if (!this.f725o.invalidateOptionsMenu()) {
                this.f712a0 |= 1;
                if (!this.f711Z) {
                    ViewCompat.postOnAnimation(this.f722l.getDecorView(), this.f713b0);
                    this.f711Z = true;
                }
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean isHandleNativeActionModesEnabled() {
        return this.f736z;
    }

    /* renamed from: j */
    public final void m182j(MenuBuilder menuBuilder) {
        if (this.f697L) {
            return;
        }
        this.f697L = true;
        this.f728r.dismissPopups();
        Window.Callback callback = this.f722l.getCallback();
        if (callback != null && !this.f703R) {
            callback.onPanelClosed(108, menuBuilder);
        }
        this.f697L = false;
    }

    /* renamed from: k */
    public final void m183k(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, boolean z) {
        C1224g9 c1224g9;
        DecorContentParent decorContentParent;
        if (z && appCompatDelegateImpl$PanelFeatureState.f603a == 0 && (decorContentParent = this.f728r) != null && decorContentParent.isOverflowMenuShowing()) {
            m182j(appCompatDelegateImpl$PanelFeatureState.f610h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f721k.getSystemService("window");
        if (windowManager != null && appCompatDelegateImpl$PanelFeatureState.f615m && (c1224g9 = appCompatDelegateImpl$PanelFeatureState.f607e) != null) {
            windowManager.removeView(c1224g9);
            if (z) {
                m181i(appCompatDelegateImpl$PanelFeatureState.f603a, appCompatDelegateImpl$PanelFeatureState, null);
            }
        }
        appCompatDelegateImpl$PanelFeatureState.f613k = false;
        appCompatDelegateImpl$PanelFeatureState.f614l = false;
        appCompatDelegateImpl$PanelFeatureState.f615m = false;
        appCompatDelegateImpl$PanelFeatureState.f608f = null;
        appCompatDelegateImpl$PanelFeatureState.f616n = true;
        if (this.f699N == appCompatDelegateImpl$PanelFeatureState) {
            this.f699N = null;
        }
        if (appCompatDelegateImpl$PanelFeatureState.f603a == 0) {
            m178B();
        }
    }

    /* renamed from: m */
    public final boolean m184m(KeyEvent keyEvent) {
        View decorView;
        boolean z;
        boolean z2;
        Object obj = this.f720j;
        boolean z3 = true;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.f722l.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82) {
            C0585c9 c0585c9 = this.f723m;
            Window.Callback callback = this.f722l.getCallback();
            c0585c9.getClass();
            try {
                c0585c9.f8290d = true;
                if (callback.dispatchKeyEvent(keyEvent)) {
                    return true;
                }
            } finally {
                c0585c9.f8290d = false;
            }
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode != 4) {
                if (keyCode == 82) {
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    AppCompatDelegateImpl$PanelFeatureState m190t = m190t(0);
                    if (m190t.f615m) {
                        return true;
                    }
                    m196z(m190t, keyEvent);
                    return true;
                }
            } else {
                if ((keyEvent.getFlags() & 128) == 0) {
                    z3 = false;
                }
                this.f700O = z3;
            }
        } else if (keyCode != 4) {
            if (keyCode == 82) {
                if (this.f731u != null) {
                    return true;
                }
                AppCompatDelegateImpl$PanelFeatureState m190t2 = m190t(0);
                DecorContentParent decorContentParent = this.f728r;
                Context context = this.f721k;
                if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && !ViewConfiguration.get(context).hasPermanentMenuKey()) {
                    if (!this.f728r.isOverflowMenuShowing()) {
                        if (!this.f703R && m196z(m190t2, keyEvent)) {
                            z = this.f728r.showOverflowMenu();
                        }
                        z = false;
                    } else {
                        z = this.f728r.hideOverflowMenu();
                    }
                } else {
                    boolean z4 = m190t2.f615m;
                    if (!z4 && !m190t2.f614l) {
                        if (m190t2.f613k) {
                            if (m190t2.f617o) {
                                m190t2.f613k = false;
                                z2 = m196z(m190t2, keyEvent);
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                m194x(m190t2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    } else {
                        m183k(m190t2, true);
                        z = z4;
                    }
                }
                if (!z) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                    return true;
                }
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                return true;
            }
        } else if (m193w()) {
            return true;
        }
        return false;
    }

    /* renamed from: n */
    public final void m185n(int i) {
        AppCompatDelegateImpl$PanelFeatureState m190t = m190t(i);
        if (m190t.f610h != null) {
            Bundle bundle = new Bundle();
            m190t.f610h.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                m190t.f618p = bundle;
            }
            m190t.f610h.stopDispatchingItemsChanged();
            m190t.f610h.clear();
        }
        m190t.f617o = true;
        m190t.f616n = true;
        if ((i == 108 || i == 0) && this.f728r != null) {
            AppCompatDelegateImpl$PanelFeatureState m190t2 = m190t(0);
            m190t2.f613k = false;
            m196z(m190t2, null);
        }
    }

    /* renamed from: o */
    public final void m186o() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.f686A) {
            int[] iArr = androidx.appcompat.R.styleable.AppCompatTheme;
            Context context2 = this.f721k;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            int i = androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar;
            if (obtainStyledAttributes.hasValue(i)) {
                if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(i, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                    requestWindowFeature(10);
                }
                this.f695J = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                m187p();
                this.f722l.getDecorView();
                LayoutInflater from = LayoutInflater.from(context2);
                if (!this.f696K) {
                    if (this.f695J) {
                        viewGroup = (ViewGroup) from.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
                        this.f693H = false;
                        this.f692G = false;
                    } else if (this.f692G) {
                        TypedValue typedValue = new TypedValue();
                        context2.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            context = new androidx.appcompat.view.ContextThemeWrapper(context2, typedValue.resourceId);
                        } else {
                            context = context2;
                        }
                        viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(androidx.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
                        DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(androidx.appcompat.R.id.decor_content_parent);
                        this.f728r = decorContentParent;
                        decorContentParent.setWindowCallback(this.f722l.getCallback());
                        if (this.f693H) {
                            this.f728r.initFeature(109);
                        }
                        if (this.f690E) {
                            this.f728r.initFeature(2);
                        }
                        if (this.f691F) {
                            this.f728r.initFeature(5);
                        }
                    } else {
                        viewGroup = null;
                    }
                } else {
                    viewGroup = this.f694I ? (ViewGroup) from.inflate(androidx.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(androidx.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (viewGroup != null) {
                    ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new b01(3, this));
                    if (this.f728r == null) {
                        this.f688C = (TextView) viewGroup.findViewById(androidx.appcompat.R.id.title);
                    }
                    ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f722l.findViewById(R.id.content);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(R.id.content);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.f722l.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new C1789s8(this));
                    this.f687B = viewGroup;
                    Object obj = this.f720j;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.f727q;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        DecorContentParent decorContentParent2 = this.f728r;
                        if (decorContentParent2 != null) {
                            decorContentParent2.setWindowTitle(charSequence);
                        } else {
                            ActionBar actionBar = this.f725o;
                            if (actionBar != null) {
                                actionBar.setWindowTitle(charSequence);
                            } else {
                                TextView textView = this.f688C;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f687B.findViewById(R.id.content);
                    View decorView = this.f722l.getDecorView();
                    contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
                    obtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                    int i2 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor;
                    if (obtainStyledAttributes2.hasValue(i2)) {
                        obtainStyledAttributes2.getValue(i2, contentFrameLayout2.getFixedWidthMajor());
                    }
                    int i3 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor;
                    if (obtainStyledAttributes2.hasValue(i3)) {
                        obtainStyledAttributes2.getValue(i3, contentFrameLayout2.getFixedWidthMinor());
                    }
                    int i4 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor;
                    if (obtainStyledAttributes2.hasValue(i4)) {
                        obtainStyledAttributes2.getValue(i4, contentFrameLayout2.getFixedHeightMajor());
                    }
                    int i5 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor;
                    if (obtainStyledAttributes2.hasValue(i5)) {
                        obtainStyledAttributes2.getValue(i5, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.f686A = true;
                    AppCompatDelegateImpl$PanelFeatureState m190t = m190t(0);
                    if (!this.f703R && m190t.f610h == null) {
                        this.f712a0 |= 4096;
                        if (!this.f711Z) {
                            ViewCompat.postOnAnimation(this.f722l.getDecorView(), this.f713b0);
                            this.f711Z = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f692G + ", windowActionBarOverlay: " + this.f693H + ", android:windowIsFloating: " + this.f695J + ", windowActionModeOverlay: " + this.f694I + ", windowNoTitle: " + this.f696K + " }");
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onConfigurationChanged(Configuration configuration) {
        if (this.f692G && this.f686A) {
            m191u();
            ActionBar actionBar = this.f725o;
            if (actionBar != null) {
                actionBar.onConfigurationChanged(configuration);
            }
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = this.f721k;
        appCompatDrawableManager.onConfigurationChanged(context);
        this.f704S = new Configuration(context.getResources().getConfiguration());
        m179f(false, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onCreate(Bundle bundle) {
        String str;
        this.f701P = true;
        m179f(false, true);
        m187p();
        Object obj = this.f720j;
        if (obj instanceof Activity) {
            try {
                str = NavUtils.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ActionBar actionBar = this.f725o;
                if (actionBar == null) {
                    this.f714c0 = true;
                } else {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            synchronized (AppCompatDelegate.f601h) {
                AppCompatDelegate.m161d(this);
                AppCompatDelegate.f600g.add(new WeakReference(this));
            }
        }
        this.f704S = new Configuration(this.f721k.getResources().getConfiguration());
        this.f702Q = true;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return createView(null, str, context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onDestroy() {
        ActionBar actionBar;
        C1114d9 c1114d9;
        C1114d9 c1114d92;
        if (this.f720j instanceof Activity) {
            synchronized (AppCompatDelegate.f601h) {
                AppCompatDelegate.m161d(this);
            }
        }
        if (this.f711Z) {
            this.f722l.getDecorView().removeCallbacks(this.f713b0);
        }
        this.f703R = true;
        if (this.f705T != -100) {
            Object obj = this.f720j;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f683i0.put(this.f720j.getClass().getName(), Integer.valueOf(this.f705T));
                actionBar = this.f725o;
                if (actionBar != null) {
                    actionBar.mo154a();
                }
                c1114d9 = this.f709X;
                if (c1114d9 != null) {
                    c1114d9.m4779a();
                }
                c1114d92 = this.f710Y;
                if (c1114d92 == null) {
                    c1114d92.m4779a();
                    return;
                }
                return;
            }
        }
        f683i0.remove(this.f720j.getClass().getName());
        actionBar = this.f725o;
        if (actionBar != null) {
        }
        c1114d9 = this.f709X;
        if (c1114d9 != null) {
        }
        c1114d92 = this.f710Y;
        if (c1114d92 == null) {
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        int i;
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState;
        Window.Callback callback = this.f722l.getCallback();
        if (callback != null && !this.f703R) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArr = this.f698M;
            if (appCompatDelegateImpl$PanelFeatureStateArr != null) {
                i = appCompatDelegateImpl$PanelFeatureStateArr.length;
            } else {
                i = 0;
            }
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    appCompatDelegateImpl$PanelFeatureState = appCompatDelegateImpl$PanelFeatureStateArr[i2];
                    if (appCompatDelegateImpl$PanelFeatureState != null && appCompatDelegateImpl$PanelFeatureState.f610h == rootMenu) {
                        break;
                    }
                    i2++;
                } else {
                    appCompatDelegateImpl$PanelFeatureState = null;
                    break;
                }
            }
            if (appCompatDelegateImpl$PanelFeatureState != null) {
                return callback.onMenuItemSelected(appCompatDelegateImpl$PanelFeatureState.f603a, menuItem);
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        DecorContentParent decorContentParent = this.f728r;
        if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && (!ViewConfiguration.get(this.f721k).hasPermanentMenuKey() || this.f728r.isOverflowMenuShowPending())) {
            Window.Callback callback = this.f722l.getCallback();
            if (this.f728r.isOverflowMenuShowing()) {
                this.f728r.hideOverflowMenu();
                if (!this.f703R) {
                    callback.onPanelClosed(108, m190t(0).f610h);
                    return;
                }
                return;
            }
            if (callback != null && !this.f703R) {
                if (this.f711Z && (1 & this.f712a0) != 0) {
                    View decorView = this.f722l.getDecorView();
                    RunnableC1104d runnableC1104d = this.f713b0;
                    decorView.removeCallbacks(runnableC1104d);
                    runnableC1104d.run();
                }
                AppCompatDelegateImpl$PanelFeatureState m190t = m190t(0);
                MenuBuilder menuBuilder2 = m190t.f610h;
                if (menuBuilder2 != null && !m190t.f617o && callback.onPreparePanel(0, m190t.f609g, menuBuilder2)) {
                    callback.onMenuOpened(108, m190t.f610h);
                    this.f728r.showOverflowMenu();
                    return;
                }
                return;
            }
            return;
        }
        AppCompatDelegateImpl$PanelFeatureState m190t2 = m190t(0);
        m190t2.f616n = true;
        m183k(m190t2, false);
        m194x(m190t2, null);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onPostCreate(Bundle bundle) {
        m186o();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onPostResume() {
        m191u();
        ActionBar actionBar = this.f725o;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onSaveInstanceState(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onStart() {
        m179f(true, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onStop() {
        m191u();
        ActionBar actionBar = this.f725o;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    /* renamed from: p */
    public final void m187p() {
        if (this.f722l == null) {
            Object obj = this.f720j;
            if (obj instanceof Activity) {
                m180g(((Activity) obj).getWindow());
            }
        }
        if (this.f722l != null) {
        } else {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    /* renamed from: q */
    public final Context m188q() {
        Context context;
        m191u();
        ActionBar actionBar = this.f725o;
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f721k;
        }
        return context;
    }

    /* renamed from: r */
    public final AbstractC1187f9 m189r(Context context) {
        if (this.f709X == null) {
            if (jz2.f20696e == null) {
                Context applicationContext = context.getApplicationContext();
                jz2.f20696e = new jz2(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION));
            }
            this.f709X = new C1114d9(this, jz2.f20696e);
        }
        return this.f709X;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.f696K && i == 108) {
            return false;
        }
        if (this.f692G && i == 1) {
            this.f692G = false;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 5) {
                    if (i != 10) {
                        if (i != 108) {
                            if (i != 109) {
                                return this.f722l.requestFeature(i);
                            }
                            m177A();
                            this.f693H = true;
                            return true;
                        }
                        m177A();
                        this.f692G = true;
                        return true;
                    }
                    m177A();
                    this.f694I = true;
                    return true;
                }
                m177A();
                this.f691F = true;
                return true;
            }
            m177A();
            this.f690E = true;
            return true;
        }
        m177A();
        this.f696K = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view) {
        m186o();
        ViewGroup viewGroup = (ViewGroup) this.f687B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f723m.m2209a(this.f722l.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setHandleNativeActionModesEnabled(boolean z) {
        this.f736z = z;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setLocalNightMode(int i) {
        if (this.f705T != i) {
            this.f705T = i;
            if (this.f701P) {
                m179f(true, true);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.setOnBackInvokedDispatcher(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f718g0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f719h0) != null) {
            AbstractC0549b9.m2066c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f719h0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f720j;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f718g0 = AbstractC0549b9.m2064a((Activity) obj);
                m178B();
            }
        }
        this.f718g0 = onBackInvokedDispatcher;
        m178B();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setSupportActionBar(Toolbar toolbar) {
        CharSequence charSequence;
        Object obj = this.f720j;
        if (!(obj instanceof Activity)) {
            return;
        }
        m191u();
        ActionBar actionBar = this.f725o;
        if (!(actionBar instanceof WindowDecorActionBar)) {
            this.f726p = null;
            if (actionBar != null) {
                actionBar.mo154a();
            }
            this.f725o = null;
            if (toolbar != null) {
                if (obj instanceof Activity) {
                    charSequence = ((Activity) obj).getTitle();
                } else {
                    charSequence = this.f727q;
                }
                C0086g c0086g = new C0086g(toolbar, charSequence, this.f723m);
                this.f725o = c0086g;
                this.f723m.f8288b = c0086g.f740c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f723m.f8288b = null;
            }
            invalidateOptionsMenu();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTheme(int i) {
        this.f706U = i;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.f727q = charSequence;
        DecorContentParent decorContentParent = this.f728r;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.f725o;
        if (actionBar != null) {
            actionBar.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.f688C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0049  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ActionMode startSupportActionMode(ActionMode.Callback callback) {
        ActionMode actionMode;
        boolean z;
        ViewGroup viewGroup;
        ActionMode actionMode2;
        if (callback != null) {
            ActionMode actionMode3 = this.f731u;
            if (actionMode3 != null) {
                actionMode3.finish();
            }
            C1974x8 c1974x8 = new C1974x8(this, callback);
            m191u();
            ActionBar actionBar = this.f725o;
            AppCompatCallback appCompatCallback = this.f724n;
            if (actionBar != null) {
                ActionMode startActionMode = actionBar.startActionMode(c1974x8);
                this.f731u = startActionMode;
                if (startActionMode != null && appCompatCallback != null) {
                    appCompatCallback.onSupportActionModeStarted(startActionMode);
                }
            }
            if (this.f731u == null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f735y;
                if (viewPropertyAnimatorCompat != null) {
                    viewPropertyAnimatorCompat.cancel();
                }
                ActionMode actionMode4 = this.f731u;
                if (actionMode4 != null) {
                    actionMode4.finish();
                }
                if (appCompatCallback != null && !this.f703R) {
                    try {
                        actionMode = appCompatCallback.onWindowStartingSupportActionMode(c1974x8);
                    } catch (AbstractMethodError unused) {
                    }
                    if (actionMode == null) {
                        this.f731u = actionMode;
                    } else {
                        boolean z2 = true;
                        if (this.f732v == null) {
                            if (this.f695J) {
                                TypedValue typedValue = new TypedValue();
                                Context context = this.f721k;
                                Resources.Theme theme = context.getTheme();
                                theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                                if (typedValue.resourceId != 0) {
                                    Resources.Theme newTheme = context.getResources().newTheme();
                                    newTheme.setTo(theme);
                                    newTheme.applyStyle(typedValue.resourceId, true);
                                    androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                                    contextThemeWrapper.getTheme().setTo(newTheme);
                                    context = contextThemeWrapper;
                                }
                                this.f732v = new ActionBarContextView(context);
                                PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, androidx.appcompat.R.attr.actionModePopupWindowStyle);
                                this.f733w = popupWindow;
                                PopupWindowCompat.setWindowLayoutType(popupWindow, 2);
                                this.f733w.setContentView(this.f732v);
                                this.f733w.setWidth(-1);
                                context.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarSize, typedValue, true);
                                this.f732v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                                this.f733w.setHeight(-2);
                                this.f734x = new RunnableC1863u8(this);
                            } else {
                                ViewStubCompat viewStubCompat = (ViewStubCompat) this.f687B.findViewById(androidx.appcompat.R.id.action_mode_bar_stub);
                                if (viewStubCompat != null) {
                                    viewStubCompat.setLayoutInflater(LayoutInflater.from(m188q()));
                                    this.f732v = (ActionBarContextView) viewStubCompat.inflate();
                                }
                            }
                        }
                        if (this.f732v != null) {
                            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = this.f735y;
                            if (viewPropertyAnimatorCompat2 != null) {
                                viewPropertyAnimatorCompat2.cancel();
                            }
                            this.f732v.killMode();
                            Context context2 = this.f732v.getContext();
                            ActionBarContextView actionBarContextView = this.f732v;
                            if (this.f733w == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            StandaloneActionMode standaloneActionMode = new StandaloneActionMode(context2, actionBarContextView, c1974x8, z);
                            if (c1974x8.f28462a.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                                standaloneActionMode.invalidate();
                                this.f732v.initForMode(standaloneActionMode);
                                this.f731u = standaloneActionMode;
                                if (!this.f686A || (viewGroup = this.f687B) == null || !viewGroup.isLaidOut()) {
                                    z2 = false;
                                }
                                if (z2) {
                                    this.f732v.setAlpha(RecyclerView.f7068F0);
                                    ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this.f732v).alpha(1.0f);
                                    this.f735y = alpha;
                                    alpha.setListener(new C1900v8(this));
                                } else {
                                    this.f732v.setAlpha(1.0f);
                                    this.f732v.setVisibility(0);
                                    if (this.f732v.getParent() instanceof View) {
                                        ViewCompat.requestApplyInsets((View) this.f732v.getParent());
                                    }
                                }
                                if (this.f733w != null) {
                                    this.f722l.getDecorView().post(this.f734x);
                                }
                            } else {
                                this.f731u = null;
                            }
                        }
                    }
                    actionMode2 = this.f731u;
                    if (actionMode2 != null && appCompatCallback != null) {
                        appCompatCallback.onSupportActionModeStarted(actionMode2);
                    }
                    m178B();
                    this.f731u = this.f731u;
                }
                actionMode = null;
                if (actionMode == null) {
                }
                actionMode2 = this.f731u;
                if (actionMode2 != null) {
                    appCompatCallback.onSupportActionModeStarted(actionMode2);
                }
                m178B();
                this.f731u = this.f731u;
            }
            m178B();
            return this.f731u;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        if (r2 <= r5) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, java.lang.Object] */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AppCompatDelegateImpl$PanelFeatureState m190t(int i) {
        Object[] objArr;
        AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArr = this.f698M;
        if (appCompatDelegateImpl$PanelFeatureStateArr != null) {
            int length = appCompatDelegateImpl$PanelFeatureStateArr.length;
            objArr = appCompatDelegateImpl$PanelFeatureStateArr;
        }
        AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArr2 = new AppCompatDelegateImpl$PanelFeatureState[i + 1];
        if (appCompatDelegateImpl$PanelFeatureStateArr != null) {
            System.arraycopy(appCompatDelegateImpl$PanelFeatureStateArr, 0, appCompatDelegateImpl$PanelFeatureStateArr2, 0, appCompatDelegateImpl$PanelFeatureStateArr.length);
        }
        this.f698M = appCompatDelegateImpl$PanelFeatureStateArr2;
        objArr = appCompatDelegateImpl$PanelFeatureStateArr2;
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = objArr[i];
        if (appCompatDelegateImpl$PanelFeatureState == 0) {
            ?? obj = new Object();
            obj.f603a = i;
            obj.f616n = false;
            objArr[i] = obj;
            return obj;
        }
        return appCompatDelegateImpl$PanelFeatureState;
    }

    /* renamed from: u */
    public final void m191u() {
        m186o();
        if (this.f692G && this.f725o == null) {
            Object obj = this.f720j;
            if (obj instanceof Activity) {
                this.f725o = new WindowDecorActionBar((Activity) obj, this.f693H);
            } else if (obj instanceof Dialog) {
                this.f725o = new WindowDecorActionBar((Dialog) obj);
            }
            ActionBar actionBar = this.f725o;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.f714c0);
            }
        }
    }

    /* renamed from: v */
    public final int m192v(int i, Context context) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i != 0) {
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        if (this.f710Y == null) {
                            this.f710Y = new C1114d9(this, context);
                        }
                        return this.f710Y.mo4554c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
                return i;
            }
            if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            }
            return m189r(context).mo4554c();
        }
        return i;
    }

    /* renamed from: w */
    public final boolean m193w() {
        boolean z = this.f700O;
        this.f700O = false;
        AppCompatDelegateImpl$PanelFeatureState m190t = m190t(0);
        if (m190t.f615m) {
            if (!z) {
                m183k(m190t, true);
            }
            return true;
        }
        ActionMode actionMode = this.f731u;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        m191u();
        ActionBar actionBar = this.f725o;
        if (actionBar == null || !actionBar.collapseActionView()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x011f, code lost:
    
        if (r15 != null) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m194x(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (!appCompatDelegateImpl$PanelFeatureState.f615m && !this.f703R) {
            int i2 = appCompatDelegateImpl$PanelFeatureState.f603a;
            Context context = this.f721k;
            if (i2 == 0 && (context.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
            Window.Callback callback = this.f722l.getCallback();
            if (callback != null && !callback.onMenuOpened(i2, appCompatDelegateImpl$PanelFeatureState.f610h)) {
                m183k(appCompatDelegateImpl$PanelFeatureState, true);
                return;
            }
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null || !m196z(appCompatDelegateImpl$PanelFeatureState, keyEvent)) {
                return;
            }
            C1224g9 c1224g9 = appCompatDelegateImpl$PanelFeatureState.f607e;
            if (c1224g9 != null && !appCompatDelegateImpl$PanelFeatureState.f616n) {
                View view = appCompatDelegateImpl$PanelFeatureState.f609g;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                    appCompatDelegateImpl$PanelFeatureState.f614l = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
                    layoutParams2.gravity = appCompatDelegateImpl$PanelFeatureState.f605c;
                    layoutParams2.windowAnimations = appCompatDelegateImpl$PanelFeatureState.f606d;
                    windowManager.addView(appCompatDelegateImpl$PanelFeatureState.f607e, layoutParams2);
                    appCompatDelegateImpl$PanelFeatureState.f615m = true;
                    if (i2 != 0) {
                        m178B();
                        return;
                    }
                    return;
                }
            } else {
                if (c1224g9 == null) {
                    Context m188q = m188q();
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme newTheme = m188q.getResources().newTheme();
                    newTheme.setTo(m188q.getTheme());
                    newTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
                    int i3 = typedValue.resourceId;
                    if (i3 != 0) {
                        newTheme.applyStyle(i3, true);
                    }
                    newTheme.resolveAttribute(androidx.appcompat.R.attr.panelMenuListTheme, typedValue, true);
                    int i4 = typedValue.resourceId;
                    if (i4 != 0) {
                        newTheme.applyStyle(i4, true);
                    } else {
                        newTheme.applyStyle(androidx.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
                    }
                    androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(m188q, 0);
                    contextThemeWrapper.getTheme().setTo(newTheme);
                    appCompatDelegateImpl$PanelFeatureState.f612j = contextThemeWrapper;
                    TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
                    appCompatDelegateImpl$PanelFeatureState.f604b = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
                    appCompatDelegateImpl$PanelFeatureState.f606d = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
                    obtainStyledAttributes.recycle();
                    appCompatDelegateImpl$PanelFeatureState.f607e = new C1224g9(this, appCompatDelegateImpl$PanelFeatureState.f612j);
                    appCompatDelegateImpl$PanelFeatureState.f605c = 81;
                } else if (appCompatDelegateImpl$PanelFeatureState.f616n && c1224g9.getChildCount() > 0) {
                    appCompatDelegateImpl$PanelFeatureState.f607e.removeAllViews();
                }
                View view2 = appCompatDelegateImpl$PanelFeatureState.f609g;
                if (view2 != null) {
                    appCompatDelegateImpl$PanelFeatureState.f608f = view2;
                } else {
                    if (appCompatDelegateImpl$PanelFeatureState.f610h != null) {
                        if (this.f730t == null) {
                            this.f730t = new C1261h9(this);
                        }
                        C1261h9 c1261h9 = this.f730t;
                        if (appCompatDelegateImpl$PanelFeatureState.f611i == null) {
                            ListMenuPresenter listMenuPresenter = new ListMenuPresenter(appCompatDelegateImpl$PanelFeatureState.f612j, androidx.appcompat.R.layout.abc_list_menu_item_layout);
                            appCompatDelegateImpl$PanelFeatureState.f611i = listMenuPresenter;
                            listMenuPresenter.setCallback(c1261h9);
                            appCompatDelegateImpl$PanelFeatureState.f610h.addMenuPresenter(appCompatDelegateImpl$PanelFeatureState.f611i);
                        }
                        View view3 = (View) appCompatDelegateImpl$PanelFeatureState.f611i.getMenuView(appCompatDelegateImpl$PanelFeatureState.f607e);
                        appCompatDelegateImpl$PanelFeatureState.f608f = view3;
                    }
                    appCompatDelegateImpl$PanelFeatureState.f616n = true;
                    return;
                }
                if (appCompatDelegateImpl$PanelFeatureState.hasPanelItems()) {
                    ViewGroup.LayoutParams layoutParams3 = appCompatDelegateImpl$PanelFeatureState.f608f.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                    }
                    appCompatDelegateImpl$PanelFeatureState.f607e.setBackgroundResource(appCompatDelegateImpl$PanelFeatureState.f604b);
                    ViewParent parent = appCompatDelegateImpl$PanelFeatureState.f608f.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(appCompatDelegateImpl$PanelFeatureState.f608f);
                    }
                    appCompatDelegateImpl$PanelFeatureState.f607e.addView(appCompatDelegateImpl$PanelFeatureState.f608f, layoutParams3);
                    if (!appCompatDelegateImpl$PanelFeatureState.f608f.hasFocus()) {
                        appCompatDelegateImpl$PanelFeatureState.f608f.requestFocus();
                    }
                }
                appCompatDelegateImpl$PanelFeatureState.f616n = true;
                return;
            }
            i = -2;
            appCompatDelegateImpl$PanelFeatureState.f614l = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
            layoutParams22.gravity = appCompatDelegateImpl$PanelFeatureState.f605c;
            layoutParams22.windowAnimations = appCompatDelegateImpl$PanelFeatureState.f606d;
            windowManager.addView(appCompatDelegateImpl$PanelFeatureState.f607e, layoutParams22);
            appCompatDelegateImpl$PanelFeatureState.f615m = true;
            if (i2 != 0) {
            }
        }
    }

    /* renamed from: y */
    public final boolean m195y(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, int i, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((!appCompatDelegateImpl$PanelFeatureState.f613k && !m196z(appCompatDelegateImpl$PanelFeatureState, keyEvent)) || (menuBuilder = appCompatDelegateImpl$PanelFeatureState.f610h) == null) {
            return false;
        }
        return menuBuilder.performShortcut(i, keyEvent, 1);
    }

    /* renamed from: z */
    public final boolean m196z(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, KeyEvent keyEvent) {
        boolean z;
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        Resources.Theme theme;
        int i;
        boolean z2;
        DecorContentParent decorContentParent3;
        DecorContentParent decorContentParent4;
        if (this.f703R) {
            return false;
        }
        if (appCompatDelegateImpl$PanelFeatureState.f613k) {
            return true;
        }
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState2 = this.f699N;
        if (appCompatDelegateImpl$PanelFeatureState2 != null && appCompatDelegateImpl$PanelFeatureState2 != appCompatDelegateImpl$PanelFeatureState) {
            m183k(appCompatDelegateImpl$PanelFeatureState2, false);
        }
        Window.Callback callback = this.f722l.getCallback();
        int i2 = appCompatDelegateImpl$PanelFeatureState.f603a;
        if (callback != null) {
            appCompatDelegateImpl$PanelFeatureState.f609g = callback.onCreatePanelView(i2);
        }
        if (i2 != 0 && i2 != 108) {
            z = false;
        } else {
            z = true;
        }
        if (z && (decorContentParent4 = this.f728r) != null) {
            decorContentParent4.setMenuPrepared();
        }
        if (appCompatDelegateImpl$PanelFeatureState.f609g == null && (!z || !(this.f725o instanceof C0086g))) {
            MenuBuilder menuBuilder = appCompatDelegateImpl$PanelFeatureState.f610h;
            if (menuBuilder == null || appCompatDelegateImpl$PanelFeatureState.f617o) {
                if (menuBuilder == null) {
                    Context context = this.f721k;
                    if ((i2 == 0 || i2 == 108) && this.f728r != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(theme);
                            context = contextThemeWrapper;
                        }
                    }
                    MenuBuilder menuBuilder2 = new MenuBuilder(context);
                    menuBuilder2.setCallback(this);
                    MenuBuilder menuBuilder3 = appCompatDelegateImpl$PanelFeatureState.f610h;
                    if (menuBuilder2 != menuBuilder3) {
                        if (menuBuilder3 != null) {
                            menuBuilder3.removeMenuPresenter(appCompatDelegateImpl$PanelFeatureState.f611i);
                        }
                        appCompatDelegateImpl$PanelFeatureState.f610h = menuBuilder2;
                        ListMenuPresenter listMenuPresenter = appCompatDelegateImpl$PanelFeatureState.f611i;
                        if (listMenuPresenter != null) {
                            menuBuilder2.addMenuPresenter(listMenuPresenter);
                        }
                    }
                    if (appCompatDelegateImpl$PanelFeatureState.f610h == null) {
                        return false;
                    }
                }
                if (z && (decorContentParent2 = this.f728r) != null) {
                    if (this.f729s == null) {
                        this.f729s = new C1937w8(this);
                    }
                    decorContentParent2.setMenu(appCompatDelegateImpl$PanelFeatureState.f610h, this.f729s);
                }
                appCompatDelegateImpl$PanelFeatureState.f610h.stopDispatchingItemsChanged();
                if (!callback.onCreatePanelMenu(i2, appCompatDelegateImpl$PanelFeatureState.f610h)) {
                    MenuBuilder menuBuilder4 = appCompatDelegateImpl$PanelFeatureState.f610h;
                    if (menuBuilder4 != null) {
                        if (menuBuilder4 != null) {
                            menuBuilder4.removeMenuPresenter(appCompatDelegateImpl$PanelFeatureState.f611i);
                        }
                        appCompatDelegateImpl$PanelFeatureState.f610h = null;
                    }
                    if (z && (decorContentParent = this.f728r) != null) {
                        decorContentParent.setMenu(null, this.f729s);
                    }
                    return false;
                }
                appCompatDelegateImpl$PanelFeatureState.f617o = false;
            }
            appCompatDelegateImpl$PanelFeatureState.f610h.stopDispatchingItemsChanged();
            Bundle bundle = appCompatDelegateImpl$PanelFeatureState.f618p;
            if (bundle != null) {
                appCompatDelegateImpl$PanelFeatureState.f610h.restoreActionViewStates(bundle);
                appCompatDelegateImpl$PanelFeatureState.f618p = null;
            }
            if (!callback.onPreparePanel(0, appCompatDelegateImpl$PanelFeatureState.f609g, appCompatDelegateImpl$PanelFeatureState.f610h)) {
                if (z && (decorContentParent3 = this.f728r) != null) {
                    decorContentParent3.setMenu(null, this.f729s);
                }
                appCompatDelegateImpl$PanelFeatureState.f610h.startDispatchingItemsChanged();
                return false;
            }
            if (keyEvent != null) {
                i = keyEvent.getDeviceId();
            } else {
                i = -1;
            }
            if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            appCompatDelegateImpl$PanelFeatureState.qwertyMode = z2;
            appCompatDelegateImpl$PanelFeatureState.f610h.setQwertyMode(z2);
            appCompatDelegateImpl$PanelFeatureState.f610h.startDispatchingItemsChanged();
        }
        appCompatDelegateImpl$PanelFeatureState.f613k = true;
        appCompatDelegateImpl$PanelFeatureState.f614l = false;
        this.f699N = appCompatDelegateImpl$PanelFeatureState;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(int i) {
        m186o();
        ViewGroup viewGroup = (ViewGroup) this.f687B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f721k).inflate(i, viewGroup);
        this.f723m.m2209a(this.f722l.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m186o();
        ViewGroup viewGroup = (ViewGroup) this.f687B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f723m.m2209a(this.f722l.getCallback());
    }
}
