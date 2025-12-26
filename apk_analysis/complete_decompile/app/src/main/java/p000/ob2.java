package p000;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.RequestTracker;

/* loaded from: classes.dex */
public final class ob2 implements ConnectivityMonitor.ConnectivityListener {

    /* renamed from: a */
    public final RequestTracker f23711a;

    /* renamed from: b */
    public final /* synthetic */ RequestManager f23712b;

    public ob2(RequestManager requestManager, RequestTracker requestTracker) {
        this.f23712b = requestManager;
        this.f23711a = requestTracker;
    }

    @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
    public final void onConnectivityChanged(boolean z) {
        if (z) {
            synchronized (this.f23712b) {
                this.f23711a.restartRequests();
            }
        }
    }
}
