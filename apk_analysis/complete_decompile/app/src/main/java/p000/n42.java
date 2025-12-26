package p000;

import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.picker.Picker;
import androidx.leanback.widget.picker.PickerColumn;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class n42 extends OnChildViewHolderSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ Picker f23227a;

    public n42(Picker picker) {
        this.f23227a = picker;
    }

    @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
    public final void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, int i2) {
        Picker picker = this.f23227a;
        int indexOf = picker.f6360b.indexOf((VerticalGridView) recyclerView);
        picker.m1514c(indexOf);
        if (viewHolder != null) {
            picker.onColumnValueChanged(indexOf, ((PickerColumn) picker.f6361c.get(indexOf)).getMinValue() + i);
        }
    }
}
