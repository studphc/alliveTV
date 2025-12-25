package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: en */
/* loaded from: classes2.dex */
public final class C1164en extends ContinuationImpl {

    /* renamed from: d */
    public Object f16908d;

    /* renamed from: e */
    public Ref.IntRef f16909e;

    /* renamed from: f */
    public ReceiveChannel f16910f;

    /* renamed from: g */
    public ChannelIterator f16911g;

    /* renamed from: h */
    public /* synthetic */ Object f16912h;

    /* renamed from: i */
    public int f16913i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16912h = obj;
        this.f16913i |= Integer.MIN_VALUE;
        return ChannelsKt.indexOf(null, null, this);
    }
}
