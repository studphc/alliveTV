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
import p000.AbstractC1833tf;
import p000.e01;
import p000.h01;
import p000.i01;

/* loaded from: classes.dex */
public class HeadersSupportFragment extends AbstractC1833tf {

    /* renamed from: u0 */
    public static final ClassPresenterSelector f5029u0 = new ClassPresenterSelector().addClassPresenter(DividerRow.class, new DividerPresenter()).addClassPresenter(SectionRow.class, new RowHeaderPresenter(R.layout.lb_section_header, false)).addClassPresenter(Row.class, new RowHeaderPresenter(R.layout.lb_header));

    /* renamed from: v0 */
    public static final e01 f5030v0 = new e01(1);

    /* renamed from: m0 */
    public OnHeaderViewSelectedListener f5031m0;

    /* renamed from: n0 */
    public OnHeaderClickedListener f5032n0;

    /* renamed from: q0 */
    public int f5035q0;

    /* renamed from: r0 */
    public boolean f5036r0;

    /* renamed from: o0 */
    public boolean f5033o0 = true;

    /* renamed from: p0 */
    public boolean f5034p0 = false;

    /* renamed from: s0 */
    public final h01 f5037s0 = new h01(this);

    /* renamed from: t0 */
    public final i01 f5038t0 = new ItemBridgeAdapter.Wrapper();

    /* loaded from: classes.dex */
    public interface OnHeaderClickedListener {
        void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row);
    }

    /* loaded from: classes.dex */
    public interface OnHeaderViewSelectedListener {
        void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.leanback.widget.ItemBridgeAdapter$Wrapper, i01] */
    public HeadersSupportFragment() {
        setPresenterSelector(f5029u0);
        FocusHighlightHelper.setupHeaderItemFocusHighlight(getBridgeAdapter());
    }

    @Override // p000.AbstractC1833tf
    public final VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view.findViewById(R.id.browse_headers);
    }

    public int getSelectedPosition() {
        return this.f26796i0;
    }

    public boolean isScrolling() {
        if (getVerticalGridView().getScrollState() != 0) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1833tf
    /* renamed from: l */
    public final int mo1307l() {
        return R.layout.lb_headers_fragment;
    }

    @Override // p000.AbstractC1833tf
    /* renamed from: m */
    public final void mo1308m(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        OnHeaderViewSelectedListener onHeaderViewSelectedListener = this.f5031m0;
        if (onHeaderViewSelectedListener != null) {
            if (viewHolder != null && i >= 0) {
                ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) viewHolder;
                onHeaderViewSelectedListener.onHeaderSelected((RowHeaderPresenter.ViewHolder) viewHolder2.getViewHolder(), (Row) viewHolder2.getItem());
            } else {
                onHeaderViewSelectedListener.onHeaderSelected(null, null);
            }
        }
    }

    @Override // p000.AbstractC1833tf
    /* renamed from: o */
    public final void mo1309o() {
        ItemBridgeAdapter itemBridgeAdapter = this.f26795h0;
        itemBridgeAdapter.setAdapter(this.f26792e0);
        itemBridgeAdapter.setPresenter(this.f26794g0);
        if (this.f26793f0 != null) {
            m7494n();
        }
        ItemBridgeAdapter bridgeAdapter = getBridgeAdapter();
        bridgeAdapter.setAdapterListener(this.f5037s0);
        bridgeAdapter.setWrapper(this.f5038t0);
    }

    @Override // p000.AbstractC1833tf, androidx.fragment.app.Fragment
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // p000.AbstractC1833tf, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // p000.AbstractC1833tf, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // p000.AbstractC1833tf
    public void onTransitionEnd() {
        VerticalGridView verticalGridView;
        if (this.f5033o0 && (verticalGridView = getVerticalGridView()) != null) {
            verticalGridView.setDescendantFocusability(262144);
            if (verticalGridView.hasFocus()) {
                verticalGridView.requestFocus();
            }
        }
        super.onTransitionEnd();
    }

    @Override // p000.AbstractC1833tf
    public boolean onTransitionPrepare() {
        VerticalGridView verticalGridView = this.f26793f0;
        if (verticalGridView != null) {
            verticalGridView.setAnimateChildLayout(false);
            this.f26793f0.setScrollEnabled(false);
            return true;
        }
        this.f26797j0 = true;
        return false;
    }

    public void onTransitionStart() {
        VerticalGridView verticalGridView;
        VerticalGridView verticalGridView2 = this.f26793f0;
        if (verticalGridView2 != null) {
            verticalGridView2.setPruneChild(false);
            this.f26793f0.setLayoutFrozen(true);
            this.f26793f0.setFocusSearchDisabled(true);
        }
        if (!this.f5033o0 && (verticalGridView = getVerticalGridView()) != null) {
            verticalGridView.setDescendantFocusability(131072);
            if (verticalGridView.hasFocus()) {
                verticalGridView.requestFocus();
            }
        }
    }

    @Override // p000.AbstractC1833tf, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView == null) {
            return;
        }
        if (this.f5036r0) {
            verticalGridView.setBackgroundColor(this.f5035q0);
            m1310p(this.f5035q0);
        } else {
            Drawable background = verticalGridView.getBackground();
            if (background instanceof ColorDrawable) {
                m1310p(((ColorDrawable) background).getColor());
            }
        }
        m1311q();
    }

    /* renamed from: p */
    public final void m1310p(int i) {
        Drawable background = getView().findViewById(R.id.fade_out_edge).getBackground();
        if (background instanceof GradientDrawable) {
            background.mutate();
            ((GradientDrawable) background).setColors(new int[]{0, i});
        }
    }

    /* renamed from: q */
    public final void m1311q() {
        int i;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            View view = getView();
            if (this.f5034p0) {
                i = 8;
            } else {
                i = 0;
            }
            view.setVisibility(i);
            if (!this.f5034p0) {
                if (this.f5033o0) {
                    verticalGridView.setChildrenVisibility(0);
                } else {
                    verticalGridView.setChildrenVisibility(4);
                }
            }
        }
    }

    public void setAlignment(int i) {
        VerticalGridView verticalGridView = this.f26793f0;
        if (verticalGridView != null) {
            verticalGridView.setItemAlignmentOffset(0);
            this.f26793f0.setItemAlignmentOffsetPercent(-1.0f);
            this.f26793f0.setWindowAlignmentOffset(i);
            this.f26793f0.setWindowAlignmentOffsetPercent(-1.0f);
            this.f26793f0.setWindowAlignment(0);
        }
    }

    public void setOnHeaderClickedListener(OnHeaderClickedListener onHeaderClickedListener) {
        this.f5032n0 = onHeaderClickedListener;
    }

    public void setOnHeaderViewSelectedListener(OnHeaderViewSelectedListener onHeaderViewSelectedListener) {
        this.f5031m0 = onHeaderViewSelectedListener;
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public void setSelectedPosition(int i, boolean z) {
        if (this.f26796i0 == i) {
            return;
        }
        this.f26796i0 = i;
        VerticalGridView verticalGridView = this.f26793f0;
        if (verticalGridView == null || this.f26798k0.f26401a) {
            return;
        }
        if (z) {
            verticalGridView.setSelectedPositionSmooth(i);
        } else {
            verticalGridView.setSelectedPosition(i);
        }
    }
}
