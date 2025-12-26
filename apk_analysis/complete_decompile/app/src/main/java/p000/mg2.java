package p000;

import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* loaded from: classes2.dex */
public final class mg2 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Object f22930c;

    /* renamed from: d */
    public Iterator f22931d;

    /* renamed from: e */
    public int f22932e;

    /* renamed from: f */
    public /* synthetic */ Object f22933f;

    /* renamed from: g */
    public final /* synthetic */ Object f22934g;

    /* renamed from: h */
    public final /* synthetic */ Sequence f22935h;

    /* renamed from: i */
    public final /* synthetic */ Function2 f22936i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mg2(Object obj, Sequence sequence, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f22934g = obj;
        this.f22935h = sequence;
        this.f22936i = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        mg2 mg2Var = new mg2(this.f22934g, this.f22935h, this.f22936i, continuation);
        mg2Var.f22933f = obj;
        return mg2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((mg2) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        SequenceScope sequenceScope2;
        Iterator it;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f22932e;
        Object obj2 = this.f22934g;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    it = this.f22931d;
                    obj2 = this.f22930c;
                    sequenceScope2 = (SequenceScope) this.f22933f;
                    ResultKt.throwOnFailure(obj);
                    while (it.hasNext()) {
                        Object invoke = this.f22936i.invoke(obj2, it.next());
                        this.f22933f = sequenceScope2;
                        this.f22930c = invoke;
                        this.f22931d = it;
                        this.f22932e = 2;
                        if (sequenceScope2.yield(invoke, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = invoke;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sequenceScope = (SequenceScope) this.f22933f;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f22933f;
            this.f22933f = sequenceScope;
            this.f22932e = 1;
            if (sequenceScope.yield(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        sequenceScope2 = sequenceScope;
        it = this.f22935h.iterator();
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
