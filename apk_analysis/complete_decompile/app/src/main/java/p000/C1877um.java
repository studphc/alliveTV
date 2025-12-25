package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: um */
/* loaded from: classes2.dex */
public final class C1877um extends ContinuationImpl {

    /* renamed from: d */
    public int f27343d;

    /* renamed from: e */
    public int f27344e;

    /* renamed from: f */
    public ReceiveChannel f27345f;

    /* renamed from: g */
    public ChannelIterator f27346g;

    /* renamed from: h */
    public /* synthetic */ Object f27347h;

    /* renamed from: i */
    public int f27348i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f27347h = obj;
        this.f27348i |= Integer.MIN_VALUE;
        return ChannelsKt.elementAtOrNull(null, 0, this);
    }
}
