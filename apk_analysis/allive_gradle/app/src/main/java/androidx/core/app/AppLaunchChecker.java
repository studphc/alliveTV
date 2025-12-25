package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.core.content.IntentCompat;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class AppLaunchChecker {
    @Deprecated
    public AppLaunchChecker() {
    }

    public static boolean hasStartedFromLauncher(@NonNull Context context) {
        return context.getSharedPreferences("android.support.AppLaunchChecker", 0).getBoolean("startedFromLauncher", false);
    }

    public static void onActivityCreate(@NonNull Activity activity) {
        Intent intent;
        SharedPreferences sharedPreferences = activity.getSharedPreferences("android.support.AppLaunchChecker", 0);
        if (!sharedPreferences.getBoolean("startedFromLauncher", false) && (intent = activity.getIntent()) != null && "android.intent.action.MAIN".equals(intent.getAction())) {
            if (intent.hasCategory("android.intent.category.LAUNCHER") || intent.hasCategory(IntentCompat.CATEGORY_LEANBACK_LAUNCHER)) {
                sharedPreferences.edit().putBoolean("startedFromLauncher", true).apply();
            }
        }
    }
}
