package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import p000.RunnableC1104d;
import p000.ht0;
import p000.t30;
import p000.u30;
import p000.v30;
import p000.w30;

/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;

    /* renamed from: e0 */
    public Handler f4401e0;

    /* renamed from: f0 */
    public final RunnableC1104d f4402f0;

    /* renamed from: g0 */
    public final t30 f4403g0;

    /* renamed from: h0 */
    public final u30 f4404h0;

    /* renamed from: i0 */
    public int f4405i0;

    /* renamed from: j0 */
    public int f4406j0;

    /* renamed from: k0 */
    public boolean f4407k0;

    /* renamed from: l0 */
    public boolean f4408l0;

    /* renamed from: m0 */
    public int f4409m0;

    /* renamed from: n0 */
    public boolean f4410n0;

    /* renamed from: o0 */
    public final v30 f4411o0;

    /* renamed from: p0 */
    public Dialog f4412p0;

    /* renamed from: q0 */
    public boolean f4413q0;

    /* renamed from: r0 */
    public boolean f4414r0;

    /* renamed from: s0 */
    public boolean f4415s0;

    /* renamed from: t0 */
    public boolean f4416t0;

    public DialogFragment() {
        this.f4402f0 = new RunnableC1104d(12, this);
        this.f4403g0 = new t30(0, this);
        this.f4404h0 = new u30(this);
        this.f4405i0 = 0;
        this.f4406j0 = 0;
        this.f4407k0 = true;
        this.f4408l0 = true;
        this.f4409m0 = -1;
        this.f4411o0 = new v30(this);
        this.f4416t0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: b */
    public final FragmentContainer mo1133b() {
        return new w30(this, new ht0(this));
    }

    public void dismiss() {
        m1135l(false, false, false);
    }

    public void dismissAllowingStateLoss() {
        m1135l(true, false, false);
    }

    @MainThread
    public void dismissNow() {
        m1135l(false, false, true);
    }

    @Nullable
    public Dialog getDialog() {
        return this.f4412p0;
    }

    public boolean getShowsDialog() {
        return this.f4408l0;
    }

    @StyleRes
    public int getTheme() {
        return this.f4406j0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: i */
    public final void mo1134i(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.mo1134i(layoutInflater, viewGroup, bundle);
        if (this.f4428K == null && this.f4412p0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f4412p0.onRestoreInstanceState(bundle2);
        }
    }

    public boolean isCancelable() {
        return this.f4407k0;
    }

    /* renamed from: l */
    public final void m1135l(boolean z, boolean z2, boolean z3) {
        if (this.f4414r0) {
            return;
        }
        this.f4414r0 = true;
        this.f4415s0 = false;
        Dialog dialog = this.f4412p0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f4412p0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.f4401e0.getLooper()) {
                    onDismiss(this.f4412p0);
                } else {
                    this.f4401e0.post(this.f4402f0);
                }
            }
        }
        this.f4413q0 = true;
        if (this.f4409m0 >= 0) {
            if (z3) {
                getParentFragmentManager().popBackStackImmediate(this.f4409m0, 1);
            } else {
                getParentFragmentManager().m1162M(this.f4409m0, 1, z);
            }
            this.f4409m0 = -1;
            return;
        }
        FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.remove(this);
        if (z3) {
            beginTransaction.commitNow();
        } else if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.f4411o0);
        if (!this.f4415s0) {
            this.f4414r0 = false;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.f4401e0 = new Handler();
        if (this.f4418A == 0) {
            z = true;
        } else {
            z = false;
        }
        this.f4408l0 = z;
        if (bundle != null) {
            this.f4405i0 = bundle.getInt("android:style", 0);
            this.f4406j0 = bundle.getInt("android:theme", 0);
            this.f4407k0 = bundle.getBoolean("android:cancelable", true);
            this.f4408l0 = bundle.getBoolean("android:showsDialog", this.f4408l0);
            this.f4409m0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @NonNull
    @MainThread
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "onCreateDialog called for DialogFragment " + this);
        }
        return new ComponentDialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f4412p0;
        if (dialog != null) {
            this.f4413q0 = true;
            dialog.setOnDismissListener(null);
            this.f4412p0.dismiss();
            if (!this.f4414r0) {
                onDismiss(this.f4412p0);
            }
            this.f4412p0 = null;
            this.f4416t0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDetach() {
        super.onDetach();
        if (!this.f4415s0 && !this.f4414r0) {
            this.f4414r0 = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.f4411o0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    @CallSuper
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        if (!this.f4413q0) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "onDismiss called for DialogFragment " + this);
            }
            m1135l(true, true, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        boolean z = this.f4408l0;
        if (z && !this.f4410n0) {
            if (z && !this.f4416t0) {
                try {
                    this.f4410n0 = true;
                    Dialog onCreateDialog = onCreateDialog(bundle);
                    this.f4412p0 = onCreateDialog;
                    if (this.f4408l0) {
                        setupDialog(onCreateDialog, this.f4405i0);
                        Context context = getContext();
                        if (context instanceof Activity) {
                            this.f4412p0.setOwnerActivity((Activity) context);
                        }
                        this.f4412p0.setCancelable(this.f4407k0);
                        this.f4412p0.setOnCancelListener(this.f4403g0);
                        this.f4412p0.setOnDismissListener(this.f4404h0);
                        this.f4416t0 = true;
                    } else {
                        this.f4412p0 = null;
                    }
                    this.f4410n0 = false;
                } catch (Throwable th) {
                    this.f4410n0 = false;
                    throw th;
                }
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.d(FragmentManager.TAG, "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f4412p0;
            if (dialog != null) {
                return onGetLayoutInflater.cloneInContext(dialog.getContext());
            }
            return onGetLayoutInflater;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.f4408l0) {
                Log.d(FragmentManager.TAG, "mShowsDialog = false: " + str);
            } else {
                Log.d(FragmentManager.TAG, "mCreatingDialog = true: " + str);
            }
        }
        return onGetLayoutInflater;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f4412p0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.f4405i0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.f4406j0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.f4407k0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.f4408l0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.f4409m0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f4412p0;
        if (dialog != null) {
            this.f4413q0 = false;
            dialog.show();
            View decorView = this.f4412p0.getWindow().getDecorView();
            ViewTreeLifecycleOwner.set(decorView, this);
            ViewTreeViewModelStoreOwner.set(decorView, this);
            ViewTreeSavedStateRegistryOwner.set(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f4412p0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onViewStateRestored(@Nullable Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f4412p0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f4412p0.onRestoreInstanceState(bundle2);
        }
    }

    @NonNull
    public final ComponentDialog requireComponentDialog() {
        Dialog requireDialog = requireDialog();
        if (requireDialog instanceof ComponentDialog) {
            return (ComponentDialog) requireDialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " did not return a ComponentDialog instance from requireDialog(). The actual Dialog is " + requireDialog);
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z) {
        this.f4407k0 = z;
        Dialog dialog = this.f4412p0;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.f4408l0 = z;
    }

    public void setStyle(int i, @StyleRes int i2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.d(FragmentManager.TAG, "Setting style and theme for DialogFragment " + this + " to " + i + ", " + i2);
        }
        this.f4405i0 = i;
        if (i == 2 || i == 3) {
            this.f4406j0 = R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.f4406j0 = i2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.f4414r0 = false;
        this.f4415s0 = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.add(this, str);
        beginTransaction.commit();
    }

    public void showNow(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.f4414r0 = false;
        this.f4415s0 = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.add(this, str);
        beginTransaction.commitNow();
    }

    public int show(@NonNull FragmentTransaction fragmentTransaction, @Nullable String str) {
        this.f4414r0 = false;
        this.f4415s0 = true;
        fragmentTransaction.add(this, str);
        this.f4413q0 = false;
        int commit = fragmentTransaction.commit();
        this.f4409m0 = commit;
        return commit;
    }

    public DialogFragment(@LayoutRes int i) {
        super(i);
        this.f4402f0 = new RunnableC1104d(12, this);
        this.f4403g0 = new t30(0, this);
        this.f4404h0 = new u30(this);
        this.f4405i0 = 0;
        this.f4406j0 = 0;
        this.f4407k0 = true;
        this.f4408l0 = true;
        this.f4409m0 = -1;
        this.f4411o0 = new v30(this);
        this.f4416t0 = false;
    }
}
