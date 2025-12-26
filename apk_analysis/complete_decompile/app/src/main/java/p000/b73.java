package p000;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class b73 implements BaseGmsClient.ConnectionProgressReportCallbacks {

    /* renamed from: a */
    public final WeakReference f7913a;

    /* renamed from: b */
    public final Api f7914b;

    /* renamed from: c */
    public final boolean f7915c;

    public b73(zaaw zaawVar, Api api, boolean z) {
        this.f7913a = new WeakReference(zaawVar);
        this.f7914b = api;
        this.f7915c = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        boolean z;
        zaaw zaawVar = (zaaw) this.f7913a.get();
        if (zaawVar == null) {
            return;
        }
        if (Looper.myLooper() == zaawVar.f13195a.f13255n.getLooper()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        Lock lock = zaawVar.f13196b;
        lock.lock();
        try {
            if (zaawVar.m3104g(0)) {
                if (!connectionResult.isSuccess()) {
                    zaawVar.m3102e(connectionResult, this.f7914b, this.f7915c);
                }
                if (zaawVar.m3105h()) {
                    zaawVar.m3103f();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
