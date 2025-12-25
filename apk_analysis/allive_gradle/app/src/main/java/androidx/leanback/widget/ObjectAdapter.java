package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.database.Observable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public abstract class ObjectAdapter {
    public static final int NO_ID = -1;

    /* renamed from: a */
    public final C0374p1 f5927a = new Observable();

    /* renamed from: b */
    public boolean f5928b;

    /* renamed from: c */
    public PresenterSelector f5929c;

    /* loaded from: classes.dex */
    public static abstract class DataObserver {
        public void onChanged() {
        }

        public void onItemMoved(int i, int i2) {
            onChanged();
        }

        public void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onChanged();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.leanback.widget.p1, android.database.Observable] */
    public ObjectAdapter(@NonNull PresenterSelector presenterSelector) {
        setPresenterSelector(presenterSelector);
    }

    @Nullable
    public abstract Object get(int i);

    public long getId(int i) {
        return -1L;
    }

    @Nullable
    public final Presenter getPresenter(@NonNull Object obj) {
        PresenterSelector presenterSelector = this.f5929c;
        if (presenterSelector != null) {
            return presenterSelector.getPresenter(obj);
        }
        throw new IllegalStateException("Presenter selector must not be null");
    }

    @NonNull
    public final PresenterSelector getPresenterSelector() {
        return this.f5929c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasObserver() {
        return this.f5927a.m1504a();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasStableIds() {
        return this.f5928b;
    }

    public boolean isImmediateNotifySupported() {
        return false;
    }

    public final void notifyChanged() {
        this.f5927a.m1505b();
    }

    public final void notifyItemMoved(int i, int i2) {
        this.f5927a.m1506c(i, i2);
    }

    public final void notifyItemRangeChanged(int i, int i2) {
        this.f5927a.m1507d(i, i2);
    }

    public final void notifyItemRangeInserted(int i, int i2) {
        this.f5927a.m1509f(i, i2);
    }

    public final void notifyItemRangeRemoved(int i, int i2) {
        this.f5927a.m1510g(i, i2);
    }

    public void onHasStableIdsChanged() {
    }

    public void onPresenterSelectorChanged() {
    }

    public final void registerObserver(@NonNull DataObserver dataObserver) {
        this.f5927a.registerObserver(dataObserver);
    }

    public final void setHasStableIds(boolean z) {
        boolean z2;
        if (this.f5928b != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f5928b = z;
        if (z2) {
            onHasStableIdsChanged();
        }
    }

    public final void setPresenterSelector(@NonNull PresenterSelector presenterSelector) {
        boolean z;
        if (presenterSelector != null) {
            PresenterSelector presenterSelector2 = this.f5929c;
            boolean z2 = false;
            if (presenterSelector2 != null) {
                z = true;
            } else {
                z = false;
            }
            if (z && presenterSelector2 != presenterSelector) {
                z2 = true;
            }
            this.f5929c = presenterSelector;
            if (z2) {
                onPresenterSelectorChanged();
            }
            if (z) {
                notifyChanged();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Presenter selector must not be null");
    }

    public abstract int size();

    public final void unregisterAllObservers() {
        this.f5927a.unregisterAll();
    }

    public final void unregisterObserver(@NonNull DataObserver dataObserver) {
        this.f5927a.unregisterObserver(dataObserver);
    }

    public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
        this.f5927a.m1508e(i, i2, obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.leanback.widget.p1, android.database.Observable] */
    public ObjectAdapter(@NonNull Presenter presenter) {
        setPresenterSelector(new SinglePresenterSelector(presenter));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.leanback.widget.p1, android.database.Observable] */
    public ObjectAdapter() {
    }
}
