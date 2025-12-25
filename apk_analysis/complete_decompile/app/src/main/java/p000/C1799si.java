package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelResult;

/* renamed from: si */
/* loaded from: classes2.dex */
public final class C1799si extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f26434d;

    /* renamed from: e */
    public final /* synthetic */ BufferedChannel f26435e;

    /* renamed from: f */
    public int f26436f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1799si(BufferedChannel bufferedChannel, Continuation continuation) {
        super(continuation);
        this.f26435e = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26434d = obj;
        this.f26436f |= Integer.MIN_VALUE;
        Object m5682l = BufferedChannel.m5682l(this.f26435e, this);
        if (m5682l == b51.getCOROUTINE_SUSPENDED()) {
            return m5682l;
        }
        return ChannelResult.m8867boximpl(m5682l);
    }
}
