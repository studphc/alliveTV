package p000;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class f81 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f17167a;

    /* renamed from: b */
    public final /* synthetic */ Runnable f17168b;

    /* renamed from: c */
    public final /* synthetic */ Object f17169c;

    public /* synthetic */ f81(Runnable runnable, Object obj, int i) {
        this.f17167a = i;
        this.f17168b = runnable;
        this.f17169c = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f17167a) {
            case 0:
                this.f17168b.run();
                return this.f17169c;
            default:
                this.f17168b.run();
                return this.f17169c;
        }
    }
}
