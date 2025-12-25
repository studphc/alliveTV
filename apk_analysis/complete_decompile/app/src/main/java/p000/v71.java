package p000;

import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class v71 implements Provider {

    /* renamed from: a */
    public volatile Set f27663a;

    /* renamed from: b */
    public volatile Set f27664b;

    /* renamed from: a */
    public final synchronized void m7811a() {
        try {
            Iterator it = this.f27663a.iterator();
            while (it.hasNext()) {
                this.f27664b.add(((Provider) it.next()).get());
            }
            this.f27663a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        if (this.f27664b == null) {
            synchronized (this) {
                try {
                    if (this.f27664b == null) {
                        this.f27664b = Collections.newSetFromMap(new ConcurrentHashMap());
                        m7811a();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f27664b);
    }
}
