package p000;

import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RoutePlanner;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class vc2 {
    /* renamed from: a */
    public static /* synthetic */ boolean m7907a(RoutePlanner routePlanner, RealConnection realConnection, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                realConnection = null;
            }
            return routePlanner.hasNext(realConnection);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasNext");
    }
}
