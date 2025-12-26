package p000;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class qn2 extends AbstractSharedFlowSlot {

    /* renamed from: a */
    public static final AtomicReferenceFieldUpdater f25701a = AtomicReferenceFieldUpdater.newUpdater(qn2.class, Object.class, "_state");

    @Volatile
    @Nullable
    private volatile Object _state;

    /* renamed from: a */
    public final Object m7113a(on2 on2Var) {
        Symbol symbol;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(on2Var), 1);
        cancellableContinuationImpl.initCancellability();
        symbol = StateFlowKt.f21968a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f25701a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, symbol, cancellableContinuationImpl)) {
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != symbol) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
                break;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(on2Var);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final boolean allocateLocked(Object obj) {
        Symbol symbol;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f25701a;
        if (atomicReferenceFieldUpdater.get(this) == null) {
            symbol = StateFlowKt.f21968a;
            atomicReferenceFieldUpdater.set(this, symbol);
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final Continuation[] freeLocked(Object obj) {
        f25701a.set(this, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }
}
