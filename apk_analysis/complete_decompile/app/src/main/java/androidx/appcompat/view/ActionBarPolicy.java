package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarPolicy {

    /* renamed from: a */
    public Context f781a;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.appcompat.view.ActionBarPolicy] */
    public static ActionBarPolicy get(Context context) {
        ?? obj = new Object();
        obj.f781a = context;
        return obj;
    }

    public boolean enableHomeButtonByDefault() {
        if (this.f781a.getApplicationInfo().targetSdkVersion < 14) {
            return true;
        }
        return false;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.f781a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration configuration = this.f781a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i <= 600) {
            if (i <= 960 || i2 <= 720) {
                if (i <= 720 || i2 <= 960) {
                    if (i < 500) {
                        if (i <= 640 || i2 <= 480) {
                            if (i <= 480 || i2 <= 640) {
                                if (i >= 360) {
                                    return 3;
                                }
                                return 2;
                            }
                            return 4;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 5;
            }
            return 5;
        }
        return 5;
    }

    public int getStackedTabMaxWidth() {
        return this.f781a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        int[] iArr = R.styleable.ActionBar;
        int i = R.attr.actionBarStyle;
        Context context = this.f781a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!hasEmbeddedTabs()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean hasEmbeddedTabs() {
        return this.f781a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public boolean showsOverflowMenuButton() {
        return true;
    }
}
