package p000;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class v92 implements Serializable {

    /* renamed from: a */
    public final Range f27678a;

    /* renamed from: b */
    public final DiscreteDomain f27679b;

    public v92(Range range, DiscreteDomain discreteDomain) {
        this.f27678a = range;
        this.f27679b = discreteDomain;
    }

    private Object readResolve() {
        return new w92(this.f27678a, this.f27679b);
    }
}
