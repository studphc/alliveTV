package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class ta3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ zzff f26756e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ta3(zzff zzffVar) {
        super(zzffVar, true);
        this.f26756e = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        ((zzcv) Preconditions.checkNotNull(this.f26756e.f13820g)).resetAnalyticsData(this.f13747a);
    }
}
