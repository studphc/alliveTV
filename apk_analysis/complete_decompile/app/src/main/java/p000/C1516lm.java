package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractC1416e;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: lm */
/* loaded from: classes2.dex */
public final class C1516lm extends ContinuationImpl {

    /* renamed from: d */
    public Function1 f22557d;

    /* renamed from: e */
    public ReceiveChannel f22558e;

    /* renamed from: f */
    public ChannelIterator f22559f;

    /* renamed from: g */
    public /* synthetic */ Object f22560g;

    /* renamed from: h */
    public int f22561h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22560g = obj;
        this.f22561h |= Integer.MIN_VALUE;
        return AbstractC1416e.m5703a(null, null, this);
    }
}
