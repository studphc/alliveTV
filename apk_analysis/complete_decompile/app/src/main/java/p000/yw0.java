package p000;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import androidx.core.provider.SelfDestructiveThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzo;

/* loaded from: classes.dex */
public final class yw0 implements Handler.Callback {

    /* renamed from: a */
    public final /* synthetic */ int f29148a;

    /* renamed from: b */
    public final /* synthetic */ Object f29149b;

    public /* synthetic */ yw0(int i, Object obj) {
        this.f29148a = i;
        this.f29149b = obj;
    }

    /* renamed from: a */
    private final boolean m8328a(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return true;
            }
            SelfDestructiveThread selfDestructiveThread = (SelfDestructiveThread) this.f29149b;
            Runnable runnable = (Runnable) message.obj;
            selfDestructiveThread.getClass();
            runnable.run();
            synchronized (selfDestructiveThread.f3732a) {
                selfDestructiveThread.f3734c.removeMessages(0);
                Handler handler = selfDestructiveThread.f3734c;
                handler.sendMessageDelayed(handler.obtainMessage(0), selfDestructiveThread.f3737f);
            }
            return true;
        }
        ((SelfDestructiveThread) this.f29149b).m879a();
        return true;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f29148a) {
            case 0:
                int i = message.what;
                zw0 zw0Var = (zw0) this.f29149b;
                if (i == 1) {
                    zw0Var.m8444b((xw0) message.obj);
                    return true;
                }
                if (i == 2) {
                    zw0Var.f29531d.clear((xw0) message.obj);
                }
                return false;
            case 1:
                return m8328a(message);
            default:
                int i2 = message.what;
                if (i2 != 0) {
                    if (i2 != 1) {
                        return false;
                    }
                    synchronized (((af3) this.f29149b).f164g) {
                        try {
                            zzo zzoVar = (zzo) message.obj;
                            qe3 qe3Var = (qe3) ((af3) this.f29149b).f164g.get(zzoVar);
                            if (qe3Var != null && qe3Var.f25554b == 3) {
                                Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(zzoVar)), new Exception());
                                ComponentName componentName = qe3Var.f25558f;
                                if (componentName == null) {
                                    componentName = zzoVar.zza();
                                }
                                if (componentName == null) {
                                    String zzc = zzoVar.zzc();
                                    Preconditions.checkNotNull(zzc);
                                    componentName = new ComponentName(zzc, EnvironmentCompat.MEDIA_UNKNOWN);
                                }
                                qe3Var.onServiceDisconnected(componentName);
                            }
                        } finally {
                        }
                    }
                } else {
                    synchronized (((af3) this.f29149b).f164g) {
                        try {
                            zzo zzoVar2 = (zzo) message.obj;
                            qe3 qe3Var2 = (qe3) ((af3) this.f29149b).f164g.get(zzoVar2);
                            if (qe3Var2 != null && qe3Var2.f25553a.isEmpty()) {
                                if (qe3Var2.f25555c) {
                                    qe3Var2.f25559g.f166i.removeMessages(1, qe3Var2.f25557e);
                                    af3 af3Var = qe3Var2.f25559g;
                                    af3Var.f168k.unbindService(af3Var.f165h, qe3Var2);
                                    qe3Var2.f25555c = false;
                                    qe3Var2.f25554b = 2;
                                }
                                ((af3) this.f29149b).f164g.remove(zzoVar2);
                            }
                        } finally {
                        }
                    }
                }
                return true;
        }
    }
}
