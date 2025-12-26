package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Job;

/* renamed from: fe */
/* loaded from: classes2.dex */
public final class C1192fe extends ContinuationImpl {

    /* renamed from: d */
    public Object[] f17228d;

    /* renamed from: e */
    public int f17229e;

    /* renamed from: f */
    public int f17230f;

    /* renamed from: g */
    public /* synthetic */ Object f17231g;

    /* renamed from: h */
    public int f17232h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f17231g = obj;
        this.f17232h |= Integer.MIN_VALUE;
        return AwaitKt.joinAll((Job[]) null, this);
    }
}
