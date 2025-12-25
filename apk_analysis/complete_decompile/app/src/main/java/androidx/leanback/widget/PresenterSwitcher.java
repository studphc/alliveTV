package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;

/* loaded from: classes.dex */
public abstract class PresenterSwitcher {

    /* renamed from: a */
    public ViewGroup f6071a;

    /* renamed from: b */
    public PresenterSelector f6072b;

    /* renamed from: c */
    public Presenter f6073c;

    /* renamed from: d */
    public Presenter.ViewHolder f6074d;

    public void clear() {
        Presenter presenter = this.f6073c;
        if (presenter != null) {
            presenter.onUnbindViewHolder(this.f6074d);
            this.f6071a.removeView(this.f6074d.view);
            this.f6074d = null;
            this.f6073c = null;
        }
    }

    public final ViewGroup getParentViewGroup() {
        return this.f6071a;
    }

    public void init(ViewGroup viewGroup, PresenterSelector presenterSelector) {
        clear();
        this.f6071a = viewGroup;
        this.f6072b = presenterSelector;
    }

    public abstract void insertView(View view);

    public void onViewSelected(View view) {
    }

    public void select(Object obj) {
        Presenter presenter = this.f6072b.getPresenter(obj);
        Presenter presenter2 = this.f6073c;
        if (presenter != presenter2) {
            Presenter.ViewHolder viewHolder = this.f6074d;
            if (viewHolder != null) {
                showView(viewHolder.view, false);
            }
            clear();
            this.f6073c = presenter;
            if (presenter != null) {
                Presenter.ViewHolder onCreateViewHolder = presenter.onCreateViewHolder(this.f6071a);
                this.f6074d = onCreateViewHolder;
                insertView(onCreateViewHolder.view);
                this.f6073c.onBindViewHolder(this.f6074d, obj);
                onViewSelected(this.f6074d.view);
            }
        } else if (presenter2 != null) {
            presenter2.onUnbindViewHolder(this.f6074d);
            this.f6073c.onBindViewHolder(this.f6074d, obj);
            onViewSelected(this.f6074d.view);
        }
        Presenter.ViewHolder viewHolder2 = this.f6074d;
        if (viewHolder2 != null) {
            showView(viewHolder2.view, true);
        }
    }

    public void showView(View view, boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void unselect() {
        Presenter.ViewHolder viewHolder = this.f6074d;
        if (viewHolder != null) {
            showView(viewHolder.view, false);
        }
    }
}
