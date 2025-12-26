package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1167eq;
import p000.C0024an;
import p000.C0563bn;
import p000.C0599cn;
import p000.C1128dn;
import p000.C1164en;
import p000.C1201fn;
import p000.C1238gn;
import p000.C1275hn;
import p000.C1312in;
import p000.C1359jm;
import p000.C1360jn;
import p000.C1397kn;
import p000.C1517ln;
import p000.C1553mm;
import p000.C1554mn;
import p000.C1590nm;
import p000.C1642om;
import p000.C1643on;
import p000.C1693pn;
import p000.C1729qm;
import p000.C1730qn;
import p000.C1761rh;
import p000.C1766rm;
import p000.C1767rn;
import p000.C1803sm;
import p000.C1804sn;
import p000.C1840tm;
import p000.C1841tn;
import p000.C1877um;
import p000.C1878un;
import p000.C1891v;
import p000.C1914vm;
import p000.C1915vn;
import p000.C1951wm;
import p000.C1988xm;
import p000.C1989xn;
import p000.C2062zm;
import p000.b51;

@Metadata(m5568d1 = {"kotlinx/coroutines/channels/e"}, m5569d2 = {}, m5570k = 4, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ChannelsKt {

    @NotNull
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object any(ReceiveChannel receiveChannel, Continuation continuation) {
        C1590nm c1590nm;
        int i;
        try {
            if (continuation instanceof C1590nm) {
                C1590nm c1590nm2 = (C1590nm) continuation;
                int i2 = c1590nm2.f23401f;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    c1590nm2.f23401f = i2 - Integer.MIN_VALUE;
                    c1590nm = c1590nm2;
                    Object obj = c1590nm.f23400e;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = c1590nm.f23401f;
                    if (i == 0) {
                        if (i == 1) {
                            receiveChannel = c1590nm.f23399d;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ChannelIterator it = receiveChannel.iterator();
                        c1590nm.f23399d = receiveChannel;
                        c1590nm.f23401f = 1;
                        obj = it.hasNext(c1590nm);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    cancelConsumed(receiveChannel, null);
                    return obj;
                }
            }
            if (i == 0) {
            }
            cancelConsumed(receiveChannel, null);
            return obj;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cancelConsumed(receiveChannel, th);
                throw th2;
            }
        }
        c1590nm = new ContinuationImpl(continuation);
        Object obj2 = c1590nm.f23400e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1590nm.f23401f;
    }

    @PublishedApi
    public static final void cancelConsumed(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    public static final <E, R> R consume(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            return function1.invoke(openSubscription);
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @Nullable
    public static final <E> Object consumeEach(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super E, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        return AbstractC1416e.m5703a(broadcastChannel, function1, continuation);
    }

    @PublishedApi
    @NotNull
    public static final Function1<Throwable, Unit> consumes(@NotNull ReceiveChannel<?> receiveChannel) {
        return new C1761rh(receiveChannel, 1);
    }

    @PublishedApi
    @NotNull
    public static final Function1<Throwable, Unit> consumesAll(@NotNull ReceiveChannel<?>... receiveChannelArr) {
        return new C1891v(2, receiveChannelArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #3 {all -> 0x002f, blocks: (B:11:0x002b, B:12:0x005a, B:14:0x0062), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0057 -> B:12:0x005a). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object count(ReceiveChannel receiveChannel, Continuation continuation) {
        C1642om c1642om;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        ReceiveChannel receiveChannel3;
        ChannelIterator it;
        Object hasNext;
        if (continuation instanceof C1642om) {
            C1642om c1642om2 = (C1642om) continuation;
            int i2 = c1642om2.f24815h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1642om2.f24815h = i2 - Integer.MIN_VALUE;
                c1642om = c1642om2;
                Object obj = c1642om.f24814g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1642om.f24815h;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator channelIterator = c1642om.f24813f;
                        receiveChannel2 = c1642om.f24812e;
                        intRef = c1642om.f24811d;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ChannelIterator channelIterator2 = channelIterator;
                            if (!((Boolean) obj).booleanValue()) {
                                try {
                                    channelIterator2.next();
                                    intRef.element++;
                                    c1642om.f24811d = intRef;
                                    c1642om.f24812e = receiveChannel3;
                                    c1642om.f24813f = it;
                                    c1642om.f24815h = 1;
                                    hasNext = it.hasNext(c1642om);
                                    if (hasNext == coroutine_suspended) {
                                        receiveChannel2 = receiveChannel3;
                                        obj = hasNext;
                                        channelIterator2 = it;
                                        if (!((Boolean) obj).booleanValue()) {
                                            cancelConsumed(receiveChannel2, null);
                                            return Boxing.boxInt(intRef.element);
                                        }
                                    } else {
                                        return coroutine_suspended;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    receiveChannel2 = receiveChannel3;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        cancelConsumed(receiveChannel2, th);
                                        throw th3;
                                    }
                                }
                                receiveChannel3 = receiveChannel2;
                                it = channelIterator2;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        intRef = new Ref.IntRef();
                        receiveChannel3 = receiveChannel;
                        it = receiveChannel.iterator();
                        c1642om.f24811d = intRef;
                        c1642om.f24812e = receiveChannel3;
                        c1642om.f24813f = it;
                        c1642om.f24815h = 1;
                        hasNext = it.hasNext(c1642om);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                }
            }
        }
        c1642om = new ContinuationImpl(continuation);
        Object obj2 = c1642om.f24814g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1642om.f24815h;
        if (i == 0) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final ReceiveChannel distinct(ReceiveChannel receiveChannel) {
        return distinctBy$default(receiveChannel, null, new SuspendLambda(2, null), 1, null);
    }

    @PublishedApi
    @NotNull
    public static final <E, K> ReceiveChannel<E> distinctBy(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1729qm(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return distinctBy(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1766rm(receiveChannel, i, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return drop(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1803sm(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return dropWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x0031, B:13:0x0060, B:15:0x0068, B:26:0x007a, B:27:0x0091), top: B:11:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a A[Catch: all -> 0x0035, TRY_ENTER, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x0031, B:13:0x0060, B:15:0x0068, B:26:0x007a, B:27:0x0091), top: B:11:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:13:0x0060). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object elementAt(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        C1840tm c1840tm;
        int i2;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i3;
        ChannelIterator channelIterator;
        Object hasNext;
        try {
            if (continuation instanceof C1840tm) {
                C1840tm c1840tm2 = (C1840tm) continuation;
                int i4 = c1840tm2.f26873i;
                if ((i4 & Integer.MIN_VALUE) != 0) {
                    c1840tm2.f26873i = i4 - Integer.MIN_VALUE;
                    c1840tm = c1840tm2;
                    Object obj = c1840tm.f26872h;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i2 = c1840tm.f26873i;
                    if (i2 == 0) {
                        if (i2 == 1) {
                            int i5 = c1840tm.f26869e;
                            i = c1840tm.f26868d;
                            ChannelIterator channelIterator2 = c1840tm.f26871g;
                            receiveChannel2 = c1840tm.f26870f;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (!((Boolean) obj).booleanValue()) {
                                    Object next = channelIterator2.next();
                                    int i6 = i5 + 1;
                                    if (i == i5) {
                                        cancelConsumed(receiveChannel2, null);
                                        return next;
                                    }
                                    channelIterator = channelIterator2;
                                    receiveChannel = receiveChannel2;
                                    i3 = i6;
                                    c1840tm.f26870f = receiveChannel;
                                    c1840tm.f26871g = channelIterator;
                                    c1840tm.f26868d = i;
                                    c1840tm.f26869e = i3;
                                    c1840tm.f26873i = 1;
                                    hasNext = channelIterator.hasNext(c1840tm);
                                    if (hasNext == coroutine_suspended) {
                                        receiveChannel2 = receiveChannel;
                                        i5 = i3;
                                        channelIterator2 = channelIterator;
                                        obj = hasNext;
                                        if (!((Boolean) obj).booleanValue()) {
                                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                                        }
                                    } else {
                                        return coroutine_suspended;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    cancelConsumed(receiveChannel2, th);
                                    throw th3;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (i >= 0) {
                            i3 = 0;
                            channelIterator = receiveChannel.iterator();
                            c1840tm.f26870f = receiveChannel;
                            c1840tm.f26871g = channelIterator;
                            c1840tm.f26868d = i;
                            c1840tm.f26869e = i3;
                            c1840tm.f26873i = 1;
                            hasNext = channelIterator.hasNext(c1840tm);
                            if (hasNext == coroutine_suspended) {
                            }
                        } else {
                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                        }
                    }
                }
            }
            if (i2 == 0) {
            }
        } catch (Throwable th4) {
            receiveChannel2 = receiveChannel;
            th = th4;
        }
        c1840tm = new ContinuationImpl(continuation);
        Object obj2 = c1840tm.f26872h;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i2 = c1840tm.f26873i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d A[Catch: all -> 0x007e, TRY_LEAVE, TryCatch #2 {all -> 0x007e, blocks: (B:13:0x0065, B:18:0x006d, B:24:0x0050, B:45:0x004b), top: B:44:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0061 -> B:13:0x0065). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object elementAtOrNull(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        C1877um c1877um;
        int i2;
        int i3;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        C1877um c1877um2;
        Object hasNext;
        if (continuation instanceof C1877um) {
            C1877um c1877um3 = (C1877um) continuation;
            int i4 = c1877um3.f27348i;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c1877um3.f27348i = i4 - Integer.MIN_VALUE;
                c1877um = c1877um3;
                Object obj = c1877um.f27347h;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i2 = c1877um.f27348i;
                if (i2 == 0) {
                    if (i2 == 1) {
                        int i5 = c1877um.f27344e;
                        i = c1877um.f27343d;
                        ChannelIterator channelIterator2 = c1877um.f27346g;
                        receiveChannel2 = c1877um.f27345f;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i3 = i5;
                            receiveChannel = receiveChannel2;
                            C1877um c1877um4 = c1877um;
                            ChannelIterator channelIterator3 = channelIterator2;
                            if (((Boolean) obj).booleanValue()) {
                                Object next = channelIterator3.next();
                                int i6 = i3 + 1;
                                if (i == i3) {
                                    cancelConsumed(receiveChannel, null);
                                    return next;
                                }
                                channelIterator = channelIterator3;
                                c1877um2 = c1877um4;
                                i3 = i6;
                                c1877um2.f27345f = receiveChannel;
                                c1877um2.f27346g = channelIterator;
                                c1877um2.f27343d = i;
                                c1877um2.f27344e = i3;
                                c1877um2.f27348i = 1;
                                hasNext = channelIterator.hasNext(c1877um2);
                                if (hasNext == coroutine_suspended) {
                                    C1877um c1877um5 = c1877um2;
                                    channelIterator3 = channelIterator;
                                    obj = hasNext;
                                    c1877um4 = c1877um5;
                                    if (((Boolean) obj).booleanValue()) {
                                    }
                                } else {
                                    return coroutine_suspended;
                                }
                            }
                            cancelConsumed(receiveChannel, null);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (i >= 0) {
                    try {
                        i3 = 0;
                        c1877um2 = c1877um;
                        channelIterator = receiveChannel.iterator();
                        c1877um2.f27345f = receiveChannel;
                        c1877um2.f27346g = channelIterator;
                        c1877um2.f27343d = i;
                        c1877um2.f27344e = i3;
                        c1877um2.f27348i = 1;
                        hasNext = channelIterator.hasNext(c1877um2);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                cancelConsumed(receiveChannel, null);
                return null;
            }
        }
        c1877um = new ContinuationImpl(continuation);
        Object obj2 = c1877um.f27347h;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i2 = c1877um.f27348i;
        if (i2 == 0) {
        }
    }

    @PublishedApi
    @NotNull
    public static final <E> ReceiveChannel<E> filter(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1914vm(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filter(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1951wm(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return filter(receiveChannel, coroutineContext, new C1988xm(function2, null));
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterNot(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @PublishedApi
    @NotNull
    public static final <E> ReceiveChannel<E> filterNotNull(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        ReceiveChannel<E> filter$default = filter$default(receiveChannel, null, new SuspendLambda(2, null), 1, null);
        Intrinsics.checkNotNull(filter$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return filter$default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[Catch: all -> 0x002f, TryCatch #2 {all -> 0x002f, blocks: (B:11:0x002b, B:12:0x0056, B:14:0x005e, B:16:0x0064, B:18:0x0044), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0053 -> B:12:0x0056). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object filterNotNullTo(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        C2062zm c2062zm;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Collection collection2;
        Object hasNext;
        if (continuation instanceof C2062zm) {
            C2062zm c2062zm2 = (C2062zm) continuation;
            int i2 = c2062zm2.f29435h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c2062zm2.f29435h = i2 - Integer.MIN_VALUE;
                c2062zm = c2062zm2;
                Object obj = c2062zm.f29434g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c2062zm.f29435h;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        collection2 = collection;
                        c2062zm.f29431d = collection2;
                        c2062zm.f29432e = receiveChannel2;
                        c2062zm.f29433f = it;
                        c2062zm.f29435h = 1;
                        hasNext = it.hasNext(c2062zm);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ChannelIterator channelIterator = c2062zm.f29433f;
                    receiveChannel2 = c2062zm.f29432e;
                    Collection collection3 = c2062zm.f29431d;
                    try {
                        ResultKt.throwOnFailure(obj);
                        ChannelIterator channelIterator2 = channelIterator;
                        if (!((Boolean) obj).booleanValue()) {
                            cancelConsumed(receiveChannel2, null);
                            return collection3;
                        }
                        Object next = channelIterator2.next();
                        if (next != null) {
                            collection3.add(next);
                        }
                        collection2 = collection3;
                        it = channelIterator2;
                        c2062zm.f29431d = collection2;
                        c2062zm.f29432e = receiveChannel2;
                        c2062zm.f29433f = it;
                        c2062zm.f29435h = 1;
                        hasNext = it.hasNext(c2062zm);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        collection3 = collection2;
                        obj = hasNext;
                        channelIterator2 = it;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            }
        }
        c2062zm = new ContinuationImpl(continuation);
        Object obj2 = c2062zm.f29434g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c2062zm.f29435h;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057 A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #2 {all -> 0x002d, blocks: (B:11:0x0029, B:12:0x004f, B:14:0x0057, B:18:0x0060, B:19:0x0067), top: B:10:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x002d, TRY_ENTER, TryCatch #2 {all -> 0x002d, blocks: (B:11:0x0029, B:12:0x004f, B:14:0x0057, B:18:0x0060, B:19:0x0067), top: B:10:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object first(ReceiveChannel receiveChannel, Continuation continuation) {
        C0563bn c0563bn;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof C0563bn) {
            C0563bn c0563bn2 = (C0563bn) continuation;
            int i2 = c0563bn2.f8099g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c0563bn2.f8099g = i2 - Integer.MIN_VALUE;
                c0563bn = c0563bn2;
                obj = c0563bn.f8098f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c0563bn.f8099g;
                if (i == 0) {
                    if (i == 1) {
                        channelIterator = c0563bn.f8097e;
                        receiveChannel2 = c0563bn.f8096d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        c0563bn.f8096d = receiveChannel;
                        c0563bn.f8097e = it;
                        c0563bn.f8099g = 1;
                        Object hasNext = it.hasNext(c0563bn);
                        if (hasNext != coroutine_suspended) {
                            receiveChannel2 = receiveChannel;
                            channelIterator = it;
                            obj = hasNext;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    coroutine_suspended = channelIterator.next();
                    cancelConsumed(receiveChannel2, null);
                    return coroutine_suspended;
                }
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
        }
        c0563bn = new ContinuationImpl(continuation);
        obj = c0563bn.f8098f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c0563bn.f8099g;
        if (i == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c A[Catch: all -> 0x002d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x002d, blocks: (B:11:0x0029, B:12:0x004f, B:18:0x005c), top: B:10:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object firstOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        C0599cn c0599cn;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof C0599cn) {
            C0599cn c0599cn2 = (C0599cn) continuation;
            int i2 = c0599cn2.f8422g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c0599cn2.f8422g = i2 - Integer.MIN_VALUE;
                c0599cn = c0599cn2;
                obj = c0599cn.f8421f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c0599cn.f8422g;
                if (i == 0) {
                    if (i == 1) {
                        channelIterator = c0599cn.f8420e;
                        receiveChannel2 = c0599cn.f8419d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        c0599cn.f8419d = receiveChannel;
                        c0599cn.f8420e = it;
                        c0599cn.f8422g = 1;
                        Object hasNext = it.hasNext(c0599cn);
                        if (hasNext != coroutine_suspended) {
                            receiveChannel2 = receiveChannel;
                            channelIterator = it;
                            obj = hasNext;
                        } else {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    cancelConsumed(receiveChannel2, null);
                    return null;
                }
                Object next = channelIterator.next();
                cancelConsumed(receiveChannel2, null);
                return next;
            }
        }
        c0599cn = new ContinuationImpl(continuation);
        obj = c0599cn.f8421f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c0599cn.f8422g;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1128dn(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return flatMap(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x0061, B:14:0x006a, B:16:0x0074, B:21:0x007e, B:23:0x004d), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:12:0x0061). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object indexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        C1164en c1164en;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Ref.IntRef intRef;
        Object obj2;
        Object hasNext;
        if (continuation instanceof C1164en) {
            C1164en c1164en2 = (C1164en) continuation;
            int i2 = c1164en2.f16913i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1164en2.f16913i = i2 - Integer.MIN_VALUE;
                c1164en = c1164en2;
                Object obj3 = c1164en.f16912h;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1164en.f16913i;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator channelIterator = c1164en.f16911g;
                        receiveChannel2 = c1164en.f16910f;
                        intRef = c1164en.f16909e;
                        Object obj4 = c1164en.f16908d;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            ChannelIterator channelIterator2 = channelIterator;
                            if (((Boolean) obj3).booleanValue()) {
                                if (Intrinsics.areEqual(obj4, channelIterator2.next())) {
                                    Integer boxInt = Boxing.boxInt(intRef.element);
                                    cancelConsumed(receiveChannel2, null);
                                    return boxInt;
                                }
                                intRef.element++;
                                obj2 = obj4;
                                it = channelIterator2;
                                c1164en.f16908d = obj2;
                                c1164en.f16909e = intRef;
                                c1164en.f16910f = receiveChannel2;
                                c1164en.f16911g = it;
                                c1164en.f16913i = 1;
                                hasNext = it.hasNext(c1164en);
                                if (hasNext == coroutine_suspended) {
                                    obj4 = obj2;
                                    obj3 = hasNext;
                                    channelIterator2 = it;
                                    if (((Boolean) obj3).booleanValue()) {
                                    }
                                } else {
                                    return coroutine_suspended;
                                }
                            } else {
                                cancelConsumed(receiveChannel2, null);
                                return Boxing.boxInt(-1);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj3);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        intRef = intRef2;
                        obj2 = obj;
                        c1164en.f16908d = obj2;
                        c1164en.f16909e = intRef;
                        c1164en.f16910f = receiveChannel2;
                        c1164en.f16911g = it;
                        c1164en.f16913i = 1;
                        hasNext = it.hasNext(c1164en);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        c1164en = new ContinuationImpl(continuation);
        Object obj32 = c1164en.f16912h;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1164en.f16913i;
        if (i == 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008b A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:13:0x0083, B:15:0x008b), top: B:11:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0069 A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #2 {all -> 0x0046, blocks: (B:40:0x0042, B:41:0x0061, B:43:0x0069, B:45:0x009b, B:46:0x00a2), top: B:39:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009b A[Catch: all -> 0x0046, TRY_ENTER, TryCatch #2 {all -> 0x0046, blocks: (B:40:0x0042, B:41:0x0061, B:43:0x0069, B:45:0x009b, B:46:0x00a2), top: B:39:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007f -> B:13:0x0083). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object last(ReceiveChannel receiveChannel, Continuation continuation) {
        C1201fn c1201fn;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object next;
        ChannelIterator channelIterator2;
        Object hasNext;
        if (continuation instanceof C1201fn) {
            C1201fn c1201fn2 = (C1201fn) continuation;
            int i2 = c1201fn2.f17340h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1201fn2.f17340h = i2 - Integer.MIN_VALUE;
                c1201fn = c1201fn2;
                obj = c1201fn.f17339g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1201fn.f17340h;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj2 = c1201fn.f17338f;
                            ChannelIterator channelIterator3 = c1201fn.f17337e;
                            ReceiveChannel receiveChannel3 = c1201fn.f17336d;
                            try {
                                ResultKt.throwOnFailure(obj);
                                ChannelIterator channelIterator4 = channelIterator3;
                                if (!((Boolean) obj).booleanValue()) {
                                    next = channelIterator4.next();
                                    receiveChannel = receiveChannel3;
                                    channelIterator2 = channelIterator4;
                                    c1201fn.f17336d = receiveChannel;
                                    c1201fn.f17337e = channelIterator2;
                                    c1201fn.f17338f = next;
                                    c1201fn.f17340h = 2;
                                    hasNext = channelIterator2.hasNext(c1201fn);
                                    if (hasNext == coroutine_suspended) {
                                        receiveChannel3 = receiveChannel;
                                        obj2 = next;
                                        obj = hasNext;
                                        channelIterator4 = channelIterator2;
                                        if (!((Boolean) obj).booleanValue()) {
                                            cancelConsumed(receiveChannel3, null);
                                            return obj2;
                                        }
                                    } else {
                                        return coroutine_suspended;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    cancelConsumed(receiveChannel2, th);
                                    throw th2;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        channelIterator = c1201fn.f17337e;
                        receiveChannel2 = c1201fn.f17336d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        c1201fn.f17336d = receiveChannel;
                        c1201fn.f17337e = it;
                        c1201fn.f17340h = 1;
                        Object hasNext2 = it.hasNext(c1201fn);
                        if (hasNext2 != coroutine_suspended) {
                            receiveChannel2 = receiveChannel;
                            channelIterator = it;
                            obj = hasNext2;
                        } else {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    next = channelIterator.next();
                    ReceiveChannel receiveChannel4 = receiveChannel2;
                    channelIterator2 = channelIterator;
                    receiveChannel = receiveChannel4;
                    c1201fn.f17336d = receiveChannel;
                    c1201fn.f17337e = channelIterator2;
                    c1201fn.f17338f = next;
                    c1201fn.f17340h = 2;
                    hasNext = channelIterator2.hasNext(c1201fn);
                    if (hasNext == coroutine_suspended) {
                    }
                } else {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
            }
        }
        c1201fn = new ContinuationImpl(continuation);
        obj = c1201fn.f17339g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1201fn.f17340h;
        if (i == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0075 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:11:0x002f, B:12:0x006d, B:14:0x0075, B:16:0x007f, B:17:0x0083, B:19:0x0057), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006a -> B:12:0x006d). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object lastIndexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        C1238gn c1238gn;
        int i;
        Ref.IntRef intRef;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Ref.IntRef intRef2;
        Object obj2;
        Object hasNext;
        if (continuation instanceof C1238gn) {
            C1238gn c1238gn2 = (C1238gn) continuation;
            int i2 = c1238gn2.f17772j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1238gn2.f17772j = i2 - Integer.MIN_VALUE;
                c1238gn = c1238gn2;
                Object obj3 = c1238gn.f17771i;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1238gn.f17772j;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator channelIterator = c1238gn.f17770h;
                        receiveChannel2 = c1238gn.f17769g;
                        intRef = c1238gn.f17768f;
                        intRef2 = c1238gn.f17767e;
                        Object obj4 = c1238gn.f17766d;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            ChannelIterator channelIterator2 = channelIterator;
                            if (((Boolean) obj3).booleanValue()) {
                                if (Intrinsics.areEqual(obj4, channelIterator2.next())) {
                                    intRef2.element = intRef.element;
                                }
                                intRef.element++;
                                obj2 = obj4;
                                it = channelIterator2;
                                c1238gn.f17766d = obj2;
                                c1238gn.f17767e = intRef2;
                                c1238gn.f17768f = intRef;
                                c1238gn.f17769g = receiveChannel2;
                                c1238gn.f17770h = it;
                                c1238gn.f17772j = 1;
                                hasNext = it.hasNext(c1238gn);
                                if (hasNext == coroutine_suspended) {
                                    obj4 = obj2;
                                    obj3 = hasNext;
                                    channelIterator2 = it;
                                    if (((Boolean) obj3).booleanValue()) {
                                    }
                                } else {
                                    return coroutine_suspended;
                                }
                            } else {
                                cancelConsumed(receiveChannel2, null);
                                return Boxing.boxInt(intRef2.element);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj3);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = -1;
                    intRef = new Ref.IntRef();
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        intRef2 = intRef3;
                        obj2 = obj;
                        c1238gn.f17766d = obj2;
                        c1238gn.f17767e = intRef2;
                        c1238gn.f17768f = intRef;
                        c1238gn.f17769g = receiveChannel2;
                        c1238gn.f17770h = it;
                        c1238gn.f17772j = 1;
                        hasNext = it.hasNext(c1238gn);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        c1238gn = new ContinuationImpl(continuation);
        Object obj32 = c1238gn.f17771i;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1238gn.f17772j;
        if (i == 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0092 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #1 {all -> 0x0034, blocks: (B:12:0x002f, B:13:0x008a, B:15:0x0092), top: B:11:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0070 A[Catch: all -> 0x0048, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0048, blocks: (B:40:0x0044, B:41:0x0063, B:45:0x0070), top: B:39:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0086 -> B:13:0x008a). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object lastOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        C1275hn c1275hn;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object next;
        ChannelIterator channelIterator2;
        Object hasNext;
        if (continuation instanceof C1275hn) {
            C1275hn c1275hn2 = (C1275hn) continuation;
            int i2 = c1275hn2.f18103h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1275hn2.f18103h = i2 - Integer.MIN_VALUE;
                c1275hn = c1275hn2;
                obj = c1275hn.f18102g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1275hn.f18103h;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj2 = c1275hn.f18101f;
                            ChannelIterator channelIterator3 = c1275hn.f18100e;
                            ReceiveChannel receiveChannel3 = c1275hn.f18099d;
                            try {
                                ResultKt.throwOnFailure(obj);
                                ChannelIterator channelIterator4 = channelIterator3;
                                if (!((Boolean) obj).booleanValue()) {
                                    next = channelIterator4.next();
                                    receiveChannel = receiveChannel3;
                                    channelIterator2 = channelIterator4;
                                    c1275hn.f18099d = receiveChannel;
                                    c1275hn.f18100e = channelIterator2;
                                    c1275hn.f18101f = next;
                                    c1275hn.f18103h = 2;
                                    hasNext = channelIterator2.hasNext(c1275hn);
                                    if (hasNext == coroutine_suspended) {
                                        receiveChannel3 = receiveChannel;
                                        obj2 = next;
                                        obj = hasNext;
                                        channelIterator4 = channelIterator2;
                                        if (!((Boolean) obj).booleanValue()) {
                                            cancelConsumed(receiveChannel3, null);
                                            return obj2;
                                        }
                                    } else {
                                        return coroutine_suspended;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    cancelConsumed(receiveChannel2, th);
                                    throw th2;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        channelIterator = c1275hn.f18100e;
                        receiveChannel2 = c1275hn.f18099d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        c1275hn.f18099d = receiveChannel;
                        c1275hn.f18100e = it;
                        c1275hn.f18103h = 1;
                        Object hasNext2 = it.hasNext(c1275hn);
                        if (hasNext2 != coroutine_suspended) {
                            receiveChannel2 = receiveChannel;
                            channelIterator = it;
                            obj = hasNext2;
                        } else {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    cancelConsumed(receiveChannel2, null);
                    return null;
                }
                next = channelIterator.next();
                ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                c1275hn.f18099d = receiveChannel;
                c1275hn.f18100e = channelIterator2;
                c1275hn.f18101f = next;
                c1275hn.f18103h = 2;
                hasNext = channelIterator2.hasNext(c1275hn);
                if (hasNext == coroutine_suspended) {
                }
            }
        }
        c1275hn = new ContinuationImpl(continuation);
        obj = c1275hn.f18102g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1275hn.f18103h;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @PublishedApi
    @NotNull
    public static final <E, R> ReceiveChannel<R> map(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1312in(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return map(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E, R> ReceiveChannel<R> mapIndexed(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1360jn(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return filterNotNull(mapIndexed(receiveChannel, coroutineContext, function3));
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return filterNotNull(map(receiveChannel, coroutineContext, function2));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapNotNull(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a1 A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #3 {all -> 0x00af, blocks: (B:15:0x0099, B:17:0x00a1, B:20:0x0084, B:56:0x0056), top: B:55:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007c A[Catch: all -> 0x0050, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:45:0x004c, B:46:0x006f, B:50:0x007c), top: B:44:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0095 -> B:14:0x0037). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object maxWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        C1397kn c1397kn;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Comparator comparator2;
        Object next;
        Comparator comparator3;
        ChannelIterator channelIterator2;
        C1397kn c1397kn2;
        Object hasNext;
        if (continuation instanceof C1397kn) {
            C1397kn c1397kn3 = (C1397kn) continuation;
            int i2 = c1397kn3.f20910i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1397kn3.f20910i = i2 - Integer.MIN_VALUE;
                c1397kn = c1397kn3;
                obj = c1397kn.f20909h;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1397kn.f20910i;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj2 = c1397kn.f20908g;
                            ChannelIterator channelIterator3 = c1397kn.f20907f;
                            ReceiveChannel receiveChannel3 = c1397kn.f20906e;
                            comparator3 = c1397kn.f20905d;
                            try {
                                ResultKt.throwOnFailure(obj);
                                C1397kn c1397kn4 = c1397kn;
                                Object obj3 = obj2;
                                receiveChannel = receiveChannel3;
                                ChannelIterator channelIterator4 = channelIterator3;
                                C1397kn c1397kn5 = c1397kn4;
                                if (!((Boolean) obj).booleanValue()) {
                                    next = channelIterator4.next();
                                    if (comparator3.compare(obj3, next) >= 0) {
                                        next = obj3;
                                    }
                                    c1397kn2 = c1397kn5;
                                    channelIterator2 = channelIterator4;
                                    c1397kn2.f20905d = comparator3;
                                    c1397kn2.f20906e = receiveChannel;
                                    c1397kn2.f20907f = channelIterator2;
                                    c1397kn2.f20908g = next;
                                    c1397kn2.f20910i = 2;
                                    hasNext = channelIterator2.hasNext(c1397kn2);
                                    if (hasNext == coroutine_suspended) {
                                        c1397kn4 = c1397kn2;
                                        obj3 = next;
                                        obj = hasNext;
                                        channelIterator4 = channelIterator2;
                                        C1397kn c1397kn52 = c1397kn4;
                                        if (!((Boolean) obj).booleanValue()) {
                                            cancelConsumed(receiveChannel, null);
                                            return obj3;
                                        }
                                    } else {
                                        return coroutine_suspended;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    cancelConsumed(receiveChannel2, th);
                                    throw th2;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        channelIterator = c1397kn.f20907f;
                        receiveChannel2 = c1397kn.f20906e;
                        comparator2 = c1397kn.f20905d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        c1397kn.f20905d = comparator;
                        c1397kn.f20906e = receiveChannel;
                        c1397kn.f20907f = it;
                        c1397kn.f20910i = 1;
                        Object hasNext2 = it.hasNext(c1397kn);
                        if (hasNext2 != coroutine_suspended) {
                            receiveChannel2 = receiveChannel;
                            channelIterator = it;
                            obj = hasNext2;
                            comparator2 = comparator;
                        } else {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    cancelConsumed(receiveChannel2, null);
                    return null;
                }
                next = channelIterator.next();
                comparator3 = comparator2;
                ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                c1397kn2 = c1397kn;
                c1397kn2.f20905d = comparator3;
                c1397kn2.f20906e = receiveChannel;
                c1397kn2.f20907f = channelIterator2;
                c1397kn2.f20908g = next;
                c1397kn2.f20910i = 2;
                hasNext = channelIterator2.hasNext(c1397kn2);
                if (hasNext == coroutine_suspended) {
                }
            }
        }
        c1397kn = new ContinuationImpl(continuation);
        obj = c1397kn.f20909h;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1397kn.f20910i;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a1 A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #3 {all -> 0x00af, blocks: (B:15:0x0099, B:17:0x00a1, B:20:0x0084, B:56:0x0056), top: B:55:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007c A[Catch: all -> 0x0050, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:45:0x004c, B:46:0x006f, B:50:0x007c), top: B:44:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0095 -> B:14:0x0037). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object minWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        C1517ln c1517ln;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Comparator comparator2;
        Object next;
        Comparator comparator3;
        ChannelIterator channelIterator2;
        C1517ln c1517ln2;
        Object hasNext;
        if (continuation instanceof C1517ln) {
            C1517ln c1517ln3 = (C1517ln) continuation;
            int i2 = c1517ln3.f22581i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1517ln3.f22581i = i2 - Integer.MIN_VALUE;
                c1517ln = c1517ln3;
                obj = c1517ln.f22580h;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1517ln.f22581i;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj2 = c1517ln.f22579g;
                            ChannelIterator channelIterator3 = c1517ln.f22578f;
                            ReceiveChannel receiveChannel3 = c1517ln.f22577e;
                            comparator3 = c1517ln.f22576d;
                            try {
                                ResultKt.throwOnFailure(obj);
                                C1517ln c1517ln4 = c1517ln;
                                Object obj3 = obj2;
                                receiveChannel = receiveChannel3;
                                ChannelIterator channelIterator4 = channelIterator3;
                                C1517ln c1517ln5 = c1517ln4;
                                if (!((Boolean) obj).booleanValue()) {
                                    next = channelIterator4.next();
                                    if (comparator3.compare(obj3, next) <= 0) {
                                        next = obj3;
                                    }
                                    c1517ln2 = c1517ln5;
                                    channelIterator2 = channelIterator4;
                                    c1517ln2.f22576d = comparator3;
                                    c1517ln2.f22577e = receiveChannel;
                                    c1517ln2.f22578f = channelIterator2;
                                    c1517ln2.f22579g = next;
                                    c1517ln2.f22581i = 2;
                                    hasNext = channelIterator2.hasNext(c1517ln2);
                                    if (hasNext == coroutine_suspended) {
                                        c1517ln4 = c1517ln2;
                                        obj3 = next;
                                        obj = hasNext;
                                        channelIterator4 = channelIterator2;
                                        C1517ln c1517ln52 = c1517ln4;
                                        if (!((Boolean) obj).booleanValue()) {
                                            cancelConsumed(receiveChannel, null);
                                            return obj3;
                                        }
                                    } else {
                                        return coroutine_suspended;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    cancelConsumed(receiveChannel2, th);
                                    throw th2;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        channelIterator = c1517ln.f22578f;
                        receiveChannel2 = c1517ln.f22577e;
                        comparator2 = c1517ln.f22576d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        c1517ln.f22576d = comparator;
                        c1517ln.f22577e = receiveChannel;
                        c1517ln.f22578f = it;
                        c1517ln.f22581i = 1;
                        Object hasNext2 = it.hasNext(c1517ln);
                        if (hasNext2 != coroutine_suspended) {
                            receiveChannel2 = receiveChannel;
                            channelIterator = it;
                            obj = hasNext2;
                            comparator2 = comparator;
                        } else {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    cancelConsumed(receiveChannel2, null);
                    return null;
                }
                next = channelIterator.next();
                comparator3 = comparator2;
                ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                c1517ln2 = c1517ln;
                c1517ln2.f22576d = comparator3;
                c1517ln2.f22577e = receiveChannel;
                c1517ln2.f22578f = channelIterator2;
                c1517ln2.f22579g = next;
                c1517ln2.f22581i = 2;
                hasNext = channelIterator2.hasNext(c1517ln2);
                if (hasNext == coroutine_suspended) {
                }
            }
        }
        c1517ln = new ContinuationImpl(continuation);
        obj = c1517ln.f22580h;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1517ln.f22581i;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object none(ReceiveChannel receiveChannel, Continuation continuation) {
        C1554mn c1554mn;
        int i;
        try {
            if (continuation instanceof C1554mn) {
                C1554mn c1554mn2 = (C1554mn) continuation;
                int i2 = c1554mn2.f22991f;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    c1554mn2.f22991f = i2 - Integer.MIN_VALUE;
                    c1554mn = c1554mn2;
                    Object obj = c1554mn.f22990e;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = c1554mn.f22991f;
                    if (i == 0) {
                        if (i == 1) {
                            receiveChannel = c1554mn.f22989d;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ChannelIterator it = receiveChannel.iterator();
                        c1554mn.f22989d = receiveChannel;
                        c1554mn.f22991f = 1;
                        obj = it.hasNext(c1554mn);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    coroutine_suspended = Boxing.boxBoolean(!((Boolean) obj).booleanValue());
                    cancelConsumed(receiveChannel, null);
                    return coroutine_suspended;
                }
            }
            if (i == 0) {
            }
            coroutine_suspended = Boxing.boxBoolean(!((Boolean) obj).booleanValue());
            cancelConsumed(receiveChannel, null);
            return coroutine_suspended;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cancelConsumed(receiveChannel, th);
                throw th2;
            }
        }
        c1554mn = new ContinuationImpl(continuation);
        Object obj2 = c1554mn.f22990e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1554mn.f22991f;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ SelectClause1 onReceiveOrNull(ReceiveChannel receiveChannel) {
        Intrinsics.checkNotNull(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return receiveChannel.getOnReceiveOrNull();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        Intrinsics.checkNotNull(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return receiveChannel.receiveOrNull(continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(expression = "trySendBlocking(element)", imports = {}))
    public static final /* synthetic */ void sendBlocking(SendChannel sendChannel, Object obj) {
        if (!ChannelResult.m8877isSuccessimpl(sendChannel.mo8858trySendJP2dKIU(obj))) {
            BuildersKt.runBlocking$default(null, new C1359jm(sendChannel, obj, null), 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008b A[Catch: all -> 0x0093, TRY_ENTER, TryCatch #2 {all -> 0x0093, blocks: (B:14:0x007e, B:19:0x008b, B:20:0x0092, B:48:0x004d), top: B:47:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006a A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #3 {all -> 0x0048, blocks: (B:37:0x0044, B:38:0x0062, B:40:0x006a, B:43:0x0097, B:44:0x009e), top: B:36:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0097 A[Catch: all -> 0x0048, TRY_ENTER, TryCatch #3 {all -> 0x0048, blocks: (B:37:0x0044, B:38:0x0062, B:40:0x006a, B:43:0x0097, B:44:0x009e), top: B:36:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object single(ReceiveChannel receiveChannel, Continuation continuation) {
        C1643on c1643on;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Throwable th;
        if (continuation instanceof C1643on) {
            C1643on c1643on2 = (C1643on) continuation;
            int i2 = c1643on2.f24830g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1643on2.f24830g = i2 - Integer.MIN_VALUE;
                c1643on = c1643on2;
                obj = c1643on.f24829f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1643on.f24830g;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj2 = c1643on.f24828e;
                            ReceiveChannel receiveChannel3 = c1643on.f24827d;
                            try {
                                ResultKt.throwOnFailure(obj);
                                coroutine_suspended = obj2;
                                receiveChannel = receiveChannel3;
                                if (((Boolean) obj).booleanValue()) {
                                    cancelConsumed(receiveChannel, null);
                                    return coroutine_suspended;
                                }
                                throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                            } catch (Throwable th2) {
                                th = th2;
                                receiveChannel2 = receiveChannel3;
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ChannelIterator channelIterator2 = (ChannelIterator) c1643on.f24828e;
                        receiveChannel2 = c1643on.f24827d;
                        try {
                            ResultKt.throwOnFailure(obj);
                            channelIterator = channelIterator2;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        cancelConsumed(receiveChannel2, th);
                        throw th4;
                    }
                }
                ResultKt.throwOnFailure(obj);
                try {
                    ChannelIterator it = receiveChannel.iterator();
                    c1643on.f24827d = receiveChannel;
                    c1643on.f24828e = it;
                    c1643on.f24830g = 1;
                    Object hasNext = it.hasNext(c1643on);
                    if (hasNext != coroutine_suspended) {
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    }
                    return coroutine_suspended;
                } catch (Throwable th5) {
                    receiveChannel2 = receiveChannel;
                    th = th5;
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    c1643on.f24827d = receiveChannel2;
                    c1643on.f24828e = next;
                    c1643on.f24830g = 2;
                    Object hasNext2 = channelIterator.hasNext(c1643on);
                    if (hasNext2 != coroutine_suspended) {
                        coroutine_suspended = next;
                        obj = hasNext2;
                        receiveChannel = receiveChannel2;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                    return coroutine_suspended;
                }
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
        }
        c1643on = new ContinuationImpl(continuation);
        obj = c1643on.f24829f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1643on.f24830g;
        if (i == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070 A[Catch: all -> 0x0049, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0049, blocks: (B:38:0x0045, B:39:0x0063, B:42:0x0070), top: B:37:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object singleOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        C1693pn c1693pn;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object obj2;
        if (continuation instanceof C1693pn) {
            C1693pn c1693pn2 = (C1693pn) continuation;
            int i2 = c1693pn2.f25229g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1693pn2.f25229g = i2 - Integer.MIN_VALUE;
                c1693pn = c1693pn2;
                obj = c1693pn.f25228f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1693pn.f25229g;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj3 = c1693pn.f25227e;
                            ReceiveChannel receiveChannel3 = c1693pn.f25226d;
                            try {
                                ResultKt.throwOnFailure(obj);
                                obj2 = obj3;
                                receiveChannel = receiveChannel3;
                                if (!((Boolean) obj).booleanValue()) {
                                    cancelConsumed(receiveChannel, null);
                                    return null;
                                }
                                cancelConsumed(receiveChannel, null);
                                return obj2;
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    cancelConsumed(receiveChannel2, th);
                                    throw th2;
                                }
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ChannelIterator channelIterator2 = (ChannelIterator) c1693pn.f25227e;
                    receiveChannel2 = c1693pn.f25226d;
                    try {
                        ResultKt.throwOnFailure(obj);
                        channelIterator = channelIterator2;
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        c1693pn.f25226d = receiveChannel;
                        c1693pn.f25227e = it;
                        c1693pn.f25229g = 1;
                        Object hasNext = it.hasNext(c1693pn);
                        if (hasNext != coroutine_suspended) {
                            receiveChannel2 = receiveChannel;
                            channelIterator = it;
                            obj = hasNext;
                        } else {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    cancelConsumed(receiveChannel2, null);
                    return null;
                }
                Object next = channelIterator.next();
                c1693pn.f25226d = receiveChannel2;
                c1693pn.f25227e = next;
                c1693pn.f25229g = 2;
                Object hasNext2 = channelIterator.hasNext(c1693pn);
                if (hasNext2 != coroutine_suspended) {
                    obj2 = next;
                    obj = hasNext2;
                    receiveChannel = receiveChannel2;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                } else {
                    return coroutine_suspended;
                }
            }
        }
        c1693pn = new ContinuationImpl(continuation);
        obj = c1693pn.f25228f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1693pn.f25229g;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1730qn(receiveChannel, i, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return take(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1767rn(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return takeWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x002e, B:17:0x0064, B:19:0x006c, B:39:0x0045), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, sn] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [C extends kotlinx.coroutines.channels.SendChannel<? super E>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v9, types: [kotlinx.coroutines.channels.ChannelIterator] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007c -> B:13:0x0031). Please report as a decompilation issue!!! */
    @PublishedApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        ?? r0;
        int i;
        ChannelIterator channelIterator;
        Object obj;
        ?? r8;
        SendChannel sendChannel;
        Object hasNext;
        try {
            if (continuation instanceof C1804sn) {
                C1804sn c1804sn = (C1804sn) continuation;
                int i2 = c1804sn.f26500h;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    c1804sn.f26500h = i2 - Integer.MIN_VALUE;
                    r0 = c1804sn;
                    Object obj2 = r0.f26499g;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = r0.f26500h;
                    if (i == 0) {
                        if (i != 1) {
                            if (i == 2) {
                                channelIterator = r0.f26498f;
                                ReceiveChannel<? extends E> receiveChannel2 = (C) r0.f26497e;
                                SendChannel sendChannel2 = r0.f26496d;
                                ResultKt.throwOnFailure(obj2);
                                SendChannel sendChannel3 = sendChannel2;
                                ReceiveChannel<? extends E> receiveChannel3 = receiveChannel2;
                                boolean z = (ChannelIterator<? extends E>) channelIterator;
                                receiveChannel = receiveChannel3;
                                sendChannel = (C) sendChannel3;
                                r8 = z;
                                r0.f26496d = sendChannel;
                                r0.f26497e = receiveChannel;
                                r0.f26498f = r8;
                                r0.f26500h = 1;
                                hasNext = r8.hasNext(r0);
                                if (hasNext != coroutine_suspended) {
                                    SendChannel sendChannel4 = sendChannel;
                                    boolean z2 = (C) receiveChannel;
                                    channelIterator = r8;
                                    obj2 = hasNext;
                                    obj = sendChannel4;
                                    c = z2;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Object next = channelIterator.next();
                                        r0.f26496d = obj;
                                        r0.f26497e = (ReceiveChannel) c;
                                        r0.f26498f = channelIterator;
                                        r0.f26500h = 2;
                                        Object send = obj.send(next, r0);
                                        sendChannel3 = obj;
                                        receiveChannel3 = c;
                                        if (send == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        boolean z3 = (ChannelIterator<? extends E>) channelIterator;
                                        receiveChannel = receiveChannel3;
                                        sendChannel = (C) sendChannel3;
                                        r8 = z3;
                                        r0.f26496d = sendChannel;
                                        r0.f26497e = receiveChannel;
                                        r0.f26498f = r8;
                                        r0.f26500h = 1;
                                        hasNext = r8.hasNext(r0);
                                        if (hasNext != coroutine_suspended) {
                                        }
                                    } else {
                                        cancelConsumed((ReceiveChannel) c, null);
                                        return obj;
                                    }
                                } else {
                                    return coroutine_suspended;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            channelIterator = r0.f26498f;
                            boolean z4 = (C) r0.f26497e;
                            SendChannel sendChannel5 = r0.f26496d;
                            ResultKt.throwOnFailure(obj2);
                            obj = sendChannel5;
                            c = z4;
                            if (!((Boolean) obj2).booleanValue()) {
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            sendChannel = c;
                            r8 = receiveChannel.iterator();
                            r0.f26496d = sendChannel;
                            r0.f26497e = receiveChannel;
                            r0.f26498f = r8;
                            r0.f26500h = 1;
                            hasNext = r8.hasNext(r0);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th) {
                            c = receiveChannel;
                            th = th;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                cancelConsumed(c, th);
                                throw th2;
                            }
                        }
                    }
                }
            }
            if (i == 0) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        r0 = new ContinuationImpl(continuation);
        Object obj22 = r0.f26499g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = r0.f26500h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #2 {all -> 0x002f, blocks: (B:11:0x002b, B:12:0x0056, B:14:0x005e, B:16:0x0044), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, tn] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v5, types: [kotlinx.coroutines.channels.ChannelIterator] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0053 -> B:12:0x0056). Please report as a decompilation issue!!! */
    @PublishedApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object toCollection(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        ?? r0;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ?? it;
        C c2;
        Object hasNext;
        if (continuation instanceof C1841tn) {
            C1841tn c1841tn = (C1841tn) continuation;
            int i2 = c1841tn.f26892h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1841tn.f26892h = i2 - Integer.MIN_VALUE;
                r0 = c1841tn;
                Object obj = r0.f26891g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = r0.f26892h;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator channelIterator = r0.f26890f;
                        receiveChannel2 = r0.f26889e;
                        Collection collection = r0.f26888d;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Object obj2 = collection;
                            ChannelIterator channelIterator2 = channelIterator;
                            if (!((Boolean) obj).booleanValue()) {
                                obj2.add(channelIterator2.next());
                                c2 = obj2;
                                it = channelIterator2;
                                r0.f26888d = c2;
                                r0.f26889e = receiveChannel2;
                                r0.f26890f = it;
                                r0.f26892h = 1;
                                hasNext = it.hasNext(r0);
                                if (hasNext == coroutine_suspended) {
                                    obj2 = c2;
                                    obj = hasNext;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj).booleanValue()) {
                                        cancelConsumed(receiveChannel2, null);
                                        return obj2;
                                    }
                                } else {
                                    return coroutine_suspended;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                cancelConsumed(receiveChannel2, th);
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
                        c2 = c;
                        r0.f26888d = c2;
                        r0.f26889e = receiveChannel2;
                        r0.f26890f = it;
                        r0.f26892h = 1;
                        hasNext = it.hasNext(r0);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        r0 = new ContinuationImpl(continuation);
        Object obj3 = r0.f26891g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = r0.f26892h;
        if (i == 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #1 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x005f, B:14:0x0067), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005c -> B:12:0x005f). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object toList(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super List<? extends E>> continuation) {
        C1553mm c1553mm;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        List list;
        ChannelIterator it;
        List list2;
        Object hasNext;
        if (continuation instanceof C1553mm) {
            C1553mm c1553mm2 = (C1553mm) continuation;
            int i2 = c1553mm2.f22983i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1553mm2.f22983i = i2 - Integer.MIN_VALUE;
                c1553mm = c1553mm2;
                Object obj = c1553mm.f22982h;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1553mm.f22983i;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator channelIterator = c1553mm.f22981g;
                        ReceiveChannel<? extends E> receiveChannel3 = c1553mm.f22980f;
                        List list3 = c1553mm.f22979e;
                        list = c1553mm.f22978d;
                        try {
                            ResultKt.throwOnFailure(obj);
                            List list4 = list3;
                            ChannelIterator channelIterator2 = channelIterator;
                            if (!((Boolean) obj).booleanValue()) {
                                try {
                                    list4.add(channelIterator2.next());
                                    c1553mm.f22978d = list;
                                    c1553mm.f22979e = list2;
                                    c1553mm.f22980f = receiveChannel2;
                                    c1553mm.f22981g = it;
                                    c1553mm.f22983i = 1;
                                    hasNext = it.hasNext(c1553mm);
                                    if (hasNext == coroutine_suspended) {
                                        receiveChannel3 = receiveChannel2;
                                        obj = hasNext;
                                        list4 = list2;
                                        channelIterator2 = it;
                                        if (!((Boolean) obj).booleanValue()) {
                                            cancelConsumed(receiveChannel3, null);
                                            return AbstractC1167eq.build(list);
                                        }
                                    } else {
                                        return coroutine_suspended;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        cancelConsumed(receiveChannel2, th);
                                        throw th3;
                                    }
                                }
                                receiveChannel2 = receiveChannel3;
                                list2 = list4;
                                it = channelIterator2;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            receiveChannel2 = receiveChannel3;
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        List createListBuilder = AbstractC1167eq.createListBuilder();
                        list = createListBuilder;
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        list2 = createListBuilder;
                        c1553mm.f22978d = list;
                        c1553mm.f22979e = list2;
                        c1553mm.f22980f = receiveChannel2;
                        c1553mm.f22981g = it;
                        c1553mm.f22983i = 1;
                        hasNext = it.hasNext(c1553mm);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                }
            }
        }
        c1553mm = new ContinuationImpl(continuation);
        Object obj2 = c1553mm.f22982h;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1553mm.f22983i;
        if (i == 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #2 {all -> 0x002f, blocks: (B:11:0x002b, B:12:0x0056, B:14:0x005e, B:16:0x0044), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, un] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [kotlinx.coroutines.channels.ChannelIterator] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0053 -> B:12:0x0056). Please report as a decompilation issue!!! */
    @PublishedApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @NotNull M m, @NotNull Continuation<? super M> continuation) {
        ?? r0;
        int i;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel2;
        Throwable th;
        ?? it;
        M m2;
        Object hasNext;
        if (continuation instanceof C1878un) {
            C1878un c1878un = (C1878un) continuation;
            int i2 = c1878un.f27379h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1878un.f27379h = i2 - Integer.MIN_VALUE;
                r0 = c1878un;
                Object obj = r0.f27378g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = r0.f27379h;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        m2 = m;
                        r0.f27375d = m2;
                        r0.f27376e = receiveChannel2;
                        r0.f27377f = it;
                        r0.f27379h = 1;
                        hasNext = it.hasNext(r0);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ChannelIterator channelIterator = r0.f27377f;
                    receiveChannel2 = r0.f27376e;
                    Map map = r0.f27375d;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Object obj2 = map;
                        ChannelIterator channelIterator2 = channelIterator;
                        if (!((Boolean) obj).booleanValue()) {
                            Pair pair = (Pair) channelIterator2.next();
                            obj2.put(pair.getFirst(), pair.getSecond());
                            m2 = obj2;
                            it = channelIterator2;
                            r0.f27375d = m2;
                            r0.f27376e = receiveChannel2;
                            r0.f27377f = it;
                            r0.f27379h = 1;
                            hasNext = it.hasNext(r0);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj2 = m2;
                            obj = hasNext;
                            channelIterator2 = it;
                            if (!((Boolean) obj).booleanValue()) {
                                cancelConsumed(receiveChannel2, null);
                                return obj2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            }
        }
        r0 = new ContinuationImpl(continuation);
        Object obj3 = r0.f27378g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = r0.f27379h;
        if (i != 0) {
        }
    }

    @PublishedApi
    @Nullable
    public static final <E> Object toMutableSet(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super Set<E>> continuation) {
        return toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> Object trySendBlocking(@NotNull SendChannel<? super E> sendChannel, E e) {
        Object mo8858trySendJP2dKIU = sendChannel.mo8858trySendJP2dKIU(e);
        if (!(mo8858trySendJP2dKIU instanceof ChannelResult.Failed)) {
            return ChannelResult.INSTANCE.m8882successJP2dKIU(Unit.INSTANCE);
        }
        return ((ChannelResult) BuildersKt.runBlocking$default(null, new C1415d(sendChannel, e, null), 1, null)).getHolder();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel receiveChannel, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new C1915vn(receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return withIndex(receiveChannel, coroutineContext);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    @Nullable
    public static final <E> Object consumeEach(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        return AbstractC1416e.m5704b(receiveChannel, function1, continuation);
    }

    @PublishedApi
    @NotNull
    public static final <E, R, V> ReceiveChannel<V> zip(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull ReceiveChannel<? extends R> receiveChannel2, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumesAll(receiveChannel, receiveChannel2), new C1989xn(receiveChannel2, receiveChannel, function2, null), 6, null);
    }

    public static final <E, R> R consume(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        try {
            R invoke = function1.invoke(receiveChannel);
            InlineMarker.finallyStart(1);
            cancelConsumed(receiveChannel, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:17:0x0061, B:19:0x0069, B:21:0x006f, B:41:0x0042), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, an] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v9, types: [kotlinx.coroutines.channels.ChannelIterator] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006d -> B:13:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007b -> B:13:0x007e). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object filterNotNullTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        ?? r0;
        int i;
        ChannelIterator channelIterator;
        Object obj;
        ?? r8;
        SendChannel sendChannel2;
        Object hasNext;
        try {
            if (continuation instanceof C0024an) {
                C0024an c0024an = (C0024an) continuation;
                int i2 = c0024an.f263h;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    c0024an.f263h = i2 - Integer.MIN_VALUE;
                    r0 = c0024an;
                    Object obj2 = r0.f262g;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = r0.f263h;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            sendChannel2 = sendChannel;
                            r8 = receiveChannel.iterator();
                            r0.f259d = sendChannel2;
                            r0.f260e = receiveChannel;
                            r0.f261f = r8;
                            r0.f263h = 1;
                            hasNext = r8.hasNext(r0);
                            if (hasNext == coroutine_suspended) {
                            }
                        } catch (Throwable th) {
                            sendChannel = receiveChannel;
                            th = th;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                cancelConsumed(sendChannel, th);
                                throw th2;
                            }
                        }
                    } else if (i == 1) {
                        channelIterator = r0.f261f;
                        ReceiveChannel receiveChannel2 = r0.f260e;
                        SendChannel sendChannel3 = r0.f259d;
                        ResultKt.throwOnFailure(obj2);
                        obj = sendChannel3;
                        sendChannel = receiveChannel2;
                        if (((Boolean) obj2).booleanValue()) {
                        }
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        channelIterator = r0.f261f;
                        ReceiveChannel receiveChannel3 = r0.f260e;
                        SendChannel sendChannel4 = r0.f259d;
                        ResultKt.throwOnFailure(obj2);
                        SendChannel sendChannel5 = sendChannel4;
                        ReceiveChannel receiveChannel4 = receiveChannel3;
                        r8 = channelIterator;
                        receiveChannel = receiveChannel4;
                        sendChannel2 = sendChannel5;
                        r0.f259d = sendChannel2;
                        r0.f260e = receiveChannel;
                        r0.f261f = r8;
                        r0.f263h = 1;
                        hasNext = r8.hasNext(r0);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        SendChannel sendChannel6 = sendChannel2;
                        sendChannel = receiveChannel;
                        channelIterator = r8;
                        obj2 = hasNext;
                        obj = sendChannel6;
                        if (((Boolean) obj2).booleanValue()) {
                            cancelConsumed(sendChannel, null);
                            return obj;
                        }
                        Object next = channelIterator.next();
                        sendChannel5 = obj;
                        receiveChannel4 = sendChannel;
                        if (next != null) {
                            r0.f259d = obj;
                            r0.f260e = sendChannel;
                            r0.f261f = channelIterator;
                            r0.f263h = 2;
                            Object send = obj.send(next, r0);
                            sendChannel5 = obj;
                            receiveChannel4 = sendChannel;
                            if (send == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        r8 = channelIterator;
                        receiveChannel = receiveChannel4;
                        sendChannel2 = sendChannel5;
                        r0.f259d = sendChannel2;
                        r0.f260e = receiveChannel;
                        r0.f261f = r8;
                        r0.f263h = 1;
                        hasNext = r8.hasNext(r0);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        r0 = new ContinuationImpl(continuation);
        Object obj22 = r0.f262g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = r0.f263h;
    }
}
