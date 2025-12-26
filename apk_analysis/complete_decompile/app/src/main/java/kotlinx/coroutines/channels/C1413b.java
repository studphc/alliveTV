package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import p000.b51;

/* renamed from: kotlinx.coroutines.channels.b */
/* loaded from: classes2.dex */
public final class C1413b implements ChannelIterator, Waiter {

    /* renamed from: a */
    public Object f21491a;

    /* renamed from: b */
    public CancellableContinuationImpl f21492b;

    /* renamed from: c */
    public final /* synthetic */ BufferedChannel f21493c;

    public C1413b(BufferedChannel bufferedChannel) {
        Symbol symbol;
        this.f21493c = bufferedChannel;
        symbol = BufferedChannelKt.f21476n;
        this.f21491a = symbol;
    }

    /* renamed from: a */
    public static final void m5702a(C1413b c1413b) {
        CancellableContinuationImpl cancellableContinuationImpl = c1413b.f21492b;
        Intrinsics.checkNotNull(cancellableContinuationImpl);
        c1413b.f21492b = null;
        c1413b.f21491a = BufferedChannelKt.getCHANNEL_CLOSED();
        Throwable closeCause = c1413b.f21493c.getCloseCause();
        if (closeCause == null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(Boolean.FALSE));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(closeCause)));
        }
    }

    @Override // kotlinx.coroutines.channels.ChannelIterator
    public final Object hasNext(Continuation continuation) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Boolean boxBoolean;
        Symbol symbol6;
        Symbol symbol7;
        Symbol symbol8;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BufferedChannel.f21457h;
        BufferedChannel bufferedChannel = this.f21493c;
        ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = BufferedChannel.f21453d.getAndIncrement(bufferedChannel);
            long j = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / j;
            int i = (int) (andIncrement % j);
            if (channelSegment.id != j2) {
                ChannelSegment m5686d = bufferedChannel.m5686d(j2, channelSegment);
                if (m5686d == null) {
                    continue;
                } else {
                    channelSegment = m5686d;
                }
            }
            Object m5699s = bufferedChannel.m5699s(channelSegment, i, null, andIncrement);
            symbol = BufferedChannelKt.f21473k;
            if (m5699s != symbol) {
                symbol2 = BufferedChannelKt.f21475m;
                if (m5699s != symbol2) {
                    symbol3 = BufferedChannelKt.f21474l;
                    if (m5699s == symbol3) {
                        BufferedChannel bufferedChannel2 = this.f21493c;
                        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
                        try {
                            this.f21492b = orCreateCancellableContinuation;
                            Object m5699s2 = bufferedChannel2.m5699s(channelSegment, i, this, andIncrement);
                            symbol4 = BufferedChannelKt.f21473k;
                            if (m5699s2 != symbol4) {
                                symbol5 = BufferedChannelKt.f21475m;
                                Function1<Throwable, Unit> function1 = null;
                                if (m5699s2 == symbol5) {
                                    if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegment.cleanPrev();
                                    }
                                    ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.f21457h.get(bufferedChannel2);
                                    while (true) {
                                        if (bufferedChannel2.isClosedForReceive()) {
                                            m5702a(this);
                                            break;
                                        }
                                        long andIncrement2 = BufferedChannel.f21453d.getAndIncrement(bufferedChannel2);
                                        long j3 = BufferedChannelKt.SEGMENT_SIZE;
                                        long j4 = andIncrement2 / j3;
                                        int i2 = (int) (andIncrement2 % j3);
                                        if (channelSegment2.id != j4) {
                                            ChannelSegment m5686d2 = bufferedChannel2.m5686d(j4, channelSegment2);
                                            if (m5686d2 != null) {
                                                channelSegment2 = m5686d2;
                                            }
                                        }
                                        Object m5699s3 = bufferedChannel2.m5699s(channelSegment2, i2, this, andIncrement2);
                                        symbol6 = BufferedChannelKt.f21473k;
                                        if (m5699s3 != symbol6) {
                                            symbol7 = BufferedChannelKt.f21475m;
                                            if (m5699s3 != symbol7) {
                                                symbol8 = BufferedChannelKt.f21474l;
                                                if (m5699s3 != symbol8) {
                                                    channelSegment2.cleanPrev();
                                                    this.f21491a = m5699s3;
                                                    this.f21492b = null;
                                                    boxBoolean = Boxing.boxBoolean(true);
                                                    Function1<E, Unit> function12 = bufferedChannel2.onUndeliveredElement;
                                                    if (function12 != 0) {
                                                        function1 = OnUndeliveredElementKt.bindCancellationFun(function12, m5699s3, orCreateCancellableContinuation.getContext());
                                                    }
                                                } else {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                            } else if (andIncrement2 < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                                                channelSegment2.cleanPrev();
                                            }
                                        } else {
                                            BufferedChannel.access$prepareReceiverForSuspension(bufferedChannel2, this, channelSegment2, i2);
                                            break;
                                        }
                                    }
                                } else {
                                    channelSegment.cleanPrev();
                                    this.f21491a = m5699s2;
                                    this.f21492b = null;
                                    boxBoolean = Boxing.boxBoolean(true);
                                    Function1<E, Unit> function13 = bufferedChannel2.onUndeliveredElement;
                                    if (function13 != 0) {
                                        function1 = OnUndeliveredElementKt.bindCancellationFun(function13, m5699s2, orCreateCancellableContinuation.getContext());
                                    }
                                }
                                orCreateCancellableContinuation.resume(boxBoolean, function1);
                            } else {
                                BufferedChannel.access$prepareReceiverForSuspension(bufferedChannel2, this, channelSegment, i);
                            }
                            Object result = orCreateCancellableContinuation.getResult();
                            if (result == b51.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(continuation);
                            }
                            return result;
                        } catch (Throwable th) {
                            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                            throw th;
                        }
                    }
                    channelSegment.cleanPrev();
                    this.f21491a = m5699s;
                    return Boxing.boxBoolean(true);
                }
                if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else {
                throw new IllegalStateException("unreachable");
            }
        }
        this.f21491a = BufferedChannelKt.getCHANNEL_CLOSED();
        Throwable closeCause = bufferedChannel.getCloseCause();
        if (closeCause == null) {
            return Boxing.boxBoolean(false);
        }
        throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment segment, int i) {
        CancellableContinuationImpl cancellableContinuationImpl = this.f21492b;
        if (cancellableContinuationImpl != null) {
            cancellableContinuationImpl.invokeOnCancellation(segment, i);
        }
    }

    @Override // kotlinx.coroutines.channels.ChannelIterator
    public final /* synthetic */ Object next(Continuation continuation) {
        return ChannelIterator.DefaultImpls.next(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ChannelIterator
    public final Object next() {
        Symbol symbol;
        Symbol symbol2;
        Throwable m5687e;
        Object obj = this.f21491a;
        symbol = BufferedChannelKt.f21476n;
        if (obj != symbol) {
            symbol2 = BufferedChannelKt.f21476n;
            this.f21491a = symbol2;
            if (obj != BufferedChannelKt.getCHANNEL_CLOSED()) {
                return obj;
            }
            m5687e = this.f21493c.m5687e();
            throw StackTraceRecoveryKt.recoverStackTrace(m5687e);
        }
        throw new IllegalStateException("`hasNext()` has not been invoked");
    }
}
