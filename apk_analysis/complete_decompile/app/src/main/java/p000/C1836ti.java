package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelResult;

/* renamed from: ti */
/* loaded from: classes2.dex */
public final class C1836ti extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f26815d;

    /* renamed from: e */
    public final /* synthetic */ BufferedChannel f26816e;

    /* renamed from: f */
    public int f26817f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1836ti(BufferedChannel bufferedChannel, Continuation continuation) {
        super(continuation);
        this.f26816e = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m5693m;
        this.f26815d = obj;
        this.f26817f |= Integer.MIN_VALUE;
        m5693m = this.f26816e.m5693m(null, 0, 0L, this);
        if (m5693m == b51.getCOROUTINE_SUSPENDED()) {
            return m5693m;
        }
        return ChannelResult.m8867boximpl(m5693m);
    }
}
