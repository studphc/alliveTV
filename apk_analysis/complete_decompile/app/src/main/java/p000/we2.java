package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.TooltipCompat;

/* loaded from: classes.dex */
public final class we2 extends LinearLayout {

    /* renamed from: a */
    public ActionBar.Tab f28160a;

    /* renamed from: b */
    public AppCompatTextView f28161b;

    /* renamed from: c */
    public AppCompatImageView f28162c;

    /* renamed from: d */
    public View f28163d;

    /* renamed from: e */
    public final /* synthetic */ ScrollingTabContainerView f28164e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public we2(ScrollingTabContainerView scrollingTabContainerView, Context context, ActionBar.Tab tab, boolean z) {
        super(context, null, r3);
        this.f28164e = scrollingTabContainerView;
        int i = R.attr.actionBarTabStyle;
        int[] iArr = {android.R.attr.background};
        this.f28160a = tab;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, iArr, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        obtainStyledAttributes.recycle();
        if (z) {
            setGravity(8388627);
        }
        m8056a();
    }

    /* renamed from: a */
    public final void m8056a() {
        ActionBar.Tab tab = this.f28160a;
        View customView = tab.getCustomView();
        CharSequence charSequence = null;
        if (customView != null) {
            ViewParent parent = customView.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(customView);
                }
                addView(customView);
            }
            this.f28163d = customView;
            AppCompatTextView appCompatTextView = this.f28161b;
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(8);
            }
            AppCompatImageView appCompatImageView = this.f28162c;
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(8);
                this.f28162c.setImageDrawable(null);
                return;
            }
            return;
        }
        View view = this.f28163d;
        if (view != null) {
            removeView(view);
            this.f28163d = null;
        }
        Drawable icon = tab.getIcon();
        CharSequence text = tab.getText();
        if (icon != null) {
            if (this.f28162c == null) {
                AppCompatImageView appCompatImageView2 = new AppCompatImageView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                appCompatImageView2.setLayoutParams(layoutParams);
                addView(appCompatImageView2, 0);
                this.f28162c = appCompatImageView2;
            }
            this.f28162c.setImageDrawable(icon);
            this.f28162c.setVisibility(0);
        } else {
            AppCompatImageView appCompatImageView3 = this.f28162c;
            if (appCompatImageView3 != null) {
                appCompatImageView3.setVisibility(8);
                this.f28162c.setImageDrawable(null);
            }
        }
        boolean isEmpty = TextUtils.isEmpty(text);
        if (!isEmpty) {
            if (this.f28161b == null) {
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                appCompatTextView2.setEllipsize(TextUtils.TruncateAt.END);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 16;
                appCompatTextView2.setLayoutParams(layoutParams2);
                addView(appCompatTextView2);
                this.f28161b = appCompatTextView2;
            }
            this.f28161b.setText(text);
            this.f28161b.setVisibility(0);
        } else {
            AppCompatTextView appCompatTextView3 = this.f28161b;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setVisibility(8);
                this.f28161b.setText((CharSequence) null);
            }
        }
        AppCompatImageView appCompatImageView4 = this.f28162c;
        if (appCompatImageView4 != null) {
            appCompatImageView4.setContentDescription(tab.getContentDescription());
        }
        if (isEmpty) {
            charSequence = tab.getContentDescription();
        }
        TooltipCompat.setTooltipText(this, charSequence);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ScrollingTabContainerView scrollingTabContainerView = this.f28164e;
        if (scrollingTabContainerView.f1352f > 0) {
            int measuredWidth = getMeasuredWidth();
            int i3 = scrollingTabContainerView.f1352f;
            if (measuredWidth > i3) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
            }
        }
    }

    @Override // android.view.View
    public final void setSelected(boolean z) {
        boolean z2;
        if (isSelected() != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        super.setSelected(z);
        if (z2 && z) {
            sendAccessibilityEvent(4);
        }
    }
}
