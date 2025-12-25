package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: nm */
/* loaded from: classes2.dex */
public final class C1590nm extends ContinuationImpl {

    /* renamed from: d */
    public ReceiveChannel f23399d;

    /* renamed from: e */
    public /* synthetic */ Object f23400e;

    /* renamed from: f */
    public int f23401f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f23400e = obj;
        this.f23401f |= Integer.MIN_VALUE;
        return ChannelsKt.any(null, this);
    }
}
