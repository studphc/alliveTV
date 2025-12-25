package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import p000.ye0;

/* renamed from: androidx.recyclerview.widget.l1 */
/* loaded from: classes.dex */
public final class C0491l1 implements ViewTypeStorage$ViewTypeLookup {

    /* renamed from: a */
    public final SparseIntArray f7434a = new SparseIntArray(1);

    /* renamed from: b */
    public final SparseIntArray f7435b = new SparseIntArray(1);

    /* renamed from: c */
    public final C0487k0 f7436c;

    /* renamed from: d */
    public final /* synthetic */ ViewTypeStorage$IsolatedViewTypeStorage f7437d;

    public C0491l1(ViewTypeStorage$IsolatedViewTypeStorage viewTypeStorage$IsolatedViewTypeStorage, C0487k0 c0487k0) {
        this.f7437d = viewTypeStorage$IsolatedViewTypeStorage;
        this.f7436c = c0487k0;
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public final void dispose() {
        SparseArray sparseArray = this.f7437d.f7310a;
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            if (((C0487k0) sparseArray.valueAt(size)) == this.f7436c) {
                sparseArray.removeAt(size);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public final int globalToLocal(int i) {
        SparseIntArray sparseIntArray = this.f7435b;
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey >= 0) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        StringBuilder m8299s = ye0.m8299s(i, "requested global type ", " does not belong to the adapter:");
        m8299s.append(this.f7436c.f7424c);
        throw new IllegalStateException(m8299s.toString());
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public final int localToGlobal(int i) {
        SparseIntArray sparseIntArray = this.f7434a;
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey > -1) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        ViewTypeStorage$IsolatedViewTypeStorage viewTypeStorage$IsolatedViewTypeStorage = this.f7437d;
        int i2 = viewTypeStorage$IsolatedViewTypeStorage.f7311b;
        viewTypeStorage$IsolatedViewTypeStorage.f7311b = i2 + 1;
        viewTypeStorage$IsolatedViewTypeStorage.f7310a.put(i2, this.f7436c);
        sparseIntArray.put(i, i2);
        this.f7435b.put(i2, i);
        return i2;
    }
}
