package p000;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: qf */
/* loaded from: classes.dex */
public abstract class AbstractFragmentC1722qf extends Fragment {

    /* renamed from: a */
    public ObjectAdapter f25560a;

    /* renamed from: b */
    public VerticalGridView f25561b;

    /* renamed from: c */
    public PresenterSelector f25562c;

    /* renamed from: f */
    public boolean f25565f;

    /* renamed from: d */
    public final ItemBridgeAdapter f25563d = new ItemBridgeAdapter();

    /* renamed from: e */
    public int f25564e = -1;

    /* renamed from: g */
    public final C1685pf f25566g = new C1685pf(this);

    /* renamed from: h */
    public final C1620of f25567h = new C1620of(this);

    /* renamed from: a */
    public abstract int mo1302a();

    /* renamed from: b */
    public abstract void mo1303b(RecyclerView.ViewHolder viewHolder, int i, int i2);

    /* renamed from: c */
    public final void m7034c() {
        if (this.f25560a == null) {
            return;
        }
        RecyclerView.Adapter adapter = this.f25561b.getAdapter();
        ItemBridgeAdapter itemBridgeAdapter = this.f25563d;
        if (adapter != itemBridgeAdapter) {
            this.f25561b.setAdapter(itemBridgeAdapter);
        }
        if (itemBridgeAdapter.getItemCount() == 0 && this.f25564e >= 0) {
            C1685pf c1685pf = this.f25566g;
            c1685pf.f25143a = true;
            c1685pf.f25144b.f25563d.registerAdapterDataObserver(c1685pf);
        } else {
            int i = this.f25564e;
            if (i >= 0) {
                this.f25561b.setSelectedPosition(i);
            }
        }
    }

    /* renamed from: d */
    public abstract void mo1304d();

    public abstract VerticalGridView findGridViewFromRoot(View view);

    public final ObjectAdapter getAdapter() {
        return this.f25560a;
    }

    public final ItemBridgeAdapter getBridgeAdapter() {
        return this.f25563d;
    }

    public final PresenterSelector getPresenterSelector() {
        return this.f25562c;
    }

    public final VerticalGridView getVerticalGridView() {
        return this.f25561b;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(mo1302a(), viewGroup, false);
        this.f25561b = findGridViewFromRoot(inflate);
        if (this.f25565f) {
            this.f25565f = false;
            onTransitionPrepare();
        }
        return inflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C1685pf c1685pf = this.f25566g;
        if (c1685pf.f25143a) {
            c1685pf.f25143a = false;
            c1685pf.f25144b.f25563d.unregisterAdapterDataObserver(c1685pf);
        }
        VerticalGridView verticalGridView = this.f25561b;
        if (verticalGridView != null) {
            verticalGridView.swapAdapter(null, true);
            this.f25561b = null;
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("currentSelectedPosition", this.f25564e);
    }

    public void onTransitionEnd() {
        VerticalGridView verticalGridView = this.f25561b;
        if (verticalGridView != null) {
            verticalGridView.setLayoutFrozen(false);
            this.f25561b.setAnimateChildLayout(true);
            this.f25561b.setPruneChild(true);
            this.f25561b.setFocusSearchDisabled(false);
            this.f25561b.setScrollEnabled(true);
        }
    }

    public abstract boolean onTransitionPrepare();

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (bundle != null) {
            this.f25564e = bundle.getInt("currentSelectedPosition", -1);
        }
        m7034c();
        this.f25561b.setOnChildViewHolderSelectedListener(this.f25567h);
    }

    public final void setAdapter(ObjectAdapter objectAdapter) {
        if (this.f25560a != objectAdapter) {
            this.f25560a = objectAdapter;
            mo1304d();
        }
    }

    public final void setPresenterSelector(PresenterSelector presenterSelector) {
        if (this.f25562c != presenterSelector) {
            this.f25562c = presenterSelector;
            mo1304d();
        }
    }
}
