package p000;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;

/* loaded from: classes.dex */
public final class n73 implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    public final /* synthetic */ StatusPendingResult f23271a;

    public n73(StatusPendingResult statusPendingResult) {
        this.f23271a = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f23271a.setResult(new Status(8));
    }
}
