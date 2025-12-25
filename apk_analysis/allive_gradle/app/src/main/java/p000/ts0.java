package p000;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.leanback.R;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class ts0 implements qs0 {

    /* renamed from: a */
    public boolean f26949a;

    /* renamed from: b */
    public float f26950b;

    /* renamed from: c */
    public int f26951c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [ss0, androidx.leanback.widget.g0, java.lang.Object] */
    @Override // p000.qs0
    /* renamed from: a */
    public final void mo7143a(View view, boolean z) {
        if (!this.f26949a) {
            Resources resources = view.getResources();
            TypedValue typedValue = new TypedValue();
            resources.getValue(R.dimen.lb_browse_header_select_scale, typedValue, true);
            this.f26950b = typedValue.getFloat();
            resources.getValue(R.dimen.lb_browse_header_select_duration, typedValue, true);
            this.f26951c = typedValue.data;
            this.f26949a = true;
        }
        view.setSelected(z);
        ss0 ss0Var = (ss0) view.getTag(R.id.lb_focus_animator);
        ss0 ss0Var2 = ss0Var;
        if (ss0Var == null) {
            ?? ss0Var3 = new ss0(view, this.f26950b, false, this.f26951c);
            ViewParent parent = view.getParent();
            while (parent != null && !(parent instanceof RecyclerView)) {
                parent = parent.getParent();
            }
            if (parent != null) {
                ss0Var3.f6298k = (ItemBridgeAdapter.ViewHolder) ((RecyclerView) parent).getChildViewHolder(view);
            }
            view.setTag(R.id.lb_focus_animator, ss0Var3);
            ss0Var2 = ss0Var3;
        }
        ss0Var2.m7401a(z, false);
    }

    @Override // p000.qs0
    /* renamed from: b */
    public final void mo7144b(View view) {
    }
}
