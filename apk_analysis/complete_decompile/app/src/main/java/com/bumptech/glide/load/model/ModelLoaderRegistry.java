package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p000.C1785s4;
import p000.mo1;

/* loaded from: classes.dex */
public class ModelLoaderRegistry {

    /* renamed from: a */
    public final MultiModelLoaderFactory f8800a;

    /* renamed from: b */
    public final C1785s4 f8801b;

    public ModelLoaderRegistry(@NonNull Pools.Pool<List<Throwable>> pool) {
        MultiModelLoaderFactory multiModelLoaderFactory = new MultiModelLoaderFactory(pool);
        this.f8801b = new C1785s4(2);
        this.f8800a = multiModelLoaderFactory;
    }

    public synchronized <Model, Data> void append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f8800a.m2337a(cls, cls2, modelLoaderFactory);
        this.f8801b.f26232a.clear();
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f8800a.build(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> cls) {
        return this.f8800a.m2339c(cls);
    }

    @NonNull
    public <A> List<ModelLoader<A, ?>> getModelLoaders(@NonNull A a) {
        List list;
        Class<?> cls = a.getClass();
        synchronized (this) {
            mo1 mo1Var = (mo1) this.f8801b.f26232a.get(cls);
            if (mo1Var == null) {
                list = null;
            } else {
                list = mo1Var.f23023a;
            }
            if (list == null) {
                list = Collections.unmodifiableList(this.f8800a.m2338b(cls));
                if (((mo1) this.f8801b.f26232a.put(cls, new mo1(list))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (!list.isEmpty()) {
            int size = list.size();
            List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i = 0; i < size; i++) {
                ModelLoader<A, ?> modelLoader = (ModelLoader) list.get(i);
                if (modelLoader.handles(a)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i);
                        z = false;
                    }
                    emptyList.add(modelLoader);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a, (List<ModelLoader<A, ?>>) list);
        }
        throw new Registry.NoModelLoaderAvailableException(a);
    }

    public synchronized <Model, Data> void prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f8800a.m2340d(cls, cls2, modelLoaderFactory);
        this.f8801b.f26232a.clear();
    }

    public synchronized <Model, Data> void remove(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        Iterator it = this.f8800a.m2341e(cls, cls2).iterator();
        while (it.hasNext()) {
            ((ModelLoaderFactory) it.next()).teardown();
        }
        this.f8801b.f26232a.clear();
    }

    public synchronized <Model, Data> void replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        Iterator it = this.f8800a.m2342f(cls, cls2, modelLoaderFactory).iterator();
        while (it.hasNext()) {
            ((ModelLoaderFactory) it.next()).teardown();
        }
        this.f8801b.f26232a.clear();
    }
}
