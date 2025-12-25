package p000;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class xo2 extends ap2 {

    /* renamed from: b */
    public final ConcurrentMap f28672b;

    /* renamed from: c */
    public final Supplier f28673c;

    /* renamed from: d */
    public final int f28674d;

    public xo2(int i, Supplier supplier) {
        super(i);
        int i2;
        int i3 = this.f7698a;
        if (i3 == -1) {
            i2 = Integer.MAX_VALUE;
        } else {
            i2 = i3 + 1;
        }
        this.f28674d = i2;
        this.f28673c = supplier;
        this.f28672b = new MapMaker().weakValues().makeMap();
    }

    @Override // com.google.common.util.concurrent.Striped
    public final Object getAt(int i) {
        int i2 = this.f28674d;
        if (i2 != Integer.MAX_VALUE) {
            Preconditions.checkElementIndex(i, i2);
        }
        Integer valueOf = Integer.valueOf(i);
        ConcurrentMap concurrentMap = this.f28672b;
        Object obj = concurrentMap.get(valueOf);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.f28673c.get();
        return MoreObjects.firstNonNull(concurrentMap.putIfAbsent(Integer.valueOf(i), obj2), obj2);
    }

    @Override // com.google.common.util.concurrent.Striped
    public final int size() {
        return this.f28674d;
    }
}
