package androidx.core.view;

import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import p000.n71;

/* loaded from: classes.dex */
public final class LayoutInflaterCompat {
    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof n71) {
            return ((n71) factory).f23266a;
        }
        return null;
    }

    @Deprecated
    public static void setFactory(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(new n71(layoutInflaterFactory));
    }

    public static void setFactory2(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
