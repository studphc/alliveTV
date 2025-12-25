package androidx.collection;

import androidx.collection.ScatterSet;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* renamed from: androidx.collection.b */
/* loaded from: classes.dex */
public final class C0112b extends ScatterSet.SetWrapper implements KMutableSet {

    /* renamed from: b */
    public final /* synthetic */ MutableScatterSet f1762b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0112b(MutableScatterSet mutableScatterSet) {
        super();
        this.f1762b = mutableScatterSet;
    }

    @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.f1762b.add(obj);
    }

    @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f1762b.addAll(elements);
    }

    @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
    public final void clear() {
        this.f1762b.clear();
    }

    @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new MutableScatterSet$MutableSetWrapper$iterator$1(this.f1762b);
    }

    @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f1762b.remove(obj);
    }

    @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableScatterSet mutableScatterSet = this.f1762b;
        int i = mutableScatterSet.get_size();
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            mutableScatterSet.minusAssign((MutableScatterSet) it.next());
        }
        if (i != mutableScatterSet.get_size()) {
            return true;
        }
        return false;
    }

    @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableScatterSet mutableScatterSet = this.f1762b;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        boolean z = false;
        if (length >= 0) {
            int i = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (!elements.contains(mutableScatterSet.elements[i4])) {
                                mutableScatterSet.removeElementAt(i4);
                                z2 = true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return z2;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    z = z2;
                    break;
                }
            }
        }
        return z;
    }
}
