package androidx.customview.poolingcontainer;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.o62;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\u0003*\u00020\t¢\u0006\u0004\b\n\u0010\u000b\"(\u0010\u000e\u001a\u00020\f*\u00020\u00002\u0006\u0010\r\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0012\u001a\u00020\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, m5569d2 = {"Landroid/view/View;", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addPoolingContainerListener", "(Landroid/view/View;Landroidx/customview/poolingcontainer/PoolingContainerListener;)V", "removePoolingContainerListener", "callPoolingContainerOnRelease", "(Landroid/view/View;)V", "Landroid/view/ViewGroup;", "callPoolingContainerOnReleaseForChildren", "(Landroid/view/ViewGroup;)V", "", "value", "isPoolingContainer", "(Landroid/view/View;)Z", "setPoolingContainer", "(Landroid/view/View;Z)V", "isWithinPoolingContainer", "customview-poolingcontainer_release"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
@JvmName(name = "PoolingContainer")
/* loaded from: classes.dex */
public final class PoolingContainer {

    /* renamed from: a */
    public static final int f4096a = R.id.pooling_container_listener_holder_tag;

    /* renamed from: b */
    public static final int f4097b = R.id.is_pooling_container_tag;

    /* renamed from: a */
    public static final o62 m1029a(View view) {
        int i = f4096a;
        o62 o62Var = (o62) view.getTag(i);
        if (o62Var == null) {
            o62 o62Var2 = new o62();
            view.setTag(i, o62Var2);
            return o62Var2;
        }
        return o62Var;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void addPoolingContainerListener(@NotNull View view, @NotNull PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        o62 m1029a = m1029a(view);
        Intrinsics.checkNotNullParameter(listener, "listener");
        m1029a.f23618a.add(listener);
    }

    public static final void callPoolingContainerOnRelease(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Iterator<View> it = ViewKt.getAllViews(view).iterator();
        while (it.hasNext()) {
            ArrayList arrayList = m1029a(it.next()).f23618a;
            for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList); -1 < lastIndex; lastIndex--) {
                ((PoolingContainerListener) arrayList.get(lastIndex)).onRelease();
            }
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Iterator<View> it = ViewGroupKt.getChildren(viewGroup).iterator();
        while (it.hasNext()) {
            ArrayList arrayList = m1029a(it.next()).f23618a;
            for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList); -1 < lastIndex; lastIndex--) {
                ((PoolingContainerListener) arrayList.get(lastIndex)).onRelease();
            }
        }
    }

    public static final boolean isPoolingContainer(@NotNull View view) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(f4097b);
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isWithinPoolingContainer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        for (Object obj : ViewKt.getAncestors(view)) {
            if ((obj instanceof View) && isPoolingContainer((View) obj)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void removePoolingContainerListener(@NotNull View view, @NotNull PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        o62 m1029a = m1029a(view);
        Intrinsics.checkNotNullParameter(listener, "listener");
        m1029a.f23618a.remove(listener);
    }

    public static final void setPoolingContainer(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(f4097b, Boolean.valueOf(z));
    }
}
