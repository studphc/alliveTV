package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import p000.ed3;

/* loaded from: classes.dex */
public final class zznx implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    public volatile boolean f14334a;

    /* renamed from: b */
    public volatile zzgy f14335b;

    /* renamed from: c */
    public final /* synthetic */ zzny f14336c;

    public zznx(zzny zznyVar) {
        this.f14336c = zznyVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnected(Bundle bundle) {
        this.f14336c.zzu.zzaX().zzn();
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.f14335b);
                this.f14336c.zzu.zzaX().zzq(new RunnableC0804i0(this, (zzgl) this.f14335b.getService(), 1));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f14335b = null;
                this.f14334a = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzny zznyVar = this.f14336c;
        zznyVar.zzu.zzaX().zzn();
        zzhe zzl = zznyVar.zzu.zzl();
        if (zzl != null) {
            zzl.zzk().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f14334a = false;
            this.f14335b = null;
        }
        this.f14336c.zzu.zzaX().zzq(new RunnableC0806j0(this, connectionResult));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnectionSuspended(int i) {
        zzio zzioVar = this.f14336c.zzu;
        zzioVar.zzaX().zzn();
        zzioVar.zzaW().zzd().zza("Service connection suspended");
        zzioVar.zzaX().zzq(new RunnableC0788a0(1, this));
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzgl zzgjVar;
        this.f14336c.zzu.zzaX().zzn();
        synchronized (this) {
            if (iBinder == null) {
                this.f14334a = false;
                this.f14336c.zzu.zzaW().zze().zza("Service connected with null binder");
                return;
            }
            zzgl zzglVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (queryLocalInterface instanceof zzgl) {
                        zzgjVar = (zzgl) queryLocalInterface;
                    } else {
                        zzgjVar = new zzgj(iBinder);
                    }
                    zzglVar = zzgjVar;
                    this.f14336c.zzu.zzaW().zzj().zza("Bound to IMeasurementService interface");
                } else {
                    this.f14336c.zzu.zzaW().zze().zzb("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f14336c.zzu.zzaW().zze().zza("Service connect failed to get IMeasurementService");
            }
            if (zzglVar == null) {
                this.f14334a = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    zzny zznyVar = this.f14336c;
                    connectionTracker.unbindService(zznyVar.zzu.zzaT(), zznyVar.f14337b);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f14336c.zzu.zzaX().zzq(new RunnableC0804i0(this, zzglVar, 0));
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzio zzioVar = this.f14336c.zzu;
        zzioVar.zzaX().zzn();
        zzioVar.zzaW().zzd().zza("Service disconnected");
        zzioVar.zzaX().zzq(new ed3(2, this, componentName));
    }

    @WorkerThread
    public final void zzb(Intent intent) {
        zzny zznyVar = this.f14336c;
        zznyVar.zzg();
        Context zzaT = zznyVar.zzu.zzaT();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            try {
                if (this.f14334a) {
                    this.f14336c.zzu.zzaW().zzj().zza("Connection attempt already in progress");
                    return;
                }
                zzny zznyVar2 = this.f14336c;
                zznyVar2.zzu.zzaW().zzj().zza("Using local app measurement service");
                this.f14334a = true;
                connectionTracker.bindService(zzaT, intent, zznyVar2.f14337b, TsExtractor.TS_STREAM_TYPE_AC3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public final void zzc() {
        zzny zznyVar = this.f14336c;
        zznyVar.zzg();
        Context zzaT = zznyVar.zzu.zzaT();
        synchronized (this) {
            try {
                if (this.f14334a) {
                    this.f14336c.zzu.zzaW().zzj().zza("Connection attempt already in progress");
                    return;
                }
                if (this.f14335b != null && (this.f14335b.isConnecting() || this.f14335b.isConnected())) {
                    this.f14336c.zzu.zzaW().zzj().zza("Already awaiting connection attempt");
                    return;
                }
                this.f14335b = new zzgy(zzaT, Looper.getMainLooper(), this, this);
                this.f14336c.zzu.zzaW().zzj().zza("Connecting to remote service");
                this.f14334a = true;
                Preconditions.checkNotNull(this.f14335b);
                this.f14335b.checkAvailabilityAndConnect();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public final void zzd() {
        if (this.f14335b != null && (this.f14335b.isConnected() || this.f14335b.isConnecting())) {
            this.f14335b.disconnect();
        }
        this.f14335b = null;
    }
}
