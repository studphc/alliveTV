package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: tm */
/* loaded from: classes2.dex */
public final class C1840tm extends ContinuationImpl {

    /* renamed from: d */
    public int f26868d;

    /* renamed from: e */
    public int f26869e;

    /* renamed from: f */
    public ReceiveChannel f26870f;

    /* renamed from: g */
    public ChannelIterator f26871g;

    /* renamed from: h */
    public /* synthetic */ Object f26872h;

    /* renamed from: i */
    public int f26873i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26872h = obj;
        this.f26873i |= Integer.MIN_VALUE;
        return ChannelsKt.elementAt(null, 0, this);
    }
}
