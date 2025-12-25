package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: mn */
/* loaded from: classes2.dex */
public final class C1554mn extends ContinuationImpl {

    /* renamed from: d */
    public ReceiveChannel f22989d;

    /* renamed from: e */
    public /* synthetic */ Object f22990e;

    /* renamed from: f */
    public int f22991f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22990e = obj;
        this.f22991f |= Integer.MIN_VALUE;
        return ChannelsKt.none(null, this);
    }
}
