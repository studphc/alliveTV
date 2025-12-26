package p000;

import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;
import androidx.recyclerview.widget.DiffUtil;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class fy0 extends DiffUtil.Callback {

    /* renamed from: a */
    public final /* synthetic */ ArrayList f17446a;

    /* renamed from: b */
    public final /* synthetic */ GuidedActionAdapter f17447b;

    public fy0(GuidedActionAdapter guidedActionAdapter, ArrayList arrayList) {
        this.f17447b = guidedActionAdapter;
        this.f17446a = arrayList;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int i, int i2) {
        GuidedActionAdapter guidedActionAdapter = this.f17447b;
        return guidedActionAdapter.f5773n.areContentsTheSame((GuidedAction) this.f17446a.get(i), (GuidedAction) guidedActionAdapter.f5769j.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int i, int i2) {
        GuidedActionAdapter guidedActionAdapter = this.f17447b;
        return guidedActionAdapter.f5773n.areItemsTheSame((GuidedAction) this.f17446a.get(i), (GuidedAction) guidedActionAdapter.f5769j.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int i, int i2) {
        GuidedActionAdapter guidedActionAdapter = this.f17447b;
        return guidedActionAdapter.f5773n.getChangePayload((GuidedAction) this.f17446a.get(i), (GuidedAction) guidedActionAdapter.f5769j.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f17447b.f5769j.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f17446a.size();
    }
}
