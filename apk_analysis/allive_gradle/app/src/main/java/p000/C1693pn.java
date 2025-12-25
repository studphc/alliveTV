package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: pn */
/* loaded from: classes2.dex */
public final class C1693pn extends ContinuationImpl {

    /* renamed from: d */
    public ReceiveChannel f25226d;

    /* renamed from: e */
    public Object f25227e;

    /* renamed from: f */
    public /* synthetic */ Object f25228f;

    /* renamed from: g */
    public int f25229g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25228f = obj;
        this.f25229g |= Integer.MIN_VALUE;
        return ChannelsKt.singleOrNull(null, this);
    }
}
