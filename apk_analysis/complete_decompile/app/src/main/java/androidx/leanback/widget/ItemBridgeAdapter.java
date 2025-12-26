package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import p000.l51;
import p000.qs0;

/* loaded from: classes.dex */
public class ItemBridgeAdapter extends RecyclerView.Adapter implements FacetProviderAdapter {

    /* renamed from: d */
    public ObjectAdapter f5868d;

    /* renamed from: e */
    public Wrapper f5869e;

    /* renamed from: f */
    public PresenterSelector f5870f;

    /* renamed from: g */
    public qs0 f5871g;

    /* renamed from: h */
    public AdapterListener f5872h;

    /* renamed from: i */
    public ArrayList f5873i;

    /* renamed from: j */
    public final C0342h1 f5874j;

    /* loaded from: classes.dex */
    public static class AdapterListener {
        public void onAddPresenter(Presenter presenter, int i) {
        }

        public void onAttachedToWindow(ViewHolder viewHolder) {
        }

        public void onBind(ViewHolder viewHolder) {
        }

        public void onCreate(ViewHolder viewHolder) {
        }

        public void onDetachedFromWindow(ViewHolder viewHolder) {
        }

        public void onUnbind(ViewHolder viewHolder) {
        }

        public void onBind(ViewHolder viewHolder, List list) {
            onBind(viewHolder);
        }
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder implements FacetProvider {

        /* renamed from: t */
        public final Presenter f5875t;

        /* renamed from: u */
        public final Presenter.ViewHolder f5876u;

        /* renamed from: v */
        public Object f5877v;

        /* renamed from: w */
        public Object f5878w;

        public ViewHolder(Presenter presenter, View view, Presenter.ViewHolder viewHolder) {
            super(view);
            this.f5875t = presenter;
            this.f5876u = viewHolder;
        }

        public final Object getExtraObject() {
            return this.f5878w;
        }

        @Override // androidx.leanback.widget.FacetProvider
        public Object getFacet(Class<?> cls) {
            return this.f5876u.getFacet(cls);
        }

        public final Object getItem() {
            return this.f5877v;
        }

        public final Presenter getPresenter() {
            return this.f5875t;
        }

        public final Presenter.ViewHolder getViewHolder() {
            return this.f5876u;
        }

        public void setExtraObject(Object obj) {
            this.f5878w = obj;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Wrapper {
        public abstract View createWrapper(View view);

        public abstract void wrap(View view, View view2);
    }

    public ItemBridgeAdapter(ObjectAdapter objectAdapter, PresenterSelector presenterSelector) {
        this.f5873i = new ArrayList();
        this.f5874j = new C0342h1(this);
        setAdapter(objectAdapter);
        this.f5870f = presenterSelector;
    }

    public void clear() {
        setAdapter(null);
    }

    @Override // androidx.leanback.widget.FacetProviderAdapter
    public FacetProvider getFacetProvider(int i) {
        return (FacetProvider) this.f5873i.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ObjectAdapter objectAdapter = this.f5868d;
        if (objectAdapter != null) {
            return objectAdapter.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.f5868d.getId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        PresenterSelector presenterSelector = this.f5870f;
        if (presenterSelector == null) {
            presenterSelector = this.f5868d.getPresenterSelector();
        }
        Presenter presenter = presenterSelector.getPresenter(this.f5868d.get(i));
        int indexOf = this.f5873i.indexOf(presenter);
        if (indexOf < 0) {
            this.f5873i.add(presenter);
            indexOf = this.f5873i.indexOf(presenter);
            onAddPresenter(presenter, indexOf);
            AdapterListener adapterListener = this.f5872h;
            if (adapterListener != null) {
                adapterListener.onAddPresenter(presenter, indexOf);
            }
        }
        return indexOf;
    }

    public ArrayList<Presenter> getPresenterMapper() {
        return this.f5873i;
    }

    public Wrapper getWrapper() {
        return this.f5869e;
    }

    public void onAddPresenter(Presenter presenter, int i) {
    }

    public void onAttachedToWindow(ViewHolder viewHolder) {
    }

    public void onBind(ViewHolder viewHolder) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Object obj = this.f5868d.get(i);
        viewHolder2.f5877v = obj;
        viewHolder2.f5875t.onBindViewHolder(viewHolder2.f5876u, obj);
        onBind(viewHolder2);
        AdapterListener adapterListener = this.f5872h;
        if (adapterListener != null) {
            adapterListener.onBind(viewHolder2);
        }
    }

    public void onCreate(ViewHolder viewHolder) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Presenter.ViewHolder onCreateViewHolder;
        View view;
        Presenter presenter = (Presenter) this.f5873i.get(i);
        Wrapper wrapper = this.f5869e;
        if (wrapper != null) {
            view = wrapper.createWrapper(viewGroup);
            onCreateViewHolder = presenter.onCreateViewHolder(viewGroup);
            this.f5869e.wrap(view, onCreateViewHolder.view);
        } else {
            onCreateViewHolder = presenter.onCreateViewHolder(viewGroup);
            view = onCreateViewHolder.view;
        }
        ViewHolder viewHolder = new ViewHolder(presenter, view, onCreateViewHolder);
        onCreate(viewHolder);
        AdapterListener adapterListener = this.f5872h;
        if (adapterListener != null) {
            adapterListener.onCreate(viewHolder);
        }
        View view2 = viewHolder.f5876u.view;
        View.OnFocusChangeListener onFocusChangeListener = view2.getOnFocusChangeListener();
        qs0 qs0Var = this.f5871g;
        if (qs0Var != null) {
            boolean z = false;
            if (onFocusChangeListener instanceof l51) {
                l51 l51Var = (l51) onFocusChangeListener;
                if (this.f5869e != null) {
                    z = true;
                }
                l51Var.f22329b = z;
                l51Var.f22330c = qs0Var;
            } else {
                if (this.f5869e != null) {
                    z = true;
                }
                view2.setOnFocusChangeListener(new l51(onFocusChangeListener, z, qs0Var));
            }
            this.f5871g.mo7144b(view);
        } else if (onFocusChangeListener instanceof l51) {
            view2.setOnFocusChangeListener(((l51) onFocusChangeListener).f22328a);
        }
        return viewHolder;
    }

    public void onDetachedFromWindow(ViewHolder viewHolder) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        onViewRecycled(viewHolder);
        return false;
    }

    public void onUnbind(ViewHolder viewHolder) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        onAttachedToWindow(viewHolder2);
        AdapterListener adapterListener = this.f5872h;
        if (adapterListener != null) {
            adapterListener.onAttachedToWindow(viewHolder2);
        }
        viewHolder2.f5875t.onViewAttachedToWindow(viewHolder2.f5876u);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.f5875t.onViewDetachedFromWindow(viewHolder2.f5876u);
        onDetachedFromWindow(viewHolder2);
        AdapterListener adapterListener = this.f5872h;
        if (adapterListener != null) {
            adapterListener.onDetachedFromWindow(viewHolder2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.f5875t.onUnbindViewHolder(viewHolder2.f5876u);
        onUnbind(viewHolder2);
        AdapterListener adapterListener = this.f5872h;
        if (adapterListener != null) {
            adapterListener.onUnbind(viewHolder2);
        }
        viewHolder2.f5877v = null;
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        ObjectAdapter objectAdapter2 = this.f5868d;
        if (objectAdapter == objectAdapter2) {
            return;
        }
        C0342h1 c0342h1 = this.f5874j;
        if (objectAdapter2 != null) {
            objectAdapter2.unregisterObserver(c0342h1);
        }
        this.f5868d = objectAdapter;
        if (objectAdapter == null) {
            notifyDataSetChanged();
            return;
        }
        objectAdapter.registerObserver(c0342h1);
        if (hasStableIds() != this.f5868d.hasStableIds()) {
            setHasStableIds(this.f5868d.hasStableIds());
        }
        notifyDataSetChanged();
    }

    public void setAdapterListener(AdapterListener adapterListener) {
        this.f5872h = adapterListener;
    }

    public void setPresenter(PresenterSelector presenterSelector) {
        this.f5870f = presenterSelector;
        notifyDataSetChanged();
    }

    public void setPresenterMapper(ArrayList<Presenter> arrayList) {
        this.f5873i = arrayList;
    }

    public void setWrapper(Wrapper wrapper) {
        this.f5869e = wrapper;
    }

    public ItemBridgeAdapter(ObjectAdapter objectAdapter) {
        this(objectAdapter, null);
    }

    public ItemBridgeAdapter() {
        this.f5873i = new ArrayList();
        this.f5874j = new C0342h1(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Object obj = this.f5868d.get(i);
        viewHolder2.f5877v = obj;
        viewHolder2.f5875t.onBindViewHolder(viewHolder2.f5876u, obj, list);
        onBind(viewHolder2);
        AdapterListener adapterListener = this.f5872h;
        if (adapterListener != null) {
            adapterListener.onBind(viewHolder2, list);
        }
    }
}
