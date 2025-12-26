package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Method;
import p000.uy2;
import p000.vy2;

/* loaded from: classes.dex */
public class TypefaceCompat {

    /* renamed from: a */
    public static final vy2 f3646a;

    /* renamed from: b */
    public static final LruCache f3647b;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        /* renamed from: a */
        public final ResourcesCompat.FontCallback f3648a;

        public ResourcesCallbackAdapter(@Nullable ResourcesCompat.FontCallback fontCallback) {
            this.f3648a = fontCallback;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRequestFailed(int i) {
            ResourcesCompat.FontCallback fontCallback = this.f3648a;
            if (fontCallback != null) {
                fontCallback.onFontRetrievalFailed(i);
            }
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRetrieved(@NonNull Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.f3648a;
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(typeface);
            }
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f3646a = new TypefaceCompatApi29Impl();
        } else if (i >= 28) {
            f3646a = new TypefaceCompatApi28Impl();
        } else if (i >= 26) {
            f3646a = new TypefaceCompatApi26Impl();
        } else {
            if (i >= 24) {
                Method method = uy2.f27551d;
                if (method == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (method != null) {
                    f3646a = new vy2();
                }
            }
            f3646a = new vy2();
        }
        f3647b = new LruCache(16);
    }

    /* renamed from: a */
    public static String m837a(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static void clearCache() {
        f3647b.evictAll();
    }

    @NonNull
    public static Typeface create(@NonNull Context context, @Nullable Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromFontInfo(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return f3646a.createFromFontInfo(context, cancellationSignal, fontInfoArr, i);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromResourcesFamilyXml(@NonNull Context context, @NonNull FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i, @Nullable String str, int i2, int i3, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        Typeface createFromFontFamilyFilesResourceEntry;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            String systemFontFamilyName = providerResourceEntry.getSystemFontFamilyName();
            Typeface typeface = null;
            if (systemFontFamilyName != null && !systemFontFamilyName.isEmpty()) {
                Typeface create = Typeface.create(systemFontFamilyName, 0);
                Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
                if (create != null && !create.equals(create2)) {
                    typeface = create;
                }
            }
            if (typeface != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(typeface, handler);
                }
                return typeface;
            }
            createFromFontFamilyFilesResourceEntry = FontsContractCompat.requestFont(context, providerResourceEntry.getRequest(), i3, !z ? fontCallback != null : providerResourceEntry.getFetchStrategy() != 0, z ? providerResourceEntry.getTimeout() : -1, ResourcesCompat.FontCallback.getHandler(handler), new ResourcesCallbackAdapter(fontCallback));
        } else {
            createFromFontFamilyFilesResourceEntry = f3646a.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i3);
            if (fontCallback != null) {
                if (createFromFontFamilyFilesResourceEntry != null) {
                    fontCallback.callbackSuccessAsync(createFromFontFamilyFilesResourceEntry, handler);
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            }
        }
        if (createFromFontFamilyFilesResourceEntry != null) {
            f3647b.put(m837a(resources, i, str, i2, i3), createFromFontFamilyFilesResourceEntry);
        }
        return createFromFontFamilyFilesResourceEntry;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromResourcesFontFile(@NonNull Context context, @NonNull Resources resources, int i, String str, int i2, int i3) {
        Typeface createFromResourcesFontFile = f3646a.createFromResourcesFontFile(context, resources, i, str, i3);
        if (createFromResourcesFontFile != null) {
            f3647b.put(m837a(resources, i, str, i2, i3), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface findFromCache(@NonNull Resources resources, int i, @Nullable String str, int i2, int i3) {
        return (Typeface) f3647b.get(m837a(resources, i, str, i2, i3));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface findFromCache(@NonNull Resources resources, int i, int i2) {
        return findFromCache(resources, i, null, 0, i2);
    }

    @NonNull
    public static Typeface create(@NonNull Context context, @Nullable Typeface typeface, @IntRange(from = 1, m153to = 1000) int i, boolean z) {
        if (context != null) {
            Preconditions.checkArgumentInRange(i, 1, 1000, "weight");
            if (typeface == null) {
                typeface = Typeface.DEFAULT;
            }
            return f3646a.mo838a(context, typeface, i, z);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface createFromResourcesFontFile(@NonNull Context context, @NonNull Resources resources, int i, String str, int i2) {
        return createFromResourcesFontFile(context, resources, i, str, 0, i2);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface createFromResourcesFamilyXml(@NonNull Context context, @NonNull FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i, int i2, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        return createFromResourcesFamilyXml(context, familyResourceEntry, resources, i, null, 0, i2, fontCallback, handler, z);
    }
}
