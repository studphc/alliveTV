package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ProducerScope;

/* renamed from: vk */
/* loaded from: classes2.dex */
public final class C1912vk extends ContinuationImpl {

    /* renamed from: d */
    public ProducerScope f27822d;

    /* renamed from: e */
    public /* synthetic */ Object f27823e;

    /* renamed from: f */
    public final /* synthetic */ C1949wk f27824f;

    /* renamed from: g */
    public int f27825g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1912vk(C1949wk c1949wk, Continuation continuation) {
        super(continuation);
        this.f27824f = c1949wk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f27823e = obj;
        this.f27825g |= Integer.MIN_VALUE;
        return this.f27824f.collectTo(null, this);
    }
}
