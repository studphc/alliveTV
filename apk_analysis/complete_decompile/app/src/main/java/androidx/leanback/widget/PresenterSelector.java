package androidx.leanback.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class PresenterSelector {
    @Nullable
    public abstract Presenter getPresenter(@Nullable Object obj);

    @Nullable
    @SuppressLint({"NullableCollection"})
    public Presenter[] getPresenters() {
        return null;
    }
}
