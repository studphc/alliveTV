package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\bR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m5569d2 = {"Landroidx/savedstate/SavedStateRegistryController;", "", "", "performAttach", "()V", "Landroid/os/Bundle;", "savedState", "performRestore", "(Landroid/os/Bundle;)V", "outBundle", "performSave", "Landroidx/savedstate/SavedStateRegistry;", "b", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistry", "Companion", "savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class SavedStateRegistryController {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a */
    public final SavedStateRegistryOwner f7534a;

    /* renamed from: b, reason: from kotlin metadata */
    public final SavedStateRegistry savedStateRegistry = new SavedStateRegistry();

    /* renamed from: c */
    public boolean f7536c;

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/savedstate/SavedStateRegistryController$Companion;", "", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "Landroidx/savedstate/SavedStateRegistryController;", "create", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/savedstate/SavedStateRegistryController;", "savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @NotNull
        public final SavedStateRegistryController create(@NotNull SavedStateRegistryOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            return new SavedStateRegistryController(owner, null);
        }
    }

    public SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner, DefaultConstructorMarker defaultConstructorMarker) {
        this.f7534a = savedStateRegistryOwner;
    }

    @JvmStatic
    @NotNull
    public static final SavedStateRegistryController create(@NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
        return INSTANCE.create(savedStateRegistryOwner);
    }

    @NotNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @MainThread
    public final void performAttach() {
        SavedStateRegistryOwner savedStateRegistryOwner = this.f7534a;
        Lifecycle lifecycle = savedStateRegistryOwner.getLifecycle();
        if (lifecycle.getF6494d() == Lifecycle.State.INITIALIZED) {
            lifecycle.addObserver(new Recreator(savedStateRegistryOwner));
            this.savedStateRegistry.performAttach$savedstate_release(lifecycle);
            this.f7536c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    @MainThread
    public final void performRestore(@Nullable Bundle savedState) {
        if (!this.f7536c) {
            performAttach();
        }
        Lifecycle lifecycle = this.f7534a.getLifecycle();
        if (!lifecycle.getF6494d().isAtLeast(Lifecycle.State.STARTED)) {
            this.savedStateRegistry.performRestore$savedstate_release(savedState);
        } else {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.getF6494d()).toString());
        }
    }

    @MainThread
    public final void performSave(@NotNull Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        this.savedStateRegistry.performSave(outBundle);
    }
}
