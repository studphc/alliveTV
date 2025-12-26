package p000;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class q80 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final DiscreteDomain f25483a;

    public q80(DiscreteDomain discreteDomain) {
        this.f25483a = discreteDomain;
    }

    private Object readResolve() {
        return new ContiguousSet(this.f25483a);
    }
}
