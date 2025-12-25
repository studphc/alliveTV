package p000;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class e81 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f16708a;

    /* renamed from: b */
    public final /* synthetic */ Runnable f16709b;

    public /* synthetic */ e81(int i, Runnable runnable) {
        this.f16708a = i;
        this.f16709b = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f16708a) {
            case 0:
                this.f16709b.run();
                return null;
            default:
                this.f16709b.run();
                return null;
        }
    }
}
