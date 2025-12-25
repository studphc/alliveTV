package p000;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/* renamed from: pg */
/* loaded from: classes.dex */
public final class RunnableC1686pg implements Runnable {

    /* renamed from: i */
    public static final wd0 f25149i = new wd0(6);

    /* renamed from: j */
    public static final long f25150j = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: a */
    public final BitmapPool f25151a;

    /* renamed from: b */
    public final MemoryCache f25152b;

    /* renamed from: c */
    public final fa0 f25153c;

    /* renamed from: d */
    public final wd0 f25154d;

    /* renamed from: e */
    public final HashSet f25155e;

    /* renamed from: f */
    public final Handler f25156f;

    /* renamed from: g */
    public long f25157g;

    /* renamed from: h */
    public boolean f25158h;

    public RunnableC1686pg(BitmapPool bitmapPool, MemoryCache memoryCache, fa0 fa0Var) {
        wd0 wd0Var = f25149i;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f25155e = new HashSet();
        this.f25157g = 40L;
        this.f25151a = bitmapPool;
        this.f25152b = memoryCache;
        this.f25153c = fa0Var;
        this.f25154d = wd0Var;
        this.f25156f = handler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.bumptech.glide.load.Key, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        fa0 fa0Var;
        int size;
        Bitmap createBitmap;
        this.f25154d.getClass();
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        while (true) {
            fa0Var = this.f25153c;
            if (fa0Var.f17188b != 0 && SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis < 32) {
                ArrayList arrayList = (ArrayList) fa0Var.f17187a;
                PreFillType preFillType = (PreFillType) arrayList.get(fa0Var.f17189c);
                HashMap hashMap = (HashMap) fa0Var.f17190d;
                Integer num = (Integer) hashMap.get(preFillType);
                if (num.intValue() == 1) {
                    hashMap.remove(preFillType);
                    arrayList.remove(fa0Var.f17189c);
                } else {
                    hashMap.put(preFillType, Integer.valueOf(num.intValue() - 1));
                }
                fa0Var.f17188b--;
                if (arrayList.isEmpty()) {
                    size = 0;
                } else {
                    size = (fa0Var.f17189c + 1) % arrayList.size();
                }
                fa0Var.f17189c = size;
                HashSet hashSet = this.f25155e;
                boolean contains = hashSet.contains(preFillType);
                BitmapPool bitmapPool = this.f25151a;
                if (!contains) {
                    hashSet.add(preFillType);
                    createBitmap = bitmapPool.getDirty(preFillType.f8767a, preFillType.f8768b, preFillType.f8769c);
                } else {
                    createBitmap = Bitmap.createBitmap(preFillType.f8767a, preFillType.f8768b, preFillType.f8769c);
                }
                int bitmapByteSize = Util.getBitmapByteSize(createBitmap);
                MemoryCache memoryCache = this.f25152b;
                if (memoryCache.getMaxSize() - memoryCache.getCurrentSize() >= bitmapByteSize) {
                    memoryCache.put(new Object(), BitmapResource.obtain(createBitmap, bitmapPool));
                } else {
                    bitmapPool.put(createBitmap);
                }
                if (Log.isLoggable("PreFillRunner", 3)) {
                    Log.d("PreFillRunner", "allocated [" + preFillType.f8767a + "x" + preFillType.f8768b + "] " + preFillType.f8769c + " size: " + bitmapByteSize);
                }
            }
        }
        if (!this.f25158h && fa0Var.f17188b != 0) {
            long j = this.f25157g;
            this.f25157g = Math.min(4 * j, f25150j);
            this.f25156f.postDelayed(this, j);
        }
    }
}
