package p000;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.picker.Picker;
import androidx.leanback.widget.picker.PickerColumn;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o42 extends RecyclerView.Adapter {

    /* renamed from: d */
    public final int f23601d;

    /* renamed from: e */
    public final int f23602e;

    /* renamed from: f */
    public final int f23603f;

    /* renamed from: g */
    public final PickerColumn f23604g;

    /* renamed from: h */
    public final /* synthetic */ Picker f23605h;

    public o42(Picker picker, int i, int i2, int i3) {
        this.f23605h = picker;
        this.f23601d = i;
        this.f23602e = i3;
        this.f23603f = i2;
        this.f23604g = (PickerColumn) picker.f6361c.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        PickerColumn pickerColumn = this.f23604g;
        if (pickerColumn == null) {
            return 0;
        }
        return pickerColumn.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        boolean z;
        PickerColumn pickerColumn;
        p42 p42Var = (p42) viewHolder;
        TextView textView = p42Var.f25029t;
        if (textView != null && (pickerColumn = this.f23604g) != null) {
            textView.setText(pickerColumn.getLabelFor(pickerColumn.getMinValue() + i));
        }
        View view = p42Var.itemView;
        Picker picker = this.f23605h;
        ArrayList arrayList = picker.f6360b;
        int i2 = this.f23602e;
        if (((VerticalGridView) arrayList.get(i2)).getSelectedPosition() == i) {
            z = true;
        } else {
            z = false;
        }
        picker.m1513b(view, z, i2, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TextView textView;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f23601d, viewGroup, false);
        int i2 = this.f23603f;
        if (i2 != 0) {
            textView = (TextView) inflate.findViewById(i2);
        } else {
            textView = (TextView) inflate;
        }
        return new p42(inflate, textView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ((p42) viewHolder).itemView.setFocusable(this.f23605h.isActivated());
    }
}
