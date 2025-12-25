package p000;

import com.google.common.collect.UnmodifiableIterator;

/* loaded from: classes.dex */
public final class hw2 extends iw2 {

    /* renamed from: b */
    public final /* synthetic */ jw2 f18206b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hw2(jw2 jw2Var) {
        super(jw2Var);
        this.f18206b = jw2Var;
    }

    @Override // p000.iw2
    /* renamed from: c */
    public final UnmodifiableIterator mo5135c() {
        jw2 jw2Var = this.f18206b;
        if (jw2Var.f20665a.isEmpty()) {
            return z51.f29250d;
        }
        return new C0566bq(this, jw2Var.f20666b.f14758a.headMap(jw2Var.f20665a.f14748b, false).descendingMap().values().iterator(), 10);
    }
}
