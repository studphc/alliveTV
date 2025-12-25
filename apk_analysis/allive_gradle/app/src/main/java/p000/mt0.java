package p000;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.app.ActivityCompat;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public final class mt0 extends FragmentHostCallback implements OnConfigurationChangedProvider, OnTrimMemoryProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener, MenuHost {

    /* renamed from: f */
    public final /* synthetic */ FragmentActivity f23102f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mt0(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f23102f = fragmentActivity;
    }

    @Override // androidx.core.view.MenuHost
    public final void addMenuProvider(MenuProvider menuProvider) {
        this.f23102f.addMenuProvider(menuProvider);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(Consumer consumer) {
        this.f23102f.addOnConfigurationChangedListener(consumer);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(Consumer consumer) {
        this.f23102f.addOnMultiWindowModeChangedListener(consumer);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(Consumer consumer) {
        this.f23102f.addOnPictureInPictureModeChangedListener(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(Consumer consumer) {
        this.f23102f.addOnTrimMemoryListener(consumer);
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.f23102f.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f23102f.f4478x;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f23102f.getOnBackPressedDispatcher();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.f23102f.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.f23102f.getViewModelStore();
    }

    @Override // androidx.core.view.MenuHost
    public final void invalidateMenu() {
        this.f23102f.invalidateMenu();
    }

    @Override // androidx.fragment.app.FragmentOnAttachListener
    public final void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
        this.f23102f.onAttachFragment(fragment);
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public final void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f23102f.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
    public final View onFindViewById(int i) {
        return this.f23102f.findViewById(i);
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public final Object onGetHost() {
        return this.f23102f;
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public final LayoutInflater onGetLayoutInflater() {
        FragmentActivity fragmentActivity = this.f23102f;
        return fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    /* renamed from: onGetWindowAnimations */
    public final int getF4490d() {
        Window window = this.f23102f.getWindow();
        if (window == null) {
            return 0;
        }
        return window.getAttributes().windowAnimations;
    }

    @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
    public final boolean onHasView() {
        Window window = this.f23102f.getWindow();
        if (window != null && window.peekDecorView() != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public final boolean onHasWindowAnimations() {
        if (this.f23102f.getWindow() != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public final boolean onShouldSaveFragmentState(Fragment fragment) {
        return !this.f23102f.isFinishing();
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public final boolean onShouldShowRequestPermissionRationale(String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale(this.f23102f, str);
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public final void onSupportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    @Override // androidx.core.view.MenuHost
    public final void removeMenuProvider(MenuProvider menuProvider) {
        this.f23102f.removeMenuProvider(menuProvider);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(Consumer consumer) {
        this.f23102f.removeOnConfigurationChangedListener(consumer);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(Consumer consumer) {
        this.f23102f.removeOnMultiWindowModeChangedListener(consumer);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(Consumer consumer) {
        this.f23102f.removeOnPictureInPictureModeChangedListener(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(Consumer consumer) {
        this.f23102f.removeOnTrimMemoryListener(consumer);
    }

    @Override // androidx.core.view.MenuHost
    public final void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.f23102f.addMenuProvider(menuProvider, lifecycleOwner);
    }

    @Override // androidx.core.view.MenuHost
    public final void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.f23102f.addMenuProvider(menuProvider, lifecycleOwner, state);
    }
}
