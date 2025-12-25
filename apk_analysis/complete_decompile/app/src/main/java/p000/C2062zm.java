package p000;

import java.util.Collection;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: zm */
/* loaded from: classes2.dex */
public final class C2062zm extends ContinuationImpl {

    /* renamed from: d */
    public Collection f29431d;

    /* renamed from: e */
    public ReceiveChannel f29432e;

    /* renamed from: f */
    public ChannelIterator f29433f;

    /* renamed from: g */
    public /* synthetic */ Object f29434g;

    /* renamed from: h */
    public int f29435h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29434g = obj;
        this.f29435h |= Integer.MIN_VALUE;
        return ChannelsKt.filterNotNullTo((ReceiveChannel) null, (Collection) null, this);
    }
}
