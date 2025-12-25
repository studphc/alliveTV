package p000;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.List;

/* loaded from: classes.dex */
public class ea1 extends AbstractList {

    /* renamed from: a */
    public final List f16740a;

    /* renamed from: b */
    public final int f16741b;

    public ea1(int i, List list) {
        this.f16740a = list;
        this.f16741b = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, size());
        int i2 = this.f16741b;
        int i3 = i * i2;
        List list = this.f16740a;
        return list.subList(i3, Math.min(i2 + i3, list.size()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f16740a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return IntMath.divide(this.f16740a.size(), this.f16741b, RoundingMode.CEILING);
    }
}
