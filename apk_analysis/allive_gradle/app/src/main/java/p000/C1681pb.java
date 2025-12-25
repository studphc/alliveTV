package p000;

import com.google.common.collect.ArrayTable;

/* renamed from: pb */
/* loaded from: classes.dex */
public final class C1681pb extends AbstractC1579nb {

    /* renamed from: b */
    public final /* synthetic */ int f25098b;

    /* renamed from: c */
    public final /* synthetic */ ArrayTable f25099c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1681pb(ArrayTable arrayTable, int i) {
        super(arrayTable.f14616f);
        this.f25098b = i;
        switch (i) {
            case 1:
                this.f25099c = arrayTable;
                super(arrayTable.f14615e);
                return;
            default:
                this.f25099c = arrayTable;
                return;
        }
    }

    @Override // p000.AbstractC1579nb
    /* renamed from: c */
    public final String mo6330c() {
        switch (this.f25098b) {
            case 0:
                return "Column";
            default:
                return "Row";
        }
    }

    @Override // p000.AbstractC1579nb
    /* renamed from: e */
    public final Object mo6331e(int i) {
        switch (this.f25098b) {
            case 0:
                return new C1616ob(this.f25099c, i, 0);
            default:
                return new C1616ob(this.f25099c, i, 1);
        }
    }

    @Override // p000.AbstractC1579nb
    /* renamed from: f */
    public final Object mo6332f(int i, Object obj) {
        switch (this.f25098b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // p000.AbstractC1579nb, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        switch (this.f25098b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
