package p000;

import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class ez0 implements Supplier, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final int f17045a;

    public ez0(int i) {
        this.f17045a = i;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return Maps.newLinkedHashMapWithExpectedSize(this.f17045a);
    }
}
