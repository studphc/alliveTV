package kotlinx.coroutines.flow;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import p000.bi2;
import p000.r82;

/* renamed from: kotlinx.coroutines.flow.b */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1479b {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r3 == 0) goto L15;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final bi2 m5725a(Flow flow, int i) {
        ChannelFlow channelFlow;
        Flow dropChannelOperators;
        int coerceAtLeast = r82.coerceAtLeast(i, Channel.INSTANCE.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()) - i;
        if ((flow instanceof ChannelFlow) && (dropChannelOperators = (channelFlow = (ChannelFlow) flow).dropChannelOperators()) != null) {
            int i2 = channelFlow.capacity;
            if (i2 != -3 && i2 != -2 && i2 != 0) {
                coerceAtLeast = i2;
            } else if (channelFlow.onBufferOverflow != BufferOverflow.SUSPEND) {
                if (i == 0) {
                    coerceAtLeast = 1;
                }
                coerceAtLeast = 0;
            }
            return new bi2(dropChannelOperators, channelFlow.context, coerceAtLeast, channelFlow.onBufferOverflow);
        }
        return new bi2(flow, EmptyCoroutineContext.INSTANCE, coerceAtLeast, BufferOverflow.SUSPEND);
    }
}
