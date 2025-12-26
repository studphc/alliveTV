package p000;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zziy;
import com.google.android.gms.internal.measurement.zzmg;

/* loaded from: classes.dex */
public final class lb3 implements zzmg {

    /* renamed from: b */
    public static final lb3 f22437b = new lb3(0);

    /* renamed from: c */
    public static final lb3 f22438c = new lb3(1);

    /* renamed from: d */
    public static final lb3 f22439d = new lb3(2);

    /* renamed from: e */
    public static final lb3 f22440e = new lb3(3);

    /* renamed from: f */
    public static final lb3 f22441f = new lb3(4);

    /* renamed from: g */
    public static final lb3 f22442g = new lb3(5);

    /* renamed from: h */
    public static final lb3 f22443h = new lb3(6);

    /* renamed from: i */
    public static final lb3 f22444i = new lb3(7);

    /* renamed from: j */
    public static final lb3 f22445j = new lb3(8);

    /* renamed from: k */
    public static final lb3 f22446k = new lb3(9);

    /* renamed from: l */
    public static final lb3 f22447l = new lb3(10);

    /* renamed from: a */
    public final /* synthetic */ int f22448a;

    public /* synthetic */ lb3(int i) {
        this.f22448a = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean zza(int i) {
        switch (this.f22448a) {
            case 0:
                if (zzfo.zza(i) != 0) {
                    return true;
                }
                return false;
            case 1:
                if (zzfu.zza(i) != 0) {
                    return true;
                }
                return false;
            case 2:
                if (zzgd.zza(i) != 0) {
                    return true;
                }
                return false;
            case 3:
                if (zzgf.zza(i) != 0) {
                    return true;
                }
                return false;
            case 4:
                if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                    return true;
                }
                return false;
            case 5:
                if (i == 0 || i == 1) {
                    return true;
                }
                return false;
            case 6:
                if (i == 1 || i == 2) {
                    return true;
                }
                return false;
            case 7:
                if (zzih.zzb(i) != null) {
                    return true;
                }
                return false;
            case 8:
                if (zzij.zza(i) != 0) {
                    return true;
                }
                return false;
            case 9:
                if (zzil.zza(i) != 0) {
                    return true;
                }
                return false;
            default:
                if (zziy.zza(i) != 0) {
                    return true;
                }
                return false;
        }
    }
}
