package p000;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* renamed from: ly */
/* loaded from: classes.dex */
public final class C1528ly implements InterfaceC1667oy, DataFetcher.DataCallback {

    /* renamed from: a */
    public final List f22711a;

    /* renamed from: b */
    public final C0538az f22712b;

    /* renamed from: c */
    public final DataFetcherGenerator$FetcherReadyCallback f22713c;

    /* renamed from: d */
    public int f22714d = -1;

    /* renamed from: e */
    public Key f22715e;

    /* renamed from: f */
    public List f22716f;

    /* renamed from: g */
    public int f22717g;

    /* renamed from: h */
    public volatile ModelLoader.LoadData f22718h;

    /* renamed from: i */
    public File f22719i;

    public C1528ly(List list, C0538az c0538az, DataFetcherGenerator$FetcherReadyCallback dataFetcherGenerator$FetcherReadyCallback) {
        this.f22711a = list;
        this.f22712b = c0538az;
        this.f22713c = dataFetcherGenerator$FetcherReadyCallback;
    }

    @Override // p000.InterfaceC1667oy
    /* renamed from: a */
    public final boolean mo5998a() {
        while (true) {
            List list = this.f22716f;
            boolean z = false;
            if (list != null && this.f22717g < list.size()) {
                this.f22718h = null;
                while (!z && this.f22717g < this.f22716f.size()) {
                    List list2 = this.f22716f;
                    int i = this.f22717g;
                    this.f22717g = i + 1;
                    ModelLoader modelLoader = (ModelLoader) list2.get(i);
                    File file = this.f22719i;
                    C0538az c0538az = this.f22712b;
                    this.f22718h = modelLoader.buildLoadData(file, c0538az.f7802e, c0538az.f7803f, c0538az.f7806i);
                    if (this.f22718h != null) {
                        C0538az c0538az2 = this.f22712b;
                        if (c0538az2.f7800c.getRegistry().getLoadPath(this.f22718h.fetcher.getDataClass(), c0538az2.f7804g, c0538az2.f7808k) != null) {
                            this.f22718h.fetcher.loadData(this.f22712b.f7812o, this);
                            z = true;
                        }
                    }
                }
                return z;
            }
            int i2 = this.f22714d + 1;
            this.f22714d = i2;
            if (i2 >= this.f22711a.size()) {
                return false;
            }
            Key key = (Key) this.f22711a.get(this.f22714d);
            C0538az c0538az3 = this.f22712b;
            File file2 = c0538az3.f7805h.m5200a().get(new C1565my(key, c0538az3.f7811n));
            this.f22719i = file2;
            if (file2 != null) {
                this.f22715e = key;
                this.f22716f = this.f22712b.f7800c.getRegistry().getModelLoaders(file2);
                this.f22717g = 0;
            }
        }
    }

    @Override // p000.InterfaceC1667oy
    public final void cancel() {
        ModelLoader.LoadData loadData = this.f22718h;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void onDataReady(Object obj) {
        this.f22713c.onDataFetcherReady(this.f22715e, obj, this.f22718h.fetcher, DataSource.DATA_DISK_CACHE, this.f22715e);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void onLoadFailed(Exception exc) {
        this.f22713c.onDataFetcherFailed(this.f22715e, exc, this.f22718h.fetcher, DataSource.DATA_DISK_CACHE);
    }
}
