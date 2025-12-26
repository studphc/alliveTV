package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p000.C0538az;
import p000.C1540m9;
import p000.C1711q4;
import p000.C1748r4;
import p000.RunnableC1213fz;
import p000.dx0;
import p000.f90;
import p000.h72;
import p000.h90;
import p000.i90;
import p000.if2;
import p000.l90;
import p000.m90;
import p000.n90;
import p000.o90;
import p000.p90;
import p000.ye0;

/* loaded from: classes.dex */
public class Engine implements m90, MemoryCache.ResourceRemovedListener, o90 {

    /* renamed from: i */
    public static final boolean f8668i = Log.isLoggable("Engine", 2);

    /* renamed from: a */
    public final C1540m9 f8669a;

    /* renamed from: b */
    public final dx0 f8670b;

    /* renamed from: c */
    public final MemoryCache f8671c;

    /* renamed from: d */
    public final h90 f8672d;

    /* renamed from: e */
    public final if2 f8673e;

    /* renamed from: f */
    public final i90 f8674f;

    /* renamed from: g */
    public final f90 f8675g;

    /* renamed from: h */
    public final C1748r4 f8676h;

    /* loaded from: classes.dex */
    public class LoadStatus {

        /* renamed from: a */
        public final l90 f8677a;

        /* renamed from: b */
        public final ResourceCallback f8678b;

        public LoadStatus(ResourceCallback resourceCallback, l90 l90Var) {
            this.f8678b = resourceCallback;
            this.f8677a = l90Var;
        }

        public void cancel() {
            synchronized (Engine.this) {
                this.f8677a.m5906h(this.f8678b);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r10v6, types: [if2, java.lang.Object] */
    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this.f8671c = memoryCache;
        i90 i90Var = new i90(factory);
        this.f8674f = i90Var;
        C1748r4 c1748r4 = new C1748r4(z);
        this.f8676h = c1748r4;
        synchronized (this) {
            synchronized (c1748r4) {
                c1748r4.f25862e = this;
            }
        }
        this.f8670b = new dx0(12);
        this.f8669a = new C1540m9(15);
        this.f8672d = new h90(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this);
        this.f8675g = new f90(i90Var);
        ?? obj = new Object();
        obj.f18397a = new Handler(Looper.getMainLooper(), new h72(1));
        this.f8673e = obj;
        memoryCache.setResourceRemovedListener(this);
    }

    /* renamed from: b */
    public static void m2314b(String str, long j, n90 n90Var) {
        StringBuilder m8303w = ye0.m8303w(str, " in ");
        m8303w.append(LogTime.getElapsedMillis(j));
        m8303w.append("ms, key: ");
        m8303w.append(n90Var);
        Log.v("Engine", m8303w.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final p90 m2315a(n90 n90Var, boolean z, long j) {
        p90 p90Var;
        p90 p90Var2;
        if (!z) {
            return null;
        }
        C1748r4 c1748r4 = this.f8676h;
        synchronized (c1748r4) {
            C1711q4 c1711q4 = (C1711q4) c1748r4.f25860c.get(n90Var);
            if (c1711q4 == null) {
                p90Var = null;
            } else {
                p90Var = (p90) c1711q4.get();
                if (p90Var == null) {
                    c1748r4.m7216b(c1711q4);
                }
            }
        }
        if (p90Var != null) {
            p90Var.m6891a();
        }
        if (p90Var != null) {
            if (f8668i) {
                m2314b("Loaded resource from active resources", j, n90Var);
            }
            return p90Var;
        }
        Resource<?> remove = this.f8671c.remove(n90Var);
        if (remove == null) {
            p90Var2 = null;
        } else if (remove instanceof p90) {
            p90Var2 = (p90) remove;
        } else {
            p90Var2 = new p90(remove, true, true, n90Var, this);
        }
        if (p90Var2 != null) {
            p90Var2.m6891a();
            this.f8676h.m7215a(n90Var, p90Var2);
        }
        if (p90Var2 == null) {
            return null;
        }
        if (f8668i) {
            m2314b("Loaded resource from cache", j, n90Var);
        }
        return p90Var2;
    }

    /* renamed from: c */
    public final LoadStatus m2316c(GlideContext glideContext, Object obj, Key key, int i, int i2, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor, n90 n90Var, long j) {
        C1540m9 c1540m9 = this.f8669a;
        l90 l90Var = (l90) ((HashMap) (z6 ? c1540m9.f22855c : c1540m9.f22854b)).get(n90Var);
        if (l90Var != null) {
            l90Var.m5899a(resourceCallback, executor);
            if (f8668i) {
                m2314b("Added to existing load", j, n90Var);
            }
            return new LoadStatus(resourceCallback, l90Var);
        }
        l90 l90Var2 = (l90) Preconditions.checkNotNull((l90) this.f8672d.f17986g.acquire());
        synchronized (l90Var2) {
            l90Var2.f22403l = n90Var;
            l90Var2.f22404m = z3;
            l90Var2.f22405n = z4;
            l90Var2.f22406o = z5;
            l90Var2.f22407p = z6;
        }
        f90 f90Var = this.f8675g;
        RunnableC1213fz runnableC1213fz = (RunnableC1213fz) Preconditions.checkNotNull((RunnableC1213fz) f90Var.f17182b.acquire());
        int i3 = f90Var.f17183c;
        f90Var.f17183c = i3 + 1;
        C0538az c0538az = runnableC1213fz.f17455a;
        c0538az.f7800c = glideContext;
        c0538az.f7801d = obj;
        c0538az.f7811n = key;
        c0538az.f7802e = i;
        c0538az.f7803f = i2;
        c0538az.f7813p = diskCacheStrategy;
        c0538az.f7804g = cls;
        c0538az.f7805h = runnableC1213fz.f17458d;
        c0538az.f7808k = cls2;
        c0538az.f7812o = priority;
        c0538az.f7806i = options;
        c0538az.f7807j = map;
        c0538az.f7814q = z;
        c0538az.f7815r = z2;
        runnableC1213fz.f17462h = glideContext;
        runnableC1213fz.f17463i = key;
        runnableC1213fz.f17464j = priority;
        runnableC1213fz.f17465k = n90Var;
        runnableC1213fz.f17466l = i;
        runnableC1213fz.f17467m = i2;
        runnableC1213fz.f17468n = diskCacheStrategy;
        runnableC1213fz.f17473s = z6;
        runnableC1213fz.f17469o = options;
        runnableC1213fz.f17470p = l90Var2;
        runnableC1213fz.f17471q = i3;
        runnableC1213fz.f17454F = 1;
        runnableC1213fz.f17474t = obj;
        C1540m9 c1540m92 = this.f8669a;
        c1540m92.getClass();
        ((HashMap) (l90Var2.f22407p ? c1540m92.f22855c : c1540m92.f22854b)).put(n90Var, l90Var2);
        l90Var2.m5899a(resourceCallback, executor);
        l90Var2.m5907i(runnableC1213fz);
        if (f8668i) {
            m2314b("Started new load", j, n90Var);
        }
        return new LoadStatus(resourceCallback, l90Var2);
    }

    public void clearDiskCache() {
        this.f8674f.m5200a().clear();
    }

    public <R> LoadStatus load(GlideContext glideContext, Object obj, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor) {
        long logTime = f8668i ? LogTime.getLogTime() : 0L;
        this.f8670b.getClass();
        n90 n90Var = new n90(obj, key, i, i2, map, cls, cls2, options);
        synchronized (this) {
            try {
                p90 m2315a = m2315a(n90Var, z3, logTime);
                if (m2315a == null) {
                    return m2316c(glideContext, obj, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, options, z3, z4, z5, z6, resourceCallback, executor, n90Var, logTime);
                }
                resourceCallback.onResourceReady(m2315a, DataSource.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.m90
    public synchronized void onEngineJobCancelled(l90 l90Var, Key key) {
        Object obj;
        C1540m9 c1540m9 = this.f8669a;
        c1540m9.getClass();
        if (l90Var.f22407p) {
            obj = c1540m9.f22855c;
        } else {
            obj = c1540m9.f22854b;
        }
        HashMap hashMap = (HashMap) obj;
        if (l90Var.equals(hashMap.get(key))) {
            hashMap.remove(key);
        }
    }

    @Override // p000.m90
    public synchronized void onEngineJobComplete(l90 l90Var, Key key, p90 p90Var) {
        Object obj;
        if (p90Var != null) {
            try {
                if (p90Var.f25069a) {
                    this.f8676h.m7215a(key, p90Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C1540m9 c1540m9 = this.f8669a;
        c1540m9.getClass();
        if (l90Var.f22407p) {
            obj = c1540m9.f22855c;
        } else {
            obj = c1540m9.f22854b;
        }
        HashMap hashMap = (HashMap) obj;
        if (l90Var.equals(hashMap.get(key))) {
            hashMap.remove(key);
        }
    }

    @Override // p000.o90
    public void onResourceReleased(Key key, p90 p90Var) {
        C1748r4 c1748r4 = this.f8676h;
        synchronized (c1748r4) {
            C1711q4 c1711q4 = (C1711q4) c1748r4.f25860c.remove(key);
            if (c1711q4 != null) {
                c1711q4.f25429c = null;
                c1711q4.clear();
            }
        }
        if (p90Var.f25069a) {
            this.f8671c.put(key, p90Var);
        } else {
            this.f8673e.m5233a(p90Var, false);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(@NonNull Resource<?> resource) {
        this.f8673e.m5233a(resource, true);
    }

    public void release(Resource<?> resource) {
        if (resource instanceof p90) {
            ((p90) resource).m6892b();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    public void shutdown() {
        h90 h90Var = this.f8672d;
        Executors.shutdownAndAwaitTermination(h90Var.f17980a);
        Executors.shutdownAndAwaitTermination(h90Var.f17981b);
        Executors.shutdownAndAwaitTermination(h90Var.f17982c);
        Executors.shutdownAndAwaitTermination(h90Var.f17983d);
        i90 i90Var = this.f8674f;
        synchronized (i90Var) {
            if (i90Var.f18341b != null) {
                i90Var.f18341b.clear();
            }
        }
        C1748r4 c1748r4 = this.f8676h;
        c1748r4.f25863f = true;
        ExecutorService executorService = c1748r4.f25859b;
        if (executorService instanceof ExecutorService) {
            Executors.shutdownAndAwaitTermination(executorService);
        }
    }
}
