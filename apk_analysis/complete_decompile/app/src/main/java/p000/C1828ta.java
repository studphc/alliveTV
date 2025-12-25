package p000;

import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: ta */
/* loaded from: classes.dex */
public final class C1828ta extends ContinuationImpl {

    /* renamed from: d */
    public AppSetIdManagerImplCommon f26735d;

    /* renamed from: e */
    public /* synthetic */ Object f26736e;

    /* renamed from: f */
    public final /* synthetic */ AppSetIdManagerImplCommon f26737f;

    /* renamed from: g */
    public int f26738g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1828ta(AppSetIdManagerImplCommon appSetIdManagerImplCommon, Continuation continuation) {
        super(continuation);
        this.f26737f = appSetIdManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26736e = obj;
        this.f26738g |= Integer.MIN_VALUE;
        return AppSetIdManagerImplCommon.m1580a(this.f26737f, this);
    }
}
