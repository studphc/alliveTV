package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public final class ListRowView extends LinearLayout {

    /* renamed from: a */
    public final HorizontalGridView f5911a;

    public ListRowView(Context context) {
        this(context, null);
    }

    public HorizontalGridView getGridView() {
        return this.f5911a;
    }

    public ListRowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_list_row, this);
        HorizontalGridView horizontalGridView = (HorizontalGridView) findViewById(androidx.leanback.R.id.row_content);
        this.f5911a = horizontalGridView;
        horizontalGridView.setHasFixedSize(false);
        setOrientation(1);
        setDescendantFocusability(262144);
    }
}
