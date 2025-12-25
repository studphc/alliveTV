package androidx.activity;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: androidx.activity.e */
/* loaded from: classes.dex */
public final class C0078e extends Lambda implements Function1 {

    /* renamed from: b */
    public static final C0078e f534b = new Lambda(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        View it = (View) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Object tag = it.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
        if (tag instanceof OnBackPressedDispatcherOwner) {
            return (OnBackPressedDispatcherOwner) tag;
        }
        return null;
    }
}
