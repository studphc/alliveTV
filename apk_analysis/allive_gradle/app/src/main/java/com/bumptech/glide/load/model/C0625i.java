package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p000.pp1;

/* renamed from: com.bumptech.glide.load.model.i */
/* loaded from: classes.dex */
public final class C0625i implements ModelLoader {

    /* renamed from: a */
    public final ArrayList f8833a;

    /* renamed from: b */
    public final Pools.Pool f8834b;

    public C0625i(ArrayList arrayList, Pools.Pool pool) {
        this.f8833a = arrayList;
        this.f8834b = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        ModelLoader.LoadData buildLoadData;
        ArrayList arrayList = this.f8833a;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader modelLoader = (ModelLoader) arrayList.get(i3);
            if (modelLoader.handles(obj) && (buildLoadData = modelLoader.buildLoadData(obj, i, i2, options)) != null) {
                key = buildLoadData.sourceKey;
                arrayList2.add(buildLoadData.fetcher);
            }
        }
        if (arrayList2.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData(key, new pp1(arrayList2, this.f8834b));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean handles(Object obj) {
        Iterator it = this.f8833a.iterator();
        while (it.hasNext()) {
            if (((ModelLoader) it.next()).handles(obj)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f8833a.toArray()) + '}';
    }
}
