package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: bn */
/* loaded from: classes2.dex */
public final class C0563bn extends ContinuationImpl {

    /* renamed from: d */
    public ReceiveChannel f8096d;

    /* renamed from: e */
    public ChannelIterator f8097e;

    /* renamed from: f */
    public /* synthetic */ Object f8098f;

    /* renamed from: g */
    public int f8099g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f8098f = obj;
        this.f8099g |= Integer.MIN_VALUE;
        return ChannelsKt.first(null, this);
    }
}
