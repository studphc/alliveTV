package p000;

import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.FactoryPools;

/* loaded from: classes.dex */
public final class f90 {

    /* renamed from: a */
    public final i90 f17181a;

    /* renamed from: b */
    public final Pools.Pool f17182b = FactoryPools.threadSafe(150, new e90(this));

    /* renamed from: c */
    public int f17183c;

    public f90(i90 i90Var) {
        this.f17181a = i90Var;
    }
}
