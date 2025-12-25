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
public final class qg2 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Iterator f25577c;

    /* renamed from: d */
    public Object f25578d;

    /* renamed from: e */
    public int f25579e;

    /* renamed from: f */
    public /* synthetic */ Object f25580f;

    /* renamed from: g */
    public final /* synthetic */ Sequence f25581g;

    /* renamed from: h */
    public final /* synthetic */ Function2 f25582h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qg2(Sequence sequence, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f25581g = sequence;
        this.f25582h = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        qg2 qg2Var = new qg2(this.f25581g, this.f25582h, continuation);
        qg2Var.f25580f = obj;
        return qg2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((qg2) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0059 -> B:5:0x0016). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Object next;
        Iterator it;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f25579e;
        if (i != 0) {
            if (i == 1) {
                Object next2 = this.f25578d;
                it = this.f25577c;
                sequenceScope = (SequenceScope) this.f25580f;
                ResultKt.throwOnFailure(obj);
                next = next2;
                if (it.hasNext()) {
                    next2 = it.next();
                    Object invoke = this.f25582h.invoke(next, next2);
                    this.f25580f = sequenceScope;
                    this.f25577c = it;
                    this.f25578d = next2;
                    this.f25579e = 1;
                    if (sequenceScope.yield(invoke, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    next = next2;
                    if (it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.f25580f;
            Iterator it2 = this.f25581g.iterator();
            if (!it2.hasNext()) {
                return Unit.INSTANCE;
            }
            sequenceScope = sequenceScope2;
            next = it2.next();
            it = it2;
            if (it.hasNext()) {
            }
        }
    }
}
