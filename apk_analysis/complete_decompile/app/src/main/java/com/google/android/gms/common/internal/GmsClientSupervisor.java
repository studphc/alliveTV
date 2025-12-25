package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executor;
import p000.af3;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GmsClientSupervisor {

    /* renamed from: a */
    public static final Object f13440a = new Object();

    /* renamed from: b */
    public static int f13441b = 9;

    /* renamed from: c */
    public static af3 f13442c = null;

    /* renamed from: d */
    public static HandlerThread f13443d = null;

    /* renamed from: e */
    public static Executor f13444e = null;

    /* renamed from: f */
    public static boolean f13445f = false;

    @KeepForSdk
    public static int getDefaultBindFlags() {
        return 4225;
    }

    @NonNull
    @KeepForSdk
    public static GmsClientSupervisor getInstance(@NonNull Context context) {
        Looper mainLooper;
        synchronized (f13440a) {
            try {
                if (f13442c == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (f13445f) {
                        mainLooper = getOrStartHandlerThread().getLooper();
                    } else {
                        mainLooper = context.getMainLooper();
                    }
                    f13442c = new af3(applicationContext, mainLooper, f13444e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f13442c;
    }

    @NonNull
    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread() {
        synchronized (f13440a) {
            try {
                HandlerThread handlerThread = f13443d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", f13441b);
                f13443d = handlerThread2;
                handlerThread2.start();
                return f13443d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static void setDefaultBindExecutor(@Nullable Executor executor) {
        synchronized (f13440a) {
            try {
                af3 af3Var = f13442c;
                if (af3Var != null) {
                    af3Var.m82a(executor);
                }
                f13444e = executor;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static boolean setGamHandlerThreadPriorityIfNotInitialized(int i) {
        synchronized (f13440a) {
            try {
                if (f13443d == null) {
                    f13441b = i;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static void setUseHandlerThreadForCallbacks() {
        synchronized (f13440a) {
            try {
                af3 af3Var = f13442c;
                if (af3Var != null && !f13445f) {
                    af3Var.m83b(getOrStartHandlerThread().getLooper());
                }
                f13445f = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public boolean bindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        return zza(new zzo(componentName, 4225), serviceConnection, str, null).isSuccess();
    }

    @KeepForSdk
    public void unbindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        zzb(new zzo(componentName, 4225), serviceConnection, str);
    }

    public abstract ConnectionResult zza(zzo zzoVar, ServiceConnection serviceConnection, String str, @Nullable Executor executor);

    public abstract void zzb(zzo zzoVar, ServiceConnection serviceConnection, String str);

    public final void zzc(@NonNull String str, @NonNull String str2, int i, @NonNull ServiceConnection serviceConnection, @NonNull String str3, boolean z) {
        zzb(new zzo(str, str2, 4225, z), serviceConnection, str3);
    }

    @KeepForSdk
    public void unbindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        zzb(new zzo(str, 4225, false), serviceConnection, str2);
    }

    @KeepForSdk
    public boolean bindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str, @Nullable Executor executor) {
        return zza(new zzo(componentName, 4225), serviceConnection, str, executor).isSuccess();
    }

    @NonNull
    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread(int i) {
        synchronized (f13440a) {
            try {
                HandlerThread handlerThread = f13443d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", i);
                f13443d = handlerThread2;
                handlerThread2.start();
                return f13443d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public boolean bindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        return zza(new zzo(str, 4225, false), serviceConnection, str2, null).isSuccess();
    }
}
