package androidx.leanback.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class SinglePresenterSelector extends PresenterSelector {

    /* renamed from: a */
    public final Presenter f6214a;

    public SinglePresenterSelector(@NonNull Presenter presenter) {
        this.f6214a = presenter;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    @Nullable
    public Presenter getPresenter(@Nullable Object obj) {
        return this.f6214a;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    @NonNull
    public Presenter[] getPresenters() {
        return new Presenter[]{this.f6214a};
    }
}
