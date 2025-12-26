package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: fn */
/* loaded from: classes2.dex */
public final class C1201fn extends ContinuationImpl {

    /* renamed from: d */
    public ReceiveChannel f17336d;

    /* renamed from: e */
    public ChannelIterator f17337e;

    /* renamed from: f */
    public Object f17338f;

    /* renamed from: g */
    public /* synthetic */ Object f17339g;

    /* renamed from: h */
    public int f17340h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f17339g = obj;
        this.f17340h |= Integer.MIN_VALUE;
        return ChannelsKt.last(null, this);
    }
}
