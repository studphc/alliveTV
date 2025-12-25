package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class cp2 extends ap2 {

    /* renamed from: b */
    public final AtomicReferenceArray f16063b;

    /* renamed from: c */
    public final Supplier f16064c;

    /* renamed from: d */
    public final int f16065d;

    /* renamed from: e */
    public final ReferenceQueue f16066e;

    public cp2(int i, Supplier supplier) {
        super(i);
        int i2;
        this.f16066e = new ReferenceQueue();
        int i3 = this.f7698a;
        if (i3 == -1) {
            i2 = Integer.MAX_VALUE;
        } else {
            i2 = i3 + 1;
        }
        this.f16065d = i2;
        this.f16063b = new AtomicReferenceArray(i2);
        this.f16064c = supplier;
    }

    @Override // com.google.common.util.concurrent.Striped
    public final Object getAt(int i) {
        Object obj;
        int i2;
        Object obj2;
        int i3 = this.f16065d;
        if (i3 != Integer.MAX_VALUE) {
            Preconditions.checkElementIndex(i, i3);
        }
        AtomicReferenceArray atomicReferenceArray = this.f16063b;
        bp2 bp2Var = (bp2) atomicReferenceArray.get(i);
        if (bp2Var == null) {
            obj = null;
        } else {
            obj = bp2Var.get();
        }
        if (obj != null) {
            return obj;
        }
        Object obj3 = this.f16064c.get();
        ReferenceQueue referenceQueue = this.f16066e;
        bp2 bp2Var2 = new bp2(obj3, i, referenceQueue);
        while (!atomicReferenceArray.compareAndSet(i, bp2Var, bp2Var2)) {
            if (atomicReferenceArray.get(i) != bp2Var) {
                bp2Var = (bp2) atomicReferenceArray.get(i);
                if (bp2Var == null) {
                    obj2 = null;
                } else {
                    obj2 = bp2Var.get();
                }
                if (obj2 != null) {
                    return obj2;
                }
            }
        }
        while (true) {
            Reference poll = referenceQueue.poll();
            if (poll != null) {
                bp2 bp2Var3 = (bp2) poll;
                do {
                    i2 = bp2Var3.f8122a;
                    if (atomicReferenceArray.compareAndSet(i2, bp2Var3, null)) {
                        break;
                    }
                } while (atomicReferenceArray.get(i2) == bp2Var3);
            } else {
                return obj3;
            }
        }
    }

    @Override // com.google.common.util.concurrent.Striped
    public final int size() {
        return this.f16065d;
    }
}
