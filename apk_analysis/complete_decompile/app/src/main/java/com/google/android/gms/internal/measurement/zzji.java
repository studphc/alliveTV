package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.ChecksSdkIntAtLeast;

/* loaded from: classes.dex */
public final class zzji {

    /* renamed from: a */
    public static UserManager f13836a;

    /* renamed from: b */
    public static volatile boolean f13837b = !zzc();

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0039, code lost:
    
        if (r3.isUserRunning(android.os.Process.myUserHandle()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        r5 = true;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m3455a(Context context) {
        boolean z;
        boolean isUserUnlocked;
        if (f13837b) {
            return true;
        }
        synchronized (zzji.class) {
            try {
                if (f13837b) {
                    return true;
                }
                int i = 1;
                while (true) {
                    z = false;
                    if (i > 2) {
                        break;
                    }
                    if (f13836a == null) {
                        f13836a = (UserManager) context.getSystemService(UserManager.class);
                    }
                    UserManager userManager = f13836a;
                    if (userManager != null) {
                        try {
                            isUserUnlocked = userManager.isUserUnlocked();
                            if (isUserUnlocked) {
                                break;
                            }
                        } catch (NullPointerException e) {
                            Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                            f13836a = null;
                            i++;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    f13836a = null;
                }
                if (z) {
                    f13837b = true;
                }
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean zza(Context context) {
        if (zzc() && !m3455a(context)) {
            return true;
        }
        return false;
    }

    public static boolean zzb(Context context) {
        if (zzc() && !m3455a(context)) {
            return false;
        }
        return true;
    }

    @ChecksSdkIntAtLeast(api = 24)
    public static boolean zzc() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
