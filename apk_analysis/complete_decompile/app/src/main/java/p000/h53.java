package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.selects.WhileSelectKt;

/* loaded from: classes2.dex */
public final class h53 extends ContinuationImpl {

    /* renamed from: d */
    public Function1 f17946d;

    /* renamed from: e */
    public /* synthetic */ Object f17947e;

    /* renamed from: f */
    public int f17948f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f17947e = obj;
        this.f17948f |= Integer.MIN_VALUE;
        return WhileSelectKt.whileSelect(null, this);
    }
}
