package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p000.C1785s4;
import p000.dx0;

/* loaded from: classes.dex */
public class Glide implements ComponentCallbacks2 {

    /* renamed from: m */
    public static volatile Glide f8450m;

    /* renamed from: n */
    public static volatile boolean f8451n;

    /* renamed from: a */
    public final Engine f8452a;

    /* renamed from: b */
    public final BitmapPool f8453b;

    /* renamed from: c */
    public final MemoryCache f8454c;

    /* renamed from: d */
    public final GlideContext f8455d;

    /* renamed from: e */
    public final Registry f8456e;

    /* renamed from: f */
    public final ArrayPool f8457f;

    /* renamed from: g */
    public final RequestManagerRetriever f8458g;

    /* renamed from: h */
    public final ConnectivityMonitorFactory f8459h;

    /* renamed from: j */
    public final RequestOptionsFactory f8461j;

    /* renamed from: l */
    public BitmapPreFiller f8463l;

    /* renamed from: i */
    public final ArrayList f8460i = new ArrayList();

    /* renamed from: k */
    public MemoryCategory f8462k = MemoryCategory.NORMAL;

    /* loaded from: classes.dex */
    public interface RequestOptionsFactory {
        @NonNull
        RequestOptions build();
    }

    public Glide(Context context, Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, ArrayPool arrayPool, RequestManagerRetriever requestManagerRetriever, ConnectivityMonitorFactory connectivityMonitorFactory, int i, RequestOptionsFactory requestOptionsFactory, ArrayMap arrayMap, List list, GlideExperiments glideExperiments) {
        ResourceDecoder byteBufferBitmapDecoder;
        ResourceDecoder streamBitmapDecoder;
        Registry registry;
        this.f8452a = engine;
        this.f8453b = bitmapPool;
        this.f8457f = arrayPool;
        this.f8454c = memoryCache;
        this.f8458g = requestManagerRetriever;
        this.f8459h = connectivityMonitorFactory;
        this.f8461j = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry2 = new Registry();
        this.f8456e = registry2;
        registry2.register(new DefaultImageHeaderParser());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            registry2.register(new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> imageHeaderParsers = registry2.getImageHeaderParsers();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, imageHeaderParsers, bitmapPool, arrayPool);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel = VideoDecoder.parcel(bitmapPool);
        Downsampler downsampler = new Downsampler(registry2.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        if (glideExperiments.isEnabled(dx0.class) && i2 >= 28) {
            streamBitmapDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        } else {
            byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
            streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool);
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        registry2.append(ByteBuffer.class, new ByteBufferEncoder()).append(InputStream.class, new StreamEncoder(arrayPool)).append(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).append(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, streamBitmapDecoder);
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry2.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        registry2.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, parcel).append(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(bitmapPool)).append(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).append(Bitmap.class, (ResourceEncoder) bitmapEncoder).append(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).append(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).append(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, parcel)).append(BitmapDrawable.class, (ResourceEncoder) new BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).append(Registry.BUCKET_GIF, InputStream.class, GifDrawable.class, new StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, arrayPool)).append(Registry.BUCKET_GIF, ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).append(GifDrawable.class, (ResourceEncoder) new GifDrawableEncoder()).append(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool)).append(Uri.class, Drawable.class, resourceDrawableDecoder).append(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).register(new ByteBufferRewinder.Factory()).append(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).append(File.class, InputStream.class, new FileLoader.StreamFactory()).append(File.class, File.class, new FileDecoder()).append(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).append(File.class, File.class, UnitModelLoader.Factory.getInstance()).register(new InputStreamRewinder.Factory(arrayPool));
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry = registry2;
            registry.register(new ParcelFileDescriptorRewinder.Factory());
        } else {
            registry = registry2;
        }
        Class cls = Integer.TYPE;
        registry.append(cls, InputStream.class, streamFactory).append(cls, ParcelFileDescriptor.class, fileDescriptorFactory).append(Integer.class, InputStream.class, streamFactory).append(Integer.class, ParcelFileDescriptor.class, fileDescriptorFactory).append(Integer.class, Uri.class, uriFactory).append(cls, AssetFileDescriptor.class, assetFileDescriptorFactory).append(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory).append(cls, Uri.class, uriFactory).append(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(String.class, InputStream.class, new StringLoader.StreamFactory()).append(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).append(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).append(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).append(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).append(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context)).append(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        if (i2 >= 29) {
            registry.append(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
            registry.append(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        registry.append(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver)).append(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver)).append(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver)).append(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).append(URL.class, InputStream.class, new UrlLoader.StreamFactory()).append(Uri.class, File.class, new MediaStoreFileLoader.Factory(context)).append(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).append(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).append(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).append(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, new UnitDrawableDecoder()).register(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).register(Bitmap.class, byte[].class, bitmapBytesTranscoder).register(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).register(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        ResourceDecoder<ByteBuffer, Bitmap> byteBuffer = VideoDecoder.byteBuffer(bitmapPool);
        registry.append(ByteBuffer.class, Bitmap.class, byteBuffer);
        registry.append(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBuffer));
        this.f8455d = new GlideContext(context, arrayPool, registry, new ImageViewTargetFactory(), requestOptionsFactory, arrayMap, list, engine, glideExperiments, i);
    }

    /* renamed from: a */
    public static GeneratedAppGlideModule m2271a(Context context) {
        try {
            return (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e2);
        } catch (NoSuchMethodException e3) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e3);
        } catch (InvocationTargetException e4) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e4);
        }
    }

    /* renamed from: b */
    public static RequestManagerRetriever m2272b(Context context) {
        Preconditions.checkNotNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).getRequestManagerRetriever();
    }

    /* renamed from: c */
    public static void m2273c(Context context, GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            emptyList = new ManifestParser(applicationContext).parse();
        }
        List<GlideModule> list = emptyList;
        if (generatedAppGlideModule != null && !generatedAppGlideModule.mo2269a().isEmpty()) {
            Set mo2269a = generatedAppGlideModule.mo2269a();
            Iterator<GlideModule> it = list.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (mo2269a.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<GlideModule> it2 = list.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        if (generatedAppGlideModule != null) {
            requestManagerFactory = generatedAppGlideModule.mo2270b();
        } else {
            requestManagerFactory = null;
        }
        glideBuilder.f8477n = requestManagerFactory;
        Iterator<GlideModule> it3 = list.iterator();
        while (it3.hasNext()) {
            it3.next().applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        if (glideBuilder.f8470g == null) {
            glideBuilder.f8470g = GlideExecutor.newSourceExecutor();
        }
        if (glideBuilder.f8471h == null) {
            glideBuilder.f8471h = GlideExecutor.newDiskCacheExecutor();
        }
        if (glideBuilder.f8478o == null) {
            glideBuilder.f8478o = GlideExecutor.newAnimationExecutor();
        }
        if (glideBuilder.f8473j == null) {
            glideBuilder.f8473j = new MemorySizeCalculator.Builder(applicationContext).build();
        }
        if (glideBuilder.f8474k == null) {
            glideBuilder.f8474k = new DefaultConnectivityMonitorFactory();
        }
        if (glideBuilder.f8467d == null) {
            int bitmapPoolSize = glideBuilder.f8473j.getBitmapPoolSize();
            if (bitmapPoolSize > 0) {
                glideBuilder.f8467d = new LruBitmapPool(bitmapPoolSize);
            } else {
                glideBuilder.f8467d = new BitmapPoolAdapter();
            }
        }
        if (glideBuilder.f8468e == null) {
            glideBuilder.f8468e = new LruArrayPool(glideBuilder.f8473j.getArrayPoolSizeInBytes());
        }
        if (glideBuilder.f8469f == null) {
            glideBuilder.f8469f = new LruResourceCache(glideBuilder.f8473j.getMemoryCacheSize());
        }
        if (glideBuilder.f8472i == null) {
            glideBuilder.f8472i = new InternalCacheDiskCacheFactory(applicationContext);
        }
        if (glideBuilder.f8466c == null) {
            glideBuilder.f8466c = new Engine(glideBuilder.f8469f, glideBuilder.f8472i, glideBuilder.f8471h, glideBuilder.f8470g, GlideExecutor.newUnlimitedSourceExecutor(), glideBuilder.f8478o, glideBuilder.f8479p);
        }
        List list2 = glideBuilder.f8480q;
        if (list2 == null) {
            glideBuilder.f8480q = Collections.emptyList();
        } else {
            glideBuilder.f8480q = Collections.unmodifiableList(list2);
        }
        C1785s4 c1785s4 = glideBuilder.f8465b;
        c1785s4.getClass();
        GlideExperiments glideExperiments = new GlideExperiments(c1785s4);
        Glide glide = new Glide(applicationContext, glideBuilder.f8466c, glideBuilder.f8469f, glideBuilder.f8467d, glideBuilder.f8468e, new RequestManagerRetriever(glideBuilder.f8477n, glideExperiments), glideBuilder.f8474k, glideBuilder.f8475l, glideBuilder.f8476m, glideBuilder.f8464a, glideBuilder.f8480q, glideExperiments);
        for (GlideModule glideModule : list) {
            try {
                glideModule.registerComponents(applicationContext, glide, glide.f8456e);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ".concat(glideModule.getClass().getName()), e);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(applicationContext, glide, glide.f8456e);
        }
        applicationContext.registerComponentCallbacks(glide);
        f8450m = glide;
    }

    @VisibleForTesting
    public static void enableHardwareBitmaps() {
        HardwareConfigState.getInstance().unblockHardwareBitmaps();
    }

    @NonNull
    public static Glide get(@NonNull Context context) {
        if (f8450m == null) {
            GeneratedAppGlideModule m2271a = m2271a(context.getApplicationContext());
            synchronized (Glide.class) {
                if (f8450m == null) {
                    if (!f8451n) {
                        f8451n = true;
                        m2273c(context, new GlideBuilder(), m2271a);
                        f8451n = false;
                    } else {
                        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
                    }
                }
            }
        }
        return f8450m;
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context) {
        return getPhotoCacheDir(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR);
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(Glide glide) {
        synchronized (Glide.class) {
            try {
                if (f8450m != null) {
                    tearDown();
                }
                f8450m = glide;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public static void tearDown() {
        synchronized (Glide.class) {
            try {
                if (f8450m != null) {
                    f8450m.getContext().getApplicationContext().unregisterComponentCallbacks(f8450m);
                    f8450m.f8452a.shutdown();
                }
                f8450m = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public static RequestManager with(@NonNull Context context) {
        return m2272b(context).get(context);
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.f8452a.clearDiskCache();
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.f8454c.clearMemory();
        this.f8453b.clearMemory();
        this.f8457f.clearMemory();
    }

    /* renamed from: d */
    public final void m2274d(RequestManager requestManager) {
        synchronized (this.f8460i) {
            try {
                if (this.f8460i.contains(requestManager)) {
                    this.f8460i.remove(requestManager);
                } else {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.f8457f;
    }

    @NonNull
    public BitmapPool getBitmapPool() {
        return this.f8453b;
    }

    @NonNull
    public Context getContext() {
        return this.f8455d.getBaseContext();
    }

    @NonNull
    public Registry getRegistry() {
        return this.f8456e;
    }

    @NonNull
    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.f8458g;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        trimMemory(i);
    }

    public synchronized void preFillBitmapPool(@NonNull PreFillType.Builder... builderArr) {
        try {
            if (this.f8463l == null) {
                this.f8463l = new BitmapPreFiller(this.f8454c, this.f8453b, (DecodeFormat) this.f8461j.build().getOptions().get(Downsampler.DECODE_FORMAT));
            }
            this.f8463l.preFill(builderArr);
        } catch (Throwable th) {
            throw th;
        }
    }

    @NonNull
    public MemoryCategory setMemoryCategory(@NonNull MemoryCategory memoryCategory) {
        Util.assertMainThread();
        this.f8454c.setSizeMultiplier(memoryCategory.getMultiplier());
        this.f8453b.setSizeMultiplier(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.f8462k;
        this.f8462k = memoryCategory;
        return memoryCategory2;
    }

    public void trimMemory(int i) {
        Util.assertMainThread();
        synchronized (this.f8460i) {
            try {
                Iterator it = this.f8460i.iterator();
                while (it.hasNext()) {
                    ((RequestManager) it.next()).onTrimMemory(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f8454c.trimMemory(i);
        this.f8453b.trimMemory(i);
        this.f8457f.trimMemory(i);
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.isDirectory() || file.mkdirs()) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable("Glide", 6)) {
            Log.e("Glide", "default disk cache dir is null");
        }
        return null;
    }

    @NonNull
    public static RequestManager with(@NonNull Activity activity) {
        return m2272b(activity).get(activity);
    }

    @NonNull
    public static RequestManager with(@NonNull FragmentActivity fragmentActivity) {
        return m2272b(fragmentActivity).get(fragmentActivity);
    }

    @NonNull
    public static RequestManager with(@NonNull Fragment fragment) {
        return m2272b(fragment.getContext()).get(fragment);
    }

    @VisibleForTesting
    public static void init(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        GeneratedAppGlideModule m2271a = m2271a(context);
        synchronized (Glide.class) {
            try {
                if (f8450m != null) {
                    tearDown();
                }
                m2273c(context, glideBuilder, m2271a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @Deprecated
    public static RequestManager with(@NonNull android.app.Fragment fragment) {
        return m2272b(fragment.getActivity()).get(fragment);
    }

    @NonNull
    public static RequestManager with(@NonNull View view) {
        return m2272b(view.getContext()).get(view);
    }
}
