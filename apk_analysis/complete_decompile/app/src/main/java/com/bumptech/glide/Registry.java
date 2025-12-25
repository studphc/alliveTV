package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {
    public static final String BUCKET_BITMAP = "Bitmap";
    public static final String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";
    public static final String BUCKET_GIF = "Gif";

    /* renamed from: a */
    public final ModelLoaderRegistry f8506a;

    /* renamed from: b */
    public final EncoderRegistry f8507b;

    /* renamed from: c */
    public final ResourceDecoderRegistry f8508c;

    /* renamed from: d */
    public final ResourceEncoderRegistry f8509d;

    /* renamed from: e */
    public final DataRewinderRegistry f8510e;

    /* renamed from: f */
    public final TranscoderRegistry f8511f;

    /* renamed from: g */
    public final ImageHeaderParserRegistry f8512g;

    /* renamed from: h */
    public final ModelToResourceClassCache f8513h = new ModelToResourceClassCache();

    /* renamed from: i */
    public final LoadPathCache f8514i = new LoadPathCache();

    /* renamed from: j */
    public final Pools.Pool f8515j;

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m, @NonNull List<ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool threadSafeList = FactoryPools.threadSafeList();
        this.f8515j = threadSafeList;
        this.f8506a = new ModelLoaderRegistry(threadSafeList);
        this.f8507b = new EncoderRegistry();
        this.f8508c = new ResourceDecoderRegistry();
        this.f8509d = new ResourceEncoderRegistry();
        this.f8510e = new DataRewinderRegistry();
        this.f8511f = new TranscoderRegistry();
        this.f8512g = new ImageHeaderParserRegistry();
        setResourceDecoderBucketPriorityList(Arrays.asList(BUCKET_GIF, BUCKET_BITMAP, BUCKET_BITMAP_DRAWABLE));
    }

    @NonNull
    public <Data> Registry append(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f8507b.append(cls, encoder);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> getImageHeaderParsers() {
        List<ImageHeaderParser> parsers = this.f8512g.getParsers();
        if (!parsers.isEmpty()) {
            return parsers;
        }
        throw new NoImageHeaderParserException();
    }

    @Nullable
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> getLoadPath(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        LoadPathCache loadPathCache = this.f8514i;
        LoadPath<Data, TResource, Transcode> loadPath = loadPathCache.get(cls, cls2, cls3);
        if (loadPathCache.isEmptyLoadPath(loadPath)) {
            return null;
        }
        if (loadPath == null) {
            ArrayList arrayList = new ArrayList();
            ResourceDecoderRegistry resourceDecoderRegistry = this.f8508c;
            for (Class cls4 : resourceDecoderRegistry.getResourceClasses(cls, cls2)) {
                TranscoderRegistry transcoderRegistry = this.f8511f;
                for (Class cls5 : transcoderRegistry.getTranscodeClasses(cls4, cls3)) {
                    arrayList.add(new DecodePath(cls, cls4, cls5, resourceDecoderRegistry.getDecoders(cls, cls4), transcoderRegistry.get(cls4, cls5), this.f8515j));
                    cls4 = cls4;
                    transcoderRegistry = transcoderRegistry;
                }
            }
            if (arrayList.isEmpty()) {
                loadPath = null;
            } else {
                loadPath = new LoadPath<>(cls, cls2, cls3, arrayList, this.f8515j);
            }
            loadPathCache.put(cls, cls2, cls3, loadPath);
        }
        return loadPath;
    }

    @NonNull
    public <Model> List<ModelLoader<Model, ?>> getModelLoaders(@NonNull Model model) {
        return this.f8506a.getModelLoaders(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> getRegisteredResourceClasses(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ModelToResourceClassCache modelToResourceClassCache = this.f8513h;
        List<Class<?>> list = modelToResourceClassCache.get(cls, cls2, cls3);
        List<Class<?>> list2 = list;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Class<?>> it = this.f8506a.getDataClasses(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : this.f8508c.getResourceClasses(it.next(), cls2)) {
                    if (!this.f8511f.getTranscodeClasses(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            modelToResourceClassCache.put(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            list2 = arrayList;
        }
        return list2;
    }

    @NonNull
    public <X> ResourceEncoder<X> getResultEncoder(@NonNull Resource<X> resource) {
        ResourceEncoder<X> resourceEncoder = this.f8509d.get(resource.getResourceClass());
        if (resourceEncoder != null) {
            return resourceEncoder;
        }
        throw new NoResultEncoderAvailableException(resource.getResourceClass());
    }

    @NonNull
    public <X> DataRewinder<X> getRewinder(@NonNull X x) {
        return this.f8510e.build(x);
    }

    @NonNull
    public <X> Encoder<X> getSourceEncoder(@NonNull X x) {
        Encoder<X> encoder = this.f8507b.getEncoder(x.getClass());
        if (encoder != null) {
            return encoder;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean isResourceEncoderAvailable(@NonNull Resource<?> resource) {
        if (this.f8509d.get(resource.getResourceClass()) != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public <Data> Registry prepend(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f8507b.prepend(cls, encoder);
        return this;
    }

    @NonNull
    @Deprecated
    public <Data> Registry register(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        return append(cls, encoder);
    }

    @NonNull
    public <Model, Data> Registry replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f8506a.replace(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    public final Registry setResourceDecoderBucketPriorityList(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        this.f8508c.setBucketPriorityList(arrayList);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry append(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        append("legacy_append", cls, cls2, resourceDecoder);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry prepend(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        prepend("legacy_prepend_all", cls, cls2, resourceDecoder);
        return this;
    }

    @NonNull
    @Deprecated
    public <TResource> Registry register(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        return append((Class) cls, (ResourceEncoder) resourceEncoder);
    }

    @NonNull
    public <Data, TResource> Registry append(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f8508c.append(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry prepend(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f8508c.prepend(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    public Registry register(@NonNull DataRewinder.Factory<?> factory) {
        this.f8510e.register(factory);
        return this;
    }

    @NonNull
    public <TResource> Registry append(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f8509d.append(cls, resourceEncoder);
        return this;
    }

    @NonNull
    public <TResource> Registry prepend(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f8509d.prepend(cls, resourceEncoder);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry register(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f8511f.register(cls, cls2, resourceTranscoder);
        return this;
    }

    @NonNull
    public <Model, Data> Registry append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f8506a.append(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    public <Model, Data> Registry prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f8506a.prepend(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    public Registry register(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f8512g.add(imageHeaderParser);
        return this;
    }
}
