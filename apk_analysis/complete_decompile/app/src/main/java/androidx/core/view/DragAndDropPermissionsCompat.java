package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import p000.g60;

/* loaded from: classes.dex */
public final class DragAndDropPermissionsCompat {

    /* renamed from: a */
    public final DragAndDropPermissions f3873a;

    public DragAndDropPermissionsCompat(DragAndDropPermissions dragAndDropPermissions) {
        this.f3873a = dragAndDropPermissions;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static DragAndDropPermissionsCompat request(@NonNull Activity activity, @NonNull DragEvent dragEvent) {
        DragAndDropPermissions m4930b;
        if (Build.VERSION.SDK_INT >= 24 && (m4930b = g60.m4930b(activity, dragEvent)) != null) {
            return new DragAndDropPermissionsCompat(m4930b);
        }
        return null;
    }

    public void release() {
        if (Build.VERSION.SDK_INT >= 24) {
            g60.m4929a(this.f3873a);
        }
    }
}
