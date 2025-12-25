package p000;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.collection.IndexBasedArrayIterator;

/* renamed from: fb */
/* loaded from: classes.dex */
public final class C1189fb extends IndexBasedArrayIterator {

    /* renamed from: d */
    public final /* synthetic */ int f17195d;

    /* renamed from: e */
    public final /* synthetic */ Object f17196e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1189fb(ArraySet arraySet) {
        super(arraySet.get_size$collection());
        this.f17195d = 2;
        this.f17196e = arraySet;
    }

    @Override // androidx.collection.IndexBasedArrayIterator
    public final Object elementAt(int i) {
        switch (this.f17195d) {
            case 0:
                return ((ArrayMap) this.f17196e).keyAt(i);
            case 1:
                return ((ArrayMap) this.f17196e).valueAt(i);
            default:
                return ((ArraySet) this.f17196e).valueAt(i);
        }
    }

    @Override // androidx.collection.IndexBasedArrayIterator
    public final void removeAt(int i) {
        switch (this.f17195d) {
            case 0:
                ((ArrayMap) this.f17196e).removeAt(i);
                return;
            case 1:
                ((ArrayMap) this.f17196e).removeAt(i);
                return;
            default:
                ((ArraySet) this.f17196e).removeAt(i);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1189fb(ArrayMap arrayMap, int i) {
        super(arrayMap.getF1755c());
        this.f17195d = i;
        switch (i) {
            case 1:
                this.f17196e = arrayMap;
                super(arrayMap.getF1755c());
                return;
            default:
                this.f17196e = arrayMap;
                return;
        }
    }
}
