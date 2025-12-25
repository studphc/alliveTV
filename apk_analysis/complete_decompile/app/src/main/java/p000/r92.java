package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;

/* loaded from: classes2.dex */
public final /* synthetic */ class r92 extends FunctionReferenceImpl implements Function1 {

    /* renamed from: h */
    public static final r92 f25912h = new FunctionReferenceImpl(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        MatchResult p0 = (MatchResult) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.next();
    }
}
