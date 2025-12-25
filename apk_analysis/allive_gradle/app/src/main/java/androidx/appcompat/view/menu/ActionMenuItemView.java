package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TooltipCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {

    /* renamed from: h */
    public MenuItemImpl f836h;

    /* renamed from: i */
    public CharSequence f837i;

    /* renamed from: j */
    public Drawable f838j;

    /* renamed from: k */
    public MenuBuilder.ItemInvoker f839k;

    /* renamed from: l */
    public C0087a f840l;

    /* renamed from: m */
    public PopupCallback f841m;

    /* renamed from: n */
    public boolean f842n;

    /* renamed from: o */
    public boolean f843o;

    /* renamed from: p */
    public final int f844p;

    /* renamed from: q */
    public int f845q;

    /* renamed from: r */
    public final int f846r;

    /* loaded from: classes.dex */
    public static abstract class PopupCallback {
        public abstract ShowableListMenu getPopup();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    /* renamed from: e */
    public final boolean m209e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480 && ((i < 640 || i2 < 480) && configuration.orientation != 2)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final void m210f() {
        CharSequence charSequence;
        CharSequence title;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f837i);
        if (this.f838j != null && (!this.f836h.showsTextAsAction() || (!this.f842n && !this.f843o))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        if (z3) {
            charSequence = this.f837i;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence contentDescription = this.f836h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z3) {
                title = null;
            } else {
                title = this.f836h.getTitle();
            }
            setContentDescription(title);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f836h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.f836h.getTitle();
            }
            TooltipCompat.setTooltipText(this, charSequence2);
            return;
        }
        TooltipCompat.setTooltipText(this, tooltipText);
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f836h;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        CharSequence title;
        int i2;
        this.f836h = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        if (prefersCondensedTitle()) {
            title = menuItemImpl.getTitleCondensed();
        } else {
            title = menuItemImpl.getTitle();
        }
        setTitle(title);
        setId(menuItemImpl.getItemId());
        if (menuItemImpl.isVisible()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        setVisibility(i2);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f840l == null) {
            this.f840l = new C0087a(this);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        if (hasText() && this.f836h.getIcon() == null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.f839k;
        if (itemInvoker != null) {
            itemInvoker.invokeItem(this.f836h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f842n = m209e();
        m210f();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean hasText = hasText();
        if (hasText && (i4 = this.f845q) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i5 = this.f844p;
        if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(size, i5);
        } else {
            i3 = i5;
        }
        if (mode != 1073741824 && i5 > 0 && measuredWidth < i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
        }
        if (!hasText && this.f838j != null) {
            super.setPadding((getMeasuredWidth() - this.f838j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0087a c0087a;
        if (this.f836h.hasSubMenu() && (c0087a = this.f840l) != null && c0087a.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f843o != z) {
            this.f843o = z;
            MenuItemImpl menuItemImpl = this.f836h;
            if (menuItemImpl != null) {
                menuItemImpl.actionFormatChanged();
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        this.f838j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f846r;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        m210f();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f839k = itemInvoker;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f845q = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f841m = popupCallback;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.f837i = charSequence;
        m210f();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f842n = m209e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.f844p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f846r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f845q = -1;
        setSaveEnabled(false);
    }
}
