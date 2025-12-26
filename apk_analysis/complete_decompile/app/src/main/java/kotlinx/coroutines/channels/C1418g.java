package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: kotlinx.coroutines.channels.g */
/* loaded from: classes2.dex */
public final class C1418g extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f21501d;

    /* renamed from: e */
    public int f21502e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f21501d = obj;
        this.f21502e |= Integer.MIN_VALUE;
        return ReceiveChannel.DefaultImpls.receiveOrNull(null, this);
    }
}
