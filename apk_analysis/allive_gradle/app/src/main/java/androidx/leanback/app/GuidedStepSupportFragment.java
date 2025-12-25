package androidx.leanback.app;

import android.R;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.DiffCallback;
import androidx.leanback.widget.GuidanceStylist;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;
import androidx.leanback.widget.GuidedActionAdapterGroup;
import androidx.leanback.widget.GuidedActionsStylist;
import androidx.leanback.widget.NonOverlappingLinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import p000.my0;
import p000.ny0;
import p000.oy0;
import p000.py0;

/* loaded from: classes.dex */
public class GuidedStepSupportFragment extends Fragment implements GuidedActionAdapter.FocusListener {
    public static final String EXTRA_UI_STYLE = "uiStyle";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int SLIDE_FROM_BOTTOM = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int SLIDE_FROM_SIDE = 0;
    public static final int UI_STYLE_ACTIVITY_ROOT = 2;

    @Deprecated
    public static final int UI_STYLE_DEFAULT = 0;
    public static final int UI_STYLE_ENTRANCE = 1;
    public static final int UI_STYLE_REPLACE = 0;

    /* renamed from: e0 */
    public ContextThemeWrapper f5008e0;

    /* renamed from: f0 */
    public GuidanceStylist f5009f0;

    /* renamed from: g0 */
    public GuidedActionsStylist f5010g0;

    /* renamed from: h0 */
    public GuidedActionsStylist f5011h0;

    /* renamed from: i0 */
    public GuidedActionAdapter f5012i0;

    /* renamed from: j0 */
    public GuidedActionAdapter f5013j0;

    /* renamed from: k0 */
    public GuidedActionAdapter f5014k0;

    /* renamed from: l0 */
    public GuidedActionAdapterGroup f5015l0;

    /* renamed from: m0 */
    public List f5016m0 = new ArrayList();

    /* renamed from: n0 */
    public List f5017n0 = new ArrayList();

    /* renamed from: o0 */
    public int f5018o0 = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class DummyFragment extends Fragment {
        @Override // androidx.fragment.app.Fragment
        @NonNull
        public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
            View view = new View(layoutInflater.getContext());
            view.setVisibility(8);
            return view;
        }
    }

    public GuidedStepSupportFragment() {
        onProvideFragmentTransitions();
    }

    public static int add(@NonNull FragmentManager fragmentManager, @NonNull GuidedStepSupportFragment guidedStepSupportFragment) {
        return add(fragmentManager, guidedStepSupportFragment, R.id.content);
    }

    public static int addAsRoot(@NonNull FragmentActivity fragmentActivity, @NonNull GuidedStepSupportFragment guidedStepSupportFragment, int i) {
        fragmentActivity.getWindow().getDecorView();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag("leanBackGuidedStepSupportFragment") != null) {
            Log.w("GuidedStepF", "Fragment is already exists, likely calling addAsRoot() when savedInstanceState is not null in Activity.onCreate().");
            return -1;
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        guidedStepSupportFragment.setUiStyle(2);
        return beginTransaction.replace(i, guidedStepSupportFragment, "leanBackGuidedStepSupportFragment").commit();
    }

    @Nullable
    public static GuidedStepSupportFragment getCurrentGuidedStepSupportFragment(@NonNull FragmentManager fragmentManager) {
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("leanBackGuidedStepSupportFragment");
        if (findFragmentByTag instanceof GuidedStepSupportFragment) {
            return (GuidedStepSupportFragment) findFragmentByTag;
        }
        return null;
    }

    /* renamed from: l */
    public static void m1298l(FragmentTransaction fragmentTransaction, View view, String str) {
        if (view != null) {
            fragmentTransaction.addSharedElement(view, str);
        }
    }

    /* renamed from: m */
    public static boolean m1299m(Context context) {
        int i = androidx.leanback.R.attr.guidedStepThemeFlag;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true) && typedValue.type == 18 && typedValue.data != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: n */
    public static boolean m1300n(GuidedAction guidedAction) {
        if (guidedAction.isAutoSaveRestoreEnabled() && guidedAction.getId() != -1) {
            return true;
        }
        return false;
    }

    public void collapseAction(boolean z) {
        GuidedActionsStylist guidedActionsStylist = this.f5010g0;
        if (guidedActionsStylist != null && guidedActionsStylist.getActionsGridView() != null) {
            this.f5010g0.collapseAction(z);
        }
    }

    public void collapseSubActions() {
        collapseAction(true);
    }

    public void expandAction(@NonNull GuidedAction guidedAction, boolean z) {
        this.f5010g0.expandAction(guidedAction, z);
    }

    public void expandSubActions(@NonNull GuidedAction guidedAction) {
        if (!guidedAction.hasSubActions()) {
            return;
        }
        expandAction(guidedAction, true);
    }

    @Nullable
    public GuidedAction findActionById(long j) {
        int findActionPositionById = findActionPositionById(j);
        if (findActionPositionById >= 0) {
            return (GuidedAction) this.f5016m0.get(findActionPositionById);
        }
        return null;
    }

    public int findActionPositionById(long j) {
        if (this.f5016m0 != null) {
            for (int i = 0; i < this.f5016m0.size(); i++) {
                if (((GuidedAction) this.f5016m0.get(i)).getId() == j) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    @Nullable
    public GuidedAction findButtonActionById(long j) {
        int findButtonActionPositionById = findButtonActionPositionById(j);
        if (findButtonActionPositionById >= 0) {
            return (GuidedAction) this.f5017n0.get(findButtonActionPositionById);
        }
        return null;
    }

    public int findButtonActionPositionById(long j) {
        if (this.f5017n0 != null) {
            for (int i = 0; i < this.f5017n0.size(); i++) {
                if (((GuidedAction) this.f5017n0.get(i)).getId() == j) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    public void finishGuidedStepSupportFragments() {
        FragmentManager fragmentManager = getFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            for (int i = backStackEntryCount - 1; i >= 0; i--) {
                FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i);
                String name = backStackEntryAt.getName();
                if (name != null && name.startsWith("GuidedStepEntrance")) {
                    GuidedStepSupportFragment currentGuidedStepSupportFragment = getCurrentGuidedStepSupportFragment(fragmentManager);
                    if (currentGuidedStepSupportFragment != null) {
                        currentGuidedStepSupportFragment.setUiStyle(1);
                    }
                    fragmentManager.popBackStackImmediate(backStackEntryAt.getId(), 1);
                    return;
                }
            }
        }
        ActivityCompat.finishAfterTransition(getActivity());
    }

    @Nullable
    public View getActionItemView(int i) {
        RecyclerView.ViewHolder findViewHolderForPosition = this.f5010g0.getActionsGridView().findViewHolderForPosition(i);
        if (findViewHolderForPosition == null) {
            return null;
        }
        return findViewHolderForPosition.itemView;
    }

    @NonNull
    public List<GuidedAction> getActions() {
        return this.f5016m0;
    }

    @Nullable
    public View getButtonActionItemView(int i) {
        RecyclerView.ViewHolder findViewHolderForPosition = this.f5011h0.getActionsGridView().findViewHolderForPosition(i);
        if (findViewHolderForPosition == null) {
            return null;
        }
        return findViewHolderForPosition.itemView;
    }

    @NonNull
    public List<GuidedAction> getButtonActions() {
        return this.f5017n0;
    }

    @NonNull
    public GuidanceStylist getGuidanceStylist() {
        return this.f5009f0;
    }

    @NonNull
    public GuidedActionsStylist getGuidedActionsStylist() {
        return this.f5010g0;
    }

    @NonNull
    public GuidedActionsStylist getGuidedButtonActionsStylist() {
        return this.f5011h0;
    }

    public int getSelectedActionPosition() {
        return this.f5010g0.getActionsGridView().getSelectedPosition();
    }

    public int getSelectedButtonActionPosition() {
        return this.f5011h0.getActionsGridView().getSelectedPosition();
    }

    public int getUiStyle() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return 1;
        }
        return arguments.getInt("uiStyle", 1);
    }

    public boolean isExpanded() {
        return this.f5010g0.isExpanded();
    }

    public boolean isFocusOutEndAllowed() {
        return false;
    }

    public boolean isFocusOutStartAllowed() {
        return false;
    }

    public boolean isSubActionsExpanded() {
        return this.f5010g0.isSubActionsExpanded();
    }

    public void notifyActionChanged(int i) {
        GuidedActionAdapter guidedActionAdapter = this.f5012i0;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.notifyItemChanged(i);
        }
    }

    public void notifyButtonActionChanged(int i) {
        GuidedActionAdapter guidedActionAdapter = this.f5014k0;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.notifyItemChanged(i);
        }
    }

    /* renamed from: o */
    public final void m1301o(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            this.f5009f0.onImeAppearing(arrayList);
            this.f5010g0.onImeAppearing(arrayList);
            this.f5011h0.onImeAppearing(arrayList);
        } else {
            this.f5009f0.onImeDisappearing(arrayList);
            this.f5010g0.onImeDisappearing(arrayList);
            this.f5011h0.onImeDisappearing(arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void onAddSharedElementTransition(@NonNull FragmentTransaction fragmentTransaction, @NonNull GuidedStepSupportFragment guidedStepSupportFragment) {
        View view = guidedStepSupportFragment.getView();
        m1298l(fragmentTransaction, view.findViewById(androidx.leanback.R.id.action_fragment_root), "action_fragment_root");
        m1298l(fragmentTransaction, view.findViewById(androidx.leanback.R.id.action_fragment_background), "action_fragment_background");
        m1298l(fragmentTransaction, view.findViewById(androidx.leanback.R.id.action_fragment), "action_fragment");
        m1298l(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_root), "guidedactions_root");
        m1298l(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_content), "guidedactions_content");
        m1298l(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_list_background), "guidedactions_list_background");
        m1298l(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_root2), "guidedactions_root2");
        m1298l(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_content2), "guidedactions_content2");
        m1298l(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_list_background2), "guidedactions_list_background2");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f5009f0 = onCreateGuidanceStylist();
        this.f5010g0 = onCreateActionsStylist();
        this.f5011h0 = onCreateButtonActionsStylist();
        onProvideFragmentTransitions();
        ArrayList arrayList = new ArrayList();
        onCreateActions(arrayList, bundle);
        if (bundle != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                GuidedAction guidedAction = (GuidedAction) arrayList.get(i);
                if (m1300n(guidedAction)) {
                    guidedAction.onRestoreInstanceState(bundle, "action_" + guidedAction.getId());
                }
            }
        }
        setActions(arrayList);
        ArrayList arrayList2 = new ArrayList();
        onCreateButtonActions(arrayList2, bundle);
        if (bundle != null) {
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                GuidedAction guidedAction2 = (GuidedAction) arrayList2.get(i2);
                if (m1300n(guidedAction2)) {
                    guidedAction2.onRestoreInstanceState(bundle, "buttonaction_" + guidedAction2.getId());
                }
            }
        }
        setButtonActions(arrayList2);
    }

    public void onCreateActions(@NonNull List<GuidedAction> list, @Nullable Bundle bundle) {
    }

    @NonNull
    public GuidedActionsStylist onCreateActionsStylist() {
        return new GuidedActionsStylist();
    }

    @Nullable
    public View onCreateBackgroundView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(androidx.leanback.R.layout.lb_guidedstep_background, viewGroup, false);
    }

    public void onCreateButtonActions(@NonNull List<GuidedAction> list, @Nullable Bundle bundle) {
    }

    @NonNull
    public GuidedActionsStylist onCreateButtonActionsStylist() {
        GuidedActionsStylist guidedActionsStylist = new GuidedActionsStylist();
        guidedActionsStylist.setAsButtonActions();
        return guidedActionsStylist;
    }

    @NonNull
    public GuidanceStylist.Guidance onCreateGuidance(@Nullable Bundle bundle) {
        return new GuidanceStylist.Guidance("", "", "", null);
    }

    @NonNull
    public GuidanceStylist onCreateGuidanceStylist() {
        return new GuidanceStylist();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LayoutInflater cloneInContext;
        Context context = getContext();
        int onProvideTheme = onProvideTheme();
        if (onProvideTheme == -1 && !m1299m(context)) {
            int i = androidx.leanback.R.attr.guidedStepTheme;
            TypedValue typedValue = new TypedValue();
            boolean resolveAttribute = context.getTheme().resolveAttribute(i, typedValue, true);
            if (resolveAttribute) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, typedValue.resourceId);
                if (m1299m(contextThemeWrapper)) {
                    this.f5008e0 = contextThemeWrapper;
                } else {
                    this.f5008e0 = null;
                    resolveAttribute = false;
                }
            }
            if (!resolveAttribute) {
                Log.e("GuidedStepF", "GuidedStepSupportFragment does not have an appropriate theme set.");
            }
        } else if (onProvideTheme != -1) {
            this.f5008e0 = new ContextThemeWrapper(context, onProvideTheme);
        }
        Context context2 = this.f5008e0;
        if (context2 == null) {
            cloneInContext = layoutInflater;
        } else {
            cloneInContext = layoutInflater.cloneInContext(context2);
        }
        GuidedStepRootLayout guidedStepRootLayout = (GuidedStepRootLayout) cloneInContext.inflate(androidx.leanback.R.layout.lb_guidedstep_fragment, viewGroup, false);
        guidedStepRootLayout.f5006a = isFocusOutStartAllowed();
        guidedStepRootLayout.f5007b = isFocusOutEndAllowed();
        ViewGroup viewGroup2 = (ViewGroup) guidedStepRootLayout.findViewById(androidx.leanback.R.id.content_fragment);
        ViewGroup viewGroup3 = (ViewGroup) guidedStepRootLayout.findViewById(androidx.leanback.R.id.action_fragment);
        ((NonOverlappingLinearLayout) viewGroup3).setFocusableViewAvailableFixEnabled(true);
        viewGroup2.addView(this.f5009f0.onCreateView(cloneInContext, viewGroup2, onCreateGuidance(bundle)));
        viewGroup3.addView(this.f5010g0.onCreateView(cloneInContext, viewGroup3));
        View onCreateView = this.f5011h0.onCreateView(cloneInContext, viewGroup3);
        viewGroup3.addView(onCreateView);
        my0 my0Var = new my0(this);
        this.f5012i0 = new GuidedActionAdapter(this.f5016m0, new ny0(this), this, this.f5010g0, false);
        this.f5014k0 = new GuidedActionAdapter(this.f5017n0, new oy0(this), this, this.f5011h0, false);
        this.f5013j0 = new GuidedActionAdapter(null, new py0(this), this, this.f5010g0, true);
        GuidedActionAdapterGroup guidedActionAdapterGroup = new GuidedActionAdapterGroup();
        this.f5015l0 = guidedActionAdapterGroup;
        guidedActionAdapterGroup.addAdpter(this.f5012i0, this.f5014k0);
        this.f5015l0.addAdpter(this.f5013j0, null);
        this.f5015l0.setEditListener(my0Var);
        this.f5010g0.setEditListener(my0Var);
        this.f5010g0.getActionsGridView().setAdapter(this.f5012i0);
        if (this.f5010g0.getSubActionsGridView() != null) {
            this.f5010g0.getSubActionsGridView().setAdapter(this.f5013j0);
        }
        this.f5011h0.getActionsGridView().setAdapter(this.f5014k0);
        if (this.f5017n0.size() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) onCreateView.getLayoutParams();
            layoutParams.weight = RecyclerView.f7068F0;
            onCreateView.setLayoutParams(layoutParams);
        } else {
            Context context3 = this.f5008e0;
            if (context3 == null) {
                context3 = getContext();
            }
            TypedValue typedValue2 = new TypedValue();
            if (context3.getTheme().resolveAttribute(androidx.leanback.R.attr.guidedActionContentWidthWeightTwoPanels, typedValue2, true)) {
                View findViewById = guidedStepRootLayout.findViewById(androidx.leanback.R.id.action_fragment_root);
                float f = typedValue2.getFloat();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams2.weight = f;
                findViewById.setLayoutParams(layoutParams2);
            }
        }
        View onCreateBackgroundView = onCreateBackgroundView(cloneInContext, guidedStepRootLayout, bundle);
        if (onCreateBackgroundView != null) {
            ((FrameLayout) guidedStepRootLayout.findViewById(androidx.leanback.R.id.guidedstep_background_view_root)).addView(onCreateBackgroundView, 0);
        }
        return guidedStepRootLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f5009f0.onDestroyView();
        this.f5010g0.onDestroyView();
        this.f5011h0.onDestroyView();
        this.f5012i0 = null;
        this.f5013j0 = null;
        this.f5014k0 = null;
        this.f5015l0 = null;
        super.onDestroyView();
    }

    public void onGuidedActionClicked(@NonNull GuidedAction guidedAction) {
    }

    public void onGuidedActionEditCanceled(@NonNull GuidedAction guidedAction) {
        onGuidedActionEdited(guidedAction);
    }

    @Deprecated
    public void onGuidedActionEdited(GuidedAction guidedAction) {
    }

    public long onGuidedActionEditedAndProceed(@NonNull GuidedAction guidedAction) {
        onGuidedActionEdited(guidedAction);
        return -2L;
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.FocusListener
    public void onGuidedActionFocused(@NonNull GuidedAction guidedAction) {
    }

    public void onProvideFragmentTransitions() {
        int uiStyle = getUiStyle();
        if (uiStyle == 0) {
            Object createFadeAndShortSlide = TransitionHelper.createFadeAndShortSlide(GravityCompat.END);
            TransitionHelper.exclude(createFadeAndShortSlide, androidx.leanback.R.id.guidedstep_background, true);
            int i = androidx.leanback.R.id.guidedactions_sub_list_background;
            TransitionHelper.exclude(createFadeAndShortSlide, i, true);
            setEnterTransition(createFadeAndShortSlide);
            Object createFadeTransition = TransitionHelper.createFadeTransition(3);
            TransitionHelper.include(createFadeTransition, i);
            Object createChangeBounds = TransitionHelper.createChangeBounds(false);
            Object createTransitionSet = TransitionHelper.createTransitionSet(false);
            TransitionHelper.addTransition(createTransitionSet, createFadeTransition);
            TransitionHelper.addTransition(createTransitionSet, createChangeBounds);
            setSharedElementEnterTransition(createTransitionSet);
        } else if (uiStyle == 1) {
            if (this.f5018o0 == 0) {
                Object createFadeTransition2 = TransitionHelper.createFadeTransition(3);
                TransitionHelper.include(createFadeTransition2, androidx.leanback.R.id.guidedstep_background);
                Object createFadeAndShortSlide2 = TransitionHelper.createFadeAndShortSlide(GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK);
                TransitionHelper.include(createFadeAndShortSlide2, androidx.leanback.R.id.content_fragment);
                TransitionHelper.include(createFadeAndShortSlide2, androidx.leanback.R.id.action_fragment_root);
                Object createTransitionSet2 = TransitionHelper.createTransitionSet(false);
                TransitionHelper.addTransition(createTransitionSet2, createFadeTransition2);
                TransitionHelper.addTransition(createTransitionSet2, createFadeAndShortSlide2);
                setEnterTransition(createTransitionSet2);
            } else {
                Object createFadeAndShortSlide3 = TransitionHelper.createFadeAndShortSlide(80);
                TransitionHelper.include(createFadeAndShortSlide3, androidx.leanback.R.id.guidedstep_background_view_root);
                Object createTransitionSet3 = TransitionHelper.createTransitionSet(false);
                TransitionHelper.addTransition(createTransitionSet3, createFadeAndShortSlide3);
                setEnterTransition(createTransitionSet3);
            }
            setSharedElementEnterTransition(null);
        } else if (uiStyle == 2) {
            setEnterTransition(null);
            setSharedElementEnterTransition(null);
        }
        Object createFadeAndShortSlide4 = TransitionHelper.createFadeAndShortSlide(GravityCompat.START);
        TransitionHelper.exclude(createFadeAndShortSlide4, androidx.leanback.R.id.guidedstep_background, true);
        TransitionHelper.exclude(createFadeAndShortSlide4, androidx.leanback.R.id.guidedactions_sub_list_background, true);
        setExitTransition(createFadeAndShortSlide4);
    }

    public int onProvideTheme() {
        return -1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getView().findViewById(androidx.leanback.R.id.action_fragment).requestFocus();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        List list = this.f5016m0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            GuidedAction guidedAction = (GuidedAction) list.get(i);
            if (m1300n(guidedAction)) {
                guidedAction.onSaveInstanceState(bundle, "action_" + guidedAction.getId());
            }
        }
        List list2 = this.f5017n0;
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            GuidedAction guidedAction2 = (GuidedAction) list2.get(i2);
            if (m1300n(guidedAction2)) {
                guidedAction2.onSaveInstanceState(bundle, "buttonaction_" + guidedAction2.getId());
            }
        }
    }

    public boolean onSubGuidedActionClicked(@NonNull GuidedAction guidedAction) {
        return true;
    }

    public void openInEditMode(@Nullable GuidedAction guidedAction) {
        this.f5010g0.openInEditMode(guidedAction);
    }

    public void popBackStackToGuidedStepSupportFragment(@NonNull Class<?> cls, int i) {
        String str;
        if (!GuidedStepSupportFragment.class.isAssignableFrom(cls)) {
            return;
        }
        FragmentManager fragmentManager = getFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        String name = cls.getName();
        if (backStackEntryCount > 0) {
            for (int i2 = backStackEntryCount - 1; i2 >= 0; i2--) {
                FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i2);
                String name2 = backStackEntryAt.getName();
                if (name2.startsWith("GuidedStepDefault")) {
                    str = name2.substring(17);
                } else if (name2.startsWith("GuidedStepEntrance")) {
                    str = name2.substring(18);
                } else {
                    str = "";
                }
                if (name.equals(str)) {
                    fragmentManager.popBackStackImmediate(backStackEntryAt.getId(), i);
                    return;
                }
            }
        }
    }

    public void setActions(@NonNull List<GuidedAction> list) {
        this.f5016m0 = list;
        GuidedActionAdapter guidedActionAdapter = this.f5012i0;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.setActions(list);
        }
    }

    public void setActionsDiffCallback(@Nullable DiffCallback<GuidedAction> diffCallback) {
        this.f5012i0.setDiffCallback(diffCallback);
    }

    public void setButtonActions(@NonNull List<GuidedAction> list) {
        this.f5017n0 = list;
        GuidedActionAdapter guidedActionAdapter = this.f5014k0;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.setActions(list);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setEntranceTransitionType(int i) {
        this.f5018o0 = i;
    }

    public void setSelectedActionPosition(int i) {
        this.f5010g0.getActionsGridView().setSelectedPosition(i);
    }

    public void setSelectedButtonActionPosition(int i) {
        this.f5011h0.getActionsGridView().setSelectedPosition(i);
    }

    public void setUiStyle(int i) {
        boolean z;
        int uiStyle = getUiStyle();
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            z = true;
        } else {
            z = false;
        }
        arguments.putInt("uiStyle", i);
        if (z) {
            setArguments(arguments);
        }
        if (i != uiStyle) {
            onProvideFragmentTransitions();
        }
    }

    public static int add(@NonNull FragmentManager fragmentManager, @NonNull GuidedStepSupportFragment guidedStepSupportFragment, int i) {
        String concat;
        GuidedStepSupportFragment currentGuidedStepSupportFragment = getCurrentGuidedStepSupportFragment(fragmentManager);
        int i2 = currentGuidedStepSupportFragment != null ? 1 : 0;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        guidedStepSupportFragment.setUiStyle(i2 ^ 1);
        int uiStyle = guidedStepSupportFragment.getUiStyle();
        Class<?> cls = guidedStepSupportFragment.getClass();
        if (uiStyle == 0) {
            concat = "GuidedStepDefault".concat(cls.getName());
        } else if (uiStyle != 1) {
            concat = "";
        } else {
            concat = "GuidedStepEntrance".concat(cls.getName());
        }
        beginTransaction.addToBackStack(concat);
        if (currentGuidedStepSupportFragment != null) {
            guidedStepSupportFragment.onAddSharedElementTransition(beginTransaction, currentGuidedStepSupportFragment);
        }
        return beginTransaction.replace(i, guidedStepSupportFragment, "leanBackGuidedStepSupportFragment").commit();
    }
}
