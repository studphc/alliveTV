package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class cb3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ int f8320e;

    /* renamed from: f */
    public final /* synthetic */ fb3 f8321f;

    /* renamed from: g */
    public final /* synthetic */ zzff f8322g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cb3(zzff zzffVar, fb3 fb3Var, int i) {
        super(zzffVar, true);
        this.f8320e = i;
        this.f8321f = fb3Var;
        this.f8322g = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        switch (this.f8320e) {
            case 0:
                ((zzcv) Preconditions.checkNotNull(this.f8322g.f13820g)).registerOnMeasurementEventListener(this.f8321f);
                return;
            default:
                ((zzcv) Preconditions.checkNotNull(this.f8322g.f13820g)).unregisterOnMeasurementEventListener(this.f8321f);
                return;
        }
    }
}
