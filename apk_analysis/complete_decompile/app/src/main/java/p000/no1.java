package p000;

import android.util.Log;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public final class no1 extends FutureTask {

    /* renamed from: a */
    public final /* synthetic */ ro1 f23442a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public no1(ro1 ro1Var, u40 u40Var) {
        super(u40Var);
        this.f23442a = ro1Var;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        ro1 ro1Var = this.f23442a;
        try {
            Object obj = get();
            if (!ro1Var.f26086e.get()) {
                ro1Var.m7294a(obj);
            }
        } catch (InterruptedException e) {
            Log.w("AsyncTask", e);
        } catch (CancellationException unused) {
            if (!ro1Var.f26086e.get()) {
                ro1Var.m7294a(null);
            }
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occurred while executing doInBackground()", th);
        }
    }
}
