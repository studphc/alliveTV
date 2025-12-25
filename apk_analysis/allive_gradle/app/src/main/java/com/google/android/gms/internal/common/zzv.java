package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.jspecify.annotations.NullMarked;
import p000.ye0;

@NullMarked
/* loaded from: classes.dex */
public final class zzv {
    /* renamed from: a */
    public static String m3217a(int i, int i2, String str) {
        if (i < 0) {
            return zzab.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzab.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(ye0.m8291k(i2, "negative size: "));
    }

    public static int zza(int i, int i2, String str) {
        String zza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i >= 0) {
            if (i2 < 0) {
                throw new IllegalArgumentException(ye0.m8291k(i2, "negative size: "));
            }
            zza = zzab.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            zza = zzab.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(m3217a(i, i2, FirebaseAnalytics.Param.INDEX));
    }

    public static void zzc(int i, int i2, int i3) {
        String m3217a;
        if (i >= 0 && i2 >= i && i2 <= i3) {
            return;
        }
        if (i >= 0 && i <= i3) {
            if (i2 >= 0 && i2 <= i3) {
                m3217a = zzab.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            } else {
                m3217a = m3217a(i2, i3, "end index");
            }
        } else {
            m3217a = m3217a(i, i3, "start index");
        }
        throw new IndexOutOfBoundsException(m3217a);
    }
}
