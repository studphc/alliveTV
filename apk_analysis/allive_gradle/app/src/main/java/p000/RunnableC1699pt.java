package p000;

import androidx.activity.result.contract.ActivityResultContract;

/* renamed from: pt */
/* loaded from: classes.dex */
public final class RunnableC1699pt implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f25281a;

    /* renamed from: b */
    public final /* synthetic */ ActivityResultContract.SynchronousResult f25282b;

    /* renamed from: c */
    public final /* synthetic */ C1773rt f25283c;

    public RunnableC1699pt(C1773rt c1773rt, int i, ActivityResultContract.SynchronousResult synchronousResult) {
        this.f25283c = c1773rt;
        this.f25281a = i;
        this.f25282b = synchronousResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f25283c.dispatchResult(this.f25281a, this.f25282b.getValue());
    }
}
