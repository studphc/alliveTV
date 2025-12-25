package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p000.lv2;
import p000.mv2;
import p000.tx0;

/* loaded from: classes.dex */
public final class TransformationUtils {
    public static final int PAINT_FLAGS = 6;

    /* renamed from: a */
    public static final Paint f8918a = new Paint(6);

    /* renamed from: b */
    public static final Paint f8919b = new Paint(7);

    /* renamed from: c */
    public static final Paint f8920c;

    /* renamed from: d */
    public static final Lock f8921d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.concurrent.locks.Lock] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    static {
        ?? r0;
        if (new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079")).contains(Build.MODEL)) {
            r0 = new ReentrantLock();
        } else {
            r0 = new Object();
        }
        f8921d = r0;
        Paint paint = new Paint(7);
        f8920c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    /* renamed from: a */
    public static void m2355a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = f8921d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f8918a);
            canvas.setBitmap(null);
        } finally {
            lock.unlock();
        }
    }

    /* renamed from: b */
    public static Bitmap m2356b(BitmapPool bitmapPool, Bitmap bitmap) {
        Bitmap.Config m2357c = m2357c(bitmap);
        if (m2357c.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), m2357c);
        new Canvas(bitmap2).drawBitmap(bitmap, RecyclerView.f7068F0, RecyclerView.f7068F0, (Paint) null);
        return bitmap2;
    }

    /* renamed from: c */
    public static Bitmap.Config m2357c(Bitmap bitmap) {
        Bitmap.Config config;
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.RGBA_F16;
            if (config.equals(bitmap.getConfig())) {
                config2 = Bitmap.Config.RGBA_F16;
                return config2;
            }
        }
        return Bitmap.Config.ARGB_8888;
    }

    public static Bitmap centerCrop(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        Bitmap.Config config;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int width2 = bitmap.getWidth() * i2;
        int height2 = bitmap.getHeight() * i;
        float f = RecyclerView.f7068F0;
        if (width2 > height2) {
            width = i2 / bitmap.getHeight();
            f = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = bitmapPool.get(i, i2, config);
        setAlpha(bitmap, bitmap2);
        m2355a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Bitmap centerInside(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return fitCenter(bitmapPool, bitmap, i, i2);
    }

    public static Bitmap circleCrop(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        float f = min;
        float f2 = f / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f / width, f / height);
        float f3 = width * max;
        float f4 = max * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap m2356b = m2356b(bitmapPool, bitmap);
        Bitmap bitmap2 = bitmapPool.get(min, min, m2357c(bitmap));
        bitmap2.setHasAlpha(true);
        Lock lock = f8921d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawCircle(f2, f2, f2, f8919b);
            canvas.drawBitmap(m2356b, (Rect) null, rectF, f8920c);
            canvas.setBitmap(null);
            lock.unlock();
            if (!m2356b.equals(bitmap)) {
                bitmapPool.put(m2356b);
            }
            return bitmap2;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    /* renamed from: d */
    public static Bitmap m2358d(BitmapPool bitmapPool, Bitmap bitmap, mv2 mv2Var) {
        Bitmap.Config m2357c = m2357c(bitmap);
        Bitmap m2356b = m2356b(bitmapPool, bitmap);
        Bitmap bitmap2 = bitmapPool.get(m2356b.getWidth(), m2356b.getHeight(), m2357c);
        bitmap2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(m2356b, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(RecyclerView.f7068F0, RecyclerView.f7068F0, bitmap2.getWidth(), bitmap2.getHeight());
        Lock lock = f8921d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            mv2Var.mo5987b(canvas, paint, rectF);
            canvas.setBitmap(null);
            lock.unlock();
            if (!m2356b.equals(bitmap)) {
                bitmapPool.put(m2356b);
            }
            return bitmap2;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public static Bitmap fitCenter(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        Bitmap.Config config;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        int width = (int) (bitmap.getWidth() * min);
        int height = (int) (bitmap.getHeight() * min);
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = bitmapPool.get(width, height, config);
        setAlpha(bitmap, bitmap2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmap2.getWidth() + "x" + bitmap2.getHeight());
            StringBuilder sb = new StringBuilder("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        m2355a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Lock getBitmapDrawableLock() {
        return f8921d;
    }

    public static int getExifOrientationDegrees(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static boolean isExifOrientationRequired(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap rotateImage(@NonNull Bitmap bitmap, int i) {
        if (i != 0) {
            try {
                Matrix matrix = new Matrix();
                matrix.setRotate(i);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e) {
                if (Log.isLoggable("TransformationUtils", 6)) {
                    Log.e("TransformationUtils", "Exception when trying to orient image", e);
                    return bitmap;
                }
                return bitmap;
            }
        }
        return bitmap;
    }

    public static Bitmap rotateImageExif(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i) {
        Bitmap.Config config;
        if (!isExifOrientationRequired(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        RectF rectF = new RectF(RecyclerView.f7068F0, RecyclerView.f7068F0, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = bitmapPool.get(round, round2, config);
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmap2.setHasAlpha(bitmap.hasAlpha());
        m2355a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    @Deprecated
    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2, int i3) {
        return roundedCorners(bitmapPool, bitmap, i3);
    }

    public static void setAlpha(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i) {
        Preconditions.checkArgument(i > 0, "roundingRadius must be greater than 0.");
        return m2358d(bitmapPool, bitmap, new tx0(i));
    }

    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, float f, float f2, float f3, float f4) {
        return m2358d(bitmapPool, bitmap, new lv2(f, f2, f3, f4));
    }
}
