package androidx.leanback.widget;

import android.annotation.SuppressLint;
import p000.rs0;

/* loaded from: classes.dex */
public class FocusHighlightHelper {
    @SuppressLint({"PrivateConstructorForUtilityClass"})
    @Deprecated
    public FocusHighlightHelper() {
    }

    public static void setupBrowseItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter, int i, boolean z) {
        if (i == 0 && !z) {
            itemBridgeAdapter.f5871g = null;
        } else {
            itemBridgeAdapter.f5871g = new rs0(i, z);
        }
    }

    @Deprecated
    public static void setupHeaderItemFocusHighlight(VerticalGridView verticalGridView) {
        setupHeaderItemFocusHighlight(verticalGridView, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static void setupHeaderItemFocusHighlight(VerticalGridView verticalGridView, boolean z) {
        if (verticalGridView == null || !(verticalGridView.getAdapter() instanceof ItemBridgeAdapter)) {
            return;
        }
        ((ItemBridgeAdapter) verticalGridView.getAdapter()).f5871g = z ? new Object() : null;
    }

    public static void setupHeaderItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter) {
        setupHeaderItemFocusHighlight(itemBridgeAdapter, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setupHeaderItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter, boolean z) {
        itemBridgeAdapter.f5871g = z ? new Object() : null;
    }
}
