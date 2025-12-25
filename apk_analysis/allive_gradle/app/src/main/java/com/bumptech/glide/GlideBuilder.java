package com.bumptech.glide;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p000.C1785s4;
import p000.dx0;

/* loaded from: classes.dex */
public final class GlideBuilder {

    /* renamed from: c */
    public Engine f8466c;

    /* renamed from: d */
    public BitmapPool f8467d;

    /* renamed from: e */
    public ArrayPool f8468e;

    /* renamed from: f */
    public MemoryCache f8469f;

    /* renamed from: g */
    public GlideExecutor f8470g;

    /* renamed from: h */
    public GlideExecutor f8471h;

    /* renamed from: i */
    public DiskCache.Factory f8472i;

    /* renamed from: j */
    public MemorySizeCalculator f8473j;

    /* renamed from: k */
    public ConnectivityMonitorFactory f8474k;

    /* renamed from: n */
    public RequestManagerRetriever.RequestManagerFactory f8477n;

    /* renamed from: o */
    public GlideExecutor f8478o;

    /* renamed from: p */
    public boolean f8479p;

    /* renamed from: q */
    public List f8480q;

    /* renamed from: a */
    public final ArrayMap f8464a = new ArrayMap();

    /* renamed from: b */
    public final C1785s4 f8465b = new C1785s4(1);

    /* renamed from: l */
    public int f8475l = 4;

    /* renamed from: m */
    public Glide.RequestOptionsFactory f8476m = new Object();

    /* loaded from: classes.dex */
    public static final class LogRequestOrigins {
    }

    /* loaded from: classes.dex */
    public static final class WaitForFramesAfterTrimMemory {
    }

    @NonNull
    public GlideBuilder addGlobalRequestListener(@NonNull RequestListener<Object> requestListener) {
        if (this.f8480q == null) {
            this.f8480q = new ArrayList();
        }
        this.f8480q.add(requestListener);
        return this;
    }

    @NonNull
    public GlideBuilder setAnimationExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f8478o = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setArrayPool(@Nullable ArrayPool arrayPool) {
        this.f8468e = arrayPool;
        return this;
    }

    @NonNull
    public GlideBuilder setBitmapPool(@Nullable BitmapPool bitmapPool) {
        this.f8467d = bitmapPool;
        return this;
    }

    @NonNull
    public GlideBuilder setConnectivityMonitorFactory(@Nullable ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.f8474k = connectivityMonitorFactory;
        return this;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@Nullable RequestOptions requestOptions) {
        return setDefaultRequestOptions(new C0603b(requestOptions));
    }

    @NonNull
    public <T> GlideBuilder setDefaultTransitionOptions(@NonNull Class<T> cls, @Nullable TransitionOptions<?, T> transitionOptions) {
        this.f8464a.put(cls, transitionOptions);
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCache(@Nullable DiskCache.Factory factory) {
        this.f8472i = factory;
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCacheExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f8471h = glideExecutor;
        return this;
    }

    public GlideBuilder setImageDecoderEnabledForBitmaps(boolean z) {
        boolean z2;
        dx0 dx0Var = new dx0(0);
        if (z && Build.VERSION.SDK_INT >= 29) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = this.f8465b.f26232a;
        if (z2) {
            hashMap.put(dx0.class, dx0Var);
        } else {
            hashMap.remove(dx0.class);
        }
        return this;
    }

    @NonNull
    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean z) {
        this.f8479p = z;
        return this;
    }

    @NonNull
    public GlideBuilder setLogLevel(int i) {
        if (i >= 2 && i <= 6) {
            this.f8475l = i;
            return this;
        }
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    public GlideBuilder setLogRequestOrigins(boolean z) {
        LogRequestOrigins logRequestOrigins = new LogRequestOrigins();
        HashMap hashMap = this.f8465b.f26232a;
        if (z) {
            hashMap.put(LogRequestOrigins.class, logRequestOrigins);
        } else {
            hashMap.remove(LogRequestOrigins.class);
        }
        return this;
    }

    @NonNull
    public GlideBuilder setMemoryCache(@Nullable MemoryCache memoryCache) {
        this.f8469f = memoryCache;
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@NonNull MemorySizeCalculator.Builder builder) {
        return setMemorySizeCalculator(builder.build());
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(@Nullable GlideExecutor glideExecutor) {
        return setSourceExecutor(glideExecutor);
    }

    @NonNull
    public GlideBuilder setSourceExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f8470g = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@NonNull Glide.RequestOptionsFactory requestOptionsFactory) {
        this.f8476m = (Glide.RequestOptionsFactory) Preconditions.checkNotNull(requestOptionsFactory);
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@Nullable MemorySizeCalculator memorySizeCalculator) {
        this.f8473j = memorySizeCalculator;
        return this;
    }
}
