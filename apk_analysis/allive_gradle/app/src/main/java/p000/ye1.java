package p000;

/* loaded from: classes.dex */
public abstract class ye1 implements cf1 {

    /* renamed from: a */
    public final Object f28923a;

    /* renamed from: b */
    public final int f28924b;

    /* renamed from: c */
    public final cf1 f28925c;

    public ye1(Object obj, int i, cf1 cf1Var) {
        this.f28923a = obj;
        this.f28924b = i;
        this.f28925c = cf1Var;
    }

    @Override // p000.cf1
    /* renamed from: a */
    public final cf1 mo2229a() {
        return this.f28925c;
    }

    @Override // p000.cf1
    /* renamed from: c */
    public final int mo2230c() {
        return this.f28924b;
    }

    @Override // p000.cf1
    public final Object getKey() {
        return this.f28923a;
    }
}
