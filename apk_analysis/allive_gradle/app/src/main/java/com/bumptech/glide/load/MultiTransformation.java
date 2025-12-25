package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MultiTransformation<T> implements Transformation<T> {

    /* renamed from: a */
    public final Collection f8626a;

    @SafeVarargs
    public MultiTransformation(@NonNull Transformation<T>... transformationArr) {
        if (transformationArr.length != 0) {
            this.f8626a = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.f8626a.equals(((MultiTransformation) obj).f8626a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f8626a.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<T> transform(@NonNull Context context, @NonNull Resource<T> resource, int i, int i2) {
        Iterator it = this.f8626a.iterator();
        Resource<T> resource2 = resource;
        while (it.hasNext()) {
            Resource<T> transform = ((Transformation) it.next()).transform(context, resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform)) {
                resource2.recycle();
            }
            resource2 = transform;
        }
        return resource2;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        Iterator it = this.f8626a.iterator();
        while (it.hasNext()) {
            ((Transformation) it.next()).updateDiskCacheKey(messageDigest);
        }
    }

    public MultiTransformation(@NonNull Collection<? extends Transformation<T>> collection) {
        if (!collection.isEmpty()) {
            this.f8626a = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
