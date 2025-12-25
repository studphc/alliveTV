package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000e\u0010\rJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u000b\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¨\u0006\u0014"}, m5569d2 = {"Lkotlinx/coroutines/DispatchedCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getResult", "Lkotlinx/atomicfu/AtomicInt;", "_decision", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
/* loaded from: classes2.dex */
public final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {

    /* renamed from: d */
    public static final AtomicIntegerFieldUpdater f21403d = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");

    @Volatile
    @JvmField
    private volatile int _decision;

    public DispatchedCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object state) {
        afterResume(state);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    public void afterResume(@Nullable Object state) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f21403d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 1) {
                    DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.uCont), CompletionStateKt.recoverResult(state, this.uCont), null, 2, null);
                    return;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }

    @Nullable
    public final Object getResult$kotlinx_coroutines_core() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f21403d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 2) {
                    Object unboxState = JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
                    if (!(unboxState instanceof CompletedExceptionally)) {
                        return unboxState;
                    }
                    throw ((CompletedExceptionally) unboxState).cause;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 1));
        return b51.getCOROUTINE_SUSPENDED();
    }
}
