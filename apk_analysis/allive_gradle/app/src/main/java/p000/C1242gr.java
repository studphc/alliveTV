package p000;

/* renamed from: gr */
/* loaded from: classes.dex */
public final class C1242gr extends AbstractC2004y1 {

    /* renamed from: f */
    public final /* synthetic */ int f17799f;

    /* renamed from: g */
    public final /* synthetic */ C1328ir f17800g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1242gr(C1328ir c1328ir, int i) {
        super(c1328ir);
        this.f17799f = i;
        this.f17800g = c1328ir;
    }

    @Override // p000.AbstractC2004y1
    /* renamed from: a */
    public final Object mo4979a(int i) {
        switch (this.f17799f) {
            case 0:
                return this.f17800g.m5358u()[i];
            case 1:
                return new fz0(this.f17800g, i);
            default:
                return this.f17800g.m5359v()[i];
        }
    }
}
