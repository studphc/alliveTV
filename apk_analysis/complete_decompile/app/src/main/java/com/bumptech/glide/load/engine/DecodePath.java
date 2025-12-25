package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p000.AbstractC1103cz;
import p000.C0538az;
import p000.C1139dz;
import p000.C1540m9;
import p000.C1565my;
import p000.InterfaceC1250gz;
import p000.RunnableC1213fz;
import p000.rd1;
import p000.tb2;

/* loaded from: classes.dex */
public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: a */
    public final Class f8663a;

    /* renamed from: b */
    public final List f8664b;

    /* renamed from: c */
    public final ResourceTranscoder f8665c;

    /* renamed from: d */
    public final Pools.Pool f8666d;

    /* renamed from: e */
    public final String f8667e;

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.f8663a = cls;
        this.f8664b = list;
        this.f8665c = resourceTranscoder;
        this.f8666d = pool;
        this.f8667e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* renamed from: a */
    public final Resource m2313a(DataRewinder dataRewinder, int i, int i2, Options options, List list) {
        List list2 = this.f8664b;
        int size = list2.size();
        Resource resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) list2.get(i3);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder, e);
                }
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f8667e, new ArrayList(list));
    }

    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, InterfaceC1250gz interfaceC1250gz) {
        Resource<?> resource;
        Transformation transformation;
        EncodeStrategy encodeStrategy;
        boolean z;
        DecodePath<DataType, ResourceType, Transcode> decodePath;
        boolean z2;
        boolean z3;
        Key c1565my;
        Pools.Pool pool = this.f8666d;
        List list = (List) Preconditions.checkNotNull(pool.acquire());
        try {
            Resource<?> m2313a = m2313a(dataRewinder, i, i2, options, list);
            pool.release(list);
            C1540m9 c1540m9 = (C1540m9) interfaceC1250gz;
            RunnableC1213fz runnableC1213fz = (RunnableC1213fz) c1540m9.f22855c;
            runnableC1213fz.getClass();
            Class<?> cls = m2313a.get().getClass();
            DataSource dataSource = DataSource.RESOURCE_DISK_CACHE;
            DataSource dataSource2 = (DataSource) c1540m9.f22854b;
            C0538az c0538az = runnableC1213fz.f17455a;
            ResourceEncoder resourceEncoder = null;
            if (dataSource2 != dataSource) {
                Transformation m1983c = c0538az.m1983c(cls);
                resource = m1983c.transform(runnableC1213fz.f17462h, m2313a, runnableC1213fz.f17466l, runnableC1213fz.f17467m);
                transformation = m1983c;
            } else {
                resource = m2313a;
                transformation = null;
            }
            if (!m2313a.equals(resource)) {
                m2313a.recycle();
            }
            if (c0538az.f7800c.getRegistry().isResourceEncoderAvailable(resource)) {
                resourceEncoder = c0538az.f7800c.getRegistry().getResultEncoder(resource);
                encodeStrategy = resourceEncoder.getEncodeStrategy(runnableC1213fz.f17469o);
            } else {
                encodeStrategy = EncodeStrategy.NONE;
            }
            Key key = runnableC1213fz.f17476v;
            ArrayList m1982b = c0538az.m1982b();
            int size = m1982b.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    if (((ModelLoader.LoadData) m1982b.get(i3)).sourceKey.equals(key)) {
                        z = true;
                        break;
                    }
                    i3++;
                } else {
                    z = false;
                    break;
                }
            }
            if (runnableC1213fz.f17468n.isResourceCacheable(!z, dataSource2, encodeStrategy)) {
                if (resourceEncoder != null) {
                    int i4 = AbstractC1103cz.f16182c[encodeStrategy.ordinal()];
                    if (i4 != 1) {
                        if (i4 == 2) {
                            z2 = true;
                            z3 = false;
                            c1565my = new tb2(c0538az.f7800c.getArrayPool(), runnableC1213fz.f17476v, runnableC1213fz.f17463i, runnableC1213fz.f17466l, runnableC1213fz.f17467m, transformation, cls, runnableC1213fz.f17469o);
                        } else {
                            throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                        }
                    } else {
                        z2 = true;
                        z3 = false;
                        c1565my = new C1565my(runnableC1213fz.f17476v, runnableC1213fz.f17463i);
                    }
                    rd1 rd1Var = (rd1) Preconditions.checkNotNull((rd1) rd1.f25935e.acquire());
                    rd1Var.f25939d = z3;
                    rd1Var.f25938c = z2;
                    rd1Var.f25937b = resource;
                    C1139dz c1139dz = runnableC1213fz.f17460f;
                    c1139dz.f16616a = c1565my;
                    c1139dz.f16617b = resourceEncoder;
                    c1139dz.f16618c = rd1Var;
                    decodePath = this;
                    resource = rd1Var;
                } else {
                    throw new Registry.NoResultEncoderAvailableException(resource.get().getClass());
                }
            } else {
                decodePath = this;
            }
            return decodePath.f8665c.transcode(resource, options);
        } catch (Throwable th) {
            pool.release(list);
            throw th;
        }
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f8663a + ", decoders=" + this.f8664b + ", transcoder=" + this.f8665c + '}';
    }
}
