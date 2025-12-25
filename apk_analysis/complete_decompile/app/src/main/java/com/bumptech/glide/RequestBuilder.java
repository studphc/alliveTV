package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import p000.kb2;

/* loaded from: classes.dex */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable {
    protected static final RequestOptions DOWNLOAD_ONLY_OPTIONS = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);

    /* renamed from: A */
    public final Context f8516A;

    /* renamed from: B */
    public final RequestManager f8517B;

    /* renamed from: C */
    public final Class f8518C;

    /* renamed from: D */
    public final Glide f8519D;

    /* renamed from: E */
    public final GlideContext f8520E;

    /* renamed from: F */
    public TransitionOptions f8521F;

    /* renamed from: G */
    public Object f8522G;

    /* renamed from: H */
    public ArrayList f8523H;

    /* renamed from: I */
    public RequestBuilder f8524I;

    /* renamed from: J */
    public RequestBuilder f8525J;

    /* renamed from: K */
    public Float f8526K;

    /* renamed from: L */
    public boolean f8527L;

    /* renamed from: M */
    public boolean f8528M;

    /* renamed from: N */
    public boolean f8529N;

    @SuppressLint({"CheckResult"})
    public RequestBuilder(@NonNull Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        RequestOptions requestOptions;
        this.f8527L = true;
        this.f8519D = glide;
        this.f8517B = requestManager;
        this.f8518C = cls;
        this.f8516A = context;
        this.f8521F = requestManager.glide.f8455d.getDefaultTransitionOptions(cls);
        this.f8520E = glide.f8455d;
        Iterator it = requestManager.f8539g.iterator();
        while (it.hasNext()) {
            addListener((RequestListener) it.next());
        }
        synchronized (requestManager) {
            requestOptions = requestManager.f8540h;
        }
        apply((BaseRequestOptions<?>) requestOptions);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        if (isAutoCloneEnabled()) {
            return mo8485clone().addListener(requestListener);
        }
        if (requestListener != null) {
            if (this.f8523H == null) {
                this.f8523H = new ArrayList();
            }
            this.f8523H.add(requestListener);
        }
        return selfOrThrowIfLocked();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ BaseRequestOptions apply(@NonNull BaseRequestOptions baseRequestOptions) {
        return apply((BaseRequestOptions<?>) baseRequestOptions);
    }

    @CheckResult
    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(@NonNull Y y) {
        return (Y) getDownloadOnlyRequest().into((RequestBuilder<File>) y);
    }

    @NonNull
    public RequestBuilder<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        if (isAutoCloneEnabled()) {
            return mo8485clone().error((RequestBuilder) requestBuilder);
        }
        this.f8525J = requestBuilder;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public final Request m2278g(int i, int i2, Priority priority, TransitionOptions transitionOptions, BaseRequestOptions baseRequestOptions, RequestCoordinator requestCoordinator, RequestFutureTarget requestFutureTarget, Target target, Object obj, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        RequestCoordinator requestCoordinator2;
        SingleRequest m2282k;
        TransitionOptions transitionOptions2;
        Priority m2279h;
        if (this.f8525J != null) {
            requestCoordinator2 = new ErrorRequestCoordinator(obj, requestCoordinator);
            errorRequestCoordinator = requestCoordinator2;
        } else {
            errorRequestCoordinator = 0;
            requestCoordinator2 = requestCoordinator;
        }
        RequestBuilder requestBuilder = this.f8524I;
        if (requestBuilder != null) {
            if (!this.f8529N) {
                TransitionOptions transitionOptions3 = requestBuilder.f8521F;
                if (requestBuilder.f8527L) {
                    transitionOptions2 = transitionOptions;
                } else {
                    transitionOptions2 = transitionOptions3;
                }
                if (requestBuilder.isPrioritySet()) {
                    m2279h = this.f8524I.getPriority();
                } else {
                    m2279h = m2279h(priority);
                }
                Priority priority2 = m2279h;
                int overrideWidth = this.f8524I.getOverrideWidth();
                int overrideHeight = this.f8524I.getOverrideHeight();
                if (Util.isValidDimensions(i, i2) && !this.f8524I.isValidOverride()) {
                    overrideWidth = baseRequestOptions.getOverrideWidth();
                    overrideHeight = baseRequestOptions.getOverrideHeight();
                }
                ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(obj, requestCoordinator2);
                ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = thumbnailRequestCoordinator;
                SingleRequest m2282k2 = m2282k(i, i2, priority, transitionOptions, baseRequestOptions, thumbnailRequestCoordinator, requestFutureTarget, target, obj, executor);
                this.f8529N = true;
                RequestBuilder requestBuilder2 = this.f8524I;
                Request m2278g = requestBuilder2.m2278g(overrideWidth, overrideHeight, priority2, transitionOptions2, requestBuilder2, thumbnailRequestCoordinator2, requestFutureTarget, target, obj, executor);
                this.f8529N = false;
                thumbnailRequestCoordinator2.setRequests(m2282k2, m2278g);
                m2282k = thumbnailRequestCoordinator2;
            } else {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
        } else if (this.f8526K != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator3 = new ThumbnailRequestCoordinator(obj, requestCoordinator2);
            thumbnailRequestCoordinator3.setRequests(m2282k(i, i2, priority, transitionOptions, baseRequestOptions, thumbnailRequestCoordinator3, requestFutureTarget, target, obj, executor), m2282k(i, i2, m2279h(priority), transitionOptions, baseRequestOptions.mo8485clone().sizeMultiplier(this.f8526K.floatValue()), thumbnailRequestCoordinator3, requestFutureTarget, target, obj, executor));
            m2282k = thumbnailRequestCoordinator3;
        } else {
            m2282k = m2282k(i, i2, priority, transitionOptions, baseRequestOptions, requestCoordinator2, requestFutureTarget, target, obj, executor);
        }
        if (errorRequestCoordinator == 0) {
            return m2282k;
        }
        int overrideWidth2 = this.f8525J.getOverrideWidth();
        int overrideHeight2 = this.f8525J.getOverrideHeight();
        if (Util.isValidDimensions(i, i2) && !this.f8525J.isValidOverride()) {
            overrideWidth2 = baseRequestOptions.getOverrideWidth();
            overrideHeight2 = baseRequestOptions.getOverrideHeight();
        }
        int i3 = overrideHeight2;
        int i4 = overrideWidth2;
        RequestBuilder requestBuilder3 = this.f8525J;
        errorRequestCoordinator.setRequests(m2282k, requestBuilder3.m2278g(i4, i3, requestBuilder3.getPriority(), requestBuilder3.f8521F, this.f8525J, errorRequestCoordinator, requestFutureTarget, target, obj, executor));
        return errorRequestCoordinator;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> getDownloadOnlyRequest() {
        return new RequestBuilder(File.class, this).apply((BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    /* renamed from: h */
    public final Priority m2279h(Priority priority) {
        int i = kb2.f20815b[priority.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3 && i != 4) {
                    throw new IllegalArgumentException("unknown priority: " + getPriority());
                }
                return Priority.IMMEDIATE;
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    /* renamed from: i */
    public final void m2280i(Target target, RequestFutureTarget requestFutureTarget, BaseRequestOptions baseRequestOptions, Executor executor) {
        Preconditions.checkNotNull(target);
        if (this.f8528M) {
            Object obj = new Object();
            TransitionOptions transitionOptions = this.f8521F;
            Request m2278g = m2278g(baseRequestOptions.getOverrideWidth(), baseRequestOptions.getOverrideHeight(), baseRequestOptions.getPriority(), transitionOptions, baseRequestOptions, null, requestFutureTarget, target, obj, executor);
            Request request = target.getRequest();
            if (m2278g.isEquivalentTo(request) && (baseRequestOptions.isMemoryCacheable() || !request.isComplete())) {
                if (!((Request) Preconditions.checkNotNull(request)).isRunning()) {
                    request.begin();
                    return;
                }
                return;
            } else {
                this.f8517B.clear((Target<?>) target);
                target.setRequest(m2278g);
                RequestManager requestManager = this.f8517B;
                synchronized (requestManager) {
                    requestManager.f8536d.track(target);
                    requestManager.f8534b.runRequest(m2278g);
                }
                return;
            }
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y into(@NonNull Y y) {
        m2280i(y, null, this, Executors.mainThreadExecutor());
        return y;
    }

    /* renamed from: j */
    public final RequestBuilder m2281j(Object obj) {
        if (isAutoCloneEnabled()) {
            return mo8485clone().m2281j(obj);
        }
        this.f8522G = obj;
        this.f8528M = true;
        return selfOrThrowIfLocked();
    }

    /* renamed from: k */
    public final SingleRequest m2282k(int i, int i2, Priority priority, TransitionOptions transitionOptions, BaseRequestOptions baseRequestOptions, RequestCoordinator requestCoordinator, RequestFutureTarget requestFutureTarget, Target target, Object obj, Executor executor) {
        Object obj2 = this.f8522G;
        ArrayList arrayList = this.f8523H;
        GlideContext glideContext = this.f8520E;
        return SingleRequest.obtain(this.f8516A, glideContext, obj, obj2, this.f8518C, baseRequestOptions, i, i2, priority, target, requestFutureTarget, arrayList, requestCoordinator, glideContext.getEngine(), transitionOptions.f8542a, executor);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        if (isAutoCloneEnabled()) {
            return mo8485clone().listener(requestListener);
        }
        this.f8523H = null;
        return addListener(requestListener);
    }

    @NonNull
    public Target<TranscodeType> preload(int i, int i2) {
        return into((RequestBuilder<TranscodeType>) PreloadTarget.obtain(this.f8517B, i, i2));
    }

    @NonNull
    public FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        if (isAutoCloneEnabled()) {
            return mo8485clone().thumbnail(requestBuilder);
        }
        this.f8524I = requestBuilder;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        if (isAutoCloneEnabled()) {
            return mo8485clone().transition(transitionOptions);
        }
        this.f8521F = (TransitionOptions) Preconditions.checkNotNull(transitionOptions);
        this.f8527L = false;
        return selfOrThrowIfLocked();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        Preconditions.checkNotNull(baseRequestOptions);
        return (RequestBuilder) super.apply(baseRequestOptions);
    }

    @CheckResult
    @Deprecated
    public FutureTarget<File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().submit(i, i2);
    }

    @NonNull
    public FutureTarget<TranscodeType> submit(int i, int i2) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i, i2);
        m2280i(requestFutureTarget, requestFutureTarget, this, Executors.directExecutor());
        return requestFutureTarget;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8485clone() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.mo8485clone();
        requestBuilder.f8521F = requestBuilder.f8521F.m8504clone();
        if (requestBuilder.f8523H != null) {
            requestBuilder.f8523H = new ArrayList(requestBuilder.f8523H);
        }
        RequestBuilder requestBuilder2 = requestBuilder.f8524I;
        if (requestBuilder2 != null) {
            requestBuilder.f8524I = requestBuilder2.mo8485clone();
        }
        RequestBuilder requestBuilder3 = requestBuilder.f8525J;
        if (requestBuilder3 != null) {
            requestBuilder.f8525J = requestBuilder3.mo8485clone();
        }
        return requestBuilder;
    }

    @NonNull
    public ViewTarget<ImageView, TranscodeType> into(@NonNull ImageView imageView) {
        BaseRequestOptions baseRequestOptions;
        Util.assertMainThread();
        Preconditions.checkNotNull(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (kb2.f20814a[imageView.getScaleType().ordinal()]) {
                case 1:
                    baseRequestOptions = mo8485clone().optionalCenterCrop();
                    break;
                case 2:
                    baseRequestOptions = mo8485clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    baseRequestOptions = mo8485clone().optionalFitCenter();
                    break;
                case 6:
                    baseRequestOptions = mo8485clone().optionalCenterInside();
                    break;
            }
            ViewTarget<ImageView, TranscodeType> buildImageViewTarget = this.f8520E.buildImageViewTarget(imageView, this.f8518C);
            m2280i(buildImageViewTarget, null, baseRequestOptions, Executors.mainThreadExecutor());
            return buildImageViewTarget;
        }
        baseRequestOptions = this;
        ViewTarget<ImageView, TranscodeType> buildImageViewTarget2 = this.f8520E.buildImageViewTarget(imageView, this.f8518C);
        m2280i(buildImageViewTarget2, null, baseRequestOptions, Executors.mainThreadExecutor());
        return buildImageViewTarget2;
    }

    @NonNull
    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> error(Object obj) {
        if (obj == null) {
            return error((RequestBuilder) null);
        }
        return error((RequestBuilder) mo8485clone().error((RequestBuilder) null).thumbnail((RequestBuilder) null).mo8491load(obj));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        if (requestBuilderArr != null && requestBuilderArr.length != 0) {
            return thumbnail(Arrays.asList(requestBuilderArr));
        }
        return thumbnail((RequestBuilder) null);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable List<RequestBuilder<TranscodeType>> list) {
        RequestBuilder<TranscodeType> requestBuilder = null;
        if (list != null && !list.isEmpty()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                RequestBuilder<TranscodeType> requestBuilder2 = list.get(size);
                if (requestBuilder2 != null) {
                    requestBuilder = requestBuilder == null ? requestBuilder2 : requestBuilder2.thumbnail(requestBuilder);
                }
            }
            return thumbnail(requestBuilder);
        }
        return thumbnail((RequestBuilder) null);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8491load(@Nullable Object obj) {
        return m2281j(obj);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8486load(@Nullable Bitmap bitmap) {
        return m2281j(bitmap).apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8487load(@Nullable Drawable drawable) {
        return m2281j(drawable).apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8492load(@Nullable String str) {
        return m2281j(str);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8488load(@Nullable Uri uri) {
        return m2281j(uri);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(float f) {
        if (isAutoCloneEnabled()) {
            return mo8485clone().thumbnail(f);
        }
        if (f >= RecyclerView.f7068F0 && f <= 1.0f) {
            this.f8526K = Float.valueOf(f);
            return selfOrThrowIfLocked();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8489load(@Nullable File file) {
        return m2281j(file);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8490load(@Nullable @DrawableRes @RawRes Integer num) {
        return m2281j(num).apply((BaseRequestOptions<?>) RequestOptions.signatureOf(AndroidResourceSignature.obtain(this.f8516A)));
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int i, int i2) {
        return submit(i, i2);
    }

    @Override // 
    @CheckResult
    @Deprecated
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8493load(@Nullable URL url) {
        return m2281j(url);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo8494load(@Nullable byte[] bArr) {
        RequestBuilder<TranscodeType> m2281j = m2281j(bArr);
        if (!m2281j.isDiskCacheStrategySet()) {
            m2281j = m2281j.apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
        }
        return !m2281j.isSkipMemoryCacheSet() ? m2281j.apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true)) : m2281j;
    }

    @SuppressLint({"CheckResult"})
    public RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.f8519D, requestBuilder.f8517B, cls, requestBuilder.f8516A);
        this.f8522G = requestBuilder.f8522G;
        this.f8528M = requestBuilder.f8528M;
        apply((BaseRequestOptions<?>) requestBuilder);
    }
}
