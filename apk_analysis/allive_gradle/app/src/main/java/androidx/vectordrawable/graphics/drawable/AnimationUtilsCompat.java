package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AnimationUtilsCompat {
    public static Interpolator loadInterpolator(Context context, int i) {
        return AnimationUtils.loadInterpolator(context, i);
    }
}
