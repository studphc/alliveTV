package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.jt0;

@Metadata(m5568d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001J)\u0010\u0005\u001a\u0004\u0018\u00010\u0003*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\n\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000bJC\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u001f¨\u0006!"}, m5569d2 = {"Landroidx/fragment/app/FragmentTransition;", "", "Landroidx/collection/ArrayMap;", "", "value", "findKeyForValue", "(Landroidx/collection/ArrayMap;Ljava/lang/String;)Ljava/lang/String;", "Landroid/view/View;", "namedViews", "", "retainValues", "(Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;)V", "Landroidx/fragment/app/Fragment;", "inFragment", "outFragment", "", "isPop", "sharedElements", "isStart", "callSharedElementStartEnd", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;ZLandroidx/collection/ArrayMap;Z)V", "", "views", "", "visibility", "setViewVisibility", "(Ljava/util/List;I)V", "supportsTransition", "()Z", "Landroidx/fragment/app/FragmentTransitionImpl;", "PLATFORM_IMPL", "Landroidx/fragment/app/FragmentTransitionImpl;", "SUPPORT_IMPL", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nFragmentTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentTransition.kt\nandroidx/fragment/app/FragmentTransition\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n515#2:124\n500#2,6:125\n125#3:131\n152#3,3:132\n125#3:135\n152#3,3:136\n125#3:139\n152#3,3:140\n1855#4,2:143\n*S KotlinDebug\n*F\n+ 1 FragmentTransition.kt\nandroidx/fragment/app/FragmentTransition\n*L\n50#1:124\n50#1:125,6\n53#1:131\n53#1:132,3\n98#1:135\n98#1:136,3\n99#1:139\n99#1:140,3\n113#1:143,2\n*E\n"})
/* loaded from: classes.dex */
public final class FragmentTransition {

    @NotNull
    public static final FragmentTransition INSTANCE = new Object();

    @JvmField
    @Nullable
    public static final FragmentTransitionImpl PLATFORM_IMPL = new FragmentTransitionImpl();

    @JvmField
    @Nullable
    public static final FragmentTransitionImpl SUPPORT_IMPL;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.FragmentTransition, java.lang.Object] */
    static {
        FragmentTransitionImpl fragmentTransitionImpl = null;
        try {
            Class<?> cls = Class.forName("androidx.transition.FragmentTransitionSupport");
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            fragmentTransitionImpl = (FragmentTransitionImpl) cls.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        SUPPORT_IMPL = fragmentTransitionImpl;
    }

    @JvmStatic
    public static final void callSharedElementStartEnd(@NotNull Fragment inFragment, @NotNull Fragment outFragment, boolean isPop, @NotNull ArrayMap<String, View> sharedElements, boolean isStart) {
        SharedElementCallback sharedElementCallback;
        Intrinsics.checkNotNullParameter(inFragment, "inFragment");
        Intrinsics.checkNotNullParameter(outFragment, "outFragment");
        Intrinsics.checkNotNullParameter(sharedElements, "sharedElements");
        if (isPop) {
            jt0 jt0Var = outFragment.f4431N;
            if (jt0Var != null) {
                sharedElementCallback = jt0Var.f20619q;
            }
            sharedElementCallback = null;
        } else {
            jt0 jt0Var2 = inFragment.f4431N;
            if (jt0Var2 != null) {
                sharedElementCallback = jt0Var2.f20619q;
            }
            sharedElementCallback = null;
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList(sharedElements.size());
            Iterator<Map.Entry<String, View>> it = sharedElements.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            ArrayList arrayList2 = new ArrayList(sharedElements.size());
            Iterator<Map.Entry<String, View>> it2 = sharedElements.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().getKey());
            }
            if (isStart) {
                sharedElementCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                sharedElementCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    @JvmStatic
    @Nullable
    public static final String findKeyForValue(@NotNull ArrayMap<String, String> arrayMap, @NotNull String value) {
        Intrinsics.checkNotNullParameter(arrayMap, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : arrayMap.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue(), value)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        return (String) CollectionsKt___CollectionsKt.firstOrNull((List) arrayList);
    }

    @JvmStatic
    public static final void retainValues(@NotNull ArrayMap<String, String> arrayMap, @NotNull ArrayMap<String, View> namedViews) {
        Intrinsics.checkNotNullParameter(arrayMap, "<this>");
        Intrinsics.checkNotNullParameter(namedViews, "namedViews");
        int f1755c = arrayMap.getF1755c();
        while (true) {
            f1755c--;
            if (-1 < f1755c) {
                if (!namedViews.containsKey(arrayMap.valueAt(f1755c))) {
                    arrayMap.removeAt(f1755c);
                }
            } else {
                return;
            }
        }
    }

    @JvmStatic
    public static final void setViewVisibility(@NotNull List<? extends View> views, int visibility) {
        Intrinsics.checkNotNullParameter(views, "views");
        Iterator<T> it = views.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(visibility);
        }
    }

    @JvmStatic
    public static final boolean supportsTransition() {
        if (PLATFORM_IMPL == null && SUPPORT_IMPL == null) {
            return false;
        }
        return true;
    }
}
