package p000;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

/* loaded from: classes.dex */
public final class f03 implements DataFetcher {

    /* renamed from: a */
    public final Object f17071a;

    public f03(Object obj) {
        this.f17071a = obj;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class getDataClass() {
        return this.f17071a.getClass();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        dataCallback.onDataReady(this.f17071a);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
    }
}
