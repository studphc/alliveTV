package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import p000.c21;
import p000.ye0;

/* loaded from: classes.dex */
public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;

    /* renamed from: f */
    public static final Set f8869f;

    /* renamed from: g */
    public static final C0633g f8870g;

    /* renamed from: h */
    public static final Queue f8871h;

    /* renamed from: a */
    public final BitmapPool f8872a;

    /* renamed from: b */
    public final DisplayMetrics f8873b;

    /* renamed from: c */
    public final ArrayPool f8874c;

    /* renamed from: d */
    public final List f8875d;

    /* renamed from: e */
    public final HardwareConfigState f8876e = HardwareConfigState.getInstance();
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);

    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;

    /* loaded from: classes.dex */
    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap);

        void onObtainBounds();
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.bumptech.glide.load.resource.bitmap.g, java.lang.Object] */
    static {
        Boolean bool = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f8869f = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f8870g = new Object();
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f8871h = Util.createQueue(0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f8875d = list;
        this.f8873b = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.f8872a = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.f8874c = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r5;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap m2347c(c21 c21Var, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) {
        if (!options.inJustDecodeBounds) {
            decodeCallbacks.onObtainBounds();
            c21Var.stopGrowingBuffers();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        try {
            try {
                Bitmap decodeBitmap = c21Var.decodeBitmap(options);
                TransformationUtils.getBitmapDrawableLock().unlock();
                return decodeBitmap;
            } catch (IllegalArgumentException e) {
                StringBuilder m8302v = ye0.m8302v("Exception decoding bitmap, outWidth: ", i, ", outHeight: ", i2, ", outMimeType: ");
                m8302v.append(str);
                m8302v.append(", inBitmap: ");
                m8302v.append(m2348d(options.inBitmap));
                IOException iOException = new IOException(m8302v.toString(), e);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOException);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        bitmapPool.put(bitmap);
                        options.inBitmap = null;
                        Bitmap m2347c = m2347c(c21Var, options, decodeCallbacks, bitmapPool);
                        TransformationUtils.getBitmapDrawableLock().unlock();
                        return m2347c;
                    } catch (IOException unused) {
                        throw iOException;
                    }
                }
                throw iOException;
            }
        } catch (Throwable th) {
            TransformationUtils.getBitmapDrawableLock().unlock();
            throw th;
        }
    }

    /* renamed from: d */
    public static String m2348d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    /* renamed from: e */
    public static void m2349e(BitmapFactory.Options options) {
        m2350f(options);
        Queue queue = f8871h;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    /* renamed from: f */
    public static void m2350f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    /* renamed from: a */
    public final BitmapResource m2351a(c21 c21Var, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) {
        BitmapFactory.Options options2;
        BitmapFactory.Options options3;
        boolean z;
        byte[] bArr = (byte[]) this.f8874c.get(65536, byte[].class);
        synchronized (Downsampler.class) {
            Queue queue = f8871h;
            synchronized (queue) {
                options2 = (BitmapFactory.Options) queue.poll();
            }
            if (options2 == null) {
                options2 = new BitmapFactory.Options();
                m2350f(options2);
            }
            options3 = options2;
        }
        options3.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        boolean booleanValue = ((Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> option = ALLOW_HARDWARE_CONFIG;
        if (options.get(option) != null && ((Boolean) options.get(option)).booleanValue()) {
            z = true;
        } else {
            z = false;
        }
        try {
            return BitmapResource.obtain(m2352b(c21Var, options3, downsampleStrategy, decodeFormat, preferredColorSpace, z, i, i2, booleanValue, decodeCallbacks), this.f8872a);
        } finally {
            m2349e(options3);
            this.f8874c.put(bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x04d0  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap m2352b(c21 c21Var, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) {
        int i3;
        int i4;
        String str;
        String str2;
        BitmapPool bitmapPool;
        int i5;
        int i6;
        String str3;
        String str4;
        int i7;
        int i8;
        int i9;
        Downsampler downsampler;
        boolean z3;
        int i10;
        boolean z4;
        boolean z5;
        int i11;
        String str5;
        int i12;
        int i13;
        BitmapPool bitmapPool2;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        Bitmap m2347c;
        boolean z6;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        Bitmap.Config config;
        Bitmap.Config config2;
        Bitmap.Config config3;
        String str6;
        String str7;
        int i14;
        int i15;
        int min;
        int i16;
        int i17;
        int floor;
        double floor2;
        int i18;
        DownsampleStrategy downsampleStrategy2;
        int i19;
        int i20;
        long logTime = LogTime.getLogTime();
        options.inJustDecodeBounds = true;
        BitmapPool bitmapPool3 = this.f8872a;
        m2347c(c21Var, options, decodeCallbacks, bitmapPool3);
        options.inJustDecodeBounds = false;
        int[] iArr = {options.outWidth, options.outHeight};
        int i21 = iArr[0];
        int i22 = iArr[1];
        String str8 = options.outMimeType;
        boolean z7 = (i21 == -1 || i22 == -1) ? false : z;
        int imageOrientation = c21Var.getImageOrientation();
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(imageOrientation);
        if (i == Integer.MIN_VALUE) {
            if (exifOrientationDegrees != 90) {
                i3 = 270;
                if (exifOrientationDegrees != 270) {
                    i4 = i21;
                }
            } else {
                i3 = 270;
            }
            i4 = i22;
        } else {
            i3 = 270;
            i4 = i;
        }
        int i23 = i2 == Integer.MIN_VALUE ? (exifOrientationDegrees == 90 || exifOrientationDegrees == i3) ? i21 : i22 : i2;
        ImageHeaderParser.ImageType imageType = c21Var.getImageType();
        boolean z8 = z7;
        if (i21 <= 0 || i22 <= 0) {
            str = "x";
            str2 = ", target density: ";
            bitmapPool = bitmapPool3;
            i5 = i22;
            i6 = 2;
            str3 = ", density: ";
            str4 = "Downsampler";
            i7 = i23;
            i8 = i21;
            i9 = i4;
            if (Log.isLoggable(str4, 3)) {
                Log.d(str4, "Unable to determine dimensions for: " + imageType + " with target [" + i9 + str + i7 + "]");
            }
            downsampler = this;
        } else {
            if (exifOrientationDegrees == 90 || exifOrientationDegrees == 270) {
                str6 = ", density: ";
                str7 = "]";
                i14 = i22;
                i15 = i21;
            } else {
                str6 = ", density: ";
                str7 = "]";
                i15 = i22;
                i14 = i21;
            }
            int i24 = i4;
            float scaleFactor = downsampleStrategy.getScaleFactor(i14, i15, i24, i23);
            if (scaleFactor > RecyclerView.f7068F0) {
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i14, i15, i24, i23);
                if (sampleSizeRounding != null) {
                    float f = i14;
                    float f2 = i15;
                    int i25 = i14 / ((int) ((scaleFactor * f) + 0.5d));
                    int i26 = i15 / ((int) ((scaleFactor * f2) + 0.5d));
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    if (sampleSizeRounding == sampleSizeRounding2) {
                        min = Math.max(i25, i26);
                    } else {
                        min = Math.min(i25, i26);
                    }
                    int i27 = Build.VERSION.SDK_INT;
                    if (i27 <= 23) {
                        i16 = i23;
                        if (f8869f.contains(options.outMimeType)) {
                            i17 = 1;
                            options.inSampleSize = i17;
                            if (imageType != ImageHeaderParser.ImageType.JPEG) {
                                float min2 = Math.min(i17, 8);
                                floor = (int) Math.ceil(f / min2);
                                i18 = (int) Math.ceil(f2 / min2);
                                int i28 = i17 / 8;
                                if (i28 > 0) {
                                    floor /= i28;
                                    i18 /= i28;
                                }
                            } else {
                                if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                                    if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                                        if (i27 >= 24) {
                                            float f3 = i17;
                                            floor = Math.round(f / f3);
                                            i18 = Math.round(f2 / f3);
                                        } else {
                                            float f4 = i17;
                                            floor = (int) Math.floor(f / f4);
                                            floor2 = Math.floor(f2 / f4);
                                        }
                                    } else if (i14 % i17 == 0 && i15 % i17 == 0) {
                                        floor = i14 / i17;
                                        i18 = i15 / i17;
                                    } else {
                                        options.inJustDecodeBounds = true;
                                        m2347c(c21Var, options, decodeCallbacks, bitmapPool3);
                                        options.inJustDecodeBounds = false;
                                        int[] iArr2 = {options.outWidth, options.outHeight};
                                        int i29 = iArr2[0];
                                        i18 = iArr2[1];
                                        downsampleStrategy2 = downsampleStrategy;
                                        floor = i29;
                                        i9 = i24;
                                        i7 = i16;
                                        double scaleFactor2 = downsampleStrategy2.getScaleFactor(floor, i18, i9, i7);
                                        bitmapPool = bitmapPool3;
                                        options.inTargetDensity = (int) (((scaleFactor2 / (r14 / r12)) * ((int) ((((int) Math.round((scaleFactor2 <= 1.0d ? scaleFactor2 : 1.0d / scaleFactor2) * 2.147483647E9d)) * scaleFactor2) + 0.5d))) + 0.5d);
                                        int round = (int) Math.round((scaleFactor2 <= 1.0d ? scaleFactor2 : 1.0d / scaleFactor2) * 2.147483647E9d);
                                        options.inDensity = round;
                                        i19 = options.inTargetDensity;
                                        if (i19 <= 0 && round > 0 && i19 != round) {
                                            options.inScaled = true;
                                        } else {
                                            options.inTargetDensity = 0;
                                            options.inDensity = 0;
                                        }
                                        str4 = "Downsampler";
                                        i6 = 2;
                                        if (!Log.isLoggable(str4, 2)) {
                                            str3 = str6;
                                            str2 = ", target density: ";
                                            str = "x";
                                            i5 = i22;
                                            i20 = i21;
                                        } else {
                                            str = "x";
                                            i5 = i22;
                                            i20 = i21;
                                            StringBuilder m8302v = ye0.m8302v("Calculate scaling, source: [", i20, str, i5, "], degreesToRotate: ");
                                            m8302v.append(exifOrientationDegrees);
                                            m8302v.append(", target: [");
                                            m8302v.append(i9);
                                            m8302v.append(str);
                                            m8302v.append(i7);
                                            m8302v.append("], power of two scaled: [");
                                            m8302v.append(floor);
                                            m8302v.append(str);
                                            m8302v.append(i18);
                                            m8302v.append("], exact scale factor: ");
                                            m8302v.append(scaleFactor);
                                            m8302v.append(", power of 2 sample size: ");
                                            m8302v.append(i17);
                                            m8302v.append(", adjusted scale factor: ");
                                            m8302v.append(scaleFactor2);
                                            str2 = ", target density: ";
                                            m8302v.append(str2);
                                            m8302v.append(options.inTargetDensity);
                                            str3 = str6;
                                            m8302v.append(str3);
                                            m8302v.append(options.inDensity);
                                            Log.v(str4, m8302v.toString());
                                        }
                                        downsampler = this;
                                        i8 = i20;
                                    }
                                } else {
                                    float f5 = i17;
                                    floor = (int) Math.floor(f / f5);
                                    floor2 = Math.floor(f2 / f5);
                                }
                                i18 = (int) floor2;
                            }
                            downsampleStrategy2 = downsampleStrategy;
                            i9 = i24;
                            i7 = i16;
                            double scaleFactor22 = downsampleStrategy2.getScaleFactor(floor, i18, i9, i7);
                            bitmapPool = bitmapPool3;
                            options.inTargetDensity = (int) (((scaleFactor22 / (r14 / r12)) * ((int) ((((int) Math.round((scaleFactor22 <= 1.0d ? scaleFactor22 : 1.0d / scaleFactor22) * 2.147483647E9d)) * scaleFactor22) + 0.5d))) + 0.5d);
                            int round2 = (int) Math.round((scaleFactor22 <= 1.0d ? scaleFactor22 : 1.0d / scaleFactor22) * 2.147483647E9d);
                            options.inDensity = round2;
                            i19 = options.inTargetDensity;
                            if (i19 <= 0) {
                            }
                            options.inTargetDensity = 0;
                            options.inDensity = 0;
                            str4 = "Downsampler";
                            i6 = 2;
                            if (!Log.isLoggable(str4, 2)) {
                            }
                            downsampler = this;
                            i8 = i20;
                        }
                    } else {
                        i16 = i23;
                    }
                    int max = Math.max(1, Integer.highestOneBit(min));
                    if (sampleSizeRounding == sampleSizeRounding2 && max < 1.0f / scaleFactor) {
                        max <<= 1;
                    }
                    i17 = max;
                    options.inSampleSize = i17;
                    if (imageType != ImageHeaderParser.ImageType.JPEG) {
                    }
                    downsampleStrategy2 = downsampleStrategy;
                    i9 = i24;
                    i7 = i16;
                    double scaleFactor222 = downsampleStrategy2.getScaleFactor(floor, i18, i9, i7);
                    bitmapPool = bitmapPool3;
                    options.inTargetDensity = (int) (((scaleFactor222 / (r14 / r12)) * ((int) ((((int) Math.round((scaleFactor222 <= 1.0d ? scaleFactor222 : 1.0d / scaleFactor222) * 2.147483647E9d)) * scaleFactor222) + 0.5d))) + 0.5d);
                    int round22 = (int) Math.round((scaleFactor222 <= 1.0d ? scaleFactor222 : 1.0d / scaleFactor222) * 2.147483647E9d);
                    options.inDensity = round22;
                    i19 = options.inTargetDensity;
                    if (i19 <= 0) {
                    }
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                    str4 = "Downsampler";
                    i6 = 2;
                    if (!Log.isLoggable(str4, 2)) {
                    }
                    downsampler = this;
                    i8 = i20;
                } else {
                    throw new IllegalArgumentException("Cannot round with null rounding");
                }
            } else {
                throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy + ", source: [" + i21 + "x" + i22 + "], target: [" + i24 + "x" + i23 + str7);
            }
        }
        boolean isHardwareConfigAllowed = downsampler.f8876e.isHardwareConfigAllowed(i9, i7, z8, isExifOrientationRequired);
        if (isHardwareConfigAllowed) {
            config3 = Bitmap.Config.HARDWARE;
            options.inPreferredConfig = config3;
            z3 = false;
            options.inMutable = false;
        } else {
            z3 = false;
        }
        if (!isHardwareConfigAllowed) {
            i10 = i6;
            if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                try {
                    z4 = c21Var.getImageType().hasAlpha();
                } catch (IOException e) {
                    if (Log.isLoggable(str4, 3)) {
                        Log.d(str4, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
                    }
                    z4 = z3;
                }
                Bitmap.Config config4 = z4 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                options.inPreferredConfig = config4;
                if (config4 == Bitmap.Config.RGB_565) {
                    z5 = true;
                    options.inDither = true;
                }
            } else {
                z5 = true;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            i11 = Build.VERSION.SDK_INT;
            if (i8 >= 0 || i5 < 0 || !z2) {
                int i30 = options.inTargetDensity;
                float f6 = (i30 > 0 || (i13 = options.inDensity) <= 0 || i30 == i13) ? z3 : z5 ? i30 / options.inDensity : 1.0f;
                int i31 = options.inSampleSize;
                float f7 = i31;
                String str9 = str4;
                int ceil = (int) Math.ceil(i8 / f7);
                int ceil2 = (int) Math.ceil(i5 / f7);
                int round3 = Math.round(ceil * f6);
                int round4 = Math.round(ceil2 * f6);
                str5 = str9;
                if (Log.isLoggable(str5, i10)) {
                    StringBuilder m8302v2 = ye0.m8302v("Calculated target [", round3, str, round4, "] for source [");
                    m8302v2.append(i8);
                    m8302v2.append(str);
                    m8302v2.append(i5);
                    m8302v2.append("], sampleSize: ");
                    m8302v2.append(i31);
                    m8302v2.append(", targetDensity: ");
                    m8302v2.append(options.inTargetDensity);
                    m8302v2.append(str3);
                    m8302v2.append(options.inDensity);
                    m8302v2.append(", density multiplier: ");
                    m8302v2.append(f6);
                    Log.v(str5, m8302v2.toString());
                }
                i9 = round3;
                i12 = round4;
            } else {
                str5 = str4;
                i12 = i7;
            }
            Bitmap bitmap = null;
            if (i9 > 0 && i12 > 0) {
                if (i11 < 26) {
                    Bitmap.Config config5 = options.inPreferredConfig;
                    config2 = Bitmap.Config.HARDWARE;
                    if (config5 != config2) {
                        config = options.outConfig;
                    }
                } else {
                    config = null;
                }
                if (config == null) {
                    config = options.inPreferredConfig;
                }
                bitmapPool2 = bitmapPool;
                options.inBitmap = bitmapPool2.getDirty(i9, i12, config);
                if (i11 < 28) {
                    if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3) {
                        colorSpace3 = options.outColorSpace;
                        if (colorSpace3 != null) {
                            colorSpace4 = options.outColorSpace;
                            isWideGamut = colorSpace4.isWideGamut();
                            if (isWideGamut) {
                                z6 = true;
                                colorSpace2 = ColorSpace.get(!z6 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
                                options.inPreferredColorSpace = colorSpace2;
                            }
                        }
                    }
                    z6 = false;
                    colorSpace2 = ColorSpace.get(!z6 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
                    options.inPreferredColorSpace = colorSpace2;
                } else if (i11 >= 26) {
                    named = ColorSpace.Named.SRGB;
                    colorSpace = ColorSpace.get(named);
                    options.inPreferredColorSpace = colorSpace;
                }
                String str10 = str;
                int i32 = i5;
                m2347c = m2347c(c21Var, options, decodeCallbacks, bitmapPool2);
                decodeCallbacks.onDecodeComplete(bitmapPool2, m2347c);
                if (Log.isLoggable(str5, i10)) {
                    Log.v(str5, "Decoded " + m2348d(m2347c) + " from [" + i8 + str10 + i32 + "] " + str8 + " with inBitmap " + m2348d(options.inBitmap) + " for [" + i + str10 + i2 + "], sample size: " + options.inSampleSize + str3 + options.inDensity + str2 + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(logTime));
                }
                if (m2347c != null) {
                    m2347c.setDensity(downsampler.f8873b.densityDpi);
                    bitmap = TransformationUtils.rotateImageExif(bitmapPool2, m2347c, imageOrientation);
                    if (!m2347c.equals(bitmap)) {
                        bitmapPool2.put(m2347c);
                    }
                }
                return bitmap;
            }
            bitmapPool2 = bitmapPool;
            if (i11 < 28) {
            }
            String str102 = str;
            int i322 = i5;
            m2347c = m2347c(c21Var, options, decodeCallbacks, bitmapPool2);
            decodeCallbacks.onDecodeComplete(bitmapPool2, m2347c);
            if (Log.isLoggable(str5, i10)) {
            }
            if (m2347c != null) {
            }
            return bitmap;
        }
        i10 = i6;
        z5 = true;
        i11 = Build.VERSION.SDK_INT;
        if (i8 >= 0) {
        }
        int i302 = options.inTargetDensity;
        float f62 = (i302 > 0 || (i13 = options.inDensity) <= 0 || i302 == i13) ? z3 : z5 ? i302 / options.inDensity : 1.0f;
        int i312 = options.inSampleSize;
        float f72 = i312;
        String str92 = str4;
        int ceil3 = (int) Math.ceil(i8 / f72);
        int ceil22 = (int) Math.ceil(i5 / f72);
        int round32 = Math.round(ceil3 * f62);
        int round42 = Math.round(ceil22 * f62);
        str5 = str92;
        if (Log.isLoggable(str5, i10)) {
        }
        i9 = round32;
        i12 = round42;
        Bitmap bitmap2 = null;
        if (i9 > 0) {
            if (i11 < 26) {
            }
            if (config == null) {
            }
            bitmapPool2 = bitmapPool;
            options.inBitmap = bitmapPool2.getDirty(i9, i12, config);
            if (i11 < 28) {
            }
            String str1022 = str;
            int i3222 = i5;
            m2347c = m2347c(c21Var, options, decodeCallbacks, bitmapPool2);
            decodeCallbacks.onDecodeComplete(bitmapPool2, m2347c);
            if (Log.isLoggable(str5, i10)) {
            }
            if (m2347c != null) {
            }
            return bitmap2;
        }
        bitmapPool2 = bitmapPool;
        if (i11 < 28) {
        }
        String str10222 = str;
        int i32222 = i5;
        m2347c = m2347c(c21Var, options, decodeCallbacks, bitmapPool2);
        decodeCallbacks.onDecodeComplete(bitmapPool2, m2347c);
        if (Log.isLoggable(str5, i10)) {
        }
        if (m2347c != null) {
        }
        return bitmap2;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) {
        return decode(inputStream, i, i2, options, f8870g);
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public Resource<Bitmap> decode(final InputStream inputStream, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) {
        final List list = this.f8875d;
        final ArrayPool arrayPool = this.f8874c;
        return m2351a(new c21(list, inputStream, arrayPool) { // from class: com.bumptech.glide.load.resource.bitmap.ImageReader$InputStreamImageReader

            /* renamed from: a */
            public final InputStreamRewinder f8894a;

            /* renamed from: b */
            public final ArrayPool f8895b;

            /* renamed from: c */
            public final List f8896c;

            {
                this.f8895b = (ArrayPool) Preconditions.checkNotNull(arrayPool);
                this.f8896c = (List) Preconditions.checkNotNull(list);
                this.f8894a = new InputStreamRewinder(inputStream, arrayPool);
            }

            @Override // p000.c21
            @Nullable
            public Bitmap decodeBitmap(BitmapFactory.Options options2) {
                return BitmapFactory.decodeStream(this.f8894a.rewindAndGet(), null, options2);
            }

            @Override // p000.c21
            public int getImageOrientation() {
                return ImageHeaderParserUtils.getOrientation((List<ImageHeaderParser>) this.f8896c, this.f8894a.rewindAndGet(), this.f8895b);
            }

            @Override // p000.c21
            public ImageHeaderParser.ImageType getImageType() {
                return ImageHeaderParserUtils.getType((List<ImageHeaderParser>) this.f8896c, this.f8894a.rewindAndGet(), this.f8895b);
            }

            @Override // p000.c21
            public void stopGrowingBuffers() {
                this.f8894a.fixMarkLimits();
            }
        }, i, i2, options, decodeCallbacks);
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    @RequiresApi(21)
    public Resource<Bitmap> decode(final ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) {
        final List list = this.f8875d;
        final ArrayPool arrayPool = this.f8874c;
        return m2351a(new c21(parcelFileDescriptor, list, arrayPool) { // from class: com.bumptech.glide.load.resource.bitmap.ImageReader$ParcelFileDescriptorImageReader

            /* renamed from: a */
            public final ArrayPool f8897a;

            /* renamed from: b */
            public final List f8898b;

            /* renamed from: c */
            public final ParcelFileDescriptorRewinder f8899c;

            {
                this.f8897a = (ArrayPool) Preconditions.checkNotNull(arrayPool);
                this.f8898b = (List) Preconditions.checkNotNull(list);
                this.f8899c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
            }

            @Override // p000.c21
            @Nullable
            public Bitmap decodeBitmap(BitmapFactory.Options options2) {
                return BitmapFactory.decodeFileDescriptor(this.f8899c.rewindAndGet().getFileDescriptor(), null, options2);
            }

            @Override // p000.c21
            public int getImageOrientation() {
                return ImageHeaderParserUtils.getOrientation((List<ImageHeaderParser>) this.f8898b, this.f8899c, this.f8897a);
            }

            @Override // p000.c21
            public ImageHeaderParser.ImageType getImageType() {
                return ImageHeaderParserUtils.getType((List<ImageHeaderParser>) this.f8898b, this.f8899c, this.f8897a);
            }

            @Override // p000.c21
            public void stopGrowingBuffers() {
            }
        }, i, i2, options, f8870g);
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }
}
