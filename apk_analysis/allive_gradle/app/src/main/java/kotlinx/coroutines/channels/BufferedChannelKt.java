package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.primitives.Longs;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;
import p000.C1873ui;

@Metadata(m5568d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0001\"\u0004\b\u0000\u0010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001a\u0010\u000f\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, m5569d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlin/reflect/KFunction2;", "", "Lkotlinx/coroutines/channels/ChannelSegment;", "createSegmentFunction", "()Lkotlin/reflect/KFunction;", "", "SEGMENT_SIZE", "I", "Lkotlinx/coroutines/internal/Symbol;", "BUFFERED", "Lkotlinx/coroutines/internal/Symbol;", "j", "getCHANNEL_CLOSED", "()Lkotlinx/coroutines/internal/Symbol;", "CHANNEL_CLOSED", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class BufferedChannelKt {

    /* renamed from: a */
    public static final ChannelSegment f21463a = new ChannelSegment(-1, null, null, 0);

    @JvmField
    public static final int SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);

    /* renamed from: b */
    public static final int f21464b = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object) null);

    @JvmField
    @NotNull
    public static final Symbol BUFFERED = new Symbol("BUFFERED");

    /* renamed from: c */
    public static final Symbol f21465c = new Symbol("SHOULD_BUFFER");

    /* renamed from: d */
    public static final Symbol f21466d = new Symbol("S_RESUMING_BY_RCV");

    /* renamed from: e */
    public static final Symbol f21467e = new Symbol("RESUMING_BY_EB");

    /* renamed from: f */
    public static final Symbol f21468f = new Symbol("POISONED");

    /* renamed from: g */
    public static final Symbol f21469g = new Symbol("DONE_RCV");

    /* renamed from: h */
    public static final Symbol f21470h = new Symbol("INTERRUPTED_SEND");

    /* renamed from: i */
    public static final Symbol f21471i = new Symbol("INTERRUPTED_RCV");

    /* renamed from: j */
    public static final Symbol f21472j = new Symbol("CHANNEL_CLOSED");

    /* renamed from: k */
    public static final Symbol f21473k = new Symbol("SUSPEND");

    /* renamed from: l */
    public static final Symbol f21474l = new Symbol("SUSPEND_NO_WAITER");

    /* renamed from: m */
    public static final Symbol f21475m = new Symbol("FAILED");

    /* renamed from: n */
    public static final Symbol f21476n = new Symbol("NO_RECEIVE_RESULT");

    /* renamed from: o */
    public static final Symbol f21477o = new Symbol("CLOSE_HANDLER_CLOSED");

    /* renamed from: p */
    public static final Symbol f21478p = new Symbol("CLOSE_HANDLER_INVOKED");

    /* renamed from: q */
    public static final Symbol f21479q = new Symbol("NO_CLOSE_CAUSE");

    public static final long access$constructEBCompletedAndPauseFlag(long j, boolean z) {
        return (z ? Longs.MAX_POWER_OF_TWO : 0L) + j;
    }

    public static final long access$constructSendersAndCloseStatus(long j, int i) {
        return (i << 60) + j;
    }

    public static final ChannelSegment access$createSegment(long j, ChannelSegment channelSegment) {
        return new ChannelSegment(j, channelSegment, channelSegment.getChannel(), 0);
    }

    public static final long access$initialBufferEnd(int i) {
        if (i == 0) {
            return 0L;
        }
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        return Long.MAX_VALUE;
    }

    public static final boolean access$tryResume0(CancellableContinuation cancellableContinuation, Object obj, Function1 function1) {
        Object tryResume = cancellableContinuation.tryResume(obj, null, function1);
        if (tryResume != null) {
            cancellableContinuation.completeResume(tryResume);
            return true;
        }
        return false;
    }

    @NotNull
    public static final <E> KFunction<ChannelSegment<E>> createSegmentFunction() {
        return C1873ui.f27275h;
    }

    @NotNull
    public static final Symbol getCHANNEL_CLOSED() {
        return f21472j;
    }
}
