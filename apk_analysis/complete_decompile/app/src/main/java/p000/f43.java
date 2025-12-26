package p000;

import android.view.View;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class f43 extends Lambda implements Function1 {

    /* renamed from: b */
    public static final f43 f17125b = new Lambda(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        View view = (View) obj;
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
        if (tag instanceof ViewModelStoreOwner) {
            return (ViewModelStoreOwner) tag;
        }
        return null;
    }
}
