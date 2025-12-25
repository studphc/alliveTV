package p000;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Resource;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: r4 */
/* loaded from: classes.dex */
public final class C1748r4 {

    /* renamed from: a */
    public final boolean f25858a;

    /* renamed from: b */
    public final ExecutorService f25859b;

    /* renamed from: c */
    public final HashMap f25860c;

    /* renamed from: d */
    public final ReferenceQueue f25861d;

    /* renamed from: e */
    public Engine f25862e;

    /* renamed from: f */
    public volatile boolean f25863f;

    public C1748r4(boolean z) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryC1674p4(0));
        this.f25860c = new HashMap();
        this.f25861d = new ReferenceQueue();
        this.f25858a = z;
        this.f25859b = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(new RunnableC1104d(3, this));
    }

    /* renamed from: a */
    public final synchronized void m7215a(Key key, p90 p90Var) {
        C1711q4 c1711q4 = (C1711q4) this.f25860c.put(key, new C1711q4(key, p90Var, this.f25861d, this.f25858a));
        if (c1711q4 != null) {
            c1711q4.f25429c = null;
            c1711q4.clear();
        }
    }

    /* renamed from: b */
    public final void m7216b(C1711q4 c1711q4) {
        Resource resource;
        synchronized (this) {
            this.f25860c.remove(c1711q4.f25427a);
            if (c1711q4.f25428b && (resource = c1711q4.f25429c) != null) {
                this.f25862e.onResourceReleased(c1711q4.f25427a, new p90(resource, true, false, c1711q4.f25427a, this.f25862e));
            }
        }
    }
}
