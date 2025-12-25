package p000;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class v31 implements Serializable {

    /* renamed from: a */
    public final ImmutableList f27638a;

    /* renamed from: b */
    public final DiscreteDomain f27639b;

    public v31(ImmutableList immutableList, DiscreteDomain discreteDomain) {
        this.f27638a = immutableList;
        this.f27639b = discreteDomain;
    }

    public Object readResolve() {
        return new ImmutableRangeSet(this.f27638a).asSet(this.f27639b);
    }
}
