package p000;

import androidx.constraintlayout.helper.widget.RunnableC0125a;

/* renamed from: cl */
/* loaded from: classes.dex */
public final class RunnableC0597cl implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ float f8408a;

    /* renamed from: b */
    public final /* synthetic */ RunnableC0125a f8409b;

    public RunnableC0597cl(RunnableC0125a runnableC0125a, float f) {
        this.f8409b = runnableC0125a;
        this.f8408a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8409b.f2683a.f2618i.touchAnimateTo(5, 1.0f, this.f8408a);
    }
}
