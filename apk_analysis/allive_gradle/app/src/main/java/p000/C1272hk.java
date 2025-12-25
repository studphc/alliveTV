package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheLoader;
import java.io.Serializable;

/* renamed from: hk */
/* loaded from: classes.dex */
public final class C1272hk extends CacheLoader implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Function f18080a;

    public C1272hk(Function function) {
        this.f18080a = (Function) Preconditions.checkNotNull(function);
    }

    @Override // com.google.common.cache.CacheLoader
    public final Object load(Object obj) {
        return this.f18080a.apply(Preconditions.checkNotNull(obj));
    }
}
