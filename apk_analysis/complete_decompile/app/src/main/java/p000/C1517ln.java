package p000;

import java.util.Comparator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: ln */
/* loaded from: classes2.dex */
public final class C1517ln extends ContinuationImpl {

    /* renamed from: d */
    public Comparator f22576d;

    /* renamed from: e */
    public ReceiveChannel f22577e;

    /* renamed from: f */
    public ChannelIterator f22578f;

    /* renamed from: g */
    public Object f22579g;

    /* renamed from: h */
    public /* synthetic */ Object f22580h;

    /* renamed from: i */
    public int f22581i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22580h = obj;
        this.f22581i |= Integer.MIN_VALUE;
        return ChannelsKt.minWith(null, null, this);
    }
}
