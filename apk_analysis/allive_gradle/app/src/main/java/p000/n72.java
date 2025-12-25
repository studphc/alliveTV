package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* loaded from: classes2.dex */
public final class n72 extends ContinuationImpl {

    /* renamed from: d */
    public ProducerScope f23267d;

    /* renamed from: e */
    public Function0 f23268e;

    /* renamed from: f */
    public /* synthetic */ Object f23269f;

    /* renamed from: g */
    public int f23270g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f23269f = obj;
        this.f23270g |= Integer.MIN_VALUE;
        return ProduceKt.awaitClose(null, null, this);
    }
}
