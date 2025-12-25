package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class e53 {

    /* renamed from: a */
    public static final Field f16676a;

    /* renamed from: b */
    public static final LongSparseArray f16677b;

    /* renamed from: c */
    public static final Object f16678c;

    static {
        Field field;
        try {
            field = Typeface.class.getDeclaredField("native_instance");
            field.setAccessible(true);
        } catch (Exception e) {
            Log.e("WeightTypeface", e.getClass().getName(), e);
            field = null;
        }
        f16676a = field;
        f16677b = new LongSparseArray(3);
        f16678c = new Object();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00bc  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface m4660a(vy2 vy2Var, Context context, Typeface typeface, int i, boolean z) {
        FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry;
        Typeface createFromResourcesFontFile;
        int i2;
        boolean z2;
        int i3;
        Field field = f16676a;
        if (field != null) {
            int i4 = (i << 1) | (z ? 1 : 0);
            synchronized (f16678c) {
                try {
                    try {
                        long longValue = ((Number) field.get(typeface)).longValue();
                        LongSparseArray longSparseArray = f16677b;
                        SparseArray sparseArray = (SparseArray) longSparseArray.get(longValue);
                        if (sparseArray == null) {
                            sparseArray = new SparseArray(4);
                            longSparseArray.put(longValue, sparseArray);
                        } else {
                            Typeface typeface2 = (Typeface) sparseArray.get(i4);
                            if (typeface2 != null) {
                                return typeface2;
                            }
                        }
                        vy2Var.getClass();
                        long m7953b = vy2.m7953b(typeface);
                        if (m7953b == 0) {
                            fontFamilyFilesResourceEntry = null;
                        } else {
                            fontFamilyFilesResourceEntry = (FontResourcesParserCompat.FontFamilyFilesResourceEntry) vy2Var.f28013a.get(Long.valueOf(m7953b));
                        }
                        if (fontFamilyFilesResourceEntry != null) {
                            Resources resources = context.getResources();
                            int i5 = Integer.MAX_VALUE;
                            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = null;
                            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry2 : fontFamilyFilesResourceEntry.getEntries()) {
                                int abs = Math.abs(fontFileResourceEntry2.getWeight() - i) * 2;
                                if (fontFileResourceEntry2.isItalic() == z) {
                                    i2 = 0;
                                } else {
                                    i2 = 1;
                                }
                                int i6 = abs + i2;
                                if (fontFileResourceEntry == null || i5 > i6) {
                                    i5 = i6;
                                    fontFileResourceEntry = fontFileResourceEntry2;
                                }
                            }
                            if (fontFileResourceEntry != null) {
                                createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, fontFileResourceEntry.getResourceId(), fontFileResourceEntry.getFileName(), 0, 0);
                                long m7953b2 = vy2.m7953b(createFromResourcesFontFile);
                                if (m7953b2 != 0) {
                                    vy2Var.f28013a.put(Long.valueOf(m7953b2), fontFamilyFilesResourceEntry);
                                }
                                if (createFromResourcesFontFile == null) {
                                    if (i >= 600) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2 && !z) {
                                        i3 = 0;
                                    } else if (!z2) {
                                        i3 = 2;
                                    } else if (!z) {
                                        i3 = 1;
                                    } else {
                                        i3 = 3;
                                    }
                                    createFromResourcesFontFile = Typeface.create(typeface, i3);
                                }
                                sparseArray.put(i4, createFromResourcesFontFile);
                                return createFromResourcesFontFile;
                            }
                        }
                        createFromResourcesFontFile = null;
                        if (createFromResourcesFontFile == null) {
                        }
                        sparseArray.put(i4, createFromResourcesFontFile);
                        return createFromResourcesFontFile;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return null;
    }
}
