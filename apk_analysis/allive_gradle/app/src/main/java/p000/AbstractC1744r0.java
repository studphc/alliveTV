package p000;

import com.google.common.util.concurrent.AbstractFuture;
import sun.misc.Unsafe;

/* renamed from: r0 */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1744r0 {
    /* renamed from: a */
    public static /* synthetic */ boolean m7156a(Unsafe unsafe, AbstractFuture abstractFuture, long j, C1374k0 c1374k0, C1374k0 c1374k02) {
        while (!unsafe.compareAndSwapObject(abstractFuture, j, c1374k0, c1374k02)) {
            if (unsafe.getObject(abstractFuture, j) != c1374k0) {
                return false;
            }
        }
        return true;
    }
}
