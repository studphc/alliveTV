package com.bumptech.glide.provider;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class LoadPathCache {

    /* renamed from: c */
    public static final LoadPath f9000c = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);

    /* renamed from: a */
    public final ArrayMap f9001a = new ArrayMap();

    /* renamed from: b */
    public final AtomicReference f9002b = new AtomicReference();

    @Nullable
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> get(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey multiClassKey = (MultiClassKey) this.f9002b.getAndSet(null);
        if (multiClassKey == null) {
            multiClassKey = new MultiClassKey();
        }
        multiClassKey.set(cls, cls2, cls3);
        synchronized (this.f9001a) {
            loadPath = (LoadPath) this.f9001a.get(multiClassKey);
        }
        this.f9002b.set(multiClassKey);
        return loadPath;
    }

    public boolean isEmptyLoadPath(@Nullable LoadPath<?, ?, ?> loadPath) {
        return f9000c.equals(loadPath);
    }

    public void put(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable LoadPath<?, ?, ?> loadPath) {
        synchronized (this.f9001a) {
            ArrayMap arrayMap = this.f9001a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f9000c;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
