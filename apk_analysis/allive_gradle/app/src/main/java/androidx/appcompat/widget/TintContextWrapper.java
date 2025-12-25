package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p000.au2;
import p000.gc2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: c */
    public static final Object f1489c = new Object();

    /* renamed from: d */
    public static ArrayList f1490d;

    /* renamed from: a */
    public final gc2 f1491a;

    /* renamed from: b */
    public final Resources.Theme f1492b;

    public TintContextWrapper(Context context) {
        super(context);
        if (VectorEnabledTintResources.shouldBeUsed()) {
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
            this.f1491a = vectorEnabledTintResources;
            Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
            this.f1492b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1491a = new au2(this, context.getResources());
        this.f1492b = null;
    }

    public static Context wrap(@NonNull Context context) {
        boolean z;
        TintContextWrapper tintContextWrapper;
        if (!(context instanceof TintContextWrapper) && !(context.getResources() instanceof au2) && !(context.getResources() instanceof VectorEnabledTintResources)) {
            z = VectorEnabledTintResources.shouldBeUsed();
        } else {
            z = false;
        }
        if (z) {
            synchronized (f1489c) {
                try {
                    ArrayList arrayList = f1490d;
                    if (arrayList == null) {
                        f1490d = new ArrayList();
                    } else {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            WeakReference weakReference = (WeakReference) f1490d.get(size);
                            if (weakReference == null || weakReference.get() == null) {
                                f1490d.remove(size);
                            }
                        }
                        for (int size2 = f1490d.size() - 1; size2 >= 0; size2--) {
                            WeakReference weakReference2 = (WeakReference) f1490d.get(size2);
                            if (weakReference2 != null) {
                                tintContextWrapper = (TintContextWrapper) weakReference2.get();
                            } else {
                                tintContextWrapper = null;
                            }
                            if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                                return tintContextWrapper;
                            }
                        }
                    }
                    TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                    f1490d.add(new WeakReference(tintContextWrapper2));
                    return tintContextWrapper2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1491a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1491a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1492b;
        if (theme == null) {
            return super.getTheme();
        }
        return theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f1492b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
