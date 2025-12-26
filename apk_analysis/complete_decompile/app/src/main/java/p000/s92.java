package p000;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import kotlin.text.Regex;

/* loaded from: classes2.dex */
public final class s92 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Matcher f26323c;

    /* renamed from: d */
    public int f26324d;

    /* renamed from: e */
    public int f26325e;

    /* renamed from: f */
    public /* synthetic */ Object f26326f;

    /* renamed from: g */
    public final /* synthetic */ Regex f26327g;

    /* renamed from: h */
    public final /* synthetic */ CharSequence f26328h;

    /* renamed from: i */
    public final /* synthetic */ int f26329i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s92(Regex regex, CharSequence charSequence, int i, Continuation continuation) {
        super(2, continuation);
        this.f26327g = regex;
        this.f26328h = charSequence;
        this.f26329i = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        s92 s92Var = new s92(this.f26327g, this.f26328h, this.f26329i, continuation);
        s92Var.f26326f = obj;
        return s92Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((s92) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x006a -> B:13:0x006d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Pattern pattern;
        SequenceScope sequenceScope;
        Matcher matcher;
        int i;
        String obj2;
        String obj3;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f26325e;
        int i3 = this.f26329i;
        CharSequence charSequence = this.f26328h;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.f26324d;
                Matcher matcher2 = this.f26323c;
                sequenceScope = (SequenceScope) this.f26326f;
                ResultKt.throwOnFailure(obj);
                matcher = matcher2;
                r7 = matcher.end();
                i++;
                if (i != i3 - 1 || !matcher.find()) {
                    obj3 = charSequence.subSequence(r7, charSequence.length()).toString();
                    this.f26326f = null;
                    this.f26323c = null;
                    this.f26325e = 3;
                    if (sequenceScope.yield(obj3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                obj2 = charSequence.subSequence(r7, matcher.start()).toString();
                this.f26326f = sequenceScope;
                this.f26323c = matcher;
                this.f26324d = i;
                this.f26325e = 2;
                if (sequenceScope.yield(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r7 = matcher.end();
                i++;
                if (i != i3 - 1) {
                }
                obj3 = charSequence.subSequence(r7, charSequence.length()).toString();
                this.f26326f = null;
                this.f26323c = null;
                this.f26325e = 3;
                if (sequenceScope.yield(obj3, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.f26326f;
            pattern = this.f26327g.f21354a;
            Matcher matcher3 = pattern.matcher(charSequence);
            if (i3 != 1 && matcher3.find()) {
                int i4 = 0;
                sequenceScope = sequenceScope2;
                matcher = matcher3;
                i = 0;
                obj2 = charSequence.subSequence(i4, matcher.start()).toString();
                this.f26326f = sequenceScope;
                this.f26323c = matcher;
                this.f26324d = i;
                this.f26325e = 2;
                if (sequenceScope.yield(obj2, this) == coroutine_suspended) {
                }
                i4 = matcher.end();
                i++;
                if (i != i3 - 1) {
                }
                obj3 = charSequence.subSequence(i4, charSequence.length()).toString();
                this.f26326f = null;
                this.f26323c = null;
                this.f26325e = 3;
                if (sequenceScope.yield(obj3, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            String obj4 = charSequence.toString();
            this.f26325e = 1;
            if (sequenceScope2.yield(obj4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
