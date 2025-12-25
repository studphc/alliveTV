package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.jt2;
import p000.y41;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m5569d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function0;", "block", "runInterruptible", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class InterruptibleKt {
    public static final Object access$runInterruptibleInExpectedContext(CoroutineContext coroutineContext, Function0 function0) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        try {
            Job job = JobKt.getJob(coroutineContext);
            jt2 jt2Var = new jt2(job);
            jt2Var.f20628c = job.invokeOnCompletion(true, true, jt2Var);
            try {
                do {
                    atomicIntegerFieldUpdater = jt2.f20625d;
                    i = atomicIntegerFieldUpdater.get(jt2Var);
                    if (i != 0) {
                        if (i != 2 && i != 3) {
                            jt2.m5460b(i);
                            throw null;
                        }
                    }
                    return function0.invoke();
                } while (!atomicIntegerFieldUpdater.compareAndSet(jt2Var, i, 0));
                return function0.invoke();
            } finally {
                jt2Var.m5461a();
            }
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }

    @Nullable
    public static final <T> Object runInterruptible(@NotNull CoroutineContext coroutineContext, @NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        return BuildersKt.withContext(coroutineContext, new y41(function0, null), continuation);
    }

    public static /* synthetic */ Object runInterruptible$default(CoroutineContext coroutineContext, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return runInterruptible(coroutineContext, function0, continuation);
    }
}
