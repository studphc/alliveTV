package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheLoader;
import java.io.Serializable;

/* renamed from: ik */
/* loaded from: classes.dex */
public final class C1309ik extends CacheLoader implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Supplier f18441a;

    public C1309ik(Supplier supplier) {
        this.f18441a = (Supplier) Preconditions.checkNotNull(supplier);
    }

    @Override // com.google.common.cache.CacheLoader
    public final Object load(Object obj) {
        Preconditions.checkNotNull(obj);
        return this.f18441a.get();
    }
}
