package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.ToggleButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundDrawablesView;
import p000.AbstractC1497l3;
import p000.C1151ea;
import p000.C1345j8;
import p000.C1503l9;

/* loaded from: classes.dex */
public class AppCompatToggleButton extends ToggleButton implements TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* renamed from: a */
    public final C1345j8 f1231a;

    /* renamed from: b */
    public final C1151ea f1232b;

    /* renamed from: c */
    public C1503l9 f1233c;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1234a = false;

        /* renamed from: b */
        public int f1235b;

        /* renamed from: c */
        public int f1236c;

        /* renamed from: d */
        public int f1237d;

        /* renamed from: e */
        public int f1238e;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapObject;
            int mapObject2;
            int mapObject3;
            int mapObject4;
            mapObject = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f1235b = mapObject;
            mapObject2 = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f1236c = mapObject2;
            mapObject3 = propertyMapper.mapObject("drawableTint", R.attr.drawableTint);
            this.f1237d = mapObject3;
            mapObject4 = propertyMapper.mapObject("drawableTintMode", R.attr.drawableTintMode);
            this.f1238e = mapObject4;
            this.f1234a = true;
        }

        public void readProperties(@NonNull AppCompatToggleButton appCompatToggleButton, @NonNull PropertyReader propertyReader) {
            if (this.f1234a) {
                propertyReader.readObject(this.f1235b, appCompatToggleButton.getBackgroundTintList());
                propertyReader.readObject(this.f1236c, appCompatToggleButton.getBackgroundTintMode());
                propertyReader.readObject(this.f1237d, appCompatToggleButton.getCompoundDrawableTintList());
                propertyReader.readObject(this.f1238e, appCompatToggleButton.getCompoundDrawableTintMode());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    public AppCompatToggleButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private C1503l9 getEmojiTextViewHelper() {
        if (this.f1233c == null) {
            this.f1233c = new C1503l9(this);
        }
        return this.f1233c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1345j8 c1345j8 = this.f1231a;
        if (c1345j8 != null) {
            c1345j8.m5407a();
        }
        C1151ea c1151ea = this.f1232b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C1345j8 c1345j8 = this.f1231a;
        if (c1345j8 != null) {
            return c1345j8.m5408b();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1345j8 c1345j8 = this.f1231a;
        if (c1345j8 != null) {
            return c1345j8.m5409c();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1232b.m4673d();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1232b.m4674e();
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

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1345j8 c1345j8 = this.f1231a;
        if (c1345j8 != null) {
            c1345j8.m5411e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C1345j8 c1345j8 = this.f1231a;
        if (c1345j8 != null) {
            c1345j8.m5412f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1232b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1232b;
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
        C1345j8 c1345j8 = this.f1231a;
        if (c1345j8 != null) {
            c1345j8.m5414h(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C1345j8 c1345j8 = this.f1231a;
        if (c1345j8 != null) {
            c1345j8.m5415i(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C1151ea c1151ea = this.f1232b;
        c1151ea.m4680k(colorStateList);
        c1151ea.m4672b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C1151ea c1151ea = this.f1232b;
        c1151ea.m4681l(mode);
        c1151ea.m4672b();
    }

    public AppCompatToggleButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.buttonStyleToggle);
    }

    public AppCompatToggleButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        C1345j8 c1345j8 = new C1345j8(this);
        this.f1231a = c1345j8;
        c1345j8.m5410d(attributeSet, i);
        C1151ea c1151ea = new C1151ea(this);
        this.f1232b = c1151ea;
        c1151ea.m4675f(attributeSet, i);
        getEmojiTextViewHelper().m5896a(attributeSet, i);
    }
}
