package p000;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class rg1 extends rv2 {

    /* renamed from: b */
    public final /* synthetic */ int f25959b;

    /* renamed from: c */
    public final /* synthetic */ Collection f25960c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rg1(Collection collection, Iterator it, int i) {
        super(it);
        this.f25959b = i;
        this.f25960c = collection;
    }

    @Override // p000.rv2
    /* renamed from: a */
    public final Object mo4106a(Object obj) {
        switch (this.f25959b) {
            case 0:
                return new C1530m(this, (Map.Entry) obj, 1);
            case 1:
                return new C1530m(this, (Map.Entry) obj, 2);
            default:
                return yy2.m8356d((Collection) obj, ((er2) this.f25960c).f25273b);
        }
    }
}
