package androidx.leanback.widget;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ControlButtonPresenterSelector extends PresenterSelector {

    /* renamed from: a */
    public final C0387t f5606a;

    /* renamed from: b */
    public final C0387t f5607b;

    /* renamed from: c */
    public final Presenter[] f5608c;

    public ControlButtonPresenterSelector() {
        C0387t c0387t = new C0387t(androidx.leanback.R.layout.lb_control_button_primary);
        this.f5606a = c0387t;
        this.f5607b = new C0387t(androidx.leanback.R.layout.lb_control_button_secondary);
        this.f5608c = new Presenter[]{c0387t};
    }

    @Override // androidx.leanback.widget.PresenterSelector
    @Nullable
    public Presenter getPresenter(@Nullable Object obj) {
        return this.f5606a;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter[] getPresenters() {
        return this.f5608c;
    }

    public Presenter getPrimaryPresenter() {
        return this.f5606a;
    }

    public Presenter getSecondaryPresenter() {
        return this.f5607b;
    }
}
