package p000;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;

/* loaded from: classes.dex */
public final class i90 {

    /* renamed from: a */
    public final DiskCache.Factory f18340a;

    /* renamed from: b */
    public volatile DiskCache f18341b;

    public i90(DiskCache.Factory factory) {
        this.f18340a = factory;
    }

    /* renamed from: a */
    public final DiskCache m5200a() {
        if (this.f18341b == null) {
            synchronized (this) {
                try {
                    if (this.f18341b == null) {
                        this.f18341b = this.f18340a.build();
                    }
                    if (this.f18341b == null) {
                        this.f18341b = new DiskCacheAdapter();
                    }
                } finally {
                }
            }
        }
        return this.f18341b;
    }
}
