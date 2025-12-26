package androidx.leanback.transition;

import android.R;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import p000.C1333ix;
import p000.iu0;
import p000.lu0;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class TransitionHelper {
    public static final int FADE_IN = 1;
    public static final int FADE_OUT = 2;

    @SuppressLint({"ReferencesDeprecated", "ClassVerificationFailure"})
    public static void addSharedElement(@NonNull FragmentTransaction fragmentTransaction, @NonNull View view, @NonNull String str) {
        fragmentTransaction.addSharedElement(view, str);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void addTarget(@NonNull Object obj, @NonNull View view) {
        ((Transition) obj).addTarget(view);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void addTransition(@NonNull Object obj, @NonNull Object obj2) {
        ((TransitionSet) obj).addTransition((Transition) obj2);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void addTransitionListener(@NonNull Object obj, @Nullable TransitionListener transitionListener) {
        if (transitionListener == null) {
            return;
        }
        lu0 lu0Var = new lu0(1, transitionListener);
        transitionListener.mImpl = lu0Var;
        ((Transition) obj).addListener(lu0Var);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup, @Nullable Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @NonNull
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createAutoTransition() {
        return new AutoTransition();
    }

    @NonNull
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createChangeBounds(boolean z) {
        C1333ix c1333ix = new C1333ix();
        c1333ix.setReparent(z);
        return c1333ix;
    }

    @NonNull
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createChangeTransform() {
        return new ChangeTransform();
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createDefaultInterpolator(@NonNull Context context) {
        return AnimationUtils.loadInterpolator(context, R.interpolator.fast_out_linear_in);
    }

    @NonNull
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createFadeAndShortSlide(int i) {
        return new FadeAndShortSlide(i);
    }

    @NonNull
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createFadeTransition(int i) {
        return new Fade(i);
    }

    @NonNull
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createScale() {
        return new ChangeTransform();
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createScene(@NonNull ViewGroup viewGroup, @Nullable Runnable runnable) {
        Scene scene = new Scene(viewGroup);
        scene.setEnterAction(runnable);
        return scene;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.transition.Visibility, androidx.leanback.transition.SlideKitkat, java.lang.Object] */
    @NonNull
    public static Object createSlide(int i) {
        ?? visibility = new Visibility();
        visibility.m1375b(80);
        visibility.m1375b(i);
        return visibility;
    }

    @NonNull
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createTransitionSet(boolean z) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(z ? 1 : 0);
        return transitionSet;
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void exclude(@NonNull Object obj, int i, boolean z) {
        ((Transition) obj).excludeTarget(i, z);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void excludeChildren(@NonNull Object obj, int i, boolean z) {
        ((Transition) obj).excludeChildren(i, z);
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object getEnterTransition(@NonNull Window window) {
        return window.getEnterTransition();
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object getExitTransition(@NonNull Window window) {
        return window.getExitTransition();
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object getReenterTransition(@NonNull Window window) {
        return window.getReenterTransition();
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object getReturnTransition(@NonNull Window window) {
        return window.getReturnTransition();
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object getSharedElementEnterTransition(@NonNull Window window) {
        return window.getSharedElementEnterTransition();
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object getSharedElementExitTransition(@NonNull Window window) {
        return window.getSharedElementExitTransition();
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object getSharedElementReenterTransition(@NonNull Window window) {
        return window.getSharedElementReenterTransition();
    }

    @Nullable
    @SuppressLint({"ClassVerificationFailure"})
    public static Object getSharedElementReturnTransition(@NonNull Window window) {
        return window.getSharedElementReturnTransition();
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void include(@NonNull Object obj, int i) {
        ((Transition) obj).addTarget(i);
    }

    @NonNull
    @SuppressLint({"ClassVerificationFailure"})
    public static Object loadTransition(@NonNull Context context, int i) {
        return TransitionInflater.from(context).inflateTransition(i);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void removeTransitionListener(@NonNull Object obj, @Nullable TransitionListener transitionListener) {
        Object obj2;
        if (transitionListener != null && (obj2 = transitionListener.mImpl) != null) {
            ((Transition) obj).removeListener((Transition.TransitionListener) obj2);
            transitionListener.mImpl = null;
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void runTransition(@Nullable Object obj, @Nullable Object obj2) {
        TransitionManager.go((Scene) obj, (Transition) obj2);
    }

    public static void setChangeBoundsDefaultStartDelay(@NonNull Object obj, int i) {
        ((C1333ix) obj).f20297a = i;
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setChangeBoundsStartDelay(@NonNull Object obj, @NonNull View view, int i) {
        ((C1333ix) obj).f20298b.put(view, Integer.valueOf(i));
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setDuration(@NonNull Object obj, long j) {
        ((Transition) obj).setDuration(j);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setEnterTransition(@NonNull Window window, @Nullable Object obj) {
        window.setEnterTransition((Transition) obj);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setEpicenterCallback(@NonNull Object obj, @Nullable TransitionEpicenterCallback transitionEpicenterCallback) {
        if (transitionEpicenterCallback == null) {
            ((Transition) obj).setEpicenterCallback(null);
        } else {
            ((Transition) obj).setEpicenterCallback(new iu0(2, transitionEpicenterCallback));
        }
    }

    @SuppressLint({"ReferencesDeprecated", "ClassVerificationFailure"})
    public static void setExitTransition(@NonNull Fragment fragment, @Nullable Object obj) {
        fragment.setExitTransition((Transition) obj);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setInterpolator(@NonNull Object obj, @Nullable Object obj2) {
        ((Transition) obj).setInterpolator((TimeInterpolator) obj2);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setReturnTransition(@NonNull Window window, @Nullable Object obj) {
        window.setReturnTransition((Transition) obj);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setSharedElementEnterTransition(@NonNull Window window, @Nullable Object obj) {
        window.setSharedElementEnterTransition((Transition) obj);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setSharedElementReturnTransition(@NonNull Window window, @Nullable Object obj) {
        window.setSharedElementReturnTransition((Transition) obj);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setStartDelay(@NonNull Object obj, long j) {
        ((Transition) obj).setStartDelay(j);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setTransitionGroup(@NonNull ViewGroup viewGroup, boolean z) {
        viewGroup.setTransitionGroup(z);
    }

    public static boolean systemSupportsEntranceTransitions() {
        return true;
    }

    @NonNull
    @SuppressLint({"ClassVerificationFailure"})
    public static Object createFadeAndShortSlide(int i, float f) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(i);
        fadeAndShortSlide.setDistance(f);
        return fadeAndShortSlide;
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void exclude(@NonNull Object obj, @NonNull View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void excludeChildren(@NonNull Object obj, @NonNull View view, boolean z) {
        ((Transition) obj).excludeChildren(view, z);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void include(@NonNull Object obj, @NonNull View view) {
        ((Transition) obj).addTarget(view);
    }

    @SuppressLint({"ReferencesDeprecated", "ClassVerificationFailure"})
    public static void setEnterTransition(@NonNull Fragment fragment, @Nullable Object obj) {
        fragment.setEnterTransition((Transition) obj);
    }

    @SuppressLint({"ReferencesDeprecated", "ClassVerificationFailure"})
    public static void setSharedElementEnterTransition(@NonNull Fragment fragment, @Nullable Object obj) {
        fragment.setSharedElementEnterTransition((Transition) obj);
    }

    public static void setChangeBoundsStartDelay(@NonNull Object obj, int i, int i2) {
        ((C1333ix) obj).f20299c.put(i, i2);
    }

    public static void setChangeBoundsStartDelay(@NonNull Object obj, @NonNull String str, int i) {
        ((C1333ix) obj).f20300d.put(str, Integer.valueOf(i));
    }
}
