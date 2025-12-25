package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: cn */
/* loaded from: classes2.dex */
public final class C0599cn extends ContinuationImpl {

    /* renamed from: d */
    public ReceiveChannel f8419d;

    /* renamed from: e */
    public ChannelIterator f8420e;

    /* renamed from: f */
    public /* synthetic */ Object f8421f;

    /* renamed from: g */
    public int f8422g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f8421f = obj;
        this.f8422g |= Integer.MIN_VALUE;
        return ChannelsKt.firstOrNull(null, this);
    }
}
