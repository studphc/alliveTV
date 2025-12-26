package p000;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: tf */
/* loaded from: classes.dex */
public abstract class AbstractC1833tf extends Fragment {

    /* renamed from: e0 */
    public ObjectAdapter f26792e0;

    /* renamed from: f0 */
    public VerticalGridView f26793f0;

    /* renamed from: g0 */
    public PresenterSelector f26794g0;

    /* renamed from: j0 */
    public boolean f26797j0;

    /* renamed from: h0 */
    public final ItemBridgeAdapter f26795h0 = new ItemBridgeAdapter();

    /* renamed from: i0 */
    public int f26796i0 = -1;

    /* renamed from: k0 */
    public final C1796sf f26798k0 = new C1796sf(this);

    /* renamed from: l0 */
    public final C1759rf f26799l0 = new C1759rf(this);

    public abstract VerticalGridView findGridViewFromRoot(View view);

    public final ObjectAdapter getAdapter() {
        return this.f26792e0;
    }

    public final ItemBridgeAdapter getBridgeAdapter() {
        return this.f26795h0;
    }

    public final PresenterSelector getPresenterSelector() {
        return this.f26794g0;
    }

    public final VerticalGridView getVerticalGridView() {
        return this.f26793f0;
    }

    /* renamed from: l */
    public abstract int mo1307l();

    /* renamed from: m */
    public abstract void mo1308m(RecyclerView.ViewHolder viewHolder, int i, int i2);

    /* renamed from: n */
    public final void m7494n() {
        if (this.f26792e0 == null) {
            return;
        }
        RecyclerView.Adapter adapter = this.f26793f0.getAdapter();
        ItemBridgeAdapter itemBridgeAdapter = this.f26795h0;
        if (adapter != itemBridgeAdapter) {
            this.f26793f0.setAdapter(itemBridgeAdapter);
        }
        if (itemBridgeAdapter.getItemCount() == 0 && this.f26796i0 >= 0) {
            C1796sf c1796sf = this.f26798k0;
            c1796sf.f26401a = true;
            c1796sf.f26402b.f26795h0.registerAdapterDataObserver(c1796sf);
        } else {
            int i = this.f26796i0;
            if (i >= 0) {
                this.f26793f0.setSelectedPosition(i);
            }
        }
    }

    /* renamed from: o */
    public abstract void mo1309o();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(mo1307l(), viewGroup, false);
        this.f26793f0 = findGridViewFromRoot(inflate);
        if (this.f26797j0) {
            this.f26797j0 = false;
            onTransitionPrepare();
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C1796sf c1796sf = this.f26798k0;
        if (c1796sf.f26401a) {
            c1796sf.f26401a = false;
            c1796sf.f26402b.f26795h0.unregisterAdapterDataObserver(c1796sf);
        }
        VerticalGridView verticalGridView = this.f26793f0;
        if (verticalGridView != null) {
            verticalGridView.swapAdapter(null, true);
            this.f26793f0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("currentSelectedPosition", this.f26796i0);
    }

    public void onTransitionEnd() {
        VerticalGridView verticalGridView = this.f26793f0;
        if (verticalGridView != null) {
            verticalGridView.setLayoutFrozen(false);
            this.f26793f0.setAnimateChildLayout(true);
            this.f26793f0.setPruneChild(true);
            this.f26793f0.setFocusSearchDisabled(false);
            this.f26793f0.setScrollEnabled(true);
        }
    }

    public abstract boolean onTransitionPrepare();

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (bundle != null) {
            this.f26796i0 = bundle.getInt("currentSelectedPosition", -1);
        }
        m7494n();
        this.f26793f0.setOnChildViewHolderSelectedListener(this.f26799l0);
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        if (this.f26792e0 != objectAdapter) {
            this.f26792e0 = objectAdapter;
            mo1309o();
        }
    }

    public final void setPresenterSelector(PresenterSelector presenterSelector) {
        if (this.f26794g0 != presenterSelector) {
            this.f26794g0 = presenterSelector;
            mo1309o();
        }
    }
}
