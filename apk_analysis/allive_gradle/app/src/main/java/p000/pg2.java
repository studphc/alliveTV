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
public final class pg2 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Iterator f25163c;

    /* renamed from: d */
    public Object f25164d;

    /* renamed from: e */
    public int f25165e;

    /* renamed from: f */
    public int f25166f;

    /* renamed from: g */
    public /* synthetic */ Object f25167g;

    /* renamed from: h */
    public final /* synthetic */ Sequence f25168h;

    /* renamed from: i */
    public final /* synthetic */ Function3 f25169i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pg2(Sequence sequence, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f25168h = sequence;
        this.f25169i = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        pg2 pg2Var = new pg2(this.f25168h, this.f25169i, continuation);
        pg2Var.f25167g = obj;
        return pg2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((pg2) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Iterator it;
        Object next;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f25166f;
        int i2 = 1;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int i3 = this.f25165e;
                    Object obj2 = this.f25164d;
                    it = this.f25163c;
                    sequenceScope = (SequenceScope) this.f25167g;
                    ResultKt.throwOnFailure(obj);
                    i2 = i3;
                    next = obj2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                next = this.f25164d;
                it = this.f25163c;
                sequenceScope = (SequenceScope) this.f25167g;
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f25167g;
            it = this.f25168h.iterator();
            if (it.hasNext()) {
                next = it.next();
                this.f25167g = sequenceScope;
                this.f25163c = it;
                this.f25164d = next;
                this.f25166f = 1;
                if (sequenceScope.yield(next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        while (it.hasNext()) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Object invoke = this.f25169i.invoke(Boxing.boxInt(i2), next, it.next());
            this.f25167g = sequenceScope;
            this.f25163c = it;
            this.f25164d = invoke;
            this.f25165e = i4;
            this.f25166f = 2;
            if (sequenceScope.yield(invoke, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            next = invoke;
            i2 = i4;
        }
        return Unit.INSTANCE;
    }
}
