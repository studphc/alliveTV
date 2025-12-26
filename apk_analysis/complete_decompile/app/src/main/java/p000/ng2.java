package p000;

import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* loaded from: classes2.dex */
public final class ng2 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Object f23356c;

    /* renamed from: d */
    public Iterator f23357d;

    /* renamed from: e */
    public int f23358e;

    /* renamed from: f */
    public int f23359f;

    /* renamed from: g */
    public /* synthetic */ Object f23360g;

    /* renamed from: h */
    public final /* synthetic */ Object f23361h;

    /* renamed from: i */
    public final /* synthetic */ Sequence f23362i;

    /* renamed from: j */
    public final /* synthetic */ Function3 f23363j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ng2(Object obj, Sequence sequence, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f23361h = obj;
        this.f23362i = sequence;
        this.f23363j = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ng2 ng2Var = new ng2(this.f23361h, this.f23362i, this.f23363j, continuation);
        ng2Var.f23360g = obj;
        return ng2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ng2) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0053  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        SequenceScope sequenceScope2;
        Iterator it;
        int i;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f23359f;
        Object obj2 = this.f23361h;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = this.f23358e;
                    it = this.f23357d;
                    obj2 = this.f23356c;
                    sequenceScope2 = (SequenceScope) this.f23360g;
                    ResultKt.throwOnFailure(obj);
                    i = i3;
                    while (it.hasNext()) {
                        Object next = it.next();
                        int i4 = i + 1;
                        if (i < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        Object invoke = this.f23363j.invoke(Boxing.boxInt(i), obj2, next);
                        this.f23360g = sequenceScope2;
                        this.f23356c = invoke;
                        this.f23357d = it;
                        this.f23358e = i4;
                        this.f23359f = 2;
                        if (sequenceScope2.yield(invoke, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = invoke;
                        i = i4;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sequenceScope = (SequenceScope) this.f23360g;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f23360g;
            this.f23360g = sequenceScope;
            this.f23359f = 1;
            if (sequenceScope.yield(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        sequenceScope2 = sequenceScope;
        it = this.f23362i.iterator();
        i = 0;
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
