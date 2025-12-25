package com.google.android.gms.common.util;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzab;
import com.google.android.gms.internal.common.zzac;
import com.google.android.gms.internal.common.zzj;
import com.google.android.gms.internal.common.zzl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@KeepForSdk
/* loaded from: classes.dex */
public class ProcessUtils {

    /* renamed from: a */
    public static String f13654a;

    /* renamed from: b */
    public static int f13655b;

    /* renamed from: c */
    public static Boolean f13656c;

    @Nullable
    @KeepForSdk
    public static String getMyProcessName() {
        BufferedReader bufferedReader;
        String processName;
        if (f13654a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                f13654a = processName;
            } else {
                int i = f13655b;
                if (i == 0) {
                    i = Process.myPid();
                    f13655b = i;
                }
                String str = null;
                str = null;
                str = null;
                BufferedReader bufferedReader2 = null;
                if (i > 0) {
                    try {
                        String str2 = "/proc/" + i + "/cmdline";
                        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str2));
                            try {
                                String readLine = bufferedReader.readLine();
                                Preconditions.checkNotNull(readLine);
                                str = readLine.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                IOUtils.closeQuietly(bufferedReader2);
                                throw th;
                            }
                        } finally {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    IOUtils.closeQuietly(bufferedReader);
                }
                f13654a = str;
            }
        }
        return f13654a;
    }

    public static boolean zza() {
        boolean isIsolated;
        Boolean bool = f13656c;
        if (bool == null) {
            if (PlatformVersion.isAtLeastP()) {
                isIsolated = Process.isIsolated();
                bool = Boolean.valueOf(isIsolated);
            } else {
                try {
                    Object zza = zzl.zza(Process.class, "isIsolated", new zzj[0]);
                    Object[] objArr = new Object[0];
                    if (zza != null) {
                        bool = (Boolean) zza;
                    } else {
                        throw new zzac(zzab.zza("expected a non-null reference", objArr));
                    }
                } catch (ReflectiveOperationException unused) {
                    bool = Boolean.FALSE;
                }
            }
            f13656c = bool;
        }
        return bool.booleanValue();
    }
}
