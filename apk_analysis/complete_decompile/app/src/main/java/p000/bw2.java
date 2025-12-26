package p000;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class bw2 implements Supplier, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Comparator f8170a;

    public bw2(Comparator comparator) {
        this.f8170a = comparator;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return new TreeMap(this.f8170a);
    }
}
