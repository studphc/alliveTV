package p000;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class pa3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ int f25095e;

    /* renamed from: f */
    public final /* synthetic */ Bundle f25096f;

    /* renamed from: g */
    public final /* synthetic */ zzff f25097g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ pa3(zzff zzffVar, Bundle bundle, int i) {
        super(zzffVar, true);
        this.f25095e = i;
        this.f25096f = bundle;
        this.f25097g = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        switch (this.f25095e) {
            case 0:
                ((zzcv) Preconditions.checkNotNull(this.f25097g.f13820g)).setConditionalUserProperty(this.f25096f, this.f13747a);
                return;
            case 1:
                ((zzcv) Preconditions.checkNotNull(this.f25097g.f13820g)).setConsentThirdParty(this.f25096f, this.f13747a);
                return;
            default:
                ((zzcv) Preconditions.checkNotNull(this.f25097g.f13820g)).setDefaultEventParameters(this.f25096f);
                return;
        }
    }
}
