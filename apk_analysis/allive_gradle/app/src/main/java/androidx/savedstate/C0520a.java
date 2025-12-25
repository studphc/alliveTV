package androidx.savedstate;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: androidx.savedstate.a */
/* loaded from: classes.dex */
public final class C0520a extends Lambda implements Function1 {

    /* renamed from: b */
    public static final C0520a f7537b = new Lambda(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        View view = (View) obj;
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(R.id.view_tree_saved_state_registry_owner);
        if (tag instanceof SavedStateRegistryOwner) {
            return (SavedStateRegistryOwner) tag;
        }
        return null;
    }
}
