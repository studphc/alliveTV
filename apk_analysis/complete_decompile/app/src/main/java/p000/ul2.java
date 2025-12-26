package p000;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class ul2 implements InterfaceC1667oy, DataFetcherGenerator$FetcherReadyCallback {

    /* renamed from: a */
    public final C0538az f27336a;

    /* renamed from: b */
    public final RunnableC1213fz f27337b;

    /* renamed from: c */
    public int f27338c;

    /* renamed from: d */
    public C1528ly f27339d;

    /* renamed from: e */
    public Object f27340e;

    /* renamed from: f */
    public volatile ModelLoader.LoadData f27341f;

    /* renamed from: g */
    public C1565my f27342g;

    public ul2(C0538az c0538az, RunnableC1213fz runnableC1213fz) {
        this.f27336a = c0538az;
        this.f27337b = runnableC1213fz;
    }

    @Override // p000.InterfaceC1667oy
    /* renamed from: a */
    public final boolean mo5998a() {
        Object obj = this.f27340e;
        if (obj != null) {
            this.f27340e = null;
            long logTime = LogTime.getLogTime();
            try {
                Encoder sourceEncoder = this.f27336a.f7800c.getRegistry().getSourceEncoder(obj);
                C1602ny c1602ny = new C1602ny(sourceEncoder, obj, this.f27336a.f7806i);
                Key key = this.f27341f.sourceKey;
                C0538az c0538az = this.f27336a;
                this.f27342g = new C1565my(key, c0538az.f7811n);
                c0538az.f7805h.m5200a().put(this.f27342g, c1602ny);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f27342g + ", data: " + obj + ", encoder: " + sourceEncoder + ", duration: " + LogTime.getElapsedMillis(logTime));
                }
                this.f27341f.fetcher.cleanup();
                this.f27339d = new C1528ly(Collections.singletonList(this.f27341f.sourceKey), this.f27336a, this);
            } catch (Throwable th) {
                this.f27341f.fetcher.cleanup();
                throw th;
            }
        }
        C1528ly c1528ly = this.f27339d;
        if (c1528ly != null && c1528ly.mo5998a()) {
            return true;
        }
        this.f27339d = null;
        this.f27341f = null;
        boolean z = false;
        while (!z && this.f27338c < this.f27336a.m1982b().size()) {
            ArrayList m1982b = this.f27336a.m1982b();
            int i = this.f27338c;
            this.f27338c = i + 1;
            this.f27341f = (ModelLoader.LoadData) m1982b.get(i);
            if (this.f27341f != null) {
                if (!this.f27336a.f7813p.isDataCacheable(this.f27341f.fetcher.getDataSource())) {
                    C0538az c0538az2 = this.f27336a;
                    if (c0538az2.f7800c.getRegistry().getLoadPath(this.f27341f.fetcher.getDataClass(), c0538az2.f7804g, c0538az2.f7808k) != null) {
                    }
                }
                this.f27341f.fetcher.loadData(this.f27336a.f7812o, new tl2(this, this.f27341f));
                z = true;
            }
        }
        return z;
    }

    @Override // p000.InterfaceC1667oy
    public final void cancel() {
        ModelLoader.LoadData loadData = this.f27341f;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public final void onDataFetcherFailed(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource) {
        this.f27337b.onDataFetcherFailed(key, exc, dataFetcher, this.f27341f.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public final void onDataFetcherReady(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2) {
        this.f27337b.onDataFetcherReady(key, obj, dataFetcher, this.f27341f.fetcher.getDataSource(), key);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public final void reschedule() {
        throw new UnsupportedOperationException();
    }
}
