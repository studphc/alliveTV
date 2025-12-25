package androidx.leanback.widget;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class PageRow extends Row {
    public PageRow(@Nullable HeaderItem headerItem) {
        super(headerItem);
    }

    @Override // androidx.leanback.widget.Row
    public final boolean isRenderedAsRowView() {
        return false;
    }
}
