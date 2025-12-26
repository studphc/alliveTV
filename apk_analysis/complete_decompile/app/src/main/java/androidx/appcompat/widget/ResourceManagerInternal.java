package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import p000.ac2;
import p000.xb2;
import p000.yb2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ResourceManagerInternal {

    /* renamed from: i */
    public static ResourceManagerInternal f1337i;

    /* renamed from: a */
    public WeakHashMap f1339a;

    /* renamed from: b */
    public SimpleArrayMap f1340b;

    /* renamed from: c */
    public SparseArrayCompat f1341c;

    /* renamed from: d */
    public final WeakHashMap f1342d = new WeakHashMap(0);

    /* renamed from: e */
    public TypedValue f1343e;

    /* renamed from: f */
    public boolean f1344f;

    /* renamed from: g */
    public ResourceManagerHooks f1345g;

    /* renamed from: h */
    public static final PorterDuff.Mode f1336h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j */
    public static final yb2 f1338j = new LruCache(6);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface ResourceManagerHooks {
        @Nullable
        Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DrawableRes int i);

        @Nullable
        ColorStateList getTintListForDrawableRes(@NonNull Context context, @DrawableRes int i);

        @Nullable
        PorterDuff.Mode getTintModeForDrawableRes(int i);

        boolean tintDrawable(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable);

        boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [ac2, java.lang.Object] */
    /* renamed from: f */
    public static void m252f(ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.m253a("vector", new xb2(2));
            resourceManagerInternal.m253a("animated-vector", new xb2(1));
            resourceManagerInternal.m253a("animated-selector", new xb2(0));
            resourceManagerInternal.m253a("drawable", new Object());
        }
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            try {
                if (f1337i == null) {
                    ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                    f1337i = resourceManagerInternal2;
                    m252f(resourceManagerInternal2);
                }
                resourceManagerInternal = f1337i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (ResourceManagerInternal.class) {
            yb2 yb2Var = f1338j;
            yb2Var.getClass();
            int i2 = (31 + i) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) yb2Var.get(Integer.valueOf(mode.hashCode() + i2));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
            }
        }
        return porterDuffColorFilter;
    }

    /* renamed from: a */
    public final void m253a(String str, ac2 ac2Var) {
        if (this.f1340b == null) {
            this.f1340b = new SimpleArrayMap();
        }
        this.f1340b.put(str, ac2Var);
    }

    /* renamed from: b */
    public final synchronized void m254b(Context context, long j, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                LongSparseArray longSparseArray = (LongSparseArray) this.f1342d.get(context);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                    this.f1342d.put(context, longSparseArray);
                }
                longSparseArray.put(j, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: c */
    public final synchronized Drawable m255c(Context context, long j) {
        LongSparseArray longSparseArray = (LongSparseArray) this.f1342d.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) longSparseArray.get(j);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.remove(j);
        }
        return null;
    }

    /* renamed from: d */
    public final synchronized Drawable m256d(Context context, int i, boolean z) {
        Drawable m258g;
        try {
            if (!this.f1344f) {
                this.f1344f = true;
                Drawable drawable = getDrawable(context, R.drawable.abc_vector_test);
                if (drawable == null || (!(drawable instanceof VectorDrawableCompat) && !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName()))) {
                    this.f1344f = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            m258g = m258g(i, context);
            if (m258g == null) {
                if (this.f1343e == null) {
                    this.f1343e = new TypedValue();
                }
                TypedValue typedValue = this.f1343e;
                context.getResources().getValue(i, typedValue, true);
                long j = (typedValue.assetCookie << 32) | typedValue.data;
                Drawable m255c = m255c(context, j);
                if (m255c == null) {
                    ResourceManagerHooks resourceManagerHooks = this.f1345g;
                    if (resourceManagerHooks == null) {
                        m255c = null;
                    } else {
                        m255c = resourceManagerHooks.createDrawableFor(this, context, i);
                    }
                    if (m255c != null) {
                        m255c.setChangingConfigurations(typedValue.changingConfigurations);
                        m254b(context, j, m255c);
                    }
                }
                m258g = m255c;
            }
            if (m258g == null) {
                m258g = ContextCompat.getDrawable(context, i);
            }
            if (m258g != null) {
                m258g = m259h(context, i, z, m258g);
            }
            if (m258g != null) {
                DrawableUtils.m247a(m258g);
            }
        } finally {
        }
        return m258g;
    }

    /* renamed from: e */
    public final synchronized ColorStateList m257e(int i, Context context) {
        ColorStateList colorStateList;
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap weakHashMap = this.f1339a;
        ColorStateList colorStateList2 = null;
        if (weakHashMap != null && (sparseArrayCompat = (SparseArrayCompat) weakHashMap.get(context)) != null) {
            colorStateList = (ColorStateList) sparseArrayCompat.get(i);
        } else {
            colorStateList = null;
        }
        if (colorStateList == null) {
            ResourceManagerHooks resourceManagerHooks = this.f1345g;
            if (resourceManagerHooks != null) {
                colorStateList2 = resourceManagerHooks.getTintListForDrawableRes(context, i);
            }
            if (colorStateList2 != null) {
                if (this.f1339a == null) {
                    this.f1339a = new WeakHashMap();
                }
                SparseArrayCompat sparseArrayCompat2 = (SparseArrayCompat) this.f1339a.get(context);
                if (sparseArrayCompat2 == null) {
                    sparseArrayCompat2 = new SparseArrayCompat();
                    this.f1339a.put(context, sparseArrayCompat2);
                }
                sparseArrayCompat2.append(i, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* renamed from: g */
    public final Drawable m258g(int i, Context context) {
        int next;
        SimpleArrayMap simpleArrayMap = this.f1340b;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat sparseArrayCompat = this.f1341c;
        if (sparseArrayCompat != null) {
            String str = (String) sparseArrayCompat.get(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f1340b.get(str) == null)) {
                return null;
            }
        } else {
            this.f1341c = new SparseArrayCompat();
        }
        if (this.f1343e == null) {
            this.f1343e = new TypedValue();
        }
        TypedValue typedValue = this.f1343e;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable m255c = m255c(context, j);
        if (m255c != null) {
            return m255c;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    String name = xml.getName();
                    this.f1341c.append(i, name);
                    ac2 ac2Var = (ac2) this.f1340b.get(name);
                    if (ac2Var != null) {
                        m255c = ac2Var.mo62a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (m255c != null) {
                        m255c.setChangingConfigurations(typedValue.changingConfigurations);
                        m254b(context, j, m255c);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (m255c == null) {
            this.f1341c.append(i, "appcompat_skip_skip");
        }
        return m255c;
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return m256d(context, i, false);
    }

    /* renamed from: h */
    public final Drawable m259h(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList m257e = m257e(i, context);
        PorterDuff.Mode mode = null;
        if (m257e != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTintList(wrap, m257e);
            ResourceManagerHooks resourceManagerHooks = this.f1345g;
            if (resourceManagerHooks != null) {
                mode = resourceManagerHooks.getTintModeForDrawableRes(i);
            }
            if (mode != null) {
                DrawableCompat.setTintMode(wrap, mode);
                return wrap;
            }
            return wrap;
        }
        ResourceManagerHooks resourceManagerHooks2 = this.f1345g;
        if (resourceManagerHooks2 == null || !resourceManagerHooks2.tintDrawable(context, i, drawable)) {
            ResourceManagerHooks resourceManagerHooks3 = this.f1345g;
            if ((resourceManagerHooks3 == null || !resourceManagerHooks3.tintDrawableUsingColorFilter(context, i, drawable)) && z) {
                return null;
            }
            return drawable;
        }
        return drawable;
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        LongSparseArray longSparseArray = (LongSparseArray) this.f1342d.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public synchronized void setHooks(ResourceManagerHooks resourceManagerHooks) {
        this.f1345g = resourceManagerHooks;
    }
}
