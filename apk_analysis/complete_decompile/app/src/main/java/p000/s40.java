package p000;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* loaded from: classes.dex */
public final class s40 extends DiskCacheStrategy {

    /* renamed from: a */
    public final /* synthetic */ int f26233a;

    @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
    public final boolean decodeCachedData() {
        switch (this.f26233a) {
            case 0:
                return true;
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return false;
            default:
                return true;
        }
    }

    @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
    public final boolean decodeCachedResource() {
        switch (this.f26233a) {
            case 0:
                return true;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return true;
            default:
                return true;
        }
    }

    @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
    public final boolean isDataCacheable(DataSource dataSource) {
        switch (this.f26233a) {
            case 0:
                if (dataSource == DataSource.REMOTE) {
                    return true;
                }
                return false;
            case 1:
                return false;
            case 2:
                if (dataSource != DataSource.DATA_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE) {
                    return true;
                }
                return false;
            case 3:
                return false;
            default:
                if (dataSource == DataSource.REMOTE) {
                    return true;
                }
                return false;
        }
    }

    @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
    public final boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
        switch (this.f26233a) {
            case 0:
                if (dataSource != DataSource.RESOURCE_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE) {
                    return true;
                }
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                if (dataSource != DataSource.RESOURCE_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE) {
                    return true;
                }
                return false;
            default:
                if (((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED) {
                    return true;
                }
                return false;
        }
    }
}
