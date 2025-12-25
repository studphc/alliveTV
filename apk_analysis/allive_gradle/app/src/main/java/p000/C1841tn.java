package p000;

import java.util.Collection;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: tn */
/* loaded from: classes2.dex */
public final class C1841tn extends ContinuationImpl {

    /* renamed from: d */
    public Collection f26888d;

    /* renamed from: e */
    public ReceiveChannel f26889e;

    /* renamed from: f */
    public ChannelIterator f26890f;

    /* renamed from: g */
    public /* synthetic */ Object f26891g;

    /* renamed from: h */
    public int f26892h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26891g = obj;
        this.f26892h |= Integer.MIN_VALUE;
        return ChannelsKt.toCollection(null, null, this);
    }
}
