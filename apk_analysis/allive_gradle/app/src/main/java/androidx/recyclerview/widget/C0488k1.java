package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.k1 */
/* loaded from: classes.dex */
public final class C0488k1 {

    /* renamed from: a */
    public final SimpleArrayMap f7428a = new SimpleArrayMap();

    /* renamed from: b */
    public final LongSparseArray f7429b = new LongSparseArray();

    /* renamed from: a */
    public final void m1874a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        SimpleArrayMap simpleArrayMap = this.f7428a;
        C0485j1 c0485j1 = (C0485j1) simpleArrayMap.get(viewHolder);
        if (c0485j1 == null) {
            c0485j1 = C0485j1.m1873a();
            simpleArrayMap.put(viewHolder, c0485j1);
        }
        c0485j1.f7417c = itemHolderInfo;
        c0485j1.f7415a |= 8;
    }

    /* renamed from: b */
    public final RecyclerView.ItemAnimator.ItemHolderInfo m1875b(RecyclerView.ViewHolder viewHolder, int i) {
        C0485j1 c0485j1;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        SimpleArrayMap simpleArrayMap = this.f7428a;
        int indexOfKey = simpleArrayMap.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (c0485j1 = (C0485j1) simpleArrayMap.valueAt(indexOfKey)) != null) {
            int i2 = c0485j1.f7415a;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                c0485j1.f7415a = i3;
                if (i == 4) {
                    itemHolderInfo = c0485j1.f7416b;
                } else if (i == 8) {
                    itemHolderInfo = c0485j1.f7417c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    simpleArrayMap.removeAt(indexOfKey);
                    c0485j1.f7415a = 0;
                    c0485j1.f7416b = null;
                    c0485j1.f7417c = null;
                    C0485j1.f7414d.release(c0485j1);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final void m1876c(RecyclerView.ViewHolder viewHolder) {
        C0485j1 c0485j1 = (C0485j1) this.f7428a.get(viewHolder);
        if (c0485j1 == null) {
            return;
        }
        c0485j1.f7415a &= -2;
    }

    /* renamed from: d */
    public final void m1877d(RecyclerView.ViewHolder viewHolder) {
        LongSparseArray longSparseArray = this.f7429b;
        int size = longSparseArray.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (viewHolder == longSparseArray.valueAt(size)) {
                longSparseArray.removeAt(size);
                break;
            }
            size--;
        }
        C0485j1 c0485j1 = (C0485j1) this.f7428a.remove(viewHolder);
        if (c0485j1 != null) {
            c0485j1.f7415a = 0;
            c0485j1.f7416b = null;
            c0485j1.f7417c = null;
            C0485j1.f7414d.release(c0485j1);
        }
    }
}
