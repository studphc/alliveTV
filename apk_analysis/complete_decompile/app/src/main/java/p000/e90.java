package p000;

import com.bumptech.glide.util.pool.FactoryPools;

/* loaded from: classes.dex */
public final class e90 implements FactoryPools.Factory {

    /* renamed from: a */
    public final /* synthetic */ f90 f16716a;

    public e90(f90 f90Var) {
        this.f16716a = f90Var;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
    public final Object create() {
        f90 f90Var = this.f16716a;
        return new RunnableC1213fz(f90Var.f17181a, f90Var.f17182b);
    }
}
