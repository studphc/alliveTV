package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ty2 extends vy2 {

    /* renamed from: b */
    public static Class f27029b = null;

    /* renamed from: c */
    public static Constructor f27030c = null;

    /* renamed from: d */
    public static Method f27031d = null;

    /* renamed from: e */
    public static Method f27032e = null;

    /* renamed from: f */
    public static boolean f27033f = false;

    /* renamed from: c */
    public static boolean m7514c(boolean z, String str, int i, Object obj) {
        m7515d();
        try {
            return ((Boolean) f27031d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: d */
    public static void m7515d() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f27033f) {
            return;
        }
        f27033f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        f27030c = constructor;
        f27029b = cls;
        f27031d = method2;
        f27032e = method;
    }

    @Override // p000.vy2
    /* renamed from: a */
    public Typeface mo838a(Context context, Typeface typeface, int i, boolean z) {
        Typeface typeface2;
        try {
            typeface2 = f53.m4773b(typeface, i, z);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        if (typeface2 == null) {
            return super.mo838a(context, typeface, i, z);
        }
        return typeface2;
    }

    @Override // p000.vy2
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        m7515d();
        try {
            Object newInstance = f27030c.newInstance(null);
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
                File tempFile = TypefaceCompatUtil.getTempFile(context);
                if (tempFile == null) {
                    return null;
                }
                try {
                    if (!TypefaceCompatUtil.copyToFile(tempFile, resources, fontFileResourceEntry.getResourceId())) {
                        return null;
                    }
                    if (!m7514c(fontFileResourceEntry.isItalic(), tempFile.getPath(), fontFileResourceEntry.getWeight(), newInstance)) {
                        return null;
                    }
                    tempFile.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    tempFile.delete();
                }
            }
            m7515d();
            try {
                Object newInstance2 = Array.newInstance((Class<?>) f27029b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f27032e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // p000.vy2
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        File file;
        String readlink;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo(fontInfoArr, i).getUri(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                try {
                    readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
                } catch (Throwable th) {
                    try {
                        openFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (ErrnoException unused) {
            }
            try {
                if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                    file = new File(readlink);
                    if (file != null && file.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(file);
                        openFileDescriptor.close();
                        return createFromFile;
                    }
                    FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                    Typeface createFromInputStream = super.createFromInputStream(context, fileInputStream);
                    fileInputStream.close();
                    openFileDescriptor.close();
                    return createFromInputStream;
                }
                Typeface createFromInputStream2 = super.createFromInputStream(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return createFromInputStream2;
            } finally {
            }
            file = null;
            if (file != null) {
                Typeface createFromFile2 = Typeface.createFromFile(file);
                openFileDescriptor.close();
                return createFromFile2;
            }
            FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
        } catch (IOException unused2) {
            return null;
        }
    }
}
