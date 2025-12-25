package androidx.leanback.app;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DividerPresenter;
import androidx.leanback.widget.DividerRow;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.SectionRow;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import p000.AbstractFragmentC1722qf;
import p000.d01;
import p000.e01;
import p000.f01;

@Deprecated
/* loaded from: classes.dex */
public class HeadersFragment extends AbstractFragmentC1722qf {

    /* renamed from: q */
    public static final ClassPresenterSelector f5019q = new ClassPresenterSelector().addClassPresenter(DividerRow.class, new DividerPresenter()).addClassPresenter(SectionRow.class, new RowHeaderPresenter(R.layout.lb_section_header, false)).addClassPresenter(Row.class, new RowHeaderPresenter(R.layout.lb_header));

    /* renamed from: r */
    public static final e01 f5020r = new e01(0);

    /* renamed from: i */
    public OnHeaderViewSelectedListener f5021i;

    /* renamed from: j */
    public OnHeaderClickedListener f5022j;

    /* renamed from: m */
    public int f5025m;

    /* renamed from: n */
    public boolean f5026n;

    /* renamed from: k */
    public boolean f5023k = true;

    /* renamed from: l */
    public boolean f5024l = false;

    /* renamed from: o */
    public final d01 f5027o = new d01(this);

    /* renamed from: p */
    public final f01 f5028p = new ItemBridgeAdapter.Wrapper();

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnHeaderClickedListener {
        void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnHeaderViewSelectedListener {
        void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.leanback.widget.ItemBridgeAdapter$Wrapper, f01] */
    public HeadersFragment() {
        setPresenterSelector(f5019q);
        FocusHighlightHelper.setupHeaderItemFocusHighlight(getBridgeAdapter());
    }

    @Override // p000.AbstractFragmentC1722qf
    /* renamed from: a */
    public final int mo1302a() {
        return R.layout.lb_headers_fragment;
    }

    @Override // p000.AbstractFragmentC1722qf
    /* renamed from: b */
    public final void mo1303b(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        OnHeaderViewSelectedListener onHeaderViewSelectedListener = this.f5021i;
        if (onHeaderViewSelectedListener != null) {
            if (viewHolder != null && i >= 0) {
                ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) viewHolder;
                onHeaderViewSelectedListener.onHeaderSelected((RowHeaderPresenter.ViewHolder) viewHolder2.getViewHolder(), (Row) viewHolder2.getItem());
            } else {
                onHeaderViewSelectedListener.onHeaderSelected(null, null);
            }
        }
    }

    @Override // p000.AbstractFragmentC1722qf
    /* renamed from: d */
    public final void mo1304d() {
        ItemBridgeAdapter itemBridgeAdapter = this.f25563d;
        itemBridgeAdapter.setAdapter(this.f25560a);
        itemBridgeAdapter.setPresenter(this.f25562c);
        if (this.f25561b != null) {
            m7034c();
        }
        ItemBridgeAdapter bridgeAdapter = getBridgeAdapter();
        bridgeAdapter.setAdapterListener(this.f5027o);
        bridgeAdapter.setWrapper(this.f5028p);
    }

    /* renamed from: e */
    public final void m1305e(int i) {
        Drawable background = getView().findViewById(R.id.fade_out_edge).getBackground();
        if (background instanceof GradientDrawable) {
            background.mutate();
            ((GradientDrawable) background).setColors(new int[]{0, i});
        }
    }

    /* renamed from: f */
    public final void m1306f() {
        int i;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            View view = getView();
            if (this.f5024l) {
                i = 8;
            } else {
                i = 0;
            }
            view.setVisibility(i);
            if (!this.f5024l) {
                if (this.f5023k) {
                    verticalGridView.setChildrenVisibility(0);
                } else {
                    verticalGridView.setChildrenVisibility(4);
                }
            }
        }
    }

    @Override // p000.AbstractFragmentC1722qf
    public final VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view.findViewById(R.id.browse_headers);
    }

    public int getSelectedPosition() {
        return this.f25564e;
    }

    public boolean isScrolling() {
        if (getVerticalGridView().getScrollState() != 0) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractFragmentC1722qf, android.app.Fragment
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // p000.AbstractFragmentC1722qf, android.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // p000.AbstractFragmentC1722qf, android.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // p000.AbstractFragmentC1722qf
    public void onTransitionEnd() {
        VerticalGridView verticalGridView;
        if (this.f5023k && (verticalGridView = getVerticalGridView()) != null) {
            verticalGridView.setDescendantFocusability(262144);
            if (verticalGridView.hasFocus()) {
                verticalGridView.requestFocus();
            }
        }
        super.onTransitionEnd();
    }

    @Override // p000.AbstractFragmentC1722qf
    public boolean onTransitionPrepare() {
        VerticalGridView verticalGridView = this.f25561b;
        if (verticalGridView != null) {
            verticalGridView.setAnimateChildLayout(false);
            this.f25561b.setScrollEnabled(false);
            return true;
        }
        this.f25565f = true;
        return false;
    }

    public void onTransitionStart() {
        VerticalGridView verticalGridView;
        VerticalGridView verticalGridView2 = this.f25561b;
        if (verticalGridView2 != null) {
            verticalGridView2.setPruneChild(false);
            this.f25561b.setLayoutFrozen(true);
            this.f25561b.setFocusSearchDisabled(true);
        }
        if (!this.f5023k && (verticalGridView = getVerticalGridView()) != null) {
            verticalGridView.setDescendantFocusability(131072);
            if (verticalGridView.hasFocus()) {
                verticalGridView.requestFocus();
            }
        }
    }

    @Override // p000.AbstractFragmentC1722qf, android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView == null) {
            return;
        }
        if (this.f5026n) {
            verticalGridView.setBackgroundColor(this.f5025m);
            m1305e(this.f5025m);
        } else {
            Drawable background = verticalGridView.getBackground();
            if (background instanceof ColorDrawable) {
                m1305e(((ColorDrawable) background).getColor());
            }
        }
        m1306f();
    }

    public void setAlignment(int i) {
        VerticalGridView verticalGridView = this.f25561b;
        if (verticalGridView != null) {
            verticalGridView.setItemAlignmentOffset(0);
            this.f25561b.setItemAlignmentOffsetPercent(-1.0f);
            this.f25561b.setWindowAlignmentOffset(i);
            this.f25561b.setWindowAlignmentOffsetPercent(-1.0f);
            this.f25561b.setWindowAlignment(0);
        }
    }

    public void setOnHeaderClickedListener(OnHeaderClickedListener onHeaderClickedListener) {
        this.f5022j = onHeaderClickedListener;
    }

    public void setOnHeaderViewSelectedListener(OnHeaderViewSelectedListener onHeaderViewSelectedListener) {
        this.f5021i = onHeaderViewSelectedListener;
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public void setSelectedPosition(int i, boolean z) {
        if (this.f25564e == i) {
            return;
        }
        this.f25564e = i;
        VerticalGridView verticalGridView = this.f25561b;
        if (verticalGridView == null || this.f25566g.f25143a) {
            return;
        }
        if (z) {
            verticalGridView.setSelectedPositionSmooth(i);
        } else {
            verticalGridView.setSelectedPosition(i);
        }
    }
}
