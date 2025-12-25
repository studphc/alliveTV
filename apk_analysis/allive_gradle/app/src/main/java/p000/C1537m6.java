package p000;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: m6 */
/* loaded from: classes.dex */
public final class C1537m6 extends ContinuationImpl {

    /* renamed from: d */
    public Object f22818d;

    /* renamed from: e */
    public /* synthetic */ Object f22819e;

    /* renamed from: f */
    public final /* synthetic */ AdSelectionManagerImplCommon$Ext10Impl$Companion f22820f;

    /* renamed from: g */
    public int f22821g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1537m6(AdSelectionManagerImplCommon$Ext10Impl$Companion adSelectionManagerImplCommon$Ext10Impl$Companion, Continuation continuation) {
        super(continuation);
        this.f22820f = adSelectionManagerImplCommon$Ext10Impl$Companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22819e = obj;
        this.f22821g |= Integer.MIN_VALUE;
        return this.f22820f.getAdSelectionData(null, null, this);
    }
}
