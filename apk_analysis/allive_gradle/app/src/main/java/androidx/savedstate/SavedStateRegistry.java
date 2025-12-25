package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0002-.B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0004\b!\u0010\u001eR$\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8G@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010,\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'\"\u0004\b*\u0010+¨\u0006/"}, m5569d2 = {"Landroidx/savedstate/SavedStateRegistry;", "", "<init>", "()V", "", "key", "Landroid/os/Bundle;", "consumeRestoredStateForKey", "(Ljava/lang/String;)Landroid/os/Bundle;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "provider", "", "registerSavedStateProvider", "(Ljava/lang/String;Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;)V", "getSavedStateProvider", "(Ljava/lang/String;)Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "unregisterSavedStateProvider", "(Ljava/lang/String;)V", "Ljava/lang/Class;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "clazz", "runOnNextRecreation", "(Ljava/lang/Class;)V", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "performAttach$savedstate_release", "(Landroidx/lifecycle/Lifecycle;)V", "performAttach", "savedState", "performRestore$savedstate_release", "(Landroid/os/Bundle;)V", "performRestore", "outBundle", "performSave", "", "<set-?>", "d", "Z", "isRestored", "()Z", "f", "isAllowingSavingState$savedstate_release", "setAllowingSavingState$savedstate_release", "(Z)V", "isAllowingSavingState", "AutoRecreated", "SavedStateProvider", "savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"RestrictedApi"})
@SourceDebugExtension({"SMAP\nSavedStateRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateRegistry.kt\nandroidx/savedstate/SavedStateRegistry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n1#2:273\n*E\n"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b */
    public boolean f7529b;

    /* renamed from: c */
    public Bundle f7530c;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean isRestored;

    /* renamed from: e */
    public Recreator.SavedStateProvider f7532e;

    /* renamed from: a */
    public final SafeIterableMap f7528a = new SafeIterableMap();

    /* renamed from: f, reason: from kotlin metadata */
    public boolean isAllowingSavingState = true;

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, m5569d2 = {"Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public interface AutoRecreated {
        void onRecreated(@NotNull SavedStateRegistryOwner owner);
    }

    @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, m5569d2 = {"Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "", "saveState", "Landroid/os/Bundle;", "savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public interface SavedStateProvider {
        @NotNull
        Bundle saveState();
    }

    @MainThread
    @Nullable
    public final Bundle consumeRestoredStateForKey(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.isRestored) {
            Bundle bundle = this.f7530c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(key);
            Bundle bundle3 = this.f7530c;
            if (bundle3 != null) {
                bundle3.remove(key);
            }
            Bundle bundle4 = this.f7530c;
            if (bundle4 == null || bundle4.isEmpty()) {
                this.f7530c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    @Nullable
    public final SavedStateProvider getSavedStateProvider(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator it = this.f7528a.iterator();
        while (it.hasNext()) {
            Map.Entry components = (Map.Entry) it.next();
            Intrinsics.checkNotNullExpressionValue(components, "components");
            String str = (String) components.getKey();
            SavedStateProvider savedStateProvider = (SavedStateProvider) components.getValue();
            if (Intrinsics.areEqual(str, key)) {
                return savedStateProvider;
            }
        }
        return null;
    }

    /* renamed from: isAllowingSavingState$savedstate_release, reason: from getter */
    public final boolean getIsAllowingSavingState() {
        return this.isAllowingSavingState;
    }

    @MainThread
    /* renamed from: isRestored, reason: from getter */
    public final boolean getIsRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach$savedstate_release(@NotNull Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (!this.f7529b) {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: ee2
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    SavedStateRegistry this$0 = SavedStateRegistry.this;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event == Lifecycle.Event.ON_START) {
                        this$0.isAllowingSavingState = true;
                    } else if (event == Lifecycle.Event.ON_STOP) {
                        this$0.isAllowingSavingState = false;
                    }
                }
            });
            this.f7529b = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.");
    }

    @MainThread
    public final void performRestore$savedstate_release(@Nullable Bundle savedState) {
        Bundle bundle;
        if (this.f7529b) {
            if (!this.isRestored) {
                if (savedState != null) {
                    bundle = savedState.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                } else {
                    bundle = null;
                }
                this.f7530c = bundle;
                this.isRestored = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
    }

    @MainThread
    public final void performSave(@NotNull Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f7530c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = this.f7528a.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(iteratorWithAdditions, "this.components.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry next = iteratorWithAdditions.next();
            bundle.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).saveState());
        }
        if (!bundle.isEmpty()) {
            outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
        }
    }

    @MainThread
    public final void registerSavedStateProvider(@NotNull String key, @NotNull SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (((SavedStateProvider) this.f7528a.putIfAbsent(key, provider)) == null) {
        } else {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @MainThread
    public final void runOnNextRecreation(@NotNull Class<? extends AutoRecreated> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this.isAllowingSavingState) {
            Recreator.SavedStateProvider savedStateProvider = this.f7532e;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.f7532e = savedStateProvider;
            try {
                clazz.getDeclaredConstructor(null);
                Recreator.SavedStateProvider savedStateProvider2 = this.f7532e;
                if (savedStateProvider2 != null) {
                    String name = clazz.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
                    savedStateProvider2.add(name);
                    return;
                }
                return;
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public final void setAllowingSavingState$savedstate_release(boolean z) {
        this.isAllowingSavingState = z;
    }

    @MainThread
    public final void unregisterSavedStateProvider(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f7528a.remove(key);
    }
}
