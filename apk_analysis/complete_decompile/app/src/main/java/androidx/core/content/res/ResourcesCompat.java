package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import p000.RunnableC0583c7;
import p000.RunnableC2015yc;
import p000.bc2;
import p000.cc2;
import p000.dc2;
import p000.ec2;
import p000.fc2;

/* loaded from: classes.dex */
public final class ResourcesCompat {

    @AnyRes
    public static final int ID_NULL = 0;

    /* renamed from: a */
    public static final ThreadLocal f3627a = new ThreadLocal();

    /* renamed from: b */
    public static final WeakHashMap f3628b = new WeakHashMap(0);

    /* renamed from: c */
    public static final Object f3629c = new Object();

    /* loaded from: classes.dex */
    public static abstract class FontCallback {
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(int i, @Nullable Handler handler) {
            getHandler(handler).post(new RunnableC2015yc(i, 2, this));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(@NonNull Typeface typeface, @Nullable Handler handler) {
            getHandler(handler).post(new RunnableC0583c7(29, this, typeface));
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);
    }

    /* loaded from: classes.dex */
    public static final class ThemeCompat {
        public static void rebase(@NonNull Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                AbstractC0178b.m823a(theme);
                return;
            }
            synchronized (AbstractC0177a.f3630a) {
                if (!AbstractC0177a.f3632c) {
                    try {
                        Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                        AbstractC0177a.f3631b = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e) {
                        Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                    }
                    AbstractC0177a.f3632c = true;
                }
                Method method = AbstractC0177a.f3631b;
                if (method != null) {
                    try {
                        method.invoke(theme, null);
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                        AbstractC0177a.f3631b = null;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m820a(fc2 fc2Var, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f3629c) {
            try {
                WeakHashMap weakHashMap = f3628b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(fc2Var);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(fc2Var, sparseArray);
                }
                sparseArray.append(i, new ec2(colorStateList, fc2Var.f17210a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00bb A[ADDED_TO_REGION] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface m821b(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, Handler handler, boolean z, boolean z2) {
        int i3 = i;
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            Typeface typeface = null;
            int i4 = -3;
            i4 = -3;
            i4 = -3;
            i4 = -3;
            i4 = -3;
            if (!charSequence2.startsWith("res/")) {
                if (fontCallback != null) {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            } else {
                Typeface findFromCache = TypefaceCompat.findFromCache(resources, i3, charSequence2, typedValue.assetCookie, i2);
                if (findFromCache != null) {
                    if (fontCallback != null) {
                        fontCallback.callbackSuccessAsync(findFromCache, handler);
                    }
                    typeface = findFromCache;
                } else if (!z2) {
                    try {
                    } catch (IOException e) {
                        e = e;
                        i3 = i4;
                    } catch (XmlPullParserException e2) {
                        e = e2;
                        i3 = i4;
                    }
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources.getXml(i3), resources);
                            if (parse == null) {
                                Log.e("ResourcesCompat", "Failed to find font-family tag");
                                if (fontCallback != null) {
                                    fontCallback.callbackFailAsync(-3, handler);
                                }
                            } else {
                                boolean z3 = z;
                                typeface = TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i, charSequence2, typedValue.assetCookie, i2, fontCallback, handler, z3);
                                i4 = z3;
                            }
                        } else {
                            Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, i, charSequence2, typedValue.assetCookie, i2);
                            if (fontCallback != null) {
                                if (createFromResourcesFontFile != null) {
                                    fontCallback.callbackSuccessAsync(createFromResourcesFontFile, handler);
                                } else {
                                    fontCallback.callbackFailAsync(-3, handler);
                                }
                            }
                            typeface = createFromResourcesFontFile;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        Log.e("ResourcesCompat", "Failed to read xml resource ".concat(charSequence2), e);
                        if (fontCallback != null) {
                            fontCallback.callbackFailAsync(i3, handler);
                        }
                        if (typeface != null) {
                        }
                        return typeface;
                    } catch (XmlPullParserException e4) {
                        e = e4;
                        Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(charSequence2), e);
                        if (fontCallback != null) {
                        }
                        if (typeface != null) {
                        }
                        return typeface;
                    }
                }
            }
            if (typeface != null && fontCallback == null && !z2) {
                throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
            }
            return typeface;
        }
        throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
    }

    public static void clearCachesForTheme(@NonNull Resources.Theme theme) {
        synchronized (f3629c) {
            try {
                Iterator it = f3628b.keySet().iterator();
                while (it.hasNext()) {
                    fc2 fc2Var = (fc2) it.next();
                    if (fc2Var != null && theme.equals(fc2Var.f17211b)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context context, @FontRes int i) {
        if (context.isRestricted()) {
            return null;
        }
        return m821b(context, i, new TypedValue(), 0, null, null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) {
        return cc2.m2224a(resources, i, theme);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x003e, code lost:
    
        if (r4.f16761c == r9.hashCode()) goto L21;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ec2 ec2Var;
        fc2 fc2Var = new fc2(resources, theme);
        synchronized (f3629c) {
            try {
                SparseArray sparseArray = (SparseArray) f3628b.get(fc2Var);
                colorStateList = null;
                if (sparseArray != null && sparseArray.size() > 0 && (ec2Var = (ec2) sparseArray.get(i)) != null) {
                    if (ec2Var.f16760b.equals(resources.getConfiguration())) {
                        if (theme == null) {
                            if (ec2Var.f16761c != 0) {
                            }
                            colorStateList2 = ec2Var.f16759a;
                        }
                        if (theme != null) {
                        }
                    }
                    sparseArray.remove(i);
                }
                colorStateList2 = null;
            } finally {
            }
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        ThreadLocal threadLocal = f3627a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            try {
                colorStateList = ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), theme);
            } catch (Exception e) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        if (colorStateList != null) {
            m820a(fc2Var, i, colorStateList, theme);
            return colorStateList;
        }
        return cc2.m2225b(resources, i, theme);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return bc2.m2080a(resources, i, theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i, int i2, @Nullable Resources.Theme theme) {
        return bc2.m2081b(resources, i, i2, theme);
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return dc2.m4568a(resources, i);
        }
        ThreadLocal threadLocal = f3627a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i) {
        if (context.isRestricted()) {
            return null;
        }
        return m821b(context, i, new TypedValue(), 0, null, null, false, false);
    }

    public static void getFont(@NonNull Context context, @FontRes int i, @NonNull FontCallback fontCallback, @Nullable Handler handler) {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            m821b(context, i, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i, @NonNull TypedValue typedValue, int i2, @Nullable FontCallback fontCallback) {
        if (context.isRestricted()) {
            return null;
        }
        return m821b(context, i, typedValue, i2, fontCallback, null, true, false);
    }
}
