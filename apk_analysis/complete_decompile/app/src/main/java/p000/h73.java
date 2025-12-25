package p000;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class h73 implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    public final /* synthetic */ zaaw f17968a;

    public /* synthetic */ h73(zaaw zaawVar) {
        this.f17968a = zaawVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zaaw zaawVar = this.f17968a;
        ((zae) Preconditions.checkNotNull(zaawVar.f13205k)).zad(new g73(zaawVar));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        boolean z;
        zaaw zaawVar = this.f17968a;
        Lock lock = zaawVar.f13196b;
        Lock lock2 = zaawVar.f13196b;
        lock.lock();
        try {
            if (zaawVar.f13206l && !connectionResult.hasResolution()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                zaawVar.m3098a();
                zaawVar.m3103f();
            } else {
                zaawVar.m3101d(connectionResult);
            }
            lock2.unlock();
        } catch (Throwable th) {
            lock2.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
