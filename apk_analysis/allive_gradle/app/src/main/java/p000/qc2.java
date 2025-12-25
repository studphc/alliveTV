package p000;

import java.util.List;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class qc2 extends AbstractList {

    /* renamed from: a */
    public final List f25514a;

    public qc2(List delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f25514a = delegate;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f25514a.get(AbstractC1363jq.access$reverseElementIndex(this, i));
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public final int getF21007c() {
        return this.f25514a.size();
    }
}
