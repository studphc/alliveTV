package p000;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class l90 implements FactoryPools.Poolable {

    /* renamed from: z */
    public static final wd0 f22391z = new wd0(12);

    /* renamed from: a */
    public final i12 f22392a;

    /* renamed from: b */
    public final StateVerifier f22393b;

    /* renamed from: c */
    public final Engine f22394c;

    /* renamed from: d */
    public final Pools.Pool f22395d;

    /* renamed from: e */
    public final wd0 f22396e;

    /* renamed from: f */
    public final Engine f22397f;

    /* renamed from: g */
    public final GlideExecutor f22398g;

    /* renamed from: h */
    public final GlideExecutor f22399h;

    /* renamed from: i */
    public final GlideExecutor f22400i;

    /* renamed from: j */
    public final GlideExecutor f22401j;

    /* renamed from: k */
    public final AtomicInteger f22402k;

    /* renamed from: l */
    public n90 f22403l;

    /* renamed from: m */
    public boolean f22404m;

    /* renamed from: n */
    public boolean f22405n;

    /* renamed from: o */
    public boolean f22406o;

    /* renamed from: p */
    public boolean f22407p;

    /* renamed from: q */
    public Resource f22408q;

    /* renamed from: r */
    public DataSource f22409r;

    /* renamed from: s */
    public boolean f22410s;

    /* renamed from: t */
    public GlideException f22411t;

    /* renamed from: u */
    public boolean f22412u;

    /* renamed from: v */
    public p90 f22413v;

    /* renamed from: w */
    public RunnableC1213fz f22414w;

    /* renamed from: x */
    public volatile boolean f22415x;

    /* renamed from: y */
    public boolean f22416y;

    public l90(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Engine engine, Engine engine2, Pools.Pool pool) {
        wd0 wd0Var = f22391z;
        this.f22392a = new i12(new ArrayList(2), 2);
        this.f22393b = StateVerifier.newInstance();
        this.f22402k = new AtomicInteger();
        this.f22398g = glideExecutor;
        this.f22399h = glideExecutor2;
        this.f22400i = glideExecutor3;
        this.f22401j = glideExecutor4;
        this.f22397f = engine;
        this.f22394c = engine2;
        this.f22395d = pool;
        this.f22396e = wd0Var;
    }

    /* renamed from: a */
    public final synchronized void m5899a(ResourceCallback resourceCallback, Executor executor) {
        try {
            this.f22393b.throwIfRecycled();
            i12 i12Var = this.f22392a;
            i12Var.getClass();
            ((ArrayList) i12Var.f18255b).add(new k90(resourceCallback, executor));
            if (this.f22410s) {
                m5901c(1);
                executor.execute(new j90(this, resourceCallback, 1));
            } else if (this.f22412u) {
                m5901c(1);
                executor.execute(new j90(this, resourceCallback, 0));
            } else {
                Preconditions.checkArgument(!this.f22415x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: b */
    public final void m5900b() {
        boolean z;
        p90 p90Var;
        synchronized (this) {
            try {
                this.f22393b.throwIfRecycled();
                Preconditions.checkArgument(m5902d(), "Not yet complete!");
                int decrementAndGet = this.f22402k.decrementAndGet();
                if (decrementAndGet >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    p90Var = this.f22413v;
                    m5905g();
                } else {
                    p90Var = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (p90Var != null) {
            p90Var.m6892b();
        }
    }

    /* renamed from: c */
    public final synchronized void m5901c(int i) {
        p90 p90Var;
        Preconditions.checkArgument(m5902d(), "Not yet complete!");
        if (this.f22402k.getAndAdd(i) == 0 && (p90Var = this.f22413v) != null) {
            p90Var.m6891a();
        }
    }

    /* renamed from: d */
    public final boolean m5902d() {
        if (!this.f22412u && !this.f22410s && !this.f22415x) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public final void m5903e() {
        synchronized (this) {
            try {
                this.f22393b.throwIfRecycled();
                if (this.f22415x) {
                    m5905g();
                    return;
                }
                if (!((ArrayList) this.f22392a.f18255b).isEmpty()) {
                    if (!this.f22412u) {
                        this.f22412u = true;
                        n90 n90Var = this.f22403l;
                        i12 i12Var = this.f22392a;
                        i12Var.getClass();
                        ArrayList arrayList = new ArrayList((ArrayList) i12Var.f18255b);
                        m5901c(arrayList.size() + 1);
                        this.f22397f.onEngineJobComplete(this, n90Var, null);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            k90 k90Var = (k90) it.next();
                            k90Var.f20793b.execute(new j90(this, k90Var.f20792a, 0));
                        }
                        m5900b();
                        return;
                    }
                    throw new IllegalStateException("Already failed once");
                }
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: f */
    public final void m5904f() {
        synchronized (this) {
            try {
                this.f22393b.throwIfRecycled();
                if (this.f22415x) {
                    this.f22408q.recycle();
                    m5905g();
                    return;
                }
                if (!((ArrayList) this.f22392a.f18255b).isEmpty()) {
                    if (!this.f22410s) {
                        wd0 wd0Var = this.f22396e;
                        Resource resource = this.f22408q;
                        boolean z = this.f22404m;
                        n90 n90Var = this.f22403l;
                        Engine engine = this.f22394c;
                        wd0Var.getClass();
                        this.f22413v = new p90(resource, z, true, n90Var, engine);
                        this.f22410s = true;
                        i12 i12Var = this.f22392a;
                        i12Var.getClass();
                        ArrayList arrayList = new ArrayList((ArrayList) i12Var.f18255b);
                        m5901c(arrayList.size() + 1);
                        this.f22397f.onEngineJobComplete(this, this.f22403l, this.f22413v);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            k90 k90Var = (k90) it.next();
                            k90Var.f20793b.execute(new j90(this, k90Var.f20792a, 1));
                        }
                        m5900b();
                        return;
                    }
                    throw new IllegalStateException("Already have resource");
                }
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: g */
    public final synchronized void m5905g() {
        if (this.f22403l != null) {
            ((ArrayList) this.f22392a.f18255b).clear();
            this.f22403l = null;
            this.f22413v = null;
            this.f22408q = null;
            this.f22412u = false;
            this.f22415x = false;
            this.f22410s = false;
            this.f22416y = false;
            this.f22414w.m4883i();
            this.f22414w = null;
            this.f22411t = null;
            this.f22409r = null;
            this.f22395d.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier getVerifier() {
        return this.f22393b;
    }

    /* renamed from: h */
    public final synchronized void m5906h(ResourceCallback resourceCallback) {
        try {
            this.f22393b.throwIfRecycled();
            i12 i12Var = this.f22392a;
            i12Var.getClass();
            ((ArrayList) i12Var.f18255b).remove(new k90(resourceCallback, Executors.directExecutor()));
            if (((ArrayList) this.f22392a.f18255b).isEmpty()) {
                if (!m5902d()) {
                    this.f22415x = true;
                    RunnableC1213fz runnableC1213fz = this.f22414w;
                    runnableC1213fz.f17451C = true;
                    InterfaceC1667oy interfaceC1667oy = runnableC1213fz.f17449A;
                    if (interfaceC1667oy != null) {
                        interfaceC1667oy.cancel();
                    }
                    this.f22397f.onEngineJobCancelled(this, this.f22403l);
                }
                if (!this.f22410s) {
                    if (this.f22412u) {
                    }
                }
                if (this.f22402k.get() == 0) {
                    m5905g();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: i */
    public final synchronized void m5907i(RunnableC1213fz runnableC1213fz) {
        GlideExecutor glideExecutor;
        this.f22414w = runnableC1213fz;
        int m4878d = runnableC1213fz.m4878d(1);
        if (m4878d != 2 && m4878d != 3) {
            if (this.f22405n) {
                glideExecutor = this.f22400i;
            } else if (this.f22406o) {
                glideExecutor = this.f22401j;
            } else {
                glideExecutor = this.f22399h;
            }
            glideExecutor.execute(runnableC1213fz);
        }
        glideExecutor = this.f22398g;
        glideExecutor.execute(runnableC1213fz);
    }
}
