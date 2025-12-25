package p000;

import androidx.emoji2.text.flatbuffer.Table;
import com.google.android.gms.internal.measurement.zzai;
import com.google.android.gms.internal.measurement.zzap;
import com.google.android.gms.internal.measurement.zzau;
import com.google.android.gms.internal.measurement.zzg;
import com.google.android.gms.internal.measurement.zzh;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class cs2 implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ int f16097a = 0;

    /* renamed from: b */
    public final /* synthetic */ Object f16098b;

    /* renamed from: c */
    public final /* synthetic */ Object f16099c;

    public cs2(zzai zzaiVar, zzg zzgVar) {
        this.f16098b = zzaiVar;
        this.f16099c = zzgVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int zza;
        Object obj3 = this.f16099c;
        Object obj4 = this.f16098b;
        switch (this.f16097a) {
            case 0:
                return ((Table) obj3).keysCompare((Integer) obj, (Integer) obj2, (ByteBuffer) obj4);
            default:
                zzap zzapVar = (zzap) obj;
                zzap zzapVar2 = (zzap) obj2;
                if (zzapVar instanceof zzau) {
                    if (zzapVar2 instanceof zzau) {
                        return 0;
                    }
                    return 1;
                }
                if (zzapVar2 instanceof zzau) {
                    zza = -1;
                } else {
                    zzai zzaiVar = (zzai) obj4;
                    if (zzaiVar == null) {
                        zza = zzapVar.zzi().compareTo(zzapVar2.zzi());
                    } else {
                        zza = (int) zzh.zza(zzaiVar.zza((zzg) obj3, Arrays.asList(zzapVar, zzapVar2)).zzh().doubleValue());
                    }
                }
                return zza;
        }
    }

    public cs2(Table table, ByteBuffer byteBuffer) {
        this.f16099c = table;
        this.f16098b = byteBuffer;
    }
}
