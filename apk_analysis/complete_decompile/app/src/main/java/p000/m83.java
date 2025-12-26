package p000;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* loaded from: classes.dex */
public final class m83 extends BasePendingResult {

    /* renamed from: o */
    public final /* synthetic */ int f22849o = 0;

    /* renamed from: p */
    public final Result f22850p;

    public m83(Result result) {
        super(Looper.getMainLooper());
        this.f22850p = result;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        switch (this.f22849o) {
            case 0:
                int statusCode = status.getStatusCode();
                Result result = this.f22850p;
                if (statusCode == result.getStatus().getStatusCode()) {
                    return result;
                }
                throw new UnsupportedOperationException("Creating failed results is not supported");
            default:
                return this.f22850p;
        }
    }

    public m83(Result result, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f22850p = result;
    }
}
