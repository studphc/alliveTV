package p000;

import com.bumptech.glide.util.LruCache;
import java.util.Queue;

/* loaded from: classes.dex */
public final class ko1 extends LruCache {
    @Override // com.bumptech.glide.util.LruCache
    public final void onItemEvicted(Object obj, Object obj2) {
        lo1 lo1Var = (lo1) obj;
        lo1Var.getClass();
        Queue queue = lo1.f22596d;
        synchronized (queue) {
            queue.offer(lo1Var);
        }
    }
}
