package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public abstract class ActionProvider {

    /* renamed from: a */
    public final Context f3854a;

    /* renamed from: b */
    public SubUiVisibilityListener f3855b;

    /* renamed from: c */
    public VisibilityListener f3856c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z);
    }

    /* loaded from: classes.dex */
    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public ActionProvider(@NonNull Context context) {
        this.f3854a = context;
    }

    @NonNull
    public Context getContext() {
        return this.f3854a;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    @NonNull
    public abstract View onCreateActionView();

    @NonNull
    public View onCreateActionView(@NonNull MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(@NonNull SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.f3856c != null && overridesItemVisibility()) {
            this.f3856c.onActionProviderVisibilityChanged(isVisible());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void reset() {
        this.f3856c = null;
        this.f3855b = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSubUiVisibilityListener(@Nullable SubUiVisibilityListener subUiVisibilityListener) {
        this.f3855b = subUiVisibilityListener;
    }

    public void setVisibilityListener(@Nullable VisibilityListener visibilityListener) {
        if (this.f3856c != null && visibilityListener != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f3856c = visibilityListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void subUiVisibilityChanged(boolean z) {
        SubUiVisibilityListener subUiVisibilityListener = this.f3855b;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.onSubUiVisibilityChanged(z);
        }
    }
}
