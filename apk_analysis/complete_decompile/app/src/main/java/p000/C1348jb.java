package p000;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.DiffCallback;
import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

/* renamed from: jb */
/* loaded from: classes.dex */
public final class C1348jb extends DiffUtil.Callback {

    /* renamed from: a */
    public final /* synthetic */ List f20441a;

    /* renamed from: b */
    public final /* synthetic */ DiffCallback f20442b;

    /* renamed from: c */
    public final /* synthetic */ ArrayObjectAdapter f20443c;

    public C1348jb(ArrayObjectAdapter arrayObjectAdapter, List list, DiffCallback diffCallback) {
        this.f20443c = arrayObjectAdapter;
        this.f20441a = list;
        this.f20442b = diffCallback;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int i, int i2) {
        return this.f20442b.areContentsTheSame(this.f20443c.f5563e.get(i), this.f20441a.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int i, int i2) {
        return this.f20442b.areItemsTheSame(this.f20443c.f5563e.get(i), this.f20441a.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int i, int i2) {
        return this.f20442b.getChangePayload(this.f20443c.f5563e.get(i), this.f20441a.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f20441a.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f20443c.f5563e.size();
    }
}
