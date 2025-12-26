package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GlideContext extends ContextWrapper {

    /* renamed from: k */
    public static final GenericTransitionOptions f8481k = new GenericTransitionOptions();

    /* renamed from: a */
    public final ArrayPool f8482a;

    /* renamed from: b */
    public final Registry f8483b;

    /* renamed from: c */
    public final ImageViewTargetFactory f8484c;

    /* renamed from: d */
    public final Glide.RequestOptionsFactory f8485d;

    /* renamed from: e */
    public final List f8486e;

    /* renamed from: f */
    public final Map f8487f;

    /* renamed from: g */
    public final Engine f8488g;

    /* renamed from: h */
    public final GlideExperiments f8489h;

    /* renamed from: i */
    public final int f8490i;

    /* renamed from: j */
    public RequestOptions f8491j;

    public GlideContext(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull ImageViewTargetFactory imageViewTargetFactory, @NonNull Glide.RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, @NonNull Engine engine, @NonNull GlideExperiments glideExperiments, int i) {
        super(context.getApplicationContext());
        this.f8482a = arrayPool;
        this.f8483b = registry;
        this.f8484c = imageViewTargetFactory;
        this.f8485d = requestOptionsFactory;
        this.f8486e = list;
        this.f8487f = map;
        this.f8488g = engine;
        this.f8489h = glideExperiments;
        this.f8490i = i;
    }

    @NonNull
    public <X> ViewTarget<ImageView, X> buildImageViewTarget(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f8484c.buildTarget(imageView, cls);
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.f8482a;
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.f8486e;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        try {
            if (this.f8491j == null) {
                this.f8491j = this.f8485d.build().lock();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f8491j;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(@NonNull Class<T> cls) {
        Map map = this.f8487f;
        TransitionOptions<?, T> transitionOptions = (TransitionOptions) map.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry entry : map.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) entry.getValue();
                }
            }
        }
        if (transitionOptions == null) {
            return f8481k;
        }
        return transitionOptions;
    }

    @NonNull
    public Engine getEngine() {
        return this.f8488g;
    }

    public GlideExperiments getExperiments() {
        return this.f8489h;
    }

    public int getLogLevel() {
        return this.f8490i;
    }

    @NonNull
    public Registry getRegistry() {
        return this.f8483b;
    }
}
