package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class ra3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ int f25916e;

    /* renamed from: f */
    public final /* synthetic */ String f25917f;

    /* renamed from: g */
    public final /* synthetic */ zzff f25918g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ra3(zzff zzffVar, String str, int i) {
        super(zzffVar, true);
        this.f25916e = i;
        this.f25917f = str;
        this.f25918g = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        switch (this.f25916e) {
            case 0:
                ((zzcv) Preconditions.checkNotNull(this.f25918g.f13820g)).setUserId(this.f25917f, this.f13747a);
                return;
            case 1:
                ((zzcv) Preconditions.checkNotNull(this.f25918g.f13820g)).beginAdUnitExposure(this.f25917f, this.f13748b);
                return;
            default:
                ((zzcv) Preconditions.checkNotNull(this.f25918g.f13820g)).endAdUnitExposure(this.f25917f, this.f13748b);
                return;
        }
    }
}
