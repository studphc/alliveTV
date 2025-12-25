package p000;

import com.google.common.collect.ArrayTable;

/* renamed from: ob */
/* loaded from: classes.dex */
public final class C1616ob extends AbstractC1579nb {

    /* renamed from: b */
    public final /* synthetic */ int f23691b;

    /* renamed from: c */
    public final int f23692c;

    /* renamed from: d */
    public final /* synthetic */ ArrayTable f23693d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1616ob(ArrayTable arrayTable, int i, int i2) {
        super(arrayTable.f14615e);
        this.f23691b = i2;
        switch (i2) {
            case 1:
                this.f23693d = arrayTable;
                super(arrayTable.f14616f);
                this.f23692c = i;
                return;
            default:
                this.f23693d = arrayTable;
                this.f23692c = i;
                return;
        }
    }

    @Override // p000.AbstractC1579nb
    /* renamed from: c */
    public final String mo6330c() {
        switch (this.f23691b) {
            case 0:
                return "Row";
            default:
                return "Column";
        }
    }

    @Override // p000.AbstractC1579nb
    /* renamed from: e */
    public final Object mo6331e(int i) {
        switch (this.f23691b) {
            case 0:
                return this.f23693d.m3831at(i, this.f23692c);
            default:
                return this.f23693d.m3831at(this.f23692c, i);
        }
    }

    @Override // p000.AbstractC1579nb
    /* renamed from: f */
    public final Object mo6332f(int i, Object obj) {
        switch (this.f23691b) {
            case 0:
                return this.f23693d.set(i, this.f23692c, obj);
            default:
                return this.f23693d.set(this.f23692c, i, obj);
        }
    }
}
