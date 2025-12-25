package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import p000.me3;

/* loaded from: classes.dex */
public final class zzot {

    /* renamed from: a */
    public static final ImmutableList f14350a = ImmutableList.m3914of("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");
    public static final /* synthetic */ int zzb = 0;

    /* renamed from: a */
    public static int m3598a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public static String m3599b(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static final boolean m3600c(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        int i6;
        int i7;
        int i8;
        me3 me3Var;
        char c;
        int m3601d = m3601d(zzklVar);
        if (m3601d > 0) {
            i7 = i3;
            if (i7 == 1) {
                i6 = i2;
                if (i6 != 1) {
                    i7 = 1;
                } else {
                    i7 = 1;
                    i6 = 1;
                }
            } else {
                i6 = i2;
            }
            cArr[m3601d] = '2';
        } else {
            i6 = i2;
            i7 = i3;
        }
        com.google.android.gms.internal.measurement.zzkm zzkmVar = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED;
        if (((com.google.android.gms.internal.measurement.zzkm) immutableMap2.getOrDefault(zzklVar, zzkmVar)) == com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c = '3';
        } else {
            if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                i8 = i5;
                if (i8 == 1) {
                    if (immutableSet.contains(str)) {
                        if (m3601d > 0 && cArr[m3601d] != '2') {
                            cArr[m3601d] = '1';
                        }
                        return true;
                    }
                    i8 = 1;
                }
            } else {
                i8 = i5;
            }
            if (immutableMap.containsKey(zzklVar) && (me3Var = (me3) immutableMap.get(zzklVar)) != null) {
                int ordinal = me3Var.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal == 2) {
                            if (((com.google.android.gms.internal.measurement.zzkm) immutableMap2.getOrDefault(zzklVar, zzkmVar)) == com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                return m3604g(zzklVar, cArr, i, i6, i7, i4, i8, str3, z, z2);
                            }
                            return m3603f(zzklVar, cArr, i, i6, i7, i4, i8, str2, z, z2);
                        }
                        if (ordinal == 3) {
                            if (((com.google.android.gms.internal.measurement.zzkm) immutableMap2.getOrDefault(zzklVar, zzkmVar)) == com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                return m3603f(zzklVar, cArr, i, i6, i7, i4, i8, str2, z, z2);
                            }
                            return m3604g(zzklVar, cArr, i, i6, i7, i4, i8, str3, z, z2);
                        }
                    } else if (((com.google.android.gms.internal.measurement.zzkm) immutableMap2.getOrDefault(zzklVar, zzkmVar)) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                        return m3604g(zzklVar, cArr, i, i6, i7, i4, i8, str3, z, z2);
                    }
                } else if (((com.google.android.gms.internal.measurement.zzkm) immutableMap2.getOrDefault(zzklVar, zzkmVar)) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                    return m3603f(zzklVar, cArr, i, i6, i7, i4, i8, str2, z, z2);
                }
                c = '8';
            }
            c = '0';
        }
        if (m3601d <= 0 || cArr[m3601d] == '2') {
            return false;
        }
        cArr[m3601d] = c;
        return false;
    }

    /* renamed from: d */
    public static final int m3601d(com.google.android.gms.internal.measurement.zzkl zzklVar) {
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE) {
            return 4;
        }
        return -1;
    }

    /* renamed from: e */
    public static final String m3602e(com.google.android.gms.internal.measurement.zzkl zzklVar, String str, String str2) {
        String str3;
        String str4 = "0";
        if (TextUtils.isEmpty(str) || str.length() < zzklVar.zza()) {
            str3 = "0";
        } else {
            str3 = String.valueOf(str.charAt(zzklVar.zza() - 1));
        }
        if (!TextUtils.isEmpty(str2) && str2.length() >= zzklVar.zza()) {
            str4 = String.valueOf(str2.charAt(zzklVar.zza() - 1));
        }
        return String.valueOf(str3).concat(String.valueOf(str4));
    }

    /* renamed from: f */
    public static final boolean m3603f(com.google.android.gms.internal.measurement.zzkl zzklVar, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, boolean z, boolean z2) {
        char c;
        int m3601d = m3601d(zzklVar);
        boolean z3 = false;
        if (!z) {
            c = '4';
        } else if (str.length() < zzklVar.zza()) {
            c = '0';
        } else {
            char charAt = str.charAt(zzklVar.zza() - 1);
            char c2 = '1';
            if (charAt == '1') {
                z3 = true;
            }
            if (m3601d > 0 && cArr[m3601d] != '2') {
                if (charAt != '1') {
                    c2 = '6';
                }
                cArr[m3601d] = c2;
            }
            return z3;
        }
        if (m3601d > 0 && cArr[m3601d] != '2') {
            cArr[m3601d] = c;
        }
        return false;
    }

    /* renamed from: g */
    public static final boolean m3604g(com.google.android.gms.internal.measurement.zzkl zzklVar, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, boolean z, boolean z2) {
        char c;
        int m3601d = m3601d(zzklVar);
        boolean z3 = false;
        if (!z2) {
            c = '5';
        } else if (str.length() < zzklVar.zza()) {
            c = '0';
        } else {
            char charAt = str.charAt(zzklVar.zza() - 1);
            char c2 = '1';
            if (charAt == '1') {
                z3 = true;
            }
            if (m3601d > 0 && cArr[m3601d] != '2') {
                if (charAt != '1') {
                    c2 = '7';
                }
                cArr[m3601d] = c2;
            }
            return z3;
        }
        if (m3601d > 0 && cArr[m3601d] != '2') {
            cArr[m3601d] = c;
        }
        return false;
    }

    public static final Map zzc(ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        int zza;
        int zza2;
        int zza3;
        int zza4;
        com.google.android.gms.internal.measurement.zzkl zzklVar = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        com.google.android.gms.internal.measurement.zzkm zzkmVar = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar);
        com.google.android.gms.internal.measurement.zzkl zzklVar2 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        com.google.android.gms.internal.measurement.zzkm zzkmVar2 = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar2);
        com.google.android.gms.internal.measurement.zzkl zzklVar3 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        com.google.android.gms.internal.measurement.zzkm zzkmVar3 = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar3);
        com.google.android.gms.internal.measurement.zzkl zzklVar4 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        com.google.android.gms.internal.measurement.zzkm zzkmVar4 = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar4);
        ImmutableMap.Builder put = ImmutableMap.builder().put("Version", ExifInterface.GPS_MEASUREMENT_2D);
        String str4 = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        ImmutableMap.Builder put2 = put.put("VendorConsent", true != z ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("VendorLegitimateInterest", true != z2 ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("gdprApplies", i3 != 1 ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("EnableAdvertiserConsentMode", i2 != 1 ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("PolicyVersion", String.valueOf(i4)).put("CmpSdkID", String.valueOf(i)).put("PurposeOneTreatment", i5 != 1 ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("PublisherCC", str);
        if (zzkmVar != null) {
            zza = zzkmVar.zza();
        } else {
            zza = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put3 = put2.put("PublisherRestrictions1", String.valueOf(zza));
        if (zzkmVar2 != null) {
            zza2 = zzkmVar2.zza();
        } else {
            zza2 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put4 = put3.put("PublisherRestrictions3", String.valueOf(zza2));
        if (zzkmVar3 != null) {
            zza3 = zzkmVar3.zza();
        } else {
            zza3 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put5 = put4.put("PublisherRestrictions4", String.valueOf(zza3));
        if (zzkmVar4 != null) {
            zza4 = zzkmVar4.zza();
        } else {
            zza4 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder putAll = put5.put("PublisherRestrictions7", String.valueOf(zza4)).putAll(ImmutableMap.m3927of("Purpose1", m3602e(zzklVar, str2, str3), "Purpose3", m3602e(zzklVar2, str2, str3), "Purpose4", m3602e(zzklVar3, str2, str3), "Purpose7", m3602e(zzklVar4, str2, str3)));
        Object obj = true != m3600c(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2) ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        Object obj2 = true != m3600c(zzklVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2) ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        Object obj3 = true != m3600c(zzklVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2) ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        if (true != m3600c(zzklVar4, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2)) {
            str4 = "0";
        }
        return putAll.putAll(ImmutableMap.m3928of("AuthorizePurpose1", (String) obj, "AuthorizePurpose3", (String) obj2, "AuthorizePurpose4", (String) obj3, "AuthorizePurpose7", str4, "PurposeDiagnostics", new String(cArr))).buildOrThrow();
    }
}
