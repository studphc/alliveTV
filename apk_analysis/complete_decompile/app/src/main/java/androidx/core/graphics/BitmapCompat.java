package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.AbstractC1510lg;
import p000.AbstractC1547mg;

/* loaded from: classes.dex */
public final class BitmapCompat {
    /* renamed from: a */
    public static int m824a(int i, int i2, int i3, int i4) {
        return i3 == 0 ? i2 : i3 > 0 ? i * (1 << (i4 - i3)) : i2 << ((-i3) - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x01a9, code lost:
    
        if (p000.AbstractC1510lg.m5925c(r11) == false) goto L124;
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap createScaledBitmap(@NonNull Bitmap bitmap, int i, int i2, @Nullable Rect rect, boolean z) {
        Bitmap bitmap2;
        int width;
        int height;
        int i3;
        int i4;
        Paint paint;
        double floor;
        double floor2;
        Paint paint2;
        Bitmap bitmap3;
        int i5;
        boolean z2;
        boolean z3;
        Rect rect2;
        Bitmap bitmap4;
        int i6;
        int i7;
        boolean z4;
        int i8;
        int i9;
        if (i > 0 && i2 > 0) {
            if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
                throw new IllegalArgumentException("srcRect must be contained by srcBm!");
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 27) {
                bitmap2 = AbstractC1510lg.m5923a(bitmap);
            } else {
                bitmap2 = bitmap;
            }
            if (rect != null) {
                width = rect.width();
            } else {
                width = bitmap.getWidth();
            }
            if (rect != null) {
                height = rect.height();
            } else {
                height = bitmap.getHeight();
            }
            float f = i / width;
            float f2 = i2 / height;
            if (rect != null) {
                i3 = rect.left;
            } else {
                i3 = 0;
            }
            if (rect != null) {
                i4 = rect.top;
            } else {
                i4 = 0;
            }
            if (i3 == 0 && i4 == 0 && i == bitmap.getWidth() && i2 == bitmap.getHeight()) {
                if (bitmap.isMutable() && bitmap == bitmap2) {
                    return bitmap.copy(bitmap.getConfig(), true);
                }
                return bitmap2;
            }
            Paint paint3 = new Paint(1);
            paint3.setFilterBitmap(true);
            if (i10 >= 29) {
                AbstractC1547mg.m6145a(paint3);
            } else {
                paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            }
            if (width == i && height == i2) {
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap2.getConfig());
                new Canvas(createBitmap).drawBitmap(bitmap2, -i3, -i4, paint3);
                return createBitmap;
            }
            double log = Math.log(2.0d);
            if (f > 1.0f) {
                paint = paint3;
                floor = Math.ceil(Math.log(f) / log);
            } else {
                paint = paint3;
                floor = Math.floor(Math.log(f) / log);
            }
            int i11 = (int) floor;
            if (f2 > 1.0f) {
                floor2 = Math.ceil(Math.log(f2) / log);
            } else {
                floor2 = Math.floor(Math.log(f2) / log);
            }
            int i12 = (int) floor2;
            if (z && i10 >= 27 && !AbstractC1510lg.m5925c(bitmap)) {
                if (i11 > 0) {
                    i8 = m824a(width, i, 1, i11);
                } else {
                    i8 = width;
                }
                if (i12 > 0) {
                    i9 = m824a(height, i2, 1, i12);
                } else {
                    i9 = height;
                }
                Bitmap m5924b = AbstractC1510lg.m5924b(i8, i9, bitmap, true);
                paint2 = paint;
                new Canvas(m5924b).drawBitmap(bitmap2, -i3, -i4, paint2);
                i5 = 1;
                i4 = 0;
                i3 = 0;
                bitmap3 = bitmap2;
                bitmap2 = m5924b;
            } else {
                paint2 = paint;
                bitmap3 = null;
                i5 = 0;
            }
            Rect rect3 = new Rect(i3, i4, width, height);
            Rect rect4 = new Rect();
            int i13 = i11;
            int i14 = i12;
            while (true) {
                if (i13 == 0 && i14 == 0) {
                    break;
                }
                if (i13 < 0) {
                    i13++;
                } else if (i13 > 0) {
                    i13--;
                }
                if (i14 < 0) {
                    i14++;
                } else if (i14 > 0) {
                    i14--;
                }
                int i15 = i14;
                Paint paint4 = paint2;
                Rect rect5 = rect3;
                rect4.set(0, 0, m824a(width, i, i13, i11), m824a(height, i2, i15, i12));
                if (i13 == 0 && i15 == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (bitmap3 != null && bitmap3.getWidth() == i && bitmap3.getHeight() == i2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (bitmap3 != null && bitmap3 != bitmap) {
                    if (z) {
                        rect2 = rect4;
                        if (Build.VERSION.SDK_INT >= 27) {
                        }
                    } else {
                        rect2 = rect4;
                    }
                    if (!z2 || (z3 && i5 == 0)) {
                        bitmap4 = bitmap3;
                        Rect rect6 = rect2;
                        new Canvas(bitmap4).drawBitmap(bitmap2, rect5, rect6, paint4);
                        rect5.set(rect6);
                        i14 = i15;
                        Bitmap bitmap5 = bitmap2;
                        bitmap2 = bitmap4;
                        rect4 = rect6;
                        rect3 = rect5;
                        paint2 = paint4;
                        bitmap3 = bitmap5;
                    }
                } else {
                    rect2 = rect4;
                }
                if (bitmap3 != bitmap && bitmap3 != null) {
                    bitmap3.recycle();
                }
                if (i13 > 0) {
                    i6 = i5;
                } else {
                    i6 = i13;
                }
                int m824a = m824a(width, i, i6, i11);
                if (i15 > 0) {
                    i7 = i5;
                } else {
                    i7 = i15;
                }
                int m824a2 = m824a(height, i2, i7, i12);
                if (Build.VERSION.SDK_INT >= 27) {
                    if (z && !z2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    bitmap4 = AbstractC1510lg.m5924b(m824a, m824a2, bitmap, z4);
                } else {
                    bitmap4 = Bitmap.createBitmap(m824a, m824a2, bitmap2.getConfig());
                }
                Rect rect62 = rect2;
                new Canvas(bitmap4).drawBitmap(bitmap2, rect5, rect62, paint4);
                rect5.set(rect62);
                i14 = i15;
                Bitmap bitmap52 = bitmap2;
                bitmap2 = bitmap4;
                rect4 = rect62;
                rect3 = rect5;
                paint2 = paint4;
                bitmap3 = bitmap52;
            }
            if (bitmap3 != bitmap && bitmap3 != null) {
                bitmap3.recycle();
            }
            return bitmap2;
        }
        throw new IllegalArgumentException("dstW and dstH must be > 0!");
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z) {
        bitmap.setHasMipMap(z);
    }
}
