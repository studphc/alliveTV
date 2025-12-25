package androidx.savedstate;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1726qj;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m5569d2 = {"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "Landroidx/lifecycle/LifecycleOwner;", FirebaseAnalytics.Param.SOURCE, "Landroidx/lifecycle/Lifecycle$Event;", NotificationCompat.CATEGORY_EVENT, "", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Companion", "SavedStateProvider", "savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class Recreator implements LifecycleEventObserver {

    @NotNull
    public static final String CLASSES_KEY = "classes_to_restore";

    @NotNull
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";

    /* renamed from: a */
    public final SavedStateRegistryOwner f7526a;

    @Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m5569d2 = {"Landroidx/savedstate/Recreator$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry;", "registry", "<init>", "(Landroidx/savedstate/SavedStateRegistry;)V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "", "className", "", "add", "(Ljava/lang/String;)V", "savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {

        /* renamed from: a */
        public final LinkedHashSet f7527a;

        public SavedStateProvider(@NotNull SavedStateRegistry registry) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            this.f7527a = new LinkedHashSet();
            registry.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public final void add(@NotNull String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            this.f7527a.add(className);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @NotNull
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(Recreator.CLASSES_KEY, new ArrayList<>(this.f7527a));
            return bundle;
        }
    }

    public Recreator(@NotNull SavedStateRegistryOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.f7526a = owner;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            source.getLifecycle().removeObserver(this);
            SavedStateRegistryOwner savedStateRegistryOwner = this.f7526a;
            Bundle consumeRestoredStateForKey = savedStateRegistryOwner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
            if (consumeRestoredStateForKey == null) {
                return;
            }
            ArrayList<String> stringArrayList = consumeRestoredStateForKey.getStringArrayList(CLASSES_KEY);
            if (stringArrayList != null) {
                for (String str : stringArrayList) {
                    try {
                        Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
                        Intrinsics.checkNotNullExpressionValue(asSubclass, "{\n                Class.…class.java)\n            }");
                        try {
                            Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                Object newInstance = declaredConstructor.newInstance(null);
                                Intrinsics.checkNotNullExpressionValue(newInstance, "{\n                constr…wInstance()\n            }");
                                ((SavedStateRegistry.AutoRecreated) newInstance).onRecreated(savedStateRegistryOwner);
                            } catch (Exception e) {
                                throw new RuntimeException(AbstractC1726qj.m7038C("Failed to instantiate ", str), e);
                            }
                        } catch (NoSuchMethodException e2) {
                            throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                        }
                    } catch (ClassNotFoundException e3) {
                        throw new RuntimeException(ye0.m8296p("Class ", str, " wasn't found"), e3);
                    }
                }
                return;
            }
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
