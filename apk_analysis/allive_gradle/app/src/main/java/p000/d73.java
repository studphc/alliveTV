package p000;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.internal.BaseGmsClient;

/* loaded from: classes.dex */
public final class d73 extends r73 {

    /* renamed from: b */
    public final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks f16280b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d73(zabf zabfVar, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabfVar);
        this.f16280b = connectionProgressReportCallbacks;
    }

    @Override // p000.r73
    /* renamed from: a */
    public final void mo33a() {
        this.f16280b.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
