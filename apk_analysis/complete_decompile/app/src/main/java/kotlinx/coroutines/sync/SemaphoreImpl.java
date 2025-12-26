package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1891v;
import p000.ag2;
import p000.b51;
import p000.cg2;
import p000.ye0;
import p000.zf2;

@Metadata(m5568d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0005¢\u0006\u0004\b\u000b\u0010\u000fJ%\u0010\u0014\u001a\u00020\n2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000b\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004R\u000b\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004R\u000b\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004R\u0011\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004R\u0011\u0010#\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, m5569d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "tryAcquire", "()Z", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "waiter", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "ignoredParam", "onAcquireRegFunction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "release", "()V", "getAvailablePermits", "()I", "availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "_availablePermits", "Lkotlinx/atomicfu/AtomicLong;", "deqIdx", "enqIdx", "Lkotlinx/atomicfu/AtomicRef;", "Lcg2;", "head", "tail", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 5 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n205#1,10:411\n205#1,10:421\n1#2:398\n332#3,12:399\n72#4,3:431\n46#4,8:434\n72#4,3:445\n46#4,8:448\n375#5:442\n375#5:443\n367#5:444\n378#5:456\n367#5:457\n375#5:458\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n*L\n197#1:411,10\n221#1:421,10\n187#1:399,12\n289#1:431,3\n289#1:434,8\n322#1:445,3\n322#1:448,8\n293#1:442\n299#1:443\n313#1:444\n328#1:456\n334#1:457\n337#1:458\n*E\n"})
/* loaded from: classes2.dex */
public class SemaphoreImpl implements Semaphore {

    /* renamed from: c */
    public static final AtomicReferenceFieldUpdater f22117c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");

    /* renamed from: d */
    public static final AtomicLongFieldUpdater f22118d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");

    /* renamed from: e */
    public static final AtomicReferenceFieldUpdater f22119e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");

    /* renamed from: f */
    public static final AtomicLongFieldUpdater f22120f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");

    /* renamed from: g */
    public static final AtomicIntegerFieldUpdater f22121g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    @Volatile
    private volatile int _availablePermits;

    /* renamed from: a */
    public final int f22122a;

    /* renamed from: b */
    public final C1891v f22123b;

    @Volatile
    private volatile long deqIdx;

    @Volatile
    private volatile long enqIdx;

    @Volatile
    @Nullable
    private volatile Object head;

    @Volatile
    @Nullable
    private volatile Object tail;

    public SemaphoreImpl(int i, int i2) {
        this.f22122a = i;
        if (i > 0) {
            if (i2 >= 0 && i2 <= i) {
                cg2 cg2Var = new cg2(0L, null, 2);
                this.head = cg2Var;
                this.tail = cg2Var;
                this._availablePermits = i - i2;
                this.f22123b = new C1891v(11, this);
                return;
            }
            throw new IllegalArgumentException(ye0.m8291k(i, "The number of acquired permits should be in 0..").toString());
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Semaphore should have at least 1 permit, but had ").toString());
    }

    /* renamed from: a */
    public final Object m5751a(Continuation continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        try {
            if (!m5752b(orCreateCancellableContinuation)) {
                acquire((CancellableContinuation<? super Unit>) orCreateCancellableContinuation);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == b51.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == b51.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    @Nullable
    public Object acquire(@NotNull Continuation<? super Unit> continuation) {
        int andDecrement;
        do {
            andDecrement = f22121g.getAndDecrement(this);
        } while (andDecrement > this.f22122a);
        if (andDecrement > 0) {
            return Unit.INSTANCE;
        }
        Object m5751a = m5751a(continuation);
        return m5751a == b51.getCOROUTINE_SUSPENDED() ? m5751a : Unit.INSTANCE;
    }

    /* renamed from: b */
    public final boolean m5752b(Waiter waiter) {
        int i;
        Object findSegmentInternal;
        int i2;
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22119e;
        cg2 cg2Var = (cg2) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f22120f.getAndIncrement(this);
        zf2 zf2Var = zf2.f29359h;
        i = SemaphoreKt.f22129f;
        long j = andIncrement / i;
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(cg2Var, j, zf2Var);
            if (!SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
                Segment m8904getSegmentimpl = SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m8904getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!m8904getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, m8904getSegmentimpl)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (m8904getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                m8904getSegmentimpl.remove();
                            }
                        }
                    }
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        cg2 cg2Var2 = (cg2) SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
        i2 = SemaphoreKt.f22129f;
        int i3 = (int) (andIncrement % i2);
        AtomicReferenceArray atomicReferenceArray = cg2Var2.f8361d;
        while (!atomicReferenceArray.compareAndSet(i3, null, waiter)) {
            if (atomicReferenceArray.get(i3) != null) {
                symbol = SemaphoreKt.f22125b;
                symbol2 = SemaphoreKt.f22126c;
                AtomicReferenceArray atomicReferenceArray2 = cg2Var2.f8361d;
                while (!atomicReferenceArray2.compareAndSet(i3, symbol, symbol2)) {
                    if (atomicReferenceArray2.get(i3) != symbol) {
                        return false;
                    }
                }
                if (waiter instanceof CancellableContinuation) {
                    Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    ((CancellableContinuation) waiter).resume(Unit.INSTANCE, this.f22123b);
                } else if (waiter instanceof SelectInstance) {
                    ((SelectInstance) waiter).selectInRegistrationPhase(Unit.INSTANCE);
                } else {
                    throw new IllegalStateException(("unexpected: " + waiter).toString());
                }
                return true;
            }
        }
        waiter.invokeOnCancellation(cg2Var2, i3);
        return true;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(f22121g.get(this), 0);
    }

    public final void onAcquireRegFunction(@NotNull SelectInstance<?> select, @Nullable Object ignoredParam) {
        while (true) {
            int andDecrement = f22121g.getAndDecrement(this);
            if (andDecrement <= this.f22122a) {
                if (andDecrement > 0) {
                    select.selectInRegistrationPhase(Unit.INSTANCE);
                    return;
                } else {
                    Intrinsics.checkNotNull(select, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
                    if (m5752b((Waiter) select)) {
                        return;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        int i;
        int i2;
        Object findSegmentInternal;
        boolean z;
        int i3;
        Symbol symbol;
        Symbol symbol2;
        int i4;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f22121g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i5 = this.f22122a;
            if (andIncrement < i5) {
                if (andIncrement >= 0) {
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22117c;
                cg2 cg2Var = (cg2) atomicReferenceFieldUpdater.get(this);
                long andIncrement2 = f22118d.getAndIncrement(this);
                i2 = SemaphoreKt.f22129f;
                long j = andIncrement2 / i2;
                ag2 ag2Var = ag2.f182h;
                while (true) {
                    findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(cg2Var, j, ag2Var);
                    if (SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
                        break;
                    }
                    Segment m8904getSegmentimpl = SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
                    while (true) {
                        Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                        if (segment.id >= m8904getSegmentimpl.id) {
                            break;
                        }
                        if (!m8904getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                            break;
                        }
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, m8904getSegmentimpl)) {
                            if (atomicReferenceFieldUpdater.get(this) != segment) {
                                if (m8904getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                    m8904getSegmentimpl.remove();
                                }
                            }
                        }
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    }
                }
                cg2 cg2Var2 = (cg2) SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
                cg2Var2.cleanPrev();
                z = false;
                if (cg2Var2.id <= j) {
                    i3 = SemaphoreKt.f22129f;
                    int i6 = (int) (andIncrement2 % i3);
                    symbol = SemaphoreKt.f22125b;
                    AtomicReferenceArray atomicReferenceArray = cg2Var2.f8361d;
                    Object andSet = atomicReferenceArray.getAndSet(i6, symbol);
                    if (andSet == null) {
                        i4 = SemaphoreKt.f22124a;
                        for (int i7 = 0; i7 < i4; i7++) {
                            Object obj = atomicReferenceArray.get(i6);
                            symbol5 = SemaphoreKt.f22126c;
                            if (obj == symbol5) {
                                z = true;
                                break;
                            }
                        }
                        symbol3 = SemaphoreKt.f22125b;
                        symbol4 = SemaphoreKt.f22127d;
                        while (true) {
                            if (atomicReferenceArray.compareAndSet(i6, symbol3, symbol4)) {
                                z = true;
                                break;
                            } else if (atomicReferenceArray.get(i6) != symbol3) {
                                break;
                            }
                        }
                        z = !z;
                    } else {
                        symbol2 = SemaphoreKt.f22128e;
                        if (andSet != symbol2) {
                            if (andSet instanceof CancellableContinuation) {
                                Intrinsics.checkNotNull(andSet, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                                CancellableContinuation cancellableContinuation = (CancellableContinuation) andSet;
                                Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.f22123b);
                                if (tryResume != null) {
                                    cancellableContinuation.completeResume(tryResume);
                                    z = true;
                                    break;
                                    break;
                                }
                            } else if (andSet instanceof SelectInstance) {
                                z = ((SelectInstance) andSet).trySelect(this, Unit.INSTANCE);
                            } else {
                                throw new IllegalStateException(("unexpected: " + andSet).toString());
                            }
                        }
                    }
                }
            } else {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= i5) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i5));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i5).toString());
            }
        } while (!z);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f22121g;
            int i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = this.f22122a;
            if (i2 > i3) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i > i3) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i3));
            } else {
                if (i2 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i2, i2 - 1)) {
                    return true;
                }
            }
        }
    }

    public final void acquire(@NotNull CancellableContinuation<? super Unit> waiter) {
        while (true) {
            int andDecrement = f22121g.getAndDecrement(this);
            if (andDecrement <= this.f22122a) {
                if (andDecrement > 0) {
                    waiter.resume(Unit.INSTANCE, this.f22123b);
                    return;
                } else {
                    Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
                    if (m5752b((Waiter) waiter)) {
                        return;
                    }
                }
            }
        }
    }
}
