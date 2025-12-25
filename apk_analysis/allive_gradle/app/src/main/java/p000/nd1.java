package p000;

import androidx.core.location.C0185e;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class nd1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f23331a;

    /* renamed from: b */
    public final /* synthetic */ C0185e f23332b;

    /* renamed from: c */
    public final /* synthetic */ Executor f23333c;

    public /* synthetic */ nd1(C0185e c0185e, Executor executor, int i) {
        this.f23331a = i;
        this.f23332b = c0185e;
        this.f23333c = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f23331a) {
            case 0:
                C0185e c0185e = this.f23332b;
                if (c0185e.f3702b == this.f23333c) {
                    c0185e.f3701a.onStopped();
                    return;
                }
                return;
            default:
                C0185e c0185e2 = this.f23332b;
                if (c0185e2.f3702b == this.f23333c) {
                    c0185e2.f3701a.onStarted();
                    return;
                }
                return;
        }
    }
}
