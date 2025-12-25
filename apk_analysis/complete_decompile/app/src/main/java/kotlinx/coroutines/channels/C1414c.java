package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;

/* renamed from: kotlinx.coroutines.channels.c */
/* loaded from: classes2.dex */
public final class C1414c extends ContinuationImpl {

    /* renamed from: d */
    public ChannelIterator f21494d;

    /* renamed from: e */
    public /* synthetic */ Object f21495e;

    /* renamed from: f */
    public int f21496f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f21495e = obj;
        this.f21496f |= Integer.MIN_VALUE;
        return ChannelIterator.DefaultImpls.next(null, this);
    }
}
