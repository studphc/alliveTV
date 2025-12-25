package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.vz2;

@Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "initSelectResult", "()Ljava/lang/Object;", "", "e", "", "handleBuilderException", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
/* loaded from: classes2.dex */
public final class UnbiasedSelectBuilderImpl<R> extends UnbiasedSelectImplementation<R> {

    /* renamed from: h */
    public final CancellableContinuationImpl f22108h;

    public UnbiasedSelectBuilderImpl(@NotNull Continuation<? super R> continuation) {
        super(continuation.getContext());
        this.f22108h = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
    }

    @PublishedApi
    public final void handleBuilderException(@NotNull Throwable e) {
        CancellableContinuationImpl cancellableContinuationImpl = this.f22108h;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(e)));
    }

    @PublishedApi
    @Nullable
    public final Object initSelectResult() {
        CancellableContinuationImpl cancellableContinuationImpl = this.f22108h;
        if (cancellableContinuationImpl.isCompleted()) {
            return cancellableContinuationImpl.getResult();
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(getContext()), null, CoroutineStart.UNDISPATCHED, new vz2(this, null), 1, null);
        return cancellableContinuationImpl.getResult();
    }
}
