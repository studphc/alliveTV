package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: on */
/* loaded from: classes2.dex */
public final class C1643on extends ContinuationImpl {

    /* renamed from: d */
    public ReceiveChannel f24827d;

    /* renamed from: e */
    public Object f24828e;

    /* renamed from: f */
    public /* synthetic */ Object f24829f;

    /* renamed from: g */
    public int f24830g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f24829f = obj;
        this.f24830g |= Integer.MIN_VALUE;
        return ChannelsKt.single(null, this);
    }
}
