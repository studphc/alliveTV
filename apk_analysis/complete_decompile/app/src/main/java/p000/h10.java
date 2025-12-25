package p000;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class h10 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f17914b;

    /* renamed from: c */
    public final /* synthetic */ Collection f17915c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h10(Collection collection, int i) {
        super(1);
        this.f17914b = i;
        this.f17915c = collection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f17914b) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                Intrinsics.checkNotNullParameter(entry, "entry");
                return Boolean.valueOf(CollectionsKt___CollectionsKt.contains(this.f17915c, ViewCompat.getTransitionName((View) entry.getValue())));
            default:
                return Boolean.valueOf(this.f17915c.contains(obj));
        }
    }
}
