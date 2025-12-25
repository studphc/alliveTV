package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a */
    public MenuItemImpl f853a;

    /* renamed from: b */
    public ImageView f854b;

    /* renamed from: c */
    public RadioButton f855c;

    /* renamed from: d */
    public TextView f856d;

    /* renamed from: e */
    public CheckBox f857e;

    /* renamed from: f */
    public TextView f858f;

    /* renamed from: g */
    public ImageView f859g;

    /* renamed from: h */
    public ImageView f860h;

    /* renamed from: i */
    public LinearLayout f861i;

    /* renamed from: j */
    public final Drawable f862j;

    /* renamed from: k */
    public final int f863k;

    /* renamed from: l */
    public final Context f864l;

    /* renamed from: m */
    public boolean f865m;

    /* renamed from: n */
    public final Drawable f866n;

    /* renamed from: o */
    public final boolean f867o;

    /* renamed from: p */
    public LayoutInflater f868p;

    /* renamed from: q */
    public boolean f869q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f868p == null) {
            this.f868p = LayoutInflater.from(getContext());
        }
        return this.f868p;
    }

    private void setSubMenuArrowVisible(boolean z) {
        int i;
        ImageView imageView = this.f859g;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f860h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f860h.getLayoutParams();
            rect.top = this.f860h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f853a;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        int i2;
        CharSequence title;
        char c;
        char c2;
        this.f853a = menuItemImpl;
        boolean z = false;
        if (menuItemImpl.isVisible()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        setVisibility(i2);
        if (prefersCondensedTitle()) {
            title = menuItemImpl.getTitleCondensed();
        } else {
            title = menuItemImpl.getTitle();
        }
        setTitle(title);
        setCheckable(menuItemImpl.isCheckable());
        if (menuItemImpl.f931n.isShortcutsVisible()) {
            if (menuItemImpl.f931n.isQwertyMode()) {
                c2 = menuItemImpl.f927j;
            } else {
                c2 = menuItemImpl.f925h;
            }
            if (c2 != 0) {
                z = true;
            }
        }
        if (menuItemImpl.f931n.isQwertyMode()) {
            c = menuItemImpl.f927j;
        } else {
            c = menuItemImpl.f925h;
        }
        setShortcut(z, c);
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f862j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f856d = textView;
        int i = this.f863k;
        if (i != -1) {
            textView.setTextAppearance(this.f864l, i);
        }
        this.f858f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f859g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f866n);
        }
        this.f860h = (ImageView) findViewById(R.id.group_divider);
        this.f861i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f854b != null && this.f865m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f854b.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.f855c == null && this.f857e == null) {
            return;
        }
        if (this.f853a.isExclusiveCheckable()) {
            if (this.f855c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f855c = radioButton;
                LinearLayout linearLayout = this.f861i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f855c;
            view = this.f857e;
        } else {
            if (this.f857e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f857e = checkBox;
                LinearLayout linearLayout2 = this.f861i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f857e;
            view = this.f855c;
        }
        if (z) {
            compoundButton.setChecked(this.f853a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view != null && view.getVisibility() != 8) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        CheckBox checkBox2 = this.f857e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f855c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f853a.isExclusiveCheckable()) {
            if (this.f855c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f855c = radioButton;
                LinearLayout linearLayout = this.f861i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f855c;
        } else {
            if (this.f857e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f857e = checkBox;
                LinearLayout linearLayout2 = this.f861i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f857e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f869q = z;
        this.f865m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        int i;
        ImageView imageView = this.f860h;
        if (imageView != null) {
            if (!this.f867o && z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        boolean z;
        if (!this.f853a.shouldShowIcon() && !this.f869q) {
            z = false;
        } else {
            z = true;
        }
        if (!z && !this.f865m) {
            return;
        }
        ImageView imageView = this.f854b;
        if (imageView == null && drawable == null && !this.f865m) {
            return;
        }
        if (imageView == null) {
            ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
            this.f854b = imageView2;
            LinearLayout linearLayout = this.f861i;
            if (linearLayout != null) {
                linearLayout.addView(imageView2, 0);
            } else {
                addView(imageView2, 0);
            }
        }
        if (drawable == null && !this.f865m) {
            this.f854b.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.f854b;
        if (!z) {
            drawable = null;
        }
        imageView3.setImageDrawable(drawable);
        if (this.f854b.getVisibility() != 0) {
            this.f854b.setVisibility(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r9 == false) goto L15;
     */
    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setShortcut(boolean z, char c) {
        int i;
        char c2;
        int i2;
        String sb;
        boolean z2;
        char c3;
        if (z) {
            MenuItemImpl menuItemImpl = this.f853a;
            i = 0;
            if (menuItemImpl.f931n.isShortcutsVisible()) {
                if (menuItemImpl.f931n.isQwertyMode()) {
                    c3 = menuItemImpl.f927j;
                } else {
                    c3 = menuItemImpl.f925h;
                }
                if (c3 != 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        i = 8;
        if (i == 0) {
            TextView textView = this.f858f;
            MenuItemImpl menuItemImpl2 = this.f853a;
            if (menuItemImpl2.f931n.isQwertyMode()) {
                c2 = menuItemImpl2.f927j;
            } else {
                c2 = menuItemImpl2.f925h;
            }
            if (c2 == 0) {
                sb = "";
            } else {
                MenuBuilder menuBuilder = menuItemImpl2.f931n;
                Resources resources = menuBuilder.getContext().getResources();
                StringBuilder sb2 = new StringBuilder();
                if (ViewConfiguration.get(menuBuilder.getContext()).hasPermanentMenuKey()) {
                    sb2.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                if (menuBuilder.isQwertyMode()) {
                    i2 = menuItemImpl2.f928k;
                } else {
                    i2 = menuItemImpl2.f926i;
                }
                MenuItemImpl.m218a(i2, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label), sb2);
                MenuItemImpl.m218a(i2, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label), sb2);
                MenuItemImpl.m218a(i2, 2, resources.getString(R.string.abc_menu_alt_shortcut_label), sb2);
                MenuItemImpl.m218a(i2, 1, resources.getString(R.string.abc_menu_shift_shortcut_label), sb2);
                MenuItemImpl.m218a(i2, 4, resources.getString(R.string.abc_menu_sym_shortcut_label), sb2);
                MenuItemImpl.m218a(i2, 8, resources.getString(R.string.abc_menu_function_shortcut_label), sb2);
                if (c2 != '\b') {
                    if (c2 != '\n') {
                        if (c2 != ' ') {
                            sb2.append(c2);
                        } else {
                            sb2.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                        }
                    } else {
                        sb2.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                    }
                } else {
                    sb2.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                }
                sb = sb2.toString();
            }
            textView.setText(sb);
        }
        if (this.f858f.getVisibility() != i) {
            this.f858f.setVisibility(i);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f856d.setText(charSequence);
            if (this.f856d.getVisibility() != 0) {
                this.f856d.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f856d.getVisibility() != 8) {
            this.f856d.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return this.f869q;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, R.styleable.MenuView, i, 0);
        this.f862j = obtainStyledAttributes.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.f863k = obtainStyledAttributes.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f865m = obtainStyledAttributes.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.f864l = context;
        this.f866n = obtainStyledAttributes.getDrawable(R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f867o = obtainStyledAttributes2.hasValue(0);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }
}
