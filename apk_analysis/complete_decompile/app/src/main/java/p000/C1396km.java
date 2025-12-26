package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractC1416e;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: km */
/* loaded from: classes2.dex */
public final class C1396km extends ContinuationImpl {

    /* renamed from: d */
    public Function1 f20891d;

    /* renamed from: e */
    public ReceiveChannel f20892e;

    /* renamed from: f */
    public ChannelIterator f20893f;

    /* renamed from: g */
    public /* synthetic */ Object f20894g;

    /* renamed from: h */
    public int f20895h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f20894g = obj;
        this.f20895h |= Integer.MIN_VALUE;
        return AbstractC1416e.m5704b(null, null, this);
    }
}
