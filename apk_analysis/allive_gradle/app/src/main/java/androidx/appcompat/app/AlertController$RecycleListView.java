package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.appcompat.R;

/* loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: a */
    public final int f587a;

    /* renamed from: b */
    public final int f588b;

    public AlertController$RecycleListView(Context context) {
        this(context, null);
    }

    public void setHasDecor(boolean z, boolean z2) {
        int i;
        int i2;
        if (!z2 || !z) {
            int paddingLeft = getPaddingLeft();
            if (z) {
                i = getPaddingTop();
            } else {
                i = this.f587a;
            }
            int paddingRight = getPaddingRight();
            if (z2) {
                i2 = getPaddingBottom();
            } else {
                i2 = this.f588b;
            }
            setPadding(paddingLeft, i, paddingRight, i2);
        }
    }

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
        this.f588b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
        this.f587a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
    }
}
