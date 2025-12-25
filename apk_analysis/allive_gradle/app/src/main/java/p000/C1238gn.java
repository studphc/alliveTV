package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: gn */
/* loaded from: classes2.dex */
public final class C1238gn extends ContinuationImpl {

    /* renamed from: d */
    public Object f17766d;

    /* renamed from: e */
    public Ref.IntRef f17767e;

    /* renamed from: f */
    public Ref.IntRef f17768f;

    /* renamed from: g */
    public ReceiveChannel f17769g;

    /* renamed from: h */
    public ChannelIterator f17770h;

    /* renamed from: i */
    public /* synthetic */ Object f17771i;

    /* renamed from: j */
    public int f17772j;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f17771i = obj;
        this.f17772j |= Integer.MIN_VALUE;
        return ChannelsKt.lastIndexOf(null, null, this);
    }
}
