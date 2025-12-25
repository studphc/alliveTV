package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CheckedTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CheckedTextViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCheckedTextView;
import androidx.core.widget.TintableCompoundDrawablesView;
import p000.AbstractC1497l3;
import p000.C1151ea;
import p000.C1345j8;
import p000.C1503l9;
import p000.C1539m8;
import p000.o63;

/* loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView implements TintableCheckedTextView, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* renamed from: a */
    public final C1539m8 f1136a;

    /* renamed from: b */
    public final C1345j8 f1137b;

    /* renamed from: c */
    public final C1151ea f1138c;

    /* renamed from: d */
    public C1503l9 f1139d;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1140a = false;

        /* renamed from: b */
        public int f1141b;

        /* renamed from: c */
        public int f1142c;

        /* renamed from: d */
        public int f1143d;

        /* renamed from: e */
        public int f1144e;

        /* renamed from: f */
        public int f1145f;

        /* renamed from: g */
        public int f1146g;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapObject;
            int mapObject2;
            int mapObject3;
            int mapObject4;
            int mapObject5;
            int mapObject6;
            mapObject = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f1141b = mapObject;
            mapObject2 = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f1142c = mapObject2;
            mapObject3 = propertyMapper.mapObject("checkMarkTint", R.attr.checkMarkTint);
            this.f1143d = mapObject3;
            mapObject4 = propertyMapper.mapObject("checkMarkTintMode", R.attr.checkMarkTintMode);
            this.f1144e = mapObject4;
            mapObject5 = propertyMapper.mapObject("drawableTint", R.attr.drawableTint);
            this.f1145f = mapObject5;
            mapObject6 = propertyMapper.mapObject("drawableTintMode", R.attr.drawableTintMode);
            this.f1146g = mapObject6;
            this.f1140a = true;
        }

        public void readProperties(@NonNull AppCompatCheckedTextView appCompatCheckedTextView, @NonNull PropertyReader propertyReader) {
            if (this.f1140a) {
                propertyReader.readObject(this.f1141b, appCompatCheckedTextView.getBackgroundTintList());
                propertyReader.readObject(this.f1142c, appCompatCheckedTextView.getBackgroundTintMode());
                propertyReader.readObject(this.f1143d, appCompatCheckedTextView.getCheckMarkTintList());
                propertyReader.readObject(this.f1144e, appCompatCheckedTextView.getCheckMarkTintMode());
                propertyReader.readObject(this.f1145f, appCompatCheckedTextView.getCompoundDrawableTintList());
                propertyReader.readObject(this.f1146g, appCompatCheckedTextView.getCompoundDrawableTintMode());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    public AppCompatCheckedTextView(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private C1503l9 getEmojiTextViewHelper() {
        if (this.f1139d == null) {
            this.f1139d = new C1503l9(this);
        }
        return this.f1139d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1151ea c1151ea = this.f1138c;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
        C1345j8 c1345j8 = this.f1137b;
        if (c1345j8 != null) {
            c1345j8.m5407a();
        }
        C1539m8 c1539m8 = this.f1136a;
        if (c1539m8 != null) {
            c1539m8.m6090a();
        }
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
        C1345j8 c1345j8 = this.f1137b;
        if (c1345j8 != null) {
            return c1345j8.m5408b();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1345j8 c1345j8 = this.f1137b;
        if (c1345j8 != null) {
            return c1345j8.m5409c();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCheckMarkTintList() {
        C1539m8 c1539m8 = this.f1136a;
        if (c1539m8 != null) {
            return c1539m8.f22840b;
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C1539m8 c1539m8 = this.f1136a;
        if (c1539m8 != null) {
            return c1539m8.f22841c;
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1138c.m4673d();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1138c.m4674e();
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().f22390b.isEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        o63.m6478x(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().m5897b(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1345j8 c1345j8 = this.f1137b;
        if (c1345j8 != null) {
            c1345j8.m5411e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C1345j8 c1345j8 = this.f1137b;
        if (c1345j8 != null) {
            c1345j8.m5412f(i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@Nullable Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C1539m8 c1539m8 = this.f1136a;
        if (c1539m8 != null) {
            if (c1539m8.f22844f) {
                c1539m8.f22844f = false;
            } else {
                c1539m8.f22844f = true;
                c1539m8.m6090a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1138c;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1138c;
        if (c1151ea != null) {
            c1151ea.m4672b();
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

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C1345j8 c1345j8 = this.f1137b;
        if (c1345j8 != null) {
            c1345j8.m5414h(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C1345j8 c1345j8 = this.f1137b;
        if (c1345j8 != null) {
            c1345j8.m5415i(mode);
        }
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintList(@Nullable ColorStateList colorStateList) {
        C1539m8 c1539m8 = this.f1136a;
        if (c1539m8 != null) {
            c1539m8.f22840b = colorStateList;
            c1539m8.f22842d = true;
            c1539m8.m6090a();
        }
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode mode) {
        C1539m8 c1539m8 = this.f1136a;
        if (c1539m8 != null) {
            c1539m8.f22841c = mode;
            c1539m8.f22843e = true;
            c1539m8.m6090a();
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C1151ea c1151ea = this.f1138c;
        c1151ea.m4680k(colorStateList);
        c1151ea.m4672b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C1151ea c1151ea = this.f1138c;
        c1151ea.m4681l(mode);
        c1151ea.m4672b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i) {
        super.setTextAppearance(context, i);
        C1151ea c1151ea = this.f1138c;
        if (c1151ea != null) {
            c1151ea.m4676g(i, context);
        }
    }

    public AppCompatCheckedTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0083 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:3:0x0046, B:5:0x004e, B:8:0x0054, B:9:0x007b, B:11:0x0083, B:12:0x008a, B:14:0x0092, B:21:0x0062, B:23:0x006a, B:25:0x0070), top: B:2:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0092 A[Catch: all -> 0x0060, TRY_LEAVE, TryCatch #0 {all -> 0x0060, blocks: (B:3:0x0046, B:5:0x004e, B:8:0x0054, B:9:0x007b, B:11:0x0083, B:12:0x008a, B:14:0x0092, B:21:0x0062, B:23:0x006a, B:25:0x0070), top: B:2:0x0046 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatCheckedTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        int resourceId;
        int i2;
        int i3;
        int resourceId2;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        C1151ea c1151ea = new C1151ea(this);
        this.f1138c = c1151ea;
        c1151ea.m4675f(attributeSet, i);
        c1151ea.m4672b();
        C1345j8 c1345j8 = new C1345j8(this);
        this.f1137b = c1345j8;
        c1345j8.m5410d(attributeSet, i);
        this.f1136a = new C1539m8(this);
        Context context2 = getContext();
        int[] iArr = R.styleable.CheckedTextView;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            int i4 = R.styleable.CheckedTextView_checkMarkCompat;
            if (obtainStyledAttributes.hasValue(i4) && (resourceId2 = obtainStyledAttributes.getResourceId(i4, 0)) != 0) {
                try {
                    setCheckMarkDrawable(AppCompatResources.getDrawable(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                }
                i2 = R.styleable.CheckedTextView_checkMarkTint;
                if (obtainStyledAttributes.hasValue(i2)) {
                    CheckedTextViewCompat.setCheckMarkTintList(this, obtainStyledAttributes.getColorStateList(i2));
                }
                i3 = R.styleable.CheckedTextView_checkMarkTintMode;
                if (obtainStyledAttributes.hasValue(i3)) {
                    CheckedTextViewCompat.setCheckMarkTintMode(this, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i3, -1), null));
                }
                obtainStyledAttributes.recycle();
                getEmojiTextViewHelper().m5896a(attributeSet, i);
            }
            int i5 = R.styleable.CheckedTextView_android_checkMark;
            if (obtainStyledAttributes.hasValue(i5) && (resourceId = obtainStyledAttributes.getResourceId(i5, 0)) != 0) {
                setCheckMarkDrawable(AppCompatResources.getDrawable(getContext(), resourceId));
            }
            i2 = R.styleable.CheckedTextView_checkMarkTint;
            if (obtainStyledAttributes.hasValue(i2)) {
            }
            i3 = R.styleable.CheckedTextView_checkMarkTintMode;
            if (obtainStyledAttributes.hasValue(i3)) {
            }
            obtainStyledAttributes.recycle();
            getEmojiTextViewHelper().m5896a(attributeSet, i);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@DrawableRes int i) {
        setCheckMarkDrawable(AppCompatResources.getDrawable(getContext(), i));
    }
}
