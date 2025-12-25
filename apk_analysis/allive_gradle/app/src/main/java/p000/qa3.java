package p000;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class qa3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ int f25496e;

    /* renamed from: f */
    public final /* synthetic */ String f25497f;

    /* renamed from: g */
    public final /* synthetic */ String f25498g;

    /* renamed from: h */
    public final /* synthetic */ zzff f25499h;

    /* renamed from: i */
    public final /* synthetic */ Object f25500i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qa3(zzff zzffVar, String str, String str2, Object obj, int i) {
        super(zzffVar, true);
        this.f25496e = i;
        this.f25497f = str;
        this.f25498g = str2;
        this.f25500i = obj;
        this.f25499h = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        switch (this.f25496e) {
            case 0:
                ((zzcv) Preconditions.checkNotNull(this.f25499h.f13820g)).clearConditionalUserProperty(this.f25497f, this.f25498g, (Bundle) this.f25500i);
                return;
            case 1:
                ((zzcv) Preconditions.checkNotNull(this.f25499h.f13820g)).getConditionalUserProperties(this.f25497f, this.f25498g, (zzcs) this.f25500i);
                return;
            default:
                ((zzcv) Preconditions.checkNotNull(this.f25499h.f13820g)).setCurrentScreenByScionActivityInfo((zzdj) this.f25500i, this.f25497f, this.f25498g, this.f13747a);
                return;
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: b */
    public void mo47b() {
        switch (this.f25496e) {
            case 1:
                ((zzcs) this.f25500i).zze(null);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qa3(zzff zzffVar, zzdj zzdjVar, String str, String str2) {
        super(zzffVar, true);
        this.f25496e = 2;
        this.f25500i = zzdjVar;
        this.f25497f = str;
        this.f25498g = str2;
        this.f25499h = zzffVar;
    }
}
