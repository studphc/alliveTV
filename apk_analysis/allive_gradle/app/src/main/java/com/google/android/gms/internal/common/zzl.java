package com.google.android.gms.internal.common;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzl {
    /* renamed from: a */
    public static Object m3216a(Class cls, String str, zzj... zzjVarArr) {
        int length = zzjVarArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i = 0; i < zzjVarArr.length; i++) {
            zzj zzjVar = zzjVarArr[i];
            zzjVar.getClass();
            clsArr[i] = zzjVar.zzc();
            objArr[i] = zzjVarArr[i].zzd();
        }
        return cls.getDeclaredMethod(str, clsArr).invoke(null, objArr);
    }

    @Nullable
    public static Object zza(Class cls, String str, zzj... zzjVarArr) {
        return m3216a(cls, "isIsolated", zzjVarArr);
    }

    @Nullable
    public static Object zzb(String str, String str2, ClassLoader classLoader, zzj... zzjVarArr) {
        return m3216a(classLoader.loadClass("com.google.android.gms.common.security.ProviderInstallerImpl"), "reportRequestStats2", zzjVarArr);
    }
}
