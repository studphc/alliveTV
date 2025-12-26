package p000;

import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* loaded from: classes.dex */
public final class rd1 implements Resource, FactoryPools.Poolable {

    /* renamed from: e */
    public static final Pools.Pool f25935e = FactoryPools.threadSafe(20, new Object());

    /* renamed from: a */
    public final StateVerifier f25936a = StateVerifier.newInstance();

    /* renamed from: b */
    public Resource f25937b;

    /* renamed from: c */
    public boolean f25938c;

    /* renamed from: d */
    public boolean f25939d;

    /* renamed from: a */
    public final synchronized void m7268a() {
        this.f25936a.throwIfRecycled();
        if (this.f25938c) {
            this.f25938c = false;
            if (this.f25939d) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return this.f25937b.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class getResourceClass() {
        return this.f25937b.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return this.f25937b.getSize();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier getVerifier() {
        return this.f25936a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final synchronized void recycle() {
        this.f25936a.throwIfRecycled();
        this.f25939d = true;
        if (!this.f25938c) {
            this.f25937b.recycle();
            this.f25937b = null;
            f25935e.release(this);
        }
    }
}
