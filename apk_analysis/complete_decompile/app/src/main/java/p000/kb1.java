package p000;

import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import java.io.ObjectInputStream;

/* loaded from: classes.dex */
public final class kb1 extends ob1 implements LoadingCache {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    public transient LoadingCache f20813n;

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f20813n = m6526e().build(this.f23709l);
    }

    private Object readResolve() {
        return this.f20813n;
    }

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public final Object apply(Object obj) {
        return this.f20813n.apply(obj);
    }

    @Override // com.google.common.cache.LoadingCache
    public final Object get(Object obj) {
        return this.f20813n.get(obj);
    }

    @Override // com.google.common.cache.LoadingCache
    public final ImmutableMap getAll(Iterable iterable) {
        return this.f20813n.getAll(iterable);
    }

    @Override // com.google.common.cache.LoadingCache
    public final Object getUnchecked(Object obj) {
        return this.f20813n.getUnchecked(obj);
    }

    @Override // com.google.common.cache.LoadingCache
    public final void refresh(Object obj) {
        this.f20813n.refresh(obj);
    }
}
