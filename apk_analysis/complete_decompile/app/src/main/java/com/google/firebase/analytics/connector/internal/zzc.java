package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzka;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes2.dex */
public final class zzc {

    /* renamed from: a */
    public static final ImmutableSet f15497a = ImmutableSet.m3977of("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", FirebaseAnalytics.Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* renamed from: b */
    public static final ImmutableList f15498b = ImmutableList.m3909of("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c */
    public static final ImmutableList f15499c = ImmutableList.m3905of(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "app", "am");

    /* renamed from: d */
    public static final ImmutableList f15500d = ImmutableList.m3904of("_r", "_dbg");

    /* renamed from: e */
    public static final ImmutableList f15501e = new ImmutableList.Builder().add((Object[]) zzka.zza).add((Object[]) zzka.zzb).build();

    /* renamed from: f */
    public static final ImmutableList f15502f = ImmutableList.m3904of("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    public static final /* synthetic */ int zza = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zza(String str, String str2, Bundle bundle) {
        char c;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zzd(str) || bundle == null) {
            return false;
        }
        ImmutableList immutableList = f15500d;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            boolean containsKey = bundle.containsKey((String) immutableList.get(i));
            i++;
            if (containsKey) {
                return false;
            }
        }
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals(AppMeasurement.FIAM_ORIGIN)) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (str.equals("fdl")) {
                    c = 1;
                }
                c = 65535;
            }
        } else {
            if (str.equals(AppMeasurement.FCM_ORIGIN)) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return false;
                }
                bundle.putString("_cis", "fiam_integration");
                return true;
            }
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        bundle.putString("_cis", "fcm_integration");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zzb(String str, Bundle bundle) {
        if (f15498b.contains(str)) {
            return false;
        }
        if (bundle != null) {
            ImmutableList immutableList = f15500d;
            int size = immutableList.size();
            int i = 0;
            while (i < size) {
                boolean containsKey = bundle.containsKey((String) immutableList.get(i));
                i++;
                if (containsKey) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean zzc(String str) {
        if (!f15497a.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean zzd(String str) {
        if (!f15499c.contains(str)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zze(String str, String str2) {
        if (!"_ce1".equals(str2) && !"_ce2".equals(str2)) {
            if ("_ln".equals(str2)) {
                if (str.equals(AppMeasurement.FCM_ORIGIN) || str.equals(AppMeasurement.FIAM_ORIGIN)) {
                    return true;
                }
                return false;
            }
            if (f15501e.contains(str2)) {
                return false;
            }
            ImmutableList immutableList = f15502f;
            int size = immutableList.size();
            int i = 0;
            while (i < size) {
                boolean matches = str2.matches((String) immutableList.get(i));
                i++;
                if (matches) {
                    return false;
                }
            }
            return true;
        }
        if (str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc")) {
            return true;
        }
        return false;
    }
}
