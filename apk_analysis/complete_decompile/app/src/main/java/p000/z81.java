package p000;

/* loaded from: classes.dex */
public final class z81 extends AbstractC2041z1 {

    /* renamed from: a */
    public final Object f29269a;

    /* renamed from: b */
    public Object f29270b;

    /* renamed from: c */
    public z81 f29271c;

    /* renamed from: d */
    public z81 f29272d;

    /* renamed from: e */
    public z81 f29273e;

    /* renamed from: f */
    public z81 f29274f;

    public z81(Object obj, Object obj2) {
        this.f29269a = obj;
        this.f29270b = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f29269a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f29270b;
    }

    @Override // p000.AbstractC2041z1, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f29270b;
        this.f29270b = obj;
        return obj2;
    }
}
