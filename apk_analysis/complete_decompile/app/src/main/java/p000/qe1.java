package p000;

import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.RowHeaderPresenter;

/* loaded from: classes2.dex */
public final class qe1 extends PresenterSelector {
    @Override // androidx.leanback.widget.PresenterSelector
    public final Presenter getPresenter(Object obj) {
        return new RowHeaderPresenter();
    }
}
