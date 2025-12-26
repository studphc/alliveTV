package p000;

import android.content.ComponentName;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zznx;
import com.google.android.gms.measurement.internal.zzny;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class ed3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f16776a;

    /* renamed from: b */
    public final /* synthetic */ Object f16777b;

    /* renamed from: c */
    public final /* synthetic */ Object f16778c;

    public /* synthetic */ ed3(int i, Object obj, Object obj2) {
        this.f16776a = i;
        this.f16777b = obj2;
        this.f16778c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16776a) {
            case 0:
                ((AppMeasurementDynamiteService) this.f16778c).f13971a.zzq().zzah((pe3) this.f16777b);
                return;
            case 1:
                synchronized (((pb3) this.f16778c).f25110c) {
                    try {
                        OnSuccessListener onSuccessListener = (OnSuccessListener) ((pb3) this.f16778c).f25111d;
                        if (onSuccessListener != null) {
                            onSuccessListener.onSuccess(((Task) this.f16777b).getResult());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 2:
                zzny.m3582j(((zznx) this.f16778c).f14336c, (ComponentName) this.f16777b);
                return;
            case 3:
                pb3 pb3Var = (pb3) this.f16778c;
                try {
                    Task then = ((SuccessContinuation) pb3Var.f25110c).then(((Task) this.f16777b).getResult());
                    if (then == null) {
                        pb3Var.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    d40 d40Var = TaskExecutors.f14453a;
                    then.addOnSuccessListener(d40Var, pb3Var);
                    then.addOnFailureListener(d40Var, pb3Var);
                    then.addOnCanceledListener(d40Var, pb3Var);
                    return;
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        pb3Var.onFailure((Exception) e.getCause());
                        return;
                    } else {
                        pb3Var.onFailure(e);
                        return;
                    }
                } catch (CancellationException unused) {
                    pb3Var.onCanceled();
                    return;
                } catch (Exception e2) {
                    pb3Var.onFailure(e2);
                    return;
                }
            case 4:
                zzpv zzpvVar = (zzpv) this.f16777b;
                zzpvVar.m3643c();
                zzpvVar.zzaX().zzg();
                if (zzpvVar.f14384p == null) {
                    zzpvVar.f14384p = new ArrayList();
                }
                zzpvVar.f14384p.add((Runnable) this.f16778c);
                zzpvVar.m3629P();
                return;
            default:
                ef3 ef3Var = (ef3) this.f16777b;
                try {
                    ef3Var.m4714b(((Callable) this.f16778c).call());
                    return;
                } catch (Exception e3) {
                    ef3Var.m4713a(e3);
                    return;
                } catch (Throwable th2) {
                    ef3Var.m4713a(new RuntimeException(th2));
                    return;
                }
        }
    }

    public /* synthetic */ ed3(int i, Object obj, Object obj2, boolean z) {
        this.f16776a = i;
        this.f16777b = obj;
        this.f16778c = obj2;
    }
}
