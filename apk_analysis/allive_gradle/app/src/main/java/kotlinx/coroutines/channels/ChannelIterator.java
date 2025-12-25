package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H¦Bø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00028\u0000H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, m5569d2 = {"Lkotlinx/coroutines/channels/ChannelIterator;", ExifInterface.LONGITUDE_EAST, "", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "next0", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public interface ChannelIterator<E> {

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object next(ChannelIterator channelIterator, Continuation continuation) {
            C1414c c1414c;
            Object obj;
            int i;
            ChannelIterator channelIterator2;
            if (continuation instanceof C1414c) {
                C1414c c1414c2 = (C1414c) continuation;
                int i2 = c1414c2.f21496f;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    c1414c2.f21496f = i2 - Integer.MIN_VALUE;
                    c1414c = c1414c2;
                    obj = c1414c.f21495e;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = c1414c.f21496f;
                    if (i == 0) {
                        if (i == 1) {
                            ChannelIterator channelIterator3 = c1414c.f21494d;
                            ResultKt.throwOnFailure(obj);
                            channelIterator2 = channelIterator3;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        c1414c.f21494d = channelIterator;
                        c1414c.f21496f = 1;
                        obj = channelIterator.hasNext(c1414c);
                        channelIterator2 = channelIterator;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return channelIterator2.next();
                    }
                    throw new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
                }
            }
            c1414c = new ContinuationImpl(continuation);
            obj = c1414c.f21495e;
            Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
            i = c1414c.f21496f;
            if (i == 0) {
            }
            if (!((Boolean) obj).booleanValue()) {
            }
        }
    }

    @Nullable
    Object hasNext(@NotNull Continuation<? super Boolean> continuation);

    E next();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @JvmName(name = "next")
    /* synthetic */ Object next(Continuation continuation);
}
