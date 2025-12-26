package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;

/* renamed from: androidx.recyclerview.widget.b */
/* loaded from: classes.dex */
public final class C0459b extends DiffUtil.Callback {

    /* renamed from: a */
    public final /* synthetic */ RunnableC0465d f7319a;

    public C0459b(RunnableC0465d runnableC0465d) {
        this.f7319a = runnableC0465d;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int i, int i2) {
        RunnableC0465d runnableC0465d = this.f7319a;
        Object obj = runnableC0465d.f7332a.get(i);
        Object obj2 = runnableC0465d.f7333b.get(i2);
        if (obj != null && obj2 != null) {
            return runnableC0465d.f7336e.f6932b.getDiffCallback().areContentsTheSame(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int i, int i2) {
        RunnableC0465d runnableC0465d = this.f7319a;
        Object obj = runnableC0465d.f7332a.get(i);
        Object obj2 = runnableC0465d.f7333b.get(i2);
        if (obj != null && obj2 != null) {
            return runnableC0465d.f7336e.f6932b.getDiffCallback().areItemsTheSame(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int i, int i2) {
        RunnableC0465d runnableC0465d = this.f7319a;
        Object obj = runnableC0465d.f7332a.get(i);
        Object obj2 = runnableC0465d.f7333b.get(i2);
        if (obj != null && obj2 != null) {
            return runnableC0465d.f7336e.f6932b.getDiffCallback().getChangePayload(obj, obj2);
        }
        throw new AssertionError();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f7319a.f7333b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f7319a.f7332a.size();
    }
}
