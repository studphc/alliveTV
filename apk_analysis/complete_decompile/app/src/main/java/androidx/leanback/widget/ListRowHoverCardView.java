package androidx.leanback.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class ListRowHoverCardView extends LinearLayout {

    /* renamed from: a */
    public final TextView f5882a;

    /* renamed from: b */
    public final TextView f5883b;

    public ListRowHoverCardView(Context context) {
        this(context, null);
    }

    public final CharSequence getDescription() {
        return this.f5883b.getText();
    }

    public final CharSequence getTitle() {
        return this.f5882a.getText();
    }

    public final void setDescription(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f5883b;
        if (!isEmpty) {
            textView.setText(charSequence);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f5882a;
        if (!isEmpty) {
            textView.setText(charSequence);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    public ListRowHoverCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListRowHoverCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_list_row_hovercard, this);
        this.f5882a = (TextView) findViewById(androidx.leanback.R.id.title);
        this.f5883b = (TextView) findViewById(androidx.leanback.R.id.description);
    }
}
