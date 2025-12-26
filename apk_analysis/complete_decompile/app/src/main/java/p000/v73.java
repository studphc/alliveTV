package p000;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.IAccountAccessor;

/* loaded from: classes.dex */
public final class v73 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ConnectionResult f27665a;

    /* renamed from: b */
    public final /* synthetic */ w73 f27666b;

    public v73(w73 w73Var, ConnectionResult connectionResult) {
        this.f27666b = w73Var;
        this.f27665a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccountAccessor iAccountAccessor;
        w73 w73Var = this.f27666b;
        zabq zabqVar = (zabq) w73Var.f28095f.f13115j.get(w73Var.f28091b);
        if (zabqVar == null) {
            return;
        }
        ConnectionResult connectionResult = this.f27665a;
        if (connectionResult.isSuccess()) {
            w73Var.f28094e = true;
            Api.Client client = w73Var.f28090a;
            if (client.requiresSignIn()) {
                if (w73Var.f28094e && (iAccountAccessor = w73Var.f28092c) != null) {
                    client.getRemoteService(iAccountAccessor, w73Var.f28093d);
                    return;
                }
                return;
            }
            try {
                client.getRemoteService(null, client.getScopesForConnectionlessNonSignIn());
                return;
            } catch (SecurityException e) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                client.disconnect("Failed to get service from broker.");
                zabqVar.zar(new ConnectionResult(10), null);
                return;
            }
        }
        zabqVar.zar(connectionResult, null);
    }
}
