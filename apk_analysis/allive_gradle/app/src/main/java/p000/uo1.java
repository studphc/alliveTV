package p000;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes2.dex */
public final class uo1 implements Executor {

    /* renamed from: a */
    public final /* synthetic */ Executor f27397a;

    /* renamed from: b */
    public final /* synthetic */ os0 f27398b;

    public uo1(Executor executor, os0 os0Var) {
        this.f27397a = executor;
        this.f27398b = os0Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.f27397a.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.f27398b.setException(e);
        }
    }
}
