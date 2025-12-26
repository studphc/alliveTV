package p000;

import androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class wu2 extends ContinuationImpl {

    /* renamed from: d */
    public TopicsManagerImplCommon f28338d;

    /* renamed from: e */
    public /* synthetic */ Object f28339e;

    /* renamed from: f */
    public final /* synthetic */ TopicsManagerImplCommon f28340f;

    /* renamed from: g */
    public int f28341g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wu2(TopicsManagerImplCommon topicsManagerImplCommon, Continuation continuation) {
        super(continuation);
        this.f28340f = topicsManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28339e = obj;
        this.f28341g |= Integer.MIN_VALUE;
        return TopicsManagerImplCommon.m1595a(this.f28340f, null, this);
    }
}
