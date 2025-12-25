package p000;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;

/* renamed from: u1 */
/* loaded from: classes.dex */
public final class C1856u1 extends C1708q1 implements Set {

    /* renamed from: f */
    public final /* synthetic */ AbstractC1930w1 f27063f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1856u1(AbstractC1930w1 abstractC1930w1, Object obj, Set set) {
        super(abstractC1930w1, obj, set, null);
        this.f27063f = abstractC1930w1;
    }

    @Override // p000.C1708q1, java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean m4071c = Sets.m4071c((Set) this.f25401b, collection);
        if (m4071c) {
            int size2 = this.f25401b.size();
            this.f27063f.f28032g += size2 - size;
            m6949c();
        }
        return m4071c;
    }
}
