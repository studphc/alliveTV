package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import p000.AbstractC1497l3;
import p000.C1151ea;
import p000.C1345j8;
import p000.C1382k8;
import p000.C1503l9;
import p000.C1541ma;

/* loaded from: classes.dex */
public class AppCompatButton extends Button implements TintableBackgroundView, AutoSizeableTextView, TintableCompoundDrawablesView, EmojiCompatConfigurationView {

    /* renamed from: a */
    public final C1345j8 f1113a;

    /* renamed from: b */
    public final C1151ea f1114b;

    /* renamed from: c */
    public C1503l9 f1115c;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1116a = false;

        /* renamed from: b */
        public int f1117b;

        /* renamed from: c */
        public int f1118c;

        /* renamed from: d */
        public int f1119d;

        /* renamed from: e */
        public int f1120e;

        /* renamed from: f */
        public int f1121f;

        /* renamed from: g */
        public int f1122g;

        /* renamed from: h */
        public int f1123h;

        /* renamed from: i */
        public int f1124i;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapInt;
            int mapInt2;
            int mapInt3;
            int mapIntEnum;
            int mapObject;
            int mapObject2;
            int mapObject3;
            int mapObject4;
            mapInt = propertyMapper.mapInt("autoSizeMaxTextSize", R.attr.autoSizeMaxTextSize);
            this.f1117b = mapInt;
            mapInt2 = propertyMapper.mapInt("autoSizeMinTextSize", R.attr.autoSizeMinTextSize);
            this.f1118c = mapInt2;
            mapInt3 = propertyMapper.mapInt("autoSizeStepGranularity", R.attr.autoSizeStepGranularity);
            this.f1119d = mapInt3;
            mapIntEnum = propertyMapper.mapIntEnum("autoSizeTextType", R.attr.autoSizeTextType, new C1382k8(0));
            this.f1120e = mapIntEnum;
            mapObject = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f1121f = mapObject;
            mapObject2 = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f1122g = mapObject2;
            mapObject3 = propertyMapper.mapObject("drawableTint", R.attr.drawableTint);
            this.f1123h = mapObject3;
            mapObject4 = propertyMapper.mapObject("drawableTintMode", R.attr.drawableTintMode);
            this.f1124i = mapObject4;
            this.f1116a = true;
        }

        public void readProperties(@NonNull AppCompatButton appCompatButton, @NonNull PropertyReader propertyReader) {
            if (this.f1116a) {
                propertyReader.readInt(this.f1117b, appCompatButton.getAutoSizeMaxTextSize());
                propertyReader.readInt(this.f1118c, appCompatButton.getAutoSizeMinTextSize());
                propertyReader.readInt(this.f1119d, appCompatButton.getAutoSizeStepGranularity());
                propertyReader.readIntEnum(this.f1120e, appCompatButton.getAutoSizeTextType());
                propertyReader.readObject(this.f1121f, appCompatButton.getBackgroundTintList());
                propertyReader.readObject(this.f1122g, appCompatButton.getBackgroundTintMode());
                propertyReader.readObject(this.f1123h, appCompatButton.getCompoundDrawableTintList());
                propertyReader.readObject(this.f1124i, appCompatButton.getCompoundDrawableTintMode());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    public AppCompatButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private C1503l9 getEmojiTextViewHelper() {
        if (this.f1115c == null) {
            this.f1115c = new C1503l9(this);
        }
        return this.f1115c;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1345j8 c1345j8 = this.f1113a;
        if (c1345j8 != null) {
            c1345j8.m5407a();
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.f1593c) {
            return super.getAutoSizeMaxTextSize();
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            return Math.round(c1151ea.f16735i.f22866e);
        }
        return -1;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.f1593c) {
            return super.getAutoSizeMinTextSize();
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            return Math.round(c1151ea.f16735i.f22865d);
        }
        return -1;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.f1593c) {
            return super.getAutoSizeStepGranularity();
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            return Math.round(c1151ea.f16735i.f22864c);
        }
        return -1;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.f1593c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            return c1151ea.f16735i.f22867f;
        }
        return new int[0];
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (ViewUtils.f1593c) {
            if (super.getAutoSizeTextType() != 1) {
                return 0;
            }
            return 1;
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea == null) {
            return 0;
        }
        return c1151ea.f16735i.f22862a;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C1345j8 c1345j8 = this.f1113a;
        if (c1345j8 != null) {
            return c1345j8.m5408b();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1345j8 c1345j8 = this.f1113a;
        if (c1345j8 != null) {
            return c1345j8.m5409c();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1114b.m4673d();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1114b.m4674e();
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().f22390b.isEnabled();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null && !ViewUtils.f1593c) {
            c1151ea.f16735i.m6116a();
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null && !ViewUtils.f1593c) {
            C1541ma c1541ma = c1151ea.f16735i;
            if (c1541ma.m6118f()) {
                c1541ma.m6116a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().m5897b(z);
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (ViewUtils.f1593c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            c1151ea.m4677h(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) {
        if (ViewUtils.f1593c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            c1151ea.m4678i(iArr, i);
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (ViewUtils.f1593c) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            c1151ea.m4679j(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1345j8 c1345j8 = this.f1113a;
        if (c1345j8 != null) {
            c1345j8.m5411e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C1345j8 c1345j8 = this.f1113a;
        if (c1345j8 != null) {
            c1345j8.m5412f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().m5898c(z);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().f22390b.getFilters(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            c1151ea.f16727a.setAllCaps(z);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C1345j8 c1345j8 = this.f1113a;
        if (c1345j8 != null) {
            c1345j8.m5414h(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C1345j8 c1345j8 = this.f1113a;
        if (c1345j8 != null) {
            c1345j8.m5415i(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C1151ea c1151ea = this.f1114b;
        c1151ea.m4680k(colorStateList);
        c1151ea.m4672b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C1151ea c1151ea = this.f1114b;
        c1151ea.m4681l(mode);
        c1151ea.m4672b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null) {
            c1151ea.m4676g(i, context);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        boolean z = ViewUtils.f1593c;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        C1151ea c1151ea = this.f1114b;
        if (c1151ea != null && !z) {
            C1541ma c1541ma = c1151ea.f16735i;
            if (!c1541ma.m6118f()) {
                c1541ma.m6119g(f, i);
            }
        }
    }

    public AppCompatButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        C1345j8 c1345j8 = new C1345j8(this);
        this.f1113a = c1345j8;
        c1345j8.m5410d(attributeSet, i);
        C1151ea c1151ea = new C1151ea(this);
        this.f1114b = c1151ea;
        c1151ea.m4675f(attributeSet, i);
        c1151ea.m4672b();
        getEmojiTextViewHelper().m5896a(attributeSet, i);
    }
}
