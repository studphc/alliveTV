package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Objects;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.dataflow.qual.Pure;
import p000.C1255h3;

/* loaded from: classes.dex */
public final class Cue implements Bundleable {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = -3.4028235E38f;
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public static final int VERTICAL_TYPE_LR = 2;
    public static final int VERTICAL_TYPE_RL = 1;

    @Nullable
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;

    @Nullable
    public final Layout.Alignment multiRowAlignment;
    public final float position;
    public final int positionAnchor;
    public final float shearDegrees;
    public final float size;

    @Nullable
    public final CharSequence text;

    @Nullable
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final int windowColor;
    public final boolean windowColorSet;
    public static final Cue EMPTY = new Builder().setText("").build();
    public static final Bundleable.Creator<Cue> CREATOR = new C1255h3(11);

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AnchorType {
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public CharSequence f11718a = null;

        /* renamed from: b */
        public Bitmap f11719b = null;

        /* renamed from: c */
        public Layout.Alignment f11720c = null;

        /* renamed from: d */
        public Layout.Alignment f11721d = null;

        /* renamed from: e */
        public float f11722e = -3.4028235E38f;

        /* renamed from: f */
        public int f11723f = Integer.MIN_VALUE;

        /* renamed from: g */
        public int f11724g = Integer.MIN_VALUE;

        /* renamed from: h */
        public float f11725h = -3.4028235E38f;

        /* renamed from: i */
        public int f11726i = Integer.MIN_VALUE;

        /* renamed from: j */
        public int f11727j = Integer.MIN_VALUE;

        /* renamed from: k */
        public float f11728k = -3.4028235E38f;

        /* renamed from: l */
        public float f11729l = -3.4028235E38f;

        /* renamed from: m */
        public float f11730m = -3.4028235E38f;

        /* renamed from: n */
        public boolean f11731n = false;

        /* renamed from: o */
        public int f11732o = ViewCompat.MEASURED_STATE_MASK;

        /* renamed from: p */
        public int f11733p = Integer.MIN_VALUE;

        /* renamed from: q */
        public float f11734q;

        public Cue build() {
            return new Cue(this.f11718a, this.f11720c, this.f11721d, this.f11719b, this.f11722e, this.f11723f, this.f11724g, this.f11725h, this.f11726i, this.f11727j, this.f11728k, this.f11729l, this.f11730m, this.f11731n, this.f11732o, this.f11733p, this.f11734q);
        }

        public Builder clearWindowColor() {
            this.f11731n = false;
            return this;
        }

        @Nullable
        @Pure
        public Bitmap getBitmap() {
            return this.f11719b;
        }

        @Pure
        public float getBitmapHeight() {
            return this.f11730m;
        }

        @Pure
        public float getLine() {
            return this.f11722e;
        }

        @Pure
        public int getLineAnchor() {
            return this.f11724g;
        }

        @Pure
        public int getLineType() {
            return this.f11723f;
        }

        @Pure
        public float getPosition() {
            return this.f11725h;
        }

        @Pure
        public int getPositionAnchor() {
            return this.f11726i;
        }

        @Pure
        public float getSize() {
            return this.f11729l;
        }

        @Nullable
        @Pure
        public CharSequence getText() {
            return this.f11718a;
        }

        @Nullable
        @Pure
        public Layout.Alignment getTextAlignment() {
            return this.f11720c;
        }

        @Pure
        public float getTextSize() {
            return this.f11728k;
        }

        @Pure
        public int getTextSizeType() {
            return this.f11727j;
        }

        @Pure
        public int getVerticalType() {
            return this.f11733p;
        }

        @ColorInt
        @Pure
        public int getWindowColor() {
            return this.f11732o;
        }

        public boolean isWindowColorSet() {
            return this.f11731n;
        }

        public Builder setBitmap(Bitmap bitmap) {
            this.f11719b = bitmap;
            return this;
        }

        public Builder setBitmapHeight(float f) {
            this.f11730m = f;
            return this;
        }

        public Builder setLine(float f, int i) {
            this.f11722e = f;
            this.f11723f = i;
            return this;
        }

        public Builder setLineAnchor(int i) {
            this.f11724g = i;
            return this;
        }

        public Builder setMultiRowAlignment(@Nullable Layout.Alignment alignment) {
            this.f11721d = alignment;
            return this;
        }

        public Builder setPosition(float f) {
            this.f11725h = f;
            return this;
        }

        public Builder setPositionAnchor(int i) {
            this.f11726i = i;
            return this;
        }

        public Builder setShearDegrees(float f) {
            this.f11734q = f;
            return this;
        }

        public Builder setSize(float f) {
            this.f11729l = f;
            return this;
        }

        public Builder setText(CharSequence charSequence) {
            this.f11718a = charSequence;
            return this;
        }

        public Builder setTextAlignment(@Nullable Layout.Alignment alignment) {
            this.f11720c = alignment;
            return this;
        }

        public Builder setTextSize(float f, int i) {
            this.f11728k = f;
            this.f11727j = i;
            return this;
        }

        public Builder setVerticalType(int i) {
            this.f11733p = i;
            return this;
        }

        public Builder setWindowColor(@ColorInt int i) {
            this.f11732o = i;
            this.f11731n = true;
            return this;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface LineType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TextSizeType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface VerticalType {
    }

    @Deprecated
    public Cue(CharSequence charSequence) {
        this(charSequence, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.text.Cue$Builder, java.lang.Object] */
    public Builder buildUpon() {
        ?? obj = new Object();
        obj.f11718a = this.text;
        obj.f11719b = this.bitmap;
        obj.f11720c = this.textAlignment;
        obj.f11721d = this.multiRowAlignment;
        obj.f11722e = this.line;
        obj.f11723f = this.lineType;
        obj.f11724g = this.lineAnchor;
        obj.f11725h = this.position;
        obj.f11726i = this.positionAnchor;
        obj.f11727j = this.textSizeType;
        obj.f11728k = this.textSize;
        obj.f11729l = this.size;
        obj.f11730m = this.bitmapHeight;
        obj.f11731n = this.windowColorSet;
        obj.f11732o = this.windowColor;
        obj.f11733p = this.verticalType;
        obj.f11734q = this.shearDegrees;
        return obj;
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || Cue.class != obj.getClass()) {
            return false;
        }
        Cue cue = (Cue) obj;
        if (TextUtils.equals(this.text, cue.text) && this.textAlignment == cue.textAlignment && this.multiRowAlignment == cue.multiRowAlignment && ((bitmap = this.bitmap) != null ? !((bitmap2 = cue.bitmap) == null || !bitmap.sameAs(bitmap2)) : cue.bitmap == null) && this.line == cue.line && this.lineType == cue.lineType && this.lineAnchor == cue.lineAnchor && this.position == cue.position && this.positionAnchor == cue.positionAnchor && this.size == cue.size && this.bitmapHeight == cue.bitmapHeight && this.windowColorSet == cue.windowColorSet && this.windowColor == cue.windowColor && this.textSizeType == cue.textSizeType && this.textSize == cue.textSize && this.verticalType == cue.verticalType && this.shearDegrees == cue.shearDegrees) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.text, this.textAlignment, this.multiRowAlignment, this.bitmap, Float.valueOf(this.line), Integer.valueOf(this.lineType), Integer.valueOf(this.lineAnchor), Float.valueOf(this.position), Integer.valueOf(this.positionAnchor), Float.valueOf(this.size), Float.valueOf(this.bitmapHeight), Boolean.valueOf(this.windowColorSet), Integer.valueOf(this.windowColor), Integer.valueOf(this.textSizeType), Float.valueOf(this.textSize), Integer.valueOf(this.verticalType), Float.valueOf(this.shearDegrees));
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(Integer.toString(0, 36), this.text);
        bundle.putSerializable(Integer.toString(1, 36), this.textAlignment);
        bundle.putSerializable(Integer.toString(2, 36), this.multiRowAlignment);
        bundle.putParcelable(Integer.toString(3, 36), this.bitmap);
        bundle.putFloat(Integer.toString(4, 36), this.line);
        bundle.putInt(Integer.toString(5, 36), this.lineType);
        bundle.putInt(Integer.toString(6, 36), this.lineAnchor);
        bundle.putFloat(Integer.toString(7, 36), this.position);
        bundle.putInt(Integer.toString(8, 36), this.positionAnchor);
        bundle.putInt(Integer.toString(9, 36), this.textSizeType);
        bundle.putFloat(Integer.toString(10, 36), this.textSize);
        bundle.putFloat(Integer.toString(11, 36), this.size);
        bundle.putFloat(Integer.toString(12, 36), this.bitmapHeight);
        bundle.putBoolean(Integer.toString(14, 36), this.windowColorSet);
        bundle.putInt(Integer.toString(13, 36), this.windowColor);
        bundle.putInt(Integer.toString(15, 36), this.verticalType);
        bundle.putFloat(Integer.toString(16, 36), this.shearDegrees);
        return bundle;
    }

    @Deprecated
    public Cue(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, ViewCompat.MEASURED_STATE_MASK);
    }

    @Deprecated
    public Cue(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, null, null, f, i, i2, f2, i3, i4, f4, f3, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, RecyclerView.f7068F0);
    }

    @Deprecated
    public Cue(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, null, f, i, i2, f2, i3, Integer.MIN_VALUE, -3.4028235E38f, f3, -3.4028235E38f, z, i4, Integer.MIN_VALUE, RecyclerView.f7068F0);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, float f6) {
        if (charSequence == null) {
            Assertions.checkNotNull(bitmap);
        } else {
            Assertions.checkArgument(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.text = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.text = charSequence.toString();
        } else {
            this.text = null;
        }
        this.textAlignment = alignment;
        this.multiRowAlignment = alignment2;
        this.bitmap = bitmap;
        this.line = f;
        this.lineType = i;
        this.lineAnchor = i2;
        this.position = f2;
        this.positionAnchor = i3;
        this.size = f4;
        this.bitmapHeight = f5;
        this.windowColorSet = z;
        this.windowColor = i5;
        this.textSizeType = i4;
        this.textSize = f3;
        this.verticalType = i6;
        this.shearDegrees = f6;
    }
}
