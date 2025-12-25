package androidx.leanback.app;

import android.R;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.transition.Transition;
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
import p000.iy0;
import p000.jy0;
import p000.ky0;
import p000.ly0;
import p000.ou0;

@Deprecated
/* loaded from: classes.dex */
public class GuidedStepFragment extends Fragment implements GuidedActionAdapter.FocusListener {
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

    /* renamed from: a */
    public ContextThemeWrapper f4995a;

    /* renamed from: b */
    public GuidanceStylist f4996b;

    /* renamed from: c */
    public GuidedActionsStylist f4997c;

    /* renamed from: d */
    public GuidedActionsStylist f4998d;

    /* renamed from: e */
    public GuidedActionAdapter f4999e;

    /* renamed from: f */
    public GuidedActionAdapter f5000f;

    /* renamed from: g */
    public GuidedActionAdapter f5001g;

    /* renamed from: h */
    public GuidedActionAdapterGroup f5002h;

    /* renamed from: i */
    public List f5003i = new ArrayList();

    /* renamed from: j */
    public List f5004j = new ArrayList();

    /* renamed from: k */
    public int f5005k = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class DummyFragment extends Fragment {
        @Override // android.app.Fragment
        @NonNull
        public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
            View view = new View(layoutInflater.getContext());
            view.setVisibility(8);
            return view;
        }
    }

    public GuidedStepFragment() {
        onProvideFragmentTransitions();
    }

    /* renamed from: a */
    public static void m1294a(FragmentTransaction fragmentTransaction, View view, String str) {
        if (view != null) {
            fragmentTransaction.addSharedElement(view, str);
        }
    }

    public static int add(@NonNull FragmentManager fragmentManager, @NonNull GuidedStepFragment guidedStepFragment) {
        return add(fragmentManager, guidedStepFragment, R.id.content);
    }

    public static int addAsRoot(@NonNull Activity activity, @NonNull GuidedStepFragment guidedStepFragment, int i) {
        activity.getWindow().getDecorView();
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("leanBackGuidedStepFragment") != null) {
            Log.w("GuidedStepF", "Fragment is already exists, likely calling addAsRoot() when savedInstanceState is not null in Activity.onCreate().");
            return -1;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        guidedStepFragment.setUiStyle(2);
        return beginTransaction.replace(i, guidedStepFragment, "leanBackGuidedStepFragment").commit();
    }

    /* renamed from: b */
    public static boolean m1295b(Context context) {
        int i = androidx.leanback.R.attr.guidedStepThemeFlag;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true) && typedValue.type == 18 && typedValue.data != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m1296c(GuidedAction guidedAction) {
        if (guidedAction.isAutoSaveRestoreEnabled() && guidedAction.getId() != -1) {
            return true;
        }
        return false;
    }

    @Nullable
    public static GuidedStepFragment getCurrentGuidedStepFragment(@NonNull FragmentManager fragmentManager) {
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("leanBackGuidedStepFragment");
        if (findFragmentByTag instanceof GuidedStepFragment) {
            return (GuidedStepFragment) findFragmentByTag;
        }
        return null;
    }

    public void collapseAction(boolean z) {
        GuidedActionsStylist guidedActionsStylist = this.f4997c;
        if (guidedActionsStylist != null && guidedActionsStylist.getActionsGridView() != null) {
            this.f4997c.collapseAction(z);
        }
    }

    public void collapseSubActions() {
        collapseAction(true);
    }

    /* renamed from: d */
    public final void m1297d(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            this.f4996b.onImeAppearing(arrayList);
            this.f4997c.onImeAppearing(arrayList);
            this.f4998d.onImeAppearing(arrayList);
        } else {
            this.f4996b.onImeDisappearing(arrayList);
            this.f4997c.onImeDisappearing(arrayList);
            this.f4998d.onImeDisappearing(arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void expandAction(@NonNull GuidedAction guidedAction, boolean z) {
        this.f4997c.expandAction(guidedAction, z);
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
            return (GuidedAction) this.f5003i.get(findActionPositionById);
        }
        return null;
    }

    public int findActionPositionById(long j) {
        if (this.f5003i != null) {
            for (int i = 0; i < this.f5003i.size(); i++) {
                if (((GuidedAction) this.f5003i.get(i)).getId() == j) {
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
            return (GuidedAction) this.f5004j.get(findButtonActionPositionById);
        }
        return null;
    }

    public int findButtonActionPositionById(long j) {
        if (this.f5004j != null) {
            for (int i = 0; i < this.f5004j.size(); i++) {
                if (((GuidedAction) this.f5004j.get(i)).getId() == j) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    public void finishGuidedStepFragments() {
        FragmentManager fragmentManager = getFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            for (int i = backStackEntryCount - 1; i >= 0; i--) {
                FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i);
                String name = backStackEntryAt.getName();
                if (name != null && name.startsWith("GuidedStepEntrance")) {
                    GuidedStepFragment currentGuidedStepFragment = getCurrentGuidedStepFragment(fragmentManager);
                    if (currentGuidedStepFragment != null) {
                        currentGuidedStepFragment.setUiStyle(1);
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
        RecyclerView.ViewHolder findViewHolderForPosition = this.f4997c.getActionsGridView().findViewHolderForPosition(i);
        if (findViewHolderForPosition == null) {
            return null;
        }
        return findViewHolderForPosition.itemView;
    }

    @NonNull
    public List<GuidedAction> getActions() {
        return this.f5003i;
    }

    @Nullable
    public View getButtonActionItemView(int i) {
        RecyclerView.ViewHolder findViewHolderForPosition = this.f4998d.getActionsGridView().findViewHolderForPosition(i);
        if (findViewHolderForPosition == null) {
            return null;
        }
        return findViewHolderForPosition.itemView;
    }

    @NonNull
    public List<GuidedAction> getButtonActions() {
        return this.f5004j;
    }

    @NonNull
    public GuidanceStylist getGuidanceStylist() {
        return this.f4996b;
    }

    @NonNull
    public GuidedActionsStylist getGuidedActionsStylist() {
        return this.f4997c;
    }

    @NonNull
    public GuidedActionsStylist getGuidedButtonActionsStylist() {
        return this.f4998d;
    }

    public int getSelectedActionPosition() {
        return this.f4997c.getActionsGridView().getSelectedPosition();
    }

    public int getSelectedButtonActionPosition() {
        return this.f4998d.getActionsGridView().getSelectedPosition();
    }

    public int getUiStyle() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return 1;
        }
        return arguments.getInt("uiStyle", 1);
    }

    public boolean isExpanded() {
        return this.f4997c.isExpanded();
    }

    public boolean isFocusOutEndAllowed() {
        return false;
    }

    public boolean isFocusOutStartAllowed() {
        return false;
    }

    public boolean isSubActionsExpanded() {
        return this.f4997c.isSubActionsExpanded();
    }

    public void notifyActionChanged(int i) {
        GuidedActionAdapter guidedActionAdapter = this.f4999e;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.notifyItemChanged(i);
        }
    }

    public void notifyButtonActionChanged(int i) {
        GuidedActionAdapter guidedActionAdapter = this.f5001g;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.notifyItemChanged(i);
        }
    }

    public void onAddSharedElementTransition(@NonNull FragmentTransaction fragmentTransaction, @NonNull GuidedStepFragment guidedStepFragment) {
        View view = guidedStepFragment.getView();
        m1294a(fragmentTransaction, view.findViewById(androidx.leanback.R.id.action_fragment_root), "action_fragment_root");
        m1294a(fragmentTransaction, view.findViewById(androidx.leanback.R.id.action_fragment_background), "action_fragment_background");
        m1294a(fragmentTransaction, view.findViewById(androidx.leanback.R.id.action_fragment), "action_fragment");
        m1294a(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_root), "guidedactions_root");
        m1294a(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_content), "guidedactions_content");
        m1294a(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_list_background), "guidedactions_list_background");
        m1294a(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_root2), "guidedactions_root2");
        m1294a(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_content2), "guidedactions_content2");
        m1294a(fragmentTransaction, view.findViewById(androidx.leanback.R.id.guidedactions_list_background2), "guidedactions_list_background2");
    }

    @Override // android.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f4996b = onCreateGuidanceStylist();
        this.f4997c = onCreateActionsStylist();
        this.f4998d = onCreateButtonActionsStylist();
        onProvideFragmentTransitions();
        ArrayList arrayList = new ArrayList();
        onCreateActions(arrayList, bundle);
        if (bundle != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                GuidedAction guidedAction = (GuidedAction) arrayList.get(i);
                if (m1296c(guidedAction)) {
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
                if (m1296c(guidedAction2)) {
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

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater cloneInContext;
        Context m6729a = ou0.m6729a(this);
        int onProvideTheme = onProvideTheme();
        if (onProvideTheme == -1 && !m1295b(m6729a)) {
            int i = androidx.leanback.R.attr.guidedStepTheme;
            TypedValue typedValue = new TypedValue();
            boolean resolveAttribute = m6729a.getTheme().resolveAttribute(i, typedValue, true);
            if (resolveAttribute) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(m6729a, typedValue.resourceId);
                if (m1295b(contextThemeWrapper)) {
                    this.f4995a = contextThemeWrapper;
                } else {
                    this.f4995a = null;
                    resolveAttribute = false;
                }
            }
            if (!resolveAttribute) {
                Log.e("GuidedStepF", "GuidedStepFragment does not have an appropriate theme set.");
            }
        } else if (onProvideTheme != -1) {
            this.f4995a = new ContextThemeWrapper(m6729a, onProvideTheme);
        }
        Context context = this.f4995a;
        if (context == null) {
            cloneInContext = layoutInflater;
        } else {
            cloneInContext = layoutInflater.cloneInContext(context);
        }
        GuidedStepRootLayout guidedStepRootLayout = (GuidedStepRootLayout) cloneInContext.inflate(androidx.leanback.R.layout.lb_guidedstep_fragment, viewGroup, false);
        guidedStepRootLayout.f5006a = isFocusOutStartAllowed();
        guidedStepRootLayout.f5007b = isFocusOutEndAllowed();
        ViewGroup viewGroup2 = (ViewGroup) guidedStepRootLayout.findViewById(androidx.leanback.R.id.content_fragment);
        ViewGroup viewGroup3 = (ViewGroup) guidedStepRootLayout.findViewById(androidx.leanback.R.id.action_fragment);
        ((NonOverlappingLinearLayout) viewGroup3).setFocusableViewAvailableFixEnabled(true);
        viewGroup2.addView(this.f4996b.onCreateView(cloneInContext, viewGroup2, onCreateGuidance(bundle)));
        viewGroup3.addView(this.f4997c.onCreateView(cloneInContext, viewGroup3));
        View onCreateView = this.f4998d.onCreateView(cloneInContext, viewGroup3);
        viewGroup3.addView(onCreateView);
        iy0 iy0Var = new iy0(this);
        this.f4999e = new GuidedActionAdapter(this.f5003i, new jy0(this), this, this.f4997c, false);
        this.f5001g = new GuidedActionAdapter(this.f5004j, new ky0(this), this, this.f4998d, false);
        this.f5000f = new GuidedActionAdapter(null, new ly0(this), this, this.f4997c, true);
        GuidedActionAdapterGroup guidedActionAdapterGroup = new GuidedActionAdapterGroup();
        this.f5002h = guidedActionAdapterGroup;
        guidedActionAdapterGroup.addAdpter(this.f4999e, this.f5001g);
        this.f5002h.addAdpter(this.f5000f, null);
        this.f5002h.setEditListener(iy0Var);
        this.f4997c.setEditListener(iy0Var);
        this.f4997c.getActionsGridView().setAdapter(this.f4999e);
        if (this.f4997c.getSubActionsGridView() != null) {
            this.f4997c.getSubActionsGridView().setAdapter(this.f5000f);
        }
        this.f4998d.getActionsGridView().setAdapter(this.f5001g);
        if (this.f5004j.size() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) onCreateView.getLayoutParams();
            layoutParams.weight = RecyclerView.f7068F0;
            onCreateView.setLayoutParams(layoutParams);
        } else {
            Context context2 = this.f4995a;
            if (context2 == null) {
                context2 = ou0.m6729a(this);
            }
            TypedValue typedValue2 = new TypedValue();
            if (context2.getTheme().resolveAttribute(androidx.leanback.R.attr.guidedActionContentWidthWeightTwoPanels, typedValue2, true)) {
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

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f4996b.onDestroyView();
        this.f4997c.onDestroyView();
        this.f4998d.onDestroyView();
        this.f4999e = null;
        this.f5000f = null;
        this.f5001g = null;
        this.f5002h = null;
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
            setEnterTransition((Transition) createFadeAndShortSlide);
            Object createFadeTransition = TransitionHelper.createFadeTransition(3);
            TransitionHelper.include(createFadeTransition, i);
            Object createChangeBounds = TransitionHelper.createChangeBounds(false);
            Object createTransitionSet = TransitionHelper.createTransitionSet(false);
            TransitionHelper.addTransition(createTransitionSet, createFadeTransition);
            TransitionHelper.addTransition(createTransitionSet, createChangeBounds);
            setSharedElementEnterTransition((Transition) createTransitionSet);
        } else if (uiStyle == 1) {
            if (this.f5005k == 0) {
                Object createFadeTransition2 = TransitionHelper.createFadeTransition(3);
                TransitionHelper.include(createFadeTransition2, androidx.leanback.R.id.guidedstep_background);
                Object createFadeAndShortSlide2 = TransitionHelper.createFadeAndShortSlide(GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK);
                TransitionHelper.include(createFadeAndShortSlide2, androidx.leanback.R.id.content_fragment);
                TransitionHelper.include(createFadeAndShortSlide2, androidx.leanback.R.id.action_fragment_root);
                Object createTransitionSet2 = TransitionHelper.createTransitionSet(false);
                TransitionHelper.addTransition(createTransitionSet2, createFadeTransition2);
                TransitionHelper.addTransition(createTransitionSet2, createFadeAndShortSlide2);
                setEnterTransition((Transition) createTransitionSet2);
            } else {
                Object createFadeAndShortSlide3 = TransitionHelper.createFadeAndShortSlide(80);
                TransitionHelper.include(createFadeAndShortSlide3, androidx.leanback.R.id.guidedstep_background_view_root);
                Object createTransitionSet3 = TransitionHelper.createTransitionSet(false);
                TransitionHelper.addTransition(createTransitionSet3, createFadeAndShortSlide3);
                setEnterTransition((Transition) createTransitionSet3);
            }
            setSharedElementEnterTransition(null);
        } else if (uiStyle == 2) {
            setEnterTransition(null);
            setSharedElementEnterTransition(null);
        }
        Object createFadeAndShortSlide4 = TransitionHelper.createFadeAndShortSlide(GravityCompat.START);
        TransitionHelper.exclude(createFadeAndShortSlide4, androidx.leanback.R.id.guidedstep_background, true);
        TransitionHelper.exclude(createFadeAndShortSlide4, androidx.leanback.R.id.guidedactions_sub_list_background, true);
        setExitTransition((Transition) createFadeAndShortSlide4);
    }

    public int onProvideTheme() {
        return -1;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        getView().findViewById(androidx.leanback.R.id.action_fragment).requestFocus();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        List list = this.f5003i;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            GuidedAction guidedAction = (GuidedAction) list.get(i);
            if (m1296c(guidedAction)) {
                guidedAction.onSaveInstanceState(bundle, "action_" + guidedAction.getId());
            }
        }
        List list2 = this.f5004j;
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            GuidedAction guidedAction2 = (GuidedAction) list2.get(i2);
            if (m1296c(guidedAction2)) {
                guidedAction2.onSaveInstanceState(bundle, "buttonaction_" + guidedAction2.getId());
            }
        }
    }

    public boolean onSubGuidedActionClicked(@NonNull GuidedAction guidedAction) {
        return true;
    }

    public void openInEditMode(@Nullable GuidedAction guidedAction) {
        this.f4997c.openInEditMode(guidedAction);
    }

    public void popBackStackToGuidedStepFragment(@NonNull Class<?> cls, int i) {
        String str;
        if (!GuidedStepFragment.class.isAssignableFrom(cls)) {
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
        this.f5003i = list;
        GuidedActionAdapter guidedActionAdapter = this.f4999e;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.setActions(list);
        }
    }

    public void setActionsDiffCallback(@Nullable DiffCallback<GuidedAction> diffCallback) {
        this.f4999e.setDiffCallback(diffCallback);
    }

    public void setButtonActions(@NonNull List<GuidedAction> list) {
        this.f5004j = list;
        GuidedActionAdapter guidedActionAdapter = this.f5001g;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.setActions(list);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setEntranceTransitionType(int i) {
        this.f5005k = i;
    }

    public void setSelectedActionPosition(int i) {
        this.f4997c.getActionsGridView().setSelectedPosition(i);
    }

    public void setSelectedButtonActionPosition(int i) {
        this.f4998d.getActionsGridView().setSelectedPosition(i);
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

    public static int add(@NonNull FragmentManager fragmentManager, @NonNull GuidedStepFragment guidedStepFragment, int i) {
        String concat;
        GuidedStepFragment currentGuidedStepFragment = getCurrentGuidedStepFragment(fragmentManager);
        int i2 = currentGuidedStepFragment != null ? 1 : 0;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        guidedStepFragment.setUiStyle(i2 ^ 1);
        int uiStyle = guidedStepFragment.getUiStyle();
        Class<?> cls = guidedStepFragment.getClass();
        if (uiStyle == 0) {
            concat = "GuidedStepDefault".concat(cls.getName());
        } else if (uiStyle != 1) {
            concat = "";
        } else {
            concat = "GuidedStepEntrance".concat(cls.getName());
        }
        beginTransaction.addToBackStack(concat);
        if (currentGuidedStepFragment != null) {
            guidedStepFragment.onAddSharedElementTransition(beginTransaction, currentGuidedStepFragment);
        }
        return beginTransaction.replace(i, guidedStepFragment, "leanBackGuidedStepFragment").commit();
    }
}
