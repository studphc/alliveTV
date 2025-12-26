package p000;

/* loaded from: classes.dex */
public final class af1 extends jb1 {

    /* renamed from: j */
    public final /* synthetic */ int f161j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ af1(zf1 zf1Var, int i) {
        super(zf1Var);
        this.f161j = i;
    }

    @Override // p000.jb1, java.util.Iterator
    public Object next() {
        switch (this.f161j) {
            case 1:
                return m5428e().f28936a;
            case 2:
                return m5428e().f28937b;
            default:
                return super.next();
        }
    }
}
