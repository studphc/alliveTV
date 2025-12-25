package p000;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public final class p60 implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        boolean z;
        DrawerLayout drawerLayout = (DrawerLayout) view;
        if (windowInsets.getSystemWindowInsetTop() > 0) {
            z = true;
        } else {
            z = false;
        }
        drawerLayout.setChildInsets(windowInsets, z);
        return windowInsets.consumeSystemWindowInsets();
    }
}
