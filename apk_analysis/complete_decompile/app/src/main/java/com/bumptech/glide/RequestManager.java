package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.nb2;
import p000.ob2;
import p000.sn1;

/* loaded from: classes.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener {

    /* renamed from: j */
    public static final RequestOptions f8530j = RequestOptions.decodeTypeOf(Bitmap.class).lock();

    /* renamed from: k */
    public static final RequestOptions f8531k = RequestOptions.decodeTypeOf(GifDrawable.class).lock();

    /* renamed from: l */
    public static final RequestOptions f8532l = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);

    /* renamed from: a */
    public final Lifecycle f8533a;

    /* renamed from: b */
    public final RequestTracker f8534b;

    /* renamed from: c */
    public final RequestManagerTreeNode f8535c;
    protected final Context context;

    /* renamed from: d */
    public final TargetTracker f8536d;

    /* renamed from: e */
    public final sn1 f8537e;

    /* renamed from: f */
    public final ConnectivityMonitor f8538f;

    /* renamed from: g */
    public final CopyOnWriteArrayList f8539g;
    protected final Glide glide;

    /* renamed from: h */
    public RequestOptions f8540h;

    /* renamed from: i */
    public boolean f8541i;

    public RequestManager(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        RequestTracker requestTracker = new RequestTracker();
        ConnectivityMonitorFactory connectivityMonitorFactory = glide.f8459h;
        this.f8536d = new TargetTracker();
        sn1 sn1Var = new sn1(6, this);
        this.f8537e = sn1Var;
        this.glide = glide;
        this.f8533a = lifecycle;
        this.f8535c = requestManagerTreeNode;
        this.f8534b = requestTracker;
        this.context = context;
        ConnectivityMonitor build = connectivityMonitorFactory.build(context.getApplicationContext(), new ob2(this, requestTracker));
        this.f8538f = build;
        if (Util.isOnBackgroundThread()) {
            Util.postOnUiThread(sn1Var);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
        this.f8539g = new CopyOnWriteArrayList(glide.f8455d.getDefaultRequestListeners());
        setRequestOptions(glide.f8455d.getDefaultRequestOptions());
        synchronized (glide.f8460i) {
            try {
                if (!glide.f8460i.contains(this)) {
                    glide.f8460i.add(this);
                } else {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final synchronized boolean m2283a(Target target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (this.f8534b.clearAndRemove(request)) {
            this.f8536d.untrack(target);
            target.setRequest(null);
            return true;
        }
        return false;
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> requestListener) {
        this.f8539g.add(requestListener);
        return this;
    }

    @NonNull
    public synchronized RequestManager applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        m2285b(requestOptions);
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: as */
    public <ResourceType> RequestBuilder<ResourceType> mo2284as(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        return mo2284as(Bitmap.class).apply((BaseRequestOptions<?>) f8530j);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        return mo2284as(Drawable.class);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> asFile() {
        return mo2284as(File.class).apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        return mo2284as(GifDrawable.class).apply((BaseRequestOptions<?>) f8531k);
    }

    /* renamed from: b */
    public final synchronized void m2285b(RequestOptions requestOptions) {
        this.f8540h = this.f8540h.apply(requestOptions);
    }

    public void clear(@NonNull View view) {
        clear(new nb2(view, 0));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> download(@Nullable Object obj) {
        return downloadOnly().mo8491load(obj);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        return mo2284as(File.class).apply((BaseRequestOptions<?>) f8532l);
    }

    public synchronized boolean isPaused() {
        return this.f8534b.isPaused();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        try {
            this.f8536d.onDestroy();
            Iterator<Target<?>> it = this.f8536d.getAll().iterator();
            while (it.hasNext()) {
                clear(it.next());
            }
            this.f8536d.clear();
            this.f8534b.clearRequests();
            this.f8533a.removeListener(this);
            this.f8533a.removeListener(this.f8538f);
            Util.removeCallbacksOnUiThread(this.f8537e);
            this.glide.m2274d(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        resumeRequests();
        this.f8536d.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        pauseRequests();
        this.f8536d.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.f8541i) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        this.f8534b.pauseAllRequests();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        Iterator<RequestManager> it = this.f8535c.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.f8534b.pauseRequests();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        Iterator<RequestManager> it = this.f8535c.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.f8534b.resumeRequests();
    }

    public synchronized void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        Iterator<RequestManager> it = this.f8535c.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    @NonNull
    public synchronized RequestManager setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.f8541i = z;
    }

    public synchronized void setRequestOptions(@NonNull RequestOptions requestOptions) {
        this.f8540h = requestOptions.mo8485clone().autoClone();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f8534b + ", treeNode=" + this.f8535c + "}";
    }

    public void clear(@Nullable Target<?> target) {
        if (target == null) {
            return;
        }
        boolean m2283a = m2283a(target);
        Request request = target.getRequest();
        if (m2283a) {
            return;
        }
        Glide glide = this.glide;
        synchronized (glide.f8460i) {
            try {
                Iterator it = glide.f8460i.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((RequestManager) it.next()).m2283a(target)) {
                        }
                    } else if (request != null) {
                        target.setRequest(null);
                        request.clear();
                    }
                }
            } finally {
            }
        }
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> mo8495load(@Nullable Bitmap bitmap) {
        return asDrawable().mo8486load(bitmap);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> mo8496load(@Nullable Drawable drawable) {
        return asDrawable().mo8487load(drawable);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> mo8501load(@Nullable String str) {
        return asDrawable().mo8492load(str);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> mo8497load(@Nullable Uri uri) {
        return asDrawable().mo8488load(uri);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> mo8498load(@Nullable File file) {
        return asDrawable().mo8489load(file);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> mo8499load(@Nullable @DrawableRes @RawRes Integer num) {
        return asDrawable().mo8490load(num);
    }

    @Override // 
    @CheckResult
    @Deprecated
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> mo8502load(@Nullable URL url) {
        return asDrawable().mo8493load(url);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> mo8503load(@Nullable byte[] bArr) {
        return asDrawable().mo8494load(bArr);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> mo8500load(@Nullable Object obj) {
        return asDrawable().mo8491load(obj);
    }
}
