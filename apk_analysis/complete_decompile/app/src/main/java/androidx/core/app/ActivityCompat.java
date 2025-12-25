package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.Arrays;
import java.util.HashSet;
import p000.AbstractC0545b5;
import p000.AbstractC0581c5;
import p000.AbstractC1110d5;
import p000.AbstractC1146e5;
import p000.AbstractC1183f5;
import p000.AbstractC1220g5;
import p000.AbstractC1257h5;
import p000.AbstractC1726qj;
import p000.RunnableC0006a5;

/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {

    /* renamed from: b */
    public static PermissionCompatDelegate f3271b;

    /* loaded from: classes.dex */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity activity, @IntRange(from = 0) int i, int i2, @Nullable Intent intent);

        boolean requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void finishAffinity(@NonNull Activity activity) {
        activity.finishAffinity();
    }

    public static void finishAfterTransition(@NonNull Activity activity) {
        AbstractC0545b5.m2019a(activity);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return f3271b;
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity activity) {
        return AbstractC0581c5.m2197a(activity);
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(@NonNull Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            return AbstractC1220g5.m4917a(activity);
        }
        if (i == 30) {
            if (AbstractC1183f5.m4770a(activity) != null && AbstractC1183f5.m4770a(activity).getDisplayId() != 0) {
                return true;
            }
            return false;
        }
        if (i != 29) {
            return false;
        }
        if (activity.getWindowManager().getDefaultDisplay() != null && activity.getWindowManager().getDefaultDisplay().getDisplayId() != 0) {
            return true;
        }
        return false;
    }

    public static void postponeEnterTransition(@NonNull Activity activity) {
        AbstractC0545b5.m2020b(activity);
    }

    public static void recreate(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new RunnableC0006a5(0, activity));
        }
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(@NonNull Activity activity, @NonNull DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i) {
        String[] strArr2;
        PermissionCompatDelegate permissionCompatDelegate = f3271b;
        if (permissionCompatDelegate != null && permissionCompatDelegate.requestPermissions(activity, strArr, i)) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (!TextUtils.isEmpty(strArr[i2])) {
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i2));
                }
            } else {
                throw new IllegalArgumentException(AbstractC1726qj.m7061q(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            strArr2 = new String[strArr.length - size];
        } else {
            strArr2 = strArr;
        }
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!hashSet.contains(Integer.valueOf(i4))) {
                    strArr2[i3] = strArr[i4];
                    i3++;
                }
            }
        }
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
        }
        AbstractC1110d5.m4523b(activity, strArr, i);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity activity, @IdRes int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) AbstractC1146e5.m4657a(activity, i);
        }
        T t = (T) activity.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void setEnterSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        SharedElementCallbackC0138a sharedElementCallbackC0138a;
        if (sharedElementCallback != null) {
            sharedElementCallbackC0138a = new SharedElementCallbackC0138a(sharedElementCallback);
        } else {
            sharedElementCallbackC0138a = null;
        }
        AbstractC0545b5.m2021c(activity, sharedElementCallbackC0138a);
    }

    public static void setExitSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        SharedElementCallbackC0138a sharedElementCallbackC0138a;
        if (sharedElementCallback != null) {
            sharedElementCallbackC0138a = new SharedElementCallbackC0138a(sharedElementCallback);
        } else {
            sharedElementCallbackC0138a = null;
        }
        AbstractC0545b5.m2022d(activity, sharedElementCallbackC0138a);
    }

    public static void setLocusContext(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC1183f5.m4771b(activity, locusIdCompat, bundle);
        }
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate permissionCompatDelegate) {
        f3271b = permissionCompatDelegate;
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, @NonNull String str) {
        int i = Build.VERSION.SDK_INT;
        if (i < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i >= 32) {
            return AbstractC1257h5.m5037a(activity, str);
        }
        if (i == 31) {
            return AbstractC1220g5.m4918b(activity, str);
        }
        return AbstractC1110d5.m4524c(activity, str);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i, @Nullable Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void startIntentSenderForResult(@NonNull Activity activity, @NonNull IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void startPostponedEnterTransition(@NonNull Activity activity) {
        AbstractC0545b5.m2023e(activity);
    }
}
