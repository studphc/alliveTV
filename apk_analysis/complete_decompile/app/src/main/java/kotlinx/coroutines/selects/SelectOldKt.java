package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a:\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0081Hø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a:\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0081Hø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, m5569d2 = {"R", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "selectOld", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUnbiasedOld", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SelectOldKt {
    public static final void access$resumeUndispatched(CancellableContinuation cancellableContinuation, Object obj) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) cancellableContinuation.getContext().get(CoroutineDispatcher.INSTANCE);
        if (coroutineDispatcher != null) {
            cancellableContinuation.resumeUndispatched(coroutineDispatcher, obj);
        } else {
            cancellableContinuation.resumeWith(Result.m8512constructorimpl(obj));
        }
    }

    public static final void access$resumeUndispatchedWithException(CancellableContinuation cancellableContinuation, Throwable th) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) cancellableContinuation.getContext().get(CoroutineDispatcher.INSTANCE);
        if (coroutineDispatcher != null) {
            cancellableContinuation.resumeUndispatchedWithException(coroutineDispatcher, th);
        } else {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(th)));
        }
    }

    @PublishedApi
    @Nullable
    public static final <R> Object selectOld(@NotNull Function1<? super SelectBuilder<? super R>, Unit> function1, @NotNull Continuation<? super R> continuation) {
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
        try {
            function1.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        Object result = selectBuilderImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @PublishedApi
    @Nullable
    public static final <R> Object selectUnbiasedOld(@NotNull Function1<? super SelectBuilder<? super R>, Unit> function1, @NotNull Continuation<? super R> continuation) {
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(continuation);
        try {
            function1.invoke(unbiasedSelectBuilderImpl);
        } catch (Throwable th) {
            unbiasedSelectBuilderImpl.handleBuilderException(th);
        }
        Object initSelectResult = unbiasedSelectBuilderImpl.initSelectResult();
        if (initSelectResult == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return initSelectResult;
    }
}
