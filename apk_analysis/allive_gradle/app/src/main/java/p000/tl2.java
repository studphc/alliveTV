package p000;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.ModelLoader;

/* loaded from: classes.dex */
public final class tl2 implements DataFetcher.DataCallback {

    /* renamed from: a */
    public final /* synthetic */ ModelLoader.LoadData f26866a;

    /* renamed from: b */
    public final /* synthetic */ ul2 f26867b;

    public tl2(ul2 ul2Var, ModelLoader.LoadData loadData) {
        this.f26867b = ul2Var;
        this.f26866a = loadData;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void onDataReady(Object obj) {
        ul2 ul2Var = this.f26867b;
        ModelLoader.LoadData loadData = this.f26866a;
        ModelLoader.LoadData loadData2 = ul2Var.f27341f;
        if (loadData2 != null && loadData2 == loadData) {
            DiskCacheStrategy diskCacheStrategy = ul2Var.f27336a.f7813p;
            if (obj != null && diskCacheStrategy.isDataCacheable(loadData.fetcher.getDataSource())) {
                ul2Var.f27340e = obj;
                ul2Var.f27337b.reschedule();
                return;
            }
            Key key = loadData.sourceKey;
            DataFetcher dataFetcher = loadData.fetcher;
            ul2Var.f27337b.onDataFetcherReady(key, obj, dataFetcher, dataFetcher.getDataSource(), ul2Var.f27342g);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void onLoadFailed(Exception exc) {
        ul2 ul2Var = this.f26867b;
        ModelLoader.LoadData loadData = this.f26866a;
        ModelLoader.LoadData loadData2 = ul2Var.f27341f;
        if (loadData2 != null && loadData2 == loadData) {
            C1565my c1565my = ul2Var.f27342g;
            DataFetcher dataFetcher = loadData.fetcher;
            ul2Var.f27337b.onDataFetcherFailed(c1565my, exc, dataFetcher, dataFetcher.getDataSource());
        }
    }
}
