package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import p000.b51;
import p000.ot2;
import p000.pt2;
import p000.qt2;
import p000.r82;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a;\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/channels/TickerMode;", "mode", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "ticker", "(JJLkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/TickerMode;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nTickerChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TickerChannels.kt\nkotlinx/coroutines/channels/TickerChannelsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
/* loaded from: classes2.dex */
public final class TickerChannelsKt {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0076, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r6, r0) != r1) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r8, r0) == r1) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0076 -> B:12:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object access$fixedDelayTicker(long j, long j2, SendChannel sendChannel, Continuation continuation) {
        ot2 ot2Var;
        Object coroutine_suspended;
        int i;
        SendChannel sendChannel2;
        SendChannel sendChannel3;
        Unit unit;
        if (continuation instanceof ot2) {
            ot2 ot2Var2 = (ot2) continuation;
            int i2 = ot2Var2.f24908g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ot2Var2.f24908g = i2 - Integer.MIN_VALUE;
                ot2Var = ot2Var2;
                Object obj = ot2Var.f24907f;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = ot2Var.f24908g;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                j = ot2Var.f24905d;
                                sendChannel2 = ot2Var.f24906e;
                                ResultKt.throwOnFailure(obj);
                                sendChannel3 = sendChannel2;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            j = ot2Var.f24905d;
                            sendChannel2 = ot2Var.f24906e;
                            ResultKt.throwOnFailure(obj);
                            ot2Var.f24906e = sendChannel2;
                            ot2Var.f24905d = j;
                            ot2Var.f24908g = 3;
                        }
                    } else {
                        j = ot2Var.f24905d;
                        SendChannel sendChannel4 = ot2Var.f24906e;
                        ResultKt.throwOnFailure(obj);
                        sendChannel3 = sendChannel4;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ot2Var.f24906e = sendChannel;
                    ot2Var.f24905d = j;
                    ot2Var.f24908g = 1;
                    sendChannel3 = sendChannel;
                }
                unit = Unit.INSTANCE;
                ot2Var.f24906e = sendChannel3;
                ot2Var.f24905d = j;
                ot2Var.f24908g = 2;
                if (sendChannel3.send(unit, ot2Var) != coroutine_suspended) {
                    sendChannel2 = sendChannel3;
                    ot2Var.f24906e = sendChannel2;
                    ot2Var.f24905d = j;
                    ot2Var.f24908g = 3;
                }
                return coroutine_suspended;
            }
        }
        ot2Var = new ContinuationImpl(continuation);
        Object obj2 = ot2Var.f24907f;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = ot2Var.f24908g;
        if (i == 0) {
        }
        unit = Unit.INSTANCE;
        ot2Var.f24906e = sendChannel3;
        ot2Var.f24905d = j;
        ot2Var.f24908g = 2;
        if (sendChannel3.send(unit, ot2Var) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00f2, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) == r2) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x010b, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) != r2) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00f5 -> B:15:0x00a3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x010b -> B:13:0x003b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object access$fixedPeriodTicker(long j, long j2, SendChannel sendChannel, Continuation continuation) {
        pt2 pt2Var;
        Object coroutine_suspended;
        int i;
        long nanoTime;
        long j3;
        long j4;
        SendChannel sendChannel2;
        long delayToNanos;
        long j5;
        long j6;
        SendChannel sendChannel3;
        char c;
        SendChannel sendChannel4;
        long j7;
        AbstractTimeSource timeSource;
        long nanoTime2;
        long coerceAtLeast;
        char c2;
        char c3;
        Unit unit;
        if (continuation instanceof pt2) {
            pt2 pt2Var2 = (pt2) continuation;
            int i2 = pt2Var2.f25297h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pt2Var2.f25297h = i2 - Integer.MIN_VALUE;
                pt2Var = pt2Var2;
                Object obj = pt2Var.f25296g;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = pt2Var.f25297h;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    j6 = pt2Var.f25294e;
                                    j7 = pt2Var.f25293d;
                                    sendChannel3 = pt2Var.f25295f;
                                    ResultKt.throwOnFailure(obj);
                                    c3 = 4;
                                    c2 = 3;
                                    long j8 = j6;
                                    j4 = j7;
                                    delayToNanos = j8;
                                    sendChannel4 = sendChannel3;
                                    long j9 = j4 + delayToNanos;
                                    unit = Unit.INSTANCE;
                                    pt2Var.f25295f = sendChannel4;
                                    pt2Var.f25293d = j9;
                                    pt2Var.f25294e = delayToNanos;
                                    pt2Var.f25297h = 2;
                                    if (sendChannel4.send(unit, pt2Var) != coroutine_suspended) {
                                        sendChannel3 = sendChannel4;
                                        j6 = delayToNanos;
                                        j7 = j9;
                                        timeSource = AbstractTimeSourceKt.getTimeSource();
                                        if (timeSource == null) {
                                            nanoTime2 = timeSource.nanoTime();
                                        } else {
                                            nanoTime2 = System.nanoTime();
                                        }
                                        coerceAtLeast = r82.coerceAtLeast(j7 - nanoTime2, 0L);
                                        if (coerceAtLeast != 0 && j6 != 0) {
                                            long j10 = j6 - ((nanoTime2 - j7) % j6);
                                            j5 = nanoTime2 + j10;
                                            long delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(j10);
                                            pt2Var.f25295f = sendChannel3;
                                            pt2Var.f25293d = j5;
                                            pt2Var.f25294e = j6;
                                            c = 3;
                                            pt2Var.f25297h = 3;
                                        } else {
                                            c2 = 3;
                                            long delayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                                            pt2Var.f25295f = sendChannel3;
                                            pt2Var.f25293d = j7;
                                            pt2Var.f25294e = j6;
                                            c3 = 4;
                                            pt2Var.f25297h = 4;
                                        }
                                    }
                                    return coroutine_suspended;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            j6 = pt2Var.f25294e;
                            j5 = pt2Var.f25293d;
                            sendChannel3 = pt2Var.f25295f;
                            ResultKt.throwOnFailure(obj);
                            c = 3;
                            long j11 = j6;
                            j4 = j5;
                            delayToNanos = j11;
                            sendChannel4 = sendChannel3;
                            long j92 = j4 + delayToNanos;
                            unit = Unit.INSTANCE;
                            pt2Var.f25295f = sendChannel4;
                            pt2Var.f25293d = j92;
                            pt2Var.f25294e = delayToNanos;
                            pt2Var.f25297h = 2;
                            if (sendChannel4.send(unit, pt2Var) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        j6 = pt2Var.f25294e;
                        j7 = pt2Var.f25293d;
                        sendChannel3 = pt2Var.f25295f;
                        ResultKt.throwOnFailure(obj);
                        timeSource = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource == null) {
                        }
                        coerceAtLeast = r82.coerceAtLeast(j7 - nanoTime2, 0L);
                        if (coerceAtLeast != 0) {
                        }
                        c2 = 3;
                        long delayNanosToMillis22 = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                        pt2Var.f25295f = sendChannel3;
                        pt2Var.f25293d = j7;
                        pt2Var.f25294e = j6;
                        c3 = 4;
                        pt2Var.f25297h = 4;
                    } else {
                        j4 = pt2Var.f25294e;
                        long j12 = pt2Var.f25293d;
                        SendChannel sendChannel5 = pt2Var.f25295f;
                        ResultKt.throwOnFailure(obj);
                        sendChannel2 = sendChannel5;
                        j3 = j12;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource2 != null) {
                        nanoTime = timeSource2.nanoTime();
                    } else {
                        nanoTime = System.nanoTime();
                    }
                    long delayToNanos2 = nanoTime + EventLoop_commonKt.delayToNanos(j2);
                    SendChannel sendChannel6 = sendChannel;
                    pt2Var.f25295f = sendChannel6;
                    j3 = j;
                    pt2Var.f25293d = j3;
                    pt2Var.f25294e = delayToNanos2;
                    pt2Var.f25297h = 1;
                    if (DelayKt.delay(j2, pt2Var) != coroutine_suspended) {
                        j4 = delayToNanos2;
                        sendChannel2 = sendChannel6;
                    }
                    return coroutine_suspended;
                }
                delayToNanos = EventLoop_commonKt.delayToNanos(j3);
                sendChannel4 = sendChannel2;
                long j922 = j4 + delayToNanos;
                unit = Unit.INSTANCE;
                pt2Var.f25295f = sendChannel4;
                pt2Var.f25293d = j922;
                pt2Var.f25294e = delayToNanos;
                pt2Var.f25297h = 2;
                if (sendChannel4.send(unit, pt2Var) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        pt2Var = new ContinuationImpl(continuation);
        Object obj2 = pt2Var.f25296g;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = pt2Var.f25297h;
        if (i == 0) {
        }
        delayToNanos = EventLoop_commonKt.delayToNanos(j3);
        sendChannel4 = sendChannel2;
        long j9222 = j4 + delayToNanos;
        unit = Unit.INSTANCE;
        pt2Var.f25295f = sendChannel4;
        pt2Var.f25293d = j9222;
        pt2Var.f25294e = delayToNanos;
        pt2Var.f25297h = 2;
        if (sendChannel4.send(unit, pt2Var) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    @ObsoleteCoroutinesApi
    @NotNull
    public static final ReceiveChannel<Unit> ticker(long j, long j2, @NotNull CoroutineContext coroutineContext, @NotNull TickerMode tickerMode) {
        if (j >= 0) {
            if (j2 >= 0) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new qt2(tickerMode, j, j2, null));
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }
}
