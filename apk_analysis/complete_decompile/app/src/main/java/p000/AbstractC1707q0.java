package p000;

import com.google.common.util.concurrent.AbstractFuture;
import sun.misc.Unsafe;

/* renamed from: q0 */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1707q0 {
    /* renamed from: a */
    public static /* synthetic */ boolean m6940a(Unsafe unsafe, AbstractFuture abstractFuture, long j, C1892v0 c1892v0, C1892v0 c1892v02) {
        while (!unsafe.compareAndSwapObject(abstractFuture, j, c1892v0, c1892v02)) {
            if (unsafe.getObject(abstractFuture, j) != c1892v0) {
                return false;
            }
        }
        return true;
    }
}
