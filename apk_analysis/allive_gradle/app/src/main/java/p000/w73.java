package p000;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* loaded from: classes.dex */
public final class w73 implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {

    /* renamed from: a */
    public final Api.Client f28090a;

    /* renamed from: b */
    public final ApiKey f28091b;

    /* renamed from: c */
    public IAccountAccessor f28092c = null;

    /* renamed from: d */
    public Set f28093d = null;

    /* renamed from: e */
    public boolean f28094e = false;

    /* renamed from: f */
    public final /* synthetic */ GoogleApiManager f28095f;

    public w73(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.f28095f = googleApiManager;
        this.f28090a = client;
        this.f28091b = apiKey;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.f28095f.f13119n.post(new v73(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zae(ConnectionResult connectionResult) {
        zabq zabqVar = (zabq) this.f28095f.f13115j.get(this.f28091b);
        if (zabqVar != null) {
            zabqVar.zas(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zaf(IAccountAccessor iAccountAccessor, Set set) {
        if (iAccountAccessor != null && set != null) {
            this.f28092c = iAccountAccessor;
            this.f28093d = set;
            if (this.f28094e) {
                this.f28090a.getRemoteService(iAccountAccessor, set);
                return;
            }
            return;
        }
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        zae(new ConnectionResult(4));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zag(int i) {
        zabq zabqVar = (zabq) this.f28095f.f13115j.get(this.f28091b);
        if (zabqVar != null) {
            if (zabqVar.f13266i) {
                zabqVar.zas(new ConnectionResult(17));
            } else {
                zabqVar.onConnectionSuspended(i);
            }
        }
    }
}
