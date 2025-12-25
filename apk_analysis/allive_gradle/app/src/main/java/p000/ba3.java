package p000;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ba3 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f7943a;

    /* renamed from: b */
    public final /* synthetic */ FirebaseAnalytics f7944b;

    public /* synthetic */ ba3(FirebaseAnalytics firebaseAnalytics, int i) {
        this.f7943a = i;
        this.f7944b = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f7943a) {
            case 0:
                return this.f7944b.f15487a.zzl();
            default:
                return this.f7944b.f15487a.zzh();
        }
    }
}
