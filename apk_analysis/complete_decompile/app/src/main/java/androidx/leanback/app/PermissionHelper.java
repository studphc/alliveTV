package androidx.leanback.app;

import android.annotation.SuppressLint;
import android.app.Fragment;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class PermissionHelper {
    @SuppressLint({"ReferencesDeprecated"})
    public static void requestPermissions(Fragment fragment, String[] strArr, int i) {
        fragment.requestPermissions(strArr, i);
    }
}
