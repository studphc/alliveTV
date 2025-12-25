package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.Presenter;

/* loaded from: classes.dex */
public class DividerPresenter extends Presenter {

    /* renamed from: b */
    public final int f5643b;

    public DividerPresenter() {
        this(androidx.leanback.R.layout.lb_divider);
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(@NonNull Presenter.ViewHolder viewHolder, @Nullable Object obj) {
    }

    @Override // androidx.leanback.widget.Presenter
    @NonNull
    public Presenter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        return new Presenter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.f5643b, viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(@NonNull Presenter.ViewHolder viewHolder) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DividerPresenter(int i) {
        this.f5643b = i;
    }
}
