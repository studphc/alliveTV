package p000;

import com.google.common.base.Function;
import com.google.common.collect.Interner;

/* loaded from: classes.dex */
public final class w41 implements Function {

    /* renamed from: a */
    public final Interner f28068a;

    public w41(Interner interner) {
        this.f28068a = interner;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return this.f28068a.intern(obj);
    }

    @Override // com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (obj instanceof w41) {
            return this.f28068a.equals(((w41) obj).f28068a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f28068a.hashCode();
    }
}
