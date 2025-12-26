package p000;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.BroadcastChannelImpl;

/* renamed from: qh */
/* loaded from: classes2.dex */
public final class C1724qh extends ContinuationImpl {

    /* renamed from: d */
    public BroadcastChannelImpl f25583d;

    /* renamed from: e */
    public Object f25584e;

    /* renamed from: f */
    public Iterator f25585f;

    /* renamed from: g */
    public /* synthetic */ Object f25586g;

    /* renamed from: h */
    public final /* synthetic */ BroadcastChannelImpl f25587h;

    /* renamed from: i */
    public int f25588i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1724qh(BroadcastChannelImpl broadcastChannelImpl, Continuation continuation) {
        super(continuation);
        this.f25587h = broadcastChannelImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25586g = obj;
        this.f25588i |= Integer.MIN_VALUE;
        return this.f25587h.send(null, this);
    }
}
