package p000;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzdj;

/* loaded from: classes.dex */
public final class gb3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ int f17633e;

    /* renamed from: f */
    public final /* synthetic */ Activity f17634f;

    /* renamed from: g */
    public final /* synthetic */ kb3 f17635g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb3(kb3 kb3Var, Activity activity, int i) {
        super(kb3Var.f20816a, true);
        this.f17633e = i;
        switch (i) {
            case 1:
                this.f17634f = activity;
                this.f17635g = kb3Var;
                super(kb3Var.f20816a, true);
                return;
            case 2:
                this.f17634f = activity;
                this.f17635g = kb3Var;
                super(kb3Var.f20816a, true);
                return;
            case 3:
                this.f17634f = activity;
                this.f17635g = kb3Var;
                super(kb3Var.f20816a, true);
                return;
            case 4:
                this.f17634f = activity;
                this.f17635g = kb3Var;
                super(kb3Var.f20816a, true);
                return;
            default:
                this.f17634f = activity;
                this.f17635g = kb3Var;
                return;
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        switch (this.f17633e) {
            case 0:
                ((zzcv) Preconditions.checkNotNull(this.f17635g.f20816a.f13820g)).onActivityStartedByScionActivityInfo(zzdj.zza(this.f17634f), this.f13748b);
                return;
            case 1:
                ((zzcv) Preconditions.checkNotNull(this.f17635g.f20816a.f13820g)).onActivityResumedByScionActivityInfo(zzdj.zza(this.f17634f), this.f13748b);
                return;
            case 2:
                ((zzcv) Preconditions.checkNotNull(this.f17635g.f20816a.f13820g)).onActivityPausedByScionActivityInfo(zzdj.zza(this.f17634f), this.f13748b);
                return;
            case 3:
                ((zzcv) Preconditions.checkNotNull(this.f17635g.f20816a.f13820g)).onActivityStoppedByScionActivityInfo(zzdj.zza(this.f17634f), this.f13748b);
                return;
            default:
                ((zzcv) Preconditions.checkNotNull(this.f17635g.f20816a.f13820g)).onActivityDestroyedByScionActivityInfo(zzdj.zza(this.f17634f), this.f13748b);
                return;
        }
    }
}
