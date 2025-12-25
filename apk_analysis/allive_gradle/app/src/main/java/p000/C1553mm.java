package p000;

import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: mm */
/* loaded from: classes2.dex */
public final class C1553mm extends ContinuationImpl {

    /* renamed from: d */
    public List f22978d;

    /* renamed from: e */
    public List f22979e;

    /* renamed from: f */
    public ReceiveChannel f22980f;

    /* renamed from: g */
    public ChannelIterator f22981g;

    /* renamed from: h */
    public /* synthetic */ Object f22982h;

    /* renamed from: i */
    public int f22983i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22982h = obj;
        this.f22983i |= Integer.MIN_VALUE;
        return ChannelsKt.toList(null, this);
    }
}
