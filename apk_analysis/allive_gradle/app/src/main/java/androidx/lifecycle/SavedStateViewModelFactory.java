package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\tB%\b\u0017\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0003\u0010\fJ/\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u000e*\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u000e*\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0013\u0010\u0017J'\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u000e*\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\rH\u0017¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m5569d2 = {"Landroidx/lifecycle/SavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;)V", "Landroid/os/Bundle;", "defaultArgs", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "Landroidx/lifecycle/ViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extras", "create", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "", "key", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "viewModel", "", "onRequery", "(Landroidx/lifecycle/ViewModel;)V", "lifecycle-viewmodel-savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    /* renamed from: a */
    public final Application f6549a;

    /* renamed from: b */
    public final ViewModelProvider.AndroidViewModelFactory f6550b;

    /* renamed from: c */
    public final Bundle f6551c;

    /* renamed from: d */
    public final Lifecycle f6552d;

    /* renamed from: e */
    public final SavedStateRegistry f6553e;

    public SavedStateViewModelFactory() {
        this.f6550b = new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass, @NotNull CreationExtras extras) {
        Constructor findMatchingConstructor;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        String str = (String) extras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (str != null) {
            if (extras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) != null && extras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) != null) {
                Application application = (Application) extras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
                boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
                if (isAssignableFrom && application != null) {
                    findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
                } else {
                    findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p());
                }
                if (findMatchingConstructor == null) {
                    return (T) this.f6550b.create(modelClass, extras);
                }
                return (!isAssignableFrom || application == null) ? (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, SavedStateHandleSupport.createSavedStateHandle(extras)) : (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, application, SavedStateHandleSupport.createSavedStateHandle(extras));
            }
            if (this.f6552d != null) {
                return (T) create(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(@NotNull ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Lifecycle lifecycle = this.f6552d;
        if (lifecycle != null) {
            SavedStateRegistry savedStateRegistry = this.f6553e;
            Intrinsics.checkNotNull(savedStateRegistry);
            Intrinsics.checkNotNull(lifecycle);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(@Nullable Application application, @NotNull SavedStateRegistryOwner owner) {
        this(application, owner, null);
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@Nullable Application application, @NotNull SavedStateRegistryOwner owner, @Nullable Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.f6553e = owner.getSavedStateRegistry();
        this.f6552d = owner.getLifecycle();
        this.f6551c = bundle;
        this.f6549a = application;
        if (application != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.INSTANCE.getInstance(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.f6550b = androidViewModelFactory;
    }

    @NotNull
    public final <T extends ViewModel> T create(@NotNull String key, @NotNull Class<T> modelClass) {
        Constructor findMatchingConstructor;
        T t;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Lifecycle lifecycle = this.f6552d;
        if (lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
            Application application = this.f6549a;
            if (isAssignableFrom && application != null) {
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
            } else {
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p());
            }
            if (findMatchingConstructor == null) {
                if (application != null) {
                    return (T) this.f6550b.create(modelClass);
                }
                return (T) ViewModelProvider.NewInstanceFactory.INSTANCE.getInstance().create(modelClass);
            }
            SavedStateRegistry savedStateRegistry = this.f6553e;
            Intrinsics.checkNotNull(savedStateRegistry);
            SavedStateHandleController create = LegacySavedStateHandleController.create(savedStateRegistry, lifecycle, key, this.f6551c);
            if (!isAssignableFrom || application == null) {
                t = (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, create.getHandle());
            } else {
                Intrinsics.checkNotNull(application);
                t = (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, application, create.getHandle());
            }
            t.m1538b(create);
            return t;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
