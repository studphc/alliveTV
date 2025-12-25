package androidx.privacysandbox.ads.adservices.topics;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: androidx.privacysandbox.ads.adservices.topics.a */
/* loaded from: classes.dex */
public final class C0451a extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ Context f6891b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0451a(Context context) {
        super(1);
        this.f6891b = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Context it = (Context) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return new TopicsManagerApi31Ext11Impl(this.f6891b);
    }
}
