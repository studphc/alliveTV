package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class bb3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ boolean f7957e;

    /* renamed from: f */
    public final /* synthetic */ zzff f7958f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb3(zzff zzffVar, boolean z) {
        super(zzffVar, true);
        this.f7957e = z;
        this.f7958f = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        ((zzcv) Preconditions.checkNotNull(this.f7958f.f13820g)).setDataCollectionEnabled(this.f7957e);
    }
}
