package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal.http.HttpStatusCodesKt;

/* loaded from: classes.dex */
public abstract class vy2 {

    /* renamed from: a */
    public final ConcurrentHashMap f28013a = new ConcurrentHashMap();

    /* renamed from: b */
    public static long m7953b(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    /* renamed from: a */
    public Typeface mo838a(Context context, Typeface typeface, int i, boolean z) {
        Typeface typeface2;
        try {
            typeface2 = e53.m4660a(this, context, typeface, i, z);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        if (typeface2 != null) {
            return typeface2;
        }
        return typeface;
    }

    public abstract Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i);

    public abstract Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i);

    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                return null;
            }
            return Typeface.createFromFile(tempFile.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, resources, i)) {
                return null;
            }
            return Typeface.createFromFile(tempFile.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        int i2;
        boolean z;
        int i3;
        if ((i & 1) == 0) {
            i2 = HttpStatusCodesKt.HTTP_BAD_REQUEST;
        } else {
            i2 = TypedValues.TransitionType.TYPE_DURATION;
        }
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        FontsContractCompat.FontInfo fontInfo = null;
        int i4 = Integer.MAX_VALUE;
        for (FontsContractCompat.FontInfo fontInfo2 : fontInfoArr) {
            int abs = Math.abs(fontInfo2.getWeight() - i2) * 2;
            if (fontInfo2.isItalic() == z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            int i5 = abs + i3;
            if (fontInfo == null || i4 > i5) {
                fontInfo = fontInfo2;
                i4 = i5;
            }
        }
        return fontInfo;
    }
}
