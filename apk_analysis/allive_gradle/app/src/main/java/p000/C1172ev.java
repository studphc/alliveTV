package p000;

/* renamed from: ev */
/* loaded from: classes.dex */
public final class C1172ev implements InterfaceC1209fv {

    /* renamed from: a */
    public boolean f16984a;

    /* renamed from: b */
    public String f16985b;

    /* renamed from: c */
    public String f16986c;

    /* renamed from: d */
    public float f16987d;

    /* renamed from: e */
    public float f16988e;

    @Override // p000.InterfaceC1209fv
    public final float value() {
        float f = this.f16987d;
        if (f >= this.f16988e) {
            this.f16984a = true;
        }
        if (!this.f16984a) {
            this.f16987d = f + 1.0f;
        }
        return this.f16987d;
    }
}
