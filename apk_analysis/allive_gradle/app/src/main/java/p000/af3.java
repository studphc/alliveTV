package p000;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzh;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class af3 extends GmsClientSupervisor {

    /* renamed from: g */
    public final HashMap f164g = new HashMap();

    /* renamed from: h */
    public final Context f165h;

    /* renamed from: i */
    public volatile zzh f166i;

    /* renamed from: j */
    public final yw0 f167j;

    /* renamed from: k */
    public final ConnectionTracker f168k;

    /* renamed from: l */
    public final long f169l;

    /* renamed from: m */
    public final long f170m;

    /* renamed from: n */
    public volatile Executor f171n;

    public af3(Context context, Looper looper, Executor executor) {
        yw0 yw0Var = new yw0(2, this);
        this.f167j = yw0Var;
        this.f165h = context.getApplicationContext();
        this.f166i = new zzh(looper, yw0Var);
        this.f168k = ConnectionTracker.getInstance();
        this.f169l = 5000L;
        this.f170m = 300000L;
        this.f171n = executor;
    }

    /* renamed from: a */
    public final void m82a(Executor executor) {
        synchronized (this.f164g) {
            this.f171n = executor;
        }
    }

    /* renamed from: b */
    public final void m83b(Looper looper) {
        synchronized (this.f164g) {
            this.f166i = new zzh(looper, this.f167j);
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final ConnectionResult zza(zzo zzoVar, ServiceConnection serviceConnection, String str, Executor executor) {
        ConnectionResult connectionResult;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f164g) {
            try {
                qe3 qe3Var = (qe3) this.f164g.get(zzoVar);
                if (executor == null) {
                    executor = this.f171n;
                }
                if (qe3Var == null) {
                    qe3Var = new qe3(this, zzoVar);
                    qe3Var.f25553a.put(serviceConnection, serviceConnection);
                    connectionResult = qe3.m7033a(qe3Var, str, executor);
                    this.f164g.put(zzoVar, qe3Var);
                } else {
                    this.f166i.removeMessages(0, zzoVar);
                    if (!qe3Var.f25553a.containsKey(serviceConnection)) {
                        qe3Var.f25553a.put(serviceConnection, serviceConnection);
                        int i = qe3Var.f25554b;
                        if (i != 1) {
                            if (i == 2) {
                                connectionResult = qe3.m7033a(qe3Var, str, executor);
                            }
                        } else {
                            serviceConnection.onServiceConnected(qe3Var.f25558f, qe3Var.f25556d);
                        }
                        connectionResult = null;
                    } else {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzoVar.toString());
                    }
                }
                if (qe3Var.f25555c) {
                    return ConnectionResult.RESULT_SUCCESS;
                }
                if (connectionResult == null) {
                    connectionResult = new ConnectionResult(-1);
                }
                return connectionResult;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zzb(zzo zzoVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f164g) {
            try {
                qe3 qe3Var = (qe3) this.f164g.get(zzoVar);
                if (qe3Var != null) {
                    if (qe3Var.f25553a.containsKey(serviceConnection)) {
                        qe3Var.f25553a.remove(serviceConnection);
                        if (qe3Var.f25553a.isEmpty()) {
                            this.f166i.sendMessageDelayed(this.f166i.obtainMessage(0, zzoVar), this.f169l);
                        }
                    } else {
                        throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzoVar.toString());
                    }
                } else {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + zzoVar.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
