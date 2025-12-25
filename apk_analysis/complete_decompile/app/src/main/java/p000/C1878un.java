package p000;

import java.util.Map;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: un */
/* loaded from: classes2.dex */
public final class C1878un extends ContinuationImpl {

    /* renamed from: d */
    public Map f27375d;

    /* renamed from: e */
    public ReceiveChannel f27376e;

    /* renamed from: f */
    public ChannelIterator f27377f;

    /* renamed from: g */
    public /* synthetic */ Object f27378g;

    /* renamed from: h */
    public int f27379h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f27378g = obj;
        this.f27379h |= Integer.MIN_VALUE;
        return ChannelsKt.toMap(null, null, this);
    }
}
