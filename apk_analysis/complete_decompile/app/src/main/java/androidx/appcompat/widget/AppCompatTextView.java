package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p000.AbstractC1497l3;
import p000.AbstractC1975x9;
import p000.C1151ea;
import p000.C1225ga;
import p000.C1262ha;
import p000.C1345j8;
import p000.C1382k8;
import p000.C1503l9;
import p000.C1540m9;
import p000.C1541ma;
import p000.InterfaceC1188fa;
import p000.b01;
import p000.o63;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView, EmojiCompatConfigurationView {

    /* renamed from: a */
    public final C1345j8 f1215a;

    /* renamed from: b */
    public final C1151ea f1216b;

    /* renamed from: c */
    public final C1540m9 f1217c;

    /* renamed from: d */
    public C1503l9 f1218d;

    /* renamed from: e */
    public boolean f1219e;

    /* renamed from: f */
    public b01 f1220f;

    /* renamed from: g */
    public Future f1221g;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1222a = false;

        /* renamed from: b */
        public int f1223b;

        /* renamed from: c */
        public int f1224c;

        /* renamed from: d */
        public int f1225d;

        /* renamed from: e */
        public int f1226e;

        /* renamed from: f */
        public int f1227f;

        /* renamed from: g */
        public int f1228g;

        /* renamed from: h */
        public int f1229h;

        /* renamed from: i */
        public int f1230i;

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
            this.f1223b = mapInt;
            mapInt2 = propertyMapper.mapInt("autoSizeMinTextSize", R.attr.autoSizeMinTextSize);
            this.f1224c = mapInt2;
            mapInt3 = propertyMapper.mapInt("autoSizeStepGranularity", R.attr.autoSizeStepGranularity);
            this.f1225d = mapInt3;
            mapIntEnum = propertyMapper.mapIntEnum("autoSizeTextType", R.attr.autoSizeTextType, new C1382k8(1));
            this.f1226e = mapIntEnum;
            mapObject = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f1227f = mapObject;
            mapObject2 = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f1228g = mapObject2;
            mapObject3 = propertyMapper.mapObject("drawableTint", R.attr.drawableTint);
            this.f1229h = mapObject3;
            mapObject4 = propertyMapper.mapObject("drawableTintMode", R.attr.drawableTintMode);
            this.f1230i = mapObject4;
            this.f1222a = true;
        }

        public void readProperties(@NonNull AppCompatTextView appCompatTextView, @NonNull PropertyReader propertyReader) {
            if (this.f1222a) {
                propertyReader.readInt(this.f1223b, appCompatTextView.getAutoSizeMaxTextSize());
                propertyReader.readInt(this.f1224c, appCompatTextView.getAutoSizeMinTextSize());
                propertyReader.readInt(this.f1225d, appCompatTextView.getAutoSizeStepGranularity());
                propertyReader.readIntEnum(this.f1226e, appCompatTextView.getAutoSizeTextType());
                propertyReader.readObject(this.f1227f, appCompatTextView.getBackgroundTintList());
                propertyReader.readObject(this.f1228g, appCompatTextView.getBackgroundTintMode());
                propertyReader.readObject(this.f1229h, appCompatTextView.getCompoundDrawableTintList());
                propertyReader.readObject(this.f1230i, appCompatTextView.getCompoundDrawableTintMode());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    public AppCompatTextView(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private C1503l9 getEmojiTextViewHelper() {
        if (this.f1218d == null) {
            this.f1218d = new C1503l9(this);
        }
        return this.f1218d;
    }

    /* renamed from: d */
    public final void m246d() {
        Future future = this.f1221g;
        if (future != null) {
            try {
                this.f1221g = null;
                TextViewCompat.setPrecomputedText(this, (PrecomputedTextCompat) future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1345j8 c1345j8 = this.f1215a;
        if (c1345j8 != null) {
            c1345j8.m5407a();
        }
        C1151ea c1151ea = this.f1216b;
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
        C1151ea c1151ea = this.f1216b;
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
        C1151ea c1151ea = this.f1216b;
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
        C1151ea c1151ea = this.f1216b;
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
        C1151ea c1151ea = this.f1216b;
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
        C1151ea c1151ea = this.f1216b;
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

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
    }

    @RequiresApi(api = 26)
    @UiThread
    public InterfaceC1188fa getSuperCaller() {
        if (this.f1220f == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.f1220f = new C1262ha(this);
            } else if (i >= 28) {
                this.f1220f = new C1225ga(this);
            } else if (i >= 26) {
                this.f1220f = new b01(4, this);
            }
        }
        return this.f1220f;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C1345j8 c1345j8 = this.f1215a;
        if (c1345j8 != null) {
            return c1345j8.m5408b();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1345j8 c1345j8 = this.f1215a;
        if (c1345j8 != null) {
            return c1345j8.m5409c();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1216b.m4673d();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1216b.m4674e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        m246d();
        return super.getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        C1540m9 c1540m9;
        if (Build.VERSION.SDK_INT < 28 && (c1540m9 = this.f1217c) != null) {
            TextClassifier textClassifier = (TextClassifier) c1540m9.f22855c;
            if (textClassifier == null) {
                return AbstractC1975x9.m8150a((TextView) c1540m9.f22854b);
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    @NonNull
    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().f22390b.isEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1216b.getClass();
        if (Build.VERSION.SDK_INT < 30 && onCreateInputConnection != null) {
            EditorInfoCompat.setInitialSurroundingText(editorInfo, getText());
        }
        o63.m6478x(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 && i < 33 && onCheckIsTextEditor()) {
            ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C1151ea c1151ea = this.f1216b;
        if (c1151ea != null && !ViewUtils.f1593c) {
            c1151ea.f16735i.m6116a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        m246d();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        C1151ea c1151ea = this.f1216b;
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
        C1151ea c1151ea = this.f1216b;
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
        C1151ea c1151ea = this.f1216b;
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
        C1151ea c1151ea = this.f1216b;
        if (c1151ea != null) {
            c1151ea.m4679j(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1345j8 c1345j8 = this.f1215a;
        if (c1345j8 != null) {
            c1345j8.m5411e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C1345j8 c1345j8 = this.f1215a;
        if (c1345j8 != null) {
            c1345j8.m5412f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1216b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1216b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1216b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1216b;
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

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().f22390b.getFilters(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().mo1994k(i);
        } else {
            TextViewCompat.setFirstBaselineToTopHeight(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().mo1990g(i);
        } else {
            TextViewCompat.setLastBaselineToBottomHeight(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange(from = 0) @Px int i) {
        TextViewCompat.setLineHeight(this, i);
    }

    public void setPrecomputedText(@NonNull PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.setPrecomputedText(this, precomputedTextCompat);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C1345j8 c1345j8 = this.f1215a;
        if (c1345j8 != null) {
            c1345j8.m5414h(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C1345j8 c1345j8 = this.f1215a;
        if (c1345j8 != null) {
            c1345j8.m5415i(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C1151ea c1151ea = this.f1216b;
        c1151ea.m4680k(colorStateList);
        c1151ea.m4672b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C1151ea c1151ea = this.f1216b;
        c1151ea.m4681l(mode);
        c1151ea.m4672b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C1151ea c1151ea = this.f1216b;
        if (c1151ea != null) {
            c1151ea.m4676g(i, context);
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        C1540m9 c1540m9;
        if (Build.VERSION.SDK_INT < 28 && (c1540m9 = this.f1217c) != null) {
            c1540m9.f22855c = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(@Nullable Future<PrecomputedTextCompat> future) {
        this.f1221g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params params) {
        TextViewCompat.setTextMetricsParams(this, params);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        boolean z = ViewUtils.f1593c;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        C1151ea c1151ea = this.f1216b;
        if (c1151ea != null && !z) {
            C1541ma c1541ma = c1151ea.f16735i;
            if (!c1541ma.m6118f()) {
                c1541ma.m6119g(f, i);
            }
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface typeface, int i) {
        Typeface typeface2;
        if (this.f1219e) {
            return;
        }
        if (typeface != null && i > 0) {
            typeface2 = TypefaceCompat.create(getContext(), typeface, i);
        } else {
            typeface2 = null;
        }
        this.f1219e = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f1219e = false;
        }
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i, @FloatRange(from = 0.0d) float f) {
        if (Build.VERSION.SDK_INT >= 34) {
            getSuperCaller().mo1996m(i, f);
        } else {
            TextViewCompat.setLineHeight(this, i, f);
        }
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.f1219e = false;
        this.f1220f = null;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        C1345j8 c1345j8 = new C1345j8(this);
        this.f1215a = c1345j8;
        c1345j8.m5410d(attributeSet, i);
        C1151ea c1151ea = new C1151ea(this);
        this.f1216b = c1151ea;
        c1151ea.m4675f(attributeSet, i);
        c1151ea.m4672b();
        this.f1217c = new C1540m9(this);
        getEmojiTextViewHelper().m5896a(attributeSet, i);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? AppCompatResources.getDrawable(context, i) : null, i2 != 0 ? AppCompatResources.getDrawable(context, i2) : null, i3 != 0 ? AppCompatResources.getDrawable(context, i3) : null, i4 != 0 ? AppCompatResources.getDrawable(context, i4) : null);
        C1151ea c1151ea = this.f1216b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? AppCompatResources.getDrawable(context, i) : null, i2 != 0 ? AppCompatResources.getDrawable(context, i2) : null, i3 != 0 ? AppCompatResources.getDrawable(context, i3) : null, i4 != 0 ? AppCompatResources.getDrawable(context, i4) : null);
        C1151ea c1151ea = this.f1216b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }
}
