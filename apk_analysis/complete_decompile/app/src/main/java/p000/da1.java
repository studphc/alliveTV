package p000;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class da1 extends AbstractList implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f16312a;

    /* renamed from: b */
    public final Object[] f16313b;

    public da1(Object obj, Object[] objArr) {
        this.f16312a = obj;
        this.f16313b = (Object[]) Preconditions.checkNotNull(objArr);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, size());
        if (i == 0) {
            return this.f16312a;
        }
        return this.f16313b[i - 1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return IntMath.saturatedAdd(this.f16313b.length, 1);
    }
}
