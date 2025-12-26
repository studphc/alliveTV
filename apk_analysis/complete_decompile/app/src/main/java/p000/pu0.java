package p000;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* loaded from: classes.dex */
public final class pu0 implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {

    /* renamed from: a */
    public final Fragment f25299a;

    /* renamed from: b */
    public final ViewModelStore f25300b;

    /* renamed from: c */
    public final RunnableC0006a5 f25301c;

    /* renamed from: d */
    public ViewModelProvider.Factory f25302d;

    /* renamed from: e */
    public LifecycleRegistry f25303e = null;

    /* renamed from: f */
    public SavedStateRegistryController f25304f = null;

    public pu0(Fragment fragment, ViewModelStore viewModelStore, RunnableC0006a5 runnableC0006a5) {
        this.f25299a = fragment;
        this.f25300b = viewModelStore;
        this.f25301c = runnableC0006a5;
    }

    /* renamed from: a */
    public final void m6923a(Lifecycle.Event event) {
        this.f25303e.handleLifecycleEvent(event);
    }

    /* renamed from: b */
    public final void m6924b() {
        if (this.f25303e == null) {
            this.f25303e = new LifecycleRegistry(this);
            SavedStateRegistryController create = SavedStateRegistryController.create(this);
            this.f25304f = create;
            create.performAttach();
            this.f25301c.run();
        }
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Fragment fragment = this.f25299a;
        Context applicationContext = fragment.requireContext().getApplicationContext();
        while (true) {
            if (applicationContext instanceof ContextWrapper) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            } else {
                application = null;
                break;
            }
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, fragment);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (fragment.getArguments() != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, fragment.getArguments());
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        Fragment fragment = this.f25299a;
        ViewModelProvider.Factory defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment.f4441X)) {
            this.f25302d = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f25302d == null) {
            Context applicationContext = fragment.requireContext().getApplicationContext();
            while (true) {
                if (applicationContext instanceof ContextWrapper) {
                    if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    }
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                } else {
                    application = null;
                    break;
                }
            }
            this.f25302d = new SavedStateViewModelFactory(application, fragment, fragment.getArguments());
        }
        return this.f25302d;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        m6924b();
        return this.f25303e;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        m6924b();
        return this.f25304f.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        m6924b();
        return this.f25300b;
    }
}
