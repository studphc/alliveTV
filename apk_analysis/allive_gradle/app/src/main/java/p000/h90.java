package p000;

import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.util.pool.FactoryPools;

/* loaded from: classes.dex */
public final class h90 {

    /* renamed from: a */
    public final GlideExecutor f17980a;

    /* renamed from: b */
    public final GlideExecutor f17981b;

    /* renamed from: c */
    public final GlideExecutor f17982c;

    /* renamed from: d */
    public final GlideExecutor f17983d;

    /* renamed from: e */
    public final Engine f17984e;

    /* renamed from: f */
    public final Engine f17985f;

    /* renamed from: g */
    public final Pools.Pool f17986g = FactoryPools.threadSafe(150, new g90(this));

    public h90(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Engine engine, Engine engine2) {
        this.f17980a = glideExecutor;
        this.f17981b = glideExecutor2;
        this.f17982c = glideExecutor3;
        this.f17983d = glideExecutor4;
        this.f17984e = engine;
        this.f17985f = engine2;
    }
}
