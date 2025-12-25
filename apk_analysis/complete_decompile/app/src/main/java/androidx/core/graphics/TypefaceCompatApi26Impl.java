package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import p000.g53;
import p000.ty2;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends ty2 {
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class<?> mFontFamily;
    protected final Constructor<?> mFontFamilyCtor;
    protected final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Class<?> cls;
        Constructor<?> constructor;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = obtainFontFamily();
            constructor = obtainFontFamilyCtor(cls);
            method = obtainAddFontFromAssetManagerMethod(cls);
            method2 = obtainAddFontFromBufferMethod(cls);
            method3 = obtainFreezeMethod(cls);
            method4 = obtainAbortCreationMethod(cls);
            method5 = obtainCreateFromFamiliesWithDefaultMethod(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            cls = null;
            constructor = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = method;
        this.mAddFontFromBuffer = method2;
        this.mFreeze = method3;
        this.mAbortCreation = method4;
        this.mCreateFromFamiliesWithDefault = method5;
    }

    @Override // p000.ty2, p000.vy2
    /* renamed from: a */
    public Typeface mo838a(Context context, Typeface typeface, int i, boolean z) {
        Typeface typeface2;
        try {
            typeface2 = g53.m4928a(typeface, i, z);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        if (typeface2 == null) {
            return super.mo838a(context, typeface, i, z);
        }
        return typeface2;
    }

    @Nullable
    public Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.mFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // p000.ty2, p000.vy2
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!m842h()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object m843i = m843i();
        if (m843i == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
            if (!m840f(context, m843i, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings()))) {
                m839e(m843i);
                return null;
            }
        }
        if (!m841g(m843i)) {
            return null;
        }
        return createFromFamiliesWithDefault(m843i);
    }

    @Override // p000.ty2, p000.vy2
    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        Typeface createFromFamiliesWithDefault;
        boolean z;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (!m842h()) {
            FontsContractCompat.FontInfo findBestInfo = findBestInfo(fontInfoArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo.getUri(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(findBestInfo.getWeight()).setItalic(findBestInfo.isItalic()).build();
                    openFileDescriptor.close();
                    return build;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> readFontInfoIntoByteBuffer = TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontInfoArr, cancellationSignal);
        Object m843i = m843i();
        if (m843i == null) {
            return null;
        }
        int length = fontInfoArr.length;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            FontsContractCompat.FontInfo fontInfo = fontInfoArr[i2];
            ByteBuffer byteBuffer = readFontInfoIntoByteBuffer.get(fontInfo.getUri());
            if (byteBuffer != null) {
                try {
                    z = ((Boolean) this.mAddFontFromBuffer.invoke(m843i, byteBuffer, Integer.valueOf(fontInfo.getTtcIndex()), null, Integer.valueOf(fontInfo.getWeight()), Integer.valueOf(fontInfo.isItalic() ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    z = false;
                }
                if (!z) {
                    m839e(m843i);
                    return null;
                }
                z2 = true;
            }
            i2++;
            z2 = z2;
        }
        if (!z2) {
            m839e(m843i);
            return null;
        }
        if (!m841g(m843i) || (createFromFamiliesWithDefault = createFromFamiliesWithDefault(m843i)) == null) {
            return null;
        }
        return Typeface.create(createFromFamiliesWithDefault, i);
    }

    @Override // p000.vy2
    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!m842h()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object m843i = m843i();
        if (m843i == null) {
            return null;
        }
        if (!m840f(context, m843i, str, 0, -1, -1, null)) {
            m839e(m843i);
            return null;
        }
        if (!m841g(m843i)) {
            return null;
        }
        return createFromFamiliesWithDefault(m843i);
    }

    /* renamed from: e */
    public final void m839e(Object obj) {
        try {
            this.mAbortCreation.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    /* renamed from: f */
    public final boolean m840f(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.mAddFontFromAssetManager.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: g */
    public final boolean m841g(Object obj) {
        try {
            return ((Boolean) this.mFreeze.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: h */
    public final boolean m842h() {
        if (this.mAddFontFromAssetManager == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (this.mAddFontFromAssetManager != null) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public final Object m843i() {
        try {
            return this.mFontFamilyCtor.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method obtainAbortCreationMethod(Class<?> cls) {
        return cls.getMethod("abortCreation", null);
    }

    public Method obtainAddFontFromAssetManagerMethod(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method obtainAddFontFromBufferMethod(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class<?> obtainFontFamily() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor<?> obtainFontFamilyCtor(Class<?> cls) {
        return cls.getConstructor(null);
    }

    public Method obtainFreezeMethod(Class<?> cls) {
        return cls.getMethod("freeze", null);
    }
}
