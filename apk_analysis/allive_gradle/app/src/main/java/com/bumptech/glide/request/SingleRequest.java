package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import p000.ye0;

/* loaded from: classes.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {

    /* renamed from: D */
    public static final boolean f9058D = Log.isLoggable("Request", 2);

    /* renamed from: A */
    public boolean f9059A;

    /* renamed from: B */
    public final RuntimeException f9060B;

    /* renamed from: C */
    public int f9061C;

    /* renamed from: a */
    public final String f9062a;

    /* renamed from: b */
    public final StateVerifier f9063b;

    /* renamed from: c */
    public final Object f9064c;

    /* renamed from: d */
    public final RequestListener f9065d;

    /* renamed from: e */
    public final RequestCoordinator f9066e;

    /* renamed from: f */
    public final Context f9067f;

    /* renamed from: g */
    public final GlideContext f9068g;

    /* renamed from: h */
    public final Object f9069h;

    /* renamed from: i */
    public final Class f9070i;

    /* renamed from: j */
    public final BaseRequestOptions f9071j;

    /* renamed from: k */
    public final int f9072k;

    /* renamed from: l */
    public final int f9073l;

    /* renamed from: m */
    public final Priority f9074m;

    /* renamed from: n */
    public final Target f9075n;

    /* renamed from: o */
    public final List f9076o;

    /* renamed from: p */
    public final TransitionFactory f9077p;

    /* renamed from: q */
    public final Executor f9078q;

    /* renamed from: r */
    public Resource f9079r;

    /* renamed from: s */
    public Engine.LoadStatus f9080s;

    /* renamed from: t */
    public long f9081t;

    /* renamed from: u */
    public volatile Engine f9082u;

    /* renamed from: v */
    public Drawable f9083v;

    /* renamed from: w */
    public Drawable f9084w;

    /* renamed from: x */
    public Drawable f9085x;

    /* renamed from: y */
    public int f9086y;

    /* renamed from: z */
    public int f9087z;

    public SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class cls, BaseRequestOptions baseRequestOptions, int i, int i2, Priority priority, Target target, RequestListener requestListener, List list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory transitionFactory, Executor executor) {
        this.f9062a = f9058D ? String.valueOf(hashCode()) : null;
        this.f9063b = StateVerifier.newInstance();
        this.f9064c = obj;
        this.f9067f = context;
        this.f9068g = glideContext;
        this.f9069h = obj2;
        this.f9070i = cls;
        this.f9071j = baseRequestOptions;
        this.f9072k = i;
        this.f9073l = i2;
        this.f9074m = priority;
        this.f9075n = target;
        this.f9065d = requestListener;
        this.f9076o = list;
        this.f9066e = requestCoordinator;
        this.f9082u = engine;
        this.f9077p = transitionFactory;
        this.f9078q = executor;
        this.f9061C = 1;
        if (this.f9060B == null && glideContext.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class)) {
            this.f9060B = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    /* renamed from: a */
    public final Drawable m2387a() {
        if (this.f9085x == null) {
            BaseRequestOptions baseRequestOptions = this.f9071j;
            Drawable fallbackDrawable = baseRequestOptions.getFallbackDrawable();
            this.f9085x = fallbackDrawable;
            if (fallbackDrawable == null && baseRequestOptions.getFallbackId() > 0) {
                this.f9085x = m2390d(baseRequestOptions.getFallbackId());
            }
        }
        return this.f9085x;
    }

    /* renamed from: b */
    public final Drawable m2388b() {
        if (this.f9084w == null) {
            BaseRequestOptions baseRequestOptions = this.f9071j;
            Drawable placeholderDrawable = baseRequestOptions.getPlaceholderDrawable();
            this.f9084w = placeholderDrawable;
            if (placeholderDrawable == null && baseRequestOptions.getPlaceholderId() > 0) {
                this.f9084w = m2390d(baseRequestOptions.getPlaceholderId());
            }
        }
        return this.f9084w;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.f9064c) {
            try {
                if (!this.f9059A) {
                    this.f9063b.throwIfRecycled();
                    this.f9081t = LogTime.getLogTime();
                    int i = 3;
                    if (this.f9069h == null) {
                        if (Util.isValidDimensions(this.f9072k, this.f9073l)) {
                            this.f9086y = this.f9072k;
                            this.f9087z = this.f9073l;
                        }
                        if (m2387a() == null) {
                            i = 5;
                        }
                        m2392f(new GlideException("Received null model"), i);
                        return;
                    }
                    int i2 = this.f9061C;
                    if (i2 != 2) {
                        boolean z = false;
                        if (i2 == 4) {
                            onResourceReady(this.f9079r, DataSource.MEMORY_CACHE, false);
                            return;
                        }
                        this.f9061C = 3;
                        if (Util.isValidDimensions(this.f9072k, this.f9073l)) {
                            onSizeReady(this.f9072k, this.f9073l);
                        } else {
                            this.f9075n.getSize(this);
                        }
                        int i3 = this.f9061C;
                        if (i3 == 2 || i3 == 3) {
                            RequestCoordinator requestCoordinator = this.f9066e;
                            if (requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this)) {
                                z = true;
                            }
                            if (z) {
                                this.f9075n.onLoadStarted(m2388b());
                            }
                        }
                        if (f9058D) {
                            m2391e("finished run method in " + LogTime.getElapsedMillis(this.f9081t));
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    public final boolean m2389c() {
        RequestCoordinator requestCoordinator = this.f9066e;
        if (requestCoordinator != null && requestCoordinator.getRoot().isAnyResourceSet()) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.f9064c) {
            try {
                if (!this.f9059A) {
                    this.f9063b.throwIfRecycled();
                    if (this.f9061C == 6) {
                        return;
                    }
                    if (!this.f9059A) {
                        this.f9063b.throwIfRecycled();
                        this.f9075n.removeCallback(this);
                        Engine.LoadStatus loadStatus = this.f9080s;
                        Resource<?> resource = null;
                        if (loadStatus != null) {
                            loadStatus.cancel();
                            this.f9080s = null;
                        }
                        Resource<?> resource2 = this.f9079r;
                        if (resource2 != null) {
                            this.f9079r = null;
                            resource = resource2;
                        }
                        RequestCoordinator requestCoordinator = this.f9066e;
                        if (requestCoordinator == null || requestCoordinator.canNotifyCleared(this)) {
                            this.f9075n.onLoadCleared(m2388b());
                        }
                        this.f9061C = 6;
                        if (resource != null) {
                            this.f9082u.release(resource);
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: d */
    public final Drawable m2390d(int i) {
        Resources.Theme theme;
        BaseRequestOptions baseRequestOptions = this.f9071j;
        if (baseRequestOptions.getTheme() != null) {
            theme = baseRequestOptions.getTheme();
        } else {
            theme = this.f9067f.getTheme();
        }
        return DrawableDecoderCompat.getDrawable(this.f9068g, i, theme);
    }

    /* renamed from: e */
    public final void m2391e(String str) {
        StringBuilder m8303w = ye0.m8303w(str, " this: ");
        m8303w.append(this.f9062a);
        Log.v("Request", m8303w.toString());
    }

    /* renamed from: f */
    public final void m2392f(GlideException glideException, int i) {
        boolean z;
        this.f9063b.throwIfRecycled();
        synchronized (this.f9064c) {
            try {
                glideException.setOrigin(this.f9060B);
                int logLevel = this.f9068g.getLogLevel();
                if (logLevel <= i) {
                    Log.w("Glide", "Load failed for " + this.f9069h + " with size [" + this.f9086y + "x" + this.f9087z + "]", glideException);
                    if (logLevel <= 4) {
                        glideException.logRootCauses("Glide");
                    }
                }
                this.f9080s = null;
                this.f9061C = 5;
                boolean z2 = true;
                this.f9059A = true;
                try {
                    List list = this.f9076o;
                    if (list != null) {
                        Iterator it = list.iterator();
                        z = false;
                        while (it.hasNext()) {
                            z |= ((RequestListener) it.next()).onLoadFailed(glideException, this.f9069h, this.f9075n, m2389c());
                        }
                    } else {
                        z = false;
                    }
                    RequestListener requestListener = this.f9065d;
                    if (requestListener == null || !requestListener.onLoadFailed(glideException, this.f9069h, this.f9075n, m2389c())) {
                        z2 = false;
                    }
                    if (!(z | z2)) {
                        m2394h();
                    }
                    this.f9059A = false;
                    RequestCoordinator requestCoordinator = this.f9066e;
                    if (requestCoordinator != null) {
                        requestCoordinator.onRequestFailed(this);
                    }
                } catch (Throwable th) {
                    this.f9059A = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public final void m2393g(Resource resource, Object obj, DataSource dataSource) {
        boolean z;
        boolean m2389c = m2389c();
        this.f9061C = 4;
        this.f9079r = resource;
        if (this.f9068g.getLogLevel() <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + dataSource + " for " + this.f9069h + " with size [" + this.f9086y + "x" + this.f9087z + "] in " + LogTime.getElapsedMillis(this.f9081t) + " ms");
        }
        boolean z2 = true;
        this.f9059A = true;
        try {
            List list = this.f9076o;
            if (list != null) {
                Iterator it = list.iterator();
                z = false;
                while (it.hasNext()) {
                    z |= ((RequestListener) it.next()).onResourceReady(obj, this.f9069h, this.f9075n, dataSource, m2389c);
                }
            } else {
                z = false;
            }
            RequestListener requestListener = this.f9065d;
            if (requestListener == null || !requestListener.onResourceReady(obj, this.f9069h, this.f9075n, dataSource, m2389c)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                this.f9075n.onResourceReady(obj, this.f9077p.build(dataSource, m2389c));
            }
            this.f9059A = false;
            RequestCoordinator requestCoordinator = this.f9066e;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
        } catch (Throwable th) {
            this.f9059A = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public Object getLock() {
        this.f9063b.throwIfRecycled();
        return this.f9064c;
    }

    /* renamed from: h */
    public final void m2394h() {
        Drawable drawable;
        RequestCoordinator requestCoordinator = this.f9066e;
        if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
            return;
        }
        if (this.f9069h == null) {
            drawable = m2387a();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            if (this.f9083v == null) {
                BaseRequestOptions baseRequestOptions = this.f9071j;
                Drawable errorPlaceholder = baseRequestOptions.getErrorPlaceholder();
                this.f9083v = errorPlaceholder;
                if (errorPlaceholder == null && baseRequestOptions.getErrorId() > 0) {
                    this.f9083v = m2390d(baseRequestOptions.getErrorId());
                }
            }
            drawable = this.f9083v;
        }
        if (drawable == null) {
            drawable = m2388b();
        }
        this.f9075n.onLoadFailed(drawable);
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.f9064c) {
            if (this.f9061C == 4) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.f9064c) {
            if (this.f9061C == 6) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.f9064c) {
            if (this.f9061C == 4) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        int i;
        int i2;
        Object obj;
        Class cls;
        BaseRequestOptions baseRequestOptions;
        Priority priority;
        int i3;
        int i4;
        int i5;
        Object obj2;
        Class cls2;
        BaseRequestOptions baseRequestOptions2;
        Priority priority2;
        int i6;
        if (!(request instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f9064c) {
            try {
                i = this.f9072k;
                i2 = this.f9073l;
                obj = this.f9069h;
                cls = this.f9070i;
                baseRequestOptions = this.f9071j;
                priority = this.f9074m;
                List list = this.f9076o;
                if (list != null) {
                    i3 = list.size();
                } else {
                    i3 = 0;
                }
            } finally {
            }
        }
        SingleRequest singleRequest = (SingleRequest) request;
        synchronized (singleRequest.f9064c) {
            try {
                i4 = singleRequest.f9072k;
                i5 = singleRequest.f9073l;
                obj2 = singleRequest.f9069h;
                cls2 = singleRequest.f9070i;
                baseRequestOptions2 = singleRequest.f9071j;
                priority2 = singleRequest.f9074m;
                List list2 = singleRequest.f9076o;
                if (list2 != null) {
                    i6 = list2.size();
                } else {
                    i6 = 0;
                }
            } finally {
            }
        }
        if (i == i4 && i2 == i5 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && i3 == i6) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.f9064c) {
            int i = this.f9061C;
            if (i != 2 && i != 3) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException) {
        m2392f(glideException, 5);
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onResourceReady(Resource<?> resource, DataSource dataSource, boolean z) {
        Object obj;
        String str;
        this.f9063b.throwIfRecycled();
        Resource<?> resource2 = null;
        try {
            synchronized (this.f9064c) {
                try {
                    this.f9080s = null;
                    if (resource == null) {
                        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.f9070i + " inside, but instead got null."));
                        return;
                    }
                    Object obj2 = resource.get();
                    try {
                        if (obj2 != null && this.f9070i.isAssignableFrom(obj2.getClass())) {
                            RequestCoordinator requestCoordinator = this.f9066e;
                            if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
                                this.f9079r = null;
                                this.f9061C = 4;
                                this.f9082u.release(resource);
                                return;
                            }
                            m2393g(resource, obj2, dataSource);
                            return;
                        }
                        this.f9079r = null;
                        StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                        sb.append(this.f9070i);
                        sb.append(" but instead got ");
                        if (obj2 != null) {
                            obj = obj2.getClass();
                        } else {
                            obj = "";
                        }
                        sb.append(obj);
                        sb.append("{");
                        sb.append(obj2);
                        sb.append("} inside Resource{");
                        sb.append(resource);
                        sb.append("}.");
                        if (obj2 != null) {
                            str = "";
                        } else {
                            str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                        }
                        sb.append(str);
                        onLoadFailed(new GlideException(sb.toString()));
                        this.f9082u.release(resource);
                    } catch (Throwable th) {
                        resource2 = resource;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (resource2 != null) {
                this.f9082u.release(resource2);
            }
            throw th3;
        }
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        Object obj;
        int round;
        int i3 = i;
        this.f9063b.throwIfRecycled();
        Object obj2 = this.f9064c;
        synchronized (obj2) {
            try {
                try {
                    boolean z = f9058D;
                    if (z) {
                        m2391e("Got onSizeReady in " + LogTime.getElapsedMillis(this.f9081t));
                    }
                    if (this.f9061C == 3) {
                        this.f9061C = 2;
                        float sizeMultiplier = this.f9071j.getSizeMultiplier();
                        if (i3 != Integer.MIN_VALUE) {
                            i3 = Math.round(i3 * sizeMultiplier);
                        }
                        this.f9086y = i3;
                        if (i2 == Integer.MIN_VALUE) {
                            round = i2;
                        } else {
                            round = Math.round(sizeMultiplier * i2);
                        }
                        this.f9087z = round;
                        if (z) {
                            m2391e("finished setup for calling load in " + LogTime.getElapsedMillis(this.f9081t));
                        }
                        Engine engine = this.f9082u;
                        GlideContext glideContext = this.f9068g;
                        Object obj3 = this.f9069h;
                        Key signature = this.f9071j.getSignature();
                        int i4 = this.f9086y;
                        int i5 = this.f9087z;
                        Class<?> resourceClass = this.f9071j.getResourceClass();
                        Class<R> cls = this.f9070i;
                        Priority priority = this.f9074m;
                        DiskCacheStrategy diskCacheStrategy = this.f9071j.getDiskCacheStrategy();
                        Map<Class<?>, Transformation<?>> transformations = this.f9071j.getTransformations();
                        boolean isTransformationRequired = this.f9071j.isTransformationRequired();
                        BaseRequestOptions baseRequestOptions = this.f9071j;
                        obj = obj2;
                        try {
                            this.f9080s = engine.load(glideContext, obj3, signature, i4, i5, resourceClass, cls, priority, diskCacheStrategy, transformations, isTransformationRequired, baseRequestOptions.f9032y, baseRequestOptions.getOptions(), this.f9071j.isMemoryCacheable(), this.f9071j.getUseUnlimitedSourceGeneratorsPool(), this.f9071j.getUseAnimationPool(), this.f9071j.getOnlyRetrieveFromCache(), this, this.f9078q);
                            if (this.f9061C != 2) {
                                this.f9080s = null;
                            }
                            if (z) {
                                m2391e("finished onSizeReady in " + LogTime.getElapsedMillis(this.f9081t));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.f9064c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
