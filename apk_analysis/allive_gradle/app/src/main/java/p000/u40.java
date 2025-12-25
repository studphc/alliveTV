package p000;

import android.os.Binder;
import android.os.Process;
import androidx.core.os.OperationCanceledException;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.google.android.gms.measurement.internal.zzbh;
import com.google.android.gms.measurement.internal.zzjp;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class u40 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f27099a;

    /* renamed from: b */
    public final /* synthetic */ Object f27100b;

    public /* synthetic */ u40(int i, Object obj) {
        this.f27099a = i;
        this.f27100b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f27099a) {
            case 0:
                synchronized (((DiskLruCache) this.f27100b)) {
                    try {
                        DiskLruCache diskLruCache = (DiskLruCache) this.f27100b;
                        if (diskLruCache.f8552i != null) {
                            diskLruCache.m2298m();
                            if (((DiskLruCache) this.f27100b).m2293g()) {
                                ((DiskLruCache) this.f27100b).m2297k();
                                ((DiskLruCache) this.f27100b).f8554k = 0;
                            }
                            return null;
                        }
                        return null;
                    } finally {
                    }
                }
            case 1:
                ro1 ro1Var = (ro1) this.f27100b;
                ro1Var.f26086e.set(true);
                Object obj = null;
                try {
                    Process.setThreadPriority(10);
                    RunnableC0552bc runnableC0552bc = (RunnableC0552bc) ro1Var;
                    try {
                        obj = runnableC0552bc.f7961k.onLoadInBackground();
                    } catch (OperationCanceledException e) {
                        if (!runnableC0552bc.f26085d.get()) {
                            throw e;
                        }
                    }
                    Binder.flushPendingCommands();
                    return obj;
                } catch (Throwable th) {
                    try {
                        ro1Var.f26085d.set(true);
                        throw th;
                    } finally {
                        ro1Var.m7294a(null);
                    }
                }
            default:
                zzjp zzjpVar = (zzjp) this.f27100b;
                zzjpVar.f14280a.m3643c();
                zzjpVar.f14280a.zzv().zzg();
                throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public u40(zzjp zzjpVar, zzbh zzbhVar, String str) {
        this.f27099a = 2;
        this.f27100b = zzjpVar;
    }
}
