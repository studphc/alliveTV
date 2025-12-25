package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzgx {
    protected static final AtomicReference zza = new AtomicReference();
    protected static final AtomicReference zzb = new AtomicReference();
    protected static final AtomicReference zzc = new AtomicReference();

    /* renamed from: a */
    public final zzgw f14178a;

    public zzgx(zzgw zzgwVar) {
        this.f14178a = zzgwVar;
    }

    /* renamed from: a */
    public static final String m3531a(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        boolean z;
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        if (strArr.length == strArr2.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        for (int i = 0; i < strArr.length; i++) {
            if (Objects.equals(str, strArr[i])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i];
                        if (str2 == null) {
                            str2 = strArr2[i] + "(" + strArr[i] + ")";
                            strArr3[i] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String zza(Object[] objArr) {
        String valueOf;
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder m7064t = AbstractC1726qj.m7064t("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                valueOf = zzb((Bundle) obj);
            } else {
                valueOf = String.valueOf(obj);
            }
            if (valueOf != null) {
                if (m7064t.length() != 1) {
                    m7064t.append(", ");
                }
                m7064t.append(valueOf);
            }
        }
        m7064t.append("]");
        return m7064t.toString();
    }

    public final String zzb(Bundle bundle) {
        String valueOf;
        if (bundle == null) {
            return null;
        }
        if (!this.f14178a.zza()) {
            return bundle.toString();
        }
        StringBuilder m7064t = AbstractC1726qj.m7064t("Bundle[{");
        for (String str : bundle.keySet()) {
            if (m7064t.length() != 8) {
                m7064t.append(", ");
            }
            m7064t.append(zze(str));
            m7064t.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                valueOf = zza(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                valueOf = zza((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                valueOf = zza(((ArrayList) obj).toArray());
            } else {
                valueOf = String.valueOf(obj);
            }
            m7064t.append(valueOf);
        }
        m7064t.append("}]");
        return m7064t.toString();
    }

    public final String zzc(zzbh zzbhVar) {
        String zzb2;
        zzgw zzgwVar = this.f14178a;
        if (!zzgwVar.zza()) {
            return zzbhVar.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(zzbhVar.zzc);
        sb.append(",name=");
        sb.append(zzd(zzbhVar.zza));
        sb.append(",params=");
        zzbf zzbfVar = zzbhVar.zzb;
        if (zzbfVar == null) {
            zzb2 = null;
        } else if (!zzgwVar.zza()) {
            zzb2 = zzbfVar.toString();
        } else {
            zzb2 = zzb(zzbfVar.zzc());
        }
        sb.append(zzb2);
        return sb.toString();
    }

    public final String zzd(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f14178a.zza()) {
            return str;
        }
        return m3531a(str, zzjy.zzc, zzjy.zza, zza);
    }

    public final String zze(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f14178a.zza()) {
            return str;
        }
        return m3531a(str, zzjz.zzb, zzjz.zza, zzb);
    }

    public final String zzf(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f14178a.zza()) {
            return str;
        }
        if (str.startsWith("_exp_")) {
            return ye0.m8296p("experiment_id(", str, ")");
        }
        return m3531a(str, zzka.zzb, zzka.zza, zzc);
    }
}
