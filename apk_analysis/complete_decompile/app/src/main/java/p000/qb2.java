package p000;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

/* loaded from: classes.dex */
public final class qb2 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a */
    public boolean f25507a;

    /* renamed from: b */
    public boolean f25508b;

    /* renamed from: c */
    public final /* synthetic */ RequirementsWatcher f25509c;

    public qb2(RequirementsWatcher requirementsWatcher) {
        this.f25509c = requirementsWatcher;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.f25509c.f10895d.post(new pb2(this, 0));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onBlockedStatusChanged(Network network, boolean z) {
        if (!z) {
            this.f25509c.f10895d.post(new pb2(this, 1));
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        boolean hasCapability = networkCapabilities.hasCapability(16);
        boolean z = this.f25507a;
        RequirementsWatcher requirementsWatcher = this.f25509c;
        if (z && this.f25508b == hasCapability) {
            if (hasCapability) {
                requirementsWatcher.f10895d.post(new pb2(this, 1));
            }
        } else {
            this.f25507a = true;
            this.f25508b = hasCapability;
            requirementsWatcher.f10895d.post(new pb2(this, 0));
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.f25509c.f10895d.post(new pb2(this, 0));
    }
}
