package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class ab3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ zzcs f114e;

    /* renamed from: f */
    public final /* synthetic */ int f115f;

    /* renamed from: g */
    public final /* synthetic */ zzff f116g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab3(zzff zzffVar, zzcs zzcsVar, int i) {
        super(zzffVar, true);
        this.f114e = zzcsVar;
        this.f115f = i;
        this.f116g = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        ((zzcv) Preconditions.checkNotNull(this.f116g.f13820g)).getTestFlag(this.f114e, this.f115f);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: b */
    public final void mo47b() {
        this.f114e.zze(null);
    }
}
