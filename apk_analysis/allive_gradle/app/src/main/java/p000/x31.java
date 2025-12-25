package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class x31 implements Serializable {

    /* renamed from: a */
    public final ImmutableList f28433a;

    public x31(ImmutableList immutableList) {
        this.f28433a = immutableList;
    }

    public Object readResolve() {
        ImmutableList immutableList = this.f28433a;
        if (immutableList.isEmpty()) {
            return ImmutableRangeSet.m3967of();
        }
        if (immutableList.equals(ImmutableList.m3903of(Range.all()))) {
            return ImmutableRangeSet.f14691d;
        }
        return new ImmutableRangeSet(immutableList);
    }
}
