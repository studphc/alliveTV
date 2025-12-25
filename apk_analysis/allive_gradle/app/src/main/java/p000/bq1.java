package p000;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class bq1 extends oh2 {

    /* renamed from: a */
    public final /* synthetic */ Object f8132a;

    /* renamed from: b */
    public final /* synthetic */ cq1 f8133b;

    public bq1(cq1 cq1Var, Object obj) {
        this.f8133b = cq1Var;
        this.f8132a = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new aq1(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f8133b.f16083f.containsKey(this.f8132a) ? 1 : 0;
    }
}
