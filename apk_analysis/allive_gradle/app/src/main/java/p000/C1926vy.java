package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl;
import kotlinx.coroutines.debug.internal.StackTraceFrame;

/* renamed from: vy */
/* loaded from: classes2.dex */
public final class C1926vy extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public int f27989c;

    /* renamed from: d */
    public /* synthetic */ Object f27990d;

    /* renamed from: e */
    public final /* synthetic */ DebugCoroutineInfoImpl f27991e;

    /* renamed from: f */
    public final /* synthetic */ StackTraceFrame f27992f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1926vy(DebugCoroutineInfoImpl debugCoroutineInfoImpl, StackTraceFrame stackTraceFrame, Continuation continuation) {
        super(2, continuation);
        this.f27991e = debugCoroutineInfoImpl;
        this.f27992f = stackTraceFrame;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1926vy c1926vy = new C1926vy(this.f27991e, this.f27992f, continuation);
        c1926vy.f27990d = obj;
        return c1926vy;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1926vy) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f27989c;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope = (SequenceScope) this.f27990d;
            CoroutineStackFrame callerFrame = this.f27992f.getCallerFrame();
            this.f27989c = 1;
            if (DebugCoroutineInfoImpl.access$yieldFrames(this.f27991e, sequenceScope, callerFrame, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
