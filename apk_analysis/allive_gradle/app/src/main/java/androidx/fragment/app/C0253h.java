package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import p000.AbstractC1204fq;
import p000.C1950wl;
import p000.RunnableC0006a5;
import p000.RunnableC0547b7;
import p000.g10;
import p000.nu0;

/* renamed from: androidx.fragment.app.h */
/* loaded from: classes.dex */
public final class C0253h extends SpecialEffectsController.Effect {

    /* renamed from: c */
    public final ArrayList f4663c;

    /* renamed from: d */
    public final SpecialEffectsController.Operation f4664d;

    /* renamed from: e */
    public final SpecialEffectsController.Operation f4665e;

    /* renamed from: f */
    public final FragmentTransitionImpl f4666f;

    /* renamed from: g */
    public final Object f4667g;

    /* renamed from: h */
    public final ArrayList f4668h;

    /* renamed from: i */
    public final ArrayList f4669i;

    /* renamed from: j */
    public final ArrayMap f4670j;

    /* renamed from: k */
    public final ArrayList f4671k;

    /* renamed from: l */
    public final ArrayList f4672l;

    /* renamed from: m */
    public final ArrayMap f4673m;

    /* renamed from: n */
    public final ArrayMap f4674n;

    /* renamed from: o */
    public final boolean f4675o;

    /* renamed from: p */
    public final CancellationSignal f4676p;

    /* renamed from: q */
    public Object f4677q;

    public C0253h(ArrayList transitionInfos, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, FragmentTransitionImpl transitionImpl, Object obj, ArrayList sharedElementFirstOutViews, ArrayList sharedElementLastInViews, ArrayMap sharedElementNameMapping, ArrayList enteringNames, ArrayList exitingNames, ArrayMap firstOutViews, ArrayMap lastInViews, boolean z) {
        Intrinsics.checkNotNullParameter(transitionInfos, "transitionInfos");
        Intrinsics.checkNotNullParameter(transitionImpl, "transitionImpl");
        Intrinsics.checkNotNullParameter(sharedElementFirstOutViews, "sharedElementFirstOutViews");
        Intrinsics.checkNotNullParameter(sharedElementLastInViews, "sharedElementLastInViews");
        Intrinsics.checkNotNullParameter(sharedElementNameMapping, "sharedElementNameMapping");
        Intrinsics.checkNotNullParameter(enteringNames, "enteringNames");
        Intrinsics.checkNotNullParameter(exitingNames, "exitingNames");
        Intrinsics.checkNotNullParameter(firstOutViews, "firstOutViews");
        Intrinsics.checkNotNullParameter(lastInViews, "lastInViews");
        this.f4663c = transitionInfos;
        this.f4664d = operation;
        this.f4665e = operation2;
        this.f4666f = transitionImpl;
        this.f4667g = obj;
        this.f4668h = sharedElementFirstOutViews;
        this.f4669i = sharedElementLastInViews;
        this.f4670j = sharedElementNameMapping;
        this.f4671k = enteringNames;
        this.f4672l = exitingNames;
        this.f4673m = firstOutViews;
        this.f4674n = lastInViews;
        this.f4675o = z;
        this.f4676p = new CancellationSignal();
    }

    /* renamed from: a */
    public static void m1224a(View view, ArrayList arrayList) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                if (!arrayList.contains(view)) {
                    arrayList.add(view);
                    return;
                }
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                if (child.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    m1224a(child, arrayList);
                }
            }
            return;
        }
        if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* renamed from: b */
    public final Pair m1225b(ViewGroup viewGroup, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        ArrayList<View> arrayList;
        ArrayList<View> arrayList2;
        Object obj;
        FragmentTransitionImpl fragmentTransitionImpl;
        Iterator it;
        C0253h c0253h = this;
        ViewGroup viewGroup2 = viewGroup;
        View view = new View(viewGroup.getContext());
        Rect rect = new Rect();
        ArrayList arrayList3 = c0253h.f4663c;
        Iterator it2 = arrayList3.iterator();
        View view2 = null;
        boolean z = false;
        while (true) {
            boolean hasNext = it2.hasNext();
            arrayList = c0253h.f4669i;
            arrayList2 = c0253h.f4668h;
            obj = c0253h.f4667g;
            fragmentTransitionImpl = c0253h.f4666f;
            if (!hasNext) {
                break;
            }
            if (((C0254i) it2.next()).f4680d != null && operation2 != null && operation != null && !c0253h.f4670j.isEmpty() && obj != null) {
                Fragment fragment = operation.getFragment();
                Fragment fragment2 = operation2.getFragment();
                it = it2;
                ArrayMap arrayMap = c0253h.f4673m;
                View view3 = view2;
                boolean z2 = z;
                z = true;
                FragmentTransition.callSharedElementStartEnd(fragment, fragment2, c0253h.f4675o, arrayMap, true);
                OneShotPreDrawListener.add(viewGroup2, new RunnableC0547b7(operation, operation2, c0253h, 3));
                arrayList2.addAll(arrayMap.values());
                ArrayList arrayList4 = c0253h.f4672l;
                if (!arrayList4.isEmpty()) {
                    Object obj2 = arrayList4.get(0);
                    Intrinsics.checkNotNullExpressionValue(obj2, "exitingNames[0]");
                    View view4 = (View) arrayMap.get((String) obj2);
                    fragmentTransitionImpl.setEpicenter(obj, view4);
                    view2 = view4;
                } else {
                    view2 = view3;
                }
                ArrayMap arrayMap2 = c0253h.f4674n;
                arrayList.addAll(arrayMap2.values());
                ArrayList arrayList5 = c0253h.f4671k;
                if (!arrayList5.isEmpty()) {
                    Object obj3 = arrayList5.get(0);
                    Intrinsics.checkNotNullExpressionValue(obj3, "enteringNames[0]");
                    View view5 = (View) arrayMap2.get((String) obj3);
                    if (view5 != null) {
                        OneShotPreDrawListener.add(viewGroup2, new RunnableC0547b7(fragmentTransitionImpl, view5, rect, 4));
                        fragmentTransitionImpl.setSharedElementTargets(obj, view, arrayList2);
                        FragmentTransitionImpl fragmentTransitionImpl2 = c0253h.f4666f;
                        Object obj4 = c0253h.f4667g;
                        fragmentTransitionImpl2.scheduleRemoveTargets(obj4, null, null, null, null, obj4, arrayList);
                    }
                }
                z = z2;
                fragmentTransitionImpl.setSharedElementTargets(obj, view, arrayList2);
                FragmentTransitionImpl fragmentTransitionImpl22 = c0253h.f4666f;
                Object obj42 = c0253h.f4667g;
                fragmentTransitionImpl22.scheduleRemoveTargets(obj42, null, null, null, null, obj42, arrayList);
            } else {
                it = it2;
                view2 = view2;
                z = z;
            }
            it2 = it;
        }
        View view6 = view2;
        boolean z3 = z;
        ArrayList arrayList6 = new ArrayList();
        Iterator it3 = arrayList3.iterator();
        Object obj5 = null;
        Object obj6 = null;
        while (it3.hasNext()) {
            C0254i c0254i = (C0254i) it3.next();
            Iterator it4 = it3;
            SpecialEffectsController.Operation operation3 = c0254i.getOperation();
            Object obj7 = obj6;
            Object cloneTransition = fragmentTransitionImpl.cloneTransition(c0254i.f4678b);
            if (cloneTransition != null) {
                Object obj8 = obj5;
                ArrayList<View> arrayList7 = new ArrayList<>();
                View view7 = operation3.getFragment().f4428K;
                Intrinsics.checkNotNullExpressionValue(view7, "operation.fragment.mView");
                m1224a(view7, arrayList7);
                if (obj != null && (operation3 == operation2 || operation3 == operation)) {
                    if (operation3 == operation2) {
                        arrayList7.removeAll(CollectionsKt___CollectionsKt.toSet(arrayList2));
                    } else {
                        arrayList7.removeAll(CollectionsKt___CollectionsKt.toSet(arrayList));
                    }
                }
                if (arrayList7.isEmpty()) {
                    fragmentTransitionImpl.addTarget(cloneTransition, view);
                } else {
                    fragmentTransitionImpl.addTargets(cloneTransition, arrayList7);
                    c0253h.f4666f.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList7, null, null, null, null);
                    if (operation3.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                        operation3.setAwaitingContainerChanges(false);
                        ArrayList<View> arrayList8 = new ArrayList<>(arrayList7);
                        arrayList8.remove(operation3.getFragment().f4428K);
                        fragmentTransitionImpl.scheduleHideFragmentView(cloneTransition, operation3.getFragment().f4428K, arrayList8);
                        OneShotPreDrawListener.add(viewGroup2, new RunnableC0006a5(11, arrayList7));
                    }
                }
                if (operation3.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                    arrayList6.addAll(arrayList7);
                    if (z3) {
                        fragmentTransitionImpl.setEpicenter(cloneTransition, rect);
                    }
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Entering Transition: " + cloneTransition);
                        Log.v(FragmentManager.TAG, ">>>>> EnteringViews <<<<<");
                        Iterator<View> it5 = arrayList7.iterator();
                        while (it5.hasNext()) {
                            View transitioningViews = it5.next();
                            Intrinsics.checkNotNullExpressionValue(transitioningViews, "transitioningViews");
                            Log.v(FragmentManager.TAG, "View: " + transitioningViews);
                        }
                    }
                } else {
                    View view8 = view6;
                    fragmentTransitionImpl.setEpicenter(cloneTransition, view8);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        view6 = view8;
                        Log.v(FragmentManager.TAG, "Exiting Transition: " + cloneTransition);
                        Log.v(FragmentManager.TAG, ">>>>> ExitingViews <<<<<");
                        Iterator<View> it6 = arrayList7.iterator();
                        while (it6.hasNext()) {
                            View transitioningViews2 = it6.next();
                            Intrinsics.checkNotNullExpressionValue(transitioningViews2, "transitioningViews");
                            Log.v(FragmentManager.TAG, "View: " + transitioningViews2);
                        }
                    } else {
                        view6 = view8;
                    }
                }
                if (c0254i.f4679c) {
                    obj5 = fragmentTransitionImpl.mergeTransitionsTogether(obj8, cloneTransition, null);
                    c0253h = this;
                    viewGroup2 = viewGroup;
                    it3 = it4;
                    obj6 = obj7;
                } else {
                    obj6 = fragmentTransitionImpl.mergeTransitionsTogether(obj7, cloneTransition, null);
                    c0253h = this;
                    obj5 = obj8;
                }
            } else {
                c0253h = this;
                obj6 = obj7;
            }
            it3 = it4;
            viewGroup2 = viewGroup;
        }
        Object mergeTransitionsInSequence = fragmentTransitionImpl.mergeTransitionsInSequence(obj5, obj6, obj);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Final merged transition: " + mergeTransitionsInSequence);
        }
        return new Pair(arrayList6, mergeTransitionsInSequence);
    }

    /* renamed from: c */
    public final boolean m1226c() {
        ArrayList arrayList = this.f4663c;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((C0254i) it.next()).getOperation().getFragment().f4460n) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m1227d(ArrayList arrayList, ViewGroup viewGroup, Function0 function0) {
        FragmentTransition.setViewVisibility(arrayList, 4);
        FragmentTransitionImpl fragmentTransitionImpl = this.f4666f;
        fragmentTransitionImpl.getClass();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<View> arrayList3 = this.f4669i;
        int size = arrayList3.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList3.get(i);
            arrayList2.add(ViewCompat.getTransitionName(view));
            ViewCompat.setTransitionName(view, null);
        }
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(2);
        ArrayList<View> arrayList4 = this.f4668h;
        if (isLoggingEnabled) {
            Log.v(FragmentManager.TAG, ">>>>> Beginning transition <<<<<");
            Log.v(FragmentManager.TAG, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator<View> it = arrayList4.iterator();
            while (it.hasNext()) {
                View sharedElementFirstOutViews = it.next();
                Intrinsics.checkNotNullExpressionValue(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                View view2 = sharedElementFirstOutViews;
                Log.v(FragmentManager.TAG, "View: " + view2 + " Name: " + ViewCompat.getTransitionName(view2));
            }
            Log.v(FragmentManager.TAG, ">>>>> SharedElementLastInViews <<<<<");
            Iterator<View> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                View sharedElementLastInViews = it2.next();
                Intrinsics.checkNotNullExpressionValue(sharedElementLastInViews, "sharedElementLastInViews");
                View view3 = sharedElementLastInViews;
                Log.v(FragmentManager.TAG, "View: " + view3 + " Name: " + ViewCompat.getTransitionName(view3));
            }
        }
        function0.invoke();
        int size2 = arrayList3.size();
        ArrayList arrayList5 = new ArrayList();
        for (int i2 = 0; i2 < size2; i2++) {
            View view4 = arrayList4.get(i2);
            String transitionName = ViewCompat.getTransitionName(view4);
            arrayList5.add(transitionName);
            if (transitionName != null) {
                ViewCompat.setTransitionName(view4, null);
                String str = (String) this.f4670j.get(transitionName);
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        break;
                    }
                    if (str.equals(arrayList2.get(i3))) {
                        ViewCompat.setTransitionName(arrayList3.get(i3), transitionName);
                        break;
                    }
                    i3++;
                }
            }
        }
        OneShotPreDrawListener.add(viewGroup, new nu0(size2, arrayList3, arrayList2, arrayList4, arrayList5));
        FragmentTransition.setViewVisibility(arrayList, 0);
        fragmentTransitionImpl.swapSharedElementTargets(this.f4667g, arrayList4, arrayList3);
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final boolean isSeekingSupported() {
        Object obj;
        FragmentTransitionImpl fragmentTransitionImpl = this.f4666f;
        if (fragmentTransitionImpl.isSeekingSupported()) {
            ArrayList arrayList = this.f4663c;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C0254i c0254i = (C0254i) it.next();
                    if (Build.VERSION.SDK_INT < 34 || (obj = c0254i.f4678b) == null || !fragmentTransitionImpl.isSeekingSupported(obj)) {
                        break;
                    }
                }
            }
            Object obj2 = this.f4667g;
            if (obj2 == null || fragmentTransitionImpl.isSeekingSupported(obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onCancel(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.f4676p.cancel();
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onCommit(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        boolean isLaidOut = container.isLaidOut();
        ArrayList arrayList = this.f4663c;
        if (!isLaidOut) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0254i c0254i = (C0254i) it.next();
                SpecialEffectsController.Operation operation = c0254i.getOperation();
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: Container " + container + " has not been laid out. Completing operation " + operation);
                }
                c0254i.getOperation().completeEffect(this);
            }
            return;
        }
        Object obj = this.f4677q;
        FragmentTransitionImpl fragmentTransitionImpl = this.f4666f;
        SpecialEffectsController.Operation operation2 = this.f4665e;
        SpecialEffectsController.Operation operation3 = this.f4664d;
        if (obj != null) {
            Intrinsics.checkNotNull(obj);
            fragmentTransitionImpl.animateToEnd(obj);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Ending execution of operations from " + operation3 + " to " + operation2);
                return;
            }
            return;
        }
        Pair m1225b = m1225b(container, operation2, operation3);
        ArrayList arrayList2 = (ArrayList) m1225b.component1();
        Object component2 = m1225b.component2();
        ArrayList arrayList3 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((C0254i) it2.next()).getOperation());
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) it3.next();
            fragmentTransitionImpl.setListenerForTransitionEnd(operation4.getFragment(), component2, this.f4676p, new g10(operation4, this, 1));
        }
        m1227d(arrayList2, container, new C1950wl(this, container, component2, 2));
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Completed executing operations from " + operation3 + " to " + operation2);
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onProgress(BackEventCompat backEvent, ViewGroup container) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        Intrinsics.checkNotNullParameter(container, "container");
        Object obj = this.f4677q;
        if (obj != null) {
            this.f4666f.setCurrentPlayTime(obj, backEvent.getProgress());
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onStart(ViewGroup container) {
        Object obj;
        Intrinsics.checkNotNullParameter(container, "container");
        boolean isLaidOut = container.isLaidOut();
        ArrayList arrayList = this.f4663c;
        if (!isLaidOut) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SpecialEffectsController.Operation operation = ((C0254i) it.next()).getOperation();
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + operation);
                }
            }
            return;
        }
        boolean m1226c = m1226c();
        SpecialEffectsController.Operation operation2 = this.f4665e;
        SpecialEffectsController.Operation operation3 = this.f4664d;
        if (m1226c && (obj = this.f4667g) != null && !isSeekingSupported()) {
            Log.i(FragmentManager.TAG, "Ignoring shared elements transition " + obj + " between " + operation3 + " and " + operation2 + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
        }
        if (isSeekingSupported() && m1226c()) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Pair m1225b = m1225b(container, operation2, operation3);
            ArrayList arrayList2 = (ArrayList) m1225b.component1();
            Object component2 = m1225b.component2();
            ArrayList arrayList3 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((C0254i) it2.next()).getOperation());
            }
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) it3.next();
                this.f4666f.setListenerForTransitionEnd(operation4.getFragment(), component2, this.f4676p, new RunnableC0006a5(10, objectRef), new g10(operation4, this, 0));
            }
            m1227d(arrayList2, container, new C0252g(this, container, component2, objectRef));
        }
    }
}
