package p000;

import com.bumptech.glide.util.pool.FactoryPools;

/* loaded from: classes.dex */
public final class g90 implements FactoryPools.Factory {

    /* renamed from: a */
    public final /* synthetic */ h90 f17615a;

    public g90(h90 h90Var) {
        this.f17615a = h90Var;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
    public final Object create() {
        h90 h90Var = this.f17615a;
        return new l90(h90Var.f17980a, h90Var.f17981b, h90Var.f17982c, h90Var.f17983d, h90Var.f17984e, h90Var.f17985f, h90Var.f17986g);
    }
}
