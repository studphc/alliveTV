package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p000.InterfaceC1250gz;

/* loaded from: classes.dex */
public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a */
    public final Class f8687a;

    /* renamed from: b */
    public final Pools.Pool f8688b;

    /* renamed from: c */
    public final List f8689c;

    /* renamed from: d */
    public final String f8690d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f8687a = cls;
        this.f8688b = pool;
        this.f8689c = (List) Preconditions.checkNotEmpty(list);
        this.f8690d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public Class<Data> getDataClass() {
        return this.f8687a;
    }

    public Resource<Transcode> load(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, InterfaceC1250gz interfaceC1250gz) {
        Pools.Pool pool = this.f8688b;
        List list = (List) Preconditions.checkNotNull(pool.acquire());
        try {
            List list2 = this.f8689c;
            int size = list2.size();
            Resource<Transcode> resource = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    resource = ((DecodePath) list2.get(i3)).decode(dataRewinder, i, i2, options, interfaceC1250gz);
                } catch (GlideException e) {
                    list.add(e);
                }
                if (resource != null) {
                    break;
                }
            }
            if (resource != null) {
                return resource;
            }
            throw new GlideException(this.f8690d, new ArrayList(list));
        } finally {
            pool.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f8689c.toArray()) + '}';
    }
}
