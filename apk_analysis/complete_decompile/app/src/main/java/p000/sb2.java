package p000;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class sb2 implements InterfaceC1667oy, DataFetcher.DataCallback {

    /* renamed from: a */
    public final RunnableC1213fz f26350a;

    /* renamed from: b */
    public final C0538az f26351b;

    /* renamed from: c */
    public int f26352c;

    /* renamed from: d */
    public int f26353d = -1;

    /* renamed from: e */
    public Key f26354e;

    /* renamed from: f */
    public List f26355f;

    /* renamed from: g */
    public int f26356g;

    /* renamed from: h */
    public volatile ModelLoader.LoadData f26357h;

    /* renamed from: i */
    public File f26358i;

    /* renamed from: j */
    public tb2 f26359j;

    public sb2(C0538az c0538az, RunnableC1213fz runnableC1213fz) {
        this.f26351b = c0538az;
        this.f26350a = runnableC1213fz;
    }

    @Override // p000.InterfaceC1667oy
    /* renamed from: a */
    public final boolean mo5998a() {
        ArrayList m1981a = this.f26351b.m1981a();
        boolean z = false;
        if (m1981a.isEmpty()) {
            return false;
        }
        C0538az c0538az = this.f26351b;
        List<Class<?>> registeredResourceClasses = c0538az.f7800c.getRegistry().getRegisteredResourceClasses(c0538az.f7801d.getClass(), c0538az.f7804g, c0538az.f7808k);
        if (registeredResourceClasses.isEmpty()) {
            if (File.class.equals(this.f26351b.f7808k)) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f26351b.f7801d.getClass() + " to " + this.f26351b.f7808k);
        }
        while (true) {
            List list = this.f26355f;
            if (list != null && this.f26356g < list.size()) {
                this.f26357h = null;
                while (!z && this.f26356g < this.f26355f.size()) {
                    List list2 = this.f26355f;
                    int i = this.f26356g;
                    this.f26356g = i + 1;
                    ModelLoader modelLoader = (ModelLoader) list2.get(i);
                    File file = this.f26358i;
                    C0538az c0538az2 = this.f26351b;
                    this.f26357h = modelLoader.buildLoadData(file, c0538az2.f7802e, c0538az2.f7803f, c0538az2.f7806i);
                    if (this.f26357h != null) {
                        C0538az c0538az3 = this.f26351b;
                        if (c0538az3.f7800c.getRegistry().getLoadPath(this.f26357h.fetcher.getDataClass(), c0538az3.f7804g, c0538az3.f7808k) != null) {
                            this.f26357h.fetcher.loadData(this.f26351b.f7812o, this);
                            z = true;
                        }
                    }
                }
                return z;
            }
            int i2 = this.f26353d + 1;
            this.f26353d = i2;
            if (i2 >= registeredResourceClasses.size()) {
                int i3 = this.f26352c + 1;
                this.f26352c = i3;
                if (i3 >= m1981a.size()) {
                    return false;
                }
                this.f26353d = 0;
            }
            Key key = (Key) m1981a.get(this.f26352c);
            Class<?> cls = registeredResourceClasses.get(this.f26353d);
            Transformation m1983c = this.f26351b.m1983c(cls);
            ArrayPool arrayPool = this.f26351b.f7800c.getArrayPool();
            C0538az c0538az4 = this.f26351b;
            this.f26359j = new tb2(arrayPool, key, c0538az4.f7811n, c0538az4.f7802e, c0538az4.f7803f, m1983c, cls, c0538az4.f7806i);
            File file2 = c0538az4.f7805h.m5200a().get(this.f26359j);
            this.f26358i = file2;
            if (file2 != null) {
                this.f26354e = key;
                this.f26355f = this.f26351b.f7800c.getRegistry().getModelLoaders(file2);
                this.f26356g = 0;
            }
        }
    }

    @Override // p000.InterfaceC1667oy
    public final void cancel() {
        ModelLoader.LoadData loadData = this.f26357h;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void onDataReady(Object obj) {
        this.f26350a.onDataFetcherReady(this.f26354e, obj, this.f26357h.fetcher, DataSource.RESOURCE_DISK_CACHE, this.f26359j);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void onLoadFailed(Exception exc) {
        this.f26350a.onDataFetcherFailed(this.f26359j, exc, this.f26357h.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }
}
