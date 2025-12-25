package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class ya3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ int f28880e;

    /* renamed from: f */
    public final /* synthetic */ zzcs f28881f;

    /* renamed from: g */
    public final /* synthetic */ zzff f28882g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ya3(zzff zzffVar, zzcs zzcsVar, int i) {
        super(zzffVar, true);
        this.f28880e = i;
        this.f28881f = zzcsVar;
        this.f28882g = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        switch (this.f28880e) {
            case 0:
                ((zzcv) Preconditions.checkNotNull(this.f28882g.f13820g)).getGmpAppId(this.f28881f);
                return;
            case 1:
                ((zzcv) Preconditions.checkNotNull(this.f28882g.f13820g)).getCachedAppInstanceId(this.f28881f);
                return;
            case 2:
                ((zzcv) Preconditions.checkNotNull(this.f28882g.f13820g)).generateEventId(this.f28881f);
                return;
            case 3:
                ((zzcv) Preconditions.checkNotNull(this.f28882g.f13820g)).getCurrentScreenName(this.f28881f);
                return;
            case 4:
                ((zzcv) Preconditions.checkNotNull(this.f28882g.f13820g)).getCurrentScreenClass(this.f28881f);
                return;
            case 5:
                ((zzcv) Preconditions.checkNotNull(this.f28882g.f13820g)).getAppInstanceId(this.f28881f);
                return;
            default:
                ((zzcv) Preconditions.checkNotNull(this.f28882g.f13820g)).getSessionId(this.f28881f);
                return;
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: b */
    public final void mo47b() {
        switch (this.f28880e) {
            case 0:
                this.f28881f.zze(null);
                return;
            case 1:
                this.f28881f.zze(null);
                return;
            case 2:
                this.f28881f.zze(null);
                return;
            case 3:
                this.f28881f.zze(null);
                return;
            case 4:
                this.f28881f.zze(null);
                return;
            case 5:
                this.f28881f.zze(null);
                return;
            default:
                this.f28881f.zze(null);
                return;
        }
    }
}
