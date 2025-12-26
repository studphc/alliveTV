package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl;

/* renamed from: wy */
/* loaded from: classes2.dex */
public final class C1963wy extends ContinuationImpl {

    /* renamed from: d */
    public DebugCoroutineInfoImpl f28378d;

    /* renamed from: e */
    public SequenceScope f28379e;

    /* renamed from: f */
    public CoroutineStackFrame f28380f;

    /* renamed from: g */
    public /* synthetic */ Object f28381g;

    /* renamed from: h */
    public final /* synthetic */ DebugCoroutineInfoImpl f28382h;

    /* renamed from: i */
    public int f28383i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1963wy(Continuation continuation, DebugCoroutineInfoImpl debugCoroutineInfoImpl) {
        super(continuation);
        this.f28382h = debugCoroutineInfoImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28381g = obj;
        this.f28383i |= Integer.MIN_VALUE;
        return DebugCoroutineInfoImpl.access$yieldFrames(this.f28382h, null, null, this);
    }
}
