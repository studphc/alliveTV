package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@KeepForSdk
/* loaded from: classes.dex */
public class BlockingServiceConnection implements ServiceConnection {

    /* renamed from: a */
    public boolean f12972a = false;

    /* renamed from: b */
    public final LinkedBlockingQueue f12973b = new LinkedBlockingQueue();

    @NonNull
    @KeepForSdk
    public IBinder getService() {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (!this.f12972a) {
            this.f12972a = true;
            return (IBinder) this.f12973b.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @NonNull
    @KeepForSdk
    public IBinder getServiceWithTimeout(long j, @NonNull TimeUnit timeUnit) {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f12972a) {
            this.f12972a = true;
            IBinder iBinder = (IBinder) this.f12973b.poll(j, timeUnit);
            if (iBinder != null) {
                return iBinder;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.f12973b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
    }
}
