package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class va3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ long f27722e;

    /* renamed from: f */
    public final /* synthetic */ zzff f27723f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public va3(zzff zzffVar, long j) {
        super(zzffVar, true);
        this.f27722e = j;
        this.f27723f = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        ((zzcv) Preconditions.checkNotNull(this.f27723f.f13820g)).setSessionTimeoutDuration(this.f27722e);
    }
}
