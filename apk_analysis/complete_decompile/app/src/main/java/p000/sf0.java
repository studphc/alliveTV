package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class sf0 extends ContinuationImpl {

    /* renamed from: d */
    public tf0 f26403d;

    /* renamed from: e */
    public /* synthetic */ Object f26404e;

    /* renamed from: f */
    public final /* synthetic */ tf0 f26405f;

    /* renamed from: g */
    public int f26406g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sf0(tf0 tf0Var, Continuation continuation) {
        super(continuation);
        this.f26405f = tf0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26404e = obj;
        this.f26406g |= Integer.MIN_VALUE;
        return this.f26405f.emit(null, this);
    }
}
