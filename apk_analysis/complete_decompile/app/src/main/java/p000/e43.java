package p000;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.runtime.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class e43 extends Lambda implements Function1 {

    /* renamed from: b */
    public static final e43 f16672b = new Lambda(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        View viewParent = (View) obj;
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        Object tag = viewParent.getTag(R.id.view_tree_lifecycle_owner);
        if (tag instanceof LifecycleOwner) {
            return (LifecycleOwner) tag;
        }
        return null;
    }
}
