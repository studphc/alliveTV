package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p000.dx0;

/* loaded from: classes.dex */
public class LruBitmapPool implements BitmapPool {

    /* renamed from: k */
    public static final Bitmap.Config f8697k = Bitmap.Config.ARGB_8888;

    /* renamed from: a */
    public final SizeConfigStrategy f8698a;

    /* renamed from: b */
    public final Set f8699b;

    /* renamed from: c */
    public final long f8700c;

    /* renamed from: d */
    public final dx0 f8701d;

    /* renamed from: e */
    public long f8702e;

    /* renamed from: f */
    public long f8703f;

    /* renamed from: g */
    public int f8704g;

    /* renamed from: h */
    public int f8705h;

    /* renamed from: i */
    public int f8706i;

    /* renamed from: j */
    public int f8707j;

    public LruBitmapPool(long j, SizeConfigStrategy sizeConfigStrategy, Set set) {
        this.f8700c = j;
        this.f8702e = j;
        this.f8698a = sizeConfigStrategy;
        this.f8699b = set;
        this.f8701d = new dx0(19);
    }

    /* renamed from: a */
    public final void m2326a() {
        Log.v("LruBitmapPool", "Hits=" + this.f8704g + ", misses=" + this.f8705h + ", puts=" + this.f8706i + ", evictions=" + this.f8707j + ", currentSize=" + this.f8703f + ", maxSize=" + this.f8702e + "\nStrategy=" + this.f8698a);
    }

    /* renamed from: b */
    public final synchronized Bitmap m2327b(int i, int i2, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3;
        Bitmap bitmap;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                config2 = Bitmap.Config.HARDWARE;
                if (config == config2) {
                    throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
                }
            }
            SizeConfigStrategy sizeConfigStrategy = this.f8698a;
            if (config != null) {
                config3 = config;
            } else {
                config3 = f8697k;
            }
            bitmap = sizeConfigStrategy.get(i, i2, config3);
            if (bitmap == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f8698a.logBitmap(i, i2, config));
                }
                this.f8705h++;
            } else {
                this.f8704g++;
                this.f8703f -= this.f8698a.getSize(bitmap);
                this.f8701d.getClass();
                bitmap.setHasAlpha(true);
                bitmap.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f8698a.logBitmap(i, i2, config));
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                m2326a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmap;
    }

    /* renamed from: c */
    public final synchronized void m2328c(long j) {
        while (this.f8703f > j) {
            try {
                Bitmap removeLast = this.f8698a.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        m2326a();
                    }
                    this.f8703f = 0L;
                    return;
                }
                this.f8701d.getClass();
                this.f8703f -= this.f8698a.getSize(removeLast);
                this.f8707j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f8698a.logBitmap(removeLast));
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    m2326a();
                }
                removeLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m2328c(0L);
    }

    public long evictionCount() {
        return this.f8707j;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Bitmap m2327b = m2327b(i, i2, config);
        if (m2327b != null) {
            m2327b.eraseColor(0);
            return m2327b;
        }
        if (config == null) {
            config = f8697k;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    public long getCurrentSize() {
        return this.f8703f;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        Bitmap m2327b = m2327b(i, i2, config);
        if (m2327b == null) {
            if (config == null) {
                config = f8697k;
            }
            return Bitmap.createBitmap(i, i2, config);
        }
        return m2327b;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.f8702e;
    }

    public long hitCount() {
        return this.f8704g;
    }

    public long missCount() {
        return this.f8705h;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f8698a.getSize(bitmap) <= this.f8702e && this.f8699b.contains(bitmap.getConfig())) {
                        int size = this.f8698a.getSize(bitmap);
                        this.f8698a.put(bitmap);
                        this.f8701d.getClass();
                        this.f8706i++;
                        this.f8703f += size;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f8698a.logBitmap(bitmap));
                        }
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            m2326a();
                        }
                        m2328c(this.f8702e);
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f8698a.logBitmap(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f8699b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f) {
        long round = Math.round(((float) this.f8700c) * f);
        this.f8702e = round;
        m2328c(round);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i < 40 && i < 20) {
            if (i >= 20 || i == 15) {
                m2328c(getMaxSize() / 2);
                return;
            }
            return;
        }
        clearMemory();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LruBitmapPool(long j) {
        this(j, r0, Collections.unmodifiableSet(r1));
        Bitmap.Config config;
        SizeConfigStrategy sizeConfigStrategy = new SizeConfigStrategy();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
    }

    public LruBitmapPool(long j, Set<Bitmap.Config> set) {
        this(j, new SizeConfigStrategy(), set);
    }
}
