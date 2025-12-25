package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.selects.SelectImplementation;

/* loaded from: classes2.dex */
public final class yf2 extends ContinuationImpl {

    /* renamed from: d */
    public SelectImplementation f28939d;

    /* renamed from: e */
    public /* synthetic */ Object f28940e;

    /* renamed from: f */
    public final /* synthetic */ SelectImplementation f28941f;

    /* renamed from: g */
    public int f28942g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf2(SelectImplementation selectImplementation, Continuation continuation) {
        super(continuation);
        this.f28941f = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m5746b;
        this.f28940e = obj;
        this.f28942g |= Integer.MIN_VALUE;
        m5746b = this.f28941f.m5746b(this);
        return m5746b;
    }
}
