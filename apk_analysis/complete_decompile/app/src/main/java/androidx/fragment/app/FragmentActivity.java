package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000.C1597nt;
import p000.C1662ot;
import p000.mt0;
import p000.pu0;

/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {

    /* renamed from: B */
    public static final /* synthetic */ int f4475B = 0;

    /* renamed from: A */
    public boolean f4476A;

    /* renamed from: w */
    public final FragmentController f4477w;

    /* renamed from: x */
    public final LifecycleRegistry f4478x;

    /* renamed from: y */
    public boolean f4479y;

    /* renamed from: z */
    public boolean f4480z;

    public FragmentActivity() {
        this.f4477w = FragmentController.createController(new mt0(this));
        this.f4478x = new LifecycleRegistry(this);
        this.f4476A = true;
        m1146b();
    }

    /* renamed from: c */
    public static boolean m1145c(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z = false;
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= m1145c(fragment.getChildFragmentManager(), state);
                }
                pu0 pu0Var = fragment.f4439V;
                if (pu0Var != null) {
                    pu0Var.m6924b();
                    if (pu0Var.f25303e.getF6494d().isAtLeast(Lifecycle.State.STARTED)) {
                        fragment.f4439V.f25303e.setCurrentState(state);
                        z = true;
                    }
                }
                if (fragment.f4438U.getF6494d().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.f4438U.setCurrentState(state);
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public final void m1146b() {
        getSavedStateRegistry().registerSavedStateProvider("android:support:lifecycle", new C1597nt(1, this));
        final int i = 0;
        addOnConfigurationChangedListener(new Consumer(this) { // from class: lt0

            /* renamed from: b */
            public final /* synthetic */ FragmentActivity f22660b;

            {
                this.f22660b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.f22660b.f4477w.noteStateNotSaved();
                        return;
                    default:
                        this.f22660b.f4477w.noteStateNotSaved();
                        return;
                }
            }
        });
        final int i2 = 1;
        addOnNewIntentListener(new Consumer(this) { // from class: lt0

            /* renamed from: b */
            public final /* synthetic */ FragmentActivity f22660b;

            {
                this.f22660b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        this.f22660b.f4477w.noteStateNotSaved();
                        return;
                    default:
                        this.f22660b.f4477w.noteStateNotSaved();
                        return;
                }
            }
        });
        addOnContextAvailableListener(new C1662ot(this, i2));
    }

    @Override // android.app.Activity
    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (!shouldDumpInternalState(strArr)) {
            return;
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f4479y);
        printWriter.print(" mResumed=");
        printWriter.print(this.f4480z);
        printWriter.print(" mStopped=");
        printWriter.print(this.f4476A);
        if (getApplication() != null) {
            LoaderManager.getInstance(this).dump(str2, fileDescriptor, printWriter, strArr);
        }
        this.f4477w.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.f4477w.getSupportFragmentManager();
    }

    @NonNull
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        this.f4477w.noteStateNotSaved();
        super.onActivityResult(i, i2, intent);
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f4478x.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f4477w.dispatchCreate();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View onCreateView = this.f4477w.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f4477w.dispatchDestroy();
        this.f4478x.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.f4477w.dispatchContextItemSelected(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f4480z = false;
        this.f4477w.dispatchPause();
        this.f4478x.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.f4477w.noteStateNotSaved();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        FragmentController fragmentController = this.f4477w;
        fragmentController.noteStateNotSaved();
        super.onResume();
        this.f4480z = true;
        fragmentController.execPendingActions();
    }

    public void onResumeFragments() {
        this.f4478x.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.f4477w.dispatchResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        FragmentController fragmentController = this.f4477w;
        fragmentController.noteStateNotSaved();
        super.onStart();
        this.f4476A = false;
        if (!this.f4479y) {
            this.f4479y = true;
            fragmentController.dispatchActivityCreated();
        }
        fragmentController.execPendingActions();
        this.f4478x.handleLifecycleEvent(Lifecycle.Event.ON_START);
        fragmentController.dispatchStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f4477w.noteStateNotSaved();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f4476A = true;
        do {
        } while (m1145c(getSupportFragmentManager(), Lifecycle.State.CREATED));
        this.f4477w.dispatchStop();
        this.f4478x.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @NonNull Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(@NonNull Fragment fragment, @NonNull IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        if (i == -1) {
            ActivityCompat.startIntentSenderForResult(this, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @NonNull Intent intent, int i, @Nullable Bundle bundle) {
        if (i == -1) {
            ActivityCompat.startActivityForResult(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View onCreateView = this.f4477w.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }

    @ContentView
    public FragmentActivity(@LayoutRes int i) {
        super(i);
        this.f4477w = FragmentController.createController(new mt0(this));
        this.f4478x = new LifecycleRegistry(this);
        this.f4476A = true;
        m1146b();
    }
}
