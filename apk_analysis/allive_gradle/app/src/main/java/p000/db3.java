package p000;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class db3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ Long f16331e;

    /* renamed from: f */
    public final /* synthetic */ String f16332f;

    /* renamed from: g */
    public final /* synthetic */ String f16333g;

    /* renamed from: h */
    public final /* synthetic */ Bundle f16334h;

    /* renamed from: i */
    public final /* synthetic */ boolean f16335i;

    /* renamed from: j */
    public final /* synthetic */ boolean f16336j;

    /* renamed from: k */
    public final /* synthetic */ zzff f16337k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db3(zzff zzffVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzffVar, true);
        this.f16331e = l;
        this.f16332f = str;
        this.f16333g = str2;
        this.f16334h = bundle;
        this.f16335i = z;
        this.f16336j = z2;
        this.f16337k = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        long longValue;
        Long l = this.f16331e;
        if (l == null) {
            longValue = this.f13747a;
        } else {
            longValue = l.longValue();
        }
        ((zzcv) Preconditions.checkNotNull(this.f16337k.f13820g)).logEvent(this.f16332f, this.f16333g, this.f16334h, this.f16335i, this.f16336j, longValue);
    }
}
