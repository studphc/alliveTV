package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class ModelToResourceClassCache {

    /* renamed from: a */
    public final AtomicReference f9003a = new AtomicReference();

    /* renamed from: b */
    public final ArrayMap f9004b = new ArrayMap();

    public void clear() {
        synchronized (this.f9004b) {
            this.f9004b.clear();
        }
    }

    @Nullable
    public List<Class<?>> get(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        MultiClassKey multiClassKey = (MultiClassKey) this.f9003a.getAndSet(null);
        if (multiClassKey == null) {
            multiClassKey = new MultiClassKey(cls, cls2, cls3);
        } else {
            multiClassKey.set(cls, cls2, cls3);
        }
        synchronized (this.f9004b) {
            list = (List) this.f9004b.get(multiClassKey);
        }
        this.f9003a.set(multiClassKey);
        return list;
    }

    public void put(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f9004b) {
            this.f9004b.put(new MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
