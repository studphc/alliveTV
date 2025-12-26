package p000;

/* renamed from: mb */
/* loaded from: classes.dex */
public final class C1542mb extends AbstractC2041z1 {

    /* renamed from: a */
    public final /* synthetic */ int f22879a;

    /* renamed from: b */
    public final /* synthetic */ AbstractC1579nb f22880b;

    public C1542mb(AbstractC1579nb abstractC1579nb, int i) {
        this.f22880b = abstractC1579nb;
        this.f22879a = i;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        AbstractC1579nb abstractC1579nb = this.f22880b;
        return abstractC1579nb.f23316a.keySet().asList().get(this.f22879a);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f22880b.mo6331e(this.f22879a);
    }

    @Override // p000.AbstractC2041z1, java.util.Map.Entry
    public final Object setValue(Object obj) {
        return this.f22880b.mo6332f(this.f22879a, obj);
    }
}
