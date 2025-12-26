package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentController {

    /* renamed from: a */
    public final FragmentHostCallback f4485a;

    public FragmentController(FragmentHostCallback fragmentHostCallback) {
        this.f4485a = fragmentHostCallback;
    }

    @NonNull
    public static FragmentController createController(@NonNull FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    public void attachHost(@Nullable Fragment fragment) {
        FragmentHostCallback fragmentHostCallback = this.f4485a;
        fragmentHostCallback.getFragmentManager().m1177b(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        fragmentManager.f4505J = false;
        fragmentManager.f4506K = false;
        fragmentManager.f4512Q.f16548j = false;
        fragmentManager.m1197u(4);
    }

    @Deprecated
    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        this.f4485a.getFragmentManager().m1185i(true, configuration);
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        return this.f4485a.getFragmentManager().m1186j(menuItem);
    }

    public void dispatchCreate() {
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        fragmentManager.f4505J = false;
        fragmentManager.f4506K = false;
        fragmentManager.f4512Q.f16548j = false;
        fragmentManager.m1197u(1);
    }

    @Deprecated
    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        return this.f4485a.getFragmentManager().m1187k(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.f4485a.getFragmentManager().m1188l();
    }

    public void dispatchDestroyView() {
        this.f4485a.getFragmentManager().m1197u(1);
    }

    @Deprecated
    public void dispatchLowMemory() {
        this.f4485a.getFragmentManager().m1189m(true);
    }

    @Deprecated
    public void dispatchMultiWindowModeChanged(boolean z) {
        this.f4485a.getFragmentManager().m1190n(z, true);
    }

    @Deprecated
    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        return this.f4485a.getFragmentManager().m1192p(menuItem);
    }

    @Deprecated
    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        this.f4485a.getFragmentManager().m1193q(menu);
    }

    public void dispatchPause() {
        this.f4485a.getFragmentManager().m1197u(5);
    }

    @Deprecated
    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.f4485a.getFragmentManager().m1195s(z, true);
    }

    @Deprecated
    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        return this.f4485a.getFragmentManager().m1196t(menu);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        fragmentManager.f4505J = false;
        fragmentManager.f4506K = false;
        fragmentManager.f4512Q.f16548j = false;
        fragmentManager.m1197u(7);
    }

    public void dispatchStart() {
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        fragmentManager.f4505J = false;
        fragmentManager.f4506K = false;
        fragmentManager.f4512Q.f16548j = false;
        fragmentManager.m1197u(5);
    }

    public void dispatchStop() {
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        fragmentManager.f4506K = true;
        fragmentManager.f4512Q.f16548j = true;
        fragmentManager.m1197u(4);
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    @Deprecated
    public void dumpLoaders(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.f4485a.getFragmentManager().m1201y(true);
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String str) {
        return this.f4485a.getFragmentManager().f4517c.m6251c(str);
    }

    @NonNull
    public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> list) {
        return this.f4485a.getFragmentManager().f4517c.m6253e();
    }

    public int getActiveFragmentsCount() {
        return ((HashMap) this.f4485a.getFragmentManager().f4517c.f23108c).size();
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.f4485a.getFragmentManager();
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.f4485a.getFragmentManager().m1161L();
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.f4485a.getFragmentManager().f4520f.onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable List<Fragment> list) {
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        FragmentManagerNonConfig fragmentManagerNonConfig = new FragmentManagerNonConfig(list, null, null);
        if (!(fragmentManager.f4538x instanceof ViewModelStoreOwner)) {
            fragmentManager.f4512Q.m4619i(fragmentManagerNonConfig);
            fragmentManager.m1168S(parcelable);
        } else {
            fragmentManager.m1176a0(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
            throw null;
        }
    }

    @Deprecated
    public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    @Deprecated
    public void restoreSaveState(@Nullable Parcelable parcelable) {
        FragmentHostCallback fragmentHostCallback = this.f4485a;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            FragmentManager fragmentManager = fragmentHostCallback.getFragmentManager();
            if (!(fragmentManager.f4538x instanceof SavedStateRegistryOwner)) {
                fragmentManager.m1168S(parcelable);
                return;
            } else {
                fragmentManager.m1176a0(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
                throw null;
            }
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Nullable
    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        if (!(fragmentManager.f4538x instanceof ViewModelStoreOwner)) {
            return fragmentManager.f4512Q.m4617g();
        }
        fragmentManager.m1176a0(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        throw null;
    }

    @Nullable
    @Deprecated
    public List<Fragment> retainNonConfig() {
        List list;
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        if (!(fragmentManager.f4538x instanceof ViewModelStoreOwner)) {
            FragmentManagerNonConfig m4617g = fragmentManager.f4512Q.m4617g();
            if (m4617g == null || (list = m4617g.f4547a) == null) {
                return null;
            }
            return new ArrayList(list);
        }
        fragmentManager.m1176a0(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        throw null;
    }

    @Nullable
    @Deprecated
    public Parcelable saveAllState() {
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        if (!(fragmentManager.f4538x instanceof SavedStateRegistryOwner)) {
            Bundle m1169T = fragmentManager.m1169T();
            if (m1169T.isEmpty()) {
                return null;
            }
            return m1169T;
        }
        fragmentManager.m1176a0(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        throw null;
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        FragmentManager fragmentManager = this.f4485a.getFragmentManager();
        if (!(fragmentManager.f4538x instanceof ViewModelStoreOwner)) {
            fragmentManager.f4512Q.m4619i(fragmentManagerNonConfig);
            fragmentManager.m1168S(parcelable);
        } else {
            fragmentManager.m1176a0(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
            throw null;
        }
    }
}
