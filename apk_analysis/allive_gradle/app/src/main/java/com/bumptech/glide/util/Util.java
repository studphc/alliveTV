package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.Model;
import com.google.common.base.Ascii;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import p000.a13;

/* loaded from: classes.dex */
public final class Util {

    /* renamed from: a */
    public static final char[] f9180a = "0123456789abcdef".toCharArray();

    /* renamed from: b */
    public static final char[] f9181b = new char[64];

    /* renamed from: c */
    public static volatile Handler f9182c;

    /* renamed from: a */
    public static Handler m2399a() {
        if (f9182c == null) {
            synchronized (Util.class) {
                try {
                    if (f9182c == null) {
                        f9182c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f9182c;
    }

    public static void assertBackgroundThread() {
        if (isOnBackgroundThread()) {
        } else {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void assertMainThread() {
        if (isOnMainThread()) {
        } else {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean bothModelsNullEquivalentOrEquals(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        if (obj instanceof Model) {
            return ((Model) obj).isEquivalentTo(obj2);
        }
        return obj.equals(obj2);
    }

    public static boolean bothNullOrEqual(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    @NonNull
    public static <T> Queue<T> createQueue(int i) {
        return new ArrayDeque(i);
    }

    @TargetApi(19)
    public static int getBitmapByteSize(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    @Deprecated
    public static int getSize(@NonNull Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }

    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static int hashCode(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    public static boolean isOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static boolean isValidDimensions(int i, int i2) {
        return (i > 0 || i == Integer.MIN_VALUE) && (i2 > 0 || i2 == Integer.MIN_VALUE);
    }

    public static void postOnUiThread(Runnable runnable) {
        m2399a().post(runnable);
    }

    public static void removeCallbacksOnUiThread(Runnable runnable) {
        m2399a().removeCallbacks(runnable);
    }

    @NonNull
    public static String sha256BytesToHex(@NonNull byte[] bArr) {
        String str;
        char[] cArr = f9181b;
        synchronized (cArr) {
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                int i2 = i * 2;
                char[] cArr2 = f9180a;
                cArr[i2] = cArr2[(b & 255) >>> 4];
                cArr[i2 + 1] = cArr2[b & Ascii.f14464SI];
            }
            str = new String(cArr);
        }
        return str;
    }

    public static int hashCode(int i) {
        return hashCode(i, 17);
    }

    public static int hashCode(float f) {
        return hashCode(f, 17);
    }

    public static int hashCode(float f, int i) {
        return hashCode(Float.floatToIntBits(f), i);
    }

    public static int hashCode(@Nullable Object obj, int i) {
        return hashCode(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int hashCode(boolean z, int i) {
        return hashCode(z ? 1 : 0, i);
    }

    public static int hashCode(boolean z) {
        return hashCode(z, 17);
    }

    public static int getBitmapByteSize(int i, int i2, @Nullable Bitmap.Config config) {
        int i3 = i * i2;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i4 = a13.f22a[config.ordinal()];
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            if (i4 != 2 && i4 != 3) {
                i5 = 4;
                if (i4 == 4) {
                    i5 = 8;
                }
            }
        }
        return i3 * i5;
    }
}
