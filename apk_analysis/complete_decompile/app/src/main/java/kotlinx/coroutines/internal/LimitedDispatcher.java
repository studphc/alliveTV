package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.xy1;

@Metadata(m5568d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001!B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0097Aø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\b2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0017¢\u0006\u0004\b\u001e\u0010\u001dR\u000b\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m5569d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "", "parallelism", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "", "time", "", "delay", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeMillis", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "Lkotlinx/atomicfu/AtomicInt;", "runningWorkers", "xy1", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,134:1\n66#1,8:135\n66#1,8:143\n28#2,4:151\n28#2,4:156\n20#3:155\n20#3:160\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n*L\n48#1:135,8\n55#1:143,8\n79#1:151,4\n92#1:156,4\n79#1:155\n92#1:160\n*E\n"})
/* loaded from: classes2.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {

    /* renamed from: g */
    public static final AtomicIntegerFieldUpdater f22016g = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");

    /* renamed from: b */
    public final CoroutineDispatcher f22017b;

    /* renamed from: c */
    public final int f22018c;

    /* renamed from: d */
    public final /* synthetic */ Delay f22019d;

    /* renamed from: e */
    public final LockFreeTaskQueue f22020e;

    /* renamed from: f */
    public final Object f22021f;

    @Volatile
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(@NotNull CoroutineDispatcher coroutineDispatcher, int i) {
        Delay delay;
        this.f22017b = coroutineDispatcher;
        this.f22018c = i;
        if (coroutineDispatcher instanceof Delay) {
            delay = (Delay) coroutineDispatcher;
        } else {
            delay = null;
        }
        this.f22019d = delay == null ? DefaultExecutorKt.getDefaultDelay() : delay;
        this.f22020e = new LockFreeTaskQueue(false);
        this.f22021f = new Object();
    }

    public static final /* synthetic */ CoroutineDispatcher access$getDispatcher$p(LimitedDispatcher limitedDispatcher) {
        return limitedDispatcher.f22017b;
    }

    public static final /* synthetic */ Runnable access$obtainTaskOrDeallocateWorker(LimitedDispatcher limitedDispatcher) {
        return limitedDispatcher.m5729a();
    }

    /* renamed from: a */
    public final Runnable m5729a() {
        while (true) {
            Runnable runnable = (Runnable) this.f22020e.removeFirstOrNull();
            if (runnable == null) {
                synchronized (this.f22021f) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f22016g;
                    atomicIntegerFieldUpdater.decrementAndGet(this);
                    if (this.f22020e.getSize() == 0) {
                        return null;
                    }
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                }
            } else {
                return runnable;
            }
        }
    }

    /* renamed from: b */
    public final boolean m5730b() {
        synchronized (this.f22021f) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f22016g;
            if (atomicIntegerFieldUpdater.get(this) >= this.f22018c) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        return this.f22019d.delay(j, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        Runnable m5729a;
        this.f22020e.addLast(block);
        if (f22016g.get(this) < this.f22018c && m5730b() && (m5729a = m5729a()) != null) {
            this.f22017b.dispatch(this, new xy1(8, this, m5729a));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @InternalCoroutinesApi
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        Runnable m5729a;
        this.f22020e.addLast(block);
        if (f22016g.get(this) < this.f22018c && m5730b() && (m5729a = m5729a()) != null) {
            this.f22017b.dispatchYield(this, new xy1(8, this, m5729a));
        }
    }

    @Override // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return this.f22019d.invokeOnTimeout(timeMillis, block, context);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @ExperimentalCoroutinesApi
    @NotNull
    public CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        if (parallelism >= this.f22018c) {
            return this;
        }
        return super.limitedParallelism(parallelism);
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        this.f22019d.scheduleResumeAfterDelay(timeMillis, continuation);
    }
}
