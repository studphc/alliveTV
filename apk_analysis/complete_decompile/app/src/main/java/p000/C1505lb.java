package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.ImmutableList;

/* renamed from: lb */
/* loaded from: classes.dex */
public final class C1505lb extends AbstractC0002a1 {

    /* renamed from: c */
    public final /* synthetic */ int f22431c;

    /* renamed from: d */
    public final Object f22432d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1505lb(int i, int i2, Object obj) {
        super(i, 0);
        this.f22431c = i2;
        this.f22432d = obj;
    }

    @Override // p000.AbstractC0002a1
    /* renamed from: a */
    public final Object mo1a(int i) {
        switch (this.f22431c) {
            case 0:
                ArrayTable arrayTable = (ArrayTable) this.f22432d;
                ImmutableList immutableList = arrayTable.f14614d;
                return arrayTable.m3831at(i / immutableList.size(), i % immutableList.size());
            case 1:
                AbstractC1579nb abstractC1579nb = (AbstractC1579nb) this.f22432d;
                Preconditions.checkElementIndex(i, abstractC1579nb.f23316a.size());
                return new C1542mb(abstractC1579nb, i);
            case 2:
                return ((Iterable[]) ((ps0) this.f22432d).f25277c)[i].iterator();
            case 3:
                return ((ImmutableList) this.f22432d).get(i);
            default:
                return new ih2(((ph2) this.f22432d).f25181a, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1505lb(int i, ImmutableList immutableList) {
        super(immutableList.size(), i);
        this.f22431c = 3;
        this.f22432d = immutableList;
    }
}
