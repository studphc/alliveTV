package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class oa3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ int f23685e = 0;

    /* renamed from: f */
    public final /* synthetic */ String f23686f;

    /* renamed from: g */
    public final /* synthetic */ String f23687g;

    /* renamed from: h */
    public final /* synthetic */ boolean f23688h;

    /* renamed from: i */
    public final /* synthetic */ zzff f23689i;

    /* renamed from: j */
    public final /* synthetic */ Object f23690j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oa3(zzff zzffVar, String str, String str2, Object obj, boolean z) {
        super(zzffVar, true);
        this.f23686f = str;
        this.f23687g = str2;
        this.f23690j = obj;
        this.f23688h = z;
        this.f23689i = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        switch (this.f23685e) {
            case 0:
                ((zzcv) Preconditions.checkNotNull(this.f23689i.f13820g)).setUserProperty(this.f23686f, this.f23687g, ObjectWrapper.wrap(this.f23690j), this.f23688h, this.f13747a);
                return;
            default:
                ((zzcv) Preconditions.checkNotNull(this.f23689i.f13820g)).getUserProperties(this.f23686f, this.f23687g, this.f23688h, (zzcs) this.f23690j);
                return;
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: b */
    public void mo47b() {
        switch (this.f23685e) {
            case 1:
                ((zzcs) this.f23690j).zze(null);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oa3(zzff zzffVar, String str, String str2, boolean z, zzcs zzcsVar) {
        super(zzffVar, true);
        this.f23686f = str;
        this.f23687g = str2;
        this.f23688h = z;
        this.f23690j = zzcsVar;
        this.f23689i = zzffVar;
    }
}
