package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class oh0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f23806d;

    /* renamed from: e */
    public /* synthetic */ Object f23807e;

    /* renamed from: f */
    public int f23808f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f23807e = obj;
        this.f23808f |= Integer.MIN_VALUE;
        return zh0.m8416a(null, null, null, this);
    }
}
