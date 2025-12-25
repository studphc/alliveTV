package p000;

import java.util.RandomAccess;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: e1 */
/* loaded from: classes2.dex */
public final class C1142e1 extends AbstractList implements RandomAccess {

    /* renamed from: a */
    public final AbstractList f16639a;

    /* renamed from: b */
    public final int f16640b;

    /* renamed from: c */
    public final int f16641c;

    public C1142e1(AbstractList list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f16639a = list;
        this.f16640b = i;
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, list.size());
        this.f16641c = i2 - i;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(i, this.f16641c);
        return this.f16639a.get(this.f16640b + i);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public final int getF21007c() {
        return this.f16641c;
    }
}
