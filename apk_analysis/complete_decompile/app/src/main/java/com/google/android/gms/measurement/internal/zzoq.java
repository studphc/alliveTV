package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzoq {

    /* renamed from: a */
    public final HashMap f14349a;

    public zzoq(Map map) {
        HashMap hashMap = new HashMap();
        this.f14349a = hashMap;
        hashMap.putAll(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final String m3595a() {
        StringBuilder sb = new StringBuilder();
        ImmutableList immutableList = zzot.f14350a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            HashMap hashMap = this.f14349a;
            if (hashMap.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) hashMap.get(str));
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public final int m3596b() {
        try {
            String str = (String) this.f14349a.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: c */
    public final Bundle m3597c() {
        int m3596b;
        String str;
        String str2;
        HashMap hashMap = this.f14349a;
        if (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(hashMap.get("GoogleConsent")) && (m3596b = m3596b()) >= 0) {
            String str3 = (String) hashMap.get("PurposeConsents");
            if (!TextUtils.isEmpty(str3)) {
                Bundle bundle = new Bundle();
                String str4 = "denied";
                if (str3.length() > 0) {
                    String str5 = zzjw.AD_STORAGE.zze;
                    if (str3.charAt(0) != '1') {
                        str2 = "denied";
                    } else {
                        str2 = "granted";
                    }
                    bundle.putString(str5, str2);
                }
                if (str3.length() > 3) {
                    String str6 = zzjw.AD_PERSONALIZATION.zze;
                    if (str3.charAt(2) != '1' || str3.charAt(3) != '1') {
                        str = "denied";
                    } else {
                        str = "granted";
                    }
                    bundle.putString(str6, str);
                }
                if (str3.length() > 6 && m3596b >= 4) {
                    String str7 = zzjw.AD_USER_DATA.zze;
                    if (str3.charAt(0) == '1' && str3.charAt(6) == '1') {
                        str4 = "granted";
                    }
                    bundle.putString(str7, str4);
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoq)) {
            return false;
        }
        return m3595a().equalsIgnoreCase(((zzoq) obj).m3595a());
    }

    public final int hashCode() {
        return m3595a().hashCode();
    }

    public final String toString() {
        return m3595a();
    }

    public final Bundle zza() {
        String str;
        String str2;
        zzgg zzggVar = zzgi.zzbj;
        boolean booleanValue = ((Boolean) zzggVar.zza(null)).booleanValue();
        HashMap hashMap = this.f14349a;
        if (!booleanValue ? !(!IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(hashMap.get("GoogleConsent")) || !IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(hashMap.get("gdprApplies")) || !IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(hashMap.get("EnableAdvertiserConsentMode"))) : !(!IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(hashMap.get("gdprApplies")) || !IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(hashMap.get("EnableAdvertiserConsentMode")))) {
            if (((Boolean) zzggVar.zza(null)).booleanValue()) {
                if (hashMap.get("Version") == null) {
                    return m3597c();
                }
                if (m3596b() >= 0) {
                    Bundle bundle = new Bundle();
                    String str3 = zzjw.AD_STORAGE.zze;
                    String str4 = "granted";
                    if (true == Objects.equals(hashMap.get("AuthorizePurpose1"), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
                        str = "granted";
                    } else {
                        str = "denied";
                    }
                    bundle.putString(str3, str);
                    String str5 = zzjw.AD_PERSONALIZATION.zze;
                    if (Objects.equals(hashMap.get("AuthorizePurpose3"), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE) && Objects.equals(hashMap.get("AuthorizePurpose4"), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
                        str2 = "granted";
                    } else {
                        str2 = "denied";
                    }
                    bundle.putString(str5, str2);
                    if (m3596b() >= 4) {
                        String str6 = zzjw.AD_USER_DATA.zze;
                        if (!Objects.equals(hashMap.get("AuthorizePurpose1"), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE) || !Objects.equals(hashMap.get("AuthorizePurpose7"), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
                            str4 = "denied";
                        }
                        bundle.putString(str6, str4);
                    }
                    return bundle;
                }
            } else {
                return m3597c();
            }
        }
        return Bundle.EMPTY;
    }

    public final String zzb() {
        String str = (String) this.f14349a.get("PurposeDiagnostics");
        if (TextUtils.isEmpty(str)) {
            return "200000";
        }
        return str;
    }

    public final String zzc(zzoq zzoqVar) {
        String str;
        HashMap hashMap = zzoqVar.f14349a;
        String str2 = "0";
        if (hashMap.isEmpty() || ((String) hashMap.get("Version")) != null) {
            str = "0";
        } else {
            str = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        }
        Bundle zza = zza();
        Bundle zza2 = zzoqVar.zza();
        if (zza.size() != zza2.size() || !Objects.equals(zza.getString("ad_storage"), zza2.getString("ad_storage")) || !Objects.equals(zza.getString("ad_personalization"), zza2.getString("ad_personalization")) || !Objects.equals(zza.getString("ad_user_data"), zza2.getString("ad_user_data"))) {
            str2 = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        }
        return str.concat(str2);
    }

    public final String zzd() {
        int i;
        HashMap hashMap = this.f14349a;
        StringBuilder sb = new StringBuilder(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        int i2 = -1;
        try {
            String str = (String) hashMap.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i2 >= 0 && i2 <= 4095) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i2 >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i2 & 63));
        } else {
            sb.append("00");
        }
        int m3596b = m3596b();
        if (m3596b >= 0 && m3596b <= 63) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(m3596b));
        } else {
            sb.append("0");
        }
        Preconditions.checkArgument(true);
        if (true != IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(hashMap.get("gdprApplies"))) {
            i = 0;
        } else {
            i = 2;
        }
        int i3 = i | 4;
        if (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(hashMap.get("EnableAdvertiserConsentMode"))) {
            i3 = i | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i3));
        return sb.toString();
    }
}
