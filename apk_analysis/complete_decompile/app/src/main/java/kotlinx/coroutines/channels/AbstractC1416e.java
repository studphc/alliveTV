package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.channels.ReceiveChannel;
import p000.C1396km;
import p000.C1516lm;
import p000.b51;

/* renamed from: kotlinx.coroutines.channels.e */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1416e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067 A[Catch: all -> 0x0071, TRY_LEAVE, TryCatch #1 {all -> 0x0071, blocks: (B:15:0x005f, B:17:0x0067), top: B:14:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:13:0x0032). Please report as a decompilation issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m5703a(BroadcastChannel broadcastChannel, Function1 function1, Continuation continuation) {
        C1516lm c1516lm;
        int i;
        ReceiveChannel receiveChannel;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator it;
        C1516lm c1516lm2;
        Object hasNext;
        if (continuation instanceof C1516lm) {
            C1516lm c1516lm3 = (C1516lm) continuation;
            int i2 = c1516lm3.f22561h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1516lm3.f22561h = i2 - Integer.MIN_VALUE;
                c1516lm = c1516lm3;
                Object obj = c1516lm.f22560g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1516lm.f22561h;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator channelIterator = c1516lm.f22559f;
                        receiveChannel = c1516lm.f22558e;
                        Function1 function12 = c1516lm.f22557d;
                        try {
                            ResultKt.throwOnFailure(obj);
                            C1516lm c1516lm4 = c1516lm;
                            ReceiveChannel receiveChannel3 = receiveChannel;
                            function1 = function12;
                            ChannelIterator channelIterator2 = channelIterator;
                            C1516lm c1516lm5 = c1516lm4;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    try {
                                        function1.invoke(channelIterator2.next());
                                        c1516lm2.f22557d = function1;
                                        c1516lm2.f22558e = receiveChannel2;
                                        c1516lm2.f22559f = it;
                                        c1516lm2.f22561h = 1;
                                        hasNext = it.hasNext(c1516lm2);
                                        if (hasNext != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        c1516lm4 = c1516lm2;
                                        receiveChannel3 = receiveChannel2;
                                        obj = hasNext;
                                        channelIterator2 = it;
                                        C1516lm c1516lm52 = c1516lm4;
                                        if (!((Boolean) obj).booleanValue()) {
                                            InlineMarker.finallyStart(1);
                                            ReceiveChannel.DefaultImpls.cancel$default(receiveChannel3, (CancellationException) null, 1, (Object) null);
                                            InlineMarker.finallyEnd(1);
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        receiveChannel = receiveChannel2;
                                    }
                                    receiveChannel2 = receiveChannel3;
                                    c1516lm2 = c1516lm52;
                                    it = channelIterator2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                receiveChannel = receiveChannel3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ReceiveChannel openSubscription = broadcastChannel.openSubscription();
                    try {
                        receiveChannel2 = openSubscription;
                        it = openSubscription.iterator();
                        c1516lm2 = c1516lm;
                        c1516lm2.f22557d = function1;
                        c1516lm2.f22558e = receiveChannel2;
                        c1516lm2.f22559f = it;
                        c1516lm2.f22561h = 1;
                        hasNext = it.hasNext(c1516lm2);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th5) {
                        receiveChannel = openSubscription;
                        th = th5;
                    }
                }
                InlineMarker.finallyStart(1);
                ReceiveChannel.DefaultImpls.cancel$default(receiveChannel, (CancellationException) null, 1, (Object) null);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        c1516lm = new ContinuationImpl(continuation);
        Object obj2 = c1516lm.f22560g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1516lm.f22561h;
        if (i == 0) {
        }
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.cancel$default(receiveChannel, (CancellationException) null, 1, (Object) null);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #2 {all -> 0x002f, blocks: (B:11:0x002b, B:12:0x0056, B:14:0x005e, B:16:0x0044), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0053 -> B:12:0x0056). Please report as a decompilation issue!!! */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m5704b(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        C1396km c1396km;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Function1 function12;
        Object hasNext;
        if (continuation instanceof C1396km) {
            C1396km c1396km2 = (C1396km) continuation;
            int i2 = c1396km2.f20895h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1396km2.f20895h = i2 - Integer.MIN_VALUE;
                c1396km = c1396km2;
                Object obj = c1396km.f20894g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1396km.f20895h;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator channelIterator = c1396km.f20893f;
                        receiveChannel2 = c1396km.f20892e;
                        Function1 function13 = c1396km.f20891d;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ChannelIterator channelIterator2 = channelIterator;
                            if (!((Boolean) obj).booleanValue()) {
                                function13.invoke(channelIterator2.next());
                                function12 = function13;
                                it = channelIterator2;
                                c1396km.f20891d = function12;
                                c1396km.f20892e = receiveChannel2;
                                c1396km.f20893f = it;
                                c1396km.f20895h = 1;
                                hasNext = it.hasNext(c1396km);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function13 = function12;
                                obj = hasNext;
                                channelIterator2 = it;
                                if (!((Boolean) obj).booleanValue()) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                                    InlineMarker.finallyEnd(1);
                                    return Unit.INSTANCE;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                InlineMarker.finallyEnd(1);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        c1396km.f20891d = function12;
                        c1396km.f20892e = receiveChannel2;
                        c1396km.f20893f = it;
                        c1396km.f20895h = 1;
                        hasNext = it.hasNext(c1396km);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        c1396km = new ContinuationImpl(continuation);
        Object obj2 = c1396km.f20894g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1396km.f20895h;
        if (i == 0) {
        }
    }
}
