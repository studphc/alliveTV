package p000;

import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class sa3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ int f26344e;

    /* renamed from: f */
    public final /* synthetic */ zzff f26345f;

    /* renamed from: g */
    public final /* synthetic */ Object f26346g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sa3(zzff zzffVar, Object obj, int i) {
        super(zzffVar, true);
        this.f26344e = i;
        this.f26346g = obj;
        this.f26345f = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        switch (this.f26344e) {
            case 0:
                ((zzcv) Preconditions.checkNotNull(this.f26345f.f13820g)).setMeasurementEnabled(((Boolean) this.f26346g).booleanValue(), this.f13747a);
                return;
            case 1:
                ((zzcv) Preconditions.checkNotNull(this.f26345f.f13820g)).retrieveAndUploadBatches(new wa3((Runnable) this.f26346g));
                return;
            case 2:
                ((zzcv) Preconditions.checkNotNull(this.f26345f.f13820g)).setEventInterceptor((eb3) this.f26346g);
                return;
            default:
                ((zzcv) Preconditions.checkNotNull(this.f26345f.f13820g)).setSgtmDebugInfo((Intent) this.f26346g);
                return;
        }
    }
}
