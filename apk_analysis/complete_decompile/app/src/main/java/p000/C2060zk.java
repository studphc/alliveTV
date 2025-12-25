package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: zk */
/* loaded from: classes2.dex */
public final class C2060zk extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f29403d;

    /* renamed from: e */
    public final /* synthetic */ C0022al f29404e;

    /* renamed from: f */
    public int f29405f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2060zk(C0022al c0022al, Continuation continuation) {
        super(continuation);
        this.f29404e = c0022al;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29403d = obj;
        this.f29405f |= Integer.MIN_VALUE;
        return this.f29404e.emit(null, this);
    }
}
