package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1829tb;
import p000.t71;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m5569d2 = {"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistry", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "<init>", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/ViewModelStoreOwner;)V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "", "performRestore", "()V", "", "key", "consumeRestoredStateForKey", "(Ljava/lang/String;)Landroid/os/Bundle;", "lifecycle-viewmodel-savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSavedStateHandleSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n215#2,2:226\n1#3:228\n*S KotlinDebug\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n*L\n146#1:226,2\n*E\n"})
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a */
    public final SavedStateRegistry f6544a;

    /* renamed from: b */
    public boolean f6545b;

    /* renamed from: c */
    public Bundle f6546c;

    /* renamed from: d */
    public final Lazy f6547d;

    public SavedStateHandlesProvider(@NotNull SavedStateRegistry savedStateRegistry, @NotNull ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        this.f6544a = savedStateRegistry;
        this.f6547d = t71.lazy(new C1829tb(12, viewModelStoreOwner));
    }

    @Nullable
    public final Bundle consumeRestoredStateForKey(@NotNull String key) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(key, "key");
        performRestore();
        Bundle bundle2 = this.f6546c;
        if (bundle2 != null) {
            bundle = bundle2.getBundle(key);
        } else {
            bundle = null;
        }
        Bundle bundle3 = this.f6546c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f6546c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f6546c = null;
        }
        return bundle;
    }

    public final void performRestore() {
        if (!this.f6545b) {
            Bundle consumeRestoredStateForKey = this.f6544a.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f6546c;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            if (consumeRestoredStateForKey != null) {
                bundle.putAll(consumeRestoredStateForKey);
            }
            this.f6546c = bundle;
            this.f6545b = true;
        }
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    @NotNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f6546c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, SavedStateHandle> entry : ((SavedStateHandlesVM) this.f6547d.getValue()).getHandles().entrySet()) {
            String key = entry.getKey();
            Bundle saveState = entry.getValue().getF6537e().saveState();
            if (!Intrinsics.areEqual(saveState, Bundle.EMPTY)) {
                bundle.putBundle(key, saveState);
            }
        }
        this.f6545b = false;
        return bundle;
    }
}
