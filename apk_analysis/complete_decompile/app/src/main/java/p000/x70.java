package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import java.util.AbstractSet;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class x70 extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ int f28452a = 1;

    /* renamed from: b */
    public final Object f28453b;

    /* renamed from: c */
    public final Object f28454c;

    public x70(BiMap biMap, Object obj) {
        this.f28453b = (Map) Preconditions.checkNotNull(biMap);
        this.f28454c = Preconditions.checkNotNull(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f28452a) {
            case 0:
                Object obj2 = ((Map) this.f28453b).get(this.f28454c);
                if (obj2 != null && obj2.equals(obj)) {
                    return true;
                }
                return false;
            default:
                Integer num = (Integer) ((ih2) ((C0566bq) this.f28454c).f8125e).f18415b.get(obj);
                if (num != null && ((BitSet) this.f28453b).get(num.intValue())) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f28452a) {
            case 0:
                Object obj = ((Map) this.f28453b).get(this.f28454c);
                if (obj == null) {
                    return ImmutableSet.m3971of().iterator();
                }
                return Iterators.singletonIterator(obj);
            default:
                return new hh2(this);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f28452a) {
            case 0:
                if (((Map) this.f28453b).get(this.f28454c) == null) {
                    return 0;
                }
                return 1;
            default:
                return ((ih2) ((C0566bq) this.f28454c).f8125e).f18416c;
        }
    }

    public x70(C0566bq c0566bq, BitSet bitSet) {
        this.f28454c = c0566bq;
        this.f28453b = bitSet;
    }
}
