package p000;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzaj;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.zzc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class qe3 implements ServiceConnection, zzt {

    /* renamed from: a */
    public final HashMap f25553a = new HashMap();

    /* renamed from: b */
    public int f25554b = 2;

    /* renamed from: c */
    public boolean f25555c;

    /* renamed from: d */
    public IBinder f25556d;

    /* renamed from: e */
    public final zzo f25557e;

    /* renamed from: f */
    public ComponentName f25558f;

    /* renamed from: g */
    public final /* synthetic */ af3 f25559g;

    public qe3(af3 af3Var, zzo zzoVar) {
        this.f25559g = af3Var;
        this.f25557e = zzoVar;
    }

    /* renamed from: a */
    public static /* bridge */ /* synthetic */ ConnectionResult m7033a(qe3 qe3Var, String str, Executor executor) {
        ConnectionResult connectionResult;
        try {
            Intent zzb = qe3Var.f25557e.zzb(qe3Var.f25559g.f165h);
            qe3Var.f25554b = 3;
            StrictMode.VmPolicy zza = zzc.zza();
            try {
                af3 af3Var = qe3Var.f25559g;
                boolean zza2 = af3Var.f168k.zza(af3Var.f165h, str, zzb, qe3Var, 4225, executor);
                qe3Var.f25555c = zza2;
                if (zza2) {
                    qe3Var.f25559g.f166i.sendMessageDelayed(qe3Var.f25559g.f166i.obtainMessage(1, qe3Var.f25557e), qe3Var.f25559g.f170m);
                    connectionResult = ConnectionResult.RESULT_SUCCESS;
                } else {
                    qe3Var.f25554b = 2;
                    try {
                        af3 af3Var2 = qe3Var.f25559g;
                        af3Var2.f168k.unbindService(af3Var2.f165h, qe3Var);
                    } catch (IllegalArgumentException unused) {
                    }
                    connectionResult = new ConnectionResult(16);
                }
                return connectionResult;
            } finally {
                StrictMode.setVmPolicy(zza);
            }
        } catch (zzaj e) {
            return e.zza;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f25559g.f164g) {
            try {
                this.f25559g.f166i.removeMessages(1, this.f25557e);
                this.f25556d = iBinder;
                this.f25558f = componentName;
                Iterator it = this.f25553a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f25554b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f25559g.f164g) {
            try {
                this.f25559g.f166i.removeMessages(1, this.f25557e);
                this.f25556d = null;
                this.f25558f = componentName;
                Iterator it = this.f25553a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f25554b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
