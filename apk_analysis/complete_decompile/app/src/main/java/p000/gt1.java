package p000;

import com.google.common.base.Objects;
import com.google.common.collect.AbstractC0955y1;
import com.google.common.collect.C0869f2;

/* loaded from: classes.dex */
public final class gt1 extends AbstractC0955y1 {

    /* renamed from: a */
    public final Object f17830a;

    /* renamed from: b */
    public int f17831b;

    /* renamed from: c */
    public final /* synthetic */ C0869f2 f17832c;

    public gt1(C0869f2 c0869f2, int i) {
        this.f17832c = c0869f2;
        this.f17830a = c0869f2.f14819a[i];
        this.f17831b = i;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final int getCount() {
        int i = this.f17831b;
        C0869f2 c0869f2 = this.f17832c;
        Object obj = this.f17830a;
        if (i == -1 || i >= c0869f2.f14821c || !Objects.equal(obj, c0869f2.f14819a[i])) {
            this.f17831b = c0869f2.m4095g(obj);
        }
        int i2 = this.f17831b;
        if (i2 == -1) {
            return 0;
        }
        return c0869f2.f14820b[i2];
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final Object getElement() {
        return this.f17830a;
    }
}
