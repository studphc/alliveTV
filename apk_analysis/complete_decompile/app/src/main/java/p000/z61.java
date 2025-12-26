package p000;

import java.util.AbstractList;

/* loaded from: classes.dex */
public final class z61 extends AbstractList {

    /* renamed from: a */
    public final /* synthetic */ Object[] f29256a;

    /* renamed from: b */
    public final /* synthetic */ Object f29257b;

    /* renamed from: c */
    public final /* synthetic */ Object f29258c;

    public z61(Object obj, Object obj2, Object[] objArr) {
        this.f29256a = objArr;
        this.f29257b = obj;
        this.f29258c = obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        if (i != 0) {
            if (i != 1) {
                return this.f29256a[i - 2];
            }
            return this.f29258c;
        }
        return this.f29257b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f29256a.length + 2;
    }
}
