package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt___StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1270hi;
import p000.C1307ii;
import p000.C1355ji;
import p000.C1392ki;
import p000.C1512li;
import p000.C1549mi;
import p000.C1586ni;
import p000.C1623oi;
import p000.C1688pi;
import p000.C1762ri;
import p000.C1799si;
import p000.C1836ti;
import p000.b51;
import p000.d92;
import p000.ha0;
import p000.o43;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004\u0087\u0001\u0088\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00028\u0000H\u0090@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\rJì\u0001\u0010&\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u000b\u001a\u00028\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182<\u0010 \u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00028\u00010\u001a2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182h\b\u0002\u0010%\u001ab\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110#¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u00010\"H\u0084\b¢\u0006\u0004\b&\u0010'J\u000f\u0010*\u001a\u00020\u0012H\u0010¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020\u0006H\u0014¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H\u0014¢\u0006\u0004\b-\u0010,J\u0013\u0010.\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\"\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b0\u0010/J\u001e\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u00020#H\u0004¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u00062\u0006\u00108\u001a\u00020#H\u0000¢\u0006\u0004\b9\u00107J%\u0010=\u001a\u00020\u00062\n\u0010<\u001a\u0006\u0012\u0002\b\u00030;2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b=\u0010>J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0096\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0006H\u0014¢\u0006\u0004\bB\u0010,J\u0019\u0010E\u001a\u00020\u00122\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00122\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bG\u0010FJ\r\u0010G\u001a\u00020\u0006¢\u0006\u0004\bG\u0010,J\u001d\u0010G\u001a\u00020\u00062\u000e\u0010D\u001a\n\u0018\u00010Hj\u0004\u0018\u0001`I¢\u0006\u0004\bG\u0010JJ\u0019\u0010L\u001a\u00020\u00122\b\u0010D\u001a\u0004\u0018\u00010CH\u0010¢\u0006\u0004\bK\u0010FJ!\u0010M\u001a\u00020\u00122\b\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010G\u001a\u00020\u0012H\u0014¢\u0006\u0004\bM\u0010NJ4\u0010P\u001a\u00020\u00062#\u0010O\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010C¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020\u0012H\u0000¢\u0006\u0004\bR\u0010)J\u000f\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010X\u001a\u00020TH\u0000¢\u0006\u0004\bW\u0010VJ\r\u0010Y\u001a\u00020\u0006¢\u0006\u0004\bY\u0010,R.\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00078\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010ZR\u0014\u0010]\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010_\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\\R,\u0010d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000`8VX\u0096\u0004¢\u0006\f\u0012\u0004\bc\u0010,\u001a\u0004\ba\u0010bR \u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000e8VX\u0096\u0004¢\u0006\f\u0012\u0004\bh\u0010,\u001a\u0004\bf\u0010gR)\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0e8VX\u0096\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bk\u0010,\u001a\u0004\bj\u0010gR\"\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000e8VX\u0096\u0004¢\u0006\f\u0012\u0004\bn\u0010,\u001a\u0004\bm\u0010gR\u0016\u0010r\u001a\u0004\u0018\u00010C8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0014\u0010t\u001a\u00020C8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bs\u0010qR\u0014\u0010u\u001a\u00020\u00128TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bu\u0010)R\u001a\u0010v\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\bw\u0010,\u001a\u0004\bv\u0010)R\u001a\u0010x\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\by\u0010,\u001a\u0004\bx\u0010)R\u001a\u0010z\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b{\u0010,\u001a\u0004\bz\u0010)R\u0013\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160|8\u0002X\u0082\u0004R\u000b\u0010\u007f\u001a\u00020~8\u0002X\u0082\u0004R\u0018\u0010\u0080\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0|8\u0002X\u0082\u0004R\u0014\u0010\u0081\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160|8\u0002X\u0082\u0004R\f\u0010\u0082\u0001\u001a\u00020~8\u0002X\u0082\u0004R\u0018\u0010\u0083\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0|8\u0002X\u0082\u0004R\f\u0010\u0084\u0001\u001a\u00020~8\u0002X\u0082\u0004R\u0018\u0010\u0085\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0|8\u0002X\u0082\u0004R\f\u0010\u0086\u0001\u001a\u00020~8\u0002X\u0082\u0004\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0089\u0001"}, m5569d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Channel;", "", "capacity", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "element", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "", "sendBroadcast$kotlinx_coroutines_core", "sendBroadcast", "R", "", "waiter", "Lkotlin/Function0;", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ChannelSegment;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "segm", "i", "onSuspend", "onClosed", "Lkotlin/Function4;", "", "s", "onNoWaiterSuspend", "sendImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "shouldSendSuspend$kotlinx_coroutines_core", "()Z", "shouldSendSuspend", "onReceiveEnqueued", "()V", "onReceiveDequeued", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching-JP2dKIU", "receiveCatching", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "globalCellIndex", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "(J)V", "globalIndex", "waitExpandBufferCompletion$kotlinx_coroutines_core", "waitExpandBufferCompletion", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "registerSelectForSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "onClosedIdempotent", "", "cause", "close", "(Ljava/lang/Throwable;)Z", "cancel", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelImpl$kotlinx_coroutines_core", "cancelImpl", "closeOrCancelImpl", "(Ljava/lang/Throwable;Z)Z", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "hasElements$kotlinx_coroutines_core", "hasElements", "", "toString", "()Ljava/lang/String;", "toStringDebug$kotlinx_coroutines_core", "toStringDebug", "checkSegmentStructureInvariants", "Lkotlin/jvm/functions/Function1;", "getSendersCounter$kotlinx_coroutines_core", "()J", "sendersCounter", "getReceiversCounter$kotlinx_coroutines_core", "receiversCounter", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "onSend", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "onReceive", "getOnReceiveCatching", "getOnReceiveCatching$annotations", "onReceiveCatching", "getOnReceiveOrNull", "getOnReceiveOrNull$annotations", "onReceiveOrNull", "getCloseCause", "()Ljava/lang/Throwable;", "closeCause", "getSendException", "sendException", "isConflatedDropOldest", "isClosedForSend", "isClosedForSend$annotations", "isClosedForReceive", "isClosedForReceive$annotations", "isEmpty", "isEmpty$annotations", "Lkotlinx/atomicfu/AtomicRef;", "_closeCause", "Lkotlinx/atomicfu/AtomicLong;", "bufferEnd", "bufferEndSegment", "closeHandler", "completedExpandBuffersAndPauseFlag", "receiveSegment", "receivers", "sendSegment", "sendersAndCloseStatus", "kotlinx/coroutines/channels/b", "hi", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3055:1\n273#1,6:3058\n280#1,68:3065\n374#1,18:3156\n244#1:3174\n269#1,10:3175\n280#1,48:3186\n395#1:3234\n334#1,14:3235\n399#1,3:3250\n244#1:3263\n269#1,10:3264\n280#1,68:3275\n244#1:3353\n269#1,10:3354\n280#1,68:3365\n244#1:3437\n269#1,10:3438\n280#1,68:3449\n886#1,52:3519\n964#1,8:3575\n858#1:3583\n882#1,33:3584\n974#1:3617\n916#1,14:3618\n935#1,3:3633\n979#1,6:3636\n886#1,52:3650\n964#1,8:3706\n858#1:3714\n882#1,33:3715\n974#1:3748\n916#1,14:3749\n935#1,3:3764\n979#1,6:3767\n858#1:3782\n882#1,48:3783\n935#1,3:3832\n858#1:3835\n882#1,48:3836\n935#1,3:3885\n244#1:3897\n269#1,10:3898\n280#1,68:3909\n858#1:3978\n882#1,48:3979\n935#1,3:4028\n1#2:3056\n3038#3:3057\n3038#3:3064\n3038#3:3185\n3038#3:3274\n3038#3:3364\n3038#3:3436\n3038#3:3448\n3038#3:3518\n3038#3:3781\n3038#3:3888\n3038#3:3889\n3052#3:3890\n3052#3:3891\n3051#3:3892\n3051#3:3893\n3051#3:3894\n3052#3:3895\n3051#3:3896\n3038#3:3908\n3039#3:4031\n3038#3:4032\n3038#3:4033\n3038#3:4034\n3039#3:4035\n3038#3:4036\n3039#3:4059\n3038#3:4060\n3038#3:4061\n3039#3:4062\n3038#3:4112\n3039#3:4113\n3039#3:4114\n3039#3:4132\n3039#3:4133\n314#4,9:3133\n323#4,2:3150\n332#4,4:3152\n336#4,8:3253\n314#4,9:3344\n323#4,2:3434\n332#4,4:3571\n336#4,8:3642\n332#4,4:3702\n336#4,8:3773\n220#5:3142\n221#5:3145\n220#5:3146\n221#5:3149\n61#6,2:3143\n61#6,2:3147\n61#6,2:3261\n269#7:3249\n269#7:3343\n269#7:3433\n269#7:3517\n269#7:3977\n882#8:3632\n882#8:3763\n882#8:3831\n882#8:3884\n882#8:4027\n37#9,11:4037\n37#9,11:4048\n72#10,3:4063\n46#10,8:4066\n72#10,3:4074\n46#10,8:4077\n46#10,8:4085\n72#10,3:4093\n46#10,8:4096\n46#10,8:4104\n766#11:4115\n857#11,2:4116\n2310#11,14:4118\n766#11:4134\n857#11,2:4135\n2310#11,14:4137\n766#11:4151\n857#11,2:4152\n2310#11,14:4154\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n113#1:3058,6\n113#1:3065,68\n154#1:3156,18\n154#1:3174\n154#1:3175,10\n154#1:3186,48\n154#1:3234\n154#1:3235,14\n154#1:3250,3\n194#1:3263\n194#1:3264,10\n194#1:3275,68\n225#1:3353\n225#1:3354,10\n225#1:3365,68\n391#1:3437\n391#1:3438,10\n391#1:3449,68\n667#1:3519,52\n696#1:3575,8\n696#1:3583\n696#1:3584,33\n696#1:3617\n696#1:3618,14\n696#1:3633,3\n696#1:3636,6\n732#1:3650,52\n748#1:3706,8\n748#1:3714\n748#1:3715,33\n748#1:3748\n748#1:3749,14\n748#1:3764,3\n748#1:3767,6\n781#1:3782\n781#1:3783,48\n781#1:3832,3\n971#1:3835\n971#1:3836,48\n971#1:3885,3\n1464#1:3897\n1464#1:3898,10\n1464#1:3909,68\n1512#1:3978\n1512#1:3979,48\n1512#1:4028,3\n70#1:3057\n113#1:3064\n154#1:3185\n194#1:3274\n225#1:3364\n278#1:3436\n391#1:3448\n606#1:3518\n771#1:3781\n1007#1:3888\n1056#1:3889\n1374#1:3890\n1376#1:3891\n1406#1:3892\n1416#1:3893\n1425#1:3894\n1426#1:3895\n1433#1:3896\n1464#1:3908\n1865#1:4031\n1867#1:4032\n1869#1:4033\n1882#1:4034\n1893#1:4035\n1894#1:4036\n2196#1:4059\n2209#1:4060\n2219#1:4061\n2222#1:4062\n2539#1:4112\n2541#1:4113\n2566#1:4114\n2628#1:4132\n2629#1:4133\n134#1:3133,9\n134#1:3150,2\n153#1:3152,4\n153#1:3253,8\n221#1:3344,9\n221#1:3434,2\n695#1:3571,4\n695#1:3642,8\n746#1:3702,4\n746#1:3773,8\n138#1:3142\n138#1:3145\n141#1:3146\n141#1:3149\n138#1:3143,2\n141#1:3147,2\n183#1:3261,2\n154#1:3249\n194#1:3343\n225#1:3433\n391#1:3517\n1464#1:3977\n696#1:3632\n748#1:3763\n781#1:3831\n971#1:3884\n1512#1:4027\n2098#1:4037,11\n2153#1:4048,11\n2361#1:4063,3\n2361#1:4066,8\n2416#1:4074,3\n2416#1:4077,8\n2435#1:4085,8\n2465#1:4093,3\n2465#1:4096,8\n2526#1:4104,8\n2575#1:4115\n2575#1:4116,2\n2576#1:4118,14\n2640#1:4134\n2640#1:4135,2\n2641#1:4137,14\n2681#1:4151\n2681#1:4152,2\n2682#1:4154,14\n*E\n"})
/* loaded from: classes2.dex */
public class BufferedChannel<E> implements Channel<E> {

    /* renamed from: c */
    public static final AtomicLongFieldUpdater f21452c = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");

    /* renamed from: d */
    public static final AtomicLongFieldUpdater f21453d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");

    /* renamed from: e */
    public static final AtomicLongFieldUpdater f21454e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");

    /* renamed from: f */
    public static final AtomicLongFieldUpdater f21455f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: g */
    public static final AtomicReferenceFieldUpdater f21456g = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");

    /* renamed from: h */
    public static final AtomicReferenceFieldUpdater f21457h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");

    /* renamed from: i */
    public static final AtomicReferenceFieldUpdater f21458i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");

    /* renamed from: j */
    public static final AtomicReferenceFieldUpdater f21459j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");

    /* renamed from: k */
    public static final AtomicReferenceFieldUpdater f21460k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");

    @Volatile
    @Nullable
    private volatile Object _closeCause;

    /* renamed from: a */
    public final int f21461a;

    /* renamed from: b */
    public final C1762ri f21462b;

    @Volatile
    private volatile long bufferEnd;

    @Volatile
    @Nullable
    private volatile Object bufferEndSegment;

    @Volatile
    @Nullable
    private volatile Object closeHandler;

    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;

    @JvmField
    @Nullable
    public final Function1<E, Unit> onUndeliveredElement;

    @Volatile
    @Nullable
    private volatile Object receiveSegment;

    @Volatile
    private volatile long receivers;

    @Volatile
    @Nullable
    private volatile Object sendSegment;

    @Volatile
    private volatile long sendersAndCloseStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int i, @Nullable Function1<? super E, Unit> function1) {
        Symbol symbol;
        this.f21461a = i;
        this.onUndeliveredElement = function1;
        if (i >= 0) {
            this.bufferEnd = BufferedChannelKt.access$initialBufferEnd(i);
            this.completedExpandBuffersAndPauseFlag = f21454e.get(this);
            ChannelSegment channelSegment = new ChannelSegment(0L, null, this, 3);
            this.sendSegment = channelSegment;
            this.receiveSegment = channelSegment;
            if (m5689h()) {
                channelSegment = BufferedChannelKt.f21463a;
                Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = channelSegment;
            this.f21462b = function1 != 0 ? new C1762ri(0, this) : null;
            symbol = BufferedChannelKt.f21479q;
            this._closeCause = symbol;
            return;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Invalid channel capacity: ", ", should be >=0").toString());
    }

    public static final ChannelSegment access$findSegmentSend(BufferedChannel bufferedChannel, long j, ChannelSegment channelSegment) {
        Object findSegmentInternal;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        long j3;
        bufferedChannel.getClass();
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, function2);
            if (!SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
                Segment m8904getSegmentimpl = SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21456g;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(bufferedChannel);
                    if (segment.id >= m8904getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!m8904getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, segment, m8904getSegmentimpl)) {
                        if (atomicReferenceFieldUpdater.get(bufferedChannel) != segment) {
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
        if (SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
            bufferedChannel.isClosedForSend();
            if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE >= bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment.cleanPrev();
            return null;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
        long j4 = channelSegment2.id;
        if (j4 > j) {
            long j5 = j4 * BufferedChannelKt.SEGMENT_SIZE;
            do {
                atomicLongFieldUpdater = f21452c;
                j2 = atomicLongFieldUpdater.get(bufferedChannel);
                j3 = 1152921504606846975L & j2;
                if (j3 >= j5) {
                    break;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j2, BufferedChannelKt.access$constructSendersAndCloseStatus(j3, (int) (j2 >> 60))));
            if (channelSegment2.id * BufferedChannelKt.SEGMENT_SIZE >= bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment2.cleanPrev();
            return null;
        }
        return channelSegment2;
    }

    public static final void access$onClosedReceiveCatchingOnNoWaiterSuspend(BufferedChannel bufferedChannel, CancellableContinuation cancellableContinuation) {
        bufferedChannel.getClass();
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m8512constructorimpl(ChannelResult.m8867boximpl(ChannelResult.INSTANCE.m8880closedJP2dKIU(bufferedChannel.getCloseCause()))));
    }

    public static final void access$onClosedReceiveOnNoWaiterSuspend(BufferedChannel bufferedChannel, CancellableContinuation cancellableContinuation) {
        bufferedChannel.getClass();
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(bufferedChannel.m5687e())));
    }

    public static final void access$onClosedSendOnNoWaiterSuspend(BufferedChannel bufferedChannel, Object obj, CancellableContinuation cancellableContinuation) {
        Function1<E, Unit> function1 = bufferedChannel.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, obj, cancellableContinuation.getContext());
        }
        Throwable sendException = bufferedChannel.getSendException();
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(sendException)));
    }

    public static final void access$prepareReceiverForSuspension(BufferedChannel bufferedChannel, Waiter waiter, ChannelSegment channelSegment, int i) {
        bufferedChannel.onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i);
    }

    public static final void access$prepareSenderForSuspension(BufferedChannel bufferedChannel, Waiter waiter, ChannelSegment channelSegment, int i) {
        bufferedChannel.getClass();
        waiter.invokeOnCancellation(channelSegment, i + BufferedChannelKt.SEGMENT_SIZE);
    }

    public static final Object access$processResultSelectReceive(BufferedChannel bufferedChannel, Object obj, Object obj2) {
        bufferedChannel.getClass();
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return obj2;
        }
        throw bufferedChannel.m5687e();
    }

    public static final Object access$processResultSelectReceiveCatching(BufferedChannel bufferedChannel, Object obj, Object obj2) {
        Object m8882successJP2dKIU;
        bufferedChannel.getClass();
        if (obj2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            m8882successJP2dKIU = ChannelResult.INSTANCE.m8880closedJP2dKIU(bufferedChannel.getCloseCause());
        } else {
            m8882successJP2dKIU = ChannelResult.INSTANCE.m8882successJP2dKIU(obj2);
        }
        return ChannelResult.m8867boximpl(m8882successJP2dKIU);
    }

    public static final Object access$processResultSelectReceiveOrNull(BufferedChannel bufferedChannel, Object obj, Object obj2) {
        bufferedChannel.getClass();
        if (obj2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            if (bufferedChannel.getCloseCause() == null) {
                return null;
            }
            throw bufferedChannel.m5687e();
        }
        return obj2;
    }

    public static final Object access$processResultSelectSend(BufferedChannel bufferedChannel, Object obj, Object obj2) {
        bufferedChannel.getClass();
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return bufferedChannel;
        }
        throw bufferedChannel.getSendException();
    }

    public static final void access$registerSelectForReceive(BufferedChannel bufferedChannel, SelectInstance selectInstance, Object obj) {
        Symbol symbol;
        Waiter waiter;
        Symbol symbol2;
        Symbol symbol3;
        bufferedChannel.getClass();
        ChannelSegment channelSegment = (ChannelSegment) f21457h.get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = f21453d.getAndIncrement(bufferedChannel);
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
            Object m5699s = bufferedChannel.m5699s(channelSegment, i, selectInstance, andIncrement);
            symbol = BufferedChannelKt.f21473k;
            if (m5699s != symbol) {
                symbol2 = BufferedChannelKt.f21475m;
                if (m5699s != symbol2) {
                    symbol3 = BufferedChannelKt.f21474l;
                    if (m5699s != symbol3) {
                        channelSegment.cleanPrev();
                        selectInstance.selectInRegistrationPhase(m5699s);
                        return;
                    }
                    throw new IllegalStateException("unexpected");
                }
                if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else {
                if (selectInstance instanceof Waiter) {
                    waiter = (Waiter) selectInstance;
                } else {
                    waiter = null;
                }
                if (waiter != null) {
                    access$prepareReceiverForSuspension(bufferedChannel, waiter, channelSegment, i);
                    return;
                }
                return;
            }
        }
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    public static final int access$updateCellSend(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i, Object obj, long j, Object obj2, boolean z) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        bufferedChannel.getClass();
        channelSegment.storeElement$kotlinx_coroutines_core(i, obj);
        if (z) {
            return bufferedChannel.m5700t(channelSegment, i, obj, j, obj2, z);
        }
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferedChannel.m5683a(j)) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, obj2)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.cleanElement$kotlinx_coroutines_core(i);
            if (bufferedChannel.m5697q(state$kotlinx_coroutines_core, obj)) {
                symbol3 = BufferedChannelKt.f21469g;
                channelSegment.setState$kotlinx_coroutines_core(i, symbol3);
                bufferedChannel.onReceiveDequeued();
                return 0;
            }
            symbol = BufferedChannelKt.f21471i;
            Object andSetState$kotlinx_coroutines_core = channelSegment.getAndSetState$kotlinx_coroutines_core(i, symbol);
            symbol2 = BufferedChannelKt.f21471i;
            if (andSetState$kotlinx_coroutines_core != symbol2) {
                channelSegment.onCancelledRequest(i, true);
            }
            return 5;
        }
        return bufferedChannel.m5700t(channelSegment, i, obj, j, obj2, z);
    }

    /* renamed from: f */
    public static void m5681f(BufferedChannel bufferedChannel) {
        bufferedChannel.getClass();
        AtomicLongFieldUpdater atomicLongFieldUpdater = f21455f;
        if ((atomicLongFieldUpdater.addAndGet(bufferedChannel, 1L) & Longs.MAX_POWER_OF_TWO) == 0) {
            return;
        }
        do {
        } while ((atomicLongFieldUpdater.get(bufferedChannel) & Longs.MAX_POWER_OF_TWO) != 0);
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isEmpty$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object m5682l(BufferedChannel bufferedChannel, Continuation continuation) {
        C1799si c1799si;
        int i;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        if (continuation instanceof C1799si) {
            c1799si = (C1799si) continuation;
            int i2 = c1799si.f26436f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1799si.f26436f = i2 - Integer.MIN_VALUE;
                C1799si c1799si2 = c1799si;
                Object obj = c1799si2.f26434d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1799si2.f26436f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return ((ChannelResult) obj).getHolder();
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ChannelSegment channelSegment = (ChannelSegment) f21457h.get(bufferedChannel);
                while (!bufferedChannel.isClosedForReceive()) {
                    long andIncrement = f21453d.getAndIncrement(bufferedChannel);
                    long j = BufferedChannelKt.SEGMENT_SIZE;
                    long j2 = andIncrement / j;
                    int i3 = (int) (andIncrement % j);
                    if (channelSegment.id != j2) {
                        ChannelSegment m5686d = bufferedChannel.m5686d(j2, channelSegment);
                        if (m5686d == null) {
                            continue;
                        } else {
                            channelSegment = m5686d;
                        }
                    }
                    Object m5699s = bufferedChannel.m5699s(channelSegment, i3, null, andIncrement);
                    symbol = BufferedChannelKt.f21473k;
                    if (m5699s != symbol) {
                        symbol2 = BufferedChannelKt.f21475m;
                        if (m5699s != symbol2) {
                            symbol3 = BufferedChannelKt.f21474l;
                            if (m5699s == symbol3) {
                                c1799si2.f26436f = 1;
                                Object m5693m = bufferedChannel.m5693m(channelSegment, i3, andIncrement, c1799si2);
                                if (m5693m == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return m5693m;
                            }
                            channelSegment.cleanPrev();
                            return ChannelResult.INSTANCE.m8882successJP2dKIU(m5699s);
                        }
                        if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                    } else {
                        throw new IllegalStateException("unexpected");
                    }
                }
                return ChannelResult.INSTANCE.m8880closedJP2dKIU(bufferedChannel.getCloseCause());
            }
        }
        c1799si = new C1799si(bufferedChannel, continuation);
        C1799si c1799si22 = c1799si;
        Object obj2 = c1799si22.f26434d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1799si22.f26436f;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object sendImpl$default(BufferedChannel bufferedChannel, Object obj, Object obj2, Function0 function0, Function2 function2, Function0 function02, Function4 function4, int i, Object obj3) {
        ChannelSegment channelSegment;
        if (obj3 == null) {
            Function4 function42 = (i & 32) != 0 ? new Function4() { // from class: kotlinx.coroutines.channels.BufferedChannel$sendImpl$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                    return invoke((ChannelSegment<int>) obj4, ((Number) obj5).intValue(), (int) obj6, ((Number) obj7).longValue());
                }

                @NotNull
                public final Void invoke(@NotNull ChannelSegment<E> channelSegment2, int i2, E e, long j) {
                    throw new IllegalStateException("unexpected");
                }
            } : function4;
            ChannelSegment channelSegment2 = (ChannelSegment) f21456g.get(bufferedChannel);
            while (true) {
                long andIncrement = f21452c.getAndIncrement(bufferedChannel);
                long j = andIncrement & 1152921504606846975L;
                boolean m5688g = bufferedChannel.m5688g(andIncrement, false);
                int i2 = BufferedChannelKt.SEGMENT_SIZE;
                long j2 = j / i2;
                int i3 = (int) (j % i2);
                if (channelSegment2.id != j2) {
                    ChannelSegment access$findSegmentSend = access$findSegmentSend(bufferedChannel, j2, channelSegment2);
                    if (access$findSegmentSend != null) {
                        channelSegment = access$findSegmentSend;
                    } else if (m5688g) {
                        return function02.invoke();
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                int access$updateCellSend = access$updateCellSend(bufferedChannel, channelSegment, i3, obj, j, obj2, m5688g);
                if (access$updateCellSend == 0) {
                    channelSegment.cleanPrev();
                    return function0.invoke();
                }
                if (access$updateCellSend == 1) {
                    return function0.invoke();
                }
                if (access$updateCellSend == 2) {
                    if (m5688g) {
                        channelSegment.onSlotCleaned();
                        return function02.invoke();
                    }
                    Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                    if (waiter != null) {
                        access$prepareSenderForSuspension(bufferedChannel, waiter, channelSegment, i3);
                    }
                    return function2.invoke(channelSegment, Integer.valueOf(i3));
                }
                if (access$updateCellSend == 3) {
                    return function42.invoke(channelSegment, Integer.valueOf(i3), obj, Long.valueOf(j));
                }
                if (access$updateCellSend == 4) {
                    if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    return function02.invoke();
                }
                if (access$updateCellSend == 5) {
                    channelSegment.cleanPrev();
                }
                channelSegment2 = channelSegment;
            }
        } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
    }

    /* renamed from: a */
    public final boolean m5683a(long j) {
        if (j >= f21454e.get(this) && j >= getReceiversCounter$kotlinx_coroutines_core() + this.f21461a) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x007a, code lost:
    
        r1 = (kotlinx.coroutines.channels.ChannelSegment) r1.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ChannelSegment m5684b(long j) {
        Symbol symbol;
        long j2;
        Symbol symbol2;
        Object obj = f21458i.get(this);
        ChannelSegment channelSegment = (ChannelSegment) f21456g.get(this);
        if (channelSegment.id > ((ChannelSegment) obj).id) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) f21457h.get(this);
        if (channelSegment2.id > ((ChannelSegment) obj).id) {
            obj = channelSegment2;
        }
        ChannelSegment channelSegment3 = (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) obj);
        if (isConflatedDropOldest()) {
            ChannelSegment channelSegment4 = channelSegment3;
            loop0: do {
                int i = BufferedChannelKt.SEGMENT_SIZE - 1;
                while (true) {
                    if (-1 >= i) {
                        break;
                    }
                    j2 = (channelSegment4.id * BufferedChannelKt.SEGMENT_SIZE) + i;
                    if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                        break loop0;
                    }
                    while (true) {
                        Object state$kotlinx_coroutines_core = channelSegment4.getState$kotlinx_coroutines_core(i);
                        if (state$kotlinx_coroutines_core != null) {
                            symbol2 = BufferedChannelKt.f21465c;
                            if (state$kotlinx_coroutines_core != symbol2) {
                                if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                                    break loop0;
                                }
                            }
                        }
                        if (channelSegment4.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            channelSegment4.onSlotCleaned();
                            break;
                        }
                    }
                    i--;
                }
            } while (channelSegment4 != null);
            j2 = -1;
            if (j2 != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(j2);
            }
        }
        Object m8891constructorimpl$default = InlineList.m8891constructorimpl$default(null, 1, null);
        loop3: for (ChannelSegment channelSegment5 = channelSegment3; channelSegment5 != null; channelSegment5 = (ChannelSegment) channelSegment5.getPrev()) {
            for (int i2 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i2; i2--) {
                if ((channelSegment5.id * BufferedChannelKt.SEGMENT_SIZE) + i2 < j) {
                    break loop3;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core2 = channelSegment5.getState$kotlinx_coroutines_core(i2);
                    if (state$kotlinx_coroutines_core2 != null) {
                        symbol = BufferedChannelKt.f21465c;
                        if (state$kotlinx_coroutines_core2 != symbol) {
                            if (state$kotlinx_coroutines_core2 instanceof o43) {
                                if (channelSegment5.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core2, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    m8891constructorimpl$default = InlineList.m8896plusFjFbRPM(m8891constructorimpl$default, ((o43) state$kotlinx_coroutines_core2).f23606a);
                                    channelSegment5.onCancelledRequest(i2, true);
                                    break;
                                }
                            } else {
                                if (!(state$kotlinx_coroutines_core2 instanceof Waiter)) {
                                    break;
                                }
                                if (channelSegment5.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core2, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    m8891constructorimpl$default = InlineList.m8896plusFjFbRPM(m8891constructorimpl$default, state$kotlinx_coroutines_core2);
                                    channelSegment5.onCancelledRequest(i2, true);
                                    break;
                                }
                            }
                        }
                    }
                    if (channelSegment5.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core2, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        channelSegment5.onSlotCleaned();
                        break;
                    }
                }
            }
        }
        if (m8891constructorimpl$default != null) {
            if (!(m8891constructorimpl$default instanceof ArrayList)) {
                m5695o((Waiter) m8891constructorimpl$default, true);
            } else {
                Intrinsics.checkNotNull(m8891constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) m8891constructorimpl$default;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    m5695o((Waiter) arrayList.get(size), true);
                }
            }
        }
        return channelSegment3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x00cc, code lost:
    
        if ((r2.addAndGet(r17, r0) & com.google.common.primitives.Longs.MAX_POWER_OF_TWO) != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00d5, code lost:
    
        if ((r2.get(r17) & com.google.common.primitives.Longs.MAX_POWER_OF_TWO) == 0) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b4, code lost:
    
        m5681f(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01b7, code lost:
    
        return;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5685c() {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        Symbol symbol8;
        Symbol symbol9;
        Symbol symbol10;
        Object findSegmentInternal;
        if (m5689h()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21458i;
        ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
        loop0: while (true) {
            long andIncrement = f21454e.getAndIncrement(this);
            long j = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j && channelSegment.getNext() != 0) {
                    m5690i(j, channelSegment);
                }
                m5681f(this);
                return;
            }
            if (channelSegment.id != j) {
                Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
                while (true) {
                    findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, function2);
                    if (!SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
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
                    } else {
                        break;
                    }
                }
                ChannelSegment channelSegment2 = null;
                if (SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
                    isClosedForSend();
                    m5690i(j, channelSegment);
                    m5681f(this);
                } else {
                    ChannelSegment channelSegment3 = (ChannelSegment) SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
                    long j2 = channelSegment3.id;
                    if (j2 > j) {
                        long j3 = BufferedChannelKt.SEGMENT_SIZE;
                        if (f21454e.compareAndSet(this, andIncrement + 1, j2 * j3)) {
                            long j4 = (channelSegment3.id * j3) - andIncrement;
                            AtomicLongFieldUpdater atomicLongFieldUpdater = f21455f;
                        } else {
                            m5681f(this);
                        }
                    } else {
                        channelSegment2 = channelSegment3;
                    }
                }
                if (channelSegment2 == null) {
                    continue;
                } else {
                    channelSegment = channelSegment2;
                }
            }
            int i = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            boolean z = state$kotlinx_coroutines_core instanceof Waiter;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f21453d;
            if (z && andIncrement >= atomicLongFieldUpdater2.get(this)) {
                symbol9 = BufferedChannelKt.f21467e;
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol9)) {
                    if (!m5698r(state$kotlinx_coroutines_core, channelSegment, i)) {
                        symbol10 = BufferedChannelKt.f21470h;
                        channelSegment.setState$kotlinx_coroutines_core(i, symbol10);
                        channelSegment.onCancelledRequest(i, false);
                        m5681f(this);
                    } else {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                        break;
                    }
                }
            }
            while (true) {
                Object state$kotlinx_coroutines_core2 = channelSegment.getState$kotlinx_coroutines_core(i);
                if (!(state$kotlinx_coroutines_core2 instanceof Waiter)) {
                    symbol3 = BufferedChannelKt.f21470h;
                    if (state$kotlinx_coroutines_core2 != symbol3) {
                        if (state$kotlinx_coroutines_core2 == null) {
                            symbol4 = BufferedChannelKt.f21465c;
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, symbol4)) {
                                break loop0;
                            }
                        } else if (state$kotlinx_coroutines_core2 != BufferedChannelKt.BUFFERED) {
                            symbol5 = BufferedChannelKt.f21468f;
                            if (state$kotlinx_coroutines_core2 == symbol5) {
                                break loop0;
                            }
                            symbol6 = BufferedChannelKt.f21469g;
                            if (state$kotlinx_coroutines_core2 == symbol6) {
                                break loop0;
                            }
                            symbol7 = BufferedChannelKt.f21471i;
                            if (state$kotlinx_coroutines_core2 == symbol7 || state$kotlinx_coroutines_core2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                                break loop0;
                            }
                            symbol8 = BufferedChannelKt.f21466d;
                            if (state$kotlinx_coroutines_core2 != symbol8) {
                                throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core2).toString());
                            }
                        } else {
                            break loop0;
                        }
                    } else {
                        break;
                    }
                } else if (andIncrement >= atomicLongFieldUpdater2.get(this)) {
                    symbol = BufferedChannelKt.f21467e;
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, symbol)) {
                        if (!m5698r(state$kotlinx_coroutines_core2, channelSegment, i)) {
                            symbol2 = BufferedChannelKt.f21470h;
                            channelSegment.setState$kotlinx_coroutines_core(i, symbol2);
                            channelSegment.onCancelledRequest(i, false);
                        } else {
                            channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                            break;
                        }
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, new o43((Waiter) state$kotlinx_coroutines_core2))) {
                    break loop0;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(@Nullable Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(@Nullable Throwable cause) {
        if (cause == null) {
            cause = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(cause, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkSegmentStructureInvariants() {
        boolean z;
        Symbol symbol;
        Symbol symbol2;
        boolean areEqual;
        boolean areEqual2;
        Symbol symbol3;
        Symbol symbol4;
        boolean areEqual3;
        boolean z2;
        boolean z3;
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2;
        boolean m5689h = m5689h();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21457h;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f21458i;
        if (m5689h) {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            channelSegment2 = BufferedChannelKt.f21463a;
            if (obj != channelSegment2) {
                throw new IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
            }
        } else if (((ChannelSegment) atomicReferenceFieldUpdater.get(this)).id > ((ChannelSegment) atomicReferenceFieldUpdater2.get(this)).id) {
            throw new IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f21456g;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ChannelSegment[]{atomicReferenceFieldUpdater.get(this), atomicReferenceFieldUpdater3.get(this), atomicReferenceFieldUpdater2.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listOf) {
            ChannelSegment channelSegment3 = (ChannelSegment) obj2;
            channelSegment = BufferedChannelKt.f21463a;
            if (channelSegment3 != channelSegment) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long j = ((ChannelSegment) next).id;
                do {
                    Object next2 = it.next();
                    long j2 = ((ChannelSegment) next2).id;
                    if (j > j2) {
                        next = next2;
                        j = j2;
                    }
                } while (it.hasNext());
            }
            ChannelSegment channelSegment4 = (ChannelSegment) next;
            if (channelSegment4.getPrev() == 0) {
                while (channelSegment4.getNext() != 0) {
                    S next3 = channelSegment4.getNext();
                    Intrinsics.checkNotNull(next3);
                    if (((ChannelSegment) next3).getPrev() != 0) {
                        S next4 = channelSegment4.getNext();
                        Intrinsics.checkNotNull(next4);
                        if (((ChannelSegment) next4).getPrev() != channelSegment4) {
                            throw new IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
                        }
                    }
                    int i = BufferedChannelKt.SEGMENT_SIZE;
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        Object state$kotlinx_coroutines_core = channelSegment4.getState$kotlinx_coroutines_core(i3);
                        if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED) && !(state$kotlinx_coroutines_core instanceof Waiter)) {
                            symbol = BufferedChannelKt.f21471i;
                            if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol)) {
                                symbol2 = BufferedChannelKt.f21470h;
                                areEqual = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol2);
                            } else {
                                areEqual = true;
                            }
                            if (areEqual) {
                                areEqual2 = true;
                            } else {
                                areEqual2 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED());
                            }
                            if (!areEqual2) {
                                symbol3 = BufferedChannelKt.f21468f;
                                if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol3)) {
                                    symbol4 = BufferedChannelKt.f21469g;
                                    areEqual3 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol4);
                                } else {
                                    areEqual3 = true;
                                }
                                if (areEqual3) {
                                    if (channelSegment4.getElement$kotlinx_coroutines_core(i3) == null) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                } else {
                                    throw new IllegalStateException(("Unexpected segment cell state: " + state$kotlinx_coroutines_core + ".\nChannel state: " + this).toString());
                                }
                            } else {
                                if (channelSegment4.getElement$kotlinx_coroutines_core(i3) == null) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    i2++;
                                } else {
                                    throw new IllegalStateException("Check failed.");
                                }
                            }
                        }
                    }
                    if (i2 == BufferedChannelKt.SEGMENT_SIZE) {
                        if (channelSegment4 != atomicReferenceFieldUpdater.get(this) && channelSegment4 != atomicReferenceFieldUpdater3.get(this) && channelSegment4 != atomicReferenceFieldUpdater2.get(this)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
                        }
                    }
                    S next5 = channelSegment4.getNext();
                    Intrinsics.checkNotNull(next5);
                    channelSegment4 = (ChannelSegment) next5;
                }
                return;
            }
            throw new IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
        }
        throw new NoSuchElementException();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable cause) {
        return closeOrCancelImpl(cause, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        r3 = kotlinx.coroutines.channels.BufferedChannelKt.f21479q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        r4 = kotlinx.coroutines.channels.BufferedChannel.f21459j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        if (r4.compareAndSet(r13, r3, r14) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r4.get(r13) == r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        if (r15 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        r5 = r9.get(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r9.compareAndSet(r13, r5, kotlinx.coroutines.channels.BufferedChannelKt.access$constructSendersAndCloseStatus(r5 & 1152921504606846975L, 3)) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
    
        isClosedForSend();
        onClosedIdempotent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
    
        if (r11 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
    
        r14 = kotlinx.coroutines.channels.BufferedChannel.f21460k;
        r15 = r14.get(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0081, code lost:
    
        if (r15 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
    
        r0 = kotlinx.coroutines.channels.BufferedChannelKt.f21477o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
    
        if (r14.compareAndSet(r13, r15, r0) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000a, code lost:
    
        if (r15 != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
    
        if (r14.get(r13) == r15) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
    
        if (r15 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
    
        r14 = (kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r15, 1);
        ((kotlin.jvm.functions.Function1) r15).invoke(getCloseCause());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
    
        r0 = kotlinx.coroutines.channels.BufferedChannelKt.f21478p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r5 = r9.get(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x004f, code lost:
    
        r5 = r9.get(r13);
        r14 = (int) (r5 >> 60);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0056, code lost:
    
        if (r14 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0058, code lost:
    
        if (r14 == 1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005b, code lost:
    
        r14 = kotlinx.coroutines.channels.BufferedChannelKt.access$constructSendersAndCloseStatus(r5 & 1152921504606846975L, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0071, code lost:
    
        if (r9.compareAndSet(r13, r5, r14) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        if (((int) (r5 >> 60)) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0063, code lost:
    
        r14 = kotlinx.coroutines.channels.BufferedChannelKt.access$constructSendersAndCloseStatus(r5 & 1152921504606846975L, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x002f, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (r9.compareAndSet(r13, r5, kotlinx.coroutines.channels.BufferedChannelKt.access$constructSendersAndCloseStatus(r5 & 1152921504606846975L, 1)) == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean closeOrCancelImpl(@Nullable Throwable cause, boolean cancel) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f21452c;
    }

    /* renamed from: d */
    public final ChannelSegment m5686d(long j, ChannelSegment channelSegment) {
        Object findSegmentInternal;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, function2);
            if (!SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
                Segment m8904getSegmentimpl = SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21457h;
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
        if (SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
            isClosedForSend();
            if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment.cleanPrev();
            return null;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
        if (!m5689h() && j <= f21454e.get(this) / BufferedChannelKt.SEGMENT_SIZE) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f21458i;
                Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                if (segment2.id >= channelSegment2.id) {
                    break;
                }
                if (!channelSegment2.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, segment2, channelSegment2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != segment2) {
                        if (channelSegment2.decPointers$kotlinx_coroutines_core()) {
                            channelSegment2.remove();
                        }
                    }
                }
                if (segment2.decPointers$kotlinx_coroutines_core()) {
                    segment2.remove();
                }
            }
        }
        long j3 = channelSegment2.id;
        if (j3 > j) {
            long j4 = j3 * BufferedChannelKt.SEGMENT_SIZE;
            do {
                atomicLongFieldUpdater = f21453d;
                j2 = atomicLongFieldUpdater.get(this);
                if (j2 >= j4) {
                    break;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j2, j4));
            if (channelSegment2.id * BufferedChannelKt.SEGMENT_SIZE >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment2.cleanPrev();
            return null;
        }
        return channelSegment2;
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        Symbol symbol;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        ChannelSegment channelSegment = (ChannelSegment) f21457h.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f21453d;
            long j = atomicLongFieldUpdater.get(this);
            if (globalCellIndex < Math.max(this.f21461a + j, f21454e.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j, j + 1)) {
                int i = BufferedChannelKt.SEGMENT_SIZE;
                long j2 = j / i;
                int i2 = (int) (j % i);
                if (channelSegment.id != j2) {
                    ChannelSegment m5686d = m5686d(j2, channelSegment);
                    if (m5686d == null) {
                        continue;
                    } else {
                        channelSegment = m5686d;
                    }
                }
                Object m5699s = m5699s(channelSegment, i2, null, j);
                symbol = BufferedChannelKt.f21475m;
                if (m5699s == symbol) {
                    if (j < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                } else {
                    channelSegment.cleanPrev();
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, m5699s, null, 2, null)) != null) {
                        throw callUndeliveredElementCatchingException$default;
                    }
                }
            }
        }
    }

    /* renamed from: e */
    public final Throwable m5687e() {
        Throwable closeCause = getCloseCause();
        if (closeCause == null) {
            return new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
        return closeCause;
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x00cd, code lost:
    
        r11 = (kotlinx.coroutines.channels.ChannelSegment) r11.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m5688g(long j, boolean z) {
        Symbol symbol;
        Symbol symbol2;
        Waiter waiter;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        int i = (int) (j >> 60);
        if (i == 0 || i == 1) {
            return false;
        }
        if (i != 2) {
            if (i == 3) {
                ChannelSegment m5684b = m5684b(j & 1152921504606846975L);
                Function1<E, Unit> function1 = this.onUndeliveredElement;
                UndeliveredElementException undeliveredElementException = null;
                Object m8891constructorimpl$default = InlineList.m8891constructorimpl$default(null, 1, null);
                loop0: do {
                    int i2 = BufferedChannelKt.SEGMENT_SIZE - 1;
                    while (true) {
                        if (-1 >= i2) {
                            break;
                        }
                        long j2 = (m5684b.id * BufferedChannelKt.SEGMENT_SIZE) + i2;
                        while (true) {
                            Object state$kotlinx_coroutines_core = m5684b.getState$kotlinx_coroutines_core(i2);
                            symbol = BufferedChannelKt.f21469g;
                            if (state$kotlinx_coroutines_core == symbol) {
                                break loop0;
                            }
                            if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                                symbol2 = BufferedChannelKt.f21465c;
                                if (state$kotlinx_coroutines_core != symbol2 && state$kotlinx_coroutines_core != null) {
                                    if (!(state$kotlinx_coroutines_core instanceof Waiter) && !(state$kotlinx_coroutines_core instanceof o43)) {
                                        symbol3 = BufferedChannelKt.f21467e;
                                        if (state$kotlinx_coroutines_core == symbol3) {
                                            break loop0;
                                        }
                                        symbol4 = BufferedChannelKt.f21466d;
                                        if (state$kotlinx_coroutines_core == symbol4) {
                                            break loop0;
                                        }
                                        symbol5 = BufferedChannelKt.f21467e;
                                        if (state$kotlinx_coroutines_core != symbol5) {
                                            break;
                                        }
                                    } else {
                                        if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                            break loop0;
                                        }
                                        if (state$kotlinx_coroutines_core instanceof o43) {
                                            waiter = ((o43) state$kotlinx_coroutines_core).f23606a;
                                        } else {
                                            waiter = (Waiter) state$kotlinx_coroutines_core;
                                        }
                                        if (m5684b.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                            if (function1 != null) {
                                                undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, m5684b.getElement$kotlinx_coroutines_core(i2), undeliveredElementException);
                                            }
                                            m8891constructorimpl$default = InlineList.m8896plusFjFbRPM(m8891constructorimpl$default, waiter);
                                            m5684b.cleanElement$kotlinx_coroutines_core(i2);
                                            m5684b.onSlotCleaned();
                                        }
                                    }
                                } else if (m5684b.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    m5684b.onSlotCleaned();
                                    break;
                                }
                            } else {
                                if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                    break loop0;
                                }
                                if (m5684b.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    if (function1 != null) {
                                        undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, m5684b.getElement$kotlinx_coroutines_core(i2), undeliveredElementException);
                                    }
                                    m5684b.cleanElement$kotlinx_coroutines_core(i2);
                                    m5684b.onSlotCleaned();
                                }
                            }
                        }
                        i2--;
                    }
                } while (m5684b != null);
                if (m8891constructorimpl$default != null) {
                    if (!(m8891constructorimpl$default instanceof ArrayList)) {
                        m5695o((Waiter) m8891constructorimpl$default, false);
                    } else {
                        Intrinsics.checkNotNull(m8891constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                        ArrayList arrayList = (ArrayList) m8891constructorimpl$default;
                        for (int size = arrayList.size() - 1; -1 < size; size--) {
                            m5695o((Waiter) arrayList.get(size), false);
                        }
                    }
                }
                if (undeliveredElementException != null) {
                    throw undeliveredElementException;
                }
            } else {
                throw new IllegalStateException(ye0.m8291k(i, "unexpected close status: ").toString());
            }
        } else {
            m5684b(j & 1152921504606846975L);
            if (z && hasElements$kotlinx_coroutines_core()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final Throwable getCloseCause() {
        return (Throwable) f21459j.get(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceive() {
        C1307ii c1307ii = C1307ii.f18417h;
        Intrinsics.checkNotNull(c1307ii, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(c1307ii, 3);
        C1355ji c1355ji = C1355ji.f20507h;
        Intrinsics.checkNotNull(c1355ji, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(c1355ji, 3), this.f21462b);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        C1392ki c1392ki = C1392ki.f20858h;
        Intrinsics.checkNotNull(c1392ki, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(c1392ki, 3);
        C1512li c1512li = C1512li.f22509h;
        Intrinsics.checkNotNull(c1512li, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(c1512li, 3), this.f21462b);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        C1549mi c1549mi = C1549mi.f22943h;
        Intrinsics.checkNotNull(c1549mi, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(c1549mi, 3);
        C1586ni c1586ni = C1586ni.f23369h;
        Intrinsics.checkNotNull(c1586ni, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(c1586ni, 3), this.f21462b);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        C1623oi c1623oi = C1623oi.f23810h;
        Intrinsics.checkNotNull(c1623oi, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(c1623oi, 3);
        C1688pi c1688pi = C1688pi.f25182h;
        Intrinsics.checkNotNull(c1688pi, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(c1688pi, 3), null, 8, null);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return f21453d.get(this);
    }

    @NotNull
    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        if (closeCause == null) {
            return new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
        return closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return f21452c.get(this) & 1152921504606846975L;
    }

    /* renamed from: h */
    public final boolean m5689h() {
        long j = f21454e.get(this);
        if (j != 0 && j != Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21457h;
            ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = receiversCounter$kotlinx_coroutines_core / i;
            if (channelSegment.id != j && (channelSegment = m5686d(j, channelSegment)) == null) {
                if (((ChannelSegment) atomicReferenceFieldUpdater.get(this)).id < j) {
                    return false;
                }
            } else {
                channelSegment.cleanPrev();
                int i2 = (int) (receiversCounter$kotlinx_coroutines_core % i);
                while (true) {
                    Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i2);
                    if (state$kotlinx_coroutines_core != null) {
                        symbol2 = BufferedChannelKt.f21465c;
                        if (state$kotlinx_coroutines_core != symbol2) {
                            if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                                symbol3 = BufferedChannelKt.f21470h;
                                if (state$kotlinx_coroutines_core != symbol3 && state$kotlinx_coroutines_core != BufferedChannelKt.getCHANNEL_CLOSED()) {
                                    symbol4 = BufferedChannelKt.f21469g;
                                    if (state$kotlinx_coroutines_core != symbol4) {
                                        symbol5 = BufferedChannelKt.f21468f;
                                        if (state$kotlinx_coroutines_core != symbol5) {
                                            symbol6 = BufferedChannelKt.f21467e;
                                            if (state$kotlinx_coroutines_core != symbol6) {
                                                symbol7 = BufferedChannelKt.f21466d;
                                                if (state$kotlinx_coroutines_core != symbol7 && receiversCounter$kotlinx_coroutines_core == getReceiversCounter$kotlinx_coroutines_core()) {
                                                    return true;
                                                }
                                            } else {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            } else {
                                return true;
                            }
                        }
                    }
                    symbol = BufferedChannelKt.f21468f;
                    if (channelSegment.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, symbol)) {
                        m5685c();
                        break;
                    }
                }
                f21453d.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, receiversCounter$kotlinx_coroutines_core + 1);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5690i(long j, ChannelSegment channelSegment) {
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment3;
        while (channelSegment.id < j && (channelSegment3 = (ChannelSegment) channelSegment.getNext()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            if (!channelSegment.isRemoved() || (channelSegment2 = (ChannelSegment) channelSegment.getNext()) == null) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21458i;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id < channelSegment.id) {
                        if (!channelSegment.tryIncPointers$kotlinx_coroutines_core()) {
                            break;
                        }
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, channelSegment)) {
                            if (atomicReferenceFieldUpdater.get(this) != segment) {
                                if (channelSegment.decPointers$kotlinx_coroutines_core()) {
                                    channelSegment.remove();
                                }
                            }
                        }
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            channelSegment = channelSegment2;
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        do {
            atomicReferenceFieldUpdater = f21460k;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, handler)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            symbol = BufferedChannelKt.f21477o;
            if (obj == symbol) {
                symbol3 = BufferedChannelKt.f21477o;
                symbol4 = BufferedChannelKt.f21478p;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, symbol3, symbol4)) {
                    if (atomicReferenceFieldUpdater.get(this) != symbol3) {
                        break;
                    }
                }
                handler.invoke(getCloseCause());
                return;
            }
            symbol2 = BufferedChannelKt.f21478p;
            if (obj == symbol2) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return m5688g(f21452c.get(this), true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return m5688g(f21452c.get(this), false);
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (isClosedForReceive() || hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return !isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator<E> iterator() {
        return new C1413b(this);
    }

    /* renamed from: j */
    public final void m5691j(SelectInstance selectInstance, Object obj) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, obj, selectInstance.getContext());
        }
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* renamed from: k */
    public final Object m5692k(Object obj, Continuation continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj, null, 2, null)) != null) {
            ha0.addSuppressed(callUndeliveredElementCatchingException$default, getSendException());
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(callUndeliveredElementCatchingException$default)));
        } else {
            Throwable sendException = getSendException();
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(sendException)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m5693m(ChannelSegment channelSegment, int i, long j, Continuation continuation) {
        C1836ti c1836ti;
        int i2;
        Symbol symbol;
        Symbol symbol2;
        ChannelResult m8867boximpl;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        if (continuation instanceof C1836ti) {
            c1836ti = (C1836ti) continuation;
            int i3 = c1836ti.f26817f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c1836ti.f26817f = i3 - Integer.MIN_VALUE;
                Object obj = c1836ti.f26815d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i2 = c1836ti.f26817f;
                if (i2 == 0) {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    c1836ti.f26817f = 1;
                    CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(c1836ti));
                    try {
                        Intrinsics.checkNotNull(orCreateCancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");
                        d92 d92Var = new d92(orCreateCancellableContinuation);
                        Object m5699s = m5699s(channelSegment, i, d92Var, j);
                        symbol = BufferedChannelKt.f21473k;
                        if (m5699s != symbol) {
                            symbol2 = BufferedChannelKt.f21475m;
                            Function1<Throwable, Unit> function1 = null;
                            if (m5699s == symbol2) {
                                if (j < getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment.cleanPrev();
                                }
                                ChannelSegment channelSegment2 = (ChannelSegment) f21457h.get(this);
                                while (true) {
                                    if (isClosedForReceive()) {
                                        access$onClosedReceiveCatchingOnNoWaiterSuspend(this, orCreateCancellableContinuation);
                                        break;
                                    }
                                    long andIncrement = f21453d.getAndIncrement(this);
                                    long j2 = BufferedChannelKt.SEGMENT_SIZE;
                                    long j3 = andIncrement / j2;
                                    int i4 = (int) (andIncrement % j2);
                                    if (channelSegment2.id != j3) {
                                        ChannelSegment m5686d = m5686d(j3, channelSegment2);
                                        if (m5686d != null) {
                                            channelSegment2 = m5686d;
                                        }
                                    }
                                    Object m5699s2 = m5699s(channelSegment2, i4, d92Var, andIncrement);
                                    symbol3 = BufferedChannelKt.f21473k;
                                    if (m5699s2 != symbol3) {
                                        symbol4 = BufferedChannelKt.f21475m;
                                        if (m5699s2 != symbol4) {
                                            symbol5 = BufferedChannelKt.f21474l;
                                            if (m5699s2 != symbol5) {
                                                channelSegment2.cleanPrev();
                                                m8867boximpl = ChannelResult.m8867boximpl(ChannelResult.INSTANCE.m8882successJP2dKIU(m5699s2));
                                                Function1<E, Unit> function12 = this.onUndeliveredElement;
                                                if (function12 != null) {
                                                    function1 = OnUndeliveredElementKt.bindCancellationFun(function12, m5699s2, orCreateCancellableContinuation.getContext());
                                                }
                                            } else {
                                                throw new IllegalStateException("unexpected");
                                            }
                                        } else if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                            channelSegment2.cleanPrev();
                                        }
                                    } else {
                                        access$prepareReceiverForSuspension(this, d92Var, channelSegment2, i4);
                                        break;
                                    }
                                }
                            } else {
                                channelSegment.cleanPrev();
                                m8867boximpl = ChannelResult.m8867boximpl(ChannelResult.INSTANCE.m8882successJP2dKIU(m5699s));
                                Function1<E, Unit> function13 = this.onUndeliveredElement;
                                if (function13 != null) {
                                    function1 = OnUndeliveredElementKt.bindCancellationFun(function13, m5699s, orCreateCancellableContinuation.getContext());
                                }
                            }
                            orCreateCancellableContinuation.resume(m8867boximpl, function1);
                        } else {
                            access$prepareReceiverForSuspension(this, d92Var, channelSegment, i);
                        }
                        obj = orCreateCancellableContinuation.getResult();
                        if (obj == b51.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(c1836ti);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th) {
                        orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                        throw th;
                    }
                }
                return ((ChannelResult) obj).getHolder();
            }
        }
        c1836ti = new C1836ti(this, continuation);
        Object obj2 = c1836ti.f26815d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i2 = c1836ti.f26817f;
        if (i2 == 0) {
        }
        return ((ChannelResult) obj2).getHolder();
    }

    /* renamed from: n */
    public final Object m5694n(ChannelSegment channelSegment, int i, long j, Continuation continuation) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        try {
            Object m5699s = m5699s(channelSegment, i, orCreateCancellableContinuation, j);
            symbol = BufferedChannelKt.f21473k;
            if (m5699s != symbol) {
                symbol2 = BufferedChannelKt.f21475m;
                Function1<Throwable, Unit> function1 = null;
                function1 = null;
                CancellableContinuationImpl cancellableContinuationImpl = null;
                if (m5699s == symbol2) {
                    if (j < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    ChannelSegment channelSegment2 = (ChannelSegment) f21457h.get(this);
                    while (true) {
                        if (isClosedForReceive()) {
                            access$onClosedReceiveOnNoWaiterSuspend(this, orCreateCancellableContinuation);
                            break;
                        }
                        long andIncrement = f21453d.getAndIncrement(this);
                        int i2 = BufferedChannelKt.SEGMENT_SIZE;
                        long j2 = andIncrement / i2;
                        int i3 = (int) (andIncrement % i2);
                        if (channelSegment2.id != j2) {
                            ChannelSegment m5686d = m5686d(j2, channelSegment2);
                            if (m5686d != null) {
                                channelSegment2 = m5686d;
                            }
                        }
                        m5699s = m5699s(channelSegment2, i3, orCreateCancellableContinuation, andIncrement);
                        symbol3 = BufferedChannelKt.f21473k;
                        if (m5699s != symbol3) {
                            symbol4 = BufferedChannelKt.f21475m;
                            if (m5699s != symbol4) {
                                symbol5 = BufferedChannelKt.f21474l;
                                if (m5699s != symbol5) {
                                    channelSegment2.cleanPrev();
                                    Function1<E, Unit> function12 = this.onUndeliveredElement;
                                    if (function12 != null) {
                                        function1 = OnUndeliveredElementKt.bindCancellationFun(function12, m5699s, orCreateCancellableContinuation.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected");
                                }
                            } else if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment2.cleanPrev();
                            }
                        } else {
                            if (orCreateCancellableContinuation instanceof Waiter) {
                                cancellableContinuationImpl = orCreateCancellableContinuation;
                            }
                            if (cancellableContinuationImpl != null) {
                                access$prepareReceiverForSuspension(this, cancellableContinuationImpl, channelSegment2, i3);
                            }
                        }
                    }
                } else {
                    channelSegment.cleanPrev();
                    Function1<E, Unit> function13 = this.onUndeliveredElement;
                    if (function13 != null) {
                        function1 = OnUndeliveredElementKt.bindCancellationFun(function13, m5699s, orCreateCancellableContinuation.getContext());
                    }
                }
                orCreateCancellableContinuation.resume(m5699s, function1);
            } else {
                access$prepareReceiverForSuspension(this, orCreateCancellableContinuation, channelSegment, i);
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

    /* renamed from: o */
    public final void m5695o(Waiter waiter, boolean z) {
        Throwable sendException;
        if (waiter instanceof C1270hi) {
            CancellableContinuationImpl cancellableContinuationImpl = ((C1270hi) waiter).f18061a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(Boolean.FALSE));
            return;
        }
        if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.INSTANCE;
            if (z) {
                sendException = m5687e();
            } else {
                sendException = getSendException();
            }
            continuation.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(sendException)));
            return;
        }
        if (waiter instanceof d92) {
            CancellableContinuationImpl cancellableContinuationImpl2 = ((d92) waiter).f16302a;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m8512constructorimpl(ChannelResult.m8867boximpl(ChannelResult.INSTANCE.m8880closedJP2dKIU(getCloseCause()))));
            return;
        }
        if (waiter instanceof C1413b) {
            C1413b c1413b = (C1413b) waiter;
            CancellableContinuationImpl cancellableContinuationImpl3 = c1413b.f21492b;
            Intrinsics.checkNotNull(cancellableContinuationImpl3);
            c1413b.f21492b = null;
            c1413b.f21491a = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = c1413b.f21493c.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion4 = Result.INSTANCE;
                cancellableContinuationImpl3.resumeWith(Result.m8512constructorimpl(Boolean.FALSE));
                return;
            } else {
                Result.Companion companion5 = Result.INSTANCE;
                cancellableContinuationImpl3.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(closeCause)));
                return;
            }
        }
        if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return Channel.DefaultImpls.offer(this, e);
    }

    public void onClosedIdempotent() {
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m5696p(ChannelSegment channelSegment, int i, Object obj, long j, Continuation continuation) {
        Object m8512constructorimpl;
        Object result;
        ChannelSegment channelSegment2;
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        try {
            int access$updateCellSend = access$updateCellSend(this, channelSegment, i, obj, j, orCreateCancellableContinuation, false);
            if (access$updateCellSend != 0) {
                if (access$updateCellSend != 1) {
                    if (access$updateCellSend != 2) {
                        if (access$updateCellSend != 4) {
                            if (access$updateCellSend == 5) {
                                channelSegment.cleanPrev();
                                ChannelSegment channelSegment3 = (ChannelSegment) f21456g.get(this);
                                while (true) {
                                    long andIncrement = f21452c.getAndIncrement(this);
                                    long j2 = andIncrement & 1152921504606846975L;
                                    boolean m5688g = m5688g(andIncrement, false);
                                    int i2 = BufferedChannelKt.SEGMENT_SIZE;
                                    long j3 = j2 / i2;
                                    int i3 = (int) (j2 % i2);
                                    if (channelSegment3.id != j3) {
                                        ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j3, channelSegment3);
                                        if (access$findSegmentSend == null) {
                                            if (m5688g) {
                                                break;
                                            }
                                        } else {
                                            channelSegment2 = access$findSegmentSend;
                                        }
                                    } else {
                                        channelSegment2 = channelSegment3;
                                    }
                                    ChannelSegment channelSegment4 = channelSegment2;
                                    int access$updateCellSend2 = access$updateCellSend(this, channelSegment2, i3, obj, j2, orCreateCancellableContinuation, m5688g);
                                    if (access$updateCellSend2 != 0) {
                                        if (access$updateCellSend2 != 1) {
                                            if (access$updateCellSend2 != 2) {
                                                if (access$updateCellSend2 != 3) {
                                                    if (access$updateCellSend2 != 4) {
                                                        if (access$updateCellSend2 == 5) {
                                                            channelSegment4.cleanPrev();
                                                        }
                                                        channelSegment3 = channelSegment4;
                                                    } else if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                                        channelSegment4.cleanPrev();
                                                    }
                                                } else {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                            } else if (m5688g) {
                                                channelSegment4.onSlotCleaned();
                                            } else {
                                                if (orCreateCancellableContinuation instanceof Waiter) {
                                                    cancellableContinuationImpl = orCreateCancellableContinuation;
                                                } else {
                                                    cancellableContinuationImpl = null;
                                                }
                                                if (cancellableContinuationImpl != null) {
                                                    access$prepareSenderForSuspension(this, cancellableContinuationImpl, channelSegment4, i3);
                                                }
                                            }
                                        } else {
                                            Result.Companion companion = Result.INSTANCE;
                                            m8512constructorimpl = Result.m8512constructorimpl(Unit.INSTANCE);
                                            break;
                                        }
                                    } else {
                                        channelSegment4.cleanPrev();
                                        Result.Companion companion2 = Result.INSTANCE;
                                        m8512constructorimpl = Result.m8512constructorimpl(Unit.INSTANCE);
                                        break;
                                    }
                                }
                            } else {
                                throw new IllegalStateException("unexpected");
                            }
                        } else if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        access$onClosedSendOnNoWaiterSuspend(this, obj, orCreateCancellableContinuation);
                    } else {
                        access$prepareSenderForSuspension(this, orCreateCancellableContinuation, channelSegment, i);
                    }
                    result = orCreateCancellableContinuation.getResult();
                    if (result == b51.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    if (result != b51.getCOROUTINE_SUSPENDED()) {
                        return result;
                    }
                    return Unit.INSTANCE;
                }
                Result.Companion companion3 = Result.INSTANCE;
                m8512constructorimpl = Result.m8512constructorimpl(Unit.INSTANCE);
            } else {
                channelSegment.cleanPrev();
                Result.Companion companion4 = Result.INSTANCE;
                m8512constructorimpl = Result.m8512constructorimpl(Unit.INSTANCE);
            }
            orCreateCancellableContinuation.resumeWith(m8512constructorimpl);
            result = orCreateCancellableContinuation.getResult();
            if (result == b51.getCOROUTINE_SUSPENDED()) {
            }
            if (result != b51.getCOROUTINE_SUSPENDED()) {
            }
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return (E) Channel.DefaultImpls.poll(this);
    }

    /* renamed from: q */
    public final boolean m5697q(Object obj, Object obj2) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, obj2);
        }
        Function1<Throwable, Unit> function1 = null;
        if (obj instanceof d92) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            d92 d92Var = (d92) obj;
            CancellableContinuationImpl cancellableContinuationImpl = d92Var.f16302a;
            ChannelResult m8867boximpl = ChannelResult.m8867boximpl(ChannelResult.INSTANCE.m8882successJP2dKIU(obj2));
            Function1<E, Unit> function12 = this.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, obj2, d92Var.f16302a.getContext());
            }
            return BufferedChannelKt.access$tryResume0(cancellableContinuationImpl, m8867boximpl, function1);
        }
        if (obj instanceof C1413b) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            C1413b c1413b = (C1413b) obj;
            CancellableContinuationImpl cancellableContinuationImpl2 = c1413b.f21492b;
            Intrinsics.checkNotNull(cancellableContinuationImpl2);
            c1413b.f21492b = null;
            c1413b.f21491a = obj2;
            Boolean bool = Boolean.TRUE;
            Function1<E, Unit> function13 = c1413b.f21493c.onUndeliveredElement;
            if (function13 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function13, obj2, cancellableContinuationImpl2.getContext());
            }
            return BufferedChannelKt.access$tryResume0(cancellableContinuationImpl2, bool, function1);
        }
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Function1<E, Unit> function14 = this.onUndeliveredElement;
            if (function14 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function14, obj2, cancellableContinuation.getContext());
            }
            return BufferedChannelKt.access$tryResume0(cancellableContinuation, obj2, function1);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    /* renamed from: r */
    public final boolean m5698r(Object obj, ChannelSegment channelSegment, int i) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Unit unit = Unit.INSTANCE;
            ChannelSegment channelSegment2 = BufferedChannelKt.f21463a;
            Object tryResume = cancellableContinuation.tryResume(unit, null, null);
            if (tryResume == null) {
                return false;
            }
            cancellableContinuation.completeResume(tryResume);
        } else if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
            }
            if (trySelectDetailed != TrySelectDetailedResult.SUCCESSFUL) {
                return false;
            }
        } else if (obj instanceof C1270hi) {
            CancellableContinuationImpl cancellableContinuationImpl = ((C1270hi) obj).f18061a;
            Boolean bool = Boolean.TRUE;
            ChannelSegment channelSegment3 = BufferedChannelKt.f21463a;
            Object tryResume2 = cancellableContinuationImpl.tryResume(bool, null, null);
            if (tryResume2 == null) {
                return false;
            }
            cancellableContinuationImpl.completeResume(tryResume2);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        return true;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receive(@NotNull Continuation<? super E> continuation) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        ChannelSegment channelSegment = (ChannelSegment) f21457h.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = f21453d.getAndIncrement(this);
            long j = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / j;
            int i = (int) (andIncrement % j);
            if (channelSegment.id != j2) {
                ChannelSegment m5686d = m5686d(j2, channelSegment);
                if (m5686d == null) {
                    continue;
                } else {
                    channelSegment = m5686d;
                }
            }
            Object m5699s = m5699s(channelSegment, i, null, andIncrement);
            symbol = BufferedChannelKt.f21473k;
            if (m5699s != symbol) {
                symbol2 = BufferedChannelKt.f21475m;
                if (m5699s != symbol2) {
                    symbol3 = BufferedChannelKt.f21474l;
                    if (m5699s == symbol3) {
                        return m5694n(channelSegment, i, andIncrement, continuation);
                    }
                    channelSegment.cleanPrev();
                    return m5699s;
                }
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else {
                throw new IllegalStateException("unexpected");
            }
        }
        throw StackTraceRecoveryKt.recoverStackTrace(m5687e());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo8860receiveCatchingJP2dKIU(@NotNull Continuation<? super ChannelResult<? extends E>> continuation) {
        return m5682l(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    @Nullable
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
    
        r14.selectInRegistrationPhase(kotlin.Unit.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void registerSelectForSend(@NotNull SelectInstance<?> select, @Nullable Object element) {
        Waiter waiter;
        ChannelSegment channelSegment = (ChannelSegment) f21456g.get(this);
        while (true) {
            long andIncrement = f21452c.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean m5688g = m5688g(andIncrement, false);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (channelSegment.id != j2) {
                ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j2, channelSegment);
                if (access$findSegmentSend == null) {
                    if (m5688g) {
                        break;
                    }
                } else {
                    channelSegment = access$findSegmentSend;
                }
            }
            int access$updateCellSend = access$updateCellSend(this, channelSegment, i2, element, j, select, m5688g);
            if (access$updateCellSend != 0) {
                if (access$updateCellSend == 1) {
                    break;
                }
                if (access$updateCellSend != 2) {
                    if (access$updateCellSend != 3) {
                        if (access$updateCellSend != 4) {
                            if (access$updateCellSend == 5) {
                                channelSegment.cleanPrev();
                            }
                        } else if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                    } else {
                        throw new IllegalStateException("unexpected");
                    }
                } else if (m5688g) {
                    channelSegment.onSlotCleaned();
                } else {
                    if (select instanceof Waiter) {
                        waiter = (Waiter) select;
                    } else {
                        waiter = null;
                    }
                    if (waiter != null) {
                        access$prepareSenderForSuspension(this, waiter, channelSegment, i2);
                        return;
                    }
                    return;
                }
            } else {
                channelSegment.cleanPrev();
                break;
            }
        }
        m5691j(select, element);
    }

    /* renamed from: s */
    public final Object m5699s(ChannelSegment channelSegment, int i, Object obj, long j) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        Symbol symbol8;
        Symbol symbol9;
        Symbol symbol10;
        Symbol symbol11;
        Symbol symbol12;
        Symbol symbol13;
        Symbol symbol14;
        Symbol symbol15;
        Symbol symbol16;
        Symbol symbol17;
        Symbol symbol18;
        Symbol symbol19;
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f21452c;
        if (state$kotlinx_coroutines_core == null) {
            if (j >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    symbol19 = BufferedChannelKt.f21474l;
                    return symbol19;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                    m5685c();
                    symbol18 = BufferedChannelKt.f21473k;
                    return symbol18;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
            symbol = BufferedChannelKt.f21469g;
            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol)) {
                m5685c();
                return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
            }
        }
        while (true) {
            Object state$kotlinx_coroutines_core2 = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core2 != null) {
                symbol6 = BufferedChannelKt.f21465c;
                if (state$kotlinx_coroutines_core2 != symbol6) {
                    if (state$kotlinx_coroutines_core2 == BufferedChannelKt.BUFFERED) {
                        symbol7 = BufferedChannelKt.f21469g;
                        if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, symbol7)) {
                            m5685c();
                            return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                        }
                    } else {
                        symbol8 = BufferedChannelKt.f21470h;
                        if (state$kotlinx_coroutines_core2 == symbol8) {
                            symbol9 = BufferedChannelKt.f21475m;
                            return symbol9;
                        }
                        symbol10 = BufferedChannelKt.f21468f;
                        if (state$kotlinx_coroutines_core2 == symbol10) {
                            symbol11 = BufferedChannelKt.f21475m;
                            return symbol11;
                        }
                        if (state$kotlinx_coroutines_core2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                            symbol13 = BufferedChannelKt.f21467e;
                            if (state$kotlinx_coroutines_core2 != symbol13) {
                                symbol14 = BufferedChannelKt.f21466d;
                                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, symbol14)) {
                                    boolean z = state$kotlinx_coroutines_core2 instanceof o43;
                                    if (z) {
                                        state$kotlinx_coroutines_core2 = ((o43) state$kotlinx_coroutines_core2).f23606a;
                                    }
                                    if (m5698r(state$kotlinx_coroutines_core2, channelSegment, i)) {
                                        symbol17 = BufferedChannelKt.f21469g;
                                        channelSegment.setState$kotlinx_coroutines_core(i, symbol17);
                                        m5685c();
                                        return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                                    }
                                    symbol15 = BufferedChannelKt.f21470h;
                                    channelSegment.setState$kotlinx_coroutines_core(i, symbol15);
                                    channelSegment.onCancelledRequest(i, false);
                                    if (z) {
                                        m5685c();
                                    }
                                    symbol16 = BufferedChannelKt.f21475m;
                                    return symbol16;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            m5685c();
                            symbol12 = BufferedChannelKt.f21475m;
                            return symbol12;
                        }
                    }
                }
            }
            if (j < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                symbol2 = BufferedChannelKt.f21468f;
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, symbol2)) {
                    m5685c();
                    symbol3 = BufferedChannelKt.f21475m;
                    return symbol3;
                }
            } else {
                if (obj == null) {
                    symbol4 = BufferedChannelKt.f21474l;
                    return symbol4;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, obj)) {
                    m5685c();
                    symbol5 = BufferedChannelKt.f21473k;
                    return symbol5;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(E e, @NotNull Continuation<? super Unit> continuation) {
        ChannelSegment channelSegment = (ChannelSegment) f21456g.get(this);
        while (true) {
            long andIncrement = f21452c.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean m5688g = m5688g(andIncrement, false);
            long j2 = BufferedChannelKt.SEGMENT_SIZE;
            long j3 = j / j2;
            int i = (int) (j % j2);
            if (channelSegment.id != j3) {
                ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j3, channelSegment);
                if (access$findSegmentSend == null) {
                    if (m5688g) {
                        Object m5692k = m5692k(e, continuation);
                        if (m5692k == b51.getCOROUTINE_SUSPENDED()) {
                            return m5692k;
                        }
                    }
                } else {
                    channelSegment = access$findSegmentSend;
                }
            }
            int access$updateCellSend = access$updateCellSend(this, channelSegment, i, e, j, null, m5688g);
            if (access$updateCellSend != 0) {
                if (access$updateCellSend == 1) {
                    break;
                }
                if (access$updateCellSend != 2) {
                    if (access$updateCellSend != 3) {
                        if (access$updateCellSend != 4) {
                            if (access$updateCellSend == 5) {
                                channelSegment.cleanPrev();
                            }
                        } else {
                            if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            Object m5692k2 = m5692k(e, continuation);
                            if (m5692k2 == b51.getCOROUTINE_SUSPENDED()) {
                                return m5692k2;
                            }
                        }
                    } else {
                        Object m5696p = m5696p(channelSegment, i, e, j, continuation);
                        if (m5696p == b51.getCOROUTINE_SUSPENDED()) {
                            return m5696p;
                        }
                    }
                } else if (m5688g) {
                    channelSegment.onSlotCleaned();
                    Object m5692k3 = m5692k(e, continuation);
                    if (m5692k3 == b51.getCOROUTINE_SUSPENDED()) {
                        return m5692k3;
                    }
                }
            } else {
                channelSegment.cleanPrev();
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a5, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r9.resumeWith(kotlin.Result.m8512constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)));
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sendBroadcast$kotlinx_coroutines_core(E e, @NotNull Continuation<? super Boolean> continuation) {
        ChannelSegment channelSegment;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (this.onUndeliveredElement == null) {
            C1270hi c1270hi = new C1270hi(cancellableContinuationImpl);
            ChannelSegment channelSegment2 = (ChannelSegment) f21456g.get(this);
            while (true) {
                long andIncrement = f21452c.getAndIncrement(this);
                long j = andIncrement & 1152921504606846975L;
                boolean m5688g = m5688g(andIncrement, false);
                long j2 = BufferedChannelKt.SEGMENT_SIZE;
                long j3 = j / j2;
                int i = (int) (j % j2);
                if (channelSegment2.id != j3) {
                    ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j3, channelSegment2);
                    if (access$findSegmentSend == null) {
                        if (m5688g) {
                            break;
                        }
                    } else {
                        channelSegment = access$findSegmentSend;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                ChannelSegment channelSegment3 = channelSegment;
                int access$updateCellSend = access$updateCellSend(this, channelSegment, i, e, j, c1270hi, m5688g);
                if (access$updateCellSend != 0) {
                    if (access$updateCellSend == 1) {
                        break;
                    }
                    if (access$updateCellSend != 2) {
                        if (access$updateCellSend != 3) {
                            if (access$updateCellSend != 4) {
                                if (access$updateCellSend == 5) {
                                    channelSegment3.cleanPrev();
                                }
                                channelSegment2 = channelSegment3;
                            } else if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment3.cleanPrev();
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else if (m5688g) {
                        channelSegment3.onSlotCleaned();
                    } else {
                        access$prepareSenderForSuspension(this, c1270hi, channelSegment3, i);
                    }
                } else {
                    channelSegment3.cleanPrev();
                    break;
                }
            }
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(Boxing.boxBoolean(false)));
            Object result = cancellableContinuationImpl.getResult();
            if (result == b51.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`");
    }

    public final <R> R sendImpl(E element, @Nullable Object waiter, @NotNull Function0<? extends R> onRendezvousOrBuffered, @NotNull Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> onSuspend, @NotNull Function0<? extends R> onClosed, @NotNull Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> onNoWaiterSuspend) {
        ChannelSegment channelSegment;
        Waiter waiter2;
        ChannelSegment channelSegment2 = (ChannelSegment) f21456g.get(this);
        while (true) {
            long andIncrement = f21452c.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean m5688g = m5688g(andIncrement, false);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (channelSegment2.id != j2) {
                ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j2, channelSegment2);
                if (access$findSegmentSend == null) {
                    if (m5688g) {
                        return onClosed.invoke();
                    }
                } else {
                    channelSegment = access$findSegmentSend;
                }
            } else {
                channelSegment = channelSegment2;
            }
            int access$updateCellSend = access$updateCellSend(this, channelSegment, i2, element, j, waiter, m5688g);
            if (access$updateCellSend != 0) {
                if (access$updateCellSend != 1) {
                    if (access$updateCellSend != 2) {
                        if (access$updateCellSend != 3) {
                            if (access$updateCellSend != 4) {
                                if (access$updateCellSend == 5) {
                                    channelSegment.cleanPrev();
                                }
                                channelSegment2 = channelSegment;
                            } else {
                                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                                    channelSegment.cleanPrev();
                                }
                                return onClosed.invoke();
                            }
                        } else {
                            return onNoWaiterSuspend.invoke(channelSegment, Integer.valueOf(i2), element, Long.valueOf(j));
                        }
                    } else {
                        if (m5688g) {
                            channelSegment.onSlotCleaned();
                            return onClosed.invoke();
                        }
                        if (waiter instanceof Waiter) {
                            waiter2 = (Waiter) waiter;
                        } else {
                            waiter2 = null;
                        }
                        if (waiter2 != null) {
                            access$prepareSenderForSuspension(this, waiter2, channelSegment, i2);
                        }
                        return onSuspend.invoke(channelSegment, Integer.valueOf(i2));
                    }
                } else {
                    return onRendezvousOrBuffered.invoke();
                }
            } else {
                channelSegment.cleanPrev();
                return onRendezvousOrBuffered.invoke();
            }
        }
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        if (m5688g(f21452c.get(this), false)) {
            return false;
        }
        return !m5683a(r0 & 1152921504606846975L);
    }

    /* renamed from: t */
    public final int m5700t(ChannelSegment channelSegment, int i, Object obj, long j, Object obj2, boolean z) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core != null) {
                symbol2 = BufferedChannelKt.f21465c;
                if (state$kotlinx_coroutines_core != symbol2) {
                    symbol3 = BufferedChannelKt.f21471i;
                    if (state$kotlinx_coroutines_core != symbol3) {
                        symbol4 = BufferedChannelKt.f21468f;
                        if (state$kotlinx_coroutines_core == symbol4) {
                            channelSegment.cleanElement$kotlinx_coroutines_core(i);
                            return 5;
                        }
                        if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            channelSegment.cleanElement$kotlinx_coroutines_core(i);
                            isClosedForSend();
                            return 4;
                        }
                        channelSegment.cleanElement$kotlinx_coroutines_core(i);
                        if (state$kotlinx_coroutines_core instanceof o43) {
                            state$kotlinx_coroutines_core = ((o43) state$kotlinx_coroutines_core).f23606a;
                        }
                        if (m5697q(state$kotlinx_coroutines_core, obj)) {
                            symbol7 = BufferedChannelKt.f21469g;
                            channelSegment.setState$kotlinx_coroutines_core(i, symbol7);
                            onReceiveDequeued();
                            return 0;
                        }
                        symbol5 = BufferedChannelKt.f21471i;
                        Object andSetState$kotlinx_coroutines_core = channelSegment.getAndSetState$kotlinx_coroutines_core(i, symbol5);
                        symbol6 = BufferedChannelKt.f21471i;
                        if (andSetState$kotlinx_coroutines_core != symbol6) {
                            channelSegment.onCancelledRequest(i, true);
                        }
                        return 5;
                    }
                    channelSegment.cleanElement$kotlinx_coroutines_core(i);
                    return 5;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (m5683a(j) && !z) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (z) {
                symbol = BufferedChannelKt.f21470h;
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, symbol)) {
                    channelSegment.onCancelledRequest(i, false);
                    return 4;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, obj2)) {
                    return 2;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x01d1, code lost:
    
        r3 = (kotlinx.coroutines.channels.ChannelSegment) r3.getNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01d8, code lost:
    
        if (r3 != null) goto L98;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        Symbol symbol;
        Symbol symbol2;
        boolean areEqual;
        Symbol symbol3;
        boolean areEqual2;
        Symbol symbol4;
        boolean areEqual3;
        Symbol symbol5;
        boolean areEqual4;
        Symbol symbol6;
        boolean areEqual5;
        Symbol symbol7;
        boolean areEqual6;
        boolean areEqual7;
        String obj;
        ChannelSegment channelSegment;
        StringBuilder sb = new StringBuilder();
        int i = (int) (f21452c.get(this) >> 60);
        if (i != 2) {
            if (i == 3) {
                sb.append("cancelled,");
            }
        } else {
            sb.append("closed,");
        }
        sb.append("capacity=" + this.f21461a + ',');
        sb.append("data=[");
        int i2 = 0;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ChannelSegment[]{f21457h.get(this), f21456g.get(this), f21458i.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listOf) {
            ChannelSegment channelSegment2 = (ChannelSegment) obj2;
            channelSegment = BufferedChannelKt.f21463a;
            if (channelSegment2 != channelSegment) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long j = ((ChannelSegment) next).id;
                do {
                    Object next2 = it.next();
                    long j2 = ((ChannelSegment) next2).id;
                    if (j > j2) {
                        next = next2;
                        j = j2;
                    }
                } while (it.hasNext());
            }
            ChannelSegment channelSegment3 = (ChannelSegment) next;
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            long sendersCounter$kotlinx_coroutines_core = getSendersCounter$kotlinx_coroutines_core();
            loop2: while (true) {
                int i3 = BufferedChannelKt.SEGMENT_SIZE;
                int i4 = i2;
                while (true) {
                    if (i4 >= i3) {
                        break;
                    }
                    long j3 = (channelSegment3.id * BufferedChannelKt.SEGMENT_SIZE) + i4;
                    if (j3 >= sendersCounter$kotlinx_coroutines_core && j3 >= receiversCounter$kotlinx_coroutines_core) {
                        break loop2;
                    }
                    Object state$kotlinx_coroutines_core = channelSegment3.getState$kotlinx_coroutines_core(i4);
                    Object element$kotlinx_coroutines_core = channelSegment3.getElement$kotlinx_coroutines_core(i4);
                    if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                        if (j3 < receiversCounter$kotlinx_coroutines_core && j3 >= sendersCounter$kotlinx_coroutines_core) {
                            obj = "receive";
                        } else if (j3 < sendersCounter$kotlinx_coroutines_core && j3 >= receiversCounter$kotlinx_coroutines_core) {
                            obj = "send";
                        } else {
                            obj = "cont";
                        }
                    } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                        if (j3 < receiversCounter$kotlinx_coroutines_core && j3 >= sendersCounter$kotlinx_coroutines_core) {
                            obj = "onReceive";
                        } else if (j3 < sendersCounter$kotlinx_coroutines_core && j3 >= receiversCounter$kotlinx_coroutines_core) {
                            obj = "onSend";
                        } else {
                            obj = "select";
                        }
                    } else if (state$kotlinx_coroutines_core instanceof d92) {
                        obj = "receiveCatching";
                    } else if (state$kotlinx_coroutines_core instanceof C1270hi) {
                        obj = "sendBroadcast";
                    } else if (!(state$kotlinx_coroutines_core instanceof o43)) {
                        symbol = BufferedChannelKt.f21466d;
                        if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol)) {
                            symbol2 = BufferedChannelKt.f21467e;
                            areEqual = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol2);
                        } else {
                            areEqual = true;
                        }
                        if (areEqual) {
                            obj = "resuming_sender";
                        } else {
                            if (state$kotlinx_coroutines_core != null) {
                                symbol3 = BufferedChannelKt.f21465c;
                                areEqual2 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol3);
                            } else {
                                areEqual2 = true;
                            }
                            if (!areEqual2) {
                                symbol4 = BufferedChannelKt.f21469g;
                                areEqual3 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol4);
                            } else {
                                areEqual3 = true;
                            }
                            if (!areEqual3) {
                                symbol5 = BufferedChannelKt.f21468f;
                                areEqual4 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol5);
                            } else {
                                areEqual4 = true;
                            }
                            if (!areEqual4) {
                                symbol6 = BufferedChannelKt.f21471i;
                                areEqual5 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol6);
                            } else {
                                areEqual5 = true;
                            }
                            if (!areEqual5) {
                                symbol7 = BufferedChannelKt.f21470h;
                                areEqual6 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol7);
                            } else {
                                areEqual6 = true;
                            }
                            if (areEqual6) {
                                areEqual7 = true;
                            } else {
                                areEqual7 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED());
                            }
                            if (!areEqual7) {
                                obj = state$kotlinx_coroutines_core.toString();
                            } else {
                                i4++;
                            }
                        }
                    } else {
                        obj = "EB(" + state$kotlinx_coroutines_core + ')';
                    }
                    if (element$kotlinx_coroutines_core != null) {
                        sb.append("(" + obj + ',' + element$kotlinx_coroutines_core + "),");
                    } else {
                        sb.append(obj + ',');
                    }
                    i4++;
                }
                i2 = 0;
            }
            if (StringsKt___StringsKt.last(sb) == ',') {
                Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(sb.length() - 1), "this.deleteCharAt(index)");
            }
            sb.append("]");
            return sb.toString();
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final String toStringDebug$kotlinx_coroutines_core() {
        String str;
        String str2;
        String valueOf;
        ChannelSegment channelSegment;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("S=");
        sb2.append(getSendersCounter$kotlinx_coroutines_core());
        sb2.append(",R=");
        sb2.append(getReceiversCounter$kotlinx_coroutines_core());
        sb2.append(",B=");
        sb2.append(f21454e.get(this));
        sb2.append(",B'=");
        sb2.append(f21455f.get(this));
        sb2.append(",C=");
        AtomicLongFieldUpdater atomicLongFieldUpdater = f21452c;
        sb2.append((int) (atomicLongFieldUpdater.get(this) >> 60));
        sb2.append(',');
        sb.append(sb2.toString());
        int i = (int) (atomicLongFieldUpdater.get(this) >> 60);
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    sb.append("CANCELLED,");
                }
            } else {
                sb.append("CLOSED,");
            }
        } else {
            sb.append("CANCELLATION_STARTED,");
        }
        StringBuilder sb3 = new StringBuilder("SEND_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21456g;
        sb3.append(DebugStringsKt.getHexAddress(atomicReferenceFieldUpdater.get(this)));
        sb3.append(",RCV_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f21457h;
        sb3.append(DebugStringsKt.getHexAddress(atomicReferenceFieldUpdater2.get(this)));
        sb.append(sb3.toString());
        boolean m5689h = m5689h();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f21458i;
        if (!m5689h) {
            sb.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(atomicReferenceFieldUpdater3.get(this)));
        }
        sb.append("  ");
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ChannelSegment[]{atomicReferenceFieldUpdater2.get(this), atomicReferenceFieldUpdater.get(this), atomicReferenceFieldUpdater3.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            ChannelSegment channelSegment2 = (ChannelSegment) obj;
            channelSegment = BufferedChannelKt.f21463a;
            if (channelSegment2 != channelSegment) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long j = ((ChannelSegment) next).id;
                do {
                    Object next2 = it.next();
                    long j2 = ((ChannelSegment) next2).id;
                    if (j > j2) {
                        next = next2;
                        j = j2;
                    }
                } while (it.hasNext());
            }
            ChannelSegment channelSegment3 = (ChannelSegment) next;
            do {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(DebugStringsKt.getHexAddress(channelSegment3));
                sb4.append("=[");
                if (channelSegment3.isRemoved()) {
                    str = "*";
                } else {
                    str = "";
                }
                sb4.append(str);
                sb4.append(channelSegment3.id);
                sb4.append(",prev=");
                ChannelSegment channelSegment4 = (ChannelSegment) channelSegment3.getPrev();
                String str3 = null;
                if (channelSegment4 != null) {
                    str2 = DebugStringsKt.getHexAddress(channelSegment4);
                } else {
                    str2 = null;
                }
                sb4.append(str2);
                sb4.append(',');
                sb.append(sb4.toString());
                int i2 = BufferedChannelKt.SEGMENT_SIZE;
                for (int i3 = 0; i3 < i2; i3++) {
                    Object state$kotlinx_coroutines_core = channelSegment3.getState$kotlinx_coroutines_core(i3);
                    Object element$kotlinx_coroutines_core = channelSegment3.getElement$kotlinx_coroutines_core(i3);
                    if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                        valueOf = "cont";
                    } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                        valueOf = "select";
                    } else if (state$kotlinx_coroutines_core instanceof d92) {
                        valueOf = "receiveCatching";
                    } else if (state$kotlinx_coroutines_core instanceof C1270hi) {
                        valueOf = "send(broadcast)";
                    } else if (state$kotlinx_coroutines_core instanceof o43) {
                        valueOf = "EB(" + state$kotlinx_coroutines_core + ')';
                    } else {
                        valueOf = String.valueOf(state$kotlinx_coroutines_core);
                    }
                    sb.append("[" + i3 + "]=(" + valueOf + ',' + element$kotlinx_coroutines_core + "),");
                }
                StringBuilder sb5 = new StringBuilder("next=");
                ChannelSegment channelSegment5 = (ChannelSegment) channelSegment3.getNext();
                if (channelSegment5 != null) {
                    str3 = DebugStringsKt.getHexAddress(channelSegment5);
                }
                sb5.append(str3);
                sb5.append("]  ");
                sb.append(sb5.toString());
                channelSegment3 = (ChannelSegment) channelSegment3.getNext();
            } while (channelSegment3 != null);
            return sb.toString();
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo8861tryReceivePtdJZtk() {
        Object obj;
        ChannelSegment channelSegment;
        Symbol symbol;
        Waiter waiter;
        Symbol symbol2;
        Symbol symbol3;
        long j = f21453d.get(this);
        long j2 = f21452c.get(this);
        if (m5688g(j2, true)) {
            return ChannelResult.INSTANCE.m8880closedJP2dKIU(getCloseCause());
        }
        if (j < (j2 & 1152921504606846975L)) {
            obj = BufferedChannelKt.f21471i;
            ChannelSegment channelSegment2 = (ChannelSegment) f21457h.get(this);
            while (!isClosedForReceive()) {
                long andIncrement = f21453d.getAndIncrement(this);
                int i = BufferedChannelKt.SEGMENT_SIZE;
                long j3 = andIncrement / i;
                int i2 = (int) (andIncrement % i);
                if (channelSegment2.id != j3) {
                    ChannelSegment m5686d = m5686d(j3, channelSegment2);
                    if (m5686d == null) {
                        continue;
                    } else {
                        channelSegment = m5686d;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object m5699s = m5699s(channelSegment, i2, obj, andIncrement);
                symbol = BufferedChannelKt.f21473k;
                if (m5699s != symbol) {
                    symbol2 = BufferedChannelKt.f21475m;
                    if (m5699s != symbol2) {
                        symbol3 = BufferedChannelKt.f21474l;
                        if (m5699s != symbol3) {
                            channelSegment.cleanPrev();
                            return ChannelResult.INSTANCE.m8882successJP2dKIU(m5699s);
                        }
                        throw new IllegalStateException("unexpected");
                    }
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    channelSegment2 = channelSegment;
                } else {
                    if (obj instanceof Waiter) {
                        waiter = (Waiter) obj;
                    } else {
                        waiter = null;
                    }
                    if (waiter != null) {
                        access$prepareReceiverForSuspension(this, waiter, channelSegment, i2);
                    }
                    waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                    channelSegment.onSlotCleaned();
                    return ChannelResult.INSTANCE.m8881failurePtdJZtk();
                }
            }
            return ChannelResult.INSTANCE.m8880closedJP2dKIU(getCloseCause());
        }
        return ChannelResult.INSTANCE.m8881failurePtdJZtk();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d5, code lost:
    
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m8880closedJP2dKIU(getSendException());
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m8882successJP2dKIU(kotlin.Unit.INSTANCE);
     */
    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    /* renamed from: trySend-JP2dKIU */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo8858trySendJP2dKIU(E element) {
        Object obj;
        ChannelSegment channelSegment;
        Waiter waiter;
        long j = f21452c.get(this);
        boolean z = false;
        long j2 = 1152921504606846975L;
        if (!m5688g(j, false)) {
            z = !m5683a(j & 1152921504606846975L);
        }
        if (!z) {
            obj = BufferedChannelKt.f21470h;
            ChannelSegment channelSegment2 = (ChannelSegment) f21456g.get(this);
            while (true) {
                long andIncrement = f21452c.getAndIncrement(this);
                long j3 = andIncrement & j2;
                boolean m5688g = m5688g(andIncrement, false);
                long j4 = BufferedChannelKt.SEGMENT_SIZE;
                long j5 = j3 / j4;
                int i = (int) (j3 % j4);
                if (channelSegment2.id != j5) {
                    ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j5, channelSegment2);
                    if (access$findSegmentSend == null) {
                        if (m5688g) {
                            break;
                        }
                    } else {
                        channelSegment = access$findSegmentSend;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                ChannelSegment channelSegment3 = channelSegment;
                int access$updateCellSend = access$updateCellSend(this, channelSegment, i, element, j3, obj, m5688g);
                if (access$updateCellSend != 0) {
                    if (access$updateCellSend == 1) {
                        break;
                    }
                    if (access$updateCellSend != 2) {
                        if (access$updateCellSend != 3) {
                            if (access$updateCellSend != 4) {
                                if (access$updateCellSend == 5) {
                                    channelSegment3.cleanPrev();
                                }
                                channelSegment2 = channelSegment3;
                                j2 = 1152921504606846975L;
                            } else if (j3 < getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment3.cleanPrev();
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else if (m5688g) {
                        channelSegment3.onSlotCleaned();
                    } else {
                        if (obj instanceof Waiter) {
                            waiter = (Waiter) obj;
                        } else {
                            waiter = null;
                        }
                        if (waiter != null) {
                            access$prepareSenderForSuspension(this, waiter, channelSegment3, i);
                        }
                        channelSegment3.onSlotCleaned();
                        return ChannelResult.INSTANCE.m8881failurePtdJZtk();
                    }
                } else {
                    channelSegment3.cleanPrev();
                    break;
                }
            }
        } else {
            return ChannelResult.INSTANCE.m8881failurePtdJZtk();
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        int i;
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater2;
        boolean z;
        long j2;
        if (m5689h()) {
            return;
        }
        do {
            atomicLongFieldUpdater = f21454e;
        } while (atomicLongFieldUpdater.get(this) <= globalIndex);
        i = BufferedChannelKt.f21464b;
        int i2 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = f21455f;
            if (i2 < i) {
                long j3 = atomicLongFieldUpdater.get(this);
                if (j3 == (atomicLongFieldUpdater3.get(this) & DurationKt.MAX_MILLIS) && j3 == atomicLongFieldUpdater.get(this)) {
                    return;
                } else {
                    i2++;
                }
            } else {
                do {
                    j = atomicLongFieldUpdater3.get(this);
                } while (!atomicLongFieldUpdater3.compareAndSet(this, j, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(j & DurationKt.MAX_MILLIS, true)));
                while (true) {
                    long j4 = atomicLongFieldUpdater.get(this);
                    atomicLongFieldUpdater2 = f21455f;
                    long j5 = atomicLongFieldUpdater2.get(this);
                    long j6 = j5 & DurationKt.MAX_MILLIS;
                    if ((Longs.MAX_POWER_OF_TWO & j5) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (j4 == j6 && j4 == atomicLongFieldUpdater.get(this)) {
                        break;
                    } else if (!z) {
                        atomicLongFieldUpdater2.compareAndSet(this, j5, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(j6, true));
                    }
                }
                do {
                    j2 = atomicLongFieldUpdater2.get(this);
                } while (!atomicLongFieldUpdater2.compareAndSet(this, j2, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(j2 & DurationKt.MAX_MILLIS, false)));
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    public /* synthetic */ BufferedChannel(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1);
    }
}
