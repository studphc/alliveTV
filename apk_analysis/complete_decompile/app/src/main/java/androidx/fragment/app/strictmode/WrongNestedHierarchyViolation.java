package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m5569d2 = {"Landroidx/fragment/app/strictmode/WrongNestedHierarchyViolation;", "Landroidx/fragment/app/strictmode/Violation;", "Landroidx/fragment/app/Fragment;", "fragment", "expectedParentFragment", "", "containerId", "<init>", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "b", "Landroidx/fragment/app/Fragment;", "getExpectedParentFragment", "()Landroidx/fragment/app/Fragment;", "c", "I", "getContainerId", "()I", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class WrongNestedHierarchyViolation extends Violation {

    /* renamed from: b, reason: from kotlin metadata */
    public final Fragment expectedParentFragment;

    /* renamed from: c, reason: from kotlin metadata */
    public final int containerId;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WrongNestedHierarchyViolation(@NotNull Fragment fragment, @NotNull Fragment expectedParentFragment, int i) {
        super(fragment, ye0.m8298r(r0, " without using parent's childFragmentManager", i));
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(expectedParentFragment, "expectedParentFragment");
        StringBuilder sb = new StringBuilder("Attempting to nest fragment ");
        sb.append(fragment);
        sb.append(" within the view of parent fragment ");
        sb.append(expectedParentFragment);
        sb.append(" via container with ID ");
        this.expectedParentFragment = expectedParentFragment;
        this.containerId = i;
    }

    public final int getContainerId() {
        return this.containerId;
    }

    @NotNull
    public final Fragment getExpectedParentFragment() {
        return this.expectedParentFragment;
    }
}
