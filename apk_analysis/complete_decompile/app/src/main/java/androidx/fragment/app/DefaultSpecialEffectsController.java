package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1327iq;
import p000.C1540m9;
import p000.RunnableC0583c7;
import p000.h10;
import p000.jt0;

@Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\b\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0016"}, m5569d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsController;", "Landroid/view/ViewGroup;", "container", "<init>", "(Landroid/view/ViewGroup;)V", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operations", "", "isPop", "", "collectEffects", "(Ljava/util/List;Z)V", "androidx/fragment/app/c", "androidx/fragment/app/d", "androidx/fragment/app/e", "Api24Impl", "Api26Impl", "SpecialEffectsInfo", "androidx/fragment/app/h", "androidx/fragment/app/i", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nDefaultSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1151:1\n288#2,2:1152\n533#2,6:1154\n1360#2:1160\n1446#2,5:1161\n819#2:1166\n847#2,2:1167\n766#2:1169\n857#2,2:1170\n1789#2,3:1172\n1726#2,3:1175\n1855#2,2:1178\n*S KotlinDebug\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController\n*L\n52#1:1152,2\n58#1:1154,6\n117#1:1160\n117#1:1161,5\n190#1:1166\n190#1:1167,2\n193#1:1169\n193#1:1170,2\n197#1:1172,3\n355#1:1175,3\n366#1:1178,2\n*E\n"})
/* loaded from: classes.dex */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: g */
    public static final /* synthetic */ int f4390g = 0;

    @RequiresApi(24)
    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$Api24Impl;", "", "Landroid/animation/AnimatorSet;", "animatorSet", "", "totalDuration", "(Landroid/animation/AnimatorSet;)J", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Api24Impl {

        @NotNull
        public static final Api24Impl INSTANCE = new Object();

        @DoNotInline
        public final long totalDuration(@NotNull AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    @RequiresApi(26)
    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$Api26Impl;", "", "Landroid/animation/AnimatorSet;", "animatorSet", "", "reverse", "(Landroid/animation/AnimatorSet;)V", "", "time", "setCurrentPlayTime", "(Landroid/animation/AnimatorSet;J)V", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Api26Impl {

        @NotNull
        public static final Api26Impl INSTANCE = new Object();

        @DoNotInline
        public final void reverse(@NotNull AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        @DoNotInline
        public final void setCurrentPlayTime(@NotNull AnimatorSet animatorSet, long time) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(time);
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m5569d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "a", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "getOperation", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "", "isVisibilityUnchanged", "()Z", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static class SpecialEffectsInfo {

        /* renamed from: a, reason: from kotlin metadata */
        public final SpecialEffectsController.Operation operation;

        public SpecialEffectsInfo(@NotNull SpecialEffectsController.Operation operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.operation = operation;
        }

        @NotNull
        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State state2;
            SpecialEffectsController.Operation operation = this.operation;
            View view = operation.getFragment().f4428K;
            if (view != null) {
                state = SpecialEffectsController.Operation.State.INSTANCE.asOperationState(view);
            } else {
                state = null;
            }
            SpecialEffectsController.Operation.State finalState = operation.getFinalState();
            if (state != finalState && (state == (state2 = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state2)) {
                return false;
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(@NotNull ViewGroup container) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
    }

    /* renamed from: g */
    public static void m1132g(ArrayMap arrayMap, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            arrayMap.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                if (child.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    m1132g(arrayMap, child);
                }
            }
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void collectEffects(@NotNull List<? extends SpecialEffectsController.Operation> operations, boolean isPop) {
        Object obj;
        SpecialEffectsController.Operation operation;
        Object obj2;
        ArrayList arrayList;
        FragmentTransitionImpl fragmentTransitionImpl;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        Object wrapTransitionInSet;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        SharedElementCallback sharedElementCallback;
        SharedElementCallback sharedElementCallback2;
        Pair m5575to;
        String findKeyForValue;
        SharedElementCallback sharedElementCallback3;
        SharedElementCallback sharedElementCallback4;
        boolean z;
        boolean z2 = isPop;
        Intrinsics.checkNotNullParameter(operations, "operations");
        Iterator<T> it = operations.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                SpecialEffectsController.Operation operation2 = (SpecialEffectsController.Operation) obj;
                SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.INSTANCE;
                View view = operation2.getFragment().f4428K;
                Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                SpecialEffectsController.Operation.State asOperationState = companion.asOperationState(view);
                SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
                if (asOperationState == state && operation2.getFinalState() != state) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) obj;
        ListIterator<? extends SpecialEffectsController.Operation> listIterator = operations.listIterator(operations.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                operation = listIterator.previous();
                SpecialEffectsController.Operation operation4 = operation;
                SpecialEffectsController.Operation.State.Companion companion2 = SpecialEffectsController.Operation.State.INSTANCE;
                View view2 = operation4.getFragment().f4428K;
                Intrinsics.checkNotNullExpressionValue(view2, "operation.fragment.mView");
                SpecialEffectsController.Operation.State asOperationState2 = companion2.asOperationState(view2);
                SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.VISIBLE;
                if (asOperationState2 != state2 && operation4.getFinalState() == state2) {
                    break;
                }
            } else {
                operation = null;
                break;
            }
        }
        SpecialEffectsController.Operation operation5 = operation;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + operation3 + " to " + operation5);
        }
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        Fragment fragment = ((SpecialEffectsController.Operation) CollectionsKt___CollectionsKt.last((List) operations)).getFragment();
        for (SpecialEffectsController.Operation operation6 : operations) {
            operation6.getFragment().f4431N.f20604b = fragment.f4431N.f20604b;
            operation6.getFragment().f4431N.f20605c = fragment.f4431N.f20605c;
            operation6.getFragment().f4431N.f20606d = fragment.f4431N.f20606d;
            operation6.getFragment().f4431N.f20607e = fragment.f4431N.f20607e;
        }
        for (SpecialEffectsController.Operation operation7 : operations) {
            arrayList10.add(new C0249d(operation7, z2));
            if (!z2 ? operation7 == operation5 : operation7 == operation3) {
                z = true;
            } else {
                z = false;
            }
            arrayList11.add(new C0254i(operation7, z2, z));
            operation7.addCompletionListener(new RunnableC0583c7(11, this, operation7));
        }
        ArrayList arrayList12 = new ArrayList();
        Iterator it2 = arrayList11.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (!((C0254i) next).isVisibilityUnchanged()) {
                arrayList12.add(next);
            }
        }
        ArrayList arrayList13 = new ArrayList();
        Iterator it3 = arrayList12.iterator();
        while (it3.hasNext()) {
            Object next2 = it3.next();
            if (((C0254i) next2).m1228a() != null) {
                arrayList13.add(next2);
            }
        }
        Iterator it4 = arrayList13.iterator();
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        while (it4.hasNext()) {
            C0254i c0254i = (C0254i) it4.next();
            FragmentTransitionImpl m1228a = c0254i.m1228a();
            if (fragmentTransitionImpl2 != null && m1228a != fragmentTransitionImpl2) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + c0254i.getOperation().getFragment() + " returned Transition " + c0254i.f4678b + " which uses a different Transition type than other Fragments.").toString());
            }
            fragmentTransitionImpl2 = m1228a;
        }
        if (fragmentTransitionImpl2 == null) {
            arrayList = arrayList10;
        } else {
            ArrayList arrayList14 = new ArrayList();
            ArrayList arrayList15 = new ArrayList();
            ArrayMap arrayMap = new ArrayMap();
            ArrayList arrayList16 = new ArrayList();
            ArrayList arrayList17 = new ArrayList();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayMap arrayMap3 = new ArrayMap();
            Iterator it5 = arrayList13.iterator();
            ArrayList arrayList18 = arrayList16;
            ArrayList arrayList19 = arrayList17;
            loop10: while (true) {
                obj2 = null;
                while (it5.hasNext()) {
                    Object obj3 = ((C0254i) it5.next()).f4680d;
                    if (obj3 != null && operation3 != null && operation5 != null) {
                        wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(obj3));
                        jt0 jt0Var = operation5.getFragment().f4431N;
                        if (jt0Var == null || (arrayList6 = jt0Var.f20609g) == null) {
                            arrayList6 = new ArrayList();
                        }
                        Intrinsics.checkNotNullExpressionValue(arrayList6, "lastIn.fragment.sharedElementSourceNames");
                        jt0 jt0Var2 = operation3.getFragment().f4431N;
                        if (jt0Var2 == null || (arrayList7 = jt0Var2.f20609g) == null) {
                            arrayList7 = new ArrayList();
                        }
                        Intrinsics.checkNotNullExpressionValue(arrayList7, "firstOut.fragment.sharedElementSourceNames");
                        jt0 jt0Var3 = operation3.getFragment().f4431N;
                        if (jt0Var3 == null || (arrayList8 = jt0Var3.f20610h) == null) {
                            arrayList8 = new ArrayList();
                        }
                        arrayList5 = arrayList10;
                        Intrinsics.checkNotNullExpressionValue(arrayList8, "firstOut.fragment.sharedElementTargetNames");
                        int size = arrayList8.size();
                        fragmentTransitionImpl = fragmentTransitionImpl2;
                        arrayList4 = arrayList13;
                        int i = 0;
                        while (i < size) {
                            int i2 = size;
                            int indexOf = arrayList6.indexOf(arrayList8.get(i));
                            if (indexOf != -1) {
                                arrayList6.set(indexOf, arrayList7.get(i));
                            }
                            i++;
                            size = i2;
                        }
                        jt0 jt0Var4 = operation5.getFragment().f4431N;
                        if (jt0Var4 == null || (arrayList9 = jt0Var4.f20610h) == null) {
                            arrayList9 = new ArrayList();
                        }
                        Intrinsics.checkNotNullExpressionValue(arrayList9, "lastIn.fragment.sharedElementTargetNames");
                        if (!z2) {
                            jt0 jt0Var5 = operation3.getFragment().f4431N;
                            if (jt0Var5 == null) {
                                sharedElementCallback3 = null;
                            } else {
                                sharedElementCallback3 = jt0Var5.f20620r;
                            }
                            jt0 jt0Var6 = operation5.getFragment().f4431N;
                            if (jt0Var6 == null) {
                                sharedElementCallback4 = null;
                            } else {
                                sharedElementCallback4 = jt0Var6.f20619q;
                            }
                            m5575to = TuplesKt.m5575to(sharedElementCallback3, sharedElementCallback4);
                        } else {
                            jt0 jt0Var7 = operation3.getFragment().f4431N;
                            if (jt0Var7 == null) {
                                sharedElementCallback = null;
                            } else {
                                sharedElementCallback = jt0Var7.f20619q;
                            }
                            jt0 jt0Var8 = operation5.getFragment().f4431N;
                            if (jt0Var8 == null) {
                                sharedElementCallback2 = null;
                            } else {
                                sharedElementCallback2 = jt0Var8.f20620r;
                            }
                            m5575to = TuplesKt.m5575to(sharedElementCallback, sharedElementCallback2);
                        }
                        SharedElementCallback sharedElementCallback5 = (SharedElementCallback) m5575to.component1();
                        SharedElementCallback sharedElementCallback6 = (SharedElementCallback) m5575to.component2();
                        int size2 = arrayList6.size();
                        int i3 = 0;
                        while (true) {
                            arrayList3 = arrayList15;
                            if (i3 >= size2) {
                                break;
                            }
                            int i4 = size2;
                            Object obj4 = arrayList6.get(i3);
                            Intrinsics.checkNotNullExpressionValue(obj4, "exitingNames[i]");
                            Object obj5 = arrayList9.get(i3);
                            Intrinsics.checkNotNullExpressionValue(obj5, "enteringNames[i]");
                            arrayMap.put((String) obj4, (String) obj5);
                            i3++;
                            size2 = i4;
                            arrayList15 = arrayList3;
                        }
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, ">>> entering view names <<<");
                            Iterator it6 = arrayList9.iterator();
                            while (true) {
                                arrayList2 = arrayList14;
                                if (!it6.hasNext()) {
                                    break;
                                }
                                Log.v(FragmentManager.TAG, "Name: " + ((String) it6.next()));
                                it6 = it6;
                                arrayList14 = arrayList2;
                            }
                            Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
                            for (Iterator it7 = arrayList6.iterator(); it7.hasNext(); it7 = it7) {
                                Log.v(FragmentManager.TAG, "Name: " + ((String) it7.next()));
                            }
                        } else {
                            arrayList2 = arrayList14;
                        }
                        View view3 = operation3.getFragment().f4428K;
                        Intrinsics.checkNotNullExpressionValue(view3, "firstOut.fragment.mView");
                        m1132g(arrayMap2, view3);
                        arrayMap2.retainAll(arrayList6);
                        if (sharedElementCallback5 != null) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Executing exit callback for operation " + operation3);
                            }
                            sharedElementCallback5.onMapSharedElements(arrayList6, arrayMap2);
                            int size3 = arrayList6.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i5 = size3 - 1;
                                    Object obj6 = arrayList6.get(size3);
                                    Intrinsics.checkNotNullExpressionValue(obj6, "exitingNames[i]");
                                    String str = (String) obj6;
                                    View view4 = (View) arrayMap2.get(str);
                                    if (view4 == null) {
                                        arrayMap.remove(str);
                                    } else if (!Intrinsics.areEqual(str, ViewCompat.getTransitionName(view4))) {
                                        arrayMap.put(ViewCompat.getTransitionName(view4), (String) arrayMap.remove(str));
                                    }
                                    if (i5 < 0) {
                                        break;
                                    } else {
                                        size3 = i5;
                                    }
                                }
                            }
                        } else {
                            arrayMap.retainAll(arrayMap2.keySet());
                        }
                        View view5 = operation5.getFragment().f4428K;
                        Intrinsics.checkNotNullExpressionValue(view5, "lastIn.fragment.mView");
                        m1132g(arrayMap3, view5);
                        arrayMap3.retainAll(arrayList9);
                        arrayMap3.retainAll(arrayMap.values());
                        if (sharedElementCallback6 != null) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Executing enter callback for operation " + operation5);
                            }
                            sharedElementCallback6.onMapSharedElements(arrayList9, arrayMap3);
                            int size4 = arrayList9.size() - 1;
                            if (size4 >= 0) {
                                while (true) {
                                    int i6 = size4 - 1;
                                    Object obj7 = arrayList9.get(size4);
                                    Intrinsics.checkNotNullExpressionValue(obj7, "enteringNames[i]");
                                    String str2 = (String) obj7;
                                    View view6 = (View) arrayMap3.get(str2);
                                    if (view6 == null) {
                                        String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap, str2);
                                        if (findKeyForValue2 != null) {
                                            arrayMap.remove(findKeyForValue2);
                                        }
                                    } else if (!Intrinsics.areEqual(str2, ViewCompat.getTransitionName(view6)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap, str2)) != null) {
                                        arrayMap.put(findKeyForValue, ViewCompat.getTransitionName(view6));
                                    }
                                    if (i6 < 0) {
                                        break;
                                    } else {
                                        size4 = i6;
                                    }
                                }
                            }
                        } else {
                            FragmentTransition.retainValues(arrayMap, arrayMap3);
                        }
                        Set keySet = arrayMap.keySet();
                        Intrinsics.checkNotNullExpressionValue(keySet, "sharedElementNameMapping.keys");
                        Set entries = arrayMap2.entrySet();
                        Intrinsics.checkNotNullExpressionValue(entries, "entries");
                        AbstractC1327iq.retainAll(entries, new h10(keySet, 0));
                        Collection values = arrayMap.values();
                        Intrinsics.checkNotNullExpressionValue(values, "sharedElementNameMapping.values");
                        Set entries2 = arrayMap3.entrySet();
                        Intrinsics.checkNotNullExpressionValue(entries2, "entries");
                        AbstractC1327iq.retainAll(entries2, new h10(values, 0));
                        if (arrayMap.isEmpty()) {
                            break;
                        }
                        z2 = isPop;
                        obj2 = wrapTransitionInSet;
                        arrayList19 = arrayList6;
                        arrayList18 = arrayList9;
                    } else {
                        fragmentTransitionImpl = fragmentTransitionImpl2;
                        arrayList2 = arrayList14;
                        arrayList3 = arrayList15;
                        arrayList4 = arrayList13;
                        arrayList5 = arrayList10;
                        z2 = isPop;
                    }
                    arrayList10 = arrayList5;
                    fragmentTransitionImpl2 = fragmentTransitionImpl;
                    arrayList13 = arrayList4;
                    arrayList15 = arrayList3;
                    arrayList14 = arrayList2;
                }
                Log.i(FragmentManager.TAG, "Ignoring shared elements transition " + wrapTransitionInSet + " between " + operation3 + " and " + operation5 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
                arrayList2.clear();
                arrayList3.clear();
                z2 = isPop;
                arrayList19 = arrayList6;
                arrayList18 = arrayList9;
                arrayList10 = arrayList5;
                fragmentTransitionImpl2 = fragmentTransitionImpl;
                arrayList13 = arrayList4;
                arrayList15 = arrayList3;
                arrayList14 = arrayList2;
            }
            FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
            ArrayList arrayList20 = arrayList14;
            ArrayList arrayList21 = arrayList15;
            ArrayList arrayList22 = arrayList13;
            ArrayList arrayList23 = arrayList10;
            if (obj2 == null) {
                if (!arrayList22.isEmpty()) {
                    Iterator it8 = arrayList22.iterator();
                    while (it8.hasNext()) {
                        if (((C0254i) it8.next()).f4678b == null) {
                        }
                    }
                }
                arrayList = arrayList23;
            }
            arrayList = arrayList23;
            C0253h c0253h = new C0253h(arrayList22, operation3, operation5, fragmentTransitionImpl3, obj2, arrayList20, arrayList21, arrayMap, arrayList18, arrayList19, arrayMap2, arrayMap3, isPop);
            Iterator it9 = arrayList22.iterator();
            while (it9.hasNext()) {
                ((C0254i) it9.next()).getOperation().addEffect(c0253h);
            }
        }
        ArrayList arrayList24 = new ArrayList();
        ArrayList arrayList25 = new ArrayList();
        Iterator it10 = arrayList.iterator();
        while (it10.hasNext()) {
            AbstractC1327iq.addAll(arrayList25, ((C0249d) it10.next()).getOperation().getEffects$fragment_release());
        }
        boolean isEmpty = arrayList25.isEmpty();
        Iterator it11 = arrayList.iterator();
        boolean z3 = false;
        while (it11.hasNext()) {
            C0249d c0249d = (C0249d) it11.next();
            Context context = getContainer().getContext();
            SpecialEffectsController.Operation operation8 = c0249d.getOperation();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            C1540m9 m1223a = c0249d.m1223a(context);
            if (m1223a != null) {
                if (((AnimatorSet) m1223a.f22855c) == null) {
                    arrayList24.add(c0249d);
                } else {
                    Fragment fragment2 = operation8.getFragment();
                    if (!operation8.getEffects$fragment_release().isEmpty()) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment2 + " as this Fragment was involved in a Transition.");
                        }
                    } else {
                        if (operation8.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation8.setAwaitingContainerChanges(false);
                        }
                        operation8.addEffect(new C0250e(c0249d));
                        z3 = true;
                    }
                }
            }
        }
        Iterator it12 = arrayList24.iterator();
        while (it12.hasNext()) {
            C0249d c0249d2 = (C0249d) it12.next();
            SpecialEffectsController.Operation operation9 = c0249d2.getOperation();
            Fragment fragment3 = operation9.getFragment();
            if (!isEmpty) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment3 + " as Animations cannot run alongside Transitions.");
                }
            } else if (z3) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment3 + " as Animations cannot run alongside Animators.");
                }
            } else {
                operation9.addEffect(new C0248c(c0249d2));
            }
        }
    }
}
