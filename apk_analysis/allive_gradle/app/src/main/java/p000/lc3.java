package p000;

import android.util.Log;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzkf;
import com.google.android.gms.internal.measurement.zzki;

/* loaded from: classes.dex */
public final class lc3 extends zzki {

    /* renamed from: i */
    public final /* synthetic */ int f22466i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lc3(zzkf zzkfVar, String str, Object obj, int i) {
        super(zzkfVar, str, obj);
        this.f22466i = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzki
    /* renamed from: a */
    public final /* synthetic */ Object mo3457a(Object obj) {
        switch (this.f22466i) {
            case 0:
                if (obj instanceof Long) {
                    return (Long) obj;
                }
                if (obj instanceof String) {
                    try {
                        return Long.valueOf(Long.parseLong((String) obj));
                    } catch (NumberFormatException unused) {
                    }
                }
                Log.e("PhenotypeFlag", "Invalid long value for " + this.f13861b + ": " + obj.toString());
                return null;
            case 1:
                if (obj instanceof Boolean) {
                    return (Boolean) obj;
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (zzjc.zzc.matcher(str).matches()) {
                        return Boolean.TRUE;
                    }
                    if (zzjc.zzd.matcher(str).matches()) {
                        return Boolean.FALSE;
                    }
                }
                Log.e("PhenotypeFlag", "Invalid boolean value for " + this.f13861b + ": " + obj.toString());
                return null;
            case 2:
                if (obj instanceof Double) {
                    return (Double) obj;
                }
                if (obj instanceof Float) {
                    return Double.valueOf(((Float) obj).doubleValue());
                }
                if (obj instanceof String) {
                    try {
                        return Double.valueOf(Double.parseDouble((String) obj));
                    } catch (NumberFormatException unused2) {
                    }
                }
                Log.e("PhenotypeFlag", "Invalid double value for " + this.f13861b + ": " + obj.toString());
                return null;
            default:
                if (obj instanceof String) {
                    return (String) obj;
                }
                return null;
        }
    }
}
