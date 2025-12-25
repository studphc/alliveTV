package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.app.AppLocalesStorageHelper;
import androidx.core.os.LocaleListCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;
import p000.AbstractC1678p8;
import p000.AbstractC1715q8;
import p000.ExecutorC1752r8;
import p000.RunnableC1613o8;
import p000.d40;

/* loaded from: classes.dex */
public abstract class AppCompatDelegate {
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;

    @Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;

    @Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;

    /* renamed from: a */
    public static final ExecutorC1752r8 f594a = new ExecutorC1752r8(new d40(1));

    /* renamed from: b */
    public static int f595b = -100;

    /* renamed from: c */
    public static LocaleListCompat f596c = null;

    /* renamed from: d */
    public static LocaleListCompat f597d = null;

    /* renamed from: e */
    public static Boolean f598e = null;

    /* renamed from: f */
    public static boolean f599f = false;

    /* renamed from: g */
    public static final ArraySet f600g = new ArraySet();

    /* renamed from: h */
    public static final Object f601h = new Object();

    /* renamed from: i */
    public static final Object f602i = new Object();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface NightMode {
    }

    /* renamed from: b */
    public static Object m159b() {
        Context contextForDelegate;
        Iterator it = f600g.iterator();
        while (it.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) it.next()).get();
            if (appCompatDelegate != null && (contextForDelegate = appCompatDelegate.getContextForDelegate()) != null) {
                return contextForDelegate.getSystemService("locale");
            }
        }
        return null;
    }

    /* renamed from: c */
    public static boolean m160c(Context context) {
        if (f598e == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.getServiceInfo(context).metaData;
                if (bundle != null) {
                    f598e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f598e = Boolean.FALSE;
            }
        }
        return f598e.booleanValue();
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Activity activity, @Nullable AppCompatCallback appCompatCallback) {
        return new LayoutInflaterFactory2C0084e(activity, null, appCompatCallback, activity);
    }

    /* renamed from: d */
    public static void m161d(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e) {
        synchronized (f601h) {
            try {
                Iterator it = f600g.iterator();
                while (it.hasNext()) {
                    AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) it.next()).get();
                    if (appCompatDelegate == layoutInflaterFactory2C0084e || appCompatDelegate == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: e */
    public static void m162e(Context context) {
        if (!m160c(context)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (!f599f) {
                f594a.execute(new RunnableC1613o8(context, 0));
                return;
            }
            return;
        }
        synchronized (f602i) {
            try {
                LocaleListCompat localeListCompat = f596c;
                if (localeListCompat == null) {
                    if (f597d == null) {
                        f597d = LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(context));
                    }
                    if (f597d.isEmpty()) {
                    } else {
                        f596c = f597d;
                    }
                } else if (!localeListCompat.equals(f597d)) {
                    LocaleListCompat localeListCompat2 = f596c;
                    f597d = localeListCompat2;
                    AppLocalesStorageHelper.persistLocales(context, localeListCompat2.toLanguageTags());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat getApplicationLocales() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object m159b = m159b();
            if (m159b != null) {
                return LocaleListCompat.wrap(AbstractC1715q8.m7004a(m159b));
            }
        } else {
            LocaleListCompat localeListCompat = f596c;
            if (localeListCompat != null) {
                return localeListCompat;
            }
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    public static int getDefaultNightMode() {
        return f595b;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    public static void setApplicationLocales(@NonNull LocaleListCompat localeListCompat) {
        Objects.requireNonNull(localeListCompat);
        if (Build.VERSION.SDK_INT >= 33) {
            Object m159b = m159b();
            if (m159b != null) {
                AbstractC1715q8.m7005b(m159b, AbstractC1678p8.m6886a(localeListCompat.toLanguageTags()));
                return;
            }
            return;
        }
        if (!localeListCompat.equals(f596c)) {
            synchronized (f601h) {
                f596c = localeListCompat;
                Iterator it = f600g.iterator();
                while (it.hasNext()) {
                    AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) it.next()).get();
                    if (appCompatDelegate != null) {
                        appCompatDelegate.mo163a();
                    }
                }
            }
        }
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(z);
    }

    public static void setDefaultNightMode(int i) {
        if (i != -1 && i != 0 && i != 1 && i != 2 && i != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
            return;
        }
        if (f595b != i) {
            f595b = i;
            synchronized (f601h) {
                try {
                    Iterator it = f600g.iterator();
                    while (it.hasNext()) {
                        AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) it.next()).get();
                        if (appCompatDelegate != null) {
                            appCompatDelegate.applyDayNight();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean applyDayNight();

    @Deprecated
    public void attachBaseContext(Context context) {
    }

    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context context) {
        attachBaseContext(context);
        return context;
    }

    public abstract View createView(@Nullable View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet);

    @Nullable
    public abstract <T extends View> T findViewById(@IdRes int i);

    @Nullable
    public Context getContextForDelegate() {
        return null;
    }

    @Nullable
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    @Nullable
    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int i);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle bundle);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(@LayoutRes int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setHandleNativeActionModesEnabled(boolean z);

    public abstract void setLocalNightMode(int i);

    @RequiresApi(33)
    @CallSuper
    public void setOnBackInvokedDispatcher(@Nullable OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void setSupportActionBar(@Nullable Toolbar toolbar);

    public void setTheme(@StyleRes int i) {
    }

    public abstract void setTitle(@Nullable CharSequence charSequence);

    @Nullable
    public abstract ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback);

    @NonNull
    public static AppCompatDelegate create(@NonNull Dialog dialog, @Nullable AppCompatCallback appCompatCallback) {
        return new LayoutInflaterFactory2C0084e(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context context, @NonNull Window window, @Nullable AppCompatCallback appCompatCallback) {
        return new LayoutInflaterFactory2C0084e(context, window, appCompatCallback, context);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context context, @NonNull Activity activity, @Nullable AppCompatCallback appCompatCallback) {
        return new LayoutInflaterFactory2C0084e(context, null, appCompatCallback, activity);
    }

    /* renamed from: a */
    public void mo163a() {
    }
}
