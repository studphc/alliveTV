package p000;

import java.util.Comparator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: kn */
/* loaded from: classes2.dex */
public final class C1397kn extends ContinuationImpl {

    /* renamed from: d */
    public Comparator f20905d;

    /* renamed from: e */
    public ReceiveChannel f20906e;

    /* renamed from: f */
    public ChannelIterator f20907f;

    /* renamed from: g */
    public Object f20908g;

    /* renamed from: h */
    public /* synthetic */ Object f20909h;

    /* renamed from: i */
    public int f20910i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f20909h = obj;
        this.f20910i |= Integer.MIN_VALUE;
        return ChannelsKt.maxWith(null, null, this);
    }
}
