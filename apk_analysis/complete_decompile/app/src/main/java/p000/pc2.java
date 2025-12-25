package p000;

import java.util.List;
import kotlin.collections.AbstractMutableList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class pc2 extends AbstractMutableList {

    /* renamed from: a */
    public final List f25117a;

    public pc2(List delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f25117a = delegate;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        this.f25117a.add(AbstractC1363jq.access$reversePositionIndex(this, i), obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f25117a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f25117a.get(AbstractC1363jq.access$reverseElementIndex(this, i));
    }

    @Override // kotlin.collections.AbstractMutableList
    /* renamed from: getSize */
    public final int getF21018c() {
        return this.f25117a.size();
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object removeAt(int i) {
        return this.f25117a.remove(AbstractC1363jq.access$reverseElementIndex(this, i));
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        return this.f25117a.set(AbstractC1363jq.access$reverseElementIndex(this, i), obj);
    }
}
