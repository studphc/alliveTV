package p000;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public final class p90 implements Resource {

    /* renamed from: a */
    public final boolean f25069a;

    /* renamed from: b */
    public final boolean f25070b;

    /* renamed from: c */
    public final Resource f25071c;

    /* renamed from: d */
    public final o90 f25072d;

    /* renamed from: e */
    public final Key f25073e;

    /* renamed from: f */
    public int f25074f;

    /* renamed from: g */
    public boolean f25075g;

    public p90(Resource resource, boolean z, boolean z2, Key key, Engine engine) {
        this.f25071c = (Resource) Preconditions.checkNotNull(resource);
        this.f25069a = z;
        this.f25070b = z2;
        this.f25073e = key;
        this.f25072d = (o90) Preconditions.checkNotNull(engine);
    }

    /* renamed from: a */
    public final synchronized void m6891a() {
        if (!this.f25075g) {
            this.f25074f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* renamed from: b */
    public final void m6892b() {
        boolean z;
        synchronized (this) {
            int i = this.f25074f;
            if (i > 0) {
                z = true;
                int i2 = i - 1;
                this.f25074f = i2;
                if (i2 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.f25072d.onResourceReleased(this.f25073e, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return this.f25071c.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class getResourceClass() {
        return this.f25071c.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return this.f25071c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final synchronized void recycle() {
        if (this.f25074f <= 0) {
            if (!this.f25075g) {
                this.f25075g = true;
                if (this.f25070b) {
                    this.f25071c.recycle();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f25069a + ", listener=" + this.f25072d + ", key=" + this.f25073e + ", acquired=" + this.f25074f + ", isRecycled=" + this.f25075g + ", resource=" + this.f25071c + '}';
    }
}
