package p000;

import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobNode;

/* loaded from: classes2.dex */
public final class kc2 extends JobNode {

    /* renamed from: d */
    public final CancellableContinuationImpl f20818d;

    public kc2(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f20818d = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        Result.Companion companion = Result.INSTANCE;
        this.f20818d.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
    }
}
