package p000;

import android.view.ViewParent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes.dex */
public final /* synthetic */ class k33 extends FunctionReferenceImpl implements Function1 {

    /* renamed from: h */
    public static final k33 f20743h = new FunctionReferenceImpl(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((ViewParent) obj).getParent();
    }
}
