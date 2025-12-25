package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.channels.SendChannel;

/* renamed from: kotlinx.coroutines.channels.f */
/* loaded from: classes2.dex */
public final class C1417f extends ChannelCoroutine implements ProducerScope {
    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable th, boolean z) {
        if (!get_channel().close(th) && !z) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Unit unit) {
        SendChannel.DefaultImpls.close$default(get_channel(), null, 1, null);
    }
}
