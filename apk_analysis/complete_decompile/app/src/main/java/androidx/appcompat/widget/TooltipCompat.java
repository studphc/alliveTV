package androidx.appcompat.widget;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.qu2;
import p000.su2;

/* loaded from: classes.dex */
public class TooltipCompat {
    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            qu2.m7148a(view, charSequence);
            return;
        }
        su2 su2Var = su2.f26569k;
        if (su2Var != null && su2Var.f26571a == view) {
            su2.m7415b(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            su2 su2Var2 = su2.f26570l;
            if (su2Var2 != null && su2Var2.f26571a == view) {
                su2Var2.m7416a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new su2(view, charSequence);
    }
}
