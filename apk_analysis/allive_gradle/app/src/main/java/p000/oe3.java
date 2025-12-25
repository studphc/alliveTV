package p000;

import com.google.android.gms.internal.measurement.zzah;
import com.google.android.gms.internal.measurement.zzai;
import com.google.android.gms.internal.measurement.zzap;
import com.google.android.gms.internal.measurement.zzg;
import java.util.List;

/* loaded from: classes.dex */
public final class oe3 extends zzai {

    /* renamed from: a */
    public final /* synthetic */ int f23792a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ oe3(String str, int i) {
        super(str);
        this.f23792a = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        switch (this.f23792a) {
            case 0:
            case 1:
                return this;
            default:
                return new zzah(Double.valueOf(0.0d));
        }
    }
}
