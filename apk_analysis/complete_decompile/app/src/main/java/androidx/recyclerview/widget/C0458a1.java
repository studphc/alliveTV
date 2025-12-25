package androidx.recyclerview.widget;

import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.a1 */
/* loaded from: classes.dex */
public final class C0458a1 extends RecyclerView.EdgeEffectFactory {
    @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
    public final EdgeEffect createEdgeEffect(RecyclerView recyclerView, int i) {
        return new EdgeEffect(recyclerView.getContext());
    }
}
