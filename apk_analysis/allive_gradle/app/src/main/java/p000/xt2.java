package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutKt;

/* loaded from: classes2.dex */
public final class xt2 extends ContinuationImpl {

    /* renamed from: d */
    public Function2 f28733d;

    /* renamed from: e */
    public Ref.ObjectRef f28734e;

    /* renamed from: f */
    public /* synthetic */ Object f28735f;

    /* renamed from: g */
    public int f28736g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28735f = obj;
        this.f28736g |= Integer.MIN_VALUE;
        return TimeoutKt.withTimeoutOrNull(0L, null, this);
    }
}
