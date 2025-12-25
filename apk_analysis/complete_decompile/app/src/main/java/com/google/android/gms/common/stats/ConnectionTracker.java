package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

@KeepForSdk
/* loaded from: classes.dex */
public class ConnectionTracker {

    /* renamed from: a */
    public static final Object f13617a = new Object();

    /* renamed from: b */
    public static volatile ConnectionTracker f13618b;

    @NonNull
    @VisibleForTesting
    public final ConcurrentHashMap zza = new ConcurrentHashMap();

    @NonNull
    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (f13618b == null) {
            synchronized (f13617a) {
                try {
                    if (f13618b == null) {
                        f13618b = new ConnectionTracker();
                    }
                } finally {
                }
            }
        }
        ConnectionTracker connectionTracker = f13618b;
        Preconditions.checkNotNull(connectionTracker);
        return connectionTracker;
    }

    /* renamed from: a */
    public final boolean m3200a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        boolean bindService;
        boolean bindService2;
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.packageManager(context).getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!(serviceConnection instanceof zzt)) {
            ServiceConnection serviceConnection2 = (ServiceConnection) this.zza.putIfAbsent(serviceConnection, serviceConnection);
            if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
            }
            if (executor == null) {
                executor = null;
            }
            try {
                if (PlatformVersion.isAtLeastQ() && executor != null) {
                    bindService2 = context.bindService(intent, i, executor, serviceConnection);
                } else {
                    bindService2 = context.bindService(intent, serviceConnection, i);
                }
                if (!bindService2) {
                    return false;
                }
                return bindService2;
            } finally {
                this.zza.remove(serviceConnection, serviceConnection);
            }
        }
        if (executor == null) {
            executor = null;
        }
        if (PlatformVersion.isAtLeastQ() && executor != null) {
            bindService = context.bindService(intent, i, executor, serviceConnection);
            return bindService;
        }
        return context.bindService(intent, serviceConnection, i);
    }

    @KeepForSdk
    public boolean bindService(@NonNull Context context, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i) {
        return m3200a(context, context.getClass().getName(), intent, serviceConnection, i, null);
    }

    @KeepForSdk
    public void unbindService(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        if (!(serviceConnection instanceof zzt) && this.zza.containsKey(serviceConnection)) {
            try {
                try {
                    context.unbindService((ServiceConnection) this.zza.get(serviceConnection));
                } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
                }
            } finally {
                this.zza.remove(serviceConnection);
            }
        } else {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
            }
        }
    }

    @KeepForSdk
    public void unbindServiceSafe(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean zza(@NonNull Context context, @NonNull String str, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i, @Nullable Executor executor) {
        return m3200a(context, str, intent, serviceConnection, 4225, executor);
    }
}
