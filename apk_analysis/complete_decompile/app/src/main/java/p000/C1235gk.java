package p000;

import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: gk */
/* loaded from: classes.dex */
public final class C1235gk extends CacheLoader {

    /* renamed from: a */
    public final /* synthetic */ CacheLoader f17728a;

    /* renamed from: b */
    public final /* synthetic */ Executor f17729b;

    public C1235gk(CacheLoader cacheLoader, Executor executor) {
        this.f17728a = cacheLoader;
        this.f17729b = executor;
    }

    @Override // com.google.common.cache.CacheLoader
    public final Object load(Object obj) {
        return this.f17728a.load(obj);
    }

    @Override // com.google.common.cache.CacheLoader
    public final Map loadAll(Iterable iterable) {
        return this.f17728a.loadAll(iterable);
    }

    @Override // com.google.common.cache.CacheLoader
    public final ListenableFuture reload(Object obj, Object obj2) {
        ListenableFutureTask create = ListenableFutureTask.create(new ec3(this, obj, obj2, 2));
        this.f17729b.execute(create);
        return create;
    }
}
