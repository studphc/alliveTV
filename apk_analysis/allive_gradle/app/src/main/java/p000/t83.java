package p000;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zak;

/* loaded from: classes.dex */
public final class t83 implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    public final int f26721a;

    /* renamed from: b */
    public final GoogleApiClient f26722b;

    /* renamed from: c */
    public final GoogleApiClient.OnConnectionFailedListener f26723c;

    /* renamed from: d */
    public final /* synthetic */ zak f26724d;

    public t83(zak zakVar, int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f26724d = zakVar;
        this.f26721a = i;
        this.f26722b = googleApiClient;
        this.f26723c = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d("AutoManageHelper", "beginFailureResolution for ".concat(String.valueOf(connectionResult)));
        this.f26724d.zah(connectionResult, this.f26721a);
    }
}
