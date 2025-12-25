package p000;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class pp1 implements DataFetcher, DataFetcher.DataCallback {

    /* renamed from: a */
    public final ArrayList f25247a;

    /* renamed from: b */
    public final Pools.Pool f25248b;

    /* renamed from: c */
    public int f25249c;

    /* renamed from: d */
    public Priority f25250d;

    /* renamed from: e */
    public DataFetcher.DataCallback f25251e;

    /* renamed from: f */
    public List f25252f;

    /* renamed from: g */
    public boolean f25253g;

    public pp1(ArrayList arrayList, Pools.Pool pool) {
        this.f25248b = pool;
        Preconditions.checkNotEmpty(arrayList);
        this.f25247a = arrayList;
        this.f25249c = 0;
    }

    /* renamed from: a */
    public final void m6920a() {
        if (this.f25253g) {
            return;
        }
        if (this.f25249c < this.f25247a.size() - 1) {
            this.f25249c++;
            loadData(this.f25250d, this.f25251e);
        } else {
            Preconditions.checkNotNull(this.f25252f);
            this.f25251e.onLoadFailed(new GlideException("Fetch failed", new ArrayList(this.f25252f)));
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
        this.f25253g = true;
        Iterator it = this.f25247a.iterator();
        while (it.hasNext()) {
            ((DataFetcher) it.next()).cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
        List list = this.f25252f;
        if (list != null) {
            this.f25248b.release(list);
        }
        this.f25252f = null;
        Iterator it = this.f25247a.iterator();
        while (it.hasNext()) {
            ((DataFetcher) it.next()).cleanup();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class getDataClass() {
        return ((DataFetcher) this.f25247a.get(0)).getDataClass();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return ((DataFetcher) this.f25247a.get(0)).getDataSource();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        this.f25250d = priority;
        this.f25251e = dataCallback;
        this.f25252f = (List) this.f25248b.acquire();
        ((DataFetcher) this.f25247a.get(this.f25249c)).loadData(priority, this);
        if (this.f25253g) {
            cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void onDataReady(Object obj) {
        if (obj != null) {
            this.f25251e.onDataReady(obj);
        } else {
            m6920a();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void onLoadFailed(Exception exc) {
        ((List) Preconditions.checkNotNull(this.f25252f)).add(exc);
        m6920a();
    }
}
