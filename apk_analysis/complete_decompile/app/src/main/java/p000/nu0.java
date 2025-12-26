package p000;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.common.cache.C0839d;
import com.google.common.cache.ConcurrentMapC0840e;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;

/* loaded from: classes.dex */
public final class nu0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f23496a = 0;

    /* renamed from: b */
    public final /* synthetic */ int f23497b;

    /* renamed from: c */
    public final /* synthetic */ Object f23498c;

    /* renamed from: d */
    public final /* synthetic */ Object f23499d;

    /* renamed from: e */
    public final /* synthetic */ Object f23500e;

    /* renamed from: f */
    public final /* synthetic */ Serializable f23501f;

    public nu0(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f23497b = i;
        this.f23498c = arrayList;
        this.f23499d = arrayList2;
        this.f23500e = arrayList3;
        this.f23501f = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f23496a) {
            case 0:
                for (int i = 0; i < this.f23497b; i++) {
                    ViewCompat.setTransitionName((View) ((ArrayList) this.f23498c).get(i), (String) ((ArrayList) this.f23499d).get(i));
                    ViewCompat.setTransitionName((View) ((ArrayList) this.f23500e).get(i), (String) ((ArrayList) this.f23501f).get(i));
                }
                return;
            default:
                lb1 lb1Var = (lb1) this.f23499d;
                try {
                    ((C0839d) this.f23501f).m3803i(this.f23498c, this.f23497b, lb1Var, (ListenableFuture) this.f23500e);
                    return;
                } catch (Throwable th) {
                    ConcurrentMapC0840e.f14584w.log(Level.WARNING, "Exception thrown during refresh", th);
                    lb1Var.f22434b.setException(th);
                    return;
                }
        }
    }

    public nu0(C0839d c0839d, Object obj, int i, lb1 lb1Var, ListenableFuture listenableFuture) {
        this.f23501f = c0839d;
        this.f23498c = obj;
        this.f23497b = i;
        this.f23499d = lb1Var;
        this.f23500e = listenableFuture;
    }
}
