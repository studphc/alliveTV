package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.RadioButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;
import androidx.core.widget.TintableCompoundDrawablesView;
import p000.AbstractC1497l3;
import p000.C1151ea;
import p000.C1345j8;
import p000.C1503l9;
import p000.C1576n8;

/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* renamed from: a */
    public final C1576n8 f1189a;

    /* renamed from: b */
    public final C1345j8 f1190b;

    /* renamed from: c */
    public final C1151ea f1191c;

    /* renamed from: d */
    public C1503l9 f1192d;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1193a = false;

        /* renamed from: b */
        public int f1194b;

        /* renamed from: c */
        public int f1195c;

        /* renamed from: d */
        public int f1196d;

        /* renamed from: e */
        public int f1197e;

        /* renamed from: f */
        public int f1198f;

        /* renamed from: g */
        public int f1199g;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapObject;
            int mapObject2;
            int mapObject3;
            int mapObject4;
            int mapObject5;
            int mapObject6;
            mapObject = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f1194b = mapObject;
            mapObject2 = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f1195c = mapObject2;
            mapObject3 = propertyMapper.mapObject("buttonTint", R.attr.buttonTint);
            this.f1196d = mapObject3;
            mapObject4 = propertyMapper.mapObject("buttonTintMode", R.attr.buttonTintMode);
            this.f1197e = mapObject4;
            mapObject5 = propertyMapper.mapObject("drawableTint", R.attr.drawableTint);
            this.f1198f = mapObject5;
            mapObject6 = propertyMapper.mapObject("drawableTintMode", R.attr.drawableTintMode);
            this.f1199g = mapObject6;
            this.f1193a = true;
        }

        public void readProperties(@NonNull AppCompatRadioButton appCompatRadioButton, @NonNull PropertyReader propertyReader) {
            if (this.f1193a) {
                propertyReader.readObject(this.f1194b, appCompatRadioButton.getBackgroundTintList());
                propertyReader.readObject(this.f1195c, appCompatRadioButton.getBackgroundTintMode());
                propertyReader.readObject(this.f1196d, appCompatRadioButton.getButtonTintList());
                propertyReader.readObject(this.f1197e, appCompatRadioButton.getButtonTintMode());
                propertyReader.readObject(this.f1198f, appCompatRadioButton.getCompoundDrawableTintList());
                propertyReader.readObject(this.f1199g, appCompatRadioButton.getCompoundDrawableTintMode());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    @NonNull
    private C1503l9 getEmojiTextViewHelper() {
        if (this.f1192d == null) {
            this.f1192d = new C1503l9(this);
        }
        return this.f1192d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1345j8 c1345j8 = this.f1190b;
        if (c1345j8 != null) {
            c1345j8.m5407a();
        }
        C1151ea c1151ea = this.f1191c;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C1345j8 c1345j8 = this.f1190b;
        if (c1345j8 != null) {
            return c1345j8.m5408b();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1345j8 c1345j8 = this.f1190b;
        if (c1345j8 != null) {
            return c1345j8.m5409c();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportButtonTintList() {
        C1576n8 c1576n8 = this.f1189a;
        if (c1576n8 != null) {
            return c1576n8.f23273b;
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportButtonTintMode() {
        C1576n8 c1576n8 = this.f1189a;
        if (c1576n8 != null) {
            return c1576n8.f23274c;
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1191c.m4673d();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1191c.m4674e();
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().f22390b.isEnabled();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().m5897b(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1345j8 c1345j8 = this.f1190b;
        if (c1345j8 != null) {
            c1345j8.m5411e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C1345j8 c1345j8 = this.f1190b;
        if (c1345j8 != null) {
            c1345j8.m5412f(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C1576n8 c1576n8 = this.f1189a;
        if (c1576n8 != null) {
            if (c1576n8.f23277f) {
                c1576n8.f23277f = false;
            } else {
                c1576n8.f23277f = true;
                c1576n8.m6317a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1191c;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1191c;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().m5898c(z);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().f22390b.getFilters(inputFilterArr));
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C1345j8 c1345j8 = this.f1190b;
        if (c1345j8 != null) {
            c1345j8.m5414h(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C1345j8 c1345j8 = this.f1190b;
        if (c1345j8 != null) {
            c1345j8.m5415i(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        C1576n8 c1576n8 = this.f1189a;
        if (c1576n8 != null) {
            c1576n8.f23273b = colorStateList;
            c1576n8.f23275d = true;
            c1576n8.m6317a();
        }
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        C1576n8 c1576n8 = this.f1189a;
        if (c1576n8 != null) {
            c1576n8.f23274c = mode;
            c1576n8.f23276e = true;
            c1576n8.m6317a();
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C1151ea c1151ea = this.f1191c;
        c1151ea.m4680k(colorStateList);
        c1151ea.m4672b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C1151ea c1151ea = this.f1191c;
        c1151ea.m4681l(mode);
        c1151ea.m4672b();
    }

    public AppCompatRadioButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        C1576n8 c1576n8 = new C1576n8(this);
        this.f1189a = c1576n8;
        c1576n8.m6318b(attributeSet, i);
        C1345j8 c1345j8 = new C1345j8(this);
        this.f1190b = c1345j8;
        c1345j8.m5410d(attributeSet, i);
        C1151ea c1151ea = new C1151ea(this);
        this.f1191c = c1151ea;
        c1151ea.m4675f(attributeSet, i);
        getEmojiTextViewHelper().m5896a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), i));
    }
}
