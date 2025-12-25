package p000;

import com.google.android.gms.internal.measurement.zzai;
import com.google.android.gms.internal.measurement.zzap;
import com.google.android.gms.internal.measurement.zzg;
import com.google.android.gms.internal.measurement.zzh;
import com.google.android.gms.internal.measurement.zzt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ze3 extends zzai {

    /* renamed from: a */
    public final boolean f29341a;

    /* renamed from: b */
    public final boolean f29342b;

    /* renamed from: c */
    public final /* synthetic */ zzt f29343c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ze3(zzt zztVar, boolean z, boolean z2) {
        super("log");
        this.f29343c = zztVar;
        this.f29341a = z;
        this.f29342b = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    @Override // com.google.android.gms.internal.measurement.zzai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzap zza(zzg zzgVar, List list) {
        int i;
        int i2;
        zzh.zzi("log", 1, list);
        int size = list.size();
        zzt zztVar = this.f29343c;
        if (size == 1) {
            zztVar.f13956a.zza(3, zzgVar.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.f29341a, this.f29342b);
            return zzap.zzf;
        }
        int zzb = zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
        if (zzb != 2) {
            i = 3;
            if (zzb != 3) {
                if (zzb != 5) {
                    if (zzb == 6) {
                        i2 = 2;
                    }
                } else {
                    i2 = 5;
                }
            } else {
                i2 = 1;
            }
            String zzi = zzgVar.zzb((zzap) list.get(1)).zzi();
            if (list.size() != 2) {
                zztVar.f13956a.zza(i2, zzi, Collections.emptyList(), this.f29341a, this.f29342b);
                return zzap.zzf;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 2; i3 < Math.min(list.size(), 5); i3++) {
                arrayList.add(zzgVar.zzb((zzap) list.get(i3)).zzi());
            }
            zztVar.f13956a.zza(i2, zzi, arrayList, this.f29341a, this.f29342b);
            return zzap.zzf;
        }
        i = 4;
        i2 = i;
        String zzi2 = zzgVar.zzb((zzap) list.get(1)).zzi();
        if (list.size() != 2) {
        }
    }
}
