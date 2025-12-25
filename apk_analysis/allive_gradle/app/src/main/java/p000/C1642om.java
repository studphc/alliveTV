package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: om */
/* loaded from: classes2.dex */
public final class C1642om extends ContinuationImpl {

    /* renamed from: d */
    public Ref.IntRef f24811d;

    /* renamed from: e */
    public ReceiveChannel f24812e;

    /* renamed from: f */
    public ChannelIterator f24813f;

    /* renamed from: g */
    public /* synthetic */ Object f24814g;

    /* renamed from: h */
    public int f24815h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f24814g = obj;
        this.f24815h |= Integer.MIN_VALUE;
        return ChannelsKt.count(null, this);
    }
}
