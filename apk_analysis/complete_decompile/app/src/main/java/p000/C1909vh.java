package p000;

import android.text.TextUtils;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.C0344i;
import androidx.leanback.widget.C0348j;
import androidx.leanback.widget.InvisibleRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;

/* renamed from: vh */
/* loaded from: classes.dex */
public final class C1909vh extends PresenterSelector {

    /* renamed from: a */
    public final /* synthetic */ int f27780a;

    /* renamed from: b */
    public final Object f27781b;

    /* renamed from: c */
    public final Presenter f27782c;

    /* renamed from: d */
    public final Presenter[] f27783d;

    public /* synthetic */ C1909vh(PresenterSelector presenterSelector, InvisibleRowPresenter invisibleRowPresenter, Presenter[] presenterArr, int i) {
        this.f27780a = i;
        this.f27781b = presenterSelector;
        this.f27782c = invisibleRowPresenter;
        this.f27783d = presenterArr;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public final Presenter getPresenter(Object obj) {
        switch (this.f27780a) {
            case 0:
                if (((Row) obj).isRenderedAsRowView()) {
                    return ((PresenterSelector) this.f27781b).getPresenter(obj);
                }
                return (InvisibleRowPresenter) this.f27782c;
            case 1:
                if (((Row) obj).isRenderedAsRowView()) {
                    return ((PresenterSelector) this.f27781b).getPresenter(obj);
                }
                return (InvisibleRowPresenter) this.f27782c;
            default:
                if (TextUtils.isEmpty(((Action) obj).getLabel2())) {
                    return (C0344i) this.f27781b;
                }
                return (C0348j) this.f27782c;
        }
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public final Presenter[] getPresenters() {
        switch (this.f27780a) {
            case 0:
                return this.f27783d;
            case 1:
                return this.f27783d;
            default:
                return this.f27783d;
        }
    }

    public C1909vh() {
        this.f27780a = 2;
        Presenter presenter = new Presenter();
        this.f27781b = presenter;
        Presenter presenter2 = new Presenter();
        this.f27782c = presenter2;
        this.f27783d = new Presenter[]{presenter, presenter2};
    }
}
