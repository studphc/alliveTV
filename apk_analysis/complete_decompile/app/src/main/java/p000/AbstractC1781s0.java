package p000;

import com.google.common.util.concurrent.AbstractFuture;
import sun.misc.Unsafe;

/* renamed from: s0 */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1781s0 {
    /* renamed from: a */
    public static /* synthetic */ boolean m7315a(Unsafe unsafe, AbstractFuture abstractFuture, long j, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(abstractFuture, j, obj, obj2)) {
            if (unsafe.getObject(abstractFuture, j) != obj) {
                return false;
            }
        }
        return true;
    }
}
