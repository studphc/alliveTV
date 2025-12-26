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
import p000.xf2;

@Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/SelectImplementation;", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "getResult", "()Ljava/lang/Object;", "", "e", "", "handleBuilderException", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
/* loaded from: classes2.dex */
public final class SelectBuilderImpl<R> extends SelectImplementation<R> {

    /* renamed from: g */
    public final CancellableContinuationImpl f22077g;

    public SelectBuilderImpl(@NotNull Continuation<? super R> continuation) {
        super(continuation.getContext());
        this.f22077g = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        CancellableContinuationImpl cancellableContinuationImpl = this.f22077g;
        if (cancellableContinuationImpl.isCompleted()) {
            return cancellableContinuationImpl.getResult();
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(getContext()), null, CoroutineStart.UNDISPATCHED, new xf2(this, null), 1, null);
        return cancellableContinuationImpl.getResult();
    }

    @PublishedApi
    public final void handleBuilderException(@NotNull Throwable e) {
        CancellableContinuationImpl cancellableContinuationImpl = this.f22077g;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(e)));
    }
}
