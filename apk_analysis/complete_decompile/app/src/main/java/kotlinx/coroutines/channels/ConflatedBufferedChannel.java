package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ha0;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\t¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00028\u0000H\u0090@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\r\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001a\u001a\u00020\b2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00108TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006 "}, m5569d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BufferedChannel;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "element", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "sendBroadcast$kotlinx_coroutines_core", "sendBroadcast", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "registerSelectForSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "shouldSendSuspend$kotlinx_coroutines_core", "()Z", "shouldSendSuspend", "isConflatedDropOldest", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nConflatedBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 5 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,119:1\n548#2,5:120\n514#2,6:125\n514#2,6:212\n548#2,5:218\n244#3:131\n269#3,10:132\n280#3,68:143\n3038#4:142\n269#5:211\n*S KotlinDebug\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n*L\n41#1:120,5\n53#1:125,6\n106#1:212,6\n109#1:218,5\n80#1:131\n80#1:132,10\n80#1:143,68\n80#1:142\n80#1:211\n*E\n"})
/* loaded from: classes2.dex */
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {

    /* renamed from: l */
    public final BufferOverflow f21488l;

    public /* synthetic */ ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bufferOverflow, (i2 & 4) != 0 ? null : function1);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean isConflatedDropOldest() {
        if (this.f21488l == BufferOverflow.DROP_OLDEST) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void registerSelectForSend(@NotNull SelectInstance<?> select, @Nullable Object element) {
        Object mo8858trySendJP2dKIU = mo8858trySendJP2dKIU(element);
        if (!(mo8858trySendJP2dKIU instanceof ChannelResult.Failed)) {
            select.selectInRegistrationPhase(Unit.INSTANCE);
        } else {
            if (mo8858trySendJP2dKIU instanceof ChannelResult.Closed) {
                ChannelResult.m8871exceptionOrNullimpl(mo8858trySendJP2dKIU);
                select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
                return;
            }
            throw new IllegalStateException("unreachable");
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(E e, @NotNull Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        Object m5701u = m5701u(e, true);
        if (m5701u instanceof ChannelResult.Closed) {
            ChannelResult.m8871exceptionOrNullimpl(m5701u);
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) != null) {
                ha0.addSuppressed(callUndeliveredElementCatchingException$default, getSendException());
                throw callUndeliveredElementCatchingException$default;
            }
            throw getSendException();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    @Nullable
    public Object sendBroadcast$kotlinx_coroutines_core(E e, @NotNull Continuation<? super Boolean> continuation) {
        Object m5701u = m5701u(e, true);
        if (!(m5701u instanceof ChannelResult.Failed)) {
            return Boxing.boxBoolean(true);
        }
        return Boxing.boxBoolean(false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    @NotNull
    /* renamed from: trySend-JP2dKIU */
    public Object mo8858trySendJP2dKIU(E element) {
        return m5701u(element, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
    
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m8882successJP2dKIU(kotlin.Unit.INSTANCE);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m5701u(Object obj, boolean z) {
        ChannelSegment channelSegment;
        Waiter waiter;
        Function1<E, Unit> function1;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        if (this.f21488l == BufferOverflow.DROP_LATEST) {
            Object mo8858trySendJP2dKIU = super.mo8858trySendJP2dKIU(obj);
            if (!ChannelResult.m8877isSuccessimpl(mo8858trySendJP2dKIU) && !ChannelResult.m8875isClosedimpl(mo8858trySendJP2dKIU)) {
                if (z && (function1 = this.onUndeliveredElement) != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj, null, 2, null)) != null) {
                    throw callUndeliveredElementCatchingException$default;
                }
                return ChannelResult.INSTANCE.m8882successJP2dKIU(Unit.INSTANCE);
            }
            return mo8858trySendJP2dKIU;
        }
        Object obj2 = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.f21456g.get(this);
        while (true) {
            long andIncrement = BufferedChannel.f21452c.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean m5688g = m5688g(andIncrement, false);
            long j2 = BufferedChannelKt.SEGMENT_SIZE;
            long j3 = j / j2;
            int i = (int) (j % j2);
            if (channelSegment2.id != j3) {
                ChannelSegment access$findSegmentSend = BufferedChannel.access$findSegmentSend(this, j3, channelSegment2);
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
            int access$updateCellSend = BufferedChannel.access$updateCellSend(this, channelSegment, i, obj, j, obj2, m5688g);
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
                            channelSegment2 = channelSegment;
                        } else if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                    } else {
                        throw new IllegalStateException("unexpected");
                    }
                } else if (m5688g) {
                    channelSegment.onSlotCleaned();
                } else {
                    if (obj2 instanceof Waiter) {
                        waiter = (Waiter) obj2;
                    } else {
                        waiter = null;
                    }
                    if (waiter != null) {
                        BufferedChannel.access$prepareSenderForSuspension(this, waiter, channelSegment, i);
                    }
                    dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * j2) + i);
                    return ChannelResult.INSTANCE.m8882successJP2dKIU(Unit.INSTANCE);
                }
            } else {
                channelSegment.cleanPrev();
                break;
            }
        }
        return ChannelResult.INSTANCE.m8880closedJP2dKIU(getSendException());
    }

    public ConflatedBufferedChannel(int i, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, Unit> function1) {
        super(i, function1);
        this.f21488l = bufferOverflow;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            if (i < 1) {
                throw new IllegalArgumentException(ye0.m8292l(i, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
        }
    }
}
