package p000;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class ma1 extends AbstractList implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f22875a;

    /* renamed from: b */
    public final Object f22876b;

    /* renamed from: c */
    public final Object[] f22877c;

    public ma1(Object obj, Object obj2, Object[] objArr) {
        this.f22875a = obj;
        this.f22876b = obj2;
        this.f22877c = (Object[]) Preconditions.checkNotNull(objArr);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        if (i != 0) {
            if (i != 1) {
                Preconditions.checkElementIndex(i, size());
                return this.f22877c[i - 2];
            }
            return this.f22876b;
        }
        return this.f22875a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return IntMath.saturatedAdd(this.f22877c.length, 2);
    }
}
