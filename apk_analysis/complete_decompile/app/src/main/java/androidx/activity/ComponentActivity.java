package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import p000.AbstractC1810st;
import p000.C1597nt;
import p000.C1662ot;
import p000.C1773rt;
import p000.C1847tt;
import p000.ExecutorC1884ut;
import p000.RunnableC0006a5;
import p000.RunnableC1104d;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost, FullyDrawnReporterOwner {

    /* renamed from: v */
    public static final /* synthetic */ int f458v = 0;

    /* renamed from: c */
    public final ContextAwareHelper f459c;

    /* renamed from: d */
    public final MenuHostHelper f460d;

    /* renamed from: e */
    public final LifecycleRegistry f461e;

    /* renamed from: f */
    public final SavedStateRegistryController f462f;

    /* renamed from: g */
    public ViewModelStore f463g;

    /* renamed from: h */
    public SavedStateViewModelFactory f464h;

    /* renamed from: i */
    public OnBackPressedDispatcher f465i;

    /* renamed from: j */
    public final ExecutorC1884ut f466j;

    /* renamed from: k */
    public final FullyDrawnReporter f467k;

    /* renamed from: l */
    public final int f468l;

    /* renamed from: m */
    public final AtomicInteger f469m;

    /* renamed from: n */
    public final C1773rt f470n;

    /* renamed from: o */
    public final CopyOnWriteArrayList f471o;

    /* renamed from: p */
    public final CopyOnWriteArrayList f472p;

    /* renamed from: q */
    public final CopyOnWriteArrayList f473q;

    /* renamed from: r */
    public final CopyOnWriteArrayList f474r;

    /* renamed from: s */
    public final CopyOnWriteArrayList f475s;

    /* renamed from: t */
    public boolean f476t;

    /* renamed from: u */
    public boolean f477u;

    /* renamed from: androidx.activity.ComponentActivity$2 */
    /* loaded from: classes.dex */
    public class C00692 implements LifecycleEventObserver {
        public C00692() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            View view;
            if (event == Lifecycle.Event.ON_STOP) {
                Window window = ComponentActivity.this.getWindow();
                if (window != null) {
                    view = window.peekDecorView();
                } else {
                    view = null;
                }
                if (view != null) {
                    view.cancelPendingInputEvents();
                }
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$3 */
    /* loaded from: classes.dex */
    public class C00703 implements LifecycleEventObserver {
        public C00703() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                ComponentActivity componentActivity = ComponentActivity.this;
                componentActivity.f459c.clearAvailableContext();
                if (!componentActivity.isChangingConfigurations()) {
                    componentActivity.getViewModelStore().clear();
                }
                ExecutorC1884ut executorC1884ut = componentActivity.f466j;
                ComponentActivity componentActivity2 = executorC1884ut.f27434d;
                componentActivity2.getWindow().getDecorView().removeCallbacks(executorC1884ut);
                componentActivity2.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(executorC1884ut);
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$4 */
    /* loaded from: classes.dex */
    public class C00714 implements LifecycleEventObserver {
        public C00714() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            ComponentActivity componentActivity = ComponentActivity.this;
            if (componentActivity.f463g == null) {
                C1847tt c1847tt = (C1847tt) componentActivity.getLastNonConfigurationInstance();
                if (c1847tt != null) {
                    componentActivity.f463g = c1847tt.f26954b;
                }
                if (componentActivity.f463g == null) {
                    componentActivity.f463g = new ViewModelStore();
                }
            }
            componentActivity.getLifecycle().removeObserver(this);
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$6 */
    /* loaded from: classes.dex */
    public class C00726 implements LifecycleEventObserver {
        public C00726() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_CREATE && Build.VERSION.SDK_INT >= 33) {
                ComponentActivity.this.f465i.setOnBackInvokedDispatcher(AbstractC1810st.m7413a((ComponentActivity) lifecycleOwner));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [androidx.activity.ImmLeaksCleaner, androidx.lifecycle.LifecycleObserver, java.lang.Object] */
    public ComponentActivity() {
        this.f459c = new ContextAwareHelper();
        this.f460d = new MenuHostHelper(new RunnableC0006a5(4, this));
        this.f461e = new LifecycleRegistry(this);
        SavedStateRegistryController create = SavedStateRegistryController.create(this);
        this.f462f = create;
        this.f465i = null;
        ExecutorC1884ut executorC1884ut = new ExecutorC1884ut(this);
        this.f466j = executorC1884ut;
        this.f467k = new FullyDrawnReporter(executorC1884ut, new Function0() { // from class: mt
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i = ComponentActivity.f458v;
                ComponentActivity.this.reportFullyDrawn();
                return null;
            }
        });
        this.f469m = new AtomicInteger();
        this.f470n = new C1773rt(this);
        this.f471o = new CopyOnWriteArrayList();
        this.f472p = new CopyOnWriteArrayList();
        this.f473q = new CopyOnWriteArrayList();
        this.f474r = new CopyOnWriteArrayList();
        this.f475s = new CopyOnWriteArrayList();
        this.f476t = false;
        this.f477u = false;
        if (getLifecycle() != null) {
            int i = Build.VERSION.SDK_INT;
            getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.2
                public C00692() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    View view;
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        if (window != null) {
                            view = window.peekDecorView();
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            view.cancelPendingInputEvents();
                        }
                    }
                }
            });
            getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.3
                public C00703() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity componentActivity = ComponentActivity.this;
                        componentActivity.f459c.clearAvailableContext();
                        if (!componentActivity.isChangingConfigurations()) {
                            componentActivity.getViewModelStore().clear();
                        }
                        ExecutorC1884ut executorC1884ut2 = componentActivity.f466j;
                        ComponentActivity componentActivity2 = executorC1884ut2.f27434d;
                        componentActivity2.getWindow().getDecorView().removeCallbacks(executorC1884ut2);
                        componentActivity2.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(executorC1884ut2);
                    }
                }
            });
            getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.4
                public C00714() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    ComponentActivity componentActivity = ComponentActivity.this;
                    if (componentActivity.f463g == null) {
                        C1847tt c1847tt = (C1847tt) componentActivity.getLastNonConfigurationInstance();
                        if (c1847tt != null) {
                            componentActivity.f463g = c1847tt.f26954b;
                        }
                        if (componentActivity.f463g == null) {
                            componentActivity.f463g = new ViewModelStore();
                        }
                    }
                    componentActivity.getLifecycle().removeObserver(this);
                }
            });
            create.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles(this);
            if (i <= 23) {
                Lifecycle lifecycle = getLifecycle();
                ?? obj = new Object();
                obj.f499a = this;
                lifecycle.addObserver(obj);
            }
            getSavedStateRegistry().registerSavedStateProvider("android:support:activity-result", new C1597nt(0, this));
            addOnContextAvailableListener(new C1662ot(this, 0));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.f466j.m7767a(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.f460d.addMenuProvider(menuProvider);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer) {
        this.f471o.add(consumer);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.f459c.addOnContextAvailableListener(onContextAvailableListener);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
        this.f474r.add(consumer);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(@NonNull Consumer<Intent> consumer) {
        this.f473q.add(consumer);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.f475s.add(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(@NonNull Consumer<Integer> consumer) {
        this.f472p.add(consumer);
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    @NonNull
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.f470n;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (getApplication() != null) {
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Bundle bundle;
        if (this.f464h == null) {
            Application application = getApplication();
            if (getIntent() != null) {
                bundle = getIntent().getExtras();
            } else {
                bundle = null;
            }
            this.f464h = new SavedStateViewModelFactory(application, this, bundle);
        }
        return this.f464h;
    }

    @Override // androidx.activity.FullyDrawnReporterOwner
    @NonNull
    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.f467k;
    }

    @Nullable
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        C1847tt c1847tt = (C1847tt) getLastNonConfigurationInstance();
        if (c1847tt != null) {
            return c1847tt.f26953a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f461e;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.f465i == null) {
            this.f465i = new OnBackPressedDispatcher(new RunnableC1104d(10, this));
            getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.6
                public C00726() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_CREATE && Build.VERSION.SDK_INT >= 33) {
                        ComponentActivity.this.f465i.setOnBackInvokedDispatcher(AbstractC1810st.m7413a((ComponentActivity) lifecycleOwner));
                    }
                }
            });
        }
        return this.f465i;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.f462f.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            if (this.f463g == null) {
                C1847tt c1847tt = (C1847tt) getLastNonConfigurationInstance();
                if (c1847tt != null) {
                    this.f463g = c1847tt.f26954b;
                }
                if (this.f463g == null) {
                    this.f463g = new ViewModelStore();
                }
            }
            return this.f463g;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(getWindow().getDecorView(), this);
        ViewTreeFullyDrawnReporterOwner.set(getWindow().getDecorView(), this);
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (!this.f470n.dispatchResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    @CallSuper
    @MainThread
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.f471o.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        this.f462f.performRestore(bundle);
        this.f459c.dispatchOnContextAvailable(this);
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
        int i = this.f468l;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, @NonNull Menu menu) {
        if (i == 0) {
            super.onCreatePanelMenu(i, menu);
            this.f460d.onCreateMenu(menu, getMenuInflater());
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.f460d.onMenuItemSelected(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean z) {
        if (this.f476t) {
            return;
        }
        Iterator it = this.f474r.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(new MultiWindowModeChangedInfo(z));
        }
    }

    @Override // android.app.Activity
    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.f473q.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, @NonNull Menu menu) {
        this.f460d.onMenuClosed(menu);
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.f477u) {
            return;
        }
        Iterator it = this.f475s.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(new PictureInPictureModeChangedInfo(z));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, @Nullable View view, @NonNull Menu menu) {
        if (i == 0) {
            super.onPreparePanel(i, view, menu);
            this.f460d.onPrepareMenu(menu);
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.f470n.dispatchResult(i, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, iArr))) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Nullable
    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [tt, java.lang.Object] */
    @Override // android.app.Activity
    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        C1847tt c1847tt;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.f463g;
        if (viewModelStore == null && (c1847tt = (C1847tt) getLastNonConfigurationInstance()) != null) {
            viewModelStore = c1847tt.f26954b;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        ?? obj = new Object();
        obj.f26953a = onRetainCustomNonConfigurationInstance;
        obj.f26954b = viewModelStore;
        return obj;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f462f.performSave(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    @CallSuper
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.f472p.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(Integer.valueOf(i));
        }
    }

    @Override // androidx.activity.contextaware.ContextAware
    @Nullable
    public Context peekAvailableContext() {
        return this.f459c.getF528b();
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.register("activity_rq#" + this.f469m.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.f460d.removeMenuProvider(menuProvider);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer) {
        this.f471o.remove(consumer);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.f459c.removeOnContextAvailableListener(onContextAvailableListener);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
        this.f474r.remove(consumer);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(@NonNull Consumer<Intent> consumer) {
        this.f473q.remove(consumer);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.f475s.remove(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(@NonNull Consumer<Integer> consumer) {
        this.f472p.remove(consumer);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.f467k.fullyDrawnReported();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(@LayoutRes int i) {
        initializeViewTreeOwners();
        this.f466j.m7767a(getWindow().getDecorView());
        super.setContentView(i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        this.f460d.addMenuProvider(menuProvider, lifecycleOwner);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        this.f460d.addMenuProvider(menuProvider, lifecycleOwner, state);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean z, @NonNull Configuration configuration) {
        this.f476t = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.f476t = false;
            Iterator it = this.f474r.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).accept(new MultiWindowModeChangedInfo(z, configuration));
            }
        } catch (Throwable th) {
            this.f476t = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z, @NonNull Configuration configuration) {
        this.f477u = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.f477u = false;
            Iterator it = this.f475s.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).accept(new PictureInPictureModeChangedInfo(z, configuration));
            }
        } catch (Throwable th) {
            this.f477u = false;
            throw th;
        }
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.f470n, activityResultCallback);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.f466j.m7767a(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.f466j.m7767a(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @ContentView
    public ComponentActivity(@LayoutRes int i) {
        this();
        this.f468l = i;
    }
}
