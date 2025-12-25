package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m5569d2 = {"Landroidx/fragment/app/strictmode/SetTargetFragmentUsageViolation;", "Landroidx/fragment/app/strictmode/TargetFragmentUsageViolation;", "Landroidx/fragment/app/Fragment;", "fragment", "targetFragment", "", "requestCode", "<init>", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "b", "Landroidx/fragment/app/Fragment;", "getTargetFragment", "()Landroidx/fragment/app/Fragment;", "c", "I", "getRequestCode", "()I", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class SetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {

    /* renamed from: b, reason: from kotlin metadata */
    public final Fragment targetFragment;

    /* renamed from: c, reason: from kotlin metadata */
    public final int requestCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetTargetFragmentUsageViolation(@NotNull Fragment fragment, @NotNull Fragment targetFragment, int i) {
        super(fragment, "Attempting to set target fragment " + targetFragment + " with request code " + i + " for fragment " + fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(targetFragment, "targetFragment");
        this.targetFragment = targetFragment;
        this.requestCode = i;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    @NotNull
    public final Fragment getTargetFragment() {
        return this.targetFragment;
    }
}
