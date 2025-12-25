package p000;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zabe;

/* loaded from: classes.dex */
public final class o73 implements ResultCallback {

    /* renamed from: a */
    public final /* synthetic */ StatusPendingResult f23654a;

    /* renamed from: b */
    public final /* synthetic */ boolean f23655b;

    /* renamed from: c */
    public final /* synthetic */ GoogleApiClient f23656c;

    /* renamed from: d */
    public final /* synthetic */ zabe f23657d;

    public o73(zabe zabeVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.f23657d = zabeVar;
        this.f23654a = statusPendingResult;
        this.f23655b = z;
        this.f23656c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        zabe zabeVar = this.f23657d;
        Storage.getInstance(zabeVar.f13223f).zac();
        if (status.isSuccess() && zabeVar.isConnected()) {
            zabeVar.disconnect();
            zabeVar.connect();
        }
        this.f23654a.setResult(status);
        if (this.f23655b) {
            this.f23656c.disconnect();
        }
    }
}
